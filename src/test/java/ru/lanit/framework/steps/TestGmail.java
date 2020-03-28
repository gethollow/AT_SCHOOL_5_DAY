package ru.lanit.framework.steps;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.lanit.framework.webdriver.WebDriverManager;

import java.util.List;

public class TestGmail extends BasePageSteps {
    private WebDriver webDriver = WebDriverManager.getDriver();

    private String url= "https://dev.n7lanit.ru/";

    @Test
    public void testGmail() throws InterruptedException {

        webDriver.get(url);
        Thread.sleep(1000);


        webDriver.findElement(By.linkText("Категории")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.linkText("Пользователи")).click();
        Thread.sleep(1000);

        webDriver.navigate().back();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Категории")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"user-menu-mount\"]//a/i")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"user-menu-mount\"]//input")).sendKeys("E");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"user-menu-mount\"]//li[8]/a")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.linkText("Eduard")).click();
        Thread.sleep(2000);


        autorization("edde.93@mail.ru","19041993A");
        Thread.sleep(2000);
        autorization("","");
        Thread.sleep(2000);
        autorization("edde.93@mail.ru","19041993AS");
        Thread.sleep(2000);
        autorization("","19041993A");
        Thread.sleep(2000);

        System.out.println("Браузер открыт " + ((ChromeDriver) webDriver).getSessionId());

        WebDriverManager.quit();

    }

    private void autorization(String username,String password) throws InterruptedException {
        webDriver.findElement(By.xpath("//*[@id=\"user-menu-mount\"]/div/button[1]")).click();
        Thread.sleep(2000);
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"id_username\"]"));
        webElement.click();
        webElement.sendKeys(username);
        webElement.sendKeys(Keys.TAB);
        webDriver.findElement(By.xpath("//*[@id=\"id_password\"]")).sendKeys(password);
        webElement.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        if (username.equals("edde.93@mail.ru") && (password.equals("19041993A"))) {
            Assert.assertFalse(webDriver.findElement(By.xpath("//*[@id=\"snackbar-mount\"]/div/p")).isDisplayed(), "Заполните оба поля.");
            Assert.assertFalse(webDriver.findElement(By.xpath("//*[@id=\"snackbar-mount\"]/div/p")).isDisplayed(), "Логин или пароль неправильны.");
            webDriver.findElement(By.xpath("//a/img[@class=\"user-avatar\"]")).click();
            Thread.sleep(2000);
            webDriver.findElement(By.xpath("//button[text()=\"Выход\"]")).click();
            Thread.sleep(2000);
            webDriver.switchTo().alert().accept();
            Thread.sleep(2000);

        } else if (username.equals("") || (password.equals(""))) {
            Assert.assertEquals(webDriver.findElement(By.xpath("//*[@id=\"snackbar-mount\"]/div/p[text()=\"Заполните оба поля.\"]")).isDisplayed(), true);

            webDriver.findElement(By.xpath("//*[@id=\"modal-mount\"]/div/div/div/button")).click();
            Thread.sleep(2000);

        } else {
            Assert.assertEquals(webDriver.findElement(By.xpath("//*[@id=\"snackbar-mount\"]/div/p[text()=\"Логин или пароль неправильны.\"]")).isDisplayed(), true);

            webDriver.findElement(By.xpath("//*[@id=\"modal-mount\"]/div/div/div/button")).click();
            Thread.sleep(2000);
        }

    }

}

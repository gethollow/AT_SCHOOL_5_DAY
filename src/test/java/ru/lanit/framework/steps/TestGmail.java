package ru.lanit.framework.steps;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.lanit.framework.webdriver.WebDriverManager;

import java.util.List;

public class TestGmail {

    @Test
    public void testGoogle() throws InterruptedException {
        WebDriver webDriver = WebDriverManager.getDriver();
        webDriver.get("http://google.com");
        Thread.sleep(1000);
        WebElement webElement = webDriver.findElement(By.name("q"));
        List<WebElement> webElements = webDriver.findElements(By.xpath("//div"));
        webElement.click();
        Thread.sleep(1000);
        webElement.sendKeys("Hello World!");
        Thread.sleep(1000);
        webElement.sendKeys(Keys.ENTER);
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id='result-stats']")).isDisplayed(), "Элемент \"Результатов: примерно...\"");
        Thread.sleep(1000);
        System.out.println("Открыт браузер " + ((ChromeDriver) webDriver).getSessionId());
        webDriver.quit();

    }
}
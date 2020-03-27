package ru.lanit.framework.steps;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import ru.lanit.framework.webdriver.WebDriverManager;

public class TestGmail extends BasePageSteps {
    //private RemoteWebDriver driver;
    private WebDriver webDriver;
    private WebElement webElement;
    private String url= "https://dev.n7lanit.ru/";

    @Test
    public void testGmail() throws InterruptedException, MalformedURLException {
        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("browserName", "Chrome");
        //caps.setCapability("screenResolution", "1366x768");
        //String hubAddress = String.format("http://google.com");
        //URL url = new URL(hubAddress);
        //driver = new RemoteWebDriver(url, caps);

        webDriver = WebDriverManager.getDriver();

        webDriver.get(url);
        Thread.sleep(10000);

        //webDriver.findElement(By.linkText("Категории")).click();
        //Thread.sleep(3000);
        //webDriver.findElement(By.linkText("Пользователи")).click();
        //Thread.sleep(3000);
        //webDriver.navigate().back();
        //webDriver.findElement(By.linkText("Категории")).click();
        //webDriver.findElement(By.cssSelector("//*[@text()='search'])")).click();

        //webDriver.findElement(By.name("w"));
        //Thread.sleep(4000);
        //webElement.sendKeys("Hello world!");
        //Thread.sleep(1000);
        //webElement.sendKeys(Keys.ENTER);
        //Thread.sleep(1000);
        System.out.println("Браузер открыт " + ((ChromeDriver) webDriver).getSessionId());
        //webDriver.close();
        WebDriverManager.quit();

    }
}

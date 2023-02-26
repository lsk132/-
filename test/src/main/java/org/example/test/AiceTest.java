package org.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AiceTest {


    private WebDriver webDriver;

    @BeforeClass
    public void driver() {

        Path p1 = Paths.get("src","driver","geckodriver.exe");
        System.setProperty("webdriver.gecko.driver",p1.toAbsolutePath().toString());

    }

    @Test
    public void openBaidu(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.baidu.com");
        webDriver.findElement(By.id("kw")).sendKeys("马士兵教育官网");
        webDriver.findElement(By.id("su")).click();
        System.out.println("第一次更新");
        System.out.println("第二次更新");
        System.out.println("创建分支");



    }
    
    @Test
    public void shubiao() throws InterruptedException {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.baidu.com");
        Actions action = new Actions(webDriver);
        WebElement data = webDriver.findElement(By.linkText("更多"));
        action.moveToElement(data);
        WebElement data2 = webDriver.findElement(By.xpath("//a[@name='tj_mp3']"));
        action.moveToElement(data2).click().perform();



    }

    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.quit();
    }
}

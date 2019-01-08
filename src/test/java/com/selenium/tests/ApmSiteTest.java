package com.selenium.tests;

import com.selenium.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;
import java.awt.*;

public class ApmSiteTest extends DriverBase {

    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;

    //Declare a test URL variable
    public String testURL = "https://www.perfline25.com";
    public String loginSuccessURL = "https://www.perfline25.com/views/secure/home.xhtml1";
    public String logoutSuccessURL = "https://www.perfline25.com/views/login.xhtml";

    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() throws Exception {
        //Create a new ChromeDriver
        driver = getDriver();
        //To maximize a browser window
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenResolution = new Dimension((int)
                toolkit.getScreenSize().getWidth(), (int)
                toolkit.getScreenSize().getHeight());

        driver.manage().window().setSize(screenResolution);
        //Go to test URL
        driver.navigate().to(testURL);
    }

    //-----------------------------------Tests-----------------------------------
    @Test(priority = 1)
    public void checkTitle() throws Exception {
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("APM Application", driver.getTitle());
    }

    @Test(priority = 2)
    public void loginLogoutTest() throws Exception {
        //click login
        driver.findElement(By.xpath("//*[@id=\"top-menu\"]/form/li/a")).click();
        driver.findElement(By.xpath("//*[@id=\"loginForm:login-email-text\"]")).sendKeys("test@user.com");
        driver.findElement(By.xpath("//*[@id=\"loginForm:login-password-text\"]")).sendKeys("12345678");
        WebElement subElement = driver.findElement(By.tagName("button"));
        subElement.click();
        Assert.assertEquals(loginSuccessURL, driver.getCurrentUrl());

        //click logout
        driver.findElement(By.xpath("//*[@id=\"top-menu\"]/form/li[4]/a")).click();
        Assert.assertEquals(logoutSuccessURL, driver.getCurrentUrl());
    }
}
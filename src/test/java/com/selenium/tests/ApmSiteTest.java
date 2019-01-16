package com.selenium.tests;

import com.selenium.DriverBase;
import com.selenium.page_objects.ApmHomePage;
import com.selenium.page_objects.LoginPage;
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
    public String testURL = "http://localhost:8081";
    public String username = "test@user.com";
    public String password = "12345678";

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
        ApmHomePage apmHomePage = new ApmHomePage();
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(apmHomePage.pageTitle, driver.getTitle());
    }

    @Test(priority = 2)
    public void loginLogoutTest() throws Exception {
        ApmHomePage apmHomePage = new ApmHomePage();
        //click login
        apmHomePage.getLoginPage();
        LoginPage loginPage = new LoginPage();
        //enter username
        loginPage.enterUsername(username);
        //enter password
        loginPage.enterPassword(password);
        //click login button
        loginPage.submitLogin();
        Assert.assertEquals(loginPage.loginSuccessURL, driver.getCurrentUrl());

        //click logout
        loginPage.submitLogout();
        Assert.assertEquals(loginPage.logoutSuccessURL, driver.getCurrentUrl());
    }
}
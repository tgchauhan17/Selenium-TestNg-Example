package com.selenium.page_objects;

import com.selenium.DriverBase;
import com.selenium.util.Query;
import org.openqa.selenium.By;
import static com.selenium.util.AssignDriver.initQueryObjects;

public class LoginPage {

    public static final String loginSuccessURL = "https://www.perfline25.com/views/secure/home.xhtml";
    public static final String logoutSuccessURL = "https://www.perfline25.com/views/login.xhtml";
    private Query usernameInputTxt = new Query().defaultLocator(By.xpath("//*[@id=\"loginForm:login-email-text\"]"));
    private Query passwordInputTxt = new Query().defaultLocator(By.xpath("//*[@id=\"loginForm:login-password-text\"]"));
    private Query loginBtn = new Query().defaultLocator(By.tagName("button"));
    private Query logoutBtn = new Query().defaultLocator(By.xpath("//*[@id=\"top-menu\"]/form/li[4]/a"));

    public LoginPage() throws Exception {
        initQueryObjects(this, DriverBase.getDriver());
    }

    public LoginPage enterUsername(String username) {
        usernameInputTxt.findWebElement().clear();
        usernameInputTxt.findWebElement().sendKeys(username);

        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInputTxt.findWebElement().clear();
        passwordInputTxt.findWebElement().sendKeys(password);

        return this;
    }

    public LoginPage submitLogin() {
        loginBtn.findWebElement().click();
        return this;
    }

    public LoginPage submitLogout() {
        logoutBtn.findWebElement().click();
        return this;
    }
}

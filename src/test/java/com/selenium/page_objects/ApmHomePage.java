package com.selenium.page_objects;


import com.selenium.DriverBase;
import com.selenium.util.Query;
import org.openqa.selenium.By;
import static com.selenium.util.AssignDriver.initQueryObjects;

public class ApmHomePage {

    private Query loginBtn = new Query().defaultLocator(By.xpath("//*[@id=\"top-menu\"]/form/li/a"));
    public static final String pageTitle = "APM Application";

    public ApmHomePage() throws Exception {
        initQueryObjects(this, DriverBase.getDriver());
    }

    public void getLoginPage() {
        loginBtn.findWebElement().click();
    }
}
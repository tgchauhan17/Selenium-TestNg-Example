package com.selenium.listeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebDriverEventListener extends AbstractWebDriverEventListener {
    private final static Logger logger = Logger.getLogger(WebDriverEventListener.class);

    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.debug("Before Navigating To: " + url);
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        logger.debug("After Navigated To:" + url);
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.debug("Trying To Click On: " + element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.debug("Clicked On: " + element.toString());
    }

    public void onException(Throwable error, WebDriver driver) {
        logger.error("Error Occurred: " + error);
    }
}

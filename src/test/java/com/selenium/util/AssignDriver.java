package com.selenium.util;

import com.selenium.listeners.WebDriverEventListener;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.Field;

public class AssignDriver {
    public static void initQueryObjects(Object object, RemoteWebDriver driver, WebDriverEventListener eventListener) {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getType() == Query.class) {
                field.setAccessible(true);
                try {
                    Query queryObject = (Query) field.get(object);
                    if (null != queryObject) {
                        queryObject.usingDriver(driver, eventListener);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

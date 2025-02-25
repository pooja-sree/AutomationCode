package org.Reach.iOS.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;

import java.util.HashMap;
import java.util.Map;

public class AlertHandler {
private static AppiumDriver driver;
    public static void handleAlert(IOSDriver driver, String action) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("action", action);  // "accept" or "dismiss"
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("mobile: alert", params);

            System.out.println("Alert handled: " + action);
        } catch (Exception e) {
            System.out.println("No alert present to handle.");
        }
    }

    public static void acceptAlert() {
        if (driver != null) {
            try {
                driver.switchTo().alert().accept();
                System.out.println("Alert accepted.");
            } catch (NoAlertPresentException e) {
                System.out.println("No alert found.");
            }
        } else {
            System.out.println("Driver is null! Cannot interact with alerts.");
        }
    }

}

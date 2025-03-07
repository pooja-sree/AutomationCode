package org.Reach.iOS.Utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;

public class Base {
    protected static IOSDriver driver;

    public static IOSDriver startDriver() {
        if (driver == null) {
            try {
                System.out.println("🚀 Starting driver...");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("appium:deviceName", "iphone 12");
                capabilities.setCapability("appium:udid", "8F630ACB-6FE4-41B1-BC83-F3CBF4A53EEF");
                capabilities.setCapability("appium:automationName", "XCUITest");
                capabilities.setCapability("appium:bundleId", "com.reach.wfd-app");
                capabilities.setCapability("appium:wdaLocalPort", 8100);
                capabilities.setCapability("appium:noReset", true);
                capabilities.setCapability("appium:autoAcceptAlerts", true);
                capabilities.setCapability("appium:newCommandTimeout", 3600);
                capabilities.setCapability("appium:connectHardwareKeyboard", true);
                capabilities.setCapability("appium:includeSafariInWebviews", true);

                driver = new IOSDriver(new URL("http://127.0.0.1:4723"), capabilities);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            System.out.println("🛑 Quitting driver...");
            driver.quit();
            driver = null;
        }
    }
}

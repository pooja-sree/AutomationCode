package org.Reach.StepDefinitions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDriverManager {

    private static AppiumDriver driver;


    public static synchronized AppiumDriver getDriver(String platform) {
        if (driver == null) { // ✅ Prevent re-initialization
            try {
                if (platform.equalsIgnoreCase("Android")) {
                    UiAutomator2Options options = new UiAutomator2Options();
                    options.setPlatformName("Android");
                    options.setDeviceName("emulator-5554");
                    options.setPlatformVersion("13.0");
                    options.setApp("C:/ReachautomationBuilds/ReachStage-PreAuth.apk");
                    options.setAutomationName("UiAutomator2");
                    options.setCapability("enforceXPath1", true);
                    options.setCapability("disableIdLocatorAutocompletion", true);
                    options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(60));
                    options.setAdbExecTimeout(Duration.ofSeconds(90));
                    options.setNewCommandTimeout(Duration.ofSeconds(300));

                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                    System.out.println("✅ Driver successfully initialized!"+driver);
                }

                else if (platform.equalsIgnoreCase("iOS")) {
                    XCUITestOptions options = new XCUITestOptions();
                    options.setPlatformName("iOS");
                    options.setDeviceName("iPhone 14");
                    options.setPlatformVersion("16.0");
                    options.setApp("C:/ReachautomationBuilds/ReachStage-PreAuth.apk");
                    options.setAutomationName("XCUITest");
                    options.setCapability("useNewWDA", true);
                    options.setCapability("autoAcceptAlerts", true);
                    options.setCapability("wdaLaunchTimeout", 60000);
                    options.setCapability("newCommandTimeout", 300);

                    driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("❌ Failed to initialize Appium driver.",e);
            }
        } else {
            System.out.println("ℹ️ Reusing existing driver instance." + driver);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

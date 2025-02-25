package org.Reach.StepDefinitions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDriverManager {

    private static AppiumDriver driver;


    public static synchronized AppiumDriver getDriver() {
        if (driver == null) { // ✅ Prevent re-initialization
            try {
                    UiAutomator2Options options = new UiAutomator2Options();
                    options.setPlatformName("Android");
                    options.setDeviceName("emulator-5554");
                    options.setPlatformVersion("13.0");
                    options.setApp("/Users/spritle/Automation_Builds/ReachStage-PreAuth.apk");
                    options.setAutomationName("UiAutomator2");
                    options.setCapability("enforceXPath1", true);
                    options.setCapability("disableIdLocatorAutocompletion", true);
                    options.setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(100));
                    options.setAdbExecTimeout(Duration.ofSeconds(90));
                    options.setNewCommandTimeout(Duration.ofSeconds(300));
                    options.setCapability("adbExecTimeout", 300000);  // 5 minutes
                    options.setCapability("androidInstallTimeout", 300000);  // 5 minutes


                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                    System.out.println("✅ Driver successfully initialized!"+driver);


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

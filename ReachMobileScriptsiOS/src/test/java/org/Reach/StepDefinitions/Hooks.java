package org.Reach.StepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.Reach.iOS.Utils.Base;
import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;

public class Hooks {

    private static AppiumDriver driver;

    @Before
    public void setUp() {
        System.out.println("🚀 Hooks: Starting driver before scenario...");
        driver = Base.startDriver();  // Runs before each scenario
    }

    @After
    public void tearDown() {

        System.out.println("🔄 Hooks: Quitting driver after scenario...");
        Base.quitDriver();  // Runs after each scenario
    }

    public static AppiumDriver getDriver() {

        return driver;  // ✅ Provide driver to other classes
    }
}

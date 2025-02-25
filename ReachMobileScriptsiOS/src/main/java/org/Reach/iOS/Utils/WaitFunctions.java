package org.Reach.iOS.Utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitFunctions {

    AppiumDriver driver;
    WebDriverWait wait;

    public WaitFunctions(AppiumDriver driver) {
        System.out.println("🔍 Inside WaitFunctions constructor. Driver: " + driver);
        this.driver = driver;
        if (driver == null) {
            System.out.println("❌ ERROR: Driver is NULL after assignment!");
        } else {
            System.out.println("✅ Driver successfully assigned: " + this.driver);
        }


        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

//    }

    public void clickElement(WebElement element) {

        System.out.println("🖱️ Waiting for element to be clickable: " + element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("✅ Element is clickable, clicking now...");
        element.click();

    }

    public void Visibility(WebElement ele){

        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    public void sendKeys(WebElement element, String keys) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(keys);
    }
}




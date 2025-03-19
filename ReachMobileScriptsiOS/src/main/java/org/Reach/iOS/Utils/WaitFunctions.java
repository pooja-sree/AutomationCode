package org.Reach.iOS.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class WaitFunctions {

    AppiumDriver driver;
    WebDriverWait wait;
    IOSDriver iosDriver;
    Actions actions;

    public WaitFunctions(AppiumDriver driver) {

        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        this.iosDriver = (IOSDriver) driver;
    }


    public void clickElement(WebElement element) {

        Visibility(element);
        System.out.println("🖱️ Waiting for element to be clickable: " + element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("✅ Element is clickable, clicking now...");
        element.click();

    }

    public void Visibility(WebElement ele){

        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    public void sendKeys(WebElement element, String keys) {
        clickElement(element);
        Clear(element);
        System.out.println("Waiting for the String to be passed: " + keys);
        element.sendKeys(keys);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void Clear(WebElement ele){
        clickElement(ele);
        System.out.println("Waiting for the String to be cleared: " + ele.getText());
        ele.clear();


    }
    public void EqnosendKeys(WebElement element, String keys) {
        clickElement(element);
        Clear(element);
        System.out.println("Waiting for the String to be passed: " + keys);
        iosDriver.hideKeyboard(HideKeyboardStrategy.TAP_OUTSIDE);
        element.sendKeys(keys+Keys.BACK_SPACE);
        iosDriver.hideKeyboard(HideKeyboardStrategy.TAP_OUTSIDE);
    }
    public void scroll(AppiumDriver driver, String direction) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction.toLowerCase()); // "up" or "down"
        driver.executeScript("mobile: swipe", params);

    }

    public void scrollUp(AppiumDriver driver) {
        scroll(driver, "up");
    }

    public void scrollDown(AppiumDriver driver) {
        scroll(driver, "down");
    }
}




package org.Reach.iOS.Utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class WaitFunctions {

    AppiumDriver driver;
    WebDriverWait wait;

    public WaitFunctions(AppiumDriver driver) {

        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        System.out.println("Waiting for the String to be passed: " + keys);
        element.sendKeys(keys);
    }

    public void Clear(WebElement ele){
      clickElement(ele);
      ele.clear();

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




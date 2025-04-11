package org.Reach.iOS.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WaitFunctions {

    AppiumDriver driver;
    WebDriverWait wait;
    IOSDriver iosDriver;


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

    public void driverSendKeys( WebElement elementLocator,String text) {
        boolean flag=false;
        try {
            flag=findElement(elementLocator);
            elementLocator.clear();
            elementLocator.sendKeys(text);
        } catch (Exception e) {
            flag=false;
            e.printStackTrace();
        }finally {
            if(flag) {
                System.out.println(text+" Entered On "+elementLocator);
            }else {
                System.out.println(text+" Not Entered On "+elementLocator);
            }
        }
    }


        public void Visibility(WebElement ele){
        wait.until(ExpectedConditions.visibilityOf(ele));
    }


    public boolean findElement(WebElement elementLocator) {
        boolean flag=false;
        try {
            if(elementLocator.isDisplayed()) {

                flag=true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(flag) {
                System.out.println(elementLocator +" - Found");
            }else {
                System.out.println(elementLocator +" - Not Found");
            }
        }
        return flag;
    }

    public void enterTextWithVerification(WebElement element, String expectedText) {
        int maxAttempts = 5;
        int attempt = 0;
        String actualText;

        do {
            element.clear();
            element.sendKeys(expectedText);

            try {
                Thread.sleep(500); // small wait to let the UI update
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            actualText = element.getAttribute("value"); // iOS prefers 'value'

            if (expectedText.equals(actualText)) {
                System.out.println("✅ Text matched after " + (attempt + 1) + " attempt(s)");
                return;
            } else {
                System.out.println("❌ Attempt " + (attempt + 1) + ": Expected '" + expectedText + "', but got '" + actualText + "'");
            }

            attempt++;

        } while (attempt < maxAttempts);

        throw new RuntimeException("❌ Failed to match entered text after " + maxAttempts + " attempts");
    }

    public void sendKeys(WebElement element, String keys) {
        clickElement(element);
        System.out.println("Waiting for the String to be passed: " + keys);
//        try {
//            for (int i = 0; i <= 3; i++) {
                element.clear();
//                Thread.sleep(500);
                element.sendKeys(keys);
//                Thread.sleep(2000);
//                try {
////                    String text = element.getAttribute("value");
////                    System.out.println(text);
//                    // Wait until the text appears in the element
////                    wait.until(ExpectedConditions.textToBePresentInElement(element, keys));
//                    wait.until(ExpectedConditions.attributeToBe(element,"value",keys));
//
//                } catch (TimeoutException e) {
//                    System.out.println("Text not found in element, retrying...");
//                    continue;  // Retry if the condition is not met
//                }
//                Boolean isTextSet = wait.until(ExpectedConditions.textToBePresentInElement(element, keys));
//                System.out.println("textx"+isTextSet);
//                String EnteredText = element.getText();
//                System.out.println("Entered Text:"+EnteredText);
//                String ActualText = keys.replaceAll("[^\\x00-\\x7F]", "");
//                if (EnteredText.equals(ActualText)) {
//
//                    System.out.println("Actual text is:" + ActualText);
//                    return;
//                } else {
//                    System.out.println("Text mismatch, retrying...");
//                }
//                Thread.sleep(5000);
//            }
//            throw new RuntimeException("Failed to enter text correctly:"+keys);
//        }catch (Exception e){
//            throw new RuntimeException("Error while entering text: " + keys, e);
//        }
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

    public void tapActions(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element)); // Ensure element is visible

            // Get element coordinates
            int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
            int centerY = element.getLocation().getY() + (element.getSize().getHeight() / 2);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence tap = new Sequence(finger, 1);

            tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(tap));
            System.out.println("Tapped using W3C Actions on element.");
        } catch (Exception e) {
            System.out.println("❌ Failed to tap using W3C Actions: " + e.getMessage());
        }
    }
}




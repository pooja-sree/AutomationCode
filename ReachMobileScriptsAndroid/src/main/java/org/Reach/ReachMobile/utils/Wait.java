package org.Reach.ReachMobile.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class Wait {

    AppiumDriver driver;
    WebDriverWait Wait;

    public Wait(AppiumDriver driver) {
        this.driver = driver;

        this.Wait = new WebDriverWait(driver, Duration.ofSeconds(500000));
    }


        public void Visibility(WebElement ele){

            Wait.until(ExpectedConditions.visibilityOf(ele));
        }



        public void waitAndClick(WebElement element) {
            Wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }




        public void waitAndSendKeys(WebElement ele, String text) {
            Visibility(ele);
            ele.sendKeys(text);
        }


    public void tapActions(WebElement element) {
        try {
            Wait.until(ExpectedConditions.visibilityOf(element)); // Ensure element is visible

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

    public void Scroll(){

        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();

//        System.out.println(screenWidth);
//        System.out.println(screenHeight);


            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),screenWidth / 2, (int) (screenHeight * 0.90)));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(new Pause(finger, Duration.ofMillis(200)));

            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(),screenWidth / 2, (int) (screenHeight * 0.10)));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(swipe));
    }

    public void LongPress(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .clickAndHold(element)
                .pause(Duration.ofSeconds(2)) // Hold for 2 seconds
                .release()
                .perform();

    }


    }


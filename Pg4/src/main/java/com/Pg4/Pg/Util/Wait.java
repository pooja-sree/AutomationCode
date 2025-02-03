package com.Pg4.Pg.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import java.time.Duration;
import java.util.List;

public class Wait {

private WebDriver driver;

static WebDriverWait wait;

public Wait(WebDriver driver){
this.driver = driver;
    PageFactory.initElements(driver, this);
    wait=new WebDriverWait(driver, Duration.ofSeconds(10000));
}






    public void Visibility(WebElement ele){
        wait.until(ExpectedConditions.visibilityOf(ele));
    }


    public void VisibilityAll(List<WebElement> ele){
        wait.until(ExpectedConditions.visibilityOfAllElements(ele));
    }

    public void Presence_of_all_elements(By Locator){
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locator));
    }
    public void URL(String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebElement Presence_of_element(By element){
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
public void Presenceofele(By Locator){
    wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
}

    public void scrollToElement(WebDriver driver, WebElement element) {

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Enable scrolling (if disabled)
            js.executeScript("document.body.style.overflow = 'auto';");
            js.executeScript("document.body.style.position = 'static';");

            // Check if the element is displayed before scrolling
            if (element.isDisplayed()) {
                // Scroll directly to the element
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            } else {
                // Scroll by a specific number of pixels as a fallback if element is not visible yet
                js.executeScript("window.scrollBy(0, 500);");
            }

            // Add a delay to allow the scroll to complete (optional)
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public void scrolldownandJsClick(WebElement elementLocator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", elementLocator);
        js.executeScript("window.scrollBy(0,400),",elementLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        js.executeScript("arguments[0].click();", elementLocator);
    }

    public void hardwaitBasedOnInput(int timeOuts) {
        try {
            Thread.sleep(timeOuts);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

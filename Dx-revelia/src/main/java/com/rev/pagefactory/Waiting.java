package com.rev.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waiting {

    WebDriver driver;
    static WebDriverWait wait;
    Locators Locate;
    public Waiting(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,Duration.ofMillis(100000));

    }

    public void Visibility(WebElement ele){
        wait.until(ExpectedConditions.visibilityOf(ele));
    }


    public void VisibilityAll(List<WebElement> ele){
        wait.until(ExpectedConditions.visibilityOfAllElements(ele));
    }

    public void URL(String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebElement Presence_of_element(By element){
       return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }


    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

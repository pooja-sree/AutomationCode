package com.Pg4.Pg.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

public static WebDriver driver;
Wait wait;

public BasePage(){


    this.driver = BrowserConfig.getDriver();

    if (this.driver == null) {
        System.out.println("BasePage: WebDriver is null.");

        throw new IllegalStateException("WebDriver is not initialized. Ensure BrowserConfig initializes the WebDriver.");
    }
    else {
        System.out.println("BasePage: WebDriver is initialized.");
    }

    PageFactory.initElements(driver,this);

    this.wait = new Wait(this.driver);

}
}

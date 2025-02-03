package com.Pg4.Pg.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserConfig {

    public static WebDriver driver;

    PropsReader props = new PropsReader();

    public BrowserConfig(){

        if (driver == null) {
            System.out.println("BrowserConfig: WebDriver is null, initializing it now.");

            driver = getDriver();


        }
        else {
            System.out.println("BrowserConfig: WebDriver already initialized.");

        }
        }



public static WebDriver getDriver(){
    System.out.println("BrowserConfig: Inside initializeDriver");

       // if (PropsReader.driver.equals("Local"))
    if(driver==null)
        {

            System.out.println("BrowserConfig: Initializing WebDriver.");

            System.setProperty("webdriver.chrome.driver","C:/Program Files/chromedriver-win64" +
        "/chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("BrowserConfig: WebDriver initialized.");

        }
        return driver;
}

    public void closeDriver() {
        if (driver != null) {

            System.out.println("BrowserConfig: Closing WebDriver.");

            driver.quit();

        }
    }
}

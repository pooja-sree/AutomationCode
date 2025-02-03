package com.Pg4.Pg.Util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {


    public static WebDriver driver;

    public Hooks(){

    }

    @Before
    public void InitializeDriver(){
        System.setProperty("webdriver.chrome.driver","C:/Program Files/chromedriver-win64" +
                "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pg3.lmapps.io/users/login");
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}

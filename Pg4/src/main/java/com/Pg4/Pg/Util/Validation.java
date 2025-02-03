package com.Pg4.Pg.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Validation extends BasePage{

    public void CheckURL(String ExpectedLink, String text){
        String msg = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedLink,msg,text);
    }




}

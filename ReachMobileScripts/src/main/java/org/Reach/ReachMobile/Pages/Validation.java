package org.Reach.ReachMobile.Pages;

import io.appium.java_client.AppiumDriver;
import org.Reach.ReachMobile.Pages.LoginApplication;
import org.testng.Assert;

public class Validation {
    AppiumDriver driver;

    LoginApplication LoginElements;
    EventCreate createEventElement;

    public Validation(AppiumDriver driver){
        if (driver == null) {
            throw new IllegalStateException("🚨 Driver is null in Validation! Ensure it's initialized before calling.");
        }
        this.driver=driver;
        this.LoginElements = new LoginApplication(driver);
        this.createEventElement = new EventCreate(driver);
    }

public void LoginUser(String Expecteduser,String message){
    Assert.assertEquals(LoginElements.Username.getText(),Expecteduser,message);

}




}

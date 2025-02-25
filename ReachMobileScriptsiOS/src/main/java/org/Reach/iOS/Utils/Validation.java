package org.Reach.iOS.Utils;

import io.appium.java_client.AppiumDriver;
import org.Reach.iOS.Pages.Login_Elements;
import org.testng.Assert;

public class Validation {

    AppiumDriver driver;
    Login_Elements login;
    public Validation(AppiumDriver driver) {
        this.driver = driver;
        this.login = new Login_Elements(driver);


    }

    public void User(String Expecteduser,String message){
        Assert.assertEquals(login.User.getText(),Expecteduser,message);



    }
}

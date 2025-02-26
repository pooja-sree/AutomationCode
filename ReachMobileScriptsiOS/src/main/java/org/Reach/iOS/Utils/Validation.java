package org.Reach.iOS.Utils;

import io.appium.java_client.AppiumDriver;
import org.Reach.iOS.Pages.Login_Elements;
import org.testng.Assert;

public class Validation {

    AppiumDriver driver;
    Login_Elements login;
    WaitFunctions waitFunctions;
    public Validation(AppiumDriver driver) {
        this.driver = driver;
        this.login = new Login_Elements(driver);
        this.waitFunctions = new WaitFunctions(driver);


    }

    public void User(String Expecteduser,String message){
        waitFunctions.Visibility(login.User);
        Assert.assertEquals(login.User.getText(),Expecteduser,message);
        System.out.println("User successfully logged in");




    }
}

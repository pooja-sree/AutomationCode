package org.Reach.iOS.Utils;

import io.appium.java_client.AppiumDriver;
import org.Reach.iOS.Pages.EventCreation_elements;
import org.Reach.iOS.Pages.Login_Elements;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Validation {

    AppiumDriver driver;
    Login_Elements login;
    WaitFunctions waitFunctions;
    EventCreation_elements event;
    public Validation(AppiumDriver driver) {
        this.driver = driver;
        this.login = new Login_Elements(driver);
        this.waitFunctions = new WaitFunctions(driver);


    }

    public void AdminUser(String Expecteduser,String message){
        waitFunctions.Visibility(login.AdminUser);
        Assert.assertEquals(login.AdminUser.getText(),Expecteduser,message);
        System.out.println("AdminUser successfully logged in");
    }

    public void TechnicianUser(String Expecteduser,String message){
        waitFunctions.Visibility(login.TechnicianUser);
        Assert.assertEquals(login.TechnicianUser.getText(),Expecteduser,message);
        System.out.println("TechnicianUser successfully logged in");
    }

    public void Equipmentnumber(WebElement element,String ExpectedValue,String message){
        waitFunctions.Visibility(element);
        Assert.assertEquals(element.getText(),ExpectedValue,message);
    }

    public void EventStatus(WebElement element,String status, String message){
        waitFunctions.Visibility(element);
        Assert.assertEquals(element.getText(),status,message);
    }


}

package org.Reach.iOS.Utils;

import io.appium.java_client.AppiumDriver;
import org.Reach.iOS.Pages.Login_Elements;
import org.Reach.iOS.Pages.ServiceEvent_Elements;
import org.testng.Assert;

public class Validation {

    AppiumDriver driver;
    Login_Elements login;
    ServiceEvent_Elements service;
    WaitFunctions waitFunctions;
    public Validation(AppiumDriver driver) {
        this.driver = driver;
        this.login = new Login_Elements(driver);
        this.service = new ServiceEvent_Elements(driver);
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

    public void Equipmentnumber(String ExpectedValue,String message){
        waitFunctions.Visibility(service.EquipmentProviderIsUnknown);
        Assert.assertEquals(service.EquipmentProviderIsUnknown.getText(),ExpectedValue,message);
    }
}

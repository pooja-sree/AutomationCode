package org.Reach.TestCase;

import io.appium.java_client.AppiumDriver;

import io.cucumber.datatable.DataTable;
import org.Reach.iOS.Pages.Login_Elements;
import org.Reach.iOS.Utils.Validation;
import org.Reach.iOS.Utils.WaitFunctions;

import java.util.List;
import java.util.Map;

public class LoginApplication_Testcase extends Login_Elements {

    public Validation valid;


    public LoginApplication_Testcase(AppiumDriver driver) {

        super(driver);
        valid = new Validation(driver);
    }


    public void LoginToApplication(String User, DataTable eventData) {

        List<Map<String,String>> list = eventData.asMaps(String.class,String.class);
        String Email = list.getFirst().get("Email");
        String Password = list.getFirst().get("Password");
        System.out.println("Starting to enter credentials");
        switch (User){
            case "SC-Admin":
                StartButton(Email, Password);
                valid.AdminUser("SC-ADMIN","Admin has logged in");
                break;

            case "SC-Technician":
                StartButton(Email, Password);
                valid.TechnicianUser("SC-TECHNICIAN","Technician has logged in");
                break;

            default: System.out.println("Invalid User");
        }

    }

    public void LogoutOfApplication() {
        Logout();

    }


}
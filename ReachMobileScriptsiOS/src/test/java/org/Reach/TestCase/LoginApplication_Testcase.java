package org.Reach.TestCase;

import io.appium.java_client.AppiumDriver;

import org.Reach.iOS.Pages.Login_Elements;
import org.Reach.iOS.Utils.WaitFunctions;

public class LoginApplication_Testcase extends Login_Elements {


AppiumDriver driver;
    public LoginApplication_Testcase(AppiumDriver driver) {

        System.out.println("🔍 Inside LoginApplication_Testcase constructor. Driver: " + driver);


        System.out.println("🔍 Inside LoginApplication_Testcase constructor. Driver: " + driver);

        if (driver == null) {
            System.out.println("❌ ERROR: Driver is NULL in LoginApplication_Testcase!");
        } else {
            System.out.println("✅ Driver successfully received: " + driver);
        }
    }


    public void LoginToApplication(String email, String password) {

        StartButton();
        LoginApp(email, password);
    }

    public void LogoutOfApplication() {
        Logout();

    }


}
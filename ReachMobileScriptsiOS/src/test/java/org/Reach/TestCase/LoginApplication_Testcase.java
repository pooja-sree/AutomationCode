package org.Reach.TestCase;

import io.appium.java_client.AppiumDriver;

import org.Reach.iOS.Pages.Login_Elements;
import org.Reach.iOS.Utils.WaitFunctions;

public class LoginApplication_Testcase extends Login_Elements {




    public LoginApplication_Testcase(AppiumDriver driver) {
        super(driver);
    }


    public void LoginToApplication(String email, String password) {


        LoginApp(email, password);
    }

    public void LogoutOfApplication() {
        Logout();

    }


}
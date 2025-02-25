package Testcase;

import io.appium.java_client.AppiumDriver;
import org.Reach.ReachMobile.Pages.LoginApplication;
import org.Reach.ReachMobile.utils.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginCase extends LoginApplication {
    private Wait waitmethods;



    public LoginCase(AppiumDriver driver) {
        super(driver);

        if (driver == null) {
            throw new IllegalStateException("🚨 Driver is NULL in LoginCase! Ensure it's initialized before calling.");
        }

        this.waitmethods = new Wait(driver);

    }


    public void Allow_Notifications(){
            waitmethods.Visibility(NotificationAllow);
            waitmethods.waitAndClick(NotificationAllow);
    }

    public void GetStarted(){
        waitmethods.Visibility(GetStarted);
        waitmethods.waitAndClick(GetStarted);
    }

    public void EnterCredentials(String email, String password){
        waitmethods.waitAndSendKeys(Email,email);
        NextButton.click();
        waitmethods.waitAndSendKeys(Password,password);
        NextButton.click();
    }

    public void Logout(){
        waitmethods.waitAndClick(Settingicon);
        waitmethods.waitAndClick(iconsettings);
        waitmethods.waitAndClick(yesbutton);
    }
}

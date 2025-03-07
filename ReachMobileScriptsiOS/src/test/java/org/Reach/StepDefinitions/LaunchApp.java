package org.Reach.StepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.Reach.TestCase.LoginApplication_Testcase;
import org.Reach.iOS.Utils.Validation;
import org.Reach.iOS.Utils.WaitFunctions;

public class LaunchApp {


    AppiumDriver driver;
    public LoginApplication_Testcase LoginObj;
    public Validation valid;
    public WaitFunctions wait;


        public LaunchApp() {
            this.driver = Hooks.getDriver();
            LoginObj = new LoginApplication_Testcase(driver);
            valid = new Validation(driver);

        }



    @Given("I launch the app on the emulator")
    public void iLaunchTheAppOnTheEmulator() {
        System.out.println("🔥 Step: Launching app on emulator...");


    }

    @Then("The app should be open")
    public void TheAppShouldBeOpen() {}

    @Then("I Enter User {string} Credentials Email {string} and Password {string}")
    public void iEnterUserCredentialsEmailAndPassword(String User,String email, String password) {
            System.out.println("Starting to enter credentials");
            switch (User){
                case "SC-Admin":
                    LoginObj.StartButton(email, password);
                    valid.AdminUser("SC-ADMIN","Admin has logged in");
                    LoginObj.LogoutOfApplication();
                    break;

                case "SC-Technician":
                    LoginObj.StartButton(email, password);
                    valid.TechnicianUser("SC-TECHNICIAN","Technician has logged in");
                    LoginObj.LogoutOfApplication();
                    break;

                default: System.out.println("Invalid User");
            }

    }

    @Then("Close Application")
    public void closeApplication() {}
}

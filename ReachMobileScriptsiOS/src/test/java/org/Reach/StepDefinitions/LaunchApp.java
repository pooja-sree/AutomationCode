package org.Reach.StepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.Reach.TestCase.LoginApplication_Testcase;

public class LaunchApp {


    AppiumDriver driver;
    LoginApplication_Testcase LoginApp;

        public LaunchApp() {
            this.driver = Hooks.getDriver();
            System.out.println("🚀 Initializing LoginApplication_Testcase...");
            System.out.println("🔍 Before initializing LoginApplication_Testcase. Driver: " + driver);

            LoginApp = new LoginApplication_Testcase(driver);
            System.out.println("✅ LoginApplication_Testcase initialized.");
        }



    @Given("I launch the app on the emulator")
    public void iLaunchTheAppOnTheEmulator() {
        System.out.println("🔥 Step: Launching app on emulator...");
        LoginApp.StartButton();
    }

    @Then("The app should be open")
    public void TheAppShouldBeOpen() {}

    @Then("I Enter User {string} Credentials Email {string} and Password {string}")
    public void iEnterUserCredentialsEmailAndPassword(String User,String email, String password) {
//        if(User.equals("SC-Admin")){
//            LoginApp.LoginToApplication(email, password);
//
//        }

    }

    @Then("Close Application")
    public void closeApplication() {}
}

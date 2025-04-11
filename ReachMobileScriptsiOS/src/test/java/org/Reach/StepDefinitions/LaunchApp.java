package org.Reach.StepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Reach.TestCase.LoginApplication_Testcase;
import org.Reach.iOS.Utils.Validation;
import org.Reach.iOS.Utils.WaitFunctions;

import java.util.List;
import java.util.Map;

public class LaunchApp {


    AppiumDriver driver;
    public LoginApplication_Testcase LoginObj;

    public WaitFunctions wait;


        public LaunchApp() {
            this.driver = Hooks.getDriver();
            LoginObj = new LoginApplication_Testcase(driver);


        }



    @Given("I launch the app on the emulator")
    public void iLaunchTheAppOnTheEmulator() {
        System.out.println("🔥 Step: Launching app on emulator...");
    }

    @When("Login as {string}")
    public void Login_as_(String User, DataTable EventData){
        LoginObj.LoginToApplication(User,EventData);
    }

    @Then("Logout")
    public void closeApplication() {
        LoginObj.LogoutOfApplication();
    }


}

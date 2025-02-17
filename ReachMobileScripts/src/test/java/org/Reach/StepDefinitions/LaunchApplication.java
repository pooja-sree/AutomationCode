package org.Reach.StepDefinitions;

import Testcase.CreateEvent;
import Testcase.LoginCase;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Reach.ReachMobile.Pages.EventCreate;
import org.Reach.ReachMobile.Pages.Validation;
import org.Reach.ReachMobile.utils.Wait;

public class LaunchApplication {

    private AppiumDriver driver;
    private LoginCase LoginElements;
    private Validation validate;
    private Wait waitfn;


    public CreateEvent ce;


    @Given("I launch the {string} app on the emulator")
    public void iLaunchTheAppOnTheEmulator(String platform) {
        driver = AppiumDriverManager.getDriver(platform); // ✅ Ensure driver is assigned here
        if (driver == null) {
            throw new IllegalStateException("Driver is null! Ensure Appium server is running.");
        }

        System.out.println("ℹ️ Driver instance in LaunchApplication: " + driver);

        LoginElements = new LoginCase(driver); // ✅ Initialize after driver is set
        this.ce = new CreateEvent(driver);
        validate = new Validation(driver);
        waitfn = new Wait(driver);
        System.out.println("✅ App Launched Successfully!");
    }

    @Then("The app should be open")
    public void theAppShouldBeOpen() {
        if (LoginElements == null) {
            throw new IllegalStateException("LoginElements is null! Ensure driver is initialized before calling methods.");
        }

        LoginElements.Allow_Notifications();
        waitfn.Visibility(LoginElements.GetStarted);
        LoginElements.GetStarted();
    }

    @Then("I Enter User {string} Credentials Email {string} and Password {string}")
    public void iEnterUserCredentialsEmailAnd(String user, String email, String password) {
        if (LoginElements == null) {
            throw new IllegalStateException("LoginElements is null! Ensure the driver is initialized.");
        }
        LoginElements.EnterCredentials(email, password);
        validate.LoginUser("SC-ADMIN", "Admin has Logged in");

//        switch (user) {
//            case "SC-Admin":
//                LoginElements.EnterCredentials(email, password);
//                validate.LoginUser("SC-ADMIN", "Admin has Logged in");
//                break;
//            case "SC-Technician":
//            case "SC-Accountant":
//            case "SC-Observer":
//            case "SC-Supervisor":
//            case "SC-User":
//            case "SC-Guest":
//                LoginElements.EnterCredentials(email, password);
//                break;
//            default:
//                System.out.println("Invalid User");
//        }
    }

    @Then("Close Application")
    public  void CloseApplication(){
        LoginElements.Logout();
        AppiumDriverManager.quitDriver();
    }

    @Given("Create an event from TD")
    public void CreateAnEventFromTD(){
        iLaunchTheAppOnTheEmulator("Android");
       if(ce== null){
           throw new IllegalStateException("Createevent is null! Ensure the driver is initialized.");
       }
       ce.EventCreation();
    }

    @When("Enter Service Details")
    public void EnterServiceDetails(){
        ce.serviceEventList();

    }
     @And("Verify event status")
    public void VerifyEventStatus(){

     }






}

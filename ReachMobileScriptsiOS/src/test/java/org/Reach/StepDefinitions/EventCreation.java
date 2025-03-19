package org.Reach.StepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import org.Reach.TestCase.Createevent_Testcase;
import org.Reach.TestCase.LoginApplication_Testcase;
import org.Reach.iOS.Utils.Validation;

public class EventCreation {
    AppiumDriver driver;
    LoginApplication_Testcase loginApp;
    Createevent_Testcase createevent;
    Validation validation;

    public EventCreation(){
        this.driver = Hooks.getDriver();
        loginApp = new LoginApplication_Testcase(driver);
        createevent = new Createevent_Testcase(driver);
        validation = new Validation(driver);

    }

    @Then("I Enter User {string} Credentials Email {string} and Password {string} to create an event with this Equipment type {string}")
    public void i_enter_user_credentials_email_and_password_to_create_an_event(String user, String email, String password,String EquipmentType) {
        System.out.println("Starting to enter Credentials");
        switch (user){
            case "SC-Admin":

                switch (EquipmentType){
                    case "PowerUnit":
                        loginApp.LoginToApplication(email, password);
                        System.out.println("Starting to select Equipment");
                        createevent.powerunitEventCreation();
                        validation.AdminUser("SC-ADMIN","Admin has logged in");
                        System.out.println("Event created successfully");
                        createevent.searchEvent();
                        createevent.assignEvent();
                        loginApp.LogoutOfApplication();
                        break;

                    default: System.out.println("Invalid Equipment");
                }
                break;

            case "SC-Technician":
                loginApp.LoginToApplication(email, password);
                validation.TechnicianUser("SC-TECHNICIAN","Technician has logged in");
                createevent.searchEvent();
                createevent.searchEventID();
                createevent.eventFlowWithETAAndETC();


                default: System.out.println("Invalid user");


        }


    }




    @Then("Close the Application")
    public void closeApplication() {
        loginApp.LogoutOfApplication();
        driver.quit();
    }
}

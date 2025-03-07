package org.Reach.StepDefinitions;

import org.Reach.TestCase.EventCreation_Testcase;
import org.Reach.TestCase.LoginApplication_Testcase;
import org.Reach.iOS.Utils.Validation;
import org.Reach.iOS.Utils.WaitFunctions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EventCreation {

    AppiumDriver driver;
    public LoginApplication_Testcase LoginObj;
    public Validation valid;
    public WaitFunctions wait;
    public EventCreation_Testcase EventObj;


    public EventCreation(){
        this.driver=Hooks.getDriver();
        LoginObj = new LoginApplication_Testcase(driver);
        valid = new Validation(driver);
        EventObj = new EventCreation_Testcase(driver);

    }



    @Then("I Enter User {string} Credentials Email {string} and Password {string}")
    public void iEnterUserCredentialsEmailAndPassword(String User,String email, String password) {
            System.out.println("Starting to enter credentials");
            switch (User){
                case "SC-Admin":
                    LoginObj.StartButton(email, password);
                    valid.AdminUser("SC-ADMIN","Admin has logged in");
                    break;

                // case "SC-Technician":
                //     LoginObj.StartButton(email, password);
                //     valid.TechnicianUser("SC-TECHNICIAN","Technician has logged in");
                //     LoginObj.LogoutOfApplication();
                //     break;

                default: System.out.println("Invalid User");
            }

    }

    @Then("the user selects Equipment Type {string}")
    public void theUserSelectsEquipmentType(String type) {
        System.out.println("Starting to select equipment type");
        String[] EquipmentType=type.split(",");
        for(String Equipment:EquipmentType){
        switch (Equipment.trim()){
            case "Chassis":
                EventObj.chassisServiceEvent();
                break;
            case "Container":
                break;
            case "PowerUnit":
                break;
            case "Trailer":
                break;
                default:System.out.println("Invalid type");
        }}
    }

}

package org.Reach.StepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.Reach.TestCase.Createevent_Testcase;
import org.Reach.TestCase.LoginApplication_Testcase;
import org.Reach.iOS.Utils.Validation;
import org.checkerframework.checker.units.qual.C;

import java.util.List;
import java.util.Map;

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

    @Then("Create an event {string}")
    public void createAnEvent(String FeatureName, DataTable EventData) throws InterruptedException {
        createevent.EventCreation(FeatureName,EventData);
           }

    @Then("Enter Service Details {string}")
    public void serviceDetails(String FeatureName, DataTable EventData){
        createevent.serviceEventDetails(FeatureName, EventData);

    }

    @Then("Add Attachments {string}")
    public void attachmentsFromGallery(String Category){
        createevent.AddAttachments(Category);
    }

    @And("Search Event")
    public void searchEvent(){
        createevent.searchEvent();
    }

    @And("Event Details Action {string}")
    public void EventDetails(String Action){
        createevent.EventDetails(Action);
    }

    @And("Search EventID")
    public void searchEventID()
    {
       createevent.searchEventID();
    }

    @And("Assign Technician {string}")
    public void assignTechnician(String Technician){
        createevent.AssignTech(Technician);
    }

    @And("GoBack1")
    public void Back(){
        createevent.GoBack1();
    }

    @And("GoBack2")
    public void GoBack(){
        createevent.GoBack2();
    }

    @Then("Event Action {string} by {string}")
    public void EventAction(String Action,String user){
        createevent.EventAction(Action,user);

    }



}

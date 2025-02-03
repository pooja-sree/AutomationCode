package com.pg4.pg.stepDefinitions;

import com.Pg4.Pg.Pages.Login;
import com.Pg4.Pg.Util.*;
import com.pg4.pg.Testcase.Questionnaire_TC;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StepDefinition {
    public WebDriver driver;
    BeforeandAfterScenarios Login = new BeforeandAfterScenarios();


    BrowserConfig con = new BrowserConfig();




    @Given("I Navigate to Login Page")
    public void i_navigate_to_login_page(){


    }

    @When("User Login as Patient")
    public void user_login_as_Patient() {
        Login.Login("Patient");
    }

    @When("User Login as Practitioner")
    public void user_login_as_Practitioner() {
        Login.Login("Practitioner");


    }

    @Then("Patient should answer the Questionnaire")
    public void Questionnaire(){
        Questionnaire_TC Que = new Questionnaire_TC();
        Que.Answer();
    }
    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        con.closeDriver();



    }


}

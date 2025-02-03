package com.rev.stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testcases.*;

import java.awt.*;


public class StepDefinition {

    public WebDriver driver;

    public StepDefinition() {
        driver = Hooks.driver;

    }


    @Given("I navigate to login page")
    public void i_navigate_to_login_page() {
    }

    @When("User login {string} and {string} and {string}")
    public void user_login_and_and(String user, String username, String password) {
        Login_TestCases login = new Login_TestCases(driver);
        switch (user) {
            case "practice admin", "practitioner":
                login.Validcredentials(username, password);
                break;
            case "patient":
                login.PatientLogin(username, password);
                break;
            case "Nonexistent":
                login.Nonexistent(username, password);
                break;
            case "Empty data":
                login.Loginwithoutcredentials(username, password);
                break;
            case "Forgot Password":
                login.ForgotPassword(username);
                break;
            default:
                login.Invalidlogincredentials(username, password);

        }
    }

    @When("I click on add new patient and enter Patient Details {string}")
    public void iClickOnAddNewPatientAndEnterPatientDetailsAnd(String usertype) {
        Add_New_Patient_TestCases AddPat = new Add_New_Patient_TestCases(driver);
        switch (usertype) {
            case "practice admin":
                AddPat.Add_Patient_Details_For_PracticeAdmin();
                break;
            case "practitioner":
                AddPat.Add_Patient_Details_For_Practitioner();
                break;
        }
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        //driver.quit();
    }

    @And("Click on Add Patient")
    public void click_on_add_patient() {
        Add_New_Patient_TestCases AddPat = new Add_New_Patient_TestCases(driver);
        AddPat.Add();
        AddPat.Validationforaddpatient();
        AddPat.Patient_Table_Validation();
    }

    @And(("Click on Cancel and continue"))
    public void Adding_a_new_patient_should_be_cancelled() {
        Add_New_Patient_TestCases AddPat = new Add_New_Patient_TestCases(driver);
        AddPat.Cancel_continue();
    }

    @And("Cancel")
    public void Cancel_adding_new_Patient() {
        Add_New_Patient_TestCases AddPat = new Add_New_Patient_TestCases(driver);
        AddPat.Cancel();
    }

    @When("I click on add new patient and click on Add {string}")
    public void Add(String usertype){
        Add_New_Patient_TestCases AddPat = new Add_New_Patient_TestCases(driver);
        if(usertype.contains("practice admin")){
            AddPat.AddNewPatientButton();
            AddPat.PracticeEmail();
            AddPat.Add();
        }
        else {
            if (usertype.contains("practitioner")) {
                AddPat.AddNewPatientButton();
                AddPat.PractitionerEmail();
                AddPat.Add();
            }

        }
    }

    @Then("Patient should be added")
    public void Patient_should_be_added(){
        Add_New_Patient_TestCases AddPat = new Add_New_Patient_TestCases(driver);
        AddPat.Validationforaddpatient();
    }

    @And("Click on Add without adding email {string}")
    public void Add_patient_only_with_email(String usertype){
        if((usertype.contains("practice admin") || usertype.contains("practitioner"))) {
            Add_New_Patient_TestCases AddPat = new Add_New_Patient_TestCases(driver);
            AddPat.AddNewPatientButton();
            AddPat.Add();
            AddPat.Validationforreqfield();
        }
    }

    @And("Click on Add by entering registered email {string}")
    public void Add_patient_with_registered_email(String usertype){
        Add_New_Patient_TestCases AddPat = new Add_New_Patient_TestCases(driver);
        if(usertype.contains("practice admin")){
            AddPat.AddNewPatientButton();
            AddPat.Add_Patient_Details_For_PracticeAdmin();
            AddPat.Add();
            AddPat.Validationforemail();
        }
        else {
            if (usertype.contains("practitioner")) {
                AddPat.AddNewPatientButton();
                AddPat.Add_Patient_Details_For_Practitioner();
                AddPat.Add();
                AddPat.Validationforemail();
            }
        }

    }
    @Given("Update Patient Profile")
    public void update_patient_profile() {
        Patient_Dashboard_TestCases Patientprof = new Patient_Dashboard_TestCases(driver);
        Patientprof.Patient_Profile_update();

    }
    @Given("Answer the Forms")
    public void Answer_the_forms(){
        Patient_About_You_Forms_Testcases form = new Patient_About_You_Forms_Testcases(driver);
        form.About_You_Form();

    }
    @Then("Save Answers")
    public void Save_answers(){

    }

    @And("Submit the forms")
    public void Submit_forms(){

    }

    @Given("Access Patient Report")
    public void Patient_Reports() throws AWTException {
        Patient_Report_Testcases report = new Patient_Report_Testcases(driver);
        report.Patient_Report();
    }

    @Given("Access Patient Plan")
    public void Patient_Plan(){
        Patient_Plan_Testcases plan = new Patient_Plan_Testcases(driver);
        plan.Patient_Plans();

    }


}







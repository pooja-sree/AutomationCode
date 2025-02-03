package Com.Pg4.StepDefinition;



import TestCases.Login_Testcase;
import TestCases.NewPatient_Testcase;
import TestCases.Questionnaire_Testcase;
import com.Pg4.PageFactory.Login;
import com.Pg4.PageFactory.Validation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;


public class Stepdefinition {

    public WebDriver driver;

    Login_Testcase Logtc;
    Questionnaire_Testcase Quetc;

    NewPatient_Testcase Pattc;
    Validation validate;
    public Stepdefinition(){
        driver = Hooks.driver;
        Logtc = new Login_Testcase(driver);
        validate = new Validation(driver);
        Quetc = new Questionnaire_Testcase(driver);
        Pattc = new NewPatient_Testcase(driver);
    }



    @Given("I Navigate to Login Page")
    public void i_navigate_to_login_page(){


    }

    @When("User login {string} and {string} and {string}")
    public void user_login_and_and(String user, String Email, String password) {

        switch (user) {

            case "practitioner" :

                Logtc.Login(Email,password);
                validate.Login_Validation_Practitioner();
                break;
            case "patient"     :

                Logtc.Login(Email,password);
                validate.Login_Validation_Patient();
                break;

            case "Invalid"     :
                Logtc.InvalidLogin(Email,password);
                break;

            case "EmptyData"   :
                Logtc.EmptyData(Email,password);
                break;

            case "Forgot Password" :
                Logtc.ForgotPassword(Email,password);
                break;

        }
    }

    @Given("Answer the forms")
    public void Answer_Questionnaire(){
        Quetc.Execute_Forms();

    }

    @Given(("Practitioner Adds a New Patient"))
    public void Add_new_Patient(){
        Pattc.Add_Patient();
        Pattc.Add_Patient_with_Blank_Fields();
        Pattc.PractitionerAsAPatient();

    }



    @Then("I should be logged in")
    public void i_should_be_logged_in() {

    }



}

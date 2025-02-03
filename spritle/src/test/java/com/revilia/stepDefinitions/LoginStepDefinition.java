package com.revilia.stepDefinitions;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.revilia.pagefactory.Loginpage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition{




	public static  WebDriver driver;
	//public static  Loginpage log = new Loginpage(driver);



	@Given("I navigate to login page")
	public void i_navigate_to_login_page() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://54.236.2.11:5173/");
		driver.manage().window().maximize();
	}

	@When("I enter valid Credential")
	public void i_enter_valid_credential(DataTable data) throws InterruptedException  {

		List <Map<String,String>>keyvalue = data.asMaps(String.class, String.class);
		String username = keyvalue.get(0).get("username");
		String password = keyvalue.get(0).get("password");
		Loginpage log = new Loginpage(driver);
		log.Validlogincredentials(username,password);
		//log.Visibility();
	}

	@Then("should be logged in")
	public void should_be_logged_in() throws InterruptedException {
		Loginpage log = new Loginpage(driver);
		log.isLoginSuccessful();
		driver.quit();
	}

	@When("I enter Invalid Credentials")
	public void I_enter_Invalid_Credential(DataTable data)  {
		List<List<String>> cred =data.asLists(String.class);
		for(List<String> value : cred) {
		String username = value.get(0);
		String password = value.get(1);
		Loginpage log = new Loginpage(driver);
		log.InValidlogincredentials(username,password);
		}

	}

	@Then("login unsuccessful")
	public void login_unsuccessful()  {
		Loginpage log = new Loginpage(driver);
		log.Loginunsuccessful();
		driver.quit();
	}

	@When("Login without Credentials with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public static void Login_without_Credentials(String username,String password)  {
		Loginpage log = new Loginpage(driver);
		log.Loginwithoutcredentials(username,password);
	}

	@Then("Validation message")
	public void Validation_Message()  {
		Loginpage log = new Loginpage(driver);
		log.Validationmessage();
		driver.quit();
	}

	@When("Click on Forgot Password")
	public void Forgot_Password() {
		Loginpage log = new Loginpage(driver);
		log.Forgot_Password();
	}

	@Then("set up new Password using link sent to given email")
	public void Reset_Password()  {
		Loginpage log = new Loginpage(driver);
		log.Reset_Password();
		driver.quit();
	}}



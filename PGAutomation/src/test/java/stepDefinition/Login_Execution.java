package stepDefinition;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.puregenomics.at.dataprovider.ConfigFileReader;
import com.puregenomics.at.testcases.Login_cases;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Login_Execution {
	public WebDriver driver;

	private Logger log = Logger.getLogger(Login_Execution.class);
	
	ConfigFileReader config = new ConfigFileReader();
	public Login_Execution() throws Exception 
	{
		driver = Hooks.driver;
		
	}
	
	@Given("^Launch the URL$")
	public void launch_the_URL() {
		log.info("---Launching URL---");
		driver.get(config.getApplicationUrl());	 
	}

	@When("^Enter credentials and sign in$")
	public void enter_credentials_and_sign_in(DataTable data) {
		List<List<String>> logindata = data.raw();
		Login_cases login = new Login_cases();
		login.navigate_to_signin_page();
		login.login(logindata);
	}

	@Then("^Verify logged user$")
	public void verify_logged_user() {
		Login_cases login = new Login_cases();
		login.verify_user();
	}
	
	@When("^Select domain$")
	public void select_domain(DataTable domain_data) {
		List<List<String>> select_domain = domain_data.raw();
		Login_cases login = new Login_cases();
		login.domain(select_domain);
	
	}

	@Then("^Verify warning message$")
	public void verify_warning_message() {
		Login_cases login = new Login_cases();
		login.login_invalid_message();
	}
	
	@Then("Logout from application$")
	public void logout_from_application() {
		Login_cases login = new Login_cases();
		login.logout();
	}
	
	@When("^Enter email  \"([^\"]*)\" password \"([^\"]*)\" and sign in$")
	public void enter_email_password_and_sign_in(String email, String pwd) {
		Login_cases login = new Login_cases();
		login.navigate_to_signin_page();
		login.signin(email,pwd);
	}

}

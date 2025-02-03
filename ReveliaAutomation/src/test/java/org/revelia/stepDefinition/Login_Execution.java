package org.revelia.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.revelia.testcases.Login_cases;
import io.cucumber.java.en.*;


public class Login_Execution {
	
	public WebDriver driver;
	
	public Login_Execution() {
		driver = Hooks.driver;
	}
		
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		System.out.println("user is in login page");
	}
	
	@When("they enter valid {string} and {string} and login")
	public void they_enter_valid_and_and_login(String user, String pwd) {
		Login_cases login = new Login_cases(driver);
		login.user_input(user, pwd);
	}
	
	@Then("validate the user login {string}")
	public void validate_the_user_login(String user) {
		Login_cases login = new Login_cases(driver);
		login.validate_login(user);
	}


}

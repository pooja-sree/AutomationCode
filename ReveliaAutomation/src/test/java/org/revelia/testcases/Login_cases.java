package org.revelia.testcases;

import org.openqa.selenium.WebDriver;
import org.revelia.pagefactory.Loginpage;

public class Login_cases extends Loginpage {
	
	 public Login_cases(WebDriver driver) {
		super(driver);
	}
	 

	public void user_input(String username, String password) {
		 input_username.sendKeys(username);
		 input_password.sendKeys(password);
		 System.out.println("user provided credentials");
		 button_login.click();
	    }
	
	    
	   public void validate_login(String user){
	    	String role =user_roles.getText();
	    	System.out.println(role);
	    	switch (user) {
			case "practice admin":
			case "practitioner":
				if(role.contains("Practice admin") || role.contains("Practitioner")){
					System.out.println("user is both admin and practitioner");
				} else if (user_roles.isDisplayed()){
					System.out.println("Check other users");
					break;
				} else {
					System.out.println("login failed");
				}
			case "patient":
				System.out.println("Passed");
				break;
	    }
	   }
}

package stepDefinition;

import org.openqa.selenium.WebDriver;

import com.puregenomics.at.testcases.P_Recommendation_cases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Recommendation_Execution {
	
	public WebDriver driver;

	public Recommendation_Execution() throws Exception 
	{
		driver = Hooks.driver;
		
	}
	
	@Given("^Navigate to report$")
	public void navigate_to_report() {
		P_Recommendation_cases recommend = new P_Recommendation_cases();
		recommend.patient_dashboard();
		recommend.navigate_to_report();
	}

	@When("^Validate the recommendation in Report$")
	public void validate_the_recommendation_in_Report() {
		P_Recommendation_cases recommend = new P_Recommendation_cases();
		recommend.supplement_recommendation();
	}

	@When("^Navigate to Supplement recommendation$")
	public void navigate_to_Supplement_recommendation() {
		P_Recommendation_cases recommend = new P_Recommendation_cases();
		recommend.navigate_to_Personalized();

	}

	@Then("^Verify the supplement list \"([^\"]*)\"$")
	public void verify_the_supplement_list(String arg1)  {
		P_Recommendation_cases recommend = new P_Recommendation_cases();
		recommend.personalized_recommendations();  
	}

}

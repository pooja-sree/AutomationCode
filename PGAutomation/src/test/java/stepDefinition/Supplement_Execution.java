package stepDefinition;

import org.openqa.selenium.WebDriver;

import com.puregenomics.at.testcases.Catalog_cases;
import com.puregenomics.at.testcases.Customize_cases;
import com.puregenomics.at.testcases.Recommendation_cases;
import com.puregenomics.at.testcases.Review_cases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Supplement_Execution {
	public WebDriver driver;

	public Supplement_Execution() throws Exception 
	{
		driver = Hooks.driver;
		
	}	
	
	@Given("^Navigat to patientlist \"([^\"]*)\"$")
	public void navigate_to_patientlist(String search) throws Throwable {
		Recommendation_cases recommend = new Recommendation_cases();
		recommend.navigate_to_patientlist();
		recommend.search_patient(search);
	}
	

	@When("^Navigate to Supplement Suggestion$")
	public void navigate_to_Supplement_Suggestion() throws Throwable {
		Recommendation_cases recommend = new Recommendation_cases();
		recommend.Supplement_report();
		recommend.Navigate_to_supplement();
		recommend.Supplement_list();
		recommend.get_snps();
		recommend.add_supplement_suggestions();
	    
	}
	
	@When("^Add Supplement and navigate to catalog$")
	public void add_Supplement_and_navigate_to_catalog() throws Throwable {
		Catalog_cases catalog = new Catalog_cases();
		catalog.navigate_to_catalog();
		catalog.search_supplement();
	}

	@When("^Add Supplement and navigate to Customize$")
	public void add_Supplement_and_navigate_to_Customize() throws Throwable {
		Customize_cases custom = new Customize_cases();
		custom.navigate_to_customize();

	}

	@When("^Customize the supplements and navigate to review$")
	public void customize_the_supplements_and_navigate_to_review() throws Throwable {
		Review_cases review = new Review_cases();
		review.navigate_to_review();
	    
	}

	@When("^Send recommendation to the patient$")
	public void send_recommendation_to_the_patient() throws Throwable {
		Review_cases review = new Review_cases();
		review.send_to_patient();
	}

	@Then("^verify recommendation sent to the patient$")
	public void verify_recommendation_sent_to_the_patient() throws Throwable {
		Review_cases review = new Review_cases();
		review.verify_sent_message();
	}
	
}

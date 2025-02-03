package stepDefinition;

import org.openqa.selenium.WebDriver;

import com.puregenomics.at.testcases.Genetic_cases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class GeneticUpload_Execution {
	public WebDriver driver;

	public GeneticUpload_Execution() throws Exception 
	{
		driver = Hooks.driver;
		
	}
	
	@Given("^Navigate to Genetic screen in patient$") 
		public void navigate_to_Genetic_screen_in_patient() throws Throwable {
			Genetic_cases genetics = new Genetic_cases();
			genetics.Navigate_to_genetics_in_patient();;
		}	
	
	@When("^Navigate to Genetic upload screen$")
	public void navigate_to_Genetic_upload_screen() throws Throwable {
		Genetic_cases genetics = new Genetic_cases();
		genetics.navigate_geneticscreen();
	}

	@When("^Add genetic file and Upload \"([^\"]*)\"$")
	public void add_genetic_file_and_Upload(String upload) throws Throwable {
		Genetic_cases genetics = new Genetic_cases();
		genetics.upload_genetic_file(upload);
	}

	@Then("^Verify Report generated$")
	public void verify_Report_generated() throws Throwable {
		Genetic_cases genetics = new Genetic_cases();
		genetics.verify_report();
	}

}

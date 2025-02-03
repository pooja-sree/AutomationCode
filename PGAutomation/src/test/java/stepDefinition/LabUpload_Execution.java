package stepDefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.puregenomics.at.testcases.Lab_cases;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LabUpload_Execution {
	public WebDriver driver;

	public LabUpload_Execution() throws Exception 
	{
		driver = Hooks.driver;
		
	}
	
	@Given("^Navigate to Lab file$")
	public void navigate_to_Lab_file(DataTable data) {
	   List<List<String>> search = data.raw();
	   Lab_cases lab = new Lab_cases();
	   lab.navigate_to_patientlist();
	   lab.search_patient(search);
	   lab.navigate_to_labscreen();
	}

	@When("^Upload lab file$")
	public void upload_lab_file() throws Exception {
		Lab_cases lab = new Lab_cases();
		lab.labfile_upload();

	}

	@Then("^Verify Report$")
	public void verify_Report(DataTable data)  {
		List<List<String>> search = data.raw();
		Lab_cases lab = new Lab_cases();
		lab.search_patient(search);
		lab.verify_labstatus();
	}

}

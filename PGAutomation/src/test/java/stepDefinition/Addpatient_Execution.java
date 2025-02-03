package stepDefinition;

import org.openqa.selenium.WebDriver;

import com.puregenomics.at.testcases.Add_Patient_cases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Addpatient_Execution {
	
	public WebDriver driver;

	public Addpatient_Execution() throws Exception 
	{
		driver = Hooks.driver;
		
	}
	
	@Given("^Navigate to Add patient page$")
	public void navigate_to_Add_patient_page() {
		Add_Patient_cases patient = new Add_Patient_cases();
		patient.navigate_to_addpatient();
	}
	
	@When("^Select patient type \"([^\"]*)\"$")
	public void select_patient_type(String patient_type) {
		Add_Patient_cases patient = new Add_Patient_cases();
		patient.verify_and_select_patient_type(patient_type);
	}

	@When("^Enter patient details$")
	public void enter_patient_details() throws Exception {
		Add_Patient_cases patient = new Add_Patient_cases();
		patient.patient_details();
	
	}
	
	@When("^Select Genetic \"([^\"]*)\"  Questionnaire \"([^\"]*)\" and Lab upload \"([^\"]*)\"$")
	public void select_Genetic_Questionnaire_and_Lab_upload(String gene, String ques, String lab) {
		Add_Patient_cases patient = new Add_Patient_cases();
		patient.select_GQL(gene, ques, lab);
	}

	@When("^Verify Genetic Questionnaire and Lab upload \"([^\"]*)\"$")
	public void verify_Genetic_Questionnaire_and_Lab_upload(String GQL) {
		Add_Patient_cases patient = new Add_Patient_cases();
		patient.verify_GQL(GQL);
	}
	
	@Then("^Create patient$")
	public void create_patient() {
		Add_Patient_cases patient = new Add_Patient_cases();
		patient.confirm_patient();
	}
	
	@Then("^Verify added patient in patient list \"([^\"]*)\"$")
	public void verify_added_patient_in_patient_list(String patient_type) throws Exception  {
		Add_Patient_cases patient = new Add_Patient_cases();
		patient.verify_patient(patient_type);
	}
	
	@Then("^Validate the patient status$")
	public void validate_the_patient_status() {
		Add_Patient_cases patient = new Add_Patient_cases();
		patient.patient_status();
	}
	
	
	@Then("^Send Reminder and validate mail sent$")
	public void send_reminder_and_validate_mail_sent() {
		Add_Patient_cases patient = new Add_Patient_cases();
		patient.send_reminder();
	}
	
	@Then("Verify added patient in another domain") 
	public void verify_added_patient_in_another_domain() throws Exception{
		Add_Patient_cases patient = new Add_Patient_cases();
		patient.verify_another_domain();
	}
	
}

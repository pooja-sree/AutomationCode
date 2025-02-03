package stepDefinition;


import org.openqa.selenium.WebDriver;

import com.puregenomics.at.testcases.Questionnaire_cases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class Questionnaire_Execution {
	public WebDriver driver;

	public Questionnaire_Execution() throws Exception 
	{
		driver = Hooks.driver;
		
	}
	
	@Given("^Navigate to Questionnaire$")
	public void navigate_to_Questionnaire() {
		Questionnaire_cases question = new Questionnaire_cases();
		question.questionnaire_screen();
		
	}

	@When("^Compete the Questionnaire$")
	public void compete_the_Questionnaire() throws Exception {
		Questionnaire_cases question = new Questionnaire_cases();
		question.welcome_question();
		question.dob_question();
		question.gender_question();
		question.race_question();
		question.ethnicity_questions();
		question.living_question();
		question.sunExposure_question();
		question.healthconcern_questions();
		question.allergies_questions();
		question.sleep_questions();
		question.exercise_questions();
		question.nutrientDiet_questions();
		question.caffeineConsumption();
		question.alcohol_questions();
		question.smoking_questions();
		question.environmental_questions();
		question.stress_questions();
		question.mood_questions();
		question.focus_questions();
		question.addictiveRisk_questions();
		question.energy_questions();
		question.immune_quesitons();
		question.cognitive_questions();
		question.cardiovascular_questions();
		question.gastorintertinal_questions();
		question.metabolic_questions();
		question.medication_questions();
		question.supplement_questions();
	}
	
	@When("^Review the Questionnaire$")
	public void review_the_Questionnaire() throws Exception {
		Questionnaire_cases question = new Questionnaire_cases();
		question.review();
	}

	@Then("^Verify data in Report$")
	public void verify_data_in_Report() throws Exception {
		Questionnaire_cases question = new Questionnaire_cases();
		question.validate_report();
	}
}

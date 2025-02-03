package com.puregenomics.at.pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Questionnaire_Elements {
	public WebDriver driver;
	
	public Questionnaire_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(how = How.XPATH, using="//*[contains(text(), 'Start Questionnaire')]")
	protected WebElement start_questionnaire;
	
	public WebElement click_start_ques() {
		return start_questionnaire;
		
	}
	
	@FindBy(how = How.XPATH, using="//*[contains(text(), 'Skip Questionnaire')]")
	protected WebElement skip_questionnaire;
	
	public WebElement skip_start_ques() {
		return skip_questionnaire;
		
	}
	
	@FindBy(how = How.XPATH, using="//*[contains(text(), 'Update Questionnaire')]")
	protected WebElement update_questionnaire;
	
	
	public WebElement click_update_ques() {
		return update_questionnaire;
		
	}
	
	@FindBy(how = How.XPATH, using="//*[contains(text(), 'Questionnaire')]")
	protected WebElement title_questionnaire;
	
	public WebElement get_quesitionnaire() {
		return title_questionnaire;
		
	}
	
	@FindAll(@FindBy(how = How.XPATH, using = "//*[@class='talktext']"))
	protected List<WebElement> get_questions;
	
	public List<WebElement> get_questions_text() {
		return get_questions;
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@class='pg-text']")
	protected WebElement btn_ans;
	
	public WebElement click_answers() {
		return btn_ans;		
	}
	
	@FindAll(@FindBy(how = How.XPATH, using = "//*[@class='pg-text']"))
	protected List<WebElement> quest_ans;
	
	public List<WebElement> get_ans(){
		return quest_ans;	
	}
	
	@FindBy(how=How.XPATH, using = "//input[@placeholder='Click to select a date']")
	protected WebElement date_field;
	
	public WebElement enter_date() {
		return date_field;	
	}
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"7Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_sun;
	
	public WebElement click_sun_yes() {
		return yes_sun;
		
	}
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"8Container\"]/div/div[2]/div[1]/input")
	protected WebElement health_text;
	
	public WebElement enter_hc() {
		return health_text;
		
	}
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"9Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_allergy;
	
	public WebElement click_yes_allergy() {
		return yes_allergy;
		
	}
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"11Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_sleep;
	
	public WebElement click_yes_sleep() {
		return yes_sleep;
		
	}
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"11Container\"]/div/div[2]/div/div[3]/div/p")
	protected WebElement no_sleep;
	
	public WebElement click_no_sleep() {
		return no_sleep;
		
	}
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"14Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_soreness;
	
	public WebElement click_yes_soreness() {
		return yes_soreness;
		
	}
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"15Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_sports;
	
	public WebElement click_yes_sports() {
		return yes_sports;
		
	}
	

	@FindBy(how=How.XPATH, using = "//*[@id=\"20Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_skippingmeals;
	
	public WebElement click_yes_meals() {
		return yes_skippingmeals;
		
	}
	

	@FindBy(how=How.XPATH, using = "//*[@id=\"24Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_consumes;
	
	public WebElement click_yes_consumes() {
		return yes_consumes;
		
	}
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"25Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_alcohol;
	
	public WebElement click_yes_alcohol() {
		return yes_alcohol;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"27Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_drugs;
	
	public WebElement click_yes_drugs() {
		return yes_drugs;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"28Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_smoker;
	
	public WebElement click_yes_smoker() {
		return yes_smoker;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"28Container\"]/div/div[2]/div/div[3]/div/p")
	protected WebElement no_smoker;
	
	public WebElement click_no_smoker() {
		return no_smoker;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"29Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_secondsmoker;
	
	public WebElement click_yes_secondsmoker() {
		return yes_secondsmoker;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"29Container\"]/div/div[2]/div/div[3]/div/p")
	protected WebElement no_secondsmoker;
	
	public WebElement click_no_secondsmoker() {
		return no_secondsmoker;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"32Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_pressure;
	
	public WebElement click_yes_pressure() {
		return yes_pressure;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"32Container\"]/div/div[2]/div/div[3]/div/p")
	protected WebElement no_pressure;
	
	public WebElement click_no_pressure() {
		return no_pressure;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"33Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_relation;
	
	public WebElement click_yes_relation() {
		return yes_relation;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"33Container\"]/div/div[2]/div/div[3]/div/p")
	protected WebElement no_relation;
	
	public WebElement click_no_relation() {
		return no_relation;
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"35Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_focus;
	
	public WebElement click_yes_focus() {
		return yes_focus;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"35Container\"]/div/div[2]/div/div[3]/div/p")
	protected WebElement no_focus;
	
	public WebElement click_no_focus() {
		return no_focus;
	}
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"42Container\"]/div/div[2]/div[1]/input")
	protected WebElement height_text;
	
	public WebElement enter_height() {
		return height_text;
		
	}
	
	@FindBy(how=How.XPATH, using = "//*[@id=\"43Container\"]/div/div[2]/div[1]/input")
	protected WebElement weight_text;
	
	public WebElement enter_weight() {
		return weight_text;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"46Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_medication;
	
	public WebElement click_yes_medication() {
		return yes_medication;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"46Container\"]/div/div[2]/div/div[3]/div/p")
	protected WebElement no_medication;
	
	public WebElement click_no_medication() {
		return no_medication;
	
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"48Container\"]/div/div[2]/div/div[2]/div/p")
	protected WebElement yes_supplements;
	
	public WebElement click_yes_supplements() {
		return yes_supplements;
		
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"48Container\"]/div/div[2]/div/div[3]/div/p")
	protected WebElement no_supplements;
	
	public WebElement click_no_supplements() {
		return no_supplements;
	
	}
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'OK')]")
	protected WebElement btn_OK;
	
	public WebElement click_ok() {
		return btn_OK;	
	}
	
	@FindBy(how=How.XPATH, using="//*[contains(text(),'Review your answers')]")
	protected WebElement review_text;
	
	public WebElement get_review_text() {
		return review_text;
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Confirm')]")
	protected WebElement btn_confirm;
	
	public WebElement click_confirm() {
		return btn_confirm;	
	}
	

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'THANK YOU')]")
	protected WebElement thank_you;
	
	public WebElement verify_questuploading() {
		return thank_you;	
	}
	
	
}

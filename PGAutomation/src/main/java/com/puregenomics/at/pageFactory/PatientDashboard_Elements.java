package com.puregenomics.at.pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PatientDashboard_Elements {
	public WebDriver driver;

	public PatientDashboard_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using= "//*[contains(text(), 'Get Started Now')]")
	protected WebElement btn_getstarted;
	
	public WebElement click_getstarted() {
		return btn_getstarted;
		
	}
	
	@FindBy(how = How.XPATH, using= "//button[@class='btn btn-outline__p px-5 w-100 textc-primary mt-3 mt-lg-0']")
	protected WebElement btn_gotodash;
	
	public WebElement click_gotodash() {
		return btn_gotodash;
		
	}
	
	@FindBy(how = How.XPATH, using="//*[contains(text(), 'Completed')]")
	protected WebElement status_ques;
	
	public WebElement get_ques_status() {
		return status_ques;
		
	}
	

	@FindBy(how=How.XPATH, using = "//*[contains(text(), 'Personalized Report')]")
	protected WebElement patient_dash;
	
	public WebElement get_patientwelcome() {
		return patient_dash;
		
	}
	
	@FindBy(how=How.XPATH, using = "//*[contains(text(), 'View Report')]")
	protected WebElement btn_report;
	
	public WebElement click_viewReport() {
		return btn_report;
		
	}
	
	@FindBy(how=How.XPATH, using= "//*[contains(text(), 'Supplement Recommendations')]")
	protected WebElement txt_supplement;
	
	public WebElement text_SupplementRecommendations() {
		return txt_supplement;
		
	}
	
	@FindBy(how=How.XPATH, using = "//*[@class='row justify-content-center my-4']/div/div[1]")
	protected List<WebElement> supplements_report;
	
	public List<WebElement> supplement_recommendation_report() {
		return supplements_report;
		
	}
	
	@FindBy(how=How.XPATH, using= "//*[contains(text(), 'View Recommendation Details')]")
	protected WebElement btn_recommendations;
	
	public WebElement click_view_recommendations() {
		return btn_recommendations;		
		
	}
	
	
	
	
	
}

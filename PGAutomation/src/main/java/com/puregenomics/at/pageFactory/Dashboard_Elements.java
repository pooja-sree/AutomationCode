package com.puregenomics.at.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Elements {
	public WebDriver driver;

	
	public Dashboard_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[1]")
	protected WebElement patient_title;
	
	public WebElement get_patients_text() {
		return patient_title;
		
	}
	
	@FindBy(how = How.XPATH, using="//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]")
	protected WebElement recent_activity;
	
	public WebElement get_recent_activity() {
		return recent_activity;
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/button[1]")
	protected WebElement button_getStarted;
	
	public WebElement click_getStarted() {
		return button_getStarted;
		
	}

	@FindBy(how = How.XPATH, using="//*[@id='add-patient-btn__dashboard']")
	protected WebElement addpatient_button;
	
	public WebElement click_addpatient() {
		return addpatient_button;
		
	}
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]")
	protected WebElement addpatient_message;
	
	public WebElement get_addpatient_message() {
		return addpatient_message;
		
	}
	
	@FindBy(how = How.XPATH, using="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[1]/div[1]")
	protected WebElement patients_text;
	
	public WebElement get_patients_title() {
		return patients_text;
		
	}
	
	
	@FindBy(how = How.XPATH, using="//*[@id=\"root\"]/div/div[2]/div[3]/div/div/div[1]")
	protected WebElement welcome;
	
	public WebElement get_welcome() {
		return welcome;
		
	}
	
	@FindBy(how = How.ID, using="view-patient-btn__dashboard") 
	protected WebElement view_patient;
	
	public WebElement click_view_patient() {
		return view_patient;
		
	}

}

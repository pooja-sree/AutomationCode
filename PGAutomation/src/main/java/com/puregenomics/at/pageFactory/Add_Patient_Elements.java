package com.puregenomics.at.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Add_Patient_Elements {
	public WebDriver driver;

	public Add_Patient_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.ID, using = "radio__newpatient")
	protected WebElement real_patient;
	
	public WebElement select_realpatient() {
		return real_patient;
		
	}
	
	@FindBy(how = How.ID, using = "radio__myself__label")
	protected WebElement add_myself_patient;
	
	public WebElement select_myself_patient() {
		return add_myself_patient;
		
	}
	
	@FindBy(how = How.ID, using = "radio__testpatient__label")
	protected WebElement add_test_patient;
	
	public WebElement select_test_patient() {
		return add_test_patient ;
		
	}
	
	@FindBy(how = How.ID, using = "f-name__addpatient")
	protected WebElement patient_firstname;
	
	public WebElement enter_patient_firstname() {
		return patient_firstname;
		
	}
	
	@FindBy(how = How.ID, using = "l-name__addpatient")
	protected WebElement patient_lastname;
	
	public WebElement enter_patient_lastname() {
		return patient_lastname;
		
	}
	
	@FindBy(how = How.ID, using = "email-input__addpatient")
	protected WebElement email_patient;
	
	public WebElement enter_email_patient() {
		return email_patient;
		
	}
	
	@FindBy(how = How.ID, using = "age__addpatient")
	protected WebElement patient_age;
	
	public WebElement enter_patient_age() {
		return patient_age;
		
	}
	
	@FindBy(how = How.XPATH, using="//*[@id=\"gender__addpatient\"]/div[1]/i")
	protected WebElement patient_gender;
	
	public WebElement click_patient_gender() {
		return patient_gender;
		
	}
	
	@FindBy(how = How.ID, using = "select-option__Male")
	protected WebElement gender_male;
	
	public WebElement click_gender_male() {
		return gender_male;
	}
	
	@FindBy(how = How.ID, using = "select-option__Female")
	protected WebElement gender_female;
	
	public WebElement click_gender_female() {
		return gender_female;
		
	}
	
	@FindBy(how = How.ID, using = "select-option__Intersex")
	protected WebElement gender_intersex;
	
	public WebElement click_gender_intersex() {
		return gender_female;
		
	}
	
	@FindBy(how = How.ID, using="selected-item")
	protected WebElement get_gender;
	
	public WebElement get_selected_gender() {
		return get_gender;
		
	}
	
	@FindBy(how = How.XPATH, using="//*[@id=\"root\"]/div/div[2]/div[2]/form/div[3]/div[1]")
	protected WebElement genetic_text;
	
	public WebElement get_genetics() {
		return genetic_text;
		
	}
	
	
	@FindBy(how = How.ID, using = "radio-genetics__patient")
	protected WebElement patient_upload;
	
	public WebElement select_patient_upload() {
		return patient_upload;
		
	}
	
	@FindBy(how = How.ID, using = "radio-genetics__practice")
	protected WebElement practitioner_upload;
	
	public WebElement select_practitioner_upload() {
		return practitioner_upload;
		
	}
	
	@FindBy(how = How.ID, using = "checkbox-questionnare")
	protected WebElement invite_questionnaire;
	
	public WebElement check_questionnaire() {
		return invite_questionnaire;
		
	}
	
	@FindBy(how = How.ID, using ="checkbox-lab__practice")
	protected WebElement Lab_upload;
	
	public WebElement check_labUpload() {
		return Lab_upload;
		
	}
	
	@FindBy(how = How.ID, using = "checkbox-savesetting__cb")
	protected WebElement save_settings;
	
	public WebElement check_save_settngs() {
		return save_settings;
		
	}
	
	@FindBy(how = How.ID, using = "cancel-btn__addpatient")
	protected WebElement cancel_button;
	
	public WebElement click_cancel_button() {
		return cancel_button;
		
	}
	
	@FindBy(how = How.ID, using = "done-btn__addpatient")
	protected WebElement done_button;
	
	public WebElement click_done_button() {
		return done_button;
		
	}
}

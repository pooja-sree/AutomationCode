package com.puregenomics.at.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Patientlist_Elements {
	public WebDriver driver;

	public Patientlist_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.ID, using="search-patient__patientlist")
	protected WebElement search_patient;
	
	public WebElement search_field() {
		return search_patient;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[4]/div[2]/div[1]/div[2]/div/div[5]/button")
	protected WebElement btn_viewreport;
	
	public WebElement click_viewreport() {
		return btn_viewreport;
	}
	
	//*[@id="root"]/div/div[2]/div[2]/div/div[4]/div[2]/div[1]/div[2]/div/div[1]
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div[3]/div/div[4]/div[2]/div[1]/div[2]/div/div[1]")
	protected WebElement get_name;
	
	public WebElement check_patient_name() {
		return get_name;
		
	}
	
	@FindBy(how = How.XPATH, using="//*[@id=\"root\"]/div/div[2]/div[2]/div/div[4]/div[2]/div[1]/div[2]/div/div[1]")
	protected WebElement patient_name;
	
	public WebElement get_patient_name() {
		return patient_name;
	}
	
	@FindBy(how = How.XPATH, using="//*[contains(text(), 'No Patient Found')]")
	protected WebElement no_result;
	
	public WebElement get_no_result() {
		return no_result;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div[3]/div/div/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/span")
	protected WebElement get_status;
	
	public WebElement patient_status() {
		return get_status;
		
	}
	
	
	@FindBy(how = How.XPATH, using="//*[@id=\"root\"]/div/div[2]/div[3]/div/div/div[4]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]")
	protected WebElement send_reminder;
	
	public WebElement click_sendreminder() {
		return send_reminder;
		
	}
	
	@FindBy(how = How.XPATH, using="//i[@class='fa fa-chevron-right transition-all my-auto cursor-pointer']")
	protected WebElement expand_arrow;
	
	public WebElement click_expand() {
		return expand_arrow;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Start Upload')]")
	protected WebElement start_upload;
	
	public WebElement click_upload() {
		return start_upload;
		
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[4]/div[2]/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div[3]")
	protected WebElement update_genetic;
	
	public WebElement click_upload_another() {
		return update_genetic;
		
	}

	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[4]/div[2]/div[1]/div[2]/div[2]/div[2]/div[3]/div[3]/div[3]")
	protected WebElement lab_upload;
	
	public WebElement click_labupload() {
		return lab_upload;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[4]/div[2]/div[1]/div[2]/div[2]/div[2]/div[3]/div[3]/div[2]")
	protected WebElement lab_status;
	
	public WebElement get_labStatus() {
		return lab_status;
		
	}
	
	@FindBy(how = How.XPATH, using="//*[@id=\"root\"]/div/div[1]/div/div/div[2]")
	protected WebElement toast_msg;
	
	public WebElement get_mailsent(){
		return toast_msg;
		
	}
}

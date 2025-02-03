package com.puregenomics.at.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Lab_Elements {
	
	public WebDriver driver;

	public Lab_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Upload Lab Data')]")
	protected WebElement lab_screen;
	
	public WebElement get_labtitle() {
		return lab_screen;
		
	}
	
	@FindBy(how = How.ID, using = "snp-file")
	protected WebElement snp_file;
	
	public WebElement upload_labfile() {
		return snp_file;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div/div[4]/button")
	protected WebElement btn_startupload;
	
	public WebElement click_startupload() {
		return btn_startupload;
		
	}
	
	@FindBy(how = How.CLASS_NAME, using = "progress")
	protected WebElement progress_bar;
	
	public WebElement get_progress() {
		return progress_bar;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'SOMETHING GOOD IS COMING YOUR WAY!')]")
	protected WebElement labfile_header;
	
	public WebElement verify_labUploading() {
		return labfile_header;
		
	}

	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Lab Results')]")
	protected WebElement lab_result;
	
	public WebElement lab_resultscreen() {
		return lab_result;
		
	}
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Confirm')]")
	protected WebElement btn_confirm;
	
	public WebElement click_confirm() {
		return btn_confirm;	
	}
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Thank you')]")
	protected WebElement thank_pop;
	
	public WebElement thank_pop() {
		return thank_pop;
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'OK')]")
	protected WebElement btn_ok;
	
	public WebElement click_ok() {
		return btn_ok;
		
	}
	
	


}

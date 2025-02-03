package com.puregenomics.at.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Genetic_Elements {
	public WebDriver driver;

	public Genetic_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Upload Genetics File')]")
	protected WebElement Upload_genetics;
	
	public WebElement upload_Genetics() {
		return Upload_genetics;

	}
	
	@FindBy(how = How.ID, using = "snp-file")
	protected WebElement snp_file;
	
	public WebElement upload_snpfile() {
		return snp_file;
		
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='my-4']/button")
	protected WebElement startUpload_btn;
	
	public WebElement click_startUpload() {
		return startUpload_btn;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'SOMETHING GOOD IS COMING YOUR WAY!')]")
	protected WebElement genetic_header;
	
	public WebElement verify_geneticUploading() {
		return genetic_header;
		
	}
	
	@FindBy(how = How.CLASS_NAME, using = "progress")
	protected WebElement progress_bar;
	
	public WebElement get_progress() {
		return progress_bar;
		
	}
	
}

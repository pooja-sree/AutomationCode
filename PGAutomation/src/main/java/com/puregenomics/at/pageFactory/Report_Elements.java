package com.puregenomics.at.pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Report_Elements {
	public WebDriver driver;

	public Report_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='pg-title py-3']")
	protected WebElement report_summary;
	
	public WebElement get_reportSummary_title() {
		return report_summary;
		
	}
	
	@FindBy(how =How.XPATH, using = "//*[@id=\"report_summary\"]/div[1]/div/div/div/div[3]/div[2]")
	protected WebElement status_questionnaire;
	
	public WebElement get_quest_status() {
		return status_questionnaire;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"report_summary\"]/div/div[3]/div/div[1]")
	protected WebElement supplement_suggestions;
	
	public WebElement get_suggestion_text() {
		return supplement_suggestions;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@class='row justify-content-center my-4']/div/div[1]")
	protected List<WebElement> supplements_report;
	
	public List<WebElement> get_supplements_report() {
		return supplements_report;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'View & Edit Suggestions')]")
	protected WebElement btn_viewedit;
	
	public WebElement click_viewedit_suggestions() {
		return btn_viewedit;
		
	}
	
}

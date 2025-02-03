package com.puregenomics.at.pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PatientReport_Elements {
	public WebDriver driver;

	public PatientReport_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='pg-title py-3']")
	protected WebElement report_summary;
	
	public WebElement get_reportSummary_title() {
		return report_summary;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"report_summary\"]/div/div[2]/div/div[1]")
	protected WebElement supplement_recommendations;
	
	public WebElement get_supplement_recommendation() {
		return supplement_recommendations;
		
	}
		
	@FindBy(how = How.XPATH, using = "//*[@class='row justify-content-center my-4']/div/div[1]")
	protected List<WebElement> recommendations_report;
	
	public List<WebElement> get_supplements_report() {
		return recommendations_report;
	}
	
	//*[@id="report_summary"]/div/div[2]/div/div[4]/button
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"report_summary\"]/div/div[2]/div/div[4]/button")
	protected WebElement btn_view_recommendations;
	
	public WebElement click_view_recommendations() {
		return btn_view_recommendations;
		
	}
	

}

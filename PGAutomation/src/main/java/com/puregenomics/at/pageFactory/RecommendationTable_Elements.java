package com.puregenomics.at.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RecommendationTable_Elements {
		public WebDriver driver;

	public RecommendationTable_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using="//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div[2]/h1")
	protected WebElement send_message;
	
	public WebElement get_supplement_recommendation() {
		return send_message;
		
	}

}

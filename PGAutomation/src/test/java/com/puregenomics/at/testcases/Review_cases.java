package com.puregenomics.at.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.puregenomics.at.dataprovider.ConfigFileReader;
import com.puregenomics.at.pageFactory.Customize_Elements;
import com.puregenomics.at.pageFactory.RecommendationTable_Elements;
import com.puregenomics.at.pageFactory.Review_Elements;
import com.puregenomics.at.pageFactory.SmartSearch_Elements;


public class Review_cases extends BaseClass {
	
	private Logger log = Logger.getLogger(Review_cases.class);
	ConfigFileReader config = new ConfigFileReader();
	SmartSearch_Elements catalog = new SmartSearch_Elements(driver);
	Customize_Elements customize = new Customize_Elements(driver);
	Review_Elements review = new Review_Elements(driver);
	RecommendationTable_Elements sent = new RecommendationTable_Elements(driver);
	
	
	public void navigate_to_review() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", customize.click_next_top());
		log.info("Clicking next button to navigate review screeen");
		Assert.assertTrue(review.click_sendscript_top().isDisplayed());
		log.info("Review screen is loaded successfully");
		Thread.sleep(2000);
	}
	
	public void send_to_patient() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", review.click_sendscript_top());
		log.info("Recommendation send to the patient successfully");
		Thread.sleep(2000);
	}
	
	public void verify_sent_message() {
		Assert.assertTrue(sent.get_supplement_recommendation().isDisplayed());
		System.out.println(sent.get_supplement_recommendation().getText());
		log.info("Practitioner sent recommendation to the patient successfully");
	}
}

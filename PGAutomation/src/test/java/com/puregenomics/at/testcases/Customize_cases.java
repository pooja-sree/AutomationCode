package com.puregenomics.at.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.puregenomics.at.dataprovider.ConfigFileReader;
import com.puregenomics.at.pageFactory.Customize_Elements;
import com.puregenomics.at.pageFactory.SmartSearch_Elements;


public class Customize_cases extends BaseClass{
	private Logger log = Logger.getLogger(Customize_cases.class);
	ConfigFileReader config = new ConfigFileReader();
	SmartSearch_Elements catalog = new SmartSearch_Elements(driver);
	Customize_Elements customize = new Customize_Elements(driver);
	
	
	public void navigate_to_customize() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,0)");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", catalog.navigate_to_cScript());
		log.info("Clicking next button to navigate customize screen");
		Assert.assertTrue(customize.click_quantity().isDisplayed());
		log.info("Customize screen is loaded successfully");
		Thread.sleep(2000);
	}
	
}

package com.puregenomics.at.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.puregenomics.at.dataprovider.ConfigFileReader;
import com.puregenomics.at.pageFactory.Customize_Elements;
import com.puregenomics.at.pageFactory.SmartSearch_Elements;
import com.puregenomics.at.pageFactory.Suggestion_Elements;


public class Catalog_cases extends BaseClass {
	private Logger log = Logger.getLogger(Catalog_cases.class);
	ConfigFileReader config = new ConfigFileReader();
	Suggestion_Elements suggest = new Suggestion_Elements(driver);
	SmartSearch_Elements catalog = new SmartSearch_Elements(driver);
	Customize_Elements customize = new Customize_Elements(driver);

	
	public void navigate_to_catalog() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,0)");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", suggest.click_next_top());
		log.info("Clicking next button to navigate catalog screen");		
		Assert.assertTrue(catalog.enter_search().isDisplayed());
		log.info("Navigated to catalog screen successfully");		
		Thread.sleep(2000);
	}
	
	public void search_supplement() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		catalog.enter_search().sendKeys("Relora");
		log.info("Searching the supplement");
		catalog.enter_search().sendKeys(Keys.ENTER);
		WebElement supplement = driver.findElement(By.xpath("//*[contains(text(), 'Relora')]"));
		Assert.assertTrue(supplement.isDisplayed());
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", catalog.add_supplement());	
		log.info("Added searched supplement");
		Thread.sleep(2000);
	}
	

}

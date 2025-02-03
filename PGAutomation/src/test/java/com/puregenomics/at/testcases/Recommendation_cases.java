package com.puregenomics.at.testcases;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.puregenomics.at.dataprovider.ConfigFileReader;
import com.puregenomics.at.pageFactory.Dashboard_Elements;
import com.puregenomics.at.pageFactory.Patientlist_Elements;
import com.puregenomics.at.pageFactory.Report_Elements;
import com.puregenomics.at.pageFactory.Suggestion_Elements;


public class Recommendation_cases extends BaseClass {
	private Logger log = Logger.getLogger(Recommendation_cases.class);
	ConfigFileReader config = new ConfigFileReader();
	Report_Elements report = new Report_Elements(driver);
	Suggestion_Elements suggest = new Suggestion_Elements(driver);
	Patientlist_Elements list = new Patientlist_Elements(driver);
	Dashboard_Elements dashboard = new Dashboard_Elements(driver);

	
	public void navigate_to_patientlist() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dashboard.click_view_patient());
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dashboard.click_view_patient()); 
		log.info("Navigate to patient list");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(list.search_field()));
	}
	
	public void search_patient(String search) {
		list.search_field().sendKeys(search);
	}
	
	public void Supplement_report() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		Assert.assertTrue(report.get_suggestion_text().isDisplayed());
		if(report.get_suggestion_text().getText().equals("SUPPLEMENT SUGGESTIONS")) {
			log.info("Supplement Suggestions are loaded in report");
			List<String> supplements_arraylist = new ArrayList<String>();
			int total_suggestion = report.get_supplements_report().size();
			log.info("Getting total size:" + total_suggestion);
			for(int i=0; i<total_suggestion;i++) 
			{
				supplements_arraylist.add(report.get_supplements_report().get(i).getText());
				log.info("Storing Supplement in array");
				System.out.println(report.get_supplements_report().get(i).getText());
			}
			System.out.println(supplements_arraylist);
			log.info("Printing Supplement arraylist: " +supplements_arraylist);

		} else if(report.get_suggestion_text().getText().equals("SUPPLEMENT RECOMMENDATIONS")) {
			log.info("Supplement is already recommended to the patient");
			List<String> supplements_arraylist = new ArrayList<String>();
			int total_suggestion = report.get_supplements_report().size();
			log.info("Getting total size:" + total_suggestion);
			for(int i=0; i<total_suggestion;i++) 
			{
				supplements_arraylist.add(report.get_supplements_report().get(i).getText());
				log.info("Storing Supplement in array");
				System.out.println(report.get_supplements_report().get(i).getText());
			}
			System.out.println(supplements_arraylist);
			log.info("Printing Supplement arraylist: " +supplements_arraylist);
		}
		
	}
	
	public void Navigate_to_supplement() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", report.click_viewedit_suggestions());
		log.info("Navigating to Rialto");
		driver.switchTo().frame("iFrameResizer0");
		log.info("Switch to iframe");
		Assert.assertTrue(suggest.get_suggestion_title().isDisplayed());
		log.info("Supplement Suggestions screen is loaded successfully");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void Supplement_list() {
		List<String> supplements_arraylist = new ArrayList<String>();
		int total_suggestion = suggest.get_suggestion_list().size();
		log.info("Getting total size:" + total_suggestion);
		for(int i=0; i<total_suggestion;i++) 
		{
			supplements_arraylist.add(suggest.get_suggestion_list().get(i).getText());
			log.info("Storing Supplement in array");
			System.out.println(suggest.get_suggestion_list().get(i).getText());
		}
		System.out.println(supplements_arraylist);
		log.info("Printing Supplement arraylist: " +supplements_arraylist);		
	}
	
	public void get_snps() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", suggest.click_view_by());
		//suggest.click_view_by().click();
		Assert.assertTrue(suggest.snps_tag().isDisplayed());
		log.info("SNPS tag is provided to filter the supplements");
		List<String> snps = new ArrayList<String>();
		int total_snps = suggest.get_snps_tag().size();
		log.info("Getting total count of:" + total_snps);
		for(int i=0;i<total_snps;i++) 
		{
			snps.add(suggest.get_snps_tag().get(i).getText());
			log.info("Storing SNP tag in array");
		}
		System.out.println(snps);
		log.info("Printing snps tags: "+ snps);
	}
	
	public void add_supplement_suggestions() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", suggest.click_addall());
		//suggest.click_addall().click();
		log.info("All supplements are added to the summary");
		Assert.assertTrue(suggest.get_summary_title().isDisplayed());
		log.info("Summary is enabled");
		
	}
}

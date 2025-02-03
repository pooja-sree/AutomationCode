package com.puregenomics.at.testcases;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.puregenomics.at.pageFactory.PatientDashboard_Elements;
import com.puregenomics.at.pageFactory.PatientReport_Elements;
import com.puregenomics.at.pageFactory.Personalized_Elements;


public class P_Recommendation_cases extends BaseClass {
	
	private Logger log = Logger.getLogger(P_Recommendation_cases.class);
	PatientDashboard_Elements patient = new PatientDashboard_Elements(driver);
	PatientReport_Elements p_report = new  PatientReport_Elements(driver);
	Personalized_Elements personalized = new Personalized_Elements(driver);
	
	public void patient_dashboard() {
		try {
			if(patient.click_gotodash().isDisplayed()) {
				WebElement element = patient.click_gotodash();
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				log.info("Navigate to patient dashboard");
				Thread.sleep(2000);
				Assert.assertTrue(patient.get_patientwelcome().isDisplayed());
				log.info("Patient dashboard is loaded successfully");
			} else if (patient.get_patientwelcome().isDisplayed()) {
					log.info("Patient dashboard is loaded successfully");
			} else {
					log.info("Patient is not logged in successfully");
			}
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void navigate_to_report() {
		try {
			
			if(patient.click_viewReport().isDisplayed()){
				WebElement report = patient.click_viewReport();
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				executor1.executeScript("arguments[0].click();", report);
				log.info("View Report button is clicked successfully");
				Assert.assertTrue(p_report.get_reportSummary_title().isDisplayed());
				log.info("Patient Report page is loaded successfully");
			} else {
				log.info("Genetic file is not uploaded for the patient");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void supplement_recommendation() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		Assert.assertTrue(p_report.get_supplement_recommendation().isDisplayed());
		if(p_report.get_supplement_recommendation().getText().equals("SUPPLEMENT RECOMMENDATIONS")) {
			log.info("Supplement is recommended to the patient");
			List<String> supplements_arraylist = new ArrayList<String>();
			int total_suggestion = p_report.get_supplements_report().size();
			log.info("Getting total size:" + total_suggestion);
			for(int i=0; i<total_suggestion;i++) 
			{
				supplements_arraylist.add(p_report.get_supplements_report().get(i).getText());
				log.info("Storing Supplement in array");
				System.out.println(p_report.get_supplements_report().get(i).getText());
			}
			System.out.println(supplements_arraylist);
			log.info("Printing Supplement arraylist: " +supplements_arraylist);
		} else {
			log.info("Supplement is not recommended by the practitioner");
		}
	}
	
	public void navigate_to_Personalized() {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", p_report.click_view_recommendations());
			log.info("Navigating to Rialto");
			Thread.sleep(8000);
			driver.switchTo().frame("iFrameResizer0");
			log.info("Switch to iframe");
			Assert.assertTrue(personalized.get_personalized_title().isDisplayed());	
			log.info("Personalzied Recommendation screen is loaded successfully");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void personalized_recommendations() {
		List<String> supplements_arraylist = new ArrayList<String>();
		int total_recommendation = personalized.get_supplement_list().size();
		log.info("Getting total size:" + total_recommendation);
		for(int i=0; i<total_recommendation;i++) 
		{
			supplements_arraylist.add(personalized.get_supplement_list().get(i).getText());
			log.info("Storing Supplement in array");
			System.out.println(personalized.get_supplement_list().get(i).getText());
		}
		System.out.println(supplements_arraylist);
		log.info("Printing Supplement arraylist: " +supplements_arraylist);
		driver.switchTo().defaultContent();
	}
	
	
}


package com.puregenomics.at.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.puregenomics.at.pageFactory.Genetic_Elements;
import com.puregenomics.at.pageFactory.PatientDashboard_Elements;
import com.puregenomics.at.pageFactory.Patientlist_Elements;
import com.puregenomics.at.pageFactory.Report_Elements;


public class Genetic_cases extends BaseClass {
	private Logger log = Logger.getLogger(Genetic_cases.class);
	Patientlist_Elements list = new Patientlist_Elements(driver);
	Genetic_Elements genetics = new Genetic_Elements(driver);
	Report_Elements report = new Report_Elements(driver);
	PatientDashboard_Elements p_dash = new PatientDashboard_Elements(driver);
	
	
	public void navigate_geneticscreen() throws Exception {
		//JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js1.executeScript("arguments[0].scrollIntoView();", list.click_expand());
		//Thread.sleep(2000);
		//list.click_expand().click();
		Thread.sleep(2000);
		if(list.click_upload().isDisplayed()) {
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", list.click_upload()); 
			//list.click_upload().click();
			log.info("Navigating to upload genetics file screen");
		}else if (list.click_upload_another().isDisplayed()){
			JavascriptExecutor executor2 = (JavascriptExecutor)driver;
			executor2.executeScript("arguments[0].click();", list.click_upload_another()); 
			//list.click_upload_another().click();
			log.info("Navigating to upload another genetics file screen");
		} else {
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", list.click_upload()); 
			log.info("Navigating to upload genetics file screen");
		}
		Assert.assertTrue(genetics.upload_Genetics().isDisplayed());
		log.info("Navigating to upload genetics file screen");
	}
	
	
	@SuppressWarnings("deprecation")
	public void upload_genetic_file(String filepath) throws Exception {
		genetics.upload_snpfile().sendKeys(filepath);
		log.info("Added genetic file");
		Thread.sleep(2000);
		WebElement element = genetics.click_startUpload();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		log.info("Genetic file uploading is started");
		Thread.sleep(2000);
		Assert.assertTrue(genetics.verify_geneticUploading().isDisplayed());
		log.info("genetic file is uploading");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(5000);
		Assert.assertTrue(genetics.get_progress().isDisplayed());
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(12, TimeUnit.MINUTES);
		wait.pollingEvery(90, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(report.get_reportSummary_title()));
		log.info("Genetic file upload is completed");
		/*WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(report.get_reportSummary_title()));
		wait.until(ExpectedConditions.invisibilityOf(genetics.get_progress()));
		log.info("Waiting to complete genetic upload progress bar")*/;
	}
	
	
	public void verify_report() {
		String report_actual = report.get_reportSummary_title().getText();
		log.info("Report summary screen is loaded: "+report_actual);
		String report_expected = "REPORT SUMMARY";
		Assert.assertEquals(report_actual, report_expected);
		log.info("Genetic file is uploaded and report is generated successfully");				
	}
	
	
	public void Navigate_to_genetics_in_patient() {
		p_dash.click_getstarted().click();
		log.info("Get started now button is clicked");
		Assert.assertTrue(genetics.upload_Genetics().isDisplayed());
		log.info("Navigating to upload genetics file screen");
	}


	
	
	
}

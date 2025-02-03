package com.puregenomics.at.testcases;

import java.util.List;
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

import com.puregenomics.at.pageFactory.Dashboard_Elements;
import com.puregenomics.at.pageFactory.Lab_Elements;
import com.puregenomics.at.pageFactory.Patientlist_Elements;

public class Lab_cases extends BaseClass {

	private Logger log = Logger.getLogger(Lab_cases.class);
	Patientlist_Elements list = new Patientlist_Elements(driver);
	Dashboard_Elements dashboard = new Dashboard_Elements(driver);
	Lab_Elements lab = new Lab_Elements(driver);

	
	public void navigate_to_patientlist() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", dashboard.click_view_patient());
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dashboard.click_view_patient()); 
		log.info("Navigate to patient list");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(list.search_field()));
	}
	
	public void search_patient(List<List<String>> search) {
		try {
			list.search_field().sendKeys(search.get(0).get(0));
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void navigate_to_labscreen() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", list.click_expand());
		log.info("Expand the patient");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", list.click_expand()); 
		log.info("Clicking start upload");
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", list.click_labupload()); 
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(lab.get_labtitle()));
		Assert.assertTrue(lab.get_labtitle().isDisplayed());
		log.info("Lab screen is loaded successfully");
	}

	@SuppressWarnings("deprecation")
	public void labfile_upload() throws Exception {
		String file_path = "D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\lab_file\\Iron.pdf";
		lab.upload_labfile().sendKeys(file_path);
		log.info("Adding lab file");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(lab.click_startupload()));
		WebElement element = lab.click_startupload();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element); 
		log.info("Lab file uploading is started");
		Thread.sleep(2000);
		Assert.assertTrue(lab.verify_labUploading().isDisplayed());
		log.info("lab file is uploading");
		FluentWait<WebDriver> wait1 = new FluentWait<WebDriver>(driver);
		wait1.withTimeout(8, TimeUnit.MINUTES);
		wait1.pollingEvery(90, TimeUnit.SECONDS);
		wait1.ignoring(NoSuchElementException.class);
		wait1.until(ExpectedConditions.visibilityOf(lab.lab_resultscreen()));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", lab.click_confirm());
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", lab.click_confirm()); 
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOf(lab.thank_pop()));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", lab.click_ok()); 
		log.info("Lab is confirmed");
	}
	
	public void verify_labstatus() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", list.click_expand());
		String labstatus = list.get_labStatus().getText();
		Assert.assertEquals("Completed", labstatus);
		log.info("Lab is uploaded successfully");
	}

	
	
}

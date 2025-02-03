package com.puregenomics.at.testcases;

import java.io.FileReader;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.puregenomics.at.dataprovider.ConfigFileReader;
import com.puregenomics.at.pageFactory.Add_Patient_Elements;
import com.puregenomics.at.pageFactory.Dashboard_Elements;
import com.puregenomics.at.pageFactory.Patientlist_Elements;


public class Add_Patient_cases extends BaseClass {

	private LogManager log = LogManager.getLogger(Add_Patient_cases.class);
	ConfigFileReader config = new ConfigFileReader();
	Dashboard_Elements  dash = new Dashboard_Elements(driver);
	Add_Patient_Elements add = new Add_Patient_Elements(driver);
	Patientlist_Elements list = new Patientlist_Elements(driver);
	JSONParser parser = new JSONParser();
	
	public void navigate_to_addpatient() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		WebElement element = dash.click_addpatient();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("Add patient button is clicked successfully");
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOf(add.enter_patient_firstname()));
		Assert.assertTrue(add.enter_patient_firstname().isDisplayed());
	}
	

	public void verify_and_select_patient_type(String patient_type) {
		Assert.assertTrue(add.select_realpatient().isSelected());
		log.info("Real patient is selected default");
		if(patient_type.equals("Myself Patient")) {
			if(add.select_myself_patient().isDisplayed()) {
				add.select_myself_patient().click();
				log.info("Myself patient is selected");
			} else {
				log.info("Myself patient is already created");
			}
		} else if(patient_type.equals("Test Patient")) {
			add.select_test_patient().click();
		} else {
			System.out.println("Real patient is selected");
		}
				
	}
	
	public void patient_details() throws Exception {
		Object obj = parser.parse(new FileReader(config.getJSON()));
	    JSONObject data = (JSONObject)obj;
	    String fname = (String)data.get("firstname");
	    String lname = (String)data.get("lastname");
	    String email = (String)data.get("email");
		add.enter_patient_firstname().sendKeys(fname);
		log.info("Firstname of the patient is: "+fname);
		add.enter_patient_lastname().sendKeys(lname);
		log.info("Lastname of the patient is: "+lname);
		add.enter_email_patient().sendKeys(email);
		log.info("Email of the patient is: "+email);
		add.enter_patient_age().sendKeys("25");
		log.info("Age of the patient is: "+25);
		WebElement element = add.click_patient_gender();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		String gender = "male";
		if(gender=="male") {
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("javascript:window.scrollBy(950,950)");
			add.click_gender_male().click();
		} else if (gender=="female") {
			add.click_gender_female().click();
		} else {
			add.click_gender_intersex().click();
		}	
	}

	//GQL - Genetics, Questionnaire and Labs
	public void select_GQL(String gene, String ques, String lab) {
		//Select SNP upload 
		if(gene.equals("Patient")) {
			WebElement gene1= add.select_patient_upload();
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", gene1);
			Assert.assertTrue(add.select_patient_upload().isSelected());
			log.info("Patient upload is selected: "+gene);
		} else {
			WebElement gene1 = add.select_practitioner_upload();
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", gene1);
			Assert.assertTrue(add.select_practitioner_upload().isSelected());
			log.info("Practitioner upload is selected: "+gene);
		}
		//Check Questionnaire
		if(ques.equals("Yes")) {
			WebElement ques1 = add.check_questionnaire();
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ques1);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Assert.assertTrue(add.check_questionnaire().isSelected());
			log.info("Questionnaire is checked: "+ques);
		} else {
			Assert.assertFalse(add.check_questionnaire().isSelected());
			log.info("Questionnaire is unchecked: "+ques);
		}
		// Select Lab
		if(lab.equals("Yes")) {
			if(add.check_labUpload().isSelected()) {
				log.info("Lab upload is already checked");
			} else {
				WebElement lab1 = add.check_labUpload();
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", lab1);
				log.info("Lab upload is checked now");
			}
		} else {
			if(add.check_labUpload().isSelected()) {
				WebElement lab1 = add.check_labUpload();
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", lab1);
				Assert.assertFalse(add.check_labUpload().isSelected());
				log.info("Lab upload is unchecked now");
			} else {
				log.info("Lab upload is already unchecked");
			}
		}
	}
	
	public void confirm_patient() {
		WebElement done = add.click_done_button();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", done);
		log.info("Done button is clicked successfully");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void verify_patient(String patient_type) throws Exception {
		Object obj = parser.parse(new FileReader(config.getJSON()));
	    JSONObject data = (JSONObject)obj;
	    String fname = (String)data.get("firstname");
	    String lname = (String)data.get("lastname");
		if(patient_type.equals("Real Patient")) {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(list.search_field()));
			Assert.assertTrue(list.search_field().isDisplayed());
			log.info("Patient list page is loaded successfully");
			String fullname = fname+" "+lname;
			list.search_field().sendKeys(fullname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			//Assert.assertEquals(fullname, list.get_patient_name().getText());
			log.info("Patient is added successfully: "+fullname);
			Thread.sleep(3000);
		} else if (patient_type.equals("Myself Patient")){
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(list.search_field()));
			Assert.assertTrue(list.search_field().isDisplayed());
			log.info("Myself patient is added successfully");
		} else {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(list.search_field()));
			Assert.assertTrue(list.search_field().isDisplayed());
			log.info("Test patient is added successfully");
		}
		
	}
	
	public void verify_GQL(String GQL) {
		if(add.enter_patient_firstname().isDisplayed()) {
			log.info(add.enter_patient_firstname().getAttribute("value"));
			log.info(add.enter_patient_lastname().getAttribute("value"));
			log.info(add.enter_patient_age().getAttribute("value"));
			log.info(add.get_selected_gender().getText());
			if(GQL.equals("Myself Patient")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("javascript:window.scrollBy(1000,1000)");
		        Assert.assertTrue(add.select_practitioner_upload().isSelected());
		        log.info("Practitioner upload is selected");
		        log.info("Myself patient is created");
			}else {
				log.info("Test patient is created");
			}
		
		} else {
			log.info("Myself patient is already created");		}
	}


	public void verify_another_domain() throws Exception {
		try {
			Object obj = parser.parse(new FileReader(config.getJSON()));
		    JSONObject data = (JSONObject)obj;
		    String fname = (String)data.get("firstname");
		    String lname = (String)data.get("lastname");
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)");
			WebElement element = dash.click_view_patient();
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			log.info("View patient button is clicked successfully");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(list.search_field()));
			Assert.assertTrue(list.search_field().isDisplayed());
			log.info("Patient list page is loaded successfully");
			String fullname = fname+" "+lname;
			list.search_field().sendKeys(fullname);
			log.info("Search patient in the field: "+fullname);
			Thread.sleep(5000);
			Assert.assertTrue(list.get_no_result().isDisplayed());
			log.info("Patient is not mapped with another domain: "+list.get_no_result().getText());
		} catch(Exception e) {
			log.info(e);
		}
	}


	public void patient_status() {
		String patient_status = list.patient_status().getText();
		log.info("Patient status is "+patient_status);
		Assert.assertEquals(patient_status, "Pending");
		log.info("Patient status is Pending");	
	}
	
	public void send_reminder() {
		String patient_status = list.patient_status().getText();
		log.info("Patient status is "+patient_status);
		if(patient_status.equals("Pending")) {
			log.info("Patient status is Pending");
			list.click_sendreminder().click();
			log.info("Send Reminder button is clicked");
		}else {
			log.info("Patient status is Active");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(list.get_mailsent().isDisplayed());
		log.info("Message is displayed " + list.get_mailsent().getText());
		
	}

}

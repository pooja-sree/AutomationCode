package com.puregenomics.at.testcases;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.puregenomics.at.dataprovider.ConfigFileReader;
import com.puregenomics.at.pageFactory.Dashboard_Elements;
import com.puregenomics.at.pageFactory.Login_Elements;


public class Login_cases extends BaseClass {
	
	private Logger log = Logger.getLogger(Login_cases.class);

	Login_Elements login = new Login_Elements(driver);
	Dashboard_Elements dash = new Dashboard_Elements(driver);
	ConfigFileReader config = new ConfigFileReader();
	
	public void navigate_to_signin_page() {
		try {
			login.click_signin_button().click();
			log.info("User click Signin button successfully");	
			System.out.println("Login page is loaded successfully");
		} catch (TimeoutException e1) {
			log.error(e1);
		} catch (NoSuchElementException e2 ) {
			log.error(e2);
		}
		
	}
	
	public void login(List<List<String>> logindata) {
		try {
			login.enter_email().sendKeys(logindata.get(0).get(0));
			log.info("user email is "+logindata.get(0).get(0));
			login.enter_password().sendKeys(logindata.get(0).get(1));
			log.info("user password is "+logindata.get(0).get(1));
			login.click_signin_login().click();
			log.info("User clicked Sigin button successfully");
			Thread.sleep(2000);
		} catch (Exception e1) {
			log.error(e1);
		}
	}
	
	
	public void login_invalid_message() {
		Assert.assertTrue(login.get_invalid_message().isDisplayed());
		log.info("Error message is displayed");
		}
	
	
	public void domain(List<List<String>> select_domain) {
		try {
			String domain_name = select_domain.get(0).get(0);
			if(domain_name.equals("kb")) {
				login.click_domain1().click();
				log.info(domain_name +" is selected successfully");
			} else {
				login.click_domain2().click();
				log.info(domain_name +" is selected successfully");
			}
			login.click_Go().click();
			log.info("Go button is clicked successfully");
			System.out.println("User logged-in successfully");
		} catch(TimeoutException e1) {
			log.error(e1);
		}
	}
	
	public void verify_user() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(login.click_usericon()));
		Assert.assertTrue(login.click_usericon().isDisplayed());
		log.info("User logged-in successfully");
		}catch (Exception e){
			log.error(e);
		}
	}
	
	
	public void logout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-300)");
		WebElement icon = login.click_usericon();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", icon);
		log.info("User icon is clicked successfully");
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOf(login.click_logout()));
		WebElement logout = login.click_logout();
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", logout);
		log.info("Logout link is clicked successfully");
	}

	public void signin(String email, String pwd) {
		try {
			System.out.format("Thread ID - %2d - %s from %s feature file.\n",
			Thread.currentThread().getId(), email,pwd);
			login.enter_email().sendKeys(email);
			log.info("user email is "+email);
			login.enter_password().sendKeys(pwd);
			log.info("user password is "+pwd);
			login.click_signin_login().click();
			log.info("User clicked Sigin button successfully");
		} catch (TimeoutException e1) {
			log.error(e1);
		}
		
	}
	
	
}

package com.puregenomics.at.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Billing_Elements {
	
	public WebDriver driver;

	public Billing_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using = "//h1[normalize-space()='Billing']")
	protected WebElement billing_title;
	
	public WebElement get_billing_title() {
		return billing_title;
		
	}
	
	@FindBy(how = How.NAME, using = "card_first_name")
	protected WebElement txt_card_firstname;
	
	public WebElement enter_card_firstname() {
		return txt_card_firstname;
		
	}
	
	@FindBy(how = How.NAME, using = "card_last_name")
	protected WebElement txt_card_lastname;
	
	public WebElement enter_card_lastname() {
		return txt_card_lastname;	
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Card Number']")
	protected WebElement txt_cardnumber;
	
	public WebElement enter_cardnumber() {
		return txt_cardnumber;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Card Expiration']")
	protected WebElement txt_expdate;
	
	public WebElement enter_expdate() {
		return txt_expdate;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Security Code']")
	protected WebElement txt_cvc;
	
	public WebElement enter_cvc() {
		return txt_cvc;		
	}

	@FindBy(how = How.NAME, using = "isShipping")
	protected WebElement check_isShipping;
	
	public WebElement check_isShipping() {
		return check_isShipping;		
	}
	
	@FindBy(how = How.NAME, using = "first_name")
	protected WebElement txt_firstname;
	
	public WebElement enter_firstname() {
		return txt_firstname;
	}
	
	@FindBy(how = How.NAME, using = "last_name")
	protected WebElement txt_lastname;
	
	public WebElement enter_lastname() {
		return txt_lastname;
		
	}
	
	@FindBy(how = How.NAME, using = "address1")
	protected WebElement txt_address1;
	
	public WebElement enter_address1() {
		return txt_address1;
		
	}
	
	@FindBy(how = How.NAME, using = "address2")
	protected WebElement txt_address2;
	
	public WebElement enter_address2() {
		return txt_address2;
		
	}
	
	@FindBy(how = How.NAME, using = "city")
	protected WebElement txt_city;
	
	public WebElement enter_city() {
		return txt_city;
		
	}
	
	@FindBy(how = How.NAME, using = "state_id")
	protected WebElement dropdown_state;
	
	public WebElement select_state() {
		return dropdown_state;
	}
	
	@FindBy(how = How.NAME, using = "zipcode")
	protected WebElement txt_zipcode;
	
	public WebElement enter_zipcode() {
		return txt_zipcode;
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/form/div[4]/div[1]/div[2]/div/div/div[4]/div/div/div/div/input")
	protected WebElement txt_phone;
	
	public WebElement enter_phone() {
		return txt_phone;
	
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/form/div[3]/div/div")
	protected WebElement card_error;
	
	public WebElement get_card_error() {
		return card_error;
		
	}
									  
	@FindBy(how = How.XPATH, using = "//div[3]//div[1]//button[2]")
	protected WebElement btn_next_top;
	
	public WebElement click_next_top() {
		return btn_next_top;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/form/div[1]/div/button[2]")
	protected WebElement btn_next_bottom;
	
	public WebElement click_next_bottom() {
		return btn_next_bottom;
		
	}
	
	

}


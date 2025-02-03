package com.puregenomics.at.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Shipping_Elements {
protected static WebDriver driver;
	
	public Shipping_Elements(WebDriver driver) {
		Shipping_Elements.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"title-breadcrumb-option-demo\"]/div[1]/div/div")
	protected WebElement shipping_title;
	
	public WebElement get_shipping_title() {
		return shipping_title;
		
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='First Name']")
	protected WebElement txt_firstname;
	
	public WebElement enter_firstname() {
		return txt_firstname;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Last Name']")
	protected WebElement txt_lastname;
	
	public WebElement enter_lastname() {
		return txt_lastname;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Street Address Line 1']")
	protected WebElement txt_address1;
	
	public WebElement enter_address1() {
		return txt_address1;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Street Address Line 2']")
	protected WebElement txt_address2;
	
	public WebElement enter_address2() {
		return txt_address2;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='City']")
	protected WebElement txt_city;
	
	public WebElement enter_city() {
		return txt_city;
		
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='state_id']")
	protected WebElement dropdown_state;
	
	public WebElement select_state() {
		return dropdown_state;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Zip Code']")
	protected WebElement txt_zipcode;
	
	public WebElement enter_zipcode() {
		return txt_zipcode;
		
	}
	
	@FindBy(how = How.XPATH, using="//body/div[@id='root']/div/div/div/div/div[@class='container-fluid']/form/div[@class='row']/div[@class='col p-3 pt-5 pb-5']/div[@class='row']/div[@class='col']/div[@aria-busy='false']/form[@class='needs-validation p-3']/div[1]")
	protected WebElement save_address;
	
	public WebElement check_save_address() {
		return save_address;
	}
	
	@FindBy(how = How.NAME, using = "Standard Shipping")
	protected WebElement radiobtn_shipping;
	
	public WebElement check_shipping() {
		return radiobtn_shipping;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	protected WebElement txt_email;
	
	public WebElement enter_email() {
		return txt_email;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Phone']")
	protected WebElement txt_phone;
	
	public WebElement enter_phone() {
		return txt_phone;
	
	}
	
	@FindBy(how = How.CSS, using = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(3) > div:nth-child(1) > button:nth-child(2)")
	protected WebElement btn_next_top;
	
	public WebElement click_next_top() {
		return btn_next_top;
		
	}
	
	
	/*
	 * @FindBy(how = How.XPATH, using =
	 * "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/form/div[4]/div/button[2]")
	 * protected WebElement btn_next_bottom;
	 * 
	 * public WebElement click_next_bottom() { return btn_next_bottom;
	 * 
	 * }
	 */
	
	@FindBy(how = How.CLASS_NAME, using = "error-message text-red")
	protected WebElement address_error_message;
	
	public WebElement get_address_error_message() {
		return address_error_message;
		
	}
		
}

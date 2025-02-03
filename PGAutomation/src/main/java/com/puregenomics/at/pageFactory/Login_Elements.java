package com.puregenomics.at.pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login_Elements {
public WebDriver driver;
	
	public Login_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"sign-in-btn__homepage\"]")
	protected WebElement sign_button;
	
	public WebElement click_signin_button() {
		return sign_button;
		
	}
	
	
	@FindBy(how = How.ID, using = "email-input__loginpage")
	protected WebElement text_email;
	
	public WebElement enter_email() {
		return text_email;
		
	}
	
	
	@FindBy(how = How.ID, using="password-input__loginpage")
	protected WebElement text_password;
	
	public WebElement enter_password() {
		return text_password;
		
	}
	
	@FindBy(how = How.ID, using="sign-in-btn__loginpage")
	protected WebElement button_signin;
	
	
	public WebElement click_signin_login() {
		return button_signin;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[1]/div/div/div[2]")
	protected WebElement get_message;
	
	public WebElement get_invalid_message() {
		return get_message;
		
	}
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]")
	protected WebElement check_domain;
	
	public WebElement domain_page() {
		return check_domain;
		
	}
	
	@FindAll(@FindBy(how = How.XPATH, using = "//*[@class='pg_radio my-2 mx-3']"))
	protected List<WebElement> sub_domains;
	
	public List<WebElement> select_domain() {
		return sub_domains ;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='radio-btn__subdomain__kb2__cb']")
	protected WebElement domain1_radio;
	
	public WebElement click_domain1() {
		return domain1_radio;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='radio-btn__subdomain__kb21__cb']")
	protected WebElement domain2_radio;
	
	public WebElement click_domain2() {
		return domain2_radio;
		
	}
	
	@FindBy(how = How.XPATH, using="//*[@id='submit-btn__subdomain']")
	protected WebElement button_go;
	
	public WebElement click_Go() {
		return button_go;
		
	}
	
	@FindBy(how = How.ID, using="fp-btn__loginpage")
	protected WebElement link_forgorpassword;
	
	public WebElement click_forgot_password() {
		return link_forgorpassword;
		
	}
	
	@FindBy(how = How.XPATH, using="//*[@id=\"root\"]/div/div[2]/div[2]/nav/div/div[3]/div/i/i")
	protected WebElement user_icon;
	
	public WebElement click_usericon() {
		return user_icon;
		
	}
	
	@FindBy(how = How.XPATH, using="//i[@class='fas fa-sign-out-alt']")
	protected WebElement logout;
	
	public WebElement click_logout() {
		return logout;
		
	}
	
	
	
}

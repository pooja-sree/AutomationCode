package com.puregenomics.at.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Review_Elements {
	protected static WebDriver driver;
	
	public Review_Elements(WebDriver driver) {
		Review_Elements.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/h4")
	protected WebElement review_script;
	
	public WebElement get_review_script() {
		return review_script;
		
	}
									   
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div/button[3]")
	protected WebElement btn_checkout_top;
	
	public WebElement click_checkout_top() {
		return btn_checkout_top;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[3]/div/button[3]")
	protected WebElement btn_checkout_bottom;
	
	public WebElement click_checkout_bottom() {
		return btn_checkout_bottom;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[3]/div[1]/button[2]")
	protected WebElement btn_sendscript_top;
	
	public WebElement click_sendscript_top() {
		return btn_sendscript_top;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[5]/div/button[2]")
	protected WebElement btn_sendscript_bottom;
	
	public WebElement click_sendscript_bottom() {
		return btn_sendscript_bottom;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[4]/div[2]/div[2]/div/div/div")
	protected WebElement script_name;
	
	public WebElement get_script_name() {
		return script_name;
		
	}
									  
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[2]/div[1]/h4")
	protected WebElement review_order;
	
	public WebElement get_review_order() {
		return review_order;
		
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[1]/div/button[2]")
	protected WebElement checkout_top;
	
	public WebElement navigate_checkout_top() {
		return checkout_top;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div[1]/div/button[2]")
	protected WebElement checkout_bottom;
	
	public WebElement navigate_checkout_bottom() {
		return checkout_bottom;
	}
}

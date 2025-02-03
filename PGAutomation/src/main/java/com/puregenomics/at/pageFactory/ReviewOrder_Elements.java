package com.puregenomics.at.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ReviewOrder_Elements {
	
protected static WebDriver driver;
	
	public ReviewOrder_Elements(WebDriver driver) {
		ReviewOrder_Elements.driver = driver;
		PageFactory.initElements(driver, this);	
	}
											
	@FindBy(how = How.CSS, using = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(2)")
	protected WebElement btn_next_top;
	
	public WebElement click_placeOrder() {
		return btn_next_top;
		
	}
}

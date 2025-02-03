package com.puregenomics.at.pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Personalized_Elements {
	public WebDriver driver;

	public Personalized_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div/div[1]/h1")
	protected WebElement personalized_title;
	
	public WebElement get_personalized_title() {
		return personalized_title;
		
	}
	
	@FindBy(how = How.XPATH, using = "//label[@class='supplement-name']")
	protected List<WebElement> supplement_list;
	
	public List<WebElement> get_supplement_list(){
		return supplement_list;
		
	}
}

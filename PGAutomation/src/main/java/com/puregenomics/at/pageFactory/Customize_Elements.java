package com.puregenomics.at.pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Customize_Elements {
protected static WebDriver driver;
	
	public Customize_Elements(WebDriver driver) {
		Customize_Elements.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindAll(@FindBy(how = How.CLASS_NAME, using ="supplement-name"))
	protected List<WebElement> supplement_list;
	
	public List<WebElement> get_supplement_list(){
		return supplement_list;
		
	}
	
								 					   
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[3]/div[1]/button[2]")
	protected WebElement btn_next_top;
	
	public WebElement click_next_top() {
		return btn_next_top;
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[5]/div/button[2]")
	protected WebElement bottom_next;
	
	public WebElement click_next_bottom() {
		return bottom_next;
		
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[4]/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[3]/button[2]")
	protected WebElement add_quantity;
	
	public WebElement click_quantity() {
		return add_quantity;
	}
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='col d-flex flex-column pb-3']/span"))
	protected List<WebElement> supplement_name;
	
	public List<WebElement> get_supplementname() {
		return supplement_name;
		
	}
	
	@FindAll(@FindBy(how = How.XPATH, using = "//p[@class='col-md-8']"))
	protected List<WebElement> summmary;
	
	public List<WebElement> get_summary() {
		return summmary;
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Add instructions (optional)']")
	protected WebElement text_comments;
	
	public WebElement enter_instructions() {
		return text_comments;
		
	}
	
}

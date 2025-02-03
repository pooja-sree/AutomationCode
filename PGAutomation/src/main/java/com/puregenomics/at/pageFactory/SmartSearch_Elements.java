package com.puregenomics.at.pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SmartSearch_Elements {
	protected static WebDriver driver;

	public SmartSearch_Elements(WebDriver driver) {
		SmartSearch_Elements.driver = driver;	
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using = "//*[@placeholder='Search for the right supplements for your patients']")
	protected WebElement txt_search;	
	
	public WebElement enter_search() {
		return txt_search;
	}
	
	
	
	@FindBy(how = How.XPATH, using="//*[@id=\"root\"]/div/div[2]/div/div/div/div[4]/div/div/div/div[2]/div/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/label/div")
	protected WebElement click_add;
	
	public WebElement add_supplement() {
		return click_add;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tag-list\"]/li[1]/h3/div")
	protected WebElement allergies;
	
	public WebElement click_allergies() {
		return allergies;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tag-list\"]/li[2]/h3/div")
	protected WebElement category;
	
	public WebElement click_category() {
		return category;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tag-list\"]/li[3]/h3/div")
	protected WebElement imbalances;
	
	public WebElement click_imbalances() {
		return imbalances;		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tag-list\"]/li[4]/h3/div")
	protected WebElement lifestyle;
	
	public WebElement click_lifestyle() {
		return lifestyle;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tag-list\"]/li[5]/h3/div")
	protected WebElement SNP;
	
	public WebElement click_SNP() {
		return SNP;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tag-list\"]/li[6]/h3/div")
	protected WebElement delivery_format;
	
	public WebElement click_delivery_format() {
		return delivery_format;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[3]/div[1]/button[2]")
	protected WebElement resetall;
	
	public WebElement click_resetall() {
		return resetall;
	}
	                                  
	
	@FindBy(how = How.CSS, using = "#root > div > div:nth-child(2) > div > div > div > div:nth-child(3) > div.col-8.px-3.nav-btn > button.btn.px-5.font-bold.button-style.mr-3.button-outline-style")
	protected WebElement patient_next_top;
	       
	public WebElement navigate_to_cScript() {
		return patient_next_top;														
		
	} 
									  
	@FindBy(how = How.XPATH, using = "//*[@id=\"catalog_srn\"]/div[2]/div/div/div/div/div[1]/button")
	protected WebElement btn_next_top;
	       
	public WebElement click_next_top() {
		return btn_next_top;														
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[5]/div/button[2]")
	protected WebElement patent_next_bottom;
	
	public WebElement click_next_cScript() {
		return patent_next_bottom;
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"catalog_srn\"]/div[2]/div/div/div/div/div[3]/button")
	protected WebElement btn_next_bottom;
	
	public WebElement click_next_bottom() {
		return btn_next_bottom;
		
	}
	
	@FindAll(@FindBy(how = How.XPATH, using = "//*[@class='sui-multi-checkbox-facet__input-text']"))
	protected List<WebElement> check_tags;
	
	public List<WebElement> click_tags(){
		return check_tags;
		
	}
	
	@FindAll(@FindBy(how = How.XPATH, using= "//p[@class='col pb-1 font-extra-bold']"))
	protected List<WebElement> check_supplement;
	
	public List<WebElement> get_supplementname() {
		return check_supplement;
		
	}
	
}

package com.puregenomics.at.pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Suggestion_Elements {
public WebDriver driver;
	
	public Suggestion_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/h1")
	protected WebElement suggestion_title;
	
	public WebElement get_suggestion_title() {
		return suggestion_title;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[4]/div[2]/div[1]/h5")
	protected WebElement summary_title;
	
	public WebElement get_summary_title() {
		return summary_title;
		
	}
	
	@FindAll(@FindBy(how = How.TAG_NAME, using = "p" ))   
	protected List<WebElement> suggestions_list;
	
	public List<WebElement> get_suggestion_list(){
		return suggestions_list;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[5]/div/button")
	protected WebElement btn_next_bottom;
	
	public WebElement click_next_bottom() {
		return btn_next_bottom;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[3]/div[1]/button")
	protected WebElement btn_next_top;
	
	public WebElement click_next_top() {
		return btn_next_top;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[3]/div[2]/button")
	protected WebElement summary_icon;
	
	public WebElement click_summary_icon() {
		return summary_icon;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[4]/div/div[2]/div[1]/div/div[1]/div/div/div/label")
	protected WebElement view_by;
	
	public WebElement click_view_by() {
		return view_by;
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@class='tags-font-size-9 font-extra-bold']")
	protected WebElement snps_tag;
	
	public WebElement snps_tag() {
		return snps_tag;
		
	}
	@FindAll(@FindBy(how = How.CLASS_NAME, using = "badge badge-pill  custom-bagde-color tag-style cursor-pointer false" ))   
	protected List<WebElement> tag_snps;
	
	public List<WebElement> get_snps_tag(){
		return tag_snps;
		
	}
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"root\"]/div/div[2]/div/div/div/div[4]/div/div[2]/div[3]/div/div/div/label[1]/div")
	protected WebElement supplement_checkbox;
	
	public WebElement click_addall() {
		return supplement_checkbox;
		
	}
}

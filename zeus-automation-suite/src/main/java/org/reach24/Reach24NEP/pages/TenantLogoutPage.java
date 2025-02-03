package org.reach24.Reach24NEP.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24NEP.util.PropsReader;
import org.reach24.Reach24NEP.util.Wait;

public class TenantLogoutPage {
	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;
	
	public TenantLogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}

	@FindBy(xpath="//a[@class='dropdown-toggle']/span[1]")
	private WebElement logoutDropdown;
	@FindBy(linkText="Log Out")  
	private WebElement clickLogout;
	
	public void sclogout() {
		wait.forElementToBeDisplayed(logoutDropdown);
		logoutDropdown.click();
		wait.forElementToBeDisplayed(clickLogout);
		clickLogout.click();
	}

	@FindBy(xpath="//a[@class='dropdown-toggle']/span[1]")
	private WebElement logoutdrop;
	@FindBy(linkText="Log Out")  
	private WebElement logoutbutton;
	
	public void techlogout() {
		wait.forElementToBeDisplayed(logoutdrop);
		logoutdrop.click();
		wait.forElementToBeDisplayed(logoutbutton);
		logoutbutton.click();
	}
}

package org.reach24.Reach24NEP.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24NEP.util.PropsReader;
import org.reach24.Reach24NEP.util.Wait;

public class TenantLoginPage {
	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;
	
	public 	TenantLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	@FindBy(id="user_email")
	private WebElement tenantUserName;
	public void enterUserName(String userName) {
		wait.forElementToBeDisplayed(tenantUserName);
		tenantUserName.clear();
		tenantUserName.sendKeys(userName);
	}

	@FindBy(id="user_password")
	private WebElement tenantPassword;
	public void enterPassword(String password) {
		wait.forElementToBeDisplayed(tenantPassword);
		tenantPassword.clear();
		tenantPassword.sendKeys(password);

	}
	
	@FindBy(xpath="//*[@id='new_user']/div[3]/div/div/ins")
	private WebElement tenantRememberMe;
	public void checkRememberMe() {
		tenantRememberMe.click();
	}
	
	@FindBy(xpath="//*[@id='new_user']/div[4]/button")
	private WebElement tenantLogin;
	public void clickLoginButton() {
		tenantLogin.click();
	}
	
	@FindBy(xpath="//*[@id='topbar']/div[2]/ul/li[2]/a/span[1]")
	private WebElement loginUserName;
	public void tenantusername() {
		loginUserName.getText();
	}
	
	@FindBy(id="admin_user_email")
	private WebElement adminUserName;
	public void enterAdminUserName(String userName) {
		wait.forElementToBeDisplayed(adminUserName);
		adminUserName.clear();
		adminUserName.sendKeys(userName);
	}
	
	@FindBy(id="admin_user_password")
	private WebElement adminPassword;
	public void enterAdminPassword(String password) {
		wait.forElementToBeDisplayed(adminPassword);
		adminPassword.clear();
		adminPassword.sendKeys(password);
	}
	
	@FindBy(xpath="//input[@id='admin_user_remember_me']/following::ins")
	private WebElement adminRememberMe;
	public void checkAdminRememberMe() {
		adminRememberMe.click();
	}
	
	@FindBy(xpath="//*[@name='button'][contains(text(),'Log in')]")
	private WebElement adminLogin;
	public void clickAdminLoginButton() {
		adminLogin.click();
	}
	
	
}



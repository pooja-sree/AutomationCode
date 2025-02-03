package org.reach24.Reach24NEP.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24NEP.util.Wait;

public class SuperAdminPage {
	
	WebDriver driver;
	Wait wait;
	
	public SuperAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public void hardwait2() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath = "//div[@id='tenants_filter']/label/div/input")
	private WebElement searchTenantBox;
	@FindBy(xpath = "//div[@id='tenants_filter']/label/div/input/following::span")
	private WebElement searchTenantIcon;
	@FindBy(xpath = "(//table[@id='tenants']/tbody/tr/td/a)[1]")
	private WebElement linkTenant;
	
	public void searchTenantBox(String tenant) {
		wait.forElementToBeClickable(searchTenantBox);
		searchTenantBox.clear();
		searchTenantBox.sendKeys(tenant);
		searchTenantIcon.click();
		hardwait2();
	}
	
	public void clickLinkTenant(String tenantName) {
		wait.forElementToBeClickable(linkTenant);
		WebElement ele=driver.findElement(By.xpath("//a[text()='"+tenantName+"']"));
		wait.forElementToBeClickable(ele);
		ele.click();
	}
	
}

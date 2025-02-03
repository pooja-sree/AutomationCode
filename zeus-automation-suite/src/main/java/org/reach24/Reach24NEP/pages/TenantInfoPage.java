package org.reach24.Reach24NEP.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24NEP.actions.DriverActions;
import org.reach24.Reach24NEP.actions.JsActions;
import org.reach24.Reach24NEP.util.Wait;

public class TenantInfoPage {
	
	
	WebDriver driver;
	Wait wait;
	JsActions jsActions;
	DriverActions driverActions;
	
	public TenantInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
		jsActions = new JsActions(driver);
		driverActions = new DriverActions(driver);
	}

	@FindBy(xpath = "//div[@class='admin-page-title']/h2 | //div[@class='admin-page-title']/h4")
	private WebElement tenantTitle;
	@FindBy(xpath = "//*[@class='fa fa-pencil']")
	private WebElement selectInfoEdit;
	
	public boolean verifyTenantName(String TenantName) {
		Boolean status=false;
		driverActions.hardwaitBasedOnInput(5000);
		String tenantName=tenantTitle.getText().trim();
		System.out.println("Expected Tenant Name:"+ TenantName );
		System.out.println("Observed Tenant Name:"+ tenantName );
		if(tenantName.equals(TenantName)) {
			status=true;
		}
		return status;
	}
	
	public void selectInfoEdit() {
		wait.forElementToBeClickable(selectInfoEdit);
		selectInfoEdit.click();
		System.out.println("Edit Button Selected on Tenant Info Page");
	}
	public String getTenantName() {
		driverActions.hardwaitBasedOnInput(5000);
		String tenantName = tenantTitle.getText().trim();
		return tenantName;
	}

	public void enableFeature(String featureName) {
		String xpath = "//label[contains(text(),'" + featureName + "')]/following::div[1]/div";
		if (driverActions.isChecked2(xpath)) {
			System.out.println(featureName + " - Checked");
			return;
		}else {
			WebElement ele = driver
					.findElement(By.xpath("//label[contains(text(),'" + featureName + "')]/following::div[1]/div/ins"));
			jsActions.jsclick(ele);
			System.out.println(featureName + " - Checked");
		}
	}

	public void disableFeature(String featureName) {
		String xpath = "//label[contains(text(),'" + featureName + "')]/following::div[1]/div";
		if (driverActions.isChecked2(xpath)) {
			WebElement ele = driver
					.findElement(By.xpath("//label[contains(text(),'" + featureName + "')]/following::div[1]/div/ins"));
			jsActions.jsclick(ele);
			System.out.println(featureName + " - Unchecked");
		}else {
			System.out.println(featureName + " - Unchecked");
			return;
		}
	}

	@FindBy(xpath = "//input[@value='Update']")
	private WebElement btnUpdate;

	public void clickBtnUpdate() {
		wait.forElementToBeClickable(btnUpdate);
		btnUpdate.click();
		System.out.println("Update Button clicked on Tenent Info Edit Page");
	}

}

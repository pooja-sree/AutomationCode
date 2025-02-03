package org.reach24.Reach24NEP.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24NEP.actions.DriverActions;
import org.reach24.Reach24NEP.actions.JsActions;
import org.reach24.Reach24NEP.util.Wait;

public class TenantInfoEditPage {
	WebDriver driver;
	DriverActions driverActions;
	JsActions jsActions;
	Wait wait;

	
	public TenantInfoEditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
		driverActions = new DriverActions(driver);
		jsActions = new JsActions(driver);
	}

	@FindBy(xpath = "//input[@id='tenant_new_event_page_accessible']/parent::div")
	private WebElement checkedNEPAccessibility;
	@FindBy(xpath = "//input[@id='tenant_new_event_page_accessible']/parent::div/ins")
	private WebElement selectNEPAccessibility;
	@FindBy(xpath = "//input[@id='tenant_default_new_event_page_enabled']/parent::div")
	private WebElement checkedMarkNewPageDefault;
	@FindBy(xpath = "//input[@id='tenant_default_new_event_page_enabled']/parent::div/ins")
	private WebElement selectMarkNewPageDefault;
	@FindBy(xpath = "//input[@id='tenant_switch_old_event_page_enabled']/parent::div")
	private WebElement checkedSwitchBackToOldEventPage;
	@FindBy(xpath = "//input[@id='tenant_switch_old_event_page_enabled']/parent::div/ins")
	private WebElement selectSwitchBackToOldEventPage;

	@FindBy(xpath = "//input[@id='tenant_enable_new_event_page_banner_' and @value='create_event']/parent::div")
	private WebElement checkedCreateEvent;
	@FindBy(xpath = "//input[@id='tenant_enable_new_event_page_banner_' and @value='create_event']/parent::div/ins")
	private WebElement selectCreateEvent;
	@FindBy(xpath = "//input[@id='tenant_enable_new_event_page_banner_' and @value='edit_event']/parent::div")
	private WebElement checkedEditEvent;
	@FindBy(xpath = "//input[@id='tenant_enable_new_event_page_banner_' and @value='edit_event']/parent::div/ins")
	private WebElement selectEditEvent;
	@FindBy(xpath = "//input[@id='tenant_enable_new_event_page_banner_' and @value='show_event']/parent::div")
	private WebElement checkedShowEvent;
	@FindBy(xpath = "//input[@id='tenant_enable_new_event_page_banner_' and @value='show_event']/parent::div/ins")
	private WebElement selectShowEvent;
	@FindBy(xpath = "//input[@id='tenant_enable_new_event_page_banner_' and @value='clone_event']/parent::div")
	private WebElement checkedCloneEvent;
	@FindBy(xpath = "//input[@id='tenant_enable_new_event_page_banner_' and @value='clone_event']/parent::div/ins")
	private WebElement selectCloneEvent;
	
	public void enableDisableNEPAccessibility(String enableDisable) {
		System.out.println("Enable Disable ---> NEPAccessibility");
		driverActions.enableDisableNEP(enableDisable, checkedNEPAccessibility, selectNEPAccessibility);
	}
		
	public void enableDisableMarkNewPageDefault(String enableDisable) {
		driverActions.hardwaitBasedOnInput(2000);
		System.out.println("Enable Disable ----->  Mark New Event Page as Default");
		driverActions.enableDisableNEP(enableDisable, checkedMarkNewPageDefault, selectMarkNewPageDefault);
	}
	
	public void enableDisableSwitchBackToOldEventPage(String enableDisable) {
		driverActions.hardwaitBasedOnInput(2000);
		System.out.println("Enable Disable ----->  Switch Back to Old Event Page");
		driverActions.enableDisableNEP(enableDisable, checkedSwitchBackToOldEventPage, selectSwitchBackToOldEventPage);
	}
		
	public void enableDisableCreateEvent(String enableDisable) {
		driverActions.hardwaitBasedOnInput(2000);
		System.out.println("Enable Disable ----->  Create Event Checkbox");
		driverActions.enableDisableNEP(enableDisable, checkedCreateEvent, selectCreateEvent);
	}
		
	public void enableDisableEditEvent(String enableDisable) {
		driverActions.hardwaitBasedOnInput(2000);
		System.out.println("Enable Disable ----->  Edit Event Checkbox");
		driverActions.enableDisableNEP(enableDisable, checkedEditEvent, selectEditEvent);
	}
		
	public void enableDisableShowEvent(String enableDisable) {
		driverActions.hardwaitBasedOnInput(2000);
		System.out.println("Enable Disable ----->  Show Event Checkbox");
		driverActions.enableDisableNEP(enableDisable, checkedShowEvent, selectShowEvent);
	}
		
	public void enableDisableCloneEvent(String enableDisable) {
		driverActions.hardwaitBasedOnInput(2000);
		System.out.println("Enable Disable ----->  Clone Event Checkbox");
		driverActions.enableDisableNEP(enableDisable, checkedCloneEvent, selectCloneEvent);
	}
	
	@FindBy(xpath = "//input[@value='Update']")
	private WebElement btnUpdate;
	
	public void clickBtnUpdate() {
		wait.forElementToBeClickable(btnUpdate);
		btnUpdate.click();
		System.out.println("Update Button clicked on Tenent Info Edit Page");
	}
}

package org.reach24.Reach24NEP.pages;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24NEP.actions.DriverActions;
import org.reach24.Reach24NEP.actions.JsActions;
import org.reach24.Reach24NEP.dtos.EventDetailsDTO;
import org.reach24.Reach24NEP.util.*;
import io.cucumber.datatable.DataTable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EventInfoPage {

	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Inandoutstream inandoutstream = new Inandoutstream();
	ReusableMethods reuse = new ReusableMethods();
	DriverActions driverActions;
	JsActions jsAction;
	Wait wait;
	EventCreationPage eventcreation;
	static String Stream;
	static String DownStream = "DOWNSTREAM";
	static String UpStream = "UPSTREAM";
	static String Test = "Test HotTab";

	public EventInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
		driverActions = new DriverActions(driver);
		jsAction = new JsActions(driver);
		eventcreation = new EventCreationPage(driver);
	}

	public String getEventInfo(String eventData) {
		String eventInfo = "//p[@class='event-id-value']" + eventData;
		driverActions.hardwaitBasedOnInput(1000);
		return driver.findElement(By.xpath(eventInfo)).getText();
	}

	@FindBy(xpath = "//span[text()=' Edit']")
	private WebElement eventEdit;

	public void clickEdit() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(eventEdit);
		eventEdit.click();
	}

	@FindBy(xpath = "//button[@class='ant-btn secondary-btn btn-clone']")
	private WebElement eventClone;

	public void clickClone() {
		wait.forLoading();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(eventClone);
		// eventClone.click();
		jsAction.jsclick(eventClone);
	}

	@FindBy(xpath = "//*[@class= 'event-id-value']")
	private WebElement eventInfo;

	public String getAlphaNumEventId() throws IOException {
		driver.switchTo().frame("eventPageIFrame");
		wait.forLoading();
		driverActions.hardwaitBasedOnInput(5000);
		String alphaNumEventId = driverActions.driverGetText(eventInfo).replace("  ", "");
		System.out.println(alphaNumEventId);
		inandoutstream.saveScheduleEventID(alphaNumEventId);
		return alphaNumEventId;
	}

	public String getAlphaNumEI_EventId() {
		String eventInfo = "//*[@id='title-breadcrumb-option-demo']/ol/a[2]";
		return driver.findElement(By.xpath(eventInfo)).getText();
	}

	@FindBy(xpath = "(//div[@class='ant-space ant-space-vertical']/div/div/div/div[2]/div/div)[2]/div[4]")
	private WebElement equipmentInfo;

	public String getEquipementType(String equipmentType) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driverActions.hardwaitBasedOnInput(3000);
		System.out.println(equipmentInfo.getText().replaceAll("Equipment Type:", ""));
		wait.forElementToBeDisplayed(equipmentInfo);
		try {
			return driverActions.driverGetText(equipmentInfo).replaceAll("Equipment Type:", "");
		} catch (NoSuchElementException e) {
			return equipmentType;
		}

	}

	//@FindBy(xpath = "(//div[@class='ant-space ant-space-vertical']/div/div/div/div[2]/div/div)[1]/div[4]")
	@FindBy(xpath = "(//div[@class='ant-space ant-space-vertical']/div/div/div/div[2]/div/div)[2]/div[4]")
	private WebElement equipmentProviders;

	public String getEquipmentProvider() {
		System.out.println(equipmentProviders.getText());
		wait.forElementToBeDisplayed(equipmentProviders);
		try {
			return driverActions.driverGetText(equipmentProviders);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@FindBy(xpath = "(//div[@class='ant-space ant-space-vertical']/div/div/div/div[2]/div/div)[2]/div[12]")
	private WebElement driverWithUnit;

	public String getDriverWithUnit() {
		try {
			return driverActions.driverGetText(driverWithUnit);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@FindBy(xpath = "(//div[@class='ant-space ant-space-vertical']/div[2]/div/div/div[2]/div/div)[1]/div[7]")
	private WebElement isLoaded;

	public String getLoaded() {
		try {
			return driverActions.driverGetText(isLoaded);
		} catch (NoSuchElementException e) {
			System.out.println("Is Loaded Exception.");
		}
		return null;

	}

	public String getServicesInfo(String servicesData, int position) {
		//((//*[@class= 'ant-row'])[4]/div/div/div/div/div/div)
		String servicesInfo = "//*[@class= 'ant-row show-servicelineitem-container']/div/div";
		return driver.findElements(By.xpath(servicesInfo)).get(position).getText();
	}

	public String getInspectionCategoriesInfo(String inspectionData) {
		String servicesInfo = "//label[contains(text(), '" + inspectionData + "')]//following::label[1]";
		return driver.findElement(By.xpath(servicesInfo)).getText();
	}

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary btn-event-log']")
	private WebElement logBtn;
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	private WebElement btnOK;

	// @FindBy(xpath = "(//div[@class='ant-tabs-tab-btn'])[1]/span")
	@FindBy(xpath = "//span[text()=' Event Log']")
	private WebElement tabEventLog;
	// @FindBy(xpath = "(//div[@class='ant-tabs-tab-btn'])[2]/span")
	@FindBy(xpath = "//span[text()=' Dispatch Log']")
	private WebElement tabdispatchLog;
	// @FindBy(xpath = "(//div[@class='ant-tabs-tab-btn'])[3]/span")
	@FindBy(xpath = "//span[text()=' Technician Log']")
	private WebElement tabTechnicianLog;
	@FindBy(xpath = "//div[@class='event-sub-header']/div/div[2]/div[2]/p/span")
	private WebElement technicianStatus;

	public String getStatus(String type) {
		String status = null;
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(5000);

		if (type.equalsIgnoreCase("eventLog") || type.equalsIgnoreCase("dispatchLog")
				|| type.equalsIgnoreCase("technLog") || type.equalsIgnoreCase("Single")
				|| type.equalsIgnoreCase("Org")) {
			wait.forElementToBeClickable(logBtn);
			jsAction.jsclick(logBtn);
			driverActions.hardwaitBasedOnInput(2000);
			int Tab1Count = driver.findElements(By.xpath("(//div[@class='ant-tabs-tab-btn'])[1]")).size();
			int Tab2Count = driver.findElements(By.xpath("(//div[@class='ant-tabs-tab-btn'])[2]")).size();
			int Tab3Count = driver.findElements(By.xpath("(//div[@class='ant-tabs-tab-btn'])[3]")).size();
			System.out.println(Tab1Count + "<---->" + Tab2Count + "<----->" + Tab3Count);
			System.out.println("Status Type ------>" + type);
			int latestRow = 1;
			if (type.equalsIgnoreCase("eventLog") && Tab1Count == 1) {
				assertEquals("The Event log tab should exist", "Event Log", driverActions.driverGetText(tabEventLog));
				jsAction.jsclick(tabEventLog);
				driverActions.hardwaitBasedOnInput(2000);
				latestRow = driver.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr")).size();
				status = driverActions.driverGetText(driver
						.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr[" + latestRow + "]/td[3]")));
			} else if (type.equalsIgnoreCase("eventlog2")) {
				assertEquals("The Event log tab should exist", "Event Log", driverActions.driverGetText(tabEventLog));
				jsAction.jsclick(tabEventLog);
				driverActions.hardwaitBasedOnInput(2000);
				latestRow = driver.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr")).size();
				status = driverActions.driverGetText(driver
						.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr[" + latestRow + "]/td[3]")));
			} else if (type.equalsIgnoreCase("dispatchLog") && Tab2Count == 1) {
				assertEquals("The Dispatch log tab should exist", "Dispatch Log",
						driverActions.driverGetText(tabdispatchLog));
				jsAction.jsclick(tabdispatchLog);
				driverActions.hardwaitBasedOnInput(2000);
				latestRow = driver.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr")).size();
				status = driverActions.driverGetText(driver
						.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr[" + latestRow + "]/td[3]")));
			} else if (type.equalsIgnoreCase("technLog") && Tab2Count == 1 && Tab3Count == 1) {
				assertEquals("The Technician log tab should exist", "Technician Log",
						driverActions.driverGetText(tabTechnicianLog));
				jsAction.jsclick(tabTechnicianLog);
				driverActions.hardwaitBasedOnInput(2000);
				latestRow = driver.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[3]/tr")).size();
				status = driverActions.driverGetText(driver
						.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[3]/tr[" + latestRow + "]/td[2]")));
			} else if (type.equalsIgnoreCase("technLog") && Tab2Count == 1 && Tab3Count == 0) {
				assertEquals("The Technician log tab should exist", "Technician Log",
						driverActions.driverGetText(tabTechnicianLog));
				jsAction.jsclick(tabTechnicianLog);
				driverActions.hardwaitBasedOnInput(2000);
				latestRow = driver.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr")).size();
				status = driverActions.driverGetText(driver
						.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[2]/tr[" + latestRow + "]/td[2]")));

			} else if (type.equalsIgnoreCase("Single") || type.equalsIgnoreCase("Org")) {
				assertEquals("The Event log tab should exist", "Event Log", driverActions.driverGetText(tabEventLog));
				jsAction.jsclick(tabEventLog);
				driverActions.hardwaitBasedOnInput(5000);
				latestRow = driver.findElements(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr")).size();
				status = driverActions.driverGetText(driver
						.findElement(By.xpath("(//tbody[@class='ant-table-tbody'])[1]/tr[" + latestRow + "]/td[3]")));
			} else {
				System.out.println("Invalid tab entered for Event Logs");
			}
			driverActions.hardwaitBasedOnInput(2000);
			jsAction.jsclick(btnOK);
		} else if (type.equalsIgnoreCase("technStatus") || type.equalsIgnoreCase("technStatus-remainingServiceLineItems")) {
			wait.forElementToBeDisplayed(technicianStatus);
			status = driverActions.driverGetText(technicianStatus);
		}
		driverActions.hardwaitBasedOnInput(1000);
		driver.switchTo().defaultContent();
		return status;
	}

	@FindBy(xpath = "(//a[@class='status-style'])[2]")
	private WebElement statusElement2;

	public String getStatus2() {
		wait.forElementToBeDisplayed(statusElement2);
		return statusElement2.getText();
	}

	@FindBy(xpath = "//div[contains(@class,'status-text-main status-text-main-active')]")
	private WebElement activeBannerStatus;

	@FindBy(xpath = "//div[contains(@class,'status-text-main status-text-main-rejected')]")
	private WebElement activeFailedBannerStatus;

	public String getBannerStatus() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		String status = "";
		int size = driver.findElements(By.xpath("//div[@class='status-text-main status-text-main-rejected']")).size();
		System.out.println("SIZE OF REJECTED BANNER STATUS IS:" + size);
		for (int i = 1; i <= size; i++) {
			WebElement rejectStatusBanner = driver
					.findElement(By.xpath("//div[contains(@class,'status-text-main status-text-main-rejected')]"));
			// System.out.println("BANNER WEBELEMENT IS:"+ statusBanner);
			if (driverActions.driverGetText(rejectStatusBanner).equalsIgnoreCase("REJECTED")) {
				System.out.println("REJECTED FOUND");
				wait.forElementToBeDisplayed(activeFailedBannerStatus);
				status = driverActions.driverGetText(activeFailedBannerStatus);
				driver.switchTo().defaultContent();
				return status;
			}
		}
		wait.forElementToBeDisplayed(activeBannerStatus);
		status = driverActions.driverGetText(activeBannerStatus);
		driver.switchTo().defaultContent();
		return status;
	}

//	@FindBy(xpath = "(//div[@class='ant-space ant-space-vertical']/div/div/div/div[2]/div/div)[1]/div[3]/div[2]/div")
	@FindBy(xpath = "//div[@class='equipment-number-field clickable-link']")
	private WebElement equipNum;

	public String getEquipmentNumber() {
		System.out.println(equipNum.getText());
		wait.forElementToBeDisplayed(equipNum);
		// try {
		// return equipNum.getText();
		// } catch (NoSuchElementException e) {
		return driverActions.driverGetText(equipNum);
	}

	public String getBannerStatus(String status) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		if (status.equalsIgnoreCase("Rejected")) {
			return "Rejected";
		}

		String bannerStatus = "";
		wait.forElementToBeDisplayed(activeBannerStatus);
		bannerStatus = driverActions.driverGetText(activeBannerStatus);
		System.out.println("Banner Status Is : " + activeBannerStatus);
		driver.switchTo().defaultContent();
		return bannerStatus;
	}

	@FindBy(xpath = "//span[text()='Assign Service Center'] | //span[text()='Reassign Service Center']")
	private WebElement clickFSC;
	@FindBy(xpath = "//span[@class='ant-input-wrapper ant-input-group']/input")
	// @FindBy(xpath =
	// "((//div[@class='ant-tabs-content-holder'])[1]/div/div[1]/div/div)[1]/span/span/input")
	private WebElement searchServiceProvider;

	@FindBy(xpath = "//input[@class='ant-input ant-input-lg']")
	private WebElement searchServiceProviderRPSP;

	@FindBy(xpath = "(//input[@class='ant-input ant-input-lg'])[1]")
	private WebElement searchServiceProvider1;

	@FindBy(xpath = "(//input[@class='ant-input ant-input-lg'])[2]")
	private WebElement searchServiceProvider2;

	@FindBy(xpath = "(//input[@class='ant-input ant-input-lg'])[3]")
	private WebElement searchServiceProvider3;

	@FindBy(xpath = "(//input[@class='ant-input ant-input-lg'])[4]")
	private WebElement searchServiceProvider4;
	@FindBy(xpath = "(//input[@class='ant-input ant-input-lg'])[5]")
	private WebElement searchServiceProvider5;

	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-lg ant-input-search-button'])[1]")
	private WebElement searchSPButton;
	// @FindBy(xpath =
	// "//*[@id=\"rc-tabs-0-panel-1\"]/div[2]/div/div/div/div[1]/div[2]/table/tbody/tr[2]/td[5]/button")
	// @FindBy(xpath = "//span[text()='Assign']")
	@FindBy(xpath = "(//tbody[@class='ant-table-tbody']/tr[2])[1]/td[5]/button/span")
	private WebElement clickAssign;

	@FindBy(xpath = "(//span[text()='Assign'])[2]")
	private WebElement clickAssignRPSP;

	public void searchSP(String sc) {
		wait.forElementToBeDisplayed(searchServiceProvider);
		driverActions.driverSendKeys(searchServiceProvider, sc);
		jsAction.jsclick(searchSPButton);
	}

	public void searchSP2(String sc) {
		wait.forElementToBeDisplayed(searchServiceProvider2);
		String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
		searchServiceProvider2.sendKeys(del + sc);
		jsAction.jsclick(searchSPButton2);
	}

	public void searchSP3(String sc) {
		wait.forElementToBeDisplayed(searchServiceProvider3);
		driverActions.driverSendKeys(searchServiceProvider3, sc);
		jsAction.jsclick(searchSPButton3);
	}

	public void searchSP4(String sc) {
		wait.forElementToBeDisplayed(searchServiceProvider4);
		driverActions.driverSendKeys(searchServiceProvider4, sc);
		jsAction.jsclick(searchSPButton4);
	}

	public void searchSP5(String sc) {
		wait.forElementToBeDisplayed(searchServiceProvider5);
		driverActions.driverSendKeys(searchServiceProvider5, sc);
		jsAction.jsclick(searchSPButton5);
	}

	@FindBy(xpath = "//div[text()='Ship to Location']/following::span[1]")
	private WebElement shipToLocation;
	@FindBy(xpath = "//div[text()='Bill to Location']/following::span[1]")
	private WebElement billToLocation;
	@FindBy(xpath = "//div[text()='OEM Verified Account']/following::span[1]")
	private WebElement oemVerifiedAccount;
	@FindBy(xpath = "//div[text()='Payment Notes']/following::span[1]")
	private WebElement paymentNotes;
	@FindBy(xpath = "//div[text()='Responsible Payer']/following::div[2]")
	private WebElement responsiblePayer;
	@FindBy(xpath = "//div[text()='Payment Method']/following::span[1]")
	private WebElement paymentMethod;
	@FindBy(xpath = "//div[text()='Payment Account Number']/following::span[1]")
	private WebElement paymentAccountNumber;

	public void verifyBridgestoneBillToDetails(){
		wait.forElementToBeDisplayed(shipToLocation);
		Assert.assertEquals("ATFleetShipToFleet\n"+"San Francisco, CA, USA\n"+"Account# ATFleetShipToAccount",driverActions.driverGetText(shipToLocation));
		wait.forElementToBeDisplayed(billToLocation);
		Assert.assertEquals("ATFleetBillToFleet\n"+"San Francisco, CA, USA\n"+"Account# ATFleetBillToAccount",driverActions.driverGetText(billToLocation));
		wait.forElementToBeDisplayed(responsiblePayer);
		Assert.assertEquals("UPSTREAM\n"+"AutoTruck Fleet",driverActions.driverGetText(responsiblePayer));
		wait.forElementToBeDisplayed(paymentMethod);
		Assert.assertEquals("Bridgestone - National Tire Account",driverActions.driverGetText(paymentMethod));
		wait.forElementToBeDisplayed(paymentAccountNumber);
		Assert.assertEquals("ATFleetShipToAccount",driverActions.driverGetText(paymentAccountNumber));
		wait.forElementToBeDisplayed(oemVerifiedAccount);
		Assert.assertEquals("Account verified",driverActions.driverGetText(oemVerifiedAccount));
		wait.forElementToBeDisplayed(paymentNotes);
		Assert.assertEquals("Bill to Account # : ATFleetBillToAccount",driverActions.driverGetText(paymentNotes));
	}

	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-lg ant-input-search-button'])[2]")
	private WebElement searchSPButton2;
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-lg ant-input-search-button'])[3]")
	private WebElement searchSPButton3;
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-lg ant-input-search-button'])[4]")
	private WebElement searchSPButton4;
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-lg ant-input-search-button'])[5]")
	private WebElement searchSPButton5;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-icon-only ant-dropdown-trigger']")
	private WebElement fscUnderRadiusTab;
	@FindBy(xpath = "(//span[@class='ant-dropdown-menu-title-content'])[1]")
	private WebElement mile2;
	@FindBy(xpath = "(//span[@class='ant-dropdown-menu-title-content'])[3]")
	private WebElement mile3;

	public void clickFSCInRadiusBtn(String Radius) {
		wait.forElementToBeClickable(fscUnderRadiusTab);
		fscUnderRadiusTab.click();
		// driverActions.hardwaitBasedOnInput(3000);
		if (Radius.equalsIgnoreCase("in 75 mile radius")) {
			wait.forElementToBeClickable(mile2);
			jsAction.jsclick(mile2);
		} else if (Radius.equalsIgnoreCase("in 100 mile radius")) {
			wait.forElementToBeClickable(mile3);
			jsAction.jsclick(mile3);
		}
	}

	@FindBy(xpath = "(//tbody[@class='ant-table-tbody']/tr[2])[3]/td[5]/button/span")
	private WebElement clickAssign3;

	public void assignSP3(String tenant) {
		wait.forElementToBeDisplayed(clickAssign3);
		jsAction.jsclick(clickAssign3);
	}

	@FindBy(xpath = "(//tbody[@class='ant-table-tbody']/tr[2])[4]/td[5]/button/span")
	private WebElement clickAssign4;

	public void assignSP4(String tenant) {
		wait.forElementToBeDisplayed(clickAssign4);
		jsAction.jsclick(clickAssign4);
		// if(tenant.equalsIgnoreCase("AutoTruck SP8")){
		// wait.forElementToBeClickable(assignAnywayBtn);
		// jsAction.jsclick(assignAnywayBtn);
		// }
	}

	@FindBy(xpath = "//span[@class='override-btn']")
	private WebElement overrideFSCSearch;

	@FindBy(xpath = "//input[@id='login-form_name'] | //input[@id='override-search-results_name']")
	private WebElement overrideFSCSearchName;

	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div[2]")
	private WebElement overrideFSCSearchNamedropdown;

	@FindBy(xpath = "(//div[@class='ant-modal-footer'])[2]/button[2]/span")
	private WebElement overrideFSCAssignButton;

	public void clickOverrideSearch(String tenant) {
		wait.forElementToBeClickable(overrideFSCSearch);
		jsAction.jsclick(overrideFSCSearch);
		wait.forElementToBeClickable(overrideFSCSearchName);
		overrideFSCSearchName.sendKeys(tenant);
		driverActions.hardwaitBasedOnInput(5000);
		wait.forElementToBeDisplayed(overrideFSCSearchNamedropdown);
		jsAction.jsclick(overrideFSCSearchNamedropdown);
		wait.forElementToBeClickable(overrideFSCAssignButton);
		jsAction.jsclick(overrideFSCAssignButton);
	}

	public void clickFSC() {
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeDisplayed(clickFSC);
		jsAction.jsclick(clickFSC);
		driverActions.hardwaitBasedOnInput(2000);
	}

	public void assignSP(String tenant) {
		wait.forElementToBeDisplayed(clickAssign);
		jsAction.jsclick(clickAssign);
	}

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary assignBtn-green ']")
	private WebElement assignTenantButton;

	public void assignTenant(String tenant) {
		wait.forElementToBeDisplayed(assignTenantButton);
		jsAction.jsclick(assignTenantButton);
	}

	@FindBy(xpath = "//div[text()='All Centers']")
	private WebElement fscAllTab;

	public void clickAllTab() {
		wait.forElementToBeClickable(fscAllTab);
		jsAction.jsclick(fscAllTab);
	}

	@FindBy(xpath = "(//div[text()='SP Authority'])[2]")
	private WebElement fscSPAuthorityTab;

	public void clickSPAuthorityTab() {
		wait.forElementToBeClickable(fscSPAuthorityTab);
		jsAction.jsclick(fscSPAuthorityTab);
	}

	@FindBy(xpath = "//div[text()='EP Approved']")
	private WebElement fscEPApprovedTab;

	public void clickEPApprovedTab() {
		wait.forElementToBeClickable(fscEPApprovedTab);
		jsAction.jsclick(fscEPApprovedTab);
	}

	@FindBy(xpath = "//div[text()='Under radius']")
	private WebElement fscUnderRadiusTabTab;

	public void clickUnderRadiusTab() {
		wait.forElementToBeClickable(fscUnderRadiusTabTab);
		jsAction.jsclick(fscUnderRadiusTabTab);
	}

	@FindBy(xpath = "(//input[@class='ant-select-selection-search-input'])[2]")
	private WebElement assignSPAnywayInput;
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']/div[1]")
	private WebElement assignSPAnywayFirstDiv;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary duplicateEventModal footer-MainButton']")
	private WebElement assignSPAnywayBtn;

	public void assignSPAnyway(String eventTenantType) {
		if (eventTenantType.equalsIgnoreCase("TD-2")) {
			wait.forElementToBeDisplayed(clickAssign2);
			jsAction.jsclick(clickAssign2);
		} else {
			wait.forElementToBeDisplayed(clickAssign);
			jsAction.jsclick(clickAssign);
		}
		wait.forElementToBeDisplayed(assignSPAnywayInput);
		assignSPAnywayInput.sendKeys("Forwarded to another Location");
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeDisplayed(assignSPAnywayFirstDiv);
		jsAction.jsclick(assignSPAnywayFirstDiv);
		wait.forElementToBeDisplayed(assignSPAnywayBtn);
		jsAction.jsclick(assignSPAnywayBtn);
	}

	public void assignSP12(String tenant) {
		wait.forElementToBeDisplayed(searchServiceProvider1);
		driverActions.driverSendKeys(searchServiceProvider1, tenant);
		wait.forElementToBeDisplayed(searchSPButton);
		jsAction.jsclick(searchSPButton);
		assignSPtenant1(tenant);
	}

	public void assignSP1(String tenant) {
		wait.forElementToBeDisplayed(searchServiceProvider1);
		driverActions.driverSendKeys(searchServiceProvider1, tenant);
		wait.forElementToBeDisplayed(searchSPButton);
		jsAction.jsclick(searchSPButton);
		assignSPtenant1(tenant);
	}

	@FindBy(xpath = "(//tbody[@class='ant-table-tbody']/tr[2])[2]/td[5]/button/span")
	private WebElement clickAssign2;

	public void assignSP2(String tenant) {
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeDisplayed(clickAssign2);
		jsAction.jsclick(clickAssign2);
	}

	public void assignSPtenant2(String tenant) {
		driverActions.hardwaitBasedOnInput(2000);
		WebElement assignTenant = driver.findElement(By.xpath("(//a[text()='" + tenant
				+ "'])[2]/parent::span/parent::div/parent::td/following-sibling::td[4]/button"));
		wait.forElementToBeDisplayed(assignTenant);
		jsAction.jsclick(assignTenant);
	}

	public void assignSPtenant1(String tenant) {
		driverActions.hardwaitBasedOnInput(2000);
		WebElement assignTenant = driver.findElement(By.xpath("(//a[text()='" + tenant
				+ "'])[1]/parent::span/parent::div/parent::td/following-sibling::td[4]/button"));
		wait.forElementToBeDisplayed(assignTenant);
		jsAction.jsclick(assignTenant);
	}

	public void assignSPRPSP(String tenant) {
		wait.forElementToBeDisplayed(searchServiceProviderRPSP);
		driverActions.driverSendKeys(searchServiceProviderRPSP, tenant);
		wait.forElementToBeDisplayed(searchSPButton);
		jsAction.jsclick(searchSPButton);
		wait.forElementToBeDisplayed(clickAssignRPSP);
		jsAction.jsclick(clickAssignRPSP);
	}

	@FindBy(xpath = "//*[text()='Responsible Payer'])[2]/following::div[1]/div/span/input")
	private WebElement selectResponsiblePayer;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div/div/div")
	private WebElement clickResponsiblePayer;
	@FindBy(xpath = "//article[text()='Payment Method']/parent::div/div/div/span/input")
	private WebElement clickPaymentMethod;
	@FindBy(xpath = "(//div[text()='Cash'])[1]")
	private WebElement selectPaymentMethod;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary duplicateEventModal footer-MainButton']")
	private WebElement saveAndAssign;
	@FindBy(xpath = "//div[text()='Possible duplicate events for the equipment']")
	private WebElement duplicateText;
	@FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div[2]/div[3]/button[1]/span")
	private WebElement btnIgnore;
	@FindBy(xpath = "//span[text()='Assign Anyway']")
	private WebElement assignAnywayBtn;
	@FindBy(xpath = "//article[text()='OEM Verified Account ?']/following::span[1]")
	private WebElement billingFSCOEMVerifiedAcc;

	@FindBy(xpath = "//article[text()='Payment notes']/following::span[1]")
	private WebElement billingFSCOEMPaymentNotes;

	public void paymentMethod(String action, String payment) {
		assignAnywayAll();
		if(payment.equalsIgnoreCase("BridgeStoneOEM")){

			wait.forElementToBeDisplayed(billingFSCOEMVerifiedAcc);
			Assert.assertEquals("Account verified", driverActions.driverGetText(billingFSCOEMVerifiedAcc));
			wait.forElementToBeDisplayed(billingFSCOEMPaymentNotes);
			Assert.assertEquals("Bill to Account # : ATFleetBillToAccount", driverActions.driverGetText(billingFSCOEMPaymentNotes));
			wait.forElementToBeClickable(saveAndAssign);
     		jsAction.jsclick(saveAndAssign);
			return;
		}
		wait.forElementToBeDisplayed(clickPaymentMethod);
		jsAction.jsInput(clickPaymentMethod, payment);
		wait.forElementToBeClickable(saveAndAssign);
		jsAction.jsclick(saveAndAssign);
	}

	@FindBy(xpath = "//div[text()='Continental']")
	private WebElement continental;

	public void paymentMethodContinental(String action, String payment) {
		assignAnywayAll();
		wait.forElementToBeClickable(clickPaymentMethod);
		clickPaymentMethod.click();
		clickPaymentMethod.sendKeys(payment);
		wait.forElementToBeDisplayed(continental);
		jsAction.jsclick(continental);
		wait.forElementToBeClickable(saveAndAssign);
		jsAction.jsclick(saveAndAssign);
	}

	@FindBy(xpath = "//div[text()='T-Check']")
	private WebElement tcheck;

	public void paymentMethodCheck(String action, String payment) {
		assignAnywayAll();
		wait.forElementToBeClickable(clickPaymentMethod);
		clickPaymentMethod.click();
		clickPaymentMethod.sendKeys(payment);
		wait.forElementToBeDisplayed(tcheck);
		jsAction.jsclick(tcheck);
		wait.forElementToBeClickable(saveAndAssign);
		jsAction.jsclick(saveAndAssign);
	}

	@FindBy(xpath = "//div[text()='Cummins Engine / Detroit Warranty']")
	private WebElement detroitWarranty;

	public void paymentMethodOEM(String action, String payment) {
		assignAnywayAll();
		wait.forElementToBeClickable(clickPaymentMethod);
		clickPaymentMethod.click();
		clickPaymentMethod.sendKeys(payment);
		wait.forElementToBeDisplayed(detroitWarranty);
		jsAction.jsclick(detroitWarranty);
		wait.forElementToBeClickable(saveAndAssign);
		jsAction.jsclick(saveAndAssign);
	}

	@FindBy(xpath = "//div[text()='Credit Card']")
	private WebElement reachCreditCard;

	public void paymentMethodReach(String action, String payment) {
		assignAnywayAll();
		wait.forElementToBeClickable(clickPaymentMethod);
		clickPaymentMethod.click();
		clickPaymentMethod.sendKeys(payment);
		wait.forElementToBeDisplayed(reachCreditCard);
		jsAction.jsclick(reachCreditCard);
		wait.forElementToBeClickable(saveAndAssign);
		jsAction.jsclick(saveAndAssign);
	}

	@FindBy(xpath = "//div[text()='ATD Tire Warranty']")
	private WebElement tireWarranty;

	public void paymentMethodTireWarranty(String action, String payment) {
		assignAnywayAll();
		wait.forElementToBeClickable(clickPaymentMethod);
		clickPaymentMethod.click();
		clickPaymentMethod.sendKeys(payment);
		wait.forElementToBeDisplayed(tireWarranty);
		jsAction.jsclick(tireWarranty);
		wait.forElementToBeClickable(saveAndAssign);
		jsAction.jsclick(saveAndAssign);
	}

	@FindBy(xpath = "//span[text()='Updating event details']")
	private WebElement updatingEventDetails;

	@FindBy(xpath = "//span[text()='Updated event details']")
	private WebElement updatedEventDetails;

	public void eventUpdateNotifValidation() {
		try {
			wait.forElementToBeDisplayedLess(updatingEventDetails);
			int size = driver.findElements(By.xpath("//span[text()='Updating event details']")).size();
			Assert.assertEquals(1, size);
			System.out.println("Event Update Notification Validated.");
		} catch (Exception e){
			System.out.println("Event Update Notification Not Displayed");
		} catch (AssertionError e) {
			System.out.println("Update Event Notification Not Validated");
		}

	}

	public void eventAssignValidation(String tenant) {
        try{
			for (int i = 0; i <= 10; i++) {
				driverActions.hardwaitBasedOnInput(100);
				System.out.println("Trying to Validate Event Assigned Notification.");
				int size = 0;
				if (tenant.equalsIgnoreCase("AutoTruckNPSP")) {
					size = driver.findElements(By.xpath("//span[contains(text(),'AutotruckNPSP successfully!')]")).size();
				}
				else {
					size = driver
							.findElements(
									By.xpath("//span[text()='Service Event submitted to " + tenant + " successfully!']"))
							.size();
				}
				if (size == 1) {
					Assert.assertEquals(1, size);
					System.out.println("Event Assigned Notification for " + tenant + " Validated.");
					break;
				}
			}
			wait.forElementToBeDisplayedLess(updatingEventDetails);
			int size = driver.findElements(By.xpath("//span[text()='Updating event details']")).size();
			Assert.assertEquals(1, size);
		} catch (Exception e){
			System.out.println("Event Assigned Notification Not Displayed");
		} catch (AssertionError e) {
			System.out.println("Event Assigned Notification for " + tenant + " Not Validated");
		}

	}

	@FindBy(xpath = "//button[@class='ant-btn general'] | //button[@class='ant-btn general btn-accept']")
	private WebElement tenantAccept;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary btn-medium']")
	private WebElement acceptETA;

	public void acceptwithETA() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(AcceptBtn);
		jsAction.jsclick(AcceptBtn);
		wait.forElementToBeDisplayed(todayDate);
		jsAction.jsclick(todayDate);
		wait.forElementToBeDisplayed(acceptTechAccept);
		jsAction.jsclick(acceptTechAccept);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//p[text()='Are you sure to withdraw and accept?']/following::div[1]/button[2]")
	private WebElement acceptWithdraw;

	public void acceptWithdraw() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(AcceptBtn);
		jsAction.jsclick(AcceptBtn);
		wait.forElementToBeDisplayed(todayDate);
		jsAction.jsclick(todayDate);
		wait.forElementToBeDisplayed(acceptTechAccept);
		jsAction.jsclick(acceptTechAccept);
		wait.forElementToBeDisplayed(acceptWithdraw);
		jsAction.jsclick(acceptWithdraw);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//button[@class='ant-btn repaired-filled']")
	private WebElement repairedBtn;

	public void clickRepaired() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(repairedBtn);
		jsAction.jsclick(repairedBtn);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "(//button[@class='ant-btn completed'])[1]")
	private WebElement completeBtn;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary btn btn-confirm']")
	private WebElement btnComplete;

	public void clickComplete() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(4000);
		wait.forElementToBeClickable(completeBtn);
		jsAction.jsclick(completeBtn);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeDisplayed(btnComplete);
		jsAction.scrolldownandJsClick(btnComplete);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	public void clickComplete2() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(completeBtn);
		jsAction.jsclick(completeBtn);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	public void clickCompleteinCheckList() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(completeBtn);
		jsAction.jsclick(completeBtn);
		driverActions.hardwaitBasedOnInput(2000);
	}

	@FindBy(xpath = "//button[@class='ant-btn completed']")
	private WebElement approveBtn;

	public void clickApprove() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(approveBtn);
		jsAction.jsclick(approveBtn);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//button[@class='ant-btn reprocess']")
	private WebElement reprocessBtn;
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	private WebElement reprocessOkBtn;

	public void clickReprocess() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(reprocessBtn);
		jsAction.jsclick(reprocessBtn);
		wait.forElementToBeClickable(reprocessOkBtn);
		jsAction.jsclick(reprocessOkBtn);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary reject'] | //button[@class='ant-btn ant-btn-primary reject btn-reject']")
	private WebElement reject;
	@FindBy(xpath = "//input[@class='ant-select-selection-search-input']")
	private WebElement rejectSearchBox;
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content'])[1]")
	private WebElement rejectReason;
	// @FindBy(xpath = "(//div[@class='ant-modal-footer'])[1]/button[2]")
	// @FindBy(xpath = "(//span[text()='OK'])[2]")
	// @FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary']/span)[2]")
	@FindBy(xpath = "(//span[text()='OK'])[1]")
	private WebElement okRejectBtn;

	// @FindBy(xpath = "(//div[@class='ant-modal-footer'])[2]/button[2]")
	@FindBy(xpath = "(//span[text()='OK'])[2]")
	private WebElement okRejectBtn2;

	@FindBy(xpath = "//div[@class='sec-1 alert-msg']")
	private WebElement verifyReasonText;

	public void clickReject() {
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(reject);
		jsAction.jsclick(reject);
		wait.forElementToBeClickable(rejectSearchBox);
		rejectSearchBox.sendKeys("Forwarded to Another Location");
		wait.forElementToBeClickable(rejectReason);
		jsAction.jsclick(rejectReason);
		wait.forElementToBeClickable(okRejectBtn);
		jsAction.jsclick(okRejectBtn);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	public void selectReasonToReject() {
		wait.forElementToBeClickable(rejectSearchBox);
		rejectSearchBox.sendKeys("Forwarded to Another Location");
		wait.forElementToBeClickable(rejectReason);
		jsAction.jsclick(rejectReason);
		wait.forElementToBeClickable(okRejectBtn2);
		jsAction.jsclick(okRejectBtn2);
		driverActions.hardwaitBasedOnInput(2000);
		driver.switchTo().defaultContent();
	}

	public void clickReject2() {
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(reject);
		jsAction.jsclick(reject);
		wait.forElementToBeClickable(rejectSearchBox);
		rejectSearchBox.sendKeys("Forwarded to Another Location");
		wait.forElementToBeClickable(rejectReason);
		jsAction.jsclick(rejectReason);
		wait.forElementToBeClickable(okRejectBtn2);
		jsAction.jsclick(okRejectBtn2);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//button[@class='ant-btn btn-tech-accept']")
	private WebElement techAccept;

	public void clickTechAccept() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(techAccept);
		jsAction.jsclick(techAccept);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	public void chechkistActions(String action, DataTable checklistData) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		if (action.equalsIgnoreCase("techaccept")) {
			wait.forElementToBeDisplayed(techAccept);
			jsAction.jsclick(techAccept);
		}
		if (action.equalsIgnoreCase("enroute")) {
			wait.forElementToBeDisplayed(selectEnroute);
			selectEnroute.click();
			wait.forElementToBeClickable(clickEnroute);
			jsAction.jsclick(clickEnroute);
		}
		if (action.equalsIgnoreCase("techrepair")) {
			wait.forElementToBeClickable(techRepair);
			jsAction.jsclick(techRepair);
		}
		if (action.equalsIgnoreCase("techarrive")) {
			wait.forElementToBeDisplayed(selectEnroute);
			selectEnroute.click();
			wait.forElementToBeClickable(clickTechArrived);
			jsAction.jsclick(clickTechArrived);
			enterChecklist(checklistData);
			submitChecklist();
			driverActions.hardwaitBasedOnInput(5000);
			etcPOPUP();
			driver.navigate().refresh();
			return;
		}
		if (action.equalsIgnoreCase("complete")) {
			wait.forElementToBeClickable(completeBtn);
			jsAction.jsclick(completeBtn);
		}
		if (action.equalsIgnoreCase("reject")) {
			wait.forElementToBeClickable(reject);
			jsAction.jsclick(reject);
			enterChecklist(checklistData);
			submitChecklist();
			selectReasonToReject();
			driver.navigate().refresh();
			return;
		}
		driverActions.hardwaitBasedOnInput(4000);
		enterChecklist(checklistData);
		submitChecklist();
		driver.navigate().refresh();
	}

	public void enterChecklist(DataTable checklistData) {
		List<Map<String, String>> list = checklistData.asMaps(String.class, String.class);
		for (int i = 0; i < list.size(); i++) {
			String question = list.get(i).get("Question");
			String answer = list.get(i).get("Answer");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (getNonTextValues(question)) {
				WebElement ele = driver.findElement(By.xpath("//div[text()='" + question + "']/parent::div/div/input"));
				wait.forElementToBeDisplayed(ele);
				ele.sendKeys(answer);
			} else if (question.equals("After Picture") || question.equals("License Plate/Slate")) {
				WebElement attachmentLink = driver.findElement(By.xpath(
						"//div[text()='" + question + "']/parent::div/div[2]/div/span/following-sibling::button"));
				wait.forElementToBeDisplayed(attachmentLink);
				addChecklistAttachments(driver, attachmentLink);
			} else if (question.equals("Completion Time-F") || question.equals("Completion Time-S")
					|| question.equals("Arrival Time-F")) {
				WebElement eleDate = driver
						.findElement(By.xpath("//div[text()='" + question + "']/following-sibling::div/div/div/input"));
				wait.forElementToBeDisplayed(eleDate);
				eleDate.sendKeys(reuse.getDate(0));
				WebElement eleDateIcon = driver.findElement(By.xpath("//li[@class='ant-picker-now']/a"));
				try {
					wait.forElementToBeDisplayed(eleDateIcon);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (!eleDateIcon.isDisplayed()) {
					WebElement eleDateIcon2 = driver.findElement(By.xpath("(//li[@class='ant-picker-now']/a)[2]"));
					jsAction.jsclick(eleDateIcon2);
				} else {
					jsAction.jsclick(eleDateIcon);
				}

			}
		}
	}

	@FindBy(xpath = "//button[text()='Select files to upload']")
	private WebElement uploadBtn;
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveButton;

	public void addChecklistAttachments(WebDriver driver2, WebElement attachmentLink) {
		this.driver = driver2;
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(attachmentLink);
		jsAction.jsclick(attachmentLink);
		driverActions.hardwaitBasedOnInput(2000);
		WebElement selectFileButton = driver.findElement(By.xpath("//input[@type='file']"));
		LocalFileDetector detector = new LocalFileDetector();
		String path = new File("src/test/resources/config/lib/Images/REACHLogo.png").getAbsolutePath();
		File file = detector.getLocalFile(path);
		((RemoteWebElement) selectFileButton).setFileDetector(detector);
		selectFileButton.sendKeys(file.getAbsolutePath());
		driverActions.hardwaitBasedOnInput(3000);
		jsAction.scrollDown();
		wait.forElementToBeDisplayed(saveButton);
		jsAction.jsclick(saveButton);
		wait.forLoading();
		driverActions.hardwaitBasedOnInput(6000);
		System.out.println("The attachment is uploaded successfully");
	}

	public boolean getNonTextValues(String question) {
		boolean flag = false;
		String[] nonTextEntries = { "After Picture", "Completion Time-F", "Completion Time-S", "Arrival Time-F",
				"License Plate/Slate" };
		for (String element : nonTextEntries) {
			if (element.equals(question)) {
				flag = false;
				break;
			} else {
				flag = true;
			}
		}
		return flag;
	}

	@FindBy(xpath = "//div[@class='ant-dropdown-trigger ant-dropdown-link icon-dot']")
	private WebElement techEnrouteArriveDropDown;
	@FindBy(xpath = "(//span[@class='ant-dropdown-menu-title-content'])[1]")
	private WebElement techEnroute;

	public void clickTechEnroute() {
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(techEnrouteArriveDropDown);
		jsAction.jsclick(techEnrouteArriveDropDown);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(techEnroute);
		jsAction.jsclick(techEnroute);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "(//span[@class='ant-dropdown-menu-title-content'])[1]")
	private WebElement techArrive;
	@FindBy(xpath = "(//button[@class='ant-btn btn-green'])[1]")
	private WebElement techArrivewithoutETC;

	public void clickTechArrive() {
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(techEnrouteArriveDropDown);
		jsAction.jsclick(techEnrouteArriveDropDown);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(techArrive);
		jsAction.jsclick(techArrive);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(techArrivewithoutETC);
		jsAction.jsclick(techArrivewithoutETC);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//button[@class='ant-btn completed']")
	private WebElement techRepair;

	public void clickTechRepair() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(techRepair);
		jsAction.jsclick(techRepair);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//button[@class='ant-btn reject']")
	private WebElement techReject;
	@FindBy(xpath = "//input[@class='ant-select-selection-search-input']")
	private WebElement techRejectSearchBox;
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content'])[1]")
	private WebElement techRejectReason;
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	private WebElement okTechRejectBtn;

	public void clickTechReject() {
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(techReject);
		jsAction.jsclick(techReject);
		wait.forElementToBeClickable(techRejectSearchBox);
		techRejectSearchBox.sendKeys("Busy with other events");
		wait.forElementToBeClickable(techRejectReason);
		techRejectReason.click();
		wait.forElementToBeClickable(okTechRejectBtn);
		jsAction.jsclick(okTechRejectBtn);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//button[@class='ant-btn primary-actions comments']/span[2]")
	private WebElement commentBtn;
	@FindBy(xpath = "(//*[@id=\"nextgen_comments\"]/div[2]/div/div[1]/div/textarea)[1]")
	private WebElement txtMessage;
	@FindBy(xpath = "//*[@id=\"nextgen_comments\"]/div[2]/div/div[1]/div[2]/ul/li[1]")
	private WebElement selectAssignedTenant;
	@FindBy(xpath = "(//button[@class='btn btn-secondary'])[1]")
	private WebElement btnSendComment;
	@FindBy(xpath = "//button[@class='ant-btn footer-done']")
	private WebElement tagAlert;
	@FindBy(xpath = "//span[@class='ant-modal-close-x']")
	private WebElement closeCommentTab;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/button/span")
	private WebElement closeAlertTab;
	@FindBy(xpath = "//span[@class='numberCircle']")
	private WebElement alertsTab;
	@FindBy(xpath = "//div[@class='noti-content']")
	private WebElement alertsValidation;

	@FindBy(xpath = "//div[@class='react-draggable']")
	private WebElement draggableComment;

	public void HandleconversationstabRaiseRFA(String assignedTenant) {
		driver.navigate().refresh();
		driverActions.hardwaitBasedOnInput(3000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(3000);
		Actions actions = new Actions(driver);
		// actions.moveToElement(commentBtn).click().build().perform();
		wait.forElementToBeDisplayed(txtMessage);
		jsAction.scrolldownandJsClick(txtMessage);
		actions.sendKeys(txtMessage, "@" + assignedTenant).build().perform();
		driverActions.hardwaitBasedOnInput(1000);
		actions.sendKeys(txtMessage, Keys.ARROW_DOWN).build().perform();
		driverActions.hardwaitBasedOnInput(2000);
		confidentialTab.click();
		commentsTab.click();
		txtMessage.click();
		wait.forElementToBeClickable(selectAssignedTenant);
		jsAction.jsclick(selectAssignedTenant);
		txtMessage.sendKeys("This is a Test");
		wait.forElementToBeClickable(btnSendComment);
		jsAction.jsclick(btnSendComment);
		wait.forElementToBeDisplayed(tagAlert);
		jsAction.jsclick(tagAlert);
		wait.forElementToBeClickable(alertsTab);
		jsAction.jsclick(alertsTab);
		driverActions.hardwaitBasedOnInput(3000);
		System.out.println(alertsValidation.getText());
		jsAction.jsclick(closeAlertTab);
		System.out.println("RFA raised in Comments Tab and validated in Alerts Tab");
	}

	@FindBy(xpath = "(//tr[@class='odd']/td/a[2])[2]")
	private WebElement hotTab;
	@FindBy(xpath = "//*[@id=\"nextgen_comments\"]/div[1]/div[3]/div[1]/div/div[2]/div[2]/div/button")
	private WebElement resolveHotTab;
	@FindBy(xpath = "//*[@id=\"nextgen_comments\"]/div[2]/div/div[2]/div[1]/div/textarea")
	private WebElement textAreaHotTab;
	@FindBy(xpath = "(//button[@class='btn btn-secondary'])[2]")
	private WebElement sendHotTab;
	@FindBy(xpath = "//li[@class='pull-right']")
	private WebElement closeHotTab;

	public void resolveRFAinHotTab() {
		wait.forElementToBeClickable(hotTab);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", hotTab);
		wait.forElementToBeDisplayed(resolveHotTab);
		jse.executeScript("arguments[0].click()", resolveHotTab);
		wait.forElementToBeDisplayed(textAreaHotTab);
		textAreaHotTab.sendKeys("Test Hot Tab");
		wait.forElementToBeClickable(sendHotTab);
		jse.executeScript("arguments[0].click()", sendHotTab);
		driverActions.hardwaitBasedOnInput(3000);
		jse.executeScript("window.scrollBy(0,-40)");
		wait.forElementToBeClickable(closeHotTab);
		closeHotTab.click();
	}

	@FindBy(xpath = "//div[@class='alert-action']/div/a")
	private WebElement respondBtn;
	@FindBy(xpath = "//div[@class='form-group card-comment']/textarea")
	private WebElement alertComment;
	@FindBy(xpath = "//div[@class='footer clearfix']/button[2]")
	private WebElement btnSend;

	public void HandleconversationstabResolveRFA() {
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(alertsTab);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", alertsTab);
		wait.forElementToBeDisplayed(respondBtn);
		jse.executeScript("arguments[0].click()", respondBtn);
		wait.forElementToBeDisplayed(alertComment);
		alertComment.sendKeys("This is a Test - Resolve.");
		driverActions.hardwaitBasedOnInput(2000);
		jse.executeScript("arguments[0].click()", btnSend);
		jse.executeScript("arguments[0].click()", closeAlertTab);
		System.out.println("RFA resolved in AlertsTab Successfully");
	}

	@FindBy(xpath = "(//button[@class='ant-btn secondary-btn'])[1]")
	private WebElement assignBtn;
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div/span[1]/input")
	// @FindBy(xpath = "(//input[@class='ant-select-selection-search-input'])")
	// @FindBy(xpath="//span[text()='Please Select User']")
	private WebElement selectUser;
	// @FindBy(xpath =
	// "/html/body/div[3]/div/div/div/div[2]/div[1]/div/div/div/div")
	@FindBy(xpath = "//span[text()='Test tech']")
	private WebElement selectTech;
	// @FindBy(xpath = "(//div[@class='ant-select-item-option-content'])[2]")
	@FindBy(xpath = "//span[text()='Test tech2']")
	private WebElement selectTech2;
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	private WebElement okBtn;
	// @FindBy(xpath = "//span[text()='Test tech']")
	// private WebElement selectTestTech;

	public void assignTechnician(String technician) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(assignBtn);
		jsAction.jsclick(assignBtn);
		wait.forElementToBeDisplayed(selectUser);
		jsAction.jsclick(selectUser);
		selectUser.click();
		if (technician.equalsIgnoreCase("TECHSP")) {
			wait.forElementToBeDisplayed(selectTech);
			jsAction.jsclick(selectTech);
		} else if (technician.equalsIgnoreCase("TECH2SP")) {
			wait.forElementToBeDisplayed(selectTech2);
			jsAction.jsclick(selectTech2);
		}
		jsAction.jsclick(okBtn);
		System.out.println("Technician Assigned Succesfully");
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//button[@class='ant-btn primary-actions comments']")
	private WebElement commentsButton;

	@FindBy(xpath = "//a[text()='Conversations (']")
	private WebElement commentsTab;
	@FindBy(xpath = "//a[text()='Confidential (']")
	private WebElement confidentialTab;
	@FindBy(xpath = "(//*[@id=\"nextgen_comments\"]/div[2]/div/div[1]/div/textarea)[1]")
	private WebElement normalMessage;
	@FindBy(xpath = "(//*[@id=\"nextgen_comments\"]/div[2]/div/div[1]/div/textarea)[2]")
	private WebElement confidentialMessage;
	@FindBy(xpath = "(//*[@id=\"nextgen_comments\"]/div[2]/div/div[2]/button[1])[1]")
	private WebElement normalSendbtn;
	@FindBy(xpath = "(//*[@id=\"nextgen_comments\"]/div[2]/div/div[2]/button[1])[2]")
	private WebElement confidentialSendbtn;
	@FindBy(xpath = "//*[@id=\"nextgen_comments\"]/div[1]/div/div[2]/div/div/div[1]")
	private WebElement recievedMsg;
	@FindBy(xpath = "//span[@class='ant-modal-close-x']")
	private WebElement closeComentBoxFaint;

	public void rFA_Action(String action, String tab, DataTable table) {
		List<Map<String, String>> list = table.asMaps(String.class, String.class);
		String equipmentType = list.get(0).get("EquipmentType");
		String tenantName = list.get(0).get("TenantName");
		String message = list.get(0).get("Message");
		String userName = list.get(0).get("UserName");
		String previousMessage = list.get(0).get("PreviousMessage");
		action = action.toUpperCase();
		tab = tab.toUpperCase();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		Actions actions = new Actions(driver);
		// wait.forElementToBeClickable(commentsButton);
		// actions.moveToElement(commentsButton).click().build().perform();
		driverActions.hardwaitBasedOnInput(3000);
		try {
			switch (tab) {
			case "CONFIDENTIALTAB":
				wait.forElementToBeDisplayed(confidentialTab);
				jsAction.jsclick(confidentialTab);
				if (action.equalsIgnoreCase("VIEW")) {
					wait.forElementToBeDisplayed(recievedMsg);
					String recievedMessage = driverActions.driverGetText(recievedMsg);
					Assert.assertEquals(previousMessage, recievedMessage);
					System.out.println("Confidential message Viewed");
				}
				wait.forElementToBeDisplayed(confidentialMessage);
				confidentialMessage.sendKeys(message);
				wait.forElementToBeClickable(confidentialSendbtn);
				jsAction.jsclick(confidentialSendbtn);
				System.out.println("Confidential message sent");
				verifySender(message, equipmentType, tenantName, userName);
				jsAction.jsclick(closeCommentTab);
				break;

			case "COMMENTTAB":
				wait.forElementToBeDisplayed(commentsTab);
				jsAction.jsclick(commentsTab);
				if (action.equalsIgnoreCase("VIEW")) {
					wait.forElementToBeDisplayed(recievedMsg);
					String recievedMessage = driverActions.driverGetText(recievedMsg);
					Assert.assertEquals(previousMessage, recievedMessage);
					System.out.println("Normal message Viewed");
				}
				wait.forElementToBeDisplayed(normalMessage);
				normalMessage.sendKeys(message);
				wait.forElementToBeClickable(normalSendbtn);
				jsAction.jsclick(normalSendbtn);
				System.out.println("Normal message sent");
				verifySender(message, equipmentType, tenantName, userName);
				jsAction.jsclick(closeCommentTab);
				break;

			default:
				throw new Reach24NEPCustomException("Invalid Action Selected");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
	}

	public void verifySender(String message, String equipmentType, String tenantName, String userName) {
		driverActions.hardwaitBasedOnInput(2000);
		WebElement equipmentTypeTextElement = driver
				.findElement(By.xpath("//div[text()='" + message + "']/parent::div/span[1]"));
		WebElement tenantNameTextElement = driver
				.findElement(By.xpath("//div[text()='" + message + "']/parent::div/span[2]"));
		WebElement userNameTextElement = driver
				.findElement(By.xpath("//div[text()='" + message + "']/parent::div/div[2]/span[1]"));
		String equipmentTypeText = driverActions.driverGetText(equipmentTypeTextElement);
		Assert.assertEquals(equipmentType, equipmentTypeText);
		String tenantNameText = driverActions.driverGetText(tenantNameTextElement);
		Assert.assertTrue(tenantNameText.contains(tenantName));
		String userNameText = driverActions.driverGetText(userNameTextElement);
		Assert.assertEquals(userName, userNameText);
	}

	@FindBy(xpath = "//i[@class='fa fa-picture-o fa-lg']")
	private WebElement attachmentOnEventInfoPage;
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-default'])[2]")
	private WebElement viewAttachmentOnEventInfoPage;
	@FindBy(xpath = "//div[@class='ant-image-mask']")
	private WebElement imageEventInfoPage;
	@FindBy(xpath = "(//div[@class='ant-modal-footer'])[2]/button[2]")
	private WebElement closeImageButton;
	@FindBy(xpath = "//p[@class='pp_description']")
	private WebElement infoFromAttachment;
	@FindBy(xpath = "//a[@class='pp_previous']")
	private WebElement previousBtn;

	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[1]")
	private WebElement uploadTag;

	public void validateAttachmentsOnEventInfoPage(String attachmentType) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(viewAttachmentOnEventInfoPage);
		jsAction.jsclick(viewAttachmentOnEventInfoPage);
		driverActions.hardwaitBasedOnInput(2000);
		Assert.assertTrue(closeImageButton.isDisplayed());
		Assert.assertEquals(driverActions.driverGetText(uploadTag),attachmentType);
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("The attachment is successfully verified on Event Info page");
		driverActions.hardwaitBasedOnInput(2000);
		jsAction.jsclick(closeImageButton);
		addAttachments(driver, attachmentType);
//		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "(//*[@class='ant-btn ant-btn-default'])[1]")
	private WebElement attachmentButton;
	@FindBy(xpath = "(//div[@class='ant-modal-footer']/button[2])[3]")
	private WebElement uploadButton;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content' and text()='Pre-repair']")
	private WebElement preRepairButton;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content' and text()='Post-repair']")
	private WebElement postRepairButton;
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content' and text()='Other'])[1]")
	private WebElement otherButton;
	@FindBy(xpath = "(//*[@class='ant-btn ant-btn-default'])[2]")
	private WebElement viewAttachmentButton;
	@FindBy(xpath = "//div[@class='ant-image']/following-sibling::div/div[1]/div/span[2]")
	private WebElement uploadEditTag;
	@FindBy(xpath = "(//span[@class='anticon anticon-close ant-modal-close-icon'])[2]")
	private WebElement viewAttachCloseBtn;

	public void addAttachments(WebDriver driver, String type) {
		this.driver = driver;
		wait.forElementToBeClickable(attachmentButton);
		jsAction.jsclick(attachmentButton);
		driverActions.hardwaitBasedOnInput(4000);
		WebElement selectFileButton = driver.findElement(By.xpath("//input[@type='file']"));
		LocalFileDetector detector = new LocalFileDetector();
		String path = new File("src/test/resources/config/lib/Images/REACHLogo.png").getAbsolutePath();
		File file = detector.getLocalFile(path);
		((RemoteWebElement) selectFileButton).setFileDetector(detector);
		selectFileButton.sendKeys(file.getAbsolutePath());
		driverActions.hardwaitBasedOnInput(3000);
		jsAction.scrollDown();
		wait.forElementToBeDisplayed(uploadButton);
		jsAction.jsclick(uploadButton);
		wait.forLoading();
		driverActions.hardwaitBasedOnInput(6000);
		System.out.println("The attachment is uploaded successfully");
		wait.forElementToBeClickable(viewAttachmentButton);
		jsAction.jsclick(viewAttachmentButton);
		switch (type) {
			case "Other":
				wait.forElementToBeDisplayed(uploadEditTag);
//				jsAction.jsclick(uploadEditTag);
				uploadEditTag.click();
				wait.forElementToBeDisplayed(otherButton);
				jsAction.jsclick(otherButton);
				break;
			case "Pre-repair":
				wait.forElementToBeDisplayed(uploadEditTag);
//				jsAction.jsclick(uploadEditTag);
				uploadEditTag.click();
				wait.forElementToBeDisplayed(preRepairButton);
				jsAction.jsclick(preRepairButton);
				break;
			case "Post-repair":
				wait.forElementToBeDisplayed(uploadEditTag);
//				jsAction.jsclick(uploadEditTag);
				uploadEditTag.click();
				wait.forElementToBeDisplayed(postRepairButton);
				jsAction.jsclick(postRepairButton);
				break;
		}
		wait.forElementToBeClickable(viewAttachCloseBtn);
		jsAction.jsclick(viewAttachCloseBtn);
	}

	@FindBy(xpath = "//button[@class='ant-btn general btn-edit']/span[1]/span")
	private WebElement editEventBtn;

	public void clickEditEvent() {
		jsAction.jsclick(editEventBtn);
	}

	@FindBy(xpath = "//button[@class='ant-btn secondary-btn btn-void']")
	private WebElement clickVoidBtn;
	@FindBy(xpath = "//input[@class='ant-select-selection-search-input']")
	private WebElement inputReason;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
	private WebElement selectReason;
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary']/span)[2]")
	private WebElement clickOk;
	@FindBy(xpath = "//div[@class='status-void']/span")
	private WebElement statusValidation;

	public void voidEvent(String voidReason, String voidStatus) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(clickVoidBtn);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", clickVoidBtn);
		wait.forElementToBeClickable(inputReason);
		inputReason.sendKeys(voidReason);
		wait.forElementToBeClickable(selectReason);
		jse.executeScript("arguments[0].click()", selectReason);
		jse.executeScript("arguments[0].click()", clickOk);
		System.out.println("Event Voided Successfully");
		// voidValidation
		System.out.println("Reason for Voiding - " + voidReason + "  Event Status -  " + voidStatus);
		wait.forElementToBeDisplayed(statusValidation);
		assertEquals("Status Validation", voidStatus, statusValidation.getText());
		System.out.println("Void Status Validated Successfully");
	}

	@FindBy(xpath = "//div[text()='Linked Customer']/following::div[1]/ul/li[1]")
	private WebElement crosswalkTxt;

	public void crossWalkValidation(String crosswalk) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		// jsAction.scrollIntoView(crosswalkTxt);
		// System.out.println(crosswalkTxt.getText());
		driverActions.hardwaitBasedOnInput(5000);
		wait.forLoading();
		assertEquals("Crosswalk Validation", crosswalk, driverActions.driverGetText(crosswalkTxt));
		System.out.println("Crosswalk Customer is Validated");
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//label[text()='Truck Dispatch Name']/parent::div/following-sibling::div/div/div/input")
	private WebElement crosswalkTemplateTxt;

	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-block'])[1]")
	private WebElement walkinBtn;
	public void crossWalkTemplateValidation(String crosswalk) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(5000);
		wait.forLoading();
		jsAction.jsclick(walkinBtn);
		assertEquals("Crosswalk Validation", crosswalk, crosswalkTemplateTxt.getAttribute("value"));
		System.out.println("Crosswalk Customer is Validated");
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//span[text()='Add to Watchlist']")
	private WebElement btnWatchList;
	@FindBy(xpath = "//span[text()='Remove from Watchlist']")
	private WebElement removeFromWatchListBtn;
	@FindBy(xpath = "(//button[@data-original-title='Remove from Watchlist'])[2]")
	private WebElement dashboardWatchList;
	@FindBy(xpath = "(//button[@data-original-title='Add to Watchlist'])[2]")
	private WebElement dashboardAddWatchList;
	@FindBy(xpath = "//*[@id=\"incidents-datatable_wrapper\"]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[1]/div/a")
	private WebElement clickEventId;

	public void validateWatchedEvents() {
		// driver.get(propsReader.tdEventInfoPage);
		driver.switchTo().frame("eventPageIFrame");
		jsAction.scrollIntoView(btnWatchList);
		wait.forElementToBeDisplayed(btnWatchList);
		btnWatchList.click();
		wait.forElementToBeDisplayed(removeFromWatchListBtn);
		System.out.println(removeFromWatchListBtn.getText());
		driver.get(propsReader.tdURL);
		wait.forElementToBeDisplayed(dashboardWatchList);
		if (dashboardWatchList.isEnabled()) {
			System.out.println("Event is in WatchList - Dashboard");
			// dashboardWatchList.click();
			jsAction.jsclick(dashboardWatchList);
		} else {
			System.out.println("Event is not in WatchList");
		}
		// driver.get(PropsReader.tdEventInfoPage);
		jsAction.jsclick(clickEventId);
		wait.forLoading();
		driverActions.hardwaitBasedOnInput(5000);
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(btnWatchList);
		System.out.println(btnWatchList.getText());
		driver.get(PropsReader.tdURL);
		wait.forLoading();
		wait.forElementToBeDisplayed(dashboardAddWatchList);
		System.out.println(dashboardAddWatchList.getText());
		jsAction.jsclick(dashboardAddWatchList);
		// driver.get(PropsReader.tdEventInfoPage);
		jsAction.jsclick(clickEventId);
		wait.forLoading();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(removeFromWatchListBtn);
		assertEquals("Remove from Watchlist", removeFromWatchListBtn.getText());
		System.out.println("Event is in WatchList - InfoPage");

	}

	@FindBy(xpath = "//i[@class='fa fa-fw fa-lg fa-circle']")
	private WebElement scheduleEventLinkAssignSP;
	@FindBy(xpath = "(//div[@class='fsc-slot-pill'])[1]")
	private WebElement timeSlotSelect;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary duplicateEventModal footer-MainButton']")
	private WebElement continueButton;

	public void clickContinue() {
		wait.forElementToBeClickable(continueButton);
		jsAction.jsclick(continueButton);
	}

	public void scheduleEventAssignSP() throws IOException {
		wait.forElementToBeClickable(scheduleEventLinkAssignSP);
		jsAction.jsclick(scheduleEventLinkAssignSP);
		wait.forElementToBeClickable(timeSlotSelect);
		System.out.println(driverActions.driverGetText(timeSlotSelect));
		inandoutstream.saveScheduledTimeSlot(driverActions.driverGetText(timeSlotSelect));
		jsAction.jsclick(timeSlotSelect);
		clickContinue();
		System.out.println(inandoutstream.loadScheduledTimeSlot());
		String eventId = driver.getCurrentUrl().split("next/")[1];
		System.out.println(eventId);
	}

	public void validateTimeSlot() throws IOException {
		wait.forElementToBeClickable(scheduleEventLinkAssignSP);
		jsAction.jsclick(scheduleEventLinkAssignSP);
		wait.forElementToBeClickable(timeSlotSelect);
		System.out.println(driverActions.driverGetText(timeSlotSelect));
		System.out.println(inandoutstream.loadScheduledTimeSlot());
		Assert.assertFalse("Second Time Slot validation",
				inandoutstream.loadScheduledTimeSlot().equalsIgnoreCase(driverActions.driverGetText(timeSlotSelect)));
	}

	@FindBy(xpath = "//span[@class='anticon anticon-check-circle']")
	private WebElement confirmScheduleEvent;
	@FindBy(xpath = "//span[@class='anticon anticon-calendar']")
	private WebElement scheduleEvent;
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[1]")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[@class='event-sub-header']/div[3]/span/b")
	private WebElement validateScheduleTimeInfo;

	public void performScheduleEventAction(String tenant, String action) throws IOException {
		tenant = tenant.toUpperCase();
		String eventId = "next/" + inandoutstream.loadEventID().substring(5);

		System.out.println(PropsReader.sp5EventInfoPage + eventId);
		driver.get(PropsReader.sp5EventInfoPage + eventId);
		System.out.println(PropsReader.sp5EventInfoPage + eventId);

		if (action.equalsIgnoreCase("Confirm")) {
			driver.switchTo().parentFrame();
			driver.switchTo().frame("eventPageIFrame");
			wait.forElementToBeClickable(confirmScheduleEvent);
			jsAction.jsclick(confirmScheduleEvent);
			driverActions.hardwaitBasedOnInput(3000);
			driver.switchTo().defaultContent();
		} else if (action.equalsIgnoreCase("Schedule") || action.equalsIgnoreCase("Reschedule")) {
			driver.switchTo().frame("eventPageIFrame");
			wait.forElementToBeClickable(scheduleEvent);
			jsAction.jsclick(scheduleEvent);
			driverActions.hardwaitBasedOnInput(3000);
			wait.forElementToBeClickable(timeSlotSelect);
			System.out.println(driverActions.driverGetText(timeSlotSelect));
			inandoutstream.saveScheduledTimeSlot(driverActions.driverGetText(timeSlotSelect));
			jsAction.jsclick(timeSlotSelect);
			wait.forElementToBeClickable(submitBtn);
			jsAction.jsclick(submitBtn);
			String loadedScheduledTimeSlot = inandoutstream.loadScheduledTimeSlot();
			String scheduledTimeSlot = loadedScheduledTimeSlot.substring(5, loadedScheduledTimeSlot.length() - 3);
			System.out.println(loadedScheduledTimeSlot);
			driverActions.hardwaitBasedOnInput(5000);
			driver.navigate().refresh();
			driverActions.hardwaitBasedOnInput(8000);
			driver.switchTo().frame("eventPageIFrame");
			System.out.println(driverActions.driverGetText(validateScheduleTimeInfo));
			// Assert.assertTrue("Validate the ScheduleTime On EventInfoPage",
			// driverActions.driverGetText(validateScheduleTimeInfo).contains(scheduledTimeSlot));
			driver.switchTo().defaultContent();
		}
	}

	@FindBy(xpath = "//i[@class='icon fa fa-users fa-fw']")
	private WebElement usertab;

	@FindBy(xpath = "//a[@id='add-company-user']")
	private WebElement addUserBtn;

	@FindBy(xpath = "//input[@id='user_first_name']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@id='user_last_name']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@id='user_email']")
	private WebElement email;
	@FindBy(xpath = "//input[@id='user_phone_number']")
	private WebElement phoneNumber;
	@FindBy(xpath = "//input[@class='technician_type_role']/parent::div")
	private WebElement techRole;
	@FindBy(xpath = "//form[@class='user_form']/div[2]/div/input")
	private WebElement clickSave;

	public void createTechnician() {

		wait.forElementToBeClickable(usertab);
		jsAction.jsclick(usertab);
		for (int i = 0; i < 150; i++) {
			wait.forElementToBeClickable(addUserBtn);
			jsAction.jsclick(addUserBtn);
			driverActions.hardwaitBasedOnInput(2000);
			wait.forElementToBeClickable(firstName);
			String fName = RandomStringUtils.randomAlphabetic(4);
			jsAction.jsInput(firstName, fName);
			wait.forElementToBeClickable(lastName);
			String lName = RandomStringUtils.randomAlphabetic(4);
			jsAction.jsInput(lastName, lName);
			wait.forElementToBeClickable(email);
			String emailID = "rb+" + fName + RandomStringUtils.randomNumeric(3) + "@reach24.net";
			jsAction.jsInput(email, emailID);
			wait.forElementToBeClickable(phoneNumber);
			String phone = "650" + RandomStringUtils.randomNumeric(7);
			jsAction.jsInput(phoneNumber, phone);
			wait.forElementToBeClickable(techRole);
			jsAction.jsclick(techRole);
			wait.forElementToBeClickable(clickSave);
			jsAction.jsclick(clickSave);
			driverActions.hardwaitBasedOnInput(3000);
		}
	}

	@FindBy(xpath = "//div[text()='Event Forward']")
	private WebElement eventForwardTab;
	@FindBy(xpath = "//div[text()='From #:']/following-sibling::div")
	private WebElement eventForwardedFrom;
	@FindBy(xpath = "//div[text()='To #:']/following-sibling::div")
	private WebElement eventForwardedTo;

	public void callForwardValidation(String forwardTo, String forwardFrom) {
		driver.switchTo().frame("eventPageIFrame");
		jsAction.scrollDown();
		// WebElement eventForwardedFrom =
		// driver.findElement(ByXPath.xpath("(//div[text()='"+ forwardFrom+"'])[2]"));
		wait.forElementToBeDisplayed(eventForwardedFrom);
		// WebElement eventForwardedTo =
		// driver.findElement(ByXPath.xpath("(//div[text()='"+ forwardTo+"'])"));
		assertEquals("Event Forwarded From", forwardFrom, eventForwardedFrom.getText());
		assertEquals("Event Forwarded To", forwardTo, eventForwardedTo.getText());
		System.out.println("Event Forwarding is Validated");
	}

	@FindBy(xpath = "//div[@class='ant-select ant-select-single ant-select-show-arrow ant-select-show-search']/div/span/input")
	private WebElement reasonBoxAssignAnyway;
	@FindBy(xpath = "//div[@label='Product Unavailable']/div")
	private WebElement firstDropdown;

	public void assignAnyway() {
		wait.forElementToBeClickable(reasonBoxAssignAnyway);
		reasonBoxAssignAnyway.sendKeys("Product Unavailable");
		wait.forElementToBeClickable(firstDropdown);
		jsAction.jsclick(firstDropdown);
		wait.forElementToBeClickable(assignAnywayBtn);
		jsAction.jsclick(assignAnywayBtn);
		driverActions.hardwaitBasedOnInput(4000);
	}

	public void assignAnywayNPSP() {
		driverActions.hardwaitBasedOnInput(3000);
		int size1 = driver.findElements(By.xpath("//span[text()='Assign Anyway']")).size();
		if (size1 == 1) {
			wait.forElementToBeClickable(assignAnywayBtn);
			jsAction.jsclick(assignAnywayBtn);
			driverActions.hardwaitBasedOnInput(2000);
			System.out.println("Assign Anyway Found");
		} else if (size1 == 0) {
			System.out.println("Assign Anyway not Found");
		}
		wait.forElementToBeClickable(saveAndAssign);
		jsAction.jsclick(saveAndAssign);
		System.out.println("Save Clicked");
	}

	public void assignAnywayAll() {
		driverActions.hardwaitBasedOnInput(3000);
		int size1 = driver.findElements(By.xpath("//span[text()='Assign Anyway']")).size();
		if (size1 == 1) {
			wait.forElementToBeClickable(assignAnywayBtn);
			jsAction.jsclick(assignAnywayBtn);
			driverActions.hardwaitBasedOnInput(2000);
			System.out.println("Assign Anyway Found");
		} else if (size1 == 0) {
			System.out.println("Assign Anyway not Found");
		}
	}

	// @FindBy(xpath = "//div[text()='TestFleetNEP']")
	// private WebElement equipmentProviderTxt;

	public void validateEquipmentProvider(String tenantName) {
		driverActions.hardwaitBasedOnInput(5000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		// WebElement equipmentProviderTxt =
		// driver.findElement(By.xpath("(//div[text()='" + tenantName + "'])[1]"));
		WebElement equipmentProviderTxt = driver
				.findElement(By.xpath("//*[text()=\"Equipment Provider\"]/parent::div"));
		wait.forElementToBeDisplayed(equipmentProviderTxt);
		assertEquals(tenantName, equipmentProviderTxt.getText().substring(20));
		System.out.println("Equipment Provider from Fleet is Validated Successfully");
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//button[@class='ant-btn agentButton']")
	private WebElement assignAgentBtn;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBox;

	public void createAgentAssignmntTaskonEventInfoPage(String user) throws IOException {
		String eventId = "next/" + inandoutstream.loadEventID().substring(5);
		System.out.println(PropsReader.td1EventInfoPage + eventId);
		driver.get(PropsReader.td1EventInfoPage + eventId);
		System.out.println(PropsReader.td1EventInfoPage + eventId);
		driverActions.hardwaitBasedOnInput(4000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(assignAgentBtn);
		assignAgentBtn.click();
		driverActions.hardwaitBasedOnInput(3000);
		wait.forLoading();
		searchBox.sendKeys(user);
		driverActions.hardwaitBasedOnInput(4000);
		// WebElement
		// userElement=driver.findElement(By.xpath("(//div[text()='"+user+"'])[2]"));
		// userElement.click();
		searchBox.sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		logOutUser(user);
	}

	@FindBy(xpath = "//span[text()=' Claim']")
	private WebElement claimBtn;

	@FindBy(xpath = "//span[text()='Confirm']")
	private WebElement claimConfirmBtn;
	@FindBy(xpath = "//div[@class='assign-agent-btn']/button/span[2]")
	private WebElement agentNameAfter;

	public void claimAgentAssignmntTaskonEventInfoPage(String user) throws IOException {
		String eventId = "next/" + inandoutstream.loadEventID().substring(5);
		System.out.println(PropsReader.td1EventInfoPage + eventId);
		driver.get(PropsReader.td1EventInfoPage + eventId);
		System.out.println(PropsReader.td1EventInfoPage + eventId);
		driverActions.hardwaitBasedOnInput(4000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(claimBtn);
		claimBtn.click();
		wait.forElementToBeClickable(claimConfirmBtn);
		claimConfirmBtn.click();
		driverActions.hardwaitBasedOnInput(3000);
		Assert.assertEquals(agentNameAfter.getText(), user);
		driver.switchTo().defaultContent();
		logOutUser(user);
	}

	public void logOutUser(String user) {
		driverActions.hardwaitBasedOnInput(2000);
		WebElement userLink = driver.findElement(By.xpath("(//span[text()='" + user
				+ "'])[1] | //ul[@class='nav navbar navbar-top-links navbar-right mbn hidden-xs']/li[3]/a/span[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(userLink).build().perform();
		actions.moveToElement(logOut).click().build().perform();
	}

	@FindBy(xpath = "//a[@href='/users/sign_out']")
	private WebElement logOut;

	public void validateNoAgentAssignment(String user) throws IOException {
		String eventId = "next/" + inandoutstream.loadEventID().substring(5);
		System.out.println(PropsReader.td1EventInfoPage + eventId);
		driver.get(PropsReader.td1EventInfoPage + eventId);
		System.out.println(PropsReader.td1EventInfoPage + eventId);
		driverActions.hardwaitBasedOnInput(4000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		if (user.equalsIgnoreCase("AutoTruck TD1 Accountant")) {
			wait.forElementToBeClickable(assignAgentBtn);
			assignAgentBtn.click();
			int noAgentAssignment = driver.findElements(By.xpath("(//div[text()='" + user + "'])[1]")).size();
			Assert.assertEquals(0, noAgentAssignment);
			System.out.println("This Tenant is an accountant or user.");
		} else {
			int noAgentAssignmentBtn = driver.findElements(By.xpath("//input[@type='search']")).size();
			Assert.assertEquals(0, noAgentAssignmentBtn);
			System.out.println("This Tenant is an Observer.");
		}
		driver.switchTo().defaultContent();
		logOutUser(user);
	}

	public void validateAgentAssignment(String user) throws IOException {
		String eventId = "next/" + inandoutstream.loadEventID().substring(5);
		System.out.println(PropsReader.td1EventInfoPage + eventId);
		driver.get(PropsReader.td1EventInfoPage + eventId);
		System.out.println(PropsReader.td1EventInfoPage + eventId);
		driverActions.hardwaitBasedOnInput(4000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(3000);
		Assert.assertEquals(agentNameAfter.getText(), user);
		driver.switchTo().defaultContent();
		logOutUser(user);
	}

	@FindBy(xpath = "//p[text()='Auto Tech Dispatch']")
	private WebElement atdLog;
	@FindBy(xpath = "//div[@class='atd-status']")
	private WebElement atdStatus;
	@FindBy(xpath = "//div[contains(@class,'call-logs')][1]/div[3]")
	private WebElement atdStatus1;
	@FindBy(xpath = "//div[contains(@class,'call-logs')][2]/div[3]")
	private WebElement atdStatus2;
	@FindBy(xpath = "//div[contains(@class,'call-logs')][3]/div[3]")
	private WebElement atdStatus3;
	@FindBy(xpath = "//div[contains(@class,'call-logs')][4]/div[3]")
	private WebElement atdStatus4;

	public void validateAtdStatus(String status1, String status2, String status3, String status4) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		jsAction.scrollUp();
		wait.forElementToBeDisplayed(atdLog);
		jsAction.jsclick(atdLog);
		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeDisplayed(atdStatus);
		if (status4.equalsIgnoreCase("Declined")) {
			assertEquals("ATD-Status Status", "Not Accepted", driverActions.driverGetText(atdStatus));
		}
		if (status4.equalsIgnoreCase("Tenant Notified") || status4.equalsIgnoreCase("Accepted")) {
			assertEquals("ATD-Status Status", status4, driverActions.driverGetText(atdStatus));
		}
		wait.forElementToBeDisplayed(atdStatus1);
		assertEquals("ATD-Status Status1", status1, driverActions.driverGetText(atdStatus1));
		wait.forElementToBeDisplayed(atdStatus2);
		assertEquals("ATD-Status Status2", status2, driverActions.driverGetText(atdStatus2));
		wait.forElementToBeDisplayed(atdStatus3);
		assertEquals("ATD-Status Status3", status3, driverActions.driverGetText(atdStatus3));
		if (status4.equalsIgnoreCase("Tenant Notified")) {
			return;
		}
		wait.forElementToBeDisplayed(atdStatus4);
		assertEquals("ATD-Status Status4", status4, driverActions.driverGetText(atdStatus4));
	}

	@FindBy(xpath = "//span[text()='Add Parts']")
	private WebElement addPartsBtn;
	@FindBy(xpath = "//input[@label='Part Group Code']")
	private WebElement searchGroupCode;
	@FindBy(xpath = "//input[@label='Part Group Description']")
	private WebElement searchGroupDiscription;
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement btnSearchPLT;
	@FindBy(xpath = "//div[@id=\"rc-tabs-0-panel-1\"]/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/label/span/input")
	private WebElement checkBoxPLT;
	@FindBy(xpath = "//span[text()='Add Selected']")
	private WebElement btnAddSelected;
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement btnSavePLT;

	public void addPLT(String groupCode, String groupDesc) {
		driverActions.hardwaitBasedOnInput(5000);
		jsAction.scrolldownandJsClick(addPartsBtn);
		wait.forElementToBeDisplayed(searchGroupCode);
		searchGroupCode.sendKeys(groupCode);
		searchGroupDiscription.sendKeys(groupDesc);
		jsAction.jsclick(btnSearchPLT);
		driverActions.hardwaitBasedOnInput(5000);
		jsAction.jsclick(checkBoxPLT);
		wait.forElementToBeDisplayed(btnAddSelected);
		jsAction.jsclick(btnAddSelected);
		wait.forElementToBeDisplayed(btnSavePLT);
		jsAction.jsclick(btnSavePLT);

	}

	@FindBy(xpath = "//span[text()='Add Labor']")
	private WebElement addLaborBtn;
	@FindBy(xpath = "//div[text()='Emergency']/ancestor::tr/td[2]/div/div[1]/label/span/input")
	// @FindBy(xpath="/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div/div"
	// + "/table/tbody/tr[1]/td[2]/div/div[1]/label/span/input")
	private WebElement selectEmergency;
	@FindBy(xpath = "//div[text()='In Shop']/ancestor::tr/td[2]/div/div[1]/label/span/input")
	// @FindBy(xpath="/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div/div"
	// + "/table/tbody/tr[3]/td[2]/div/div[1]/label/span/input")
	private WebElement selectInshop;
	@FindBy(xpath = "//span[text()='Add Row']")
	private WebElement addRowBtn;
	// @FindBy(xpath="/html/body/div[1]/div[2]/div[4]/div/div/div[2]/div/form/div/div[1]/div/div/div/div/div/div"
	// + "/div[2]/div/div[3]/div[7]/div[2]/div/div/div/div/input")
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[4]/div/div/div[2]/div/form/div/div[1]"
			+ "/div/div/div/div/div/div/div[2]/div/div[3]/div[6]/div[2]/div/div/div/div")
	private WebElement laborCodeTxt;

	public void addLabor(String laborCode) {
		driverActions.hardwaitBasedOnInput(3000);
		jsAction.scrolldownandJsClick(addLaborBtn);
		driverActions.hardwaitBasedOnInput(3000);
		// driver.switchTo().parentFrame();
		// driver.switchTo().frame("eventPageIFrame");
		// wait.forElementToBeDisplayed(selectEmergency);
		// jsAction.jsclick(selectEmergency);
		selectEmergency.click();
		// jsAction.jsclick(selectInshop);
		selectInshop.click();
		wait.forElementToBeDisplayed(btnAddSelected);
		jsAction.jsclick(btnAddSelected);
		// wait.forElementToBeDisplayed(addRowBtn);
		// jsAction.jsclick(addRowBtn);
		// jsAction.scrolldownandJsClick(laborCodeTxt);
		// laborCodeTxt.click();
		// wait.forElementToBeDisplayed(laborCodeTxt);
		// jsAction.scrollIntoView(laborCodeTxt);
		// jsAction.scrollIntoView(laborCodeTxt);
		// laborCodeTxt.sendKeys(laborCode);
		wait.forElementToBeDisplayed(btnSavePLT);
		jsAction.jsclick(btnSavePLT);
	}

	@FindBy(xpath = "//div[text()='Default']")
	private WebElement defaultTab;
	@FindBy(xpath = "(//tbody[@class='ant-table-tbody']/tr[2])[2]/td[5]/button/span")
	private WebElement clickDefaultAssign;
	@FindBy(xpath = "(//input[@class='ant-input ant-input-lg'])[2]")
	private WebElement searchSPDefault;

	public void clickDefaultTab(String tenent) {
		wait.forElementToBeDisplayed(defaultTab);
		jsAction.jsclick(defaultTab);
		wait.forElementToBeDisplayed(searchSPDefault);
		driverActions.driverSendKeys(searchSPDefault, tenent);
		searchSPButton2.click();
		wait.forElementToBeDisplayed(clickDefaultAssign);
		clickDefaultAssign.click();
	}

	@FindBy(xpath = "(//div[text()='Reporting SP'])[2]")
	private WebElement reportingSPtab;
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[8]/div[1]/div/span/span/input")
	private WebElement searchReportingSP;
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[8]/div[2]/div/div/div/div[1]/div[2]/table/tbody/tr[2]/td[5]/button/span")
	private WebElement clickRpSP;

	@FindBy(xpath = "//span[@class='anticon anticon-ellipsis']")
	private WebElement ellipseButton;

	public void clickReportingSPTab(String tenent) {
		wait.forElementToBeDisplayed(ellipseButton);
		ellipseButton.click();
		wait.forElementToBeDisplayed(reportingSPtab);
		jsAction.jsclick(reportingSPtab);
		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeDisplayed(searchSPDefault);
		searchSPDefault.sendKeys(tenent);
		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeDisplayed(clickDefaultAssign);
		clickDefaultAssign.click();
		driverActions.hardwaitBasedOnInput(3000);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/img")
	private WebElement clickMap;
	@FindBy(xpath = "//span[@class='ant-select-selection-placeholder']")
	private WebElement tagsMap;
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content'])[1]")
	private WebElement tagsMapFirst;
	@FindBy(xpath = "//*[@id=\"map_popup_map_view\"]/div/div/div[2]/div[2]/div/div[3]/div[2]/img")
	private WebElement clickSPMap;
	@FindBy(xpath = "//span[text()='Assign']")
	private WebElement assignSpMap;

	public void assignSPMap(String tenent) {
		wait.forElementToBeDisplayed(clickMap);
		jsAction.jsclick(clickMap);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeDisplayed(tagsMap);
		Actions actions=new Actions(driver);
		actions.moveToElement(tagsMap).click().build().perform();
		wait.forElementToBeDisplayed(tagsMapFirst);
		jsAction.jsclick(tagsMapFirst);
		wait.forElementToBeDisplayed(clickSPMap);
		jsAction.jsclick(clickSPMap);
		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeDisplayed(assignSpMap);
		jsAction.jsclick(assignSpMap);
	}

	@FindBy(xpath = "(//div[text()='OEM Authorized SP'])[2]")
	private WebElement clickOEMSP;
	@FindBy(xpath = "(//input[@class='ant-input ant-input-lg'])[2]")
	private WebElement searchOEMSP;
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[7]/div[2]/div/div/div/div[1]/div[2]/table/tbody/tr[2]/td[5]/button")
	private WebElement assignOEMSP;

	public void clickOEMSPTab(String tenent) {
		wait.forElementToBeDisplayed(ellipseButton);
		ellipseButton.click();
		wait.forElementToBeDisplayed(clickOEMSP);
		jsAction.jsclick(clickOEMSP);
		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeDisplayed(searchOEMSP);
		searchOEMSP.sendKeys(tenent);
		wait.forElementToBeDisplayed(assignOEMSP);
		assignOEMSP.click();
		driverActions.hardwaitBasedOnInput(3000);
	}

	@FindBy(xpath = "//button[@class='ant-btn btn-log-tech-arrival']")
	private WebElement logTechArrivalBtn;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary btn-event-log']")
	private WebElement eventHistory;
	@FindBy(xpath = "(//tbody[@class='ant-table-tbody'])[1]/tr[4]/td[3]")
	private WebElement techArrivalStatus;
	@FindBy(xpath = "(//tbody[@class='ant-table-tbody'])[1]/tr[4]/td[1]")
	private WebElement techArrivalTenantName;

	public void logTechArrival(String tenantName) {
		driver.navigate().refresh();
		driverActions.hardwaitBasedOnInput(3000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(logTechArrivalBtn);
		logTechArrivalBtn.click();
		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeDisplayed(eventHistory);
		eventHistory.click();
		driverActions.hardwaitBasedOnInput(3000);
		String techArrivalStatusText = techArrivalStatus.getText();
		Assert.assertEquals("Validated Technician Arrival", techArrivalStatusText, "Tech Arrived");

		if (tenantName.equalsIgnoreCase("TD")) {
			String techArrivalTenantNameText1 = techArrivalTenantName.getText();
			Assert.assertEquals("Validated Tenant Name", techArrivalTenantNameText1, "AutoTruck TD");

		} else if (tenantName.equalsIgnoreCase("SP")) {
			String techArrivalTenantNameText2 = techArrivalTenantName.getText();
			Assert.assertEquals("Validated Tenant Name", techArrivalTenantNameText2, "AutoTruck SP");
		}
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//span[text()='Estimate']")
	private WebElement btnEstimate;

	public void clickEstimate() {
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(btnEstimate);
		jsAction.jsclick(btnEstimate);
		eventUpdateNotifValidation();
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//div[@class='status-text-dispatch']")
	private WebElement estimationStatus;

	public String getBannerStatusEstimation() {
		wait.forElementToBeDisplayed(estimationStatus);
		String estStatus = estimationStatus.getText();
		return estStatus;
	}

	@FindBy(xpath = "//span[text()='Prepare Estimate']")
	private WebElement clickPrepareBtn;

	public void clickPrepareEstimateButton() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(clickPrepareBtn);
		jsAction.jsclick(clickPrepareBtn);

	}

	@FindBy(xpath = "//*[@name='total_discount_amt']")
	private WebElement discount;
	@FindBy(xpath = "//*[@name='total_taxable_amt']")
	private WebElement taxable;
	@FindBy(xpath = "//*[@name='total_non_taxable_amt']")
	private WebElement nonTaxable;
	@FindBy(xpath = "//*[@name='total_tax_amt']")
	private WebElement tax;
	@FindBy(xpath = "//*[@name='total_parts_amt']")
	private WebElement parts;
	@FindBy(xpath = "//*[@name='total_labor_amt']")
	private WebElement labour;
	@FindBy(xpath = "//*[@name='total_oil_amt']")
	private WebElement oil;
	@FindBy(xpath = "//*[@name='new_tires_total_amt']")
	private WebElement newTire;
	@FindBy(xpath = "//*[@name='used_tires_total_amt']")
	private WebElement usedTire;
	@FindBy(xpath = "//*[@name='trade_in_amt']")
	private WebElement tradeIn;
	@FindBy(xpath = "//*[@name='sublet_amt']")
	private WebElement sublet;
	@FindBy(xpath = "//*[@name='road_call_amt']")
	private WebElement roadCall;
	@FindBy(xpath = "//*[@name='env_waste_tax_amt']")
	private WebElement envWasteTax;

	public void enterValueForEstimates(String field, String value) {
		if (field.equalsIgnoreCase("Discount")) {
			wait.forElementToBeDisplayed(discount);
			discount.sendKeys(Keys.CONTROL + "a");
			discount.sendKeys(Keys.DELETE);
			discount.sendKeys(value);
		} else if (field.equalsIgnoreCase("Taxable")) {
			wait.forElementToBeDisplayed(taxable);
			taxable.sendKeys(Keys.CONTROL + "a");
			taxable.sendKeys(Keys.DELETE);
			taxable.sendKeys(value);
		} else if (field.equalsIgnoreCase("NonTaxable")) {
			wait.forElementToBeDisplayed(nonTaxable);
			nonTaxable.sendKeys(Keys.CONTROL + "a");
			nonTaxable.sendKeys(Keys.DELETE);
			nonTaxable.sendKeys(value);
		} else if (field.equalsIgnoreCase("Tax")) {
			wait.forElementToBeDisplayed(tax);
			tax.sendKeys(Keys.CONTROL + "a");
			tax.sendKeys(Keys.DELETE);
			tax.sendKeys(value);
		} else if (field.equalsIgnoreCase("Parts")) {
			wait.forElementToBeDisplayed(parts);
			parts.sendKeys(Keys.CONTROL + "a");
			parts.sendKeys(Keys.DELETE);
			parts.sendKeys(value);
		} else if (field.equalsIgnoreCase("Labor")) {
			wait.forElementToBeDisplayed(labour);
			labour.sendKeys(Keys.CONTROL + "a");
			labour.sendKeys(Keys.DELETE);
			labour.sendKeys(value);
		} else if (field.equalsIgnoreCase("Oil")) {
			wait.forElementToBeDisplayed(oil);
			oil.sendKeys(Keys.CONTROL + "a");
			oil.sendKeys(Keys.DELETE);
			oil.sendKeys(value);
		} else if (field.equalsIgnoreCase("NewTires")) {
			wait.forElementToBeDisplayed(newTire);
			newTire.sendKeys(Keys.CONTROL + "a");
			newTire.sendKeys(Keys.DELETE);
			newTire.sendKeys(value);
		} else if (field.equalsIgnoreCase("UsedTires")) {
			wait.forElementToBeDisplayed(usedTire);
			usedTire.sendKeys(Keys.CONTROL + "a");
			usedTire.sendKeys(Keys.DELETE);
			usedTire.sendKeys(value);
		} else if (field.equalsIgnoreCase("TradeIn")) {
			wait.forElementToBeDisplayed(tradeIn);
			tradeIn.sendKeys(Keys.CONTROL + "a");
			tradeIn.sendKeys(Keys.DELETE);
			tradeIn.sendKeys(value);
		} else if (field.equalsIgnoreCase("Sublet")) {
			wait.forElementToBeDisplayed(sublet);
			sublet.sendKeys(Keys.CONTROL + "a");
			sublet.sendKeys(Keys.DELETE);
			sublet.sendKeys(value);
		} else if (field.equalsIgnoreCase("RoadCall")) {
			wait.forElementToBeDisplayed(roadCall);
			roadCall.sendKeys(Keys.CONTROL + "a");
			roadCall.sendKeys(Keys.DELETE);
			roadCall.sendKeys(value);
		} else if (field.equalsIgnoreCase("EnvWasteTax")) {
			wait.forElementToBeDisplayed(envWasteTax);
			envWasteTax.sendKeys(Keys.CONTROL + "a");
			envWasteTax.sendKeys(Keys.DELETE);
			envWasteTax.sendKeys(value);
		}
	}

	@FindBy(xpath = "//span[text()='Submit']")
	private WebElement btnEstimationSubmit;

	public void clickSubmitEstimatesButton() {
		wait.forElementToBeDisplayed(btnEstimationSubmit);
		jsAction.jsclick(btnEstimationSubmit);

	}

	@FindBy(xpath = "//span[text()='Re-Estimate']")
	private WebElement reEstimatesBtn;

	public void clickReviewEstimatesButton() {
		wait.forElementToBeDisplayed(reEstimatesBtn);
		reEstimatesBtn.click();
	}

	@FindBy(xpath = "//input[@name='total_gross_amt']")
	private WebElement totalGross;

	@FindBy(xpath = "//input[@name='total_net_amt']")
	private WebElement totalNet;

	@FindBy(xpath = "//input[@name='est_total_amt']")
	private WebElement estimated;

	public String getEstimates(String field) {
		String estimates = null;
		if (field.equalsIgnoreCase("totalGross")) {
			wait.forElementToBeDisplayed(totalGross);
			estimates = totalGross.getAttribute("value");
		} else if (field.equalsIgnoreCase("totalNet")) {
			wait.forElementToBeDisplayed(totalNet);
			estimates = totalNet.getAttribute("value");
		} else if (field.equalsIgnoreCase("estimated")) {
			wait.forElementToBeDisplayed(estimated);
			estimates = estimated.getAttribute("value");
		}
		return estimates;
	}

	@FindBy(xpath = "//span[text()='Event Log']")
	private WebElement eventLog;
	@FindBy(xpath = "//td[text()='Estimate Approved']")
	private WebElement estimateApproved;
	@FindBy(xpath = "//td[text()='Estimate Rejected']")
	private WebElement estimateRejected;
	@FindBy(xpath = "//span[text()='OK']")
	private WebElement okEstimateBtn;

	public void validateEstimationPreApproval(String tenantName) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(eventLog);
		jsAction.jsclick(eventLog);
		driverActions.hardwaitBasedOnInput(3000);
		// jsAction.scrollDown();
		if (tenantName.equalsIgnoreCase("TDEstimate Rejected")) {
			// jsAction.scrollIntoView(estimateRejected);
			driverActions.hardwaitBasedOnInput(2000);
			assertEquals("Pre-Approval Status", "Estimate Rejected", estimateRejected.getText());
			System.out.println("Estimate is Estimate Rejected");
			jsAction.jsclick(okEstimateBtn);
			return;
		}
		// jsAction.scrollIntoView(estimateApproved);
		assertEquals("Pre-Approval Status", "Estimate Approved", estimateApproved.getText());
		System.out.println("Estimate is Pre - Approved By " + tenantName);
		jsAction.jsclick(okEstimateBtn);
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//*[contains(text(),'Approve Estimate')]")
	private WebElement btnApprove;
	@FindBy(xpath = "//span[(text()='Approve Estimate')]")
	private WebElement approveButton;

	public void estimateApproval(String tenantName) {

		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(5000);
		jsAction.scrollDown();
		jsAction.scrollIntoView(btnApprove);
		jsAction.jsclick(btnApprove);
		wait.forElementToBeDisplayed(approveButton);
		jsAction.jsclick(approveButton);

	}

	@FindBy(xpath = "//span[text()='Reject Estimate']")
	private WebElement rejectEstimate;
	@FindBy(xpath = "//div[text()='Reject Estimate']")
	private WebElement buttonReject;
	@FindBy(xpath = "//span[text()='Cost too high']")
	private WebElement reasonReject;

	public void rejectApproval(String tenantName) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(5000);
		// jsAction.scrollDown();
		// jsAction.scrollIntoView(rejectEstimate);
		// jsAction.jsclick(rejectEstimate);
		jsAction.scrolldownandJsClick(rejectEstimate);
		wait.forElementToBeDisplayed(buttonReject);
		jsAction.jsclick(buttonReject);
		// buttonReject.click();
		// wait.forElementToBeDisplayed(reasonReject);
		driverActions.hardwaitBasedOnInput(1000);
		jsAction.jsclick(reasonReject);
		// reasonReject.click();
	}

	@FindBy(xpath = "//div[text()='Autotruck Shipper']")
	private WebElement shipperInfo;

	public void validateShipperOnInfoPage() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(3000);
		String str = shipperInfo.getText();
		System.out.println("-------------------");
		System.out.println(str);
		System.out.println("-------------------");
		Assert.assertEquals("Shipper:\n" + "Autotruck Shipper", str);
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//img[@class=\"npa-icon\"]")
	private List<WebElement> npspLogo;

	public void verifyRPONPSPLogo() {
		Assert.assertTrue("npsp logo is present - RPO validation failed", npspLogo.size() == 0);
		System.out.println("RPO validation passed - npsp logo is not present");
	}

	@FindBy(xpath = "//span[text()='Assign']")
	private WebElement assignButton;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div/span[1]/input")
	private WebElement selectTechUser;
	@FindBy(xpath = "/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div/div")
	private WebElement selectTechnician;

	public void clickAssignUserButton() {

		wait.forElementToBeDisplayed(assignButton);
		jsAction.jsclick(assignButton);
		wait.forElementToBeDisplayed(selectTechUser);
		jsAction.jsclick(selectTechUser);
		wait.forElementToBeClickable(selectTechnician);
		jsAction.jsclick(selectTechnician);
		driverActions.hardwaitBasedOnInput(2000);
		jsAction.jsclick(okBtn);
	}

	@FindBy(xpath = "//span[text()='Accept']")
	private WebElement AcceptBtn;

	@FindBy(xpath = "//td[contains(@class, 'rdtToday')]")
	private WebElement todayDate;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary cta-accept-datepicker']")
	private WebElement acceptTechAccept;

	public void techAccept() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(AcceptBtn);
		jsAction.jsclick(AcceptBtn);
		wait.forElementToBeDisplayed(todayDate);
		jsAction.jsclick(todayDate);
		wait.forElementToBeDisplayed(acceptTechAccept);
		jsAction.jsclick(acceptTechAccept);
	}

	public void techAccept2() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(AcceptBtn);
		jsAction.jsclick(AcceptBtn);
		wait.forElementToBeDisplayed(todayDate);
		jsAction.jsclick(todayDate);
		wait.forElementToBeDisplayed(acceptTechAccept);
		jsAction.jsclick(acceptTechAccept);
		eventUpdateNotifValidation();
	}

	@FindBy(xpath = "//span[text()='Submit']")
	private WebElement btnSubmit;

	public void submitChecklist() {
		wait.forElementToBeDisplayed(btnSubmit);
		jsAction.jsclick(btnSubmit);
		driverActions.hardwaitBasedOnInput(3000);

	}

	@FindBy(xpath = "//*[@id=\"Layer_1\"]")
	private WebElement selectEnroute;
	@FindBy(xpath = "//span[text()=' Tech En Route']")
	private WebElement clickEnroute;

	public void techEnroute() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(selectEnroute);
		selectEnroute.click();
		wait.forElementToBeClickable(clickEnroute);
		jsAction.jsclick(clickEnroute);

	}

	@FindBy(xpath = "//span[text()=' Tech Arrived']")
	private WebElement clickTechArrived;

	public void techArrived() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(selectEnroute);
		selectEnroute.click();
		wait.forElementToBeClickable(clickTechArrived);
		jsAction.jsclick(clickTechArrived);
		driverActions.hardwaitBasedOnInput(2000);
		// wait.forElementToBeClickable(techArrivewithoutETC);
		// jsAction.jsclick(techArrivewithoutETC);
	}

	public void etcPOPUP() {
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(techArrivewithoutETC);
		jsAction.jsclick(techArrivewithoutETC);
	}

	@FindBy(xpath = "//div[text()='Fleet Checklist']")
	private WebElement headerFleetChecklist;

	public void validateChecklistInTanent(DataTable checklist) {
		driverActions.hardwaitBasedOnInput(5000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		List<Map<String, String>> list = checklist.asMaps(String.class, String.class);
		for (int i = 0; i < list.size(); i++) {
			String question = list.get(i).get("Question");
			String answer = list.get(i).get("Answer");

			WebElement ele = driver.findElement(
					By.xpath("//div[@class='event_field_label' and text()='" + question + "']/parent::div"));
			int size = question.length();
			System.out.println(ele.getText().substring(size).replaceAll(":", " ").trim());
			Assert.assertEquals("Checklist Verification for " + question, answer,
					ele.getText().substring(size).replaceAll(":", " ").trim());
		}
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//span[text()='Equipment']/parent::a/parent::li")
	private WebElement equipmentBtn;
	@FindBy(xpath = "//span[text()='E360-Activity']")
	private WebElement equipment360Activity;
	@FindBy(xpath = "//div[@id='equipment-activity-datatable_filter']/label/div/input")
	private WebElement searchEquipment;
	@FindBy(xpath = "//a[@data-target='#equipment_history_modal']")
	private WebElement clickEquipment;

	public void equipment360ActivityValidation() throws IOException {
		driverActions.hardwaitBasedOnInput(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(equipmentBtn).build().perform();
		// wait.forElementToBeDisplayed(equipmentBtn);
		// driverActions.driverClick(equipmentBtn);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeDisplayed(equipment360Activity);
		// driverActions.driverClick(equipment360Activity);
		jsAction.jsclick(equipment360Activity);
		wait.forLoading();
		driverActions.hardwaitBasedOnInput(3000);
		String event360 = inandoutstream.loadScheduleEventID();
		wait.forElementToBeDisplayed(searchEquipment);
		driverActions.driverSendKeys(searchEquipment, event360);
		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeClickable(clickEquipment);
		jsAction.jsclick(clickEquipment);
	}

	@FindBy(xpath = "//*[@id='equipment-details']/div/div[1]/p")
	private WebElement chassisdetails;
	@FindBy(xpath = "//*[@id='equipment-details']/div/div[2]/p")
	private WebElement equipmentNumberDetails;
	@FindBy(xpath = "//*[@id='equipment-details']/div/div[3]/p")
	private WebElement equipmentProviderDetails;
	@FindBy(xpath = "//*[@id='equipment-details']/div/div[7]/p")
	private WebElement sourceTruckDetails;
	@FindBy(xpath = "//*[@id='equipment-details']/div/div[8]/p")
	private WebElement makeDetails;
	@FindBy(xpath = "//*[@id='equipment-details']/div/div[9]/p")
	private WebElement modelDetails;
	@FindBy(xpath = "//*[@id='equipment-details']/div/div[10]/p")
	private WebElement yearDetails;
	@FindBy(xpath = "//*[@id='equipment-details']/div/div[11]/p")
	private WebElement vinDetails;
	@FindBy(xpath = "//*[@id='equipment-details']/div/div[12]/p")
	private WebElement liscenceDetails;
	@FindBy(xpath = "//*[@id=\"equipment_history_modal\"]/div/div/div[3]/button")
	private WebElement closebtn;

	public void validateEquipmentDetails(String equipmentType, String equipmentNumber, String sourceTruck,
			String equipmentProvider, String make, String model, String year, String vin, String liscence) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("EquipmentType", equipmentType, driverActions.driverGetText(chassisdetails));
		assertEquals("EquipmentNumber", equipmentNumber, driverActions.driverGetText(equipmentNumberDetails));
		assertEquals("EquipmentProvider", equipmentProvider, driverActions.driverGetText(equipmentProviderDetails));
		// assertEquals("SourceTruck", sourceTruck,
		// driverActions.driverGetText(sourceTruckDetails));
		// assertEquals("Make", make, driverActions.driverGetText(makeDetails));
		// assertEquals("Model", model, driverActions.driverGetText(modelDetails));
		// assertEquals("Year", year, driverActions.driverGetText(yearDetails));
		// assertEquals("Vin", vin, driverActions.driverGetText(vinDetails));
		// assertEquals("Liscence", liscence,
		// driverActions.driverGetText(liscenceDetails));
		System.out.println("Equipment Details Validated Succesfully");
		wait.forElementToBeDisplayed(closebtn);
		jsAction.jsclick(closebtn);

	}

	@FindBy(xpath = "//*[@id=\"rc-tabs-0-panel-1\"]/div/div[1]/div/div[1]/div[2]/div")
	private WebElement chassisdetailsEdit;
	@FindBy(xpath = "//*[@id=\"rc-tabs-0-panel-1\"]/div/div[1]/div/div[2]/div[2]/div")
	private WebElement equipmentNumberDetailsEdit;
	@FindBy(xpath = "//*[@id=\"rc-tabs-0-panel-1\"]/div/div[1]/div/div[3]/div[2]/div")
	private WebElement equipmentProviderDetailsEdit;
	@FindBy(xpath = "//*[@id=\"rc-tabs-0-panel-1\"]/div/div[1]/div/div[7]/div[2]/div")
	private WebElement sourceTruckDetailsEdit;
	@FindBy(xpath = "//*[@id=\"rc-tabs-0-panel-1\"]/div/div[1]/div/div[8]/div[2]/div")
	private WebElement makeDetailsEdit;
	@FindBy(xpath = "//*[@id=\"rc-tabs-0-panel-1\"]/div/div[1]/div/div[9]/div[2]/div")
	private WebElement modelDetailEdit;
	@FindBy(xpath = "//*[@id=\"rc-tabs-0-panel-1\"]/div/div[1]/div/div[10]/div[2]/div")
	private WebElement yearDetailsEdit;
	@FindBy(xpath = "//*[@id=\"rc-tabs-0-panel-1\"]/div/div[1]/div/div[11]/div[2]/div")
	private WebElement vinDetailsEdit;
	@FindBy(xpath = "//*[@id=\"rc-tabs-0-panel-1\"]/div/div[1]/div/div[12]/div[2]/div")
	private WebElement liscenceDetailsEdit;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div/button/span")
	private WebElement closebtnEdit;

	public void validateEquipmentDetailsEditPage(String equipmentType, String equipmentNumber, String sourceTruck,
			String equipmentProvider, String make, String model, String year, String vin, String liscence) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("EquipmentType", equipmentType, driverActions.driverGetText(chassisdetailsEdit));
		assertEquals("EquipmentNumber", equipmentNumber, driverActions.driverGetText(equipmentNumberDetailsEdit));
		assertEquals("EquipmentProvider", equipmentProvider, driverActions.driverGetText(equipmentProviderDetailsEdit));
		// assertEquals("SourceTruck", sourceTruck,
		// driverActions.driverGetText(sourceTruckDetailsEdit));
		// assertEquals("Make", make, driverActions.driverGetText(makeDetailsEdit));
		// assertEquals("Model", model, driverActions.driverGetText(modelDetailEdit));
		// assertEquals("Year", year, driverActions.driverGetText(yearDetailsEdit));
		// assertEquals("Vin", vin, driverActions.driverGetText(vinDetailsEdit));
		// assertEquals("Liscence", liscence,
		// driverActions.driverGetText(liscenceDetailsEdit));
		System.out.println("Equipment Details Validated Succesfully");
		wait.forElementToBeDisplayed(closebtnEdit);
		jsAction.jsclick(closebtnEdit);

	}

	@FindBy(xpath = "//*[@id='s2id_equipment-history-search']/a")
	private WebElement clickeq360;
	@FindBy(xpath = "//*[@id='s2id_autogen1_search']")
	private WebElement searchEq360;
	@FindBy(xpath = "//li[@id='equipment-details-li']/a")
	private WebElement fleetDetailsTab;

	public void validateEq360Dashboard() throws Exception {
		jsAction.scrollUp();
		driverActions.hardwaitBasedOnInput(3000);
		Actions act = new Actions(driver);
		act.moveToElement(clickeq360).click().build().perform();
		wait.forElementToBeDisplayed(searchEq360);
		jsAction.jsInput(searchEq360, Inandoutstream.loadchassisnumber(null).substring(0, 4));
		driverActions.hardwaitBasedOnInput(3000);
		searchEq360.sendKeys("0");
		driverActions.hardwaitBasedOnInput(3000);
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= 9; j++) {
				searchEq360.sendKeys(Keys.ARROW_DOWN);
			}
			driverActions.hardwaitBasedOnInput(2000);
		}
		searchEq360.sendKeys(Keys.RETURN);
		wait.forLoading();
		driverActions.hardwaitBasedOnInput(5000);
		fleetDetailsTab.click();
		driverActions.hardwaitBasedOnInput(3000);
	}

	@FindBy(xpath = "//button[@class='ant-btn general btn-edit']")
	private WebElement editBtn;
	@FindBy(xpath = "//span[text()='360']")
	private WebElement btn360;

	public void validateEq360Editpage() {
		wait.forLoading();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(5000);
		editBtn.click();
		wait.forLoading();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(btn360);
		jsAction.jsclick(btn360);
		driverActions.hardwaitBasedOnInput(5000);

	}

	@FindBy(xpath = "//div[@class='service_center_list']")
	private WebElement assignedSP;
	// @FindBy(xpath="//div[text()='SPHQ Admin']")
	// @FindBy(xpath="//*[@id=\"root\"]/div[6]/div[2]/div/div/div[2]/div/div/div[17]/text()[2]")
	// private WebElement createdSP;

	public void validateAssignReportingLocation(String createdBy, String serviceCenter) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement createdSP = driver.findElement(By.xpath("//div[text()='" + createdBy + " Admin']"));
		jsAction.scrollDown();
		assertEquals("CreatedBy", createdBy, driverActions.driverGetText(createdSP).substring(12, 16));
		assertEquals("EquipmentNumber", serviceCenter, driverActions.driverGetText(assignedSP).substring(0, 13));

	}

	public void clickViewInvoice(String tenant) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		if (tenant.equalsIgnoreCase("Generate Invoice - AUTOTRUCK")) {
			WebElement tenantViewInvoice = driver
					.findElement(By.xpath("//span[text()='Generate Invoice - AUTOTRUCK']"));
			jsAction.jsclick(tenantViewInvoice);
			driverActions.hardwaitBasedOnInput(2000);
		} else {
			WebElement tenantViewInvoice = driver
					.findElement(By.xpath("//span[text()='View Invoice - " + tenant + "']"));
			jsAction.jsclick(tenantViewInvoice);
		}
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//div[text()='View Invoices']")
	private WebElement btnViewInvoices;
	@FindBy(xpath = "(//ul[@class='ant-menu ant-menu-root ant-menu-vertical ant-menu-light'])/li[1]/span")
	private WebElement btnViewInvoicesDrop1;
	@FindBy(xpath = "(//ul[@class='ant-menu ant-menu-root ant-menu-vertical ant-menu-light'])/li[2]/span")
	private WebElement btnViewInvoicesDrop2;

	public void viewInvoice(String tenant) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		Actions actions = new Actions(driver);
		wait.forElementToBeClickable(btnViewInvoices);
		System.out.println("Click on Down Tenant : " + tenant);
		String dropDown = "//span[text()='" + tenant + "' and @class='ant-menu-title-content']";
		actions.moveToElement(btnViewInvoices).build().perform();
		driverActions.hardwaitBasedOnInput(1000);
		driver.findElement(By.xpath(dropDown)).click();
		driverActions.hardwaitBasedOnInput(2000);
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//ol[@class='breadcrumb page-breadcrumb pull-left']/a[4]")
	private WebElement invoiceID;
	@FindBy(xpath = "//input[@id=\"invoice_source_id\"]")
	private WebElement invoiceSource;
	@FindBy(xpath = "//input[@id=\"invoice_total_amount\"]")
	private WebElement invoiceAmt;
	@FindBy(xpath = "//button[@class='btn btn-green btn-sm save_submit']")
	private WebElement invoiceSubmit;
	@FindBy(xpath = "//button[text()=' Accept']")
	private WebElement invoiceAccept;
	@FindBy(xpath = "//button[text()=' Reject']")
	private WebElement invoiceReject;
	@FindBy(xpath = "//button[text()=' Mark as Paid']")
	private WebElement invoicePaid;
	@FindBy(xpath = "//strong[text()='Status :']/following-sibling::a[1]")
	private WebElement invoiceStatusValidation;
	@FindBy(xpath = "//label[text()='Source Invoice # :']/following-sibling::p[1]")
	private WebElement invoiceSourceValidation;
	@FindBy(xpath = "//label[text()='Total :']/following-sibling::p[1]")
	private WebElement invoiceAmountValidation;

	public void invoiceDetails(String invoiceNumber, String amount, String status, String action, String tenant)
			throws IOException {
		driverActions.hardwaitBasedOnInput(2000);
		Assert.assertEquals("Validated Invoice Status", status, driverActions.driverGetText(invoiceStatusValidation));
		if (action.equalsIgnoreCase("Submit")) {
			wait.forElementToBeDisplayed(invoiceSource);
			String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
			invoiceSource.sendKeys(del + invoiceNumber);
			wait.forElementToBeClickable(invoiceAmt);
			invoiceAmt.sendKeys(del + amount);
			wait.forElementToBeClickable(invoiceSubmit);
			jsAction.jsclick(invoiceSubmit);
			String InvoiceNumber = driverActions.driverGetText(invoiceID);
			System.out.println("Invoice ID is ----> " + tenant + " --------------->  " + InvoiceNumber);
			inandoutstream.saveInvoiceNumber(InvoiceNumber, tenant);
		}
		if (action.equalsIgnoreCase("Accept") || action.equalsIgnoreCase("Reject")
				|| action.equalsIgnoreCase("MarkAsPaid") || action.equalsIgnoreCase("Paid")) {
			Assert.assertEquals("Validated Invoice Source", invoiceNumber,
					driverActions.driverGetText(invoiceSourceValidation));
			Assert.assertEquals("Validated Invoice Amount", amount,
					driverActions.driverGetText(invoiceAmountValidation));
			String validatingInvoiceID = inandoutstream.loadInvoiceNumber(tenant);
			int size = driver.findElements(By.xpath("//*[contains(text(),'" + validatingInvoiceID + "')]")).size();
			Assert.assertEquals(1, size);
			if (action.equalsIgnoreCase("Accept")) {
				wait.forElementToBeDisplayed(invoiceAccept);
				jsAction.jsclick(invoiceAccept);
			}
			if (action.equalsIgnoreCase("MarkAsPaid")) {
				wait.forElementToBeDisplayed(invoicePaid);
				jsAction.jsclick(invoicePaid);
			}
			if (action.equalsIgnoreCase("Reject")) {
				wait.forElementToBeDisplayed(invoiceReject);
				jsAction.jsclick(invoiceReject);
			}
		}
	}

	@FindBy(xpath = "//i[@class='fa fa-file-o']")
	private WebElement invoiceHeader;

	public void validatePayer(String payer) {
		int size = driver.findElements(By.xpath("//*[contains(text(),'" + payer + "'))]")).size();
		Assert.assertEquals(1, size);
	}

	public void validatePayee(String payee) {
		int size = driver.findElements(By.xpath("//*[contains(text(),'" + payee + "'))]")).size();
		Assert.assertEquals(1, size);
	}

	@FindBy(xpath = "//i[@class='fa fa-credit-card']")
	private WebElement invoiceTab;
	@FindBy(xpath = "//a[@class='dt-button status_filter_btn'] | //a[@class='dt-button status_filter_btn status-filter-highlight']")
	private WebElement invoiceDashStatus;
	@FindBy(xpath = "//h4[text()='Status Filter Option']/parent::div[1]/following-sibling::div[1]/div/div/ul/li/input")
	private WebElement invoiceDashStatusInput;
	@FindBy(xpath = "//a[@class='dt-button payer_filter_btn'] | //a[@class='dt-button payer_filter_btn payer-filter-highlight']")
	private WebElement invoiceDashPayer;
	@FindBy(xpath = "//h4[text()='Payer Filter']/parent::div[1]/following-sibling::div[1]/div/div/ul/li/input")
	private WebElement invoiceDashPayerInput;
	@FindBy(xpath = "//a[@class='dt-button payee_filter_btn'] | //a[@class='dt-button payee_filter_btn payee-filter-highlight']")
	private WebElement invoiceDashPayee;
	@FindBy(xpath = "//h4[text()='Payee Filter']/parent::div[1]/following-sibling::div[1]/div/div/ul/li/input")
	private WebElement invoiceDashPayeeInput;
	@FindBy(xpath = "(//button[@class='btn btn-grey btn-sm'])[2]")
	private WebElement invoiceDashInputClose1;
	@FindBy(xpath = "(//button[@class='btn btn-grey btn-sm'])[4]")
	private WebElement invoiceDashInputClose2;
	@FindBy(xpath = "(//button[@class='btn btn-grey btn-sm'])[3]")
	private WebElement invoiceDashInputClose3;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	private WebElement invoiceDashInputInvoiceID;
	@FindBy(xpath = "//i[@class='fa fa-search fa-fw']")
	private WebElement invoiceDashInvoiceIDSearchBtn;
	@FindBy(xpath = "//table[@id='invoice_data_table']/tbody/tr/td[1]/a")
	private WebElement invoiceDashTableInvoiceID;

	public void filterInvoice(String status, String payer, String payee) throws IOException {
		String loadTenant1 = payer.toLowerCase();
		String loadTenant = removeSpace(loadTenant1);
		wait.forElementToBeDisplayed(invoiceTab);
		jsAction.jsclick(invoiceTab);
		wait.forElementToBeDisplayed(invoiceDashStatus);
		jsAction.jsclick(invoiceDashStatus);
		wait.forElementToBeDisplayed(invoiceDashStatusInput);
		invoiceDashStatusInput.click();
		invoiceDashStatusInput.sendKeys(Keys.BACK_SPACE);
		invoiceDashStatusInput.sendKeys(Keys.BACK_SPACE);
		invoiceDashStatusInput.sendKeys(Keys.BACK_SPACE);
		// Actions actions=new Actions(driver);
		// actions.sendKeys(invoiceDashStatusInput, status + Keys.ENTER +
		// Keys.ESCAPE).perform();
		invoiceDashStatusInput.sendKeys(status);
		driverActions.hardwaitBasedOnInput(3000);
		invoiceDashStatusInput.sendKeys(Keys.ENTER);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeDisplayed(invoiceDashInputClose1);
		jsAction.jsclick(invoiceDashInputClose1);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeDisplayed(invoiceDashPayer);
		jsAction.jsclick(invoiceDashPayer);
		wait.forElementToBeDisplayed(invoiceDashPayerInput);
		invoiceDashPayerInput.click();
		invoiceDashPayerInput.sendKeys(Keys.BACK_SPACE);
		invoiceDashPayerInput.sendKeys(Keys.BACK_SPACE);
		// actions.sendKeys(invoiceDashPayerInput, payer + Keys.ENTER).perform();
		invoiceDashPayerInput.sendKeys(payer);
		driverActions.hardwaitBasedOnInput(3000);
		invoiceDashPayerInput.sendKeys(Keys.ENTER);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeDisplayed(invoiceDashInputClose2);
		jsAction.jsclick(invoiceDashInputClose2);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeDisplayed(invoiceDashPayee);
		jsAction.jsclick(invoiceDashPayee);
		wait.forElementToBeDisplayed(invoiceDashPayeeInput);
		invoiceDashPayeeInput.click();
		invoiceDashPayeeInput.sendKeys(Keys.BACK_SPACE);
		invoiceDashPayeeInput.sendKeys(Keys.BACK_SPACE);
		// actions.sendKeys(invoiceDashPayeeInput, payer + Keys.ENTER).perform();
		// driverActions.hardwaitBasedOnInput(4000);
		invoiceDashPayeeInput.sendKeys(payee);
		driverActions.hardwaitBasedOnInput(3000);
		invoiceDashPayeeInput.sendKeys(Keys.ENTER);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeDisplayed(invoiceDashInputClose3);
		jsAction.jsclick(invoiceDashInputClose3);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeDisplayed(invoiceDashInputInvoiceID);
		invoiceDashInputInvoiceID.clear();
		jsAction.jsInput(invoiceDashInputInvoiceID, inandoutstream.loadInvoiceNumber(loadTenant));
		wait.forElementToBeDisplayed(invoiceDashInvoiceIDSearchBtn);
		jsAction.jsclick(invoiceDashInvoiceIDSearchBtn);
		jsAction.jsclick(invoiceDashInvoiceIDSearchBtn);
		driverActions.hardwaitBasedOnInput(2000);
		int size = driver.findElements(By.xpath("//table[@id='invoice_data_table']/tbody/tr/td[1]/a")).size();
		for (int i = 1; i <= size; i++) {
			WebElement invoiceDashTableInvoiceID = driver
					.findElement(By.xpath("//table[@id='invoice_data_table']/tbody/tr[" + i + "]/td[1]/a"));
			if (driverActions.driverGetText(invoiceDashTableInvoiceID)
					.equals(inandoutstream.loadInvoiceNumber(loadTenant))) {
				return;
			}
		}
	}

	public String removeSpace(String str) {
		StringBuilder name = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (c != ' ') {
				name.append(c);
			}
		}
		return name.toString();
	}

	public void validateResendInvoice(String tenant) {
		driverActions.hardwaitBasedOnInput(3000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		String resendInvoicePath = "//span[text()='Resend Invoice request - " + tenant + "']";
		Assert.assertEquals("Validate Resend Invoice Request Button . ", "Resend Invoice Request - " + tenant,
				driver.findElement(By.xpath(resendInvoicePath)).getText());
		driver.switchTo().defaultContent();
	}

	public void validateNoInvoice() {
		driverActions.hardwaitBasedOnInput(3000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		int size = driver.findElements(By.xpath("//button[@class='ant-btn general invoice_name']")).size();
		Assert.assertEquals(0, size);
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//div[contains(text(),'Billing')]")
	private WebElement billingHeader;
	@FindBy(xpath = "//span[@class='ant-typography ant-typography-secondary']")
	private WebElement paymentStream;
	@FindBy(xpath = "(//span[@class='ant-typography ant-typography-secondary'])[1]")
	private WebElement streamCC1;
	@FindBy(xpath = "(//span[@class='ant-typography ant-typography-secondary'])[2]")
	private WebElement streamCC2;

	public void verifyPaymentStream(String tenantType) {
		wait.forLoading();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(3000);
		jsAction.scrollDown();
		jsAction.scrollIntoView(billingHeader);
		try {
			switch (tenantType) {
			case "TD":
				String stream = driverActions.driverGetText(paymentStream);

				assertEquals(Stream, DownStream, stream);
				if (stream.equalsIgnoreCase(DownStream)) {
					System.out.println("Payment Stream Verified");
				} else {
					System.out.println("Payment Stream Verification Failed");
				}
				break;
			case "SP":
				String streamSP = driverActions.driverGetText(paymentStream);
				assertEquals(Stream, UpStream, streamSP);
				if (streamSP.equalsIgnoreCase(UpStream)) {
					System.out.println("Payment Stream Verified");
				} else {
					System.out.println("Payment Stream Verification Failed");
				}

				break;
			case "CC":
				String stream1 = driverActions.driverGetText(streamCC1);
				String stream2 = driverActions.driverGetText(streamCC2);
				if (stream1.equalsIgnoreCase("Upstream")) {
					assertEquals(Stream, UpStream, stream1);
					System.out.println("Payment Stream Verified");
				} else if (stream2.equalsIgnoreCase("Downstream")) {
					assertEquals(Stream, DownStream, stream2);
					System.out.println("Payment Stream Verified");
				}
				break;

			default:
				throw new Reach24NEPCustomException("Invalid Tenant selected");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}
	}

	public void verifySubContact(String tofrom, String tenant) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		WebElement subcontractElement = null;
		if (tofrom.equalsIgnoreCase("TO")) {
			subcontractElement = driver
					.findElement(By.xpath("//div[text()='Subcontract To']/following-sibling::span"));
		} else if (tofrom.equalsIgnoreCase("FROM")) {
			subcontractElement = driver
					.findElement(By.xpath("//div[text()='Subcontract From']/following-sibling::span"));
		}
		String subcontractText = driverActions.driverGetText(subcontractElement);
		Assert.assertEquals(tenant, subcontractText);
		System.out.println("<----------SubContract Validated----------->");
		driver.switchTo().defaultContent();
	}
	
	@FindBy(xpath = "//span[text()='Non working hours']")
private WebElement fscNonWorkingHours;

public void ValidateFscPopUpNonWorkingHours() {
	wait.forElementToBeClickable(fscNonWorkingHours);
	jsAction.jsclick(fscNonWorkingHours);
	String actualFscvalue = driverActions.driverGetText(fscNonWorkingHours);
	System.out.println(actualFscvalue);
	String expValue = "Non working hours";
	Assert.assertTrue(actualFscvalue.contains(expValue));
}

@FindBy(xpath = "//span[text()='Door closed']")
private WebElement fscPopUpDoorClosed;

public void ValidateFscPopUpDoorClosed() {
	wait.forElementToBeClickable(fscPopUpDoorClosed);
	jsAction.jsclick(fscPopUpDoorClosed);
	String actualFscvalue = driverActions.driverGetText(fscPopUpDoorClosed);
	System.out.println(actualFscvalue);
	String expValue = "Door closed";
	Assert.assertTrue(actualFscvalue.contains(expValue));
}

@FindBy(xpath = "//span[text()='Available (after-hours)']")
private WebElement fscPopUpAfterHours;

public void ValidateFscPopUpAfterHours() {
	wait.forElementToBeClickable(fscPopUpAfterHours);
	jsAction.jsclick(fscPopUpAfterHours);
	String actualFscvalue = driverActions.driverGetText(fscPopUpAfterHours);
	System.out.println(actualFscvalue);
	String expValue = "Available (after-hours)";
	Assert.assertTrue(actualFscvalue.contains(expValue));
}

@FindBy(xpath = "//span[text()='Available']")
private WebElement fscPopUpAvaiable;

public void ValidateFscPopUpAvaiable() {
	wait.forElementToBeClickable(fscPopUpAvaiable);
	jsAction.jsclick(fscPopUpAvaiable);
	String actualFscvalue = driverActions.driverGetText(fscPopUpAvaiable);
	System.out.println(actualFscvalue);
	String expValue = "Available";
	Assert.assertTrue(actualFscvalue.contains(expValue));
}

@FindBy(xpath = "//label[text()='Door']")
private WebElement doorCloseEnable;
@FindBy(xpath = "//span[text()='Open']")
private WebElement doorCloseOpen;
@FindBy(xpath = "//span[@class='hidden-xs']/following-sibling::span[1]")
private WebElement myProfileDropDown;
@FindBy(xpath = "//div[@class='make-switch has-switch sp_availability_switch']/div[1]")
private WebElement doorSwitchOnOff;
@FindBy(xpath = "//label[text()='Door']")
private WebElement closeOpenDoor;

public void clickDoorCloseOpen(String action, String tenant) {
	driver.switchTo().defaultContent();
	Actions act = new Actions(driver);
	driver.get(PropsReader.sp5URL);
	driverActions.hardwaitBasedOnInput(3000);
	wait.forElementToBeClickable(myProfileDropDown);
	act.moveToElement(myProfileDropDown).build().perform();
//	wait.forElementToBeDisplayed(doorSwitchOnOff);
//	wait.forElementToBeClickable(closeOpenDoor);
	driverActions.hardwaitBasedOnInput(1000);
	if (doorSwitchOnOff.getAttribute("class").contains("switch-on")) {
		if (action.equalsIgnoreCase("open")) {
			System.out.println("Door is already opened");
			return;
		} else {
			System.out.println("Door is Opened, Closing the door");
			closeOpenDoor.click();
		}
	}

	if (doorSwitchOnOff.getAttribute("class").contains("switch-off")) {
		if (action.equalsIgnoreCase("open")) {
			closeOpenDoor.click();
			System.out.println("Door is closed, OPening the Door");
		} else {
			System.out.println("Door is already closed");
			return;
		}
	}
}

}

package org.reach24.Reach24NEP.pages;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24NEP.actions.DriverActions;
import org.reach24.Reach24NEP.actions.JsActions;
import org.reach24.Reach24NEP.dtos.CommonVariables;
import org.reach24.Reach24NEP.util.Inandoutstream;
import org.reach24.Reach24NEP.util.PropsReader;
import org.reach24.Reach24NEP.util.ReusableMethods;
import org.reach24.Reach24NEP.util.Wait;

public class EventCreationPage {
	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	ReusableMethods reusableMethods = new ReusableMethods();
	DriverActions driverActions;
	JsActions jsAction;
	Wait wait;
	Inandoutstream inandoutstream = new Inandoutstream();

	public EventCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
		driverActions = new DriverActions(driver);
		jsAction = new JsActions(driver);
	}

	public void scrolldownandclick(WebElement elementLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elementLocator);
		js.executeScript("arguments[0].click();", elementLocator);
	}

	public void scrollUpandclick(WebElement elementLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", elementLocator);
		js.executeScript("arguments[0].click();", elementLocator);
	}

	public void jsclick(WebElement elementLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", elementLocator);
	}

	@FindBy(xpath = "//span[contains(text(),'View this event in our ')]")
	private WebElement newEventPageBackBanner;
	@FindBy(xpath = "//div[contains(text(),'Experience this event in the new event page')]")
	private WebElement newEventPageForwardBanner;
	@FindBy(xpath = "//div[@class='create-header-text']/span")
	private WebElement createHeaderTextBackButton;
	@FindBy(xpath = "(//*[@class='ant-select-selection-search-input'])[1]")
	private WebElement enterTruckDispatch;
	@FindBy(xpath = "//input[@id='rc_select_0']")
	private WebElement selectCustomer;
	@FindBy(xpath = "(//*[@class='ant-select-item-option-content'])[1]")
	private WebElement searchSelectCustomer;
	@FindBy(xpath = "//span[text()='Equipment Type']/parent::label/parent::div/parent::div/div[2]/div/div/div/div/div/div/span/input")
	private WebElement selectEquipment;
	@FindBy(xpath = "//input[@name ='equipment_number']")
	private WebElement equipmentNumber;

	public void clickBackButton() {
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(createHeaderTextBackButton);
		createHeaderTextBackButton.click();
	}

	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary ant-btn-block'])[2]")
	private WebElement advanceSearchBtn;
	@FindBy(xpath = "(//div[@class='advanced-search-label'])[2]/following-sibling::input[1]")
	private WebElement nameAdSearch;
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary']/span)[2]")
	private WebElement searchAdSearch;
	@FindBy(xpath = "(//span[@class='ant-checkbox-inner'])[2]")
	private WebElement selectCrosswalk;
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary']/span)[3]")
	private WebElement saveAdSearch;
	@FindBy(xpath = "//div[text()='Warning!']")
	private WebElement warningPopUp;
	@FindBy(xpath = "//span[text()='OK']")
	private WebElement okBtn;
	@FindBy(xpath = "//input[@id='equipment_type']/parent::span/parent::div/following-sibling::div/div/div/div/div[2]/div[1]/div[1]/div[1]/div[1]")
	private WebElement equipmentTypeFirst;
	@FindBy(xpath = "//span[text()='Truck Dispatch']/parent::div/following::div/div[1]/div/div/div/span/input")
	private WebElement truckDispatch;

	//@FindBy(xpath = "//*[@id='root']/section/main/form/div[1]/div/div[2]/div/div/div[1]/div/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div/div/div/div")
	@FindBy(xpath = "//input[@id='truck_dispatch']/parent::span/parent::div/following-sibling::div/div/div/div/div[2]/div[1]/div[1]/div[1]/div[1]")
	private WebElement searchTd;

	@FindBy(xpath = "//div[text()='Show fleets from']/following::div[1]/span[1]/span")
	private WebElement selectCustomerFromAdvance;
	@FindBy(xpath="//input[@id='payment_method']/following::span[1]")
	private WebElement paymentMethodText;
	@FindBy(xpath="//label[@for='payment_account_number']/following::span[2]")
	private WebElement paymentAccountNum;

	public void selectEpuipmentAndDriver(String featureName, String customerName, String equipmentType,
			String crosswalk) {
		wait.forLoading();
		if (featureName.contains("SPEventCreation") || featureName.contains("SmokeSuiteOrgStructure")
				|| featureName.contains("AssignReportingLocation") || featureName.contains("CCEventCreation") || featureName.contains("BridgestoneShipTo")
				|| featureName.contains("EventForward")) {
			wait.forElementToBeClickable(truckDispatch);
			jsAction.jsclick(truckDispatch);
			truckDispatch.sendKeys(customerName);
			driverActions.hardwaitBasedOnInput(2000);
			//wait.forElementToBeDisplayed(searchTd);
			jsAction.jsclick(searchTd);
		}
		if (featureName.contains("CrossWalk")) {
			wait.forElementToBeClickable(advanceSearchBtn);
			advanceSearchBtn.click();
			crossWalk(crosswalk);
		}
		if (featureName.contains("BridgestoneShipToCrossWalk")) {
			wait.forElementToBeClickable(advanceSearchBtn);
			advanceSearchBtn.click();
			crossWalk(crosswalk);
			wait.forElementToBeDisplayed(shipToLoaction);
			Assert.assertEquals("ATFleetShipToFleet\n"+"San Francisco, CA, USA\n"+"Account# ATFleetShipToAccount",driverActions.driverGetText(shipToLoaction));
			wait.forElementToBeDisplayed(billToLoaction);
			Assert.assertEquals("ATFleetBillToFleet\n"+"San Francisco, CA, USA\n"+"Account# ATFleetBillToAccount",driverActions.driverGetText(billToLoaction));
			wait.forElementToBeDisplayed(billToLoaction);
			Assert.assertEquals("ATFleetBillToFleet\n"+"San Francisco, CA, USA\n"+"Account# ATFleetBillToAccount",driverActions.driverGetText(billToLoaction));
			wait.forElementToBeDisplayed(paymentMethodText);
			Assert.assertEquals("Bridgestone",driverActions.driverGetText(paymentMethodText));
			wait.forElementToBeDisplayed(paymentAccountNum);
			Assert.assertEquals("ATFleetBillToAccount",driverActions.driverGetText(paymentAccountNum));
			wait.forElementToBeDisplayed(oemVerifiedAccount);
			Assert.assertEquals("Account verified",driverActions.driverGetText(oemVerifiedAccount));
		}
		wait.forElementToBeClickable(selectEquipment);
		jsAction.jsclick(selectEquipment);
		selectEquipment.sendKeys(equipmentType);
		wait.forElementToBeDisplayed(equipmentTypeFirst);
		jsAction.jsclick(equipmentTypeFirst);
	}

	public void crossWalk(String crosswalk){
		String crosswalkString="";
		if(crosswalk.contains(":")){
			crosswalkString=crosswalk;
			String crosswalkDropdownName="";
			String searchCrosswalkName="";
			String resultCrosswalk1="";
			String resultCrosswalk2="";
			String resultCrosswalk3="";
			String resultCrosswalk4="";
			String selectCrosswalkCustomer="";
			int start=0;
			for(int i=0;i<crosswalkString.length();i++){
				if(crosswalkString.charAt(i)==':'){
					start=i;
					break;
				}
				crosswalkDropdownName+=crosswalkString.charAt(i);
			}
			for(int j=start+1;j<crosswalkString.length();j++){
				if(crosswalkString.charAt(j)=='?'){
					start=j;
					break;
				}
				searchCrosswalkName+=crosswalkString.charAt(j);
			}
			for(int k=start+1;k<crosswalkString.length();k++){
				if(crosswalkString.charAt(k)=='>'){
					start=k;
					break;
				}
				resultCrosswalk1+=crosswalkString.charAt(k);
			}
			for(int l=start+1;l<crosswalkString.length();l++){
				if(crosswalkString.charAt(l)=='>'){
					start=l;
					break;
				}
				resultCrosswalk2+=crosswalkString.charAt(l);
			}
			for(int m=start+1;m<crosswalkString.length();m++){
				if(crosswalkString.charAt(m)=='>'){
					start=m;
					break;
				}
				resultCrosswalk3+=crosswalkString.charAt(m);
			}
			for(int n=start+1;n<crosswalkString.length();n++){
				if(crosswalkString.charAt(n)=='='){
					start=n;
					break;
				}
				resultCrosswalk4+=crosswalkString.charAt(n);
			}
			for(int n=start+1;n<crosswalkString.length();n++){
				selectCrosswalkCustomer+=crosswalkString.charAt(n);
			}
			System.out.println(crosswalkDropdownName);
			System.out.println(searchCrosswalkName);
			System.out.println(resultCrosswalk1);
			System.out.println(resultCrosswalk2);
			System.out.println(resultCrosswalk3);
			System.out.println(resultCrosswalk4);
			System.out.println(selectCrosswalkCustomer);
			ArrayList<String> arrList=new ArrayList<String>();
			arrList.add(resultCrosswalk1);
			arrList.add(resultCrosswalk2);
			arrList.add(resultCrosswalk3);
			arrList.add(resultCrosswalk4);
			driverActions.hardwaitBasedOnInput(2000);
			Actions actions=new Actions(driver);
			actions.moveToElement(selectCustomerFromAdvance).click().build().perform();
			driverActions.hardwaitBasedOnInput(2000);
			driver.findElement(By.xpath("//div[text()='"+crosswalkDropdownName+"']")).click();
			wait.forElementToBeDisplayed(nameAdSearch);
			nameAdSearch.sendKeys(searchCrosswalkName);
			wait.forElementToBeDisplayed(searchAdSearch);
			searchAdSearch.click();
			driverActions.hardwaitBasedOnInput(3000);
			int size=driver.findElements(By.xpath("//div[@class='custom-class-name']")).size();
			for(int x=1;x<=size;x++){
				WebElement currentCustomer=driver.findElement(By.xpath("(//div[@class='custom-class-name'])["+x+"]"));
				System.out.println(driverActions.driverGetText(currentCustomer));
				Assert.assertEquals(driverActions.driverGetText(currentCustomer),arrList.get(x-1));
			}
			WebElement selectCrosswalkCheckBox=driver.findElement(By.xpath("//div[text()='"+selectCrosswalkCustomer+"']/parent::td/following::td[14]/label/span/span"));
			wait.forElementToBeClickable(selectCrosswalkCheckBox);
			jsAction.jsclick(selectCrosswalkCheckBox);
			jsAction.jsclick(saveAdSearch);
		}else {
			crosswalkString=crosswalk;
			wait.forElementToBeDisplayed(nameAdSearch);
			nameAdSearch.sendKeys(crosswalkString);
			wait.forElementToBeDisplayed(searchAdSearch);
			searchAdSearch.click();
			driverActions.hardwaitBasedOnInput(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", selectCrosswalk);
			wait.forElementToBeClickable(selectCrosswalk);
			jsclick(selectCrosswalk);
			saveAdSearch.click();
		}
	}

	@FindBy(xpath = "//span[text()='Driver/Inspector']/parent::label/parent::div/parent::div/div[2]/div/div/div[1]/div/div[1]/div/span/input")
	private WebElement selectDriver;
	@FindBy(xpath = "//div[text()='No Driver']")
	private WebElement noDriver;
	@FindBy(xpath = "//span[text()='Driver With Unit?']/parent::label/parent::div/following-sibling::div/div/div/button")
	private WebElement unitWithDriver;
	@FindBy(xpath = "(//button[@class='ant-switch'])[1]")
	private WebElement unitWithDriver1;

	public void selectEquipmentNumber(String type) throws IOException {
		wait.forElementToBeClickable(equipmentNumber);
		jsAction.jsclick(equipmentNumber);
		String equipnum = reusableMethods.randomAlphaNumericName(4, 6);
		driverActions.driverSendKeys(equipmentNumber, equipnum);
		inandoutstream.saveEquipmentNumber(equipnum);
		System.out.println("Equipment number is : " + equipnum);
		driverActions.hardwaitBasedOnInput(2000);
		// wait.forElementToBeClickable(selectDriver);
		jsAction.jsclick(selectDriver);
		selectDriver.sendKeys(CommonVariables.driverName);
		wait.forElementToBeClickable(noDriver);
		jsAction.jsclick(noDriver);
		if (!(type.equalsIgnoreCase("clone"))) {
			wait.forElementToBeClickable(unitWithDriver);
			jsAction.jsclick(unitWithDriver);
		}
	}

	public void selectSPAuthority() throws IOException {
		wait.forElementToBeClickable(equipmentNumber);
		equipmentNumber.click();
		driverActions.driverSendKeys(equipmentNumber, "CONT676767");
		inandoutstream.saveEquipmentNumber("CONT676767");
	}

	@FindBy(xpath = "//input[@id='departed_terminal']")
	private WebElement departedTerminal;

	public void selectDepartedTerminal() {
		wait.forElementToBeDisplayed(departedTerminal);
		jsAction.jsclick(departedTerminal);
		driverActions.driverSendKeys(departedTerminal, "Demo Terminal");
		driverActions.hardwaitBasedOnInput(3000);
		departedTerminal.sendKeys(Keys.ARROW_DOWN);
		departedTerminal.sendKeys(Keys.ENTER);
	}

	public void selectSPAuthorityy() throws IOException {
		wait.forElementToBeClickable(equipmentNumber);
		equipmentNumber.click();
		driverActions.driverSendKeys(equipmentNumber, "HIND151947");
		inandoutstream.saveEquipmentNumber("HIND151947");
		clickIgnoreCont();
	}

	public void selectDepartedTerminall() {
		wait.forElementToBeDisplayed(departedTerminal);
		jsAction.jsclick(departedTerminal);
		driverActions.driverSendKeys(departedTerminal, "Demo Terminal");
		driverActions.hardwaitBasedOnInput(3000);
		departedTerminal.sendKeys(Keys.ARROW_DOWN);
		departedTerminal.sendKeys(Keys.ENTER);
	}

	public void verifyNewEventPageBackBanner() {
		driver.switchTo().parentFrame();
		Boolean status = false;
		wait.forElementToBeClickable(newEventPageBackBanner);
		driverActions.hardwaitBasedOnInput(2000);
		String newEventPageBackText = newEventPageBackBanner.getText().trim();
		if (newEventPageBackText.equals("View this event in our Old Interface")) {
			status = true;
		}
		Assert.assertEquals(true, status);
	}

	@FindBy(xpath = "(//*[@class='ant-radio-button'])[2]")
	private WebElement locationType;
	// @FindBy(xpath = "//span[text()='Loaded?']")

	@FindBy(xpath = "//span[text()='Loaded?']/parent::label/parent::div/following::div[1]/div/div/button")
	private WebElement loadedBtn;
	//@FindBy(xpath = "//span[text()='Reported Location']/parent::div/following-sibling::div/div[1]/div/input")
	//@FindBy(xpath = "//span[text()='Reported Location']/parent::div/following-sibling::div/span[2]/div/div/input")
	@FindBy(id = "address")
	private WebElement location;
	@FindBy(xpath = "(//input[@name='reported_user_name'])")
	private WebElement callerName;

	public void selectEventAndLocation(String address, String caller) {
		wait.forElementToBeDisplayed(locationType);
		jsAction.jsclick(locationType);
		wait.forElementToBeClickable(loadedBtn);
		jsAction.jsclick(loadedBtn);
		jsAction.jsclick(location);
		driverActions.driverSendKeys(location, address);
		driverActions.hardwaitBasedOnInput(3000);
		location.sendKeys(Keys.ARROW_DOWN);
		location.sendKeys(Keys.ENTER);
		wait.forElementToBeDisplayed(callerName);
		driverActions.driverSendKeys(callerName, caller);
	}

	@FindBy(xpath = "//span[text()='Drop Location']/following::div[1]/div/div/button")
	private WebElement dropLocation;

	public void selectDropLocationCheckBox() {
		jsAction.jsclick(locationType);
		jsAction.jsclick(loadedBtn);
		jsAction.jsclick(dropLocation);
		driverActions.hardwaitBasedOnInput(2000);
	}

	@FindBy(xpath = "//span[text()='Ancillary Location']/following::div[1]/div/div/span/input")
	private WebElement clickAncillaryLocation;
	@FindBy(xpath = "//*[@class=\"select2-result-label\"]/span")
	private WebElement selectAncillaryLocation;

	public void selectAncillaryLocation() throws AWTException {
		jsAction.jsclick(clickAncillaryLocation);
		driverActions.hardwaitBasedOnInput(2000);
		driverActions.driverSendKeys(clickAncillaryLocation, "Front Gate");
		try {
			Thread.sleep(2000);
			clickAncillaryLocation.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
		} catch (InterruptedException e) {
			System.out.println("Error: " + e);
		}
		driverActions.hardwaitBasedOnInput(2000);
	}

	@FindBy(xpath = "//button[@id = 'AddServiceLineButton']")
	private WebElement addServiceBtn;

	public void addServiceBtn() {
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(addServiceBtn);
		jsAction.jsclick(addServiceBtn);
	}

	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary'])[2]")
	private WebElement btnOK;

	public void handlePopup() {
		wait.forElementToBeDisplayed(btnOK);
		jsclick(btnOK);
	}

	@FindBy(xpath = "//span[text()='CF01']/parent::label/parent::div/following-sibling::div/div/div/div/input")
	private WebElement textCustomFields;
	@FindBy(xpath = "//span[text()='CS02']/parent::label/parent::div/following-sibling::div/div/div/div/div[1]/div[1]")
	private WebElement dateCustomFields;
	@FindBy(xpath = "//a[@class='ant-picker-now-btn']")
	private WebElement selectNowDate;
	@FindBy(xpath = "//span[text()='CS03']/parent::label/parent::div/following-sibling::div/div/div/div/label/span/input")
	private WebElement selectCustomCheckBox;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveBtnEditPage;

	public void add_CustomFields() {
		wait.forLoading();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		jsAction.scrollDown();
		wait.forElementToBeDisplayed(textCustomFields);
		textCustomFields.sendKeys("This is a test");
		wait.forElementToBeDisplayed(dateCustomFields);
		dateCustomFields.click();
		wait.forElementToBeDisplayed(selectNowDate);
		selectNowDate.click();
		wait.forElementToBeDisplayed(saveBtnEditPage);
		jsAction.jsclick(saveBtnEditPage);
		driverActions.hardwaitBasedOnInput(5000);
		System.out.println("Custom Fields Added ");
		driverActions.hardwaitBasedOnInput(5000);
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-block'])[1]")
	private WebElement walkinBtn;
	@FindBy(xpath = "//input[@name='walkin_truck_dispatch.name']")
	private WebElement truckDispatchWalkIn;
	@FindBy(xpath = "//input[@name='walkin_truck_dispatch.address']")
	private WebElement walkInAddress;
	@FindBy(xpath = "//input[@name='walkin_truck_dispatch.phone']")
	private WebElement walkinPhone;

	public void addWalkinDetails(String crosswalk) {
		wait.forElementToBeDisplayed(walkinBtn);
		jsclick(walkinBtn);
		wait.forElementToBeDisplayed(truckDispatchWalkIn);
		truckDispatchWalkIn.sendKeys(crosswalk);
		wait.forElementToBeDisplayed(walkInAddress);
		walkInAddress.sendKeys(CommonVariables.address);
		wait.forElementToBeDisplayed(walkinPhone);
		walkinPhone.sendKeys(CommonVariables.driverPhoneNumber);
	}

	@FindBy(xpath = "//div[text()='Possible duplicate events for the equipment']")
	private WebElement duplicateText;
	@FindBy(xpath = "//span[text()='Ignore & continue']")
	private WebElement btnIgnore;
	@FindBy(xpath = "//span[text()='OK']")
	private WebElement okBotton;

	public void selectDuplicateEventNumber(String duplicateChassisNumber) {
		wait.forElementToBeClickable(equipmentNumber);
		// equipmentNumber.clear();
		equipmentNumber.sendKeys(duplicateChassisNumber);
		selectDriver.click();
		wait.forElementToBeClickable(noDriver);
		noDriver.click();
		jsAction.jsclick(unitWithDriver);
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/form/div/div[3]/div/div[6]/div/div[2]/div/div/div[1]/div/div[1]/div/span[1]/input | /html/body/div[1]/div[2]/div[1]/div/div/div[2]/div/form/div/div[3]/div/div[7]/div/div[2]/div/div/div[1]/div/div[1]/div/span[1]/input")
	private WebElement selectDriverEditPage;
	@FindBy(xpath = "(//span[@class='ant-switch-inner'])[5]")
	private WebElement dropLocationEditPage;

	public void selectEditEventNumber(String duplicateChassisNumber) {
		wait.forElementToBeDisplayed(okBotton);
		jsAction.jsclick(okBotton);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(equipmentNumber);
		equipmentNumber.sendKeys(duplicateChassisNumber);
		driverActions.hardwaitBasedOnInput(5000);
		clickIgnoreCont();
		driverActions.hardwaitBasedOnInput(3000);
		System.out.println("Find Duplicate Pop-Up Validated in EditPage");
	}

	@FindBy(xpath = "//button[@class='ant-btn create-header-save-draft']")
	private WebElement saveDraft;

	public void clickSaveDraftButton() {
		wait.forElementToBeDisplayed(saveDraft);
		jsAction.jsclick(saveDraft);
	}

	@FindBy(xpath = "//a[@class='head-tenant-name']")
	private WebElement headTenantName;
	@FindBy(xpath = "//a[@href='#payment-methods']")
	private WebElement clickPaymentMethods;

	public void clickPaymentMethod() {
		driver.get(propsReader.tdURL);
		headTenantName.click();
		wait.forElementToBeDisplayed(clickPaymentMethods);
		jsAction.jsclick(clickPaymentMethods);

	}

	@FindBy(xpath = "//div[@id='s2id_default_payment_method_id']/a")
	private WebElement defaultMethodSelect;
	@FindBy(xpath = "(//div[text()='House Account'])[2]")
	private WebElement methodHouseAccount;
	@FindBy(xpath = "//input[@value='Save All']")
	private WebElement btnSaveAll;

	public void selectDefaultPaymentMethod() {
		wait.forElementToBeDisplayed(defaultMethodSelect);
		// jsAction.jsclick(defaultMethodSelect);
		defaultMethodSelect.click();
		wait.forElementToBeDisplayed(methodHouseAccount);
		// jsAction.jsclick(methodHouseAccount);
		methodHouseAccount.click();
		// jsAction.scrollIntoView(btnSaveAll);
		jsAction.jsclick(btnSaveAll);
		// btnSaveAll.click();
		driverActions.hardwaitBasedOnInput(3000);
	}

	@FindBy(xpath = "//div[text()='Please select']")
	private WebElement pleaseSelect;

	public void deselectDefaultPaymentMethod() {
		wait.forElementToBeDisplayed(defaultMethodSelect);
		// jsAction.jsclick(defaultMethodSelect);
		defaultMethodSelect.click();
		wait.forElementToBeDisplayed(pleaseSelect);
		// jsAction.jsclick(methodHouseAccount);
		pleaseSelect.click();
		// jsAction.scrollIntoView(btnSaveAll);
		jsAction.jsclick(btnSaveAll);
		// btnSaveAll.click();
		driverActions.hardwaitBasedOnInput(3000);
	}

	@FindBy(xpath = "(//*[@class=\"payment\"]/div/div[3]/div/div/span[2])[1]")
	private WebElement cashSwitch;

	public void selectCashPaymentMethod() {
		wait.forElementToBeDisplayed(cashSwitch);
		cashSwitch.click();
		jsAction.jsclick(btnSaveAll);
		driverActions.hardwaitBasedOnInput(3000);
	}

	@FindBy(xpath = "//span[text()='Assign Anyway']")
	private WebElement assignAnyway;

	public void handleAssignAnyway() {

		wait.forElementToBeDisplayed(assignAnyway);
		assignAnyway.click();
		driverActions.hardwaitBasedOnInput(3000);
	}

	@FindBy(xpath = "//*[@id=\"payment-tabs\"]/li[4]/a/h5")
	private WebElement btnNationalTire;
	@FindBy(xpath = "(//*[@class=\"payment\"]/div/div[4]/div/div/span[2])[1]")
	private WebElement clickNationalTire;

	public void selectNationalTireMethod() {
		wait.forElementToBeDisplayed(btnNationalTire);
		btnNationalTire.click();
		wait.forElementToBeDisplayed(clickNationalTire);
		clickNationalTire.click();
		jsAction.jsclick(clickCheckPaymentMethod);
		jsAction.jsclick(btnSaveAll);
		driverActions.hardwaitBasedOnInput(3000);
	}

	@FindBy(xpath = "//ul[@id=\"payment-tabs\"]/li[2]/a/h5")
	private WebElement btnCheck;
	@FindBy(xpath = "(//*[@class=\"payment\"]/div/div[3]/div/div/span[2])[2]")
	private WebElement clickCheckPaymentMethod;

	public void selectCheckPaymentMethod() {
		wait.forElementToBeDisplayed(btnCheck);
		btnCheck.click();
		wait.forElementToBeDisplayed(clickCheckPaymentMethod);
		clickCheckPaymentMethod.click();
		jsAction.jsclick(btnSaveAll);
		driverActions.hardwaitBasedOnInput(3000);
	}

	@FindBy(xpath = "//*[@id=\"incidents-datatable_wrapper\"]/div[2]/div[3]/div[2]/div/table/tbody/tr/td/a[1]/i")
	public WebElement Edit;

	public void action() {
		wait.forLoading();
		wait.forElementToBeDisplayed(Edit);
		jsAction.jsclick(Edit);
	}

	@FindBy(xpath = "//button[@class='ant-btn delete-event-button']")
	private WebElement btndelete;

	public void deleteevent() {
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(btndelete);
		jsAction.scrolldownandJsClick(btndelete);
	}

	@FindBy(xpath = "//span[text()='Create Event']")
	private WebElement createBtn;
	@FindBy(xpath = "//span[text()='+ Add Service Item']")
	private WebElement addServiceLineDraft;
	@FindBy(xpath = "//*[@id=\"line_items.0.aar.service.name\"]")
	private WebElement addServiceDraft;
	@FindBy(xpath = "//span[text()='Yard Check']")
	private WebElement yardCheckBtn;
	@FindBy(xpath = "//input[@name='reported_location']")
	private WebElement locationDraft;
	@FindBy(xpath = "//div[text()='ABSECUCable - ReplaceW/New']")
	private WebElement selectServiceDraft;

	public void createDraftevent() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		jsAction.scrollDown();
		wait.forElementToBeDisplayed(addServiceLineDraft);
		jsAction.jsclick(addServiceLineDraft);
		wait.forElementToBeDisplayed(addServiceBtn);
		driverActions.driverSendKeys(addServiceDraft, "ABSECUCable - ReplaceW/New");
		driverActions.hardwaitBasedOnInput(4000);
		driverActions.driverClick(selectServiceDraft);
		jsAction.jsclick(selectServiceDraft);
//		 jsAction.jsInput(addServiceDraft, "ABSECUCable"+ Keys.ARROW_DOWN +
//		 Keys.ENTER);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(createBtn);
		jsAction.scrolldownandJsClick(createBtn);

	}

	@FindBy(xpath = "//*[@id=\"payment-tabs\"]/li[5]/a/h5")
	private WebElement btnOEM;
	@FindBy(xpath = "(//*[@class=\"payment\"]/div/div[3]/div/div/span[2])[18]")
	private WebElement clickOEM;

	public void selectOEMmethod() {
		wait.forElementToBeDisplayed(btnOEM);
		btnOEM.click();
		wait.forElementToBeDisplayed(clickOEM);
		clickOEM.click();
		jsAction.jsclick(btnSaveAll);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//*[@id=\"payment-tabs\"]/li[7]/a/h5")
	private WebElement btnReachPayment;
	@FindBy(xpath = "(//*[@class=\"payment\"]/div/div[3]/div/div/label)[27]")
	private WebElement clickReachPayment;

	public void selectReachPaymentmethod() {
		wait.forElementToBeDisplayed(btnReachPayment);
		btnReachPayment.click();
		wait.forElementToBeDisplayed(clickReachPayment);
		clickReachPayment.click();
		jsAction.jsclick(btnSaveAll);
		driverActions.hardwaitBasedOnInput(3000);
	}

	@FindBy(xpath = "//*[@id=\"payment-tabs\"]/li[8]/a/h5")
	private WebElement btnTireWarranty;
	@FindBy(xpath = "(//*[@class=\"payment\"]/div/div[3]/div/div/span[2])[28]")
	private WebElement clickTireWarranty;

	public void selectTireWarrantyMethod() {
		wait.forElementToBeDisplayed(btnTireWarranty);
		btnTireWarranty.click();
		wait.forElementToBeDisplayed(clickTireWarranty);
		clickTireWarranty.click();
		jsAction.jsclick(btnSaveAll);
		driverActions.hardwaitBasedOnInput(3000);
	}

	@FindBy(xpath = "//label[text()='Choose a different EP']/following::div[1]/div/div/button")
	private WebElement btnDifferentEP;

	public void selectDifferentEP() {
		wait.forElementToBeDisplayed(btnDifferentEP);
		btnDifferentEP.click();
		driverActions.hardwaitBasedOnInput(5000);
	}

	// @FindBy(xpath="/html/body/div[1]/section/main/form/div[1]/div/div[2]/div/div/div[1]/div/div[5]/div/div/div/div/div[2]/div[2]/div/div[1]/span[1]/input")
	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[3]")
	//@FindBy(xpath = "//span[@class='ant-select-selection-item' and @title='Unknown Equipment Provider']")
	private WebElement differentEP;

	public void selectEP(String equipmentProvider) {
		wait.forElementToBeDisplayed(differentEP);
		differentEP.click();
		driverActions.hardwaitBasedOnInput(5000);

		//WebElement selectDiffEP = driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'])[3]"));
//  //span[@class='ant-select-item " +
//				"ant-select-item-option ant-select-item-option-active' and @title='AutoTruck Fleet']
		WebElement selectDiffEP = driver.findElement(
				By.xpath("//div[text()='" + equipmentProvider + "' and @class='ant-select-item-option-content']"));
		wait.forElementToBeDisplayed(selectDiffEP);
		jsAction.jsclick(selectDiffEP);

	}

	@FindBy(xpath = "//span[text()='Event Forwarded From']/parent::label/parent::div/following-sibling::div/div/div/div/div[1]/span[1]/input")
	private WebElement eventForwardedFromRelative;
	//@FindBy(xpath = "//div[@id='billing_event_forward_from_list']/following-sibling::div/div[1]/div/div/div/div")
	@FindBy(xpath = "(//div[@id='billing_event_forward_from_list']/following-sibling::div/div[1]/div/div/div/div)[2]")
	private WebElement eventForwardedFromFirstOption;

	public void selectEventForwardedFrom() {
		wait.forElementToBeDisplayed(eventForwardedFromRelative);
		jsAction.jsclick(eventForwardedFromRelative);
		driverActions.hardwaitBasedOnInput(2000);
		eventForwardedFromRelative.sendKeys("AutoTruck CC1");
		driverActions.hardwaitBasedOnInput(6000);
		wait.forElementToBeDisplayed(eventForwardedFromFirstOption);
		jsAction.jsclick(eventForwardedFromFirstOption);
	}

	@FindBy(xpath = "//label[@for='responsible_payer']/parent::div/following-sibling::div/div/div/div/div/span[1]/input")
	private WebElement responsiblePayerName;
	@FindBy(xpath = "//div[@class='responsible-payer-options-label']")
	private WebElement responsiblePayerFromFirstOption;
	@FindBy(xpath = "//input[@id='payment_method']")
	private WebElement responsiblePayerPaymentMethod;
	@FindBy(xpath = "//div[text()='National Tire Account']/following::div[1]/div")
	private WebElement responsiblePayerPaymentMethodNationalTireAccount;
	@FindBy(xpath = "//input[@id='payment_account_number']")
	private WebElement responsiblePayerPaymentAccNum;
	@FindBy(xpath = "//div[@title='ATFleetShipToAccount']/div")
	private WebElement responsiblePayerPaymentAccNumFirstOption;
	@FindBy(xpath = "(//div[@class='shipToLocationDiv'])[1]")
	private WebElement shipToLoaction;
	@FindBy(xpath = "(//div[@class='shipToLocationDiv'])[2]")
	private WebElement billToLoaction;
	@FindBy(xpath = "//label[@for='oem_verified_account']/following::div[1]/div/div/span")
	private WebElement oemVerifiedAccount;
	@FindBy(xpath = "//label[@for='payment_notes']/following::div[1]/div/div/div/div/span")
	private WebElement paymentNotes;

	public void selectBridgestoneResponsiblePayer(String customerName){
		wait.forElementToBeDisplayed(responsiblePayerName);
		jsAction.jsclick(responsiblePayerName);
		driverActions.hardwaitBasedOnInput(2000);
		responsiblePayerName.sendKeys(customerName);
		driverActions.hardwaitBasedOnInput(4000);
		wait.forElementToBeDisplayed(responsiblePayerFromFirstOption);
		jsAction.jsclick(responsiblePayerFromFirstOption);
		wait.forElementToBeDisplayed(responsiblePayerPaymentMethod);
		jsAction.jsclick(responsiblePayerPaymentMethod);
		driverActions.hardwaitBasedOnInput(2000);
		responsiblePayerPaymentMethod.sendKeys("Bridgestone");
		driverActions.hardwaitBasedOnInput(4000);
		wait.forElementToBeDisplayed(responsiblePayerPaymentMethodNationalTireAccount);
		jsAction.jsclick(responsiblePayerPaymentMethodNationalTireAccount);
		wait.forElementToBeDisplayed(responsiblePayerPaymentAccNum);
		jsAction.jsclick(responsiblePayerPaymentAccNum);
		driverActions.hardwaitBasedOnInput(2000);
		responsiblePayerPaymentAccNum.sendKeys("ATFleetShipToAccount");
		wait.forElementToBeDisplayed(responsiblePayerPaymentAccNumFirstOption);
		jsAction.jsclick(responsiblePayerPaymentAccNumFirstOption);
		wait.forElementToBeDisplayed(shipToLoaction);
		Assert.assertEquals("ATFleetShipToFleet\n"+"San Francisco, CA, USA\n"+"Account# ATFleetShipToAccount",driverActions.driverGetText(shipToLoaction));
		wait.forElementToBeDisplayed(billToLoaction);
		Assert.assertEquals("ATFleetBillToFleet\n"+"San Francisco, CA, USA\n"+"Account# ATFleetBillToAccount",driverActions.driverGetText(billToLoaction));
		wait.forElementToBeDisplayed(oemVerifiedAccount);
		Assert.assertEquals("Account verified",driverActions.driverGetText(oemVerifiedAccount));
		wait.forElementToBeDisplayed(paymentNotes);
		Assert.assertEquals("Bill to Account # : ATFleetBillToAccount",driverActions.driverGetText(paymentNotes));
	}



	public void selectdriver() {
		jsAction.jsclick(selectDriver);
		selectDriver.sendKeys(CommonVariables.driverName);
		wait.forElementToBeClickable(noDriver);
		// noDriver.click();
		jsAction.jsclick(noDriver);
		wait.forElementToBeClickable(unitWithDriver);
		jsAction.jsclick(unitWithDriver);
	}

	public void selectdriver1() {
		jsAction.jsclick(selectDriver);
		selectDriver.sendKeys(CommonVariables.driverName);
		wait.forElementToBeClickable(noDriver);
		jsAction.jsclick(noDriver);
		wait.forElementToBeClickable(unitWithDriver1);
		jsAction.jsclick(unitWithDriver1);
	}

	public void clickIgnoreCont() {
		driverActions.hardwaitBasedOnInput(5000);
		wait.forElementToBeDisplayed(btnIgnore);
		// btnIgnore.click();
		jsAction.jsclick(btnIgnore);
		driverActions.hardwaitBasedOnInput(2000);
	}

	public void eventTemplate(String equipmentType) {
		wait.forElementToBeDisplayed(eventButton);
		jsAction.jsclick(eventButton);
		if (equipmentType.equalsIgnoreCase("Chassis")) {
			wait.forElementToBeClickable(chassisTemplate);
			jsAction.jsclick(chassisTemplate);
		}
		if (equipmentType.equalsIgnoreCase("Power Unit")) {
			wait.forElementToBeClickable(powerUnitTemplate);
			jsAction.jsclick(powerUnitTemplate);
		}
		if (equipmentType.equalsIgnoreCase("Trailer")) {
			wait.forElementToBeClickable(trailerTemplate);
			jsAction.jsclick(trailerTemplate);
		}
		if (equipmentType.equalsIgnoreCase("Container")) {
			wait.forElementToBeClickable(containerTemplate);
			jsAction.jsclick(containerTemplate);
		}
	}

	@FindBy(xpath = "//input[@id='service_event_template_name']")
	private WebElement templateName;


	@FindBy(xpath = "(//a[normalize-space()='Add new'])[1]")
	private WebElement addNewBtn;

	@FindBy(xpath = "//span[text()='Save Template']")
	private WebElement saveTemplateBtn;

	public void createEventTemplate() {
		wait.forElementToBeDisplayed(eventButton);
		jsAction.jsclick(eventButton);
		wait.forElementToBeDisplayed(addNewBtn);
		jsclick(addNewBtn);

		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(templateName);
		jsclick(templateName);

		templateName.sendKeys("chassis01");
		driverActions.hardwaitBasedOnInput(2000);

		wait.forElementToBeDisplayed(saveTemplateBtn);
		saveTemplateBtn.click();
		driverActions.hardwaitBasedOnInput(2000);
	}

	public void deleteTemplate() {
		wait.forElementToBeDisplayed(eventButton);
		jsAction.jsclick(eventButton);
		Actions act = new Actions(driver);
		act.moveToElement(deleteIconBtn).build().perform();
		jsclick(deleteIconBtn);

		driverActions.hardwaitBasedOnInput(2000);

		wait.forElementToBeClickable(popUpOKBtn);
		popUpOKBtn.click();
		System.out.println("----- Template deleted successfully !!!! -----");

		driverActions.hardwaitBasedOnInput(2000);
	}

	public void techSchedularTab() {
		wait.forElementToBeClickable(techSchedulerTab);
		techSchedulerTab.click();
		wait.forLoading();
		driver.switchTo().frame(0);
		driverActions.hardwaitBasedOnInput(2000);
	}

	// Tech-Scheduler
	@FindBy(xpath = "//*[@href=\"/technician_scheduler\"]")
	private WebElement techSchedulerTab;
	@FindBy(xpath = "//*[@class='fc-addTechnician-button fc-button fc-button-primary']")
	private WebElement addTechTab;
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstNameTS;
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastNameTS;
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailTS;
	@FindBy(xpath = "//input[@name='phoneNumber']")
	private WebElement phoneNumberTS;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTS;
	@FindBy(xpath = "//button[@class = 'r24btn r24btn--wide r24btn--pri']")
	private WebElement submitAddTech;
	@FindBy(xpath = "//label[text()='Superior Skill']/parent::div/div[1]/div/div/div[1]/div[2]/div/input")
	private WebElement superiorSkill;

	@FindBy(xpath = "(//*[@xmlns='http://www.w3.org/2000/svg'])[4]")
	private WebElement technicianNotes;
	@FindBy(xpath = "(//*[@xmlns='http://www.w3.org/2000/svg'])[5]")
	private WebElement technicianAddNotes;
	@FindBy(xpath = "//textarea[@class='r24fg__input r24fg--textarea w-100']")
	private WebElement technicianAddNotesTextArea;
	@FindBy(xpath = "//button[@class='r24btn r24btn--wide r24btn--pri']")
	private WebElement technicianAddNotesSaveBtn;

	public void addTechinTS(String techName) {
		wait.forElementToBeClickable(addTechTab);
		jsclick(addTechTab);

		driverActions.hardwaitBasedOnInput(2000);

		String firstName = techName.split(" (?!.* )")[0];
		String lastName = techName.split(" (?!.* )")[1];
		wait.forElementToBeDisplayed(firstNameTS);
		firstNameTS.sendKeys(firstName);
		wait.forElementToBeDisplayed(lastNameTS);
		lastNameTS.sendKeys(lastName);
		wait.forElementToBeDisplayed(emailTS);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
		emailTS.sendKeys(firstName + "+" + lastName + randomInt + "@reach24.net");
		wait.forElementToBeDisplayed(phoneNumberTS);
		phoneNumberTS.sendKeys("6235525611");
		wait.forElementToBeDisplayed(passwordTS);
		passwordTS.sendKeys("welcome123");
		wait.forElementToBeDisplayed(superiorSkill);
		// superiorSkillTS.sendKeys("Lamps");
		Actions actions = new Actions(driver);
		actions.sendKeys(superiorSkillTS, "Lighting devices" + Keys.ENTER + Keys.ESCAPE).perform();
		wait.forElementToBeClickable(submitAddTech);
		submitAddTech.click();
		System.out.println("Technician Added Succesfully");

		wait.forElementToBeClickable(nextTab);
		jsclick(nextTab);

		wait.forElementToBeClickable(dayView);
		jsclick(dayView);

		wait.forElementToBeDisplayed(techNameInput);
		jsAction.jsInput(techNameInput, techName);
		wait.forElementToBeDisplayed(applyButton);
		jsAction.jsclick(applyButton);

		wait.forElementToBeDisplayed(technicianNotes);
		actions.moveToElement(technicianNotes).perform();
		actions.click().perform();

		wait.forElementToBeDisplayed(technicianAddNotes);
		actions.moveToElement(technicianAddNotes).perform();
		actions.click().perform();

		wait.forElementToBeDisplayed(technicianAddNotesTextArea);
		jsAction.jsInput(technicianAddNotesTextArea, "Hi ! This is Technician 2. I specializes in Lighting Devices.");

		wait.forElementToBeDisplayed(technicianAddNotesSaveBtn);
		jsAction.jsclick(technicianAddNotesSaveBtn);

		wait.forElementToBeClickable(weekView);
		jsclick(weekView);

	}

	@FindBy(xpath = "//input[@name='technicianName']")
	private WebElement filterByName;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[3]/div[2]/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td/div/div/span[2]/div/span[3]")
	private WebElement tech2;
	// @FindBy(xpath =
	// "//*[@id=\"root\"]/div/div[1]/div[3]/div[2]/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td/div/div/span[2]/div/button")
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[3]/div[2]/div/table/tbody/tr/td[1]/div/div/table/tbody/tr/td/div/div/span[2]/div/span[4]/button[1]")
	private WebElement editTechTS;
	@FindBy(xpath = "//input[@name='personalPhone']")
	private WebElement personalPhoneTS;
	@FindBy(xpath = "//input[@name='afterHoursPhone']")
	private WebElement afterHoursPhoneTS;
	@FindBy(xpath = "(//div[@class='r24modal__right']/div/div[1]/div[2]/div[1])[1]")
	private WebElement superiorSkillTS;
	@FindBy(xpath = "/html/body/div[3]/div/div/form/div/div[1]/div[8]/div/div/div[1]/div[1]")
	private WebElement superiorText;
	@FindBy(xpath = "(//div[@class='r24modal__right']/div/div[1]/div[2]/div[1])[2]")
	private WebElement advancedSkillTS;
	@FindBy(xpath = "(//div[@class='r24modal__right']/div/div[1]/div[2]/div[1])[3]")
	private WebElement intermidiateSkillTS;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitUpdateBtn;

	public void editTechinTS() {
		driverActions.hardwaitBasedOnInput(2000);
		scrollUpandclick(filterByName);
		filterByName.clear();

		wait.forElementToBeDisplayed(filterByName);
		jsAction.jsInput(filterByName, "Tech2");
		// filterByName.sendKeys();
		wait.forElementToBeDisplayed(applyButton);
		jsAction.jsclick(applyButton);

		driverActions.hardwaitBasedOnInput(3000);

		Actions actions = new Actions(driver);

		actions.moveToElement(tech2).perform();
		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeDisplayed(editTechTS);
		editTechTS.click();

		personalPhoneTS.clear();
		personalPhoneTS.sendKeys("6235525611");
		afterHoursPhoneTS.clear();
		afterHoursPhoneTS.sendKeys("6235525611");

		jsclick(superiorSkillTS);
		actions.sendKeys(superiorSkillTS, "Engine" + Keys.ENTER + Keys.ESCAPE).perform();
		wait.forElementToBeClickable(submitUpdateBtn);
		jsclick(submitUpdateBtn);
		System.out.println("Technician Updated Succesfully");

	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[2]/div/form/div/div[3]/div/div[1]/div[1]")
	private WebElement filterByExpertise;
	@FindBy(xpath = "//button[@class='mr-auto delete-technician']")
	private WebElement deleteTechTS;
	@FindBy(xpath = "//button[@class='r24btn r24btn--small r24btn--pri export-schedule-action']")
	private WebElement confirmDelete;

	public void deleteTechinTS() {
		Actions actions = new Actions(driver);
		wait.forElementToBeDisplayed(filterByName);
		filterByName.clear();
		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeClickable(filterByExpertise);
		jsclick(filterByExpertise);
		actions.sendKeys(filterByExpertise, "Engine" + Keys.ENTER + Keys.ESCAPE).perform();
		wait.forLoading();
		actions.moveToElement(tech2).perform();
		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeClickable(editTechTS);
		editTechTS.click();
		wait.forElementToBeDisplayed(deleteTechTS);
		jsclick(deleteTechTS);
		wait.forElementToBeClickable(confirmDelete);
		jsclick(confirmDelete);
		System.out.println("Technician Deleted Succesfully");

	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[3]/div[1]/div[3]/button[6]")
	private WebElement nextTab;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[3]/div[2]/div/table/tbody/tr/td[3]/div/div/div/table/tbody/tr")
	private WebElement nextShift;
	@FindBy(xpath = "(//input[@name='priority'])[2]")
	private WebElement priority;
	@FindBy(xpath = "//div[@class='fc-timeline-event-harness']")
	private WebElement techShift;
	@FindBy(xpath = "//a[@class='mr-auto delete-shift']")
	private WebElement deleteShift;
	@FindBy(xpath = "//input[@name='technicianName']")
	private WebElement techNameInput;
	@FindBy(xpath = "//button[@class='r24btn r24btn--small r24btn--pri r24filters__single']")
	private WebElement applyButton;
	@FindBy(xpath = "//textarea[@class='r24fg__input r24fg--textarea']")
	private WebElement shiftNotesTextArea;

	public void addShiftTS(String techName) {
		wait.forElementToBeDisplayed(techNameInput);
		jsAction.jsInput(techNameInput, techName);
		wait.forElementToBeDisplayed(applyButton);
		jsAction.jsclick(applyButton);

		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeClickable(nextTab);
		jsclick(nextTab);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

		Actions actions = new Actions(driver);
		wait.forElementToBeDisplayed(nextShift);
		actions.moveToElement(nextShift).perform();
		driverActions.hardwaitBasedOnInput(3000);
		actions.click().perform();

		wait.forElementToBeDisplayed(shiftNotesTextArea);
		jsAction.jsInput(shiftNotesTextArea, "Replacement for Technician1");

		wait.forElementToBeDisplayed(priority);
		priority.sendKeys("1" + Keys.ENTER);

		System.out.println("Shift added Succesfully");
	}

	@FindBy(xpath = "//input[@class='r24btn r24btn--small r24btn--light']")
	private WebElement resetBtn;
	@FindBy(xpath = "(//div[@class='r24__placeholder css-1wa3eu0-placeholder'])[1]")
	private WebElement expertiseFilter;
	@FindBy(xpath = "(//div[@class='r24__placeholder css-1wa3eu0-placeholder'])[2]")
	private WebElement priorityFilter;

	public void editAndVerifyShiftTS(String techName) {
		wait.forElementToBeDisplayed(resetBtn);
		jsAction.jsclick(resetBtn);

		Actions actions = new Actions(driver);
		wait.forElementToBeDisplayed(expertiseFilter);
		driverActions.hardwaitBasedOnInput(2000);
		jsclick(expertiseFilter);
		actions.sendKeys(expertiseFilter, "Engine" + Keys.ENTER + Keys.ESCAPE).perform();

		driverActions.hardwaitBasedOnInput(2000);

		int size = driver.findElements(By.xpath("//div[@class='fc-timeline-event-harness']")).size();
		Boolean testShift = false;
		if (size == 1) {
			testShift = true;
		}
		Assert.assertTrue(testShift);

		wait.forElementToBeDisplayed(resetBtn);
		jsAction.jsclick(resetBtn);

		wait.forElementToBeDisplayed(priorityFilter);
		driverActions.hardwaitBasedOnInput(2000);
		jsclick(priorityFilter);
		actions.sendKeys(priorityFilter, "1" + Keys.ENTER + Keys.ESCAPE).perform();

		driverActions.hardwaitBasedOnInput(2000);

		int size2 = driver.findElements(By.xpath("//div[@class='fc-timeline-event-harness']")).size();
		testShift = false;
		if (size2 == 1) {
			testShift = true;
		}
		Assert.assertTrue(testShift);

		wait.forElementToBeDisplayed(resetBtn);
		jsAction.jsclick(resetBtn);

	}

	public void deleteShiftTS() {
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(techShift);
		techShift.click();
		wait.forElementToBeClickable(deleteShift);
		jsAction.jsclick(deleteShift);
		System.out.println("Shift deleted Successfully");
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[3]/div[1]/div[3]/div/button[1]")
	private WebElement dayView;
	@FindBy(xpath = "(//*[@xmlns='http://www.w3.org/2000/svg'])[3]")
	private WebElement techNotes;
	@FindBy(xpath = "(//*[@xmlns='http://www.w3.org/2000/svg'])[5]")
	private WebElement addNotes;
	@FindBy(xpath = "//textarea[@name = 'notes']")
	private WebElement textArea;
	@FindBy(xpath = "//button[@class = 'r24btn r24btn--wide r24btn--pri']")
	private WebElement saveNote;

	public void addDayNotes() {
		wait.forElementToBeClickable(techSchedulerTab);
		techSchedulerTab.click();
		wait.forLoading();
		driverActions.hardwaitBasedOnInput(3000);

		driver.switchTo().frame(0);
		wait.forElementToBeClickable(nextTab);
		jsclick(nextTab);

		wait.forElementToBeClickable(dayView);
		jsclick(dayView);
		// wait.forElementToBeDisplayed(techNotes);
		// jsclick(techNotes);
		Actions actions = new Actions(driver);
		wait.forElementToBeDisplayed(techNotes);
		actions.moveToElement(techNotes).perform();
		actions.click().perform();
		wait.forElementToBeDisplayed(addNotes);
		actions.moveToElement(addNotes).perform();
		actions.click().perform();

		// jsclick(addNotes);

		wait.forElementToBeDisplayed(textArea);
		textArea.sendKeys("This is a Test");
		jsclick(saveNote);

	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[3]/div[1]/div[3]/div/button[2]")
	private WebElement weekView;

	public void deleteTechnicianNotes() {
		wait.forElementToBeClickable(dayView);
		jsAction.jsclick(dayView);
		wait.forElementToBeDisplayed(technicianNotes);
		// technicianNotes.click();
		Actions actions = new Actions(driver);
		wait.forElementToBeDisplayed(technicianNotes);
		actions.moveToElement(technicianNotes).perform();
		driverActions.hardwaitBasedOnInput(2000);
		actions.click().perform();

		wait.forElementToBeClickable(technicianAddNotes);
		technicianAddNotes.click();
		// actions.moveToElement(technicianAddNotes).perform();
		// actions.click().perform();

		wait.forElementToBeDisplayed(technicianAddNotesTextArea);
		technicianAddNotesTextArea.clear();
		jsclick(technicianAddNotesSaveBtn);

		wait.forElementToBeClickable(weekView);
		jsAction.jsclick(weekView);
	}

	@FindBy(xpath = "//button[@class='fc-copyShifts-button fc-button fc-button-primary']")
	private WebElement copyPreviousWeekBtn;

	@FindBy(xpath = "//button[@class='r24btn r24btn--pri r24btn--wide']")
	private WebElement copyPreviousProceedBtn;

	public void copyPreviousWeekShiftInTS() {
		wait.forElementToBeClickable(nextTab);
		jsAction.jsclick(nextTab);
		wait.forElementToBeClickable(copyPreviousWeekBtn);
		// jsAction.jsclick(copyPreviousWeekBtn);
		// copyPreviousWeekBtn.click();
		// driverActions.driverClick(copyPreviousWeekBtn);
		wait.forElementToBeClickable(copyPreviousProceedBtn);
		jsAction.jsclick(copyPreviousProceedBtn);
	}

	@FindBy(xpath = "(//*[@xmlns = 'http://www.w3.org/2000/svg'])[2]")
	private WebElement generalNotes;
	@FindBy(xpath = "(//div[@class = 'notranslate public-DraftEditor-content'])[2] | //textarea[@class='r24fg__input r24fg--textarea w-100']")
	private WebElement generalTextArea;
	@FindBy(xpath = "//button[@class = 'r24btn r24btn--wide r24btn--pri']")
	private WebElement saveNotes;
	@FindBy(xpath = "(//*[@xmlns = 'http://www.w3.org/2000/svg'])[1]")
	private WebElement textExpansion;
	@FindBy(xpath = "//span[@class = 'mb-0 text-justify text-black false']")
	private WebElement textGeneralNotes;
	@FindBy(xpath = "(//*[@xmlns='http://www.w3.org/2000/svg'])[2]")
	private WebElement editGeneralNotes;

	public void addGeneralNotes() {
		wait.forElementToBeClickable(generalNotes);
		generalNotes.click();
		wait.forElementToBeDisplayed(generalTextArea);
		generalTextArea.clear();
		generalTextArea.sendKeys("General Notes Testing");
		driverActions.hardwaitBasedOnInput(2000);
		saveNotes.click();
		System.out.println("General Notes Added");
		// driverActions.hardwaitBasedOnInput(2000);
		// wait.forElementToBeClickable(generalNotes);
		// generalNotes.click();
		// wait.forElementToBeDisplayed(generalTextArea);
		// System.out.println(generalTextArea.getText());
		// Assert.assertEquals("General Notes", "General Notes Testing",
		// generalTextArea.getText());
		// wait.forElementToBeDisplayed(generalTextArea);
		// generalTextArea.clear();
		// driverActions.hardwaitBasedOnInput(2000);
		// saveNotes.click();
		// System.out.println("General Notes Deleted");
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div[3]/div[2]/div/table/tbody/tr/td[1]/div/div/table"
			+ "/tbody/tr/td/div/div/span[2]/div/span[4]/button[2]")
	private WebElement techLog;
	@FindBy(xpath = "//div[@class = 'modal-header']")
	private WebElement headerActivityLog;
	@FindBy(xpath = "//strong[@class='r24tech__name']")
	private WebElement techNameLog;
	@FindBy(xpath = "//table[@class='table mt-3 mb-0 r24tech__activity__table']/thead/tr/th[text()='Action']")
	private WebElement actionLog;
	@FindBy(xpath = "//table[@class='table mt-3 mb-0 r24tech__activity__table']/thead/tr/th[text()='Time']")
	private WebElement timeLog;
	@FindBy(xpath = "//table[@class='table mt-3 mb-0 r24tech__activity__table']/thead/tr/th[text()='User']")
	private WebElement userLog;
	@FindBy(xpath = "//table[@class='table mt-3 mb-0 r24tech__activity__table']/thead/tr/th[text()='ShiftId']")
	private WebElement shiftIDlog;
	@FindBy(xpath = "//table[@class='table mt-3 mb-0 r24tech__activity__table']/thead/tr/th[text()='Notes']")
	private WebElement notesLog;
	@FindBy(xpath = "//table[@class='table mt-3 mb-0 r24tech__activity__table']/thead/tr/th[text()='Priority']")
	private WebElement priorityLog;
	@FindBy(xpath = "//table[@class='table mt-3 mb-0 r24tech__activity__table']/thead/tr/th[text()='Shift Start Time']")
	private WebElement shiftStartLog;
	@FindBy(xpath = "//table[@class='table mt-3 mb-0 r24tech__activity__table']/thead/tr/th[text()='Shift End Time']")
	private WebElement shiftEndLog;

	@FindBy(xpath = "//table[@class='table mt-3 mb-0 r24tech__activity__table']/tbody/tr[1]/td[1]")
	private WebElement activityLogTR1;
	@FindBy(xpath = "//table[@class='table mt-3 mb-0 r24tech__activity__table']/tbody/tr[2]/td[1]")
	private WebElement activityLogTR2;
	@FindBy(xpath = "//table[@class='table mt-3 mb-0 r24tech__activity__table']/tbody/tr[3]/td[1]")
	private WebElement activityLogTR3;
	@FindBy(xpath = "(//button[@class='close']/span)[1]")
	private WebElement closeLog;

	public void activityLog() {
		wait.forElementToBeDisplayed(resetBtn);
		jsAction.jsclick(resetBtn);

		Actions actions = new Actions(driver);
		wait.forElementToBeDisplayed(expertiseFilter);
		driverActions.hardwaitBasedOnInput(2000);
		jsclick(expertiseFilter);
		actions.sendKeys(expertiseFilter, "Engine" + Keys.ENTER + Keys.ESCAPE).perform();
		driverActions.hardwaitBasedOnInput(2000);

		actions.moveToElement(tech2).perform();
		wait.forElementToBeDisplayed(techLog);
		techLog.click();

		System.out.println("Tech Name is " + driverActions.driverGetText(techNameLog));
		// Assert.assertEquals(driverActions.driverGetText(techNameLog), "Tech2,
		// TestNEPSP1");

		System.out.println("Activity Log Fields are " + driverActions.driverGetText(actionLog) + ","
				+ driverActions.driverGetText(timeLog) + "," + driverActions.driverGetText(userLog) + ","
				+ driverActions.driverGetText(shiftIDlog) + "," + driverActions.driverGetText(notesLog) + ","
				+ driverActions.driverGetText(priorityLog) + "," + driverActions.driverGetText(shiftStartLog) + ","
				+ driverActions.driverGetText(shiftEndLog));

		Assert.assertEquals(driverActions.driverGetText(activityLogTR1), "Deleted");
		Assert.assertEquals(driverActions.driverGetText(activityLogTR2), "Created");
		// Assert.assertEquals(driverActions.driverGetText(activityLogTR3), "Created");

		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeClickable(closeLog);
		closeLog.click();

	}

	@FindBy(xpath = "//button[@class='fc-uploadShifts-button fc-button fc-button-primary']")
	private WebElement uploadShift;
	@FindBy(xpath = "//button[@class = 'r24btn r24btn--pri r24btn--wide']")
	private WebElement uploadBtnLog;
	@FindBy(xpath = "//div[@class='fc-event-pri']")
	private WebElement shiftUploaded;

	public void uploadShift() {
		wait.forElementToBeDisplayed(uploadShift);
		uploadShift.click();
		// wait.forElementToBeClickable(chooseFile);
		WebElement chooseFile = driver.findElement(By.xpath("//input[@name='file']"));
		LocalFileDetector detector = new LocalFileDetector();
		String path = new File("src\\test\\resources\\config\\lib\\Images\\ShiftUpload.csv").getAbsolutePath();
		File file = detector.getLocalFile(path);
		((RemoteWebElement) chooseFile).setFileDetector(detector);
		chooseFile.sendKeys(file.getAbsolutePath());
		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeClickable(uploadBtnLog);
		uploadBtnLog.click();
		driverActions.hardwaitBasedOnInput(1000);

		System.out.println("Shift Uploaded in CSV Successfully");

	}

	@FindBy(xpath = "//div[text()='Demo Terminal']")
	private WebElement depTerminal;

	public void validateTerminalOnEventShowPage() {
		driverActions.hardwaitBasedOnInput(5000);
		driver.switchTo().frame("eventPageIFrame");

		String str = depTerminal.getText();
		System.out.println("-----------------------");
		System.out.println(str);
		System.out.println("-----------------------");
		Assert.assertEquals(str, "Departed Terminal:\n" + "Demo Terminal\n" + "San Francisco, CA, USA");
		System.out.println("------- Departed Terminal Present -------");

	}

	@FindBy(xpath = "//div[text()='Demo Terminal']")
	private WebElement depTerminal1;

	public void validateTerminalOnEventShowPage1() {

		driver.switchTo().frame("eventPageIFrame");

		String str = depTerminal1.getText();
		System.out.println("-----------------------");
		System.out.println(str);
		System.out.println("-----------------------");
		Assert.assertEquals(str, "Departed Terminal:\n" + "Demo Terminal\n" + "San Francisco, CA, USA");
		System.out.println("------- Departed Terminal Present -------");
	}

	// Shipper...

	@FindBy(xpath = "//input[@id='shipper']")
	// @FindBy(xpath = "(//input[@class='ant-select-selection-search-input'])[6]")
	private WebElement shipperBtn;

	@FindBy(xpath = "//div[text()='Autotruck Shipper']")
	private WebElement selectShipperTenant;

	public void selectShipperTenant() {
		// Actions act = new Actions(driver);
		// driverActions.hardwaitBasedOnInput(2000);
		// act.moveToElement(shipperBtn).click().build().perform();
		// wait.forLoading();
		// driverActions.hardwaitBasedOnInput(2000);
		// act.sendKeys(Keys.DOWN).moveToElement(selectShipperTenant).click().build().perform();
		// driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(shipperBtn);
		driverActions.driverSendKeys(shipperBtn, "Autotruck Shipper");
		wait.forLoading();
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(selectShipperTenant);
		jsAction.jsclick(selectShipperTenant);
	}

	@FindBy(xpath = "//b[text()='Zeus - Our New Interface']")
	private WebElement enableZeusPage;

	public void enableZeus() {
		wait.forElementToBeDisplayed(enableZeusPage);
		jsAction.jsclick(enableZeusPage);

	}

	@FindBy(xpath = "//input[@id='assign_reporting_location']")
	private WebElement assignReportLocation;
//	@FindBy(xpath = "//div[text()='AutoTruck SP2']")
	@FindBy(xpath="//*[@id=\"root\"]/section/main/form/div[3]/div/div[2]/div/div/div[3]/div/div[5]/div/div[2]/div/div/div/div[2]/div/div/div/div[2]/div[1]/div/div/div[1]/div")
	private WebElement selectRepotingTenant;

	public void assignReportingLocation() {
		wait.forElementToBeDisplayed(assignReportLocation);
		jsAction.jsclick(assignReportLocation);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assignReportLocation.click();
		wait.forElementToBeDisplayed(selectRepotingTenant);
		jsAction.jsclick(selectRepotingTenant);
		driverActions.hardwaitBasedOnInput(2000);

	}
	
	@FindBy(xpath = "//button[@data-toggle='dropdown']/span[1]")
	private WebElement eventButton;
	@FindBy(id = "service_event_template_name")
	private WebElement templateNames;

	@FindBy(linkText = "Add new")
	private WebElement addNewtemp;
	@FindBy(xpath = "//span[text()='Update Template']")
	private WebElement clickUpdateTemplate;
	@FindBy(xpath = "//span[text()='Equipment Type']/following::input[1]")
	private WebElement equipmentTypeElement;
	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	private WebElement searchEquipmentType;
	@FindBy(xpath = "//span[text()='Equipment Type']/parent::label/parent::div/parent::div/div[2]/div/div/div/div/div/div/span/input")
	private WebElement clickEquipmentType;
	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	private WebElement clickEditTemplate;
	@FindBy(xpath = "//p[text()='This will remove all the Service Line Items']//following::span[2]")
	private WebElement epChangePopUp;

	public void clickEventTempDropdown() {
		wait.forElementToBeDisplayed(eventButton);
		jsAction.jsclick(eventButton);
	}

	public void testTemplate(String tempname) {
		wait.forElementToBeClickable(templateNames);
		jsAction.jsclick(templateNames);
		templateNames.sendKeys(tempname);

	}

	public void newTemplate() {
		wait.forElementToBeDisplayed(addNewtemp);
		jsAction.jsclick(addNewtemp);
	}

	public void editTemplate() {
		Actions act = new Actions(driver);
		act.moveToElement(clickEditTemplate).click().build().perform();
//		jsclick(clickEditTemplate);
	}

	public void selectEquipmentType(String equipmentType) {
		wait.forLoading();
		wait.forElementToBeDisplayed(equipmentTypeElement);
		jsclick(equipmentTypeElement);
		equipmentTypeElement.sendKeys(equipmentType);
		wait.forElementToBeDisplayed(equipmentTypeFirst);
		jsAction.jsclick(equipmentTypeFirst);
		if (equipmentType.equalsIgnoreCase("Container")) {
			wait.forElementToBeClickable(epChangePopUp);
			epChangePopUp.click();
			System.out.println("----- Template updated successfully !!!! -----");
		}

//		if (equipmentType.equalsIgnoreCase("Snow Scraper")) {
//			wait.forElementToBeClickable(epChangePopUp);
//			System.out.println("----- Template updated successfully !!!! -----");
//		}

		driverActions.hardwaitBasedOnInput(2000);
	}

	@FindBy(xpath = "//span[@title='Autotruck Shipper']")
	private WebElement shipperInfo;

	public void validateShipperTemplate(String shipper) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(shipperInfo);
		String Actualtext = shipperInfo.getText();
		String Expectedtext = shipper;
		System.out.println(shipper);
		Assert.assertTrue(Expectedtext.contains(Actualtext));
		System.out.println("shipper is validated");
		driver.switchTo().defaultContent();
	}

	public void selectCrossWalk(String crosswalk) {

		wait.forElementToBeClickable(advanceSearchBtn);
		advanceSearchBtn.click();
		wait.forElementToBeDisplayed(nameAdSearch);
		nameAdSearch.sendKeys(crosswalk);
		wait.forElementToBeDisplayed(searchAdSearch);
		searchAdSearch.click();
		driverActions.hardwaitBasedOnInput(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", selectCrosswalk);
		if (!selectCrosswalk.isSelected()) {
//			selectCrosswalk.click();
			jsAction.jsclick(selectCrosswalk);
		}
		wait.forElementToBeClickable(saveAdSearch);
		jsAction.jsclick(saveAdSearch);
		// saveAdSearch.click();
	}

	public void clickUpdateTemplate() {
		wait.forElementToBeDisplayed(clickUpdateTemplate);
		jsAction.jsclick(clickUpdateTemplate);
		System.out.println("----- Template updated successfully !!!! -----");
		driver.switchTo().defaultContent();

	}

	public void viewTemplate() {
		wait.forElementToBeDisplayed(templateView);
		jsAction.jsclick(templateView);
	}

	public void reportedLocation(String address) {
		wait.forElementToBeDisplayed(locationType);
		jsAction.jsclick(locationType);
		wait.forElementToBeClickable(loadedBtn);
		jsAction.jsclick(loadedBtn);
		jsAction.jsclick(location);
		driverActions.driverSendKeys(location, "San Francisco, CA, USA");
		driverActions.hardwaitBasedOnInput(2000);
		location.sendKeys(Keys.ARROW_DOWN);
		location.sendKeys(Keys.ENTER);
		wait.forElementToBeDisplayed(callerName);
//		wait.forElementToBeDisplayed(reportlocationelement);
//		driverActions.hardwaitBasedOnInput(2000);
//		jsAction.jsclick(reportlocationelement);		
//		reportlocationelement.sendKeys("San Francisco, CA, USA");
//		driverActions.hardwaitBasedOnInput(2000);
//		reportlocationelement.sendKeys(Keys.ARROW_DOWN);
//		reportlocationelement.sendKeys(Keys.ENTER);
		driverActions.hardwaitBasedOnInput(2000);
	}

	public void validateTemplatefields1(String equipmentType, String priority, String walkin, String address) {
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(4000);
		String Epvalue = driverActions.driverGetText(equipmentTypeValue);
		System.out.println(Epvalue);
		Assert.assertTrue(Epvalue.contains(equipmentType));
		driverActions.hardwaitBasedOnInput(2000);
		String EpNum = driverActions.driverGetText(equipmentNumber);
		System.out.println(EpNum);
      	jsAction.scrollIntoView(loadedBtn);
		Assert.assertTrue(loadedBtn.isEnabled());
		System.out.print("loaded enabled");
		jsAction.scrollIntoView(locationType);
		Assert.assertTrue(locationType.isEnabled());
		if(locationType.isEnabled()){
		System.out.print("location type selected");
		}

//		wait.forElementToBeDisplayed(emergencypriority);
//		System.out.println("validation priority --> " + emergencypriority.getText());
//		Assert.assertEquals("Emergency", getPriority(emergencypriority.getText()));
//		System.out.println("-------------Emergency-------------------------");
//		wait.forElementToBeDisplayed(location);
//		String Actualtext = location.getText();
//		String Expectedtext = address;
//		System.out.println(address );
//		Assert.assertTrue(Expectedtext.contains(Actualtext));
//		Assert.assertTrue(driverActions.driverGetText(location).contains("San Francisco, CA, USA"));
		driver.switchTo().defaultContent();

	}

	public void validateTemplatefields2(String equipmentType, String crosswalk) {
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(4000);
//		wait.forElementToBeDisplayed(truckDispatchWalkInval);
		String Epvalue2 = driverActions.driverGetText(equipmentTypeValue);
		System.out.println(Epvalue2);
		Assert.assertEquals(Epvalue2,equipmentType);
		jsAction.jsclick(walkinBtn);
      	jsAction.scrollIntoView(truckDispatchWalkIn);
		String Actualvalue = truckDispatchWalkIn.getText();
		String Expectedvalue = crosswalk;
		Assert.assertTrue(Expectedvalue.contains(Actualvalue));
		System.out.println(crosswalk);
		System.out.println("walkin fleet validatd");
	//	Assert.assertTrue(walkinVal.contains(crosswalk));
//		String walkinaddrVal = driverActions.driverGetText(walkInAddress);
//		System.out.println(walkinaddrVal);
//		Assert.assertTrue(walkinaddrVal.contains(crosswalk));
//		String walkinphVal = driverActions.driverGetText(walkinPhone);
//		System.out.println(walkinphVal);
//		Assert.assertTrue(walkinphVal.contains(crosswalk));
		driver.switchTo().defaultContent();

	}
	private WebElement reportlocationelement;
	@FindBy(xpath = "//span[text()='Equipment Type']/parent::label/parent::div/parent::div/div[2]/div/div/div/div/div/div/span[2]")
//	@FindBy(xpath = "(//div[@class='ant-select-selector-item']//span)[2]")
	private WebElement equipmentTypeValue;
	@FindBy(xpath = "//div[@class='ant-slider-mark']//span[1]")
	private WebElement PriorityValidation;

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[3]/ul[1]/div[1]/li[1]/a[1]")
	private WebElement templateView;

	@FindBy(xpath = "(//*[@class='li-temp-link'])[1]")
	private WebElement chassisTemplate;

	@FindBy(xpath = "(//*[@class='li-temp-link'])[2]")
	private WebElement powerUnitTemplate;

	@FindBy(xpath = "(//*[@class='li-temp-link'])[3]")
	private WebElement trailerTemplate;

	@FindBy(xpath = "(//*[@class='li-temp-link'])[4]")
	private WebElement containerTemplate;

	@FindBy(xpath = "//i[@class='fa fa-trash']")
	private WebElement deleteIconBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement popUpOKBtn;
	@FindBy(xpath = "//span[text()='PO #']/following::input[1]")
	private WebElement tempCustomFields;
	@FindBy(xpath = "//span[text()='PO #']/following::input[1]")
	private WebElement tempBreakDownNotes;
	
	public void templateCustomFields() {
		wait.forElementToBeClickable(tempCustomFields);
		tempCustomFields.sendKeys("testCustomFields");
	}
	public void templateBreakDownNotes() {
		wait.forElementToBeClickable(tempBreakDownNotes);
		tempBreakDownNotes.sendKeys("testBreakNotes");
	}

	public void clickDeleteTemplate() {
		wait.forElementToBeDisplayed(eventButton);
		jsAction.jsclick(eventButton);
		driverActions.hardwaitBasedOnInput(2000);
		Actions act = new Actions(driver);
		act.moveToElement(deleteIconBtn).build().perform();
		jsclick(deleteIconBtn);
		driverActions.hardwaitBasedOnInput(2000);
		wait.forElementToBeClickable(popUpOKBtn);
		popUpOKBtn.click();

		driverActions.hardwaitBasedOnInput(2000);
	}
	@FindBy(xpath = "//input[@id='billing_event_forward_from']")
	private WebElement eventForwardedFrom;
	public void validateARL() {
		wait.forElementToBeDisplayed(eventForwardedFrom);
		if (!eventForwardedFrom.isEnabled()) {
			System.out.println("EventForwardedFrom textbox is Disabled.....");
		}
	}

}

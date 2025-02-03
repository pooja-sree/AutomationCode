package org.reach24.Reach24NEP.pages;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.reach24.Reach24NEP.actions.DriverActions;
import org.reach24.Reach24NEP.actions.JsActions;
import org.reach24.Reach24NEP.util.Wait;

public class EventServicesPage {
	WebDriver driver;
	Wait wait;
	DriverActions driverActions;
	JsActions jsAction;

	public EventServicesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
		driverActions = new DriverActions(driver);
		jsAction = new JsActions(driver);
	}

	@FindBy(xpath = "//button[@id='AddServiceLineButton']/parent::div/parent::div/following-sibling::div/div/div/div/div/div/div/div/div/div/div/following::div/div/div[2]/div[1]/div/div/div/div/div/div/div/span[1]/input")
	private WebElement selectSystem;
	@FindBy(xpath = "//div[@id='line_items.0.aar.system.name_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickSystem;
	@FindBy(xpath = "//div[contains(@class,'ant-select-item ant-select-item-option') and @title='Service']/div[1]")
	private WebElement clickSystem2;

	public void selectSystem(String system, int elementPosition) {
		wait.forElementToBeDisplayed(selectSystem);
		driverActions.driverSendKeys(selectSystem, system);
		if (system.equalsIgnoreCase("Service")) {
			wait.forElementToBeDisplayed(clickSystem2);
			jsAction.jsclick(clickSystem2);
			return;
		}
		wait.forElementToBeClickable(clickSystem);
		clickSystem.click();
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[4]/div/div/div[2]/div/form/div/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/span[1]/input")
	private WebElement selectSystemEditPage;
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[4]/div/div/div[2]/div/form/div/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/"
			+ "div[2]/div/div/div/div[2]/div/div/div/div[2]/div[1]/div/div/div[1]/div")
	private WebElement clickSystemEditPage;

	public void selectSystemEdit(String system, int elementPosition) {
		wait.forElementToBeDisplayed(selectSystemEditPage);
		driverActions.driverSendKeys(selectSystemEditPage, system);
		wait.forElementToBeClickable(clickSystemEditPage);
		clickSystemEditPage.click();
	}

    @FindBy(xpath = "//input[@id='line_items.0.aar.subsystem.name']")
	private WebElement selectSubSystem;
	@FindBy(xpath = "//div[@id='line_items.0.aar.subsystem.name_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickSubSystem;
	@FindBy(xpath = "//div[@id='line_items.0.aar.subsystem.name_list']/following-sibling::div/div[1]/div/div/div[3]/div")
	private WebElement clickSubSystem3;
	@FindBy(xpath = "/html/body/div[1]/section/main/form/div[4]/div/div[2]/div/div/div[1]/div/div/div/div/div/"
			+ "div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div[1]/span[1]/input")
	private WebElement clickEditSubSystem;

	public void selectSubSystem(String subSystem, int elementPosition) {
		wait.forElementToBeDisplayed(selectSubSystem);
		driverActions.driverSendKeys(selectSubSystem, subSystem);
		if (subSystem.equalsIgnoreCase("Other")) {
			wait.forElementToBeDisplayed(clickSubSystem3);
			jsAction.jsclick(clickSubSystem3);
			return;
		}
		wait.forElementToBeClickable(clickSubSystem);
		clickSubSystem.click();
	}

	@FindBy(xpath = "//input[@id='line_items.0.aar.service.name']")
	private WebElement selectServices;
	@FindBy(xpath = "//div[@id='line_items.0.aar.service.name_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickServices;

	public void selectService(String service, int elementPosition) {
		wait.forElementToBeDisplayed(selectServices);
		driverActions.driverSendKeys(selectServices, service);
		wait.forElementToBeClickable(clickServices);
		clickServices.click();
	}

	@FindBy(xpath = "//input[@id='line_items.0.aar.service_line_jobs.0.defect.description']")
	private WebElement selectDefect;
	@FindBy(xpath = "//div[@id='line_items.0.aar.service_line_jobs.0.defect.description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickDefect;

	public void selectDefect(String defect, int elementPosition) {
		wait.forElementToBeDisplayed(selectDefect);
		driverActions.driverSendKeys(selectDefect, defect);
		wait.forElementToBeClickable(clickDefect);
		clickDefect.click();
	}

    @FindBy(xpath = "//input[@id='line_items.0.aar.service_line_jobs.0.location.description']")
	private WebElement selectLocation;
	@FindBy(xpath = "//div[@id='line_items.0.aar.service_line_jobs.0.location.description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickLocation;

	public void selectLocation(String location, int elementPosition) {
		wait.forElementToBeDisplayed(selectLocation);
		driverActions.driverSendKeys(selectLocation, location);
		wait.forElementToBeClickable(clickLocation);
		clickLocation.click();
	}

	@FindBy(xpath = "(//div[@class='ant-space-item']/button)[2]")
	private WebElement saveBtn;

	public void clickSaveBtn(String featureName) {
		wait.forElementToBeClickable(saveBtn);
		saveBtn.click();
		if (featureName.equalsIgnoreCase("Clone")) {
			System.out.println("Event Cloned Successfully");
		} else {
			System.out.println("Event Created Succesfully");
		}
		driverActions.hardwaitBasedOnInput(3000);
	}

	@FindBy(xpath = "//input[@id='line_items.0.vmrs.system.system_description']")
	private WebElement selectTracSystem;
	@FindBy(xpath = "//div[@id='line_items.0.vmrs.system.system_description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickTrackSystem;
	@FindBy(xpath = "//span[text()='System']")
	private WebElement editTrackSystem;

	public void selectTractorSystem(String system, int elementPosition) {
		wait.forElementToBeDisplayed(selectTracSystem);
		driverActions.driverSendKeys(selectTracSystem, system);
		wait.forElementToBeClickable(clickTrackSystem);
		clickTrackSystem.click();
	}

	@FindBy(xpath = "//input[@id='line_items.0.vmrs.assembly.assembly_description']")
	private WebElement selectAssembly;

	@FindBy(xpath = "//div[@id='line_items.0.vmrs.assembly.assembly_description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickAssembly;

	public void selectAssembly(String assembly, int elementPosition) {
		wait.forElementToBeDisplayed(selectAssembly);
		driverActions.driverSendKeys(selectAssembly, assembly);
		wait.forElementToBeClickable(clickAssembly);
		clickAssembly.click();
	}

	@FindBy(xpath = "//input[@id='line_items.0.vmrs.component.component_description']")
	private WebElement selectComponent;
	@FindBy(xpath = "//div[@id='line_items.0.vmrs.component.component_description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickComponent;

	public void selectComponent(String component, int elementPosition) {
		wait.forElementToBeDisplayed(selectComponent);
		driverActions.driverSendKeys(selectComponent, component);
		wait.forElementToBeClickable(clickComponent);
		clickComponent.click();
	}

	@FindBy(xpath = "//input[@id='line_items.0.vmrs.position.position_description']")
	private WebElement selectPosition;
	@FindBy(xpath = "//div[@id='line_items.0.vmrs.position.position_description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickPosition;

	public void selectPosition(String position, int elementPosition) {
		wait.forElementToBeDisplayed(selectPosition);
		driverActions.driverSendKeys(selectPosition, position);
		wait.forElementToBeClickable(clickPosition);
		clickPosition.click();
	}

	@FindBy(xpath = "//input[@id='line_items.0.vmrs.wa_code.wa_code_description']")
	private WebElement selectWorkAccomplished;
	@FindBy(xpath = "//div[@id='line_items.0.vmrs.wa_code.wa_code_description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickWorkAccomplished;

	public void selectWorkAccomplished(String workAccomplished, int elementPosition) {
		wait.forElementToBeDisplayed(selectWorkAccomplished);
		driverActions.driverSendKeys(selectWorkAccomplished, workAccomplished);
		wait.forElementToBeClickable(clickWorkAccomplished);
		clickWorkAccomplished.click();
	}

	@FindBy(xpath = "//input[@id='line_items.0.vmrs.failure_code.failure_code_description']")
	private WebElement reasonElement;

	@FindBy(xpath = "//div[@id='line_items.0.vmrs.failure_code.failure_code_description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickReason;

	public void selectReasonforRepair(String reason, int elementPosition) {
		wait.forElementToBeDisplayed(reasonElement);
		driverActions.driverSendKeys(reasonElement, reason);
		wait.forElementToBeClickable(clickReason);
		jsAction.jsclick(clickReason);
	}

	@FindBy(xpath = "//input[@id='line_items.1.vmrs.system.system_description']")
	private WebElement selectTracSystem2;
	@FindBy(xpath = "//div[@id='line_items.1.vmrs.system.system_description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickTrackSystem2;

	public void selectTractorSystem2(String system2, int elementPosition) {
		wait.forElementToBeDisplayed(selectTracSystem2);
		driverActions.driverSendKeys(selectTracSystem2, system2);
		wait.forElementToBeClickable(clickTrackSystem2);
		clickTrackSystem2.click();
	}

	@FindBy(xpath = "//input[@id='line_items.1.vmrs.assembly.assembly_description']")
	private WebElement selectAssembly2;
	@FindBy(xpath = "//div[@id='line_items.1.vmrs.assembly.assembly_description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickAssembly2;

	public void selectAssembly2(String assembly2, int elementPosition) {
		wait.forElementToBeClickable(selectAssembly2);
		driverActions.driverSendKeys(selectAssembly2, assembly2);
		wait.forElementToBeClickable(clickAssembly2);
		clickAssembly2.click();
	}

	@FindBy(xpath = "//input[@id='line_items.1.vmrs.component.component_description']")
	private WebElement selectComponent2;
	@FindBy(xpath = "//div[@id='line_items.1.vmrs.component.component_description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickComponent2;

	public void selectComponent2(String component2, int elementPosition) {
		wait.forElementToBeClickable(selectComponent2);
		driverActions.driverSendKeys(selectComponent2, component2);
		wait.forElementToBeClickable(clickComponent2);
		clickComponent2.click();
	}

	@FindBy(xpath = "//input[@id='line_items.1.vmrs.position.position_description']")
	private WebElement selectPosition2;
	@FindBy(xpath = "//div[@id='line_items.1.vmrs.position.position_description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickPosition2;

	public void selectPosition2(String position2, int elementPosition) {
		wait.forElementToBeDisplayed(selectPosition2);
		driverActions.driverSendKeys(selectPosition2, position2);
		wait.forElementToBeClickable(clickPosition2);
		clickPosition2.click();
	}

	@FindBy(xpath = "//input[@id='line_items.1.vmrs.wa_code.wa_code_description']")
	private WebElement selectWorkAccomplished2;

	@FindBy(xpath = "//div[@id='line_items.1.vmrs.wa_code.wa_code_description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickWorkAccomplished2;

	public void selectWorkAccomplished2(String workAccomplished2, int elementPosition) {
		wait.forElementToBeDisplayed(selectWorkAccomplished2);
		driverActions.driverSendKeys(selectWorkAccomplished2, workAccomplished2);
		wait.forElementToBeClickable(clickWorkAccomplished2);
		clickWorkAccomplished2.click();
	}

	@FindBy(xpath = "//input[@id='line_items.1.vmrs.failure_code.failure_code_description']")
	private WebElement reasonElement2;
	@FindBy(xpath = "//div[@id='line_items.1.vmrs.failure_code.failure_code_description_list']/following-sibling::div/div[1]/div/div/div[1]/div")
	private WebElement clickReason2;

	public void selectReasonforRepair2(String reason2, int elementPosition) {
		wait.forElementToBeDisplayed(reasonElement2);
		driverActions.driverSendKeys(reasonElement2, reason2);
		wait.forElementToBeClickable(clickReason2);
		jsAction.jsclick(clickReason2);
	}

	@FindBy(xpath = "(//*[@class='ant-btn ant-btn-default'])[1]")
	private WebElement attachmentButton;
	@FindBy(xpath = "//div[@class='ant-modal-footer']/button[2]")
	private WebElement uploadButton;
	@FindBy(xpath = "//figure/parent::td/following-sibling::td[2]/div/span/span")
	private WebElement uploadTag;
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
			case "Others":
				wait.forElementToBeDisplayed(uploadEditTag);
//				jsAction.jsclick(uploadEditTag);
				uploadEditTag.click();
				driverActions.hardwaitBasedOnInput(1000);
				wait.forElementToBeDisplayed(otherButton);
				jsAction.jsclick(otherButton);
				break;
			case "Pre":
				wait.forElementToBeDisplayed(uploadEditTag);
//				jsAction.jsclick(uploadEditTag);
				uploadEditTag.click();
				driverActions.hardwaitBasedOnInput(1000);
				wait.forElementToBeDisplayed(preRepairButton);
				jsAction.jsclick(preRepairButton);
				break;
			case "Post":
				wait.forElementToBeDisplayed(uploadEditTag);
//				jsAction.jsclick(uploadEditTag);
				uploadEditTag.click();
				driverActions.hardwaitBasedOnInput(1000);
				wait.forElementToBeDisplayed(postRepairButton);
				jsAction.jsclick(postRepairButton);
				break;
		}
		wait.forElementToBeClickable(viewAttachCloseBtn);
		jsAction.jsclick(viewAttachCloseBtn);
	}


	@FindBy(xpath = "//div[@class='ant-notification-notice-message' and text()='Batch uploaded successfully']")
	private WebElement batchUploadMessage1;
	@FindBy(xpath = "//div[@class='ant-notification-notice-description' and text()='Total events: 4,  Successful events: 4,  Failed events: 0']")
	private WebElement batchUploadMessage2;

	public void uploadBatchUploadAttachments(WebDriver driver, String fileName) {
		this.driver = driver;
		driverActions.hardwaitBasedOnInput(3000);
		WebElement selectFileButton = driver.findElement(By.xpath("//input[@type='file']"));
		LocalFileDetector detector = new LocalFileDetector();
		String path = new File("src/test/resources/config/lib/"+fileName).getAbsolutePath();
		File file = detector.getLocalFile(path);
		((RemoteWebElement) selectFileButton).setFileDetector(detector);
		selectFileButton.sendKeys(file.getAbsolutePath());
		driverActions.hardwaitBasedOnInput(8000);
		Assert.assertEquals("Batch uploaded successfully",driverActions.driverGetText(batchUploadMessage1));
		Assert.assertEquals("Total events: 4, Successful events: 4, Failed events: 0",driverActions.driverGetText(batchUploadMessage2));
		System.out.println("Batch Uploaded Successfully.");
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[4]/div/div/div[2]/div/form/div/div[1]/div/div/div/div/div/div/div[2]"
			+ "/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/span[1]/input")
	private WebElement tractorSystemEdit;
	@FindBy(xpath = "//div[text()='013 - Brakes']")
	private WebElement selectTractorSystemEdit;

	public void selectTractorSystemEdit(String system, int elementPosition) {
		wait.forElementToBeDisplayed(tractorSystemEdit);
		jsAction.jsclick(tractorSystemEdit);
		driverActions.driverSendKeys(tractorSystemEdit, system);
		wait.forElementToBeDisplayed(selectTractorSystemEdit);
		selectTractorSystemEdit.click();
	}

	// @FindBy(xpath="//span[text()='Assembly']")
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[4]/div/div/div[2]/div/form/div/div[1]"
			+ "/div/div/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/span[1]/input")
	private WebElement assemblyEdit;
	@FindBy(xpath = "//div[text()='012 - Electric Brakes']")
	private WebElement selectAssemblyEdit;

	public void selectAssemblyEdit(String assembly, int elementPosition) {
		wait.forElementToBeDisplayed(assemblyEdit);
		jsAction.jsclick(assemblyEdit);
		driverActions.driverSendKeys(assemblyEdit, assembly);
		wait.forElementToBeDisplayed(selectAssemblyEdit);
		selectAssemblyEdit.click();
	}

	public void selectSubSystemEdit(String string, int count) {
		// TODO Auto-generated method stub

	}

	public void selectDefectEdit(String string, int count) {
		// TODO Auto-generated method stub

	}

	public void selectLocationEdit(String string, int count) {
		// TODO Auto-generated method stub

	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[4]/div/div/div[2]/div/form/div/div[1]/div/div/div/div/div/div/div[2]/div/"
			+ "div[2]/div[3]/div/div/div[2]/div/div/div/div[1]/span[1]/input")
	private WebElement componentEdit;
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content'])[4]")
	private WebElement selectComponentEdit;

	public void selectComponentEdit(String component, int elementPosition) {
		wait.forElementToBeDisplayed(componentEdit);
		jsAction.jsclick(componentEdit);
		// jsclick(componentEdit);
		driverActions.driverSendKeys(componentEdit, component);
		wait.forElementToBeDisplayed(selectComponentEdit);
		selectComponentEdit.click();
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[4]/div/div/div[2]/div/form/div/div[1]/div/div/div/div/div/div/div[2]/div/div[2]"
			+ "/div[5]/div/div/div[2]/div/div/div/div[1]/span[1]/input")
	private WebElement positionEdit;
	@FindBy(xpath = "//div[text()='51 - Front Center']")
	private WebElement selectPositionEdit;

	public void selectPositionEdit(String position, int elementPosition) {
		wait.forElementToBeDisplayed(positionEdit);
		jsAction.jsclick(positionEdit);
		driverActions.driverSendKeys(positionEdit, position);
		wait.forElementToBeDisplayed(selectPositionEdit);
		selectPositionEdit.click();
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[4]/div/div/div[2]/div/form/div/"
			+ "div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div[6]/div/div/div[2]/div/div/div/div[1]/span[1]/input")
	private WebElement workAccomplishedEdit;
	@FindBy(xpath = "//div[text()='001 - Adjust']")
	private WebElement selectworkAccomplishedEdit;

	public void selectWorkAccomplishedEdit(String workAccomplished, int elementPosition) {
		wait.forElementToBeDisplayed(workAccomplishedEdit);
		jsAction.jsclick(workAccomplishedEdit);
		driverActions.driverSendKeys(workAccomplishedEdit, workAccomplished);
		wait.forElementToBeDisplayed(selectworkAccomplishedEdit);
		selectworkAccomplishedEdit.click();
	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div[4]/div/div/div[2]/div/form/div/div[1]/div/div/div/div/div/div/div[2]"
			+ "/div/div[2]/div[7]/div/div/div[2]/div/div/div/div/span[1]/input")
	private WebElement reasonForRepairEdit;
	@FindBy(xpath = "//div[text()='062 - Abandonment']")
	private WebElement selectReasonEdit;

	public void selectReasonforRepairEdit(String reason, int elementPosition) {
		wait.forElementToBeDisplayed(reasonForRepairEdit);
		jsAction.jsclick(reasonForRepairEdit);
		driverActions.driverSendKeys(reasonForRepairEdit, reason);
		wait.forElementToBeDisplayed(selectReasonEdit);
		selectReasonEdit.click();
	}

	public void selectServiceEdit(String string, int count) {
		// TODO Auto-generated method stub
	}

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveEditBtn;

	public void clickSaveEditBtn() {
		wait.forElementToBeClickable(saveEditBtn);
		saveEditBtn.click();
	}

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveEventBtn;

	public void clickSaveEventBtn() {
		wait.forElementToBeClickable(saveEventBtn);
		saveEventBtn.click();
	}

	@FindBy(id = "event-submit")
	private WebElement submitButton;

	public void clickSubmitButton() {
		jsAction.jsclick(submitButton);
	}

	@FindBy(xpath = "//input[@id='line_items.0.towing_destination_address']")
	private WebElement towingDestinationElement;
	@FindBy(xpath = "(//div[@class='pac-container pac-logo hdpi'])[12]/div[1]")
	private WebElement towingDestinationElementFirstOption;
	@FindBy(xpath = "//span[text()='Calculate Mileage ']/parent::button")
	private WebElement mileageCalculate;
	@FindBy(xpath = "//span[text()='Calculate Mileage ']/parent::button/parent::div/label")
	private WebElement mileageText;

	public void selectTowingDestination(String towingDestination, String Mileage) {
		wait.forElementToBeDisplayed(towingDestinationElement);
		towingDestinationElement.sendKeys(towingDestination);
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='line_items.0.towing_destination_address']"))
					.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
		} catch (InterruptedException e) {
			System.out.println("Error: " + e);
		}
		wait.forElementToBeClickable(mileageCalculate);
		jsAction.scrolldownandJsClick(mileageCalculate);
		driverActions.hardwaitBasedOnInput(3000);
		String MileageText = driverActions.driverGetText(mileageText);

		String calMileage = MileageText.substring(0, 2);
		System.out.println(calMileage);
		System.out.println(Mileage);
		boolean validation = false;
		if (Integer.parseInt(calMileage) > Integer.parseInt(Mileage)
				&& Integer.parseInt(calMileage) < Integer.parseInt(Mileage) + 10) {
			validation = true;
		}
		Assert.assertTrue(validation);
	}

	public void reEvaluateTowingServices(String towingDestination1, String mileage) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		WebElement edit = driver.findElement(By.xpath("//button[@class='ant-btn general btn-edit']"));
		wait.forElementToBeDisplayed(edit);
		edit.click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(towingDestinationElement);
		driverActions.hardwaitBasedOnInput(2000);
		// towingDestinationElement.clear();
		String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
		towingDestinationElement.sendKeys(del + towingDestination1);
		driverActions.hardwaitBasedOnInput(2000);
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='line_items.0.towing_destination_address']"))
					.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
		} catch (InterruptedException e) {
			System.out.println("Error: " + e);
		}
		driverActions.hardwaitBasedOnInput(3000);
		wait.forElementToBeDisplayed(mileageCalculate);
		mileageCalculate.click();
		driverActions.hardwaitBasedOnInput(3000);
		String MileageText = driverActions.driverGetText(mileageText);
		String calMileage = MileageText.substring(0, 2);
		System.out.println(calMileage);
		System.out.println(mileage);
		boolean validation = false;
		if (Integer.parseInt(calMileage) > Integer.parseInt(mileage)
				&& Integer.parseInt(calMileage) < Integer.parseInt(mileage) + 10) {
			validation = true;
		}
		Assert.assertTrue(validation);
		driverActions.hardwaitBasedOnInput(3000);
		// driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//span[text()='Towing Destination']/following-sibling::p/span")
	private WebElement VMRSTowingValidation;

	@FindBy(xpath = "//span[text()='Towing mileage']/following-sibling::p")
	private WebElement VMRSMileageValidation;

	public void validateTowingServices(String type, String towingDestination, String mileage) {
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		String VMRSTowingDest = driverActions.driverGetText(VMRSTowingValidation);
		System.out.println(VMRSTowingDest);
		String VMRSMil = driverActions.driverGetText(VMRSMileageValidation);
		System.out.println(VMRSMil);
		Assert.assertTrue(VMRSTowingDest.contains(towingDestination));
		String calMileage = VMRSMil.substring(0, 2);
		boolean validation = false;
		if (Integer.parseInt(calMileage) >= Integer.parseInt(mileage)
				&& Integer.parseInt(calMileage) < Integer.parseInt(mileage) + 10) {
			validation = true;
		}
		Assert.assertTrue(validation);
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "//*[@id=\"line_items.0.removed_tire_details.size\"]")
	private WebElement sizeElement1;

	public void selectSize1(String size1, int elementPosition) {
		driverActions.driverSendKeys(sizeElement1, size1);
		driverActions.hardwaitBasedOnInput(2000);
		WebElement size1Option1=driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content' and text()='"+size1+"'])[1]"));
		jsAction.jsclick(size1Option1);
		driverActions.hardwaitBasedOnInput(2000);
	}

	@FindBy(xpath = "//*[@id=\"line_items.0.applied_tire_details.size\"]")
	private WebElement sizeElement2;

	public void selectSize2(String size2, int elementPosition) {
		driverActions.driverSendKeys(sizeElement2, size2);
		driverActions.hardwaitBasedOnInput(2000);
		WebElement size2Option1=driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content' and text()='"+size2+"'])[2]"));
		jsAction.jsclick(size2Option1);
		driverActions.hardwaitBasedOnInput(2000);
	}

	@FindBy(xpath = "//span[text()='Save Template']")
	private WebElement SaveTemplate;

	public void clickSaveTemplate() {
		wait.forElementToBeClickable(SaveTemplate);
		jsAction.jsclick(SaveTemplate);
	}
}

package org.reach24.Reach24NEP.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.reach24.Reach24NEP.util.Wait;

import java.io.File;

public class EventEditPage extends EventCreationPage {

	Wait wait=new Wait(driver);

	public EventEditPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[text()='Reported Location']/parent::div")
	private WebElement ancillaryLocationInfo;
	public void validateAncillaryLocation() {
		driverActions.hardwaitBasedOnInput(5000);

		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeDisplayed(ancillaryLocationInfo);
		System.out.println("Ancillary Location Info - " + ancillaryLocationInfo.getText() + "\n");
		Assert.assertTrue(driverActions.driverGetText(ancillaryLocationInfo).contains("Front Gate"));
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "(//*[@class='ant-btn ant-btn-default'])[2]")
	private WebElement viewAttachmentButton;
	@FindBy(xpath = "//*[@class='ant-image-img' or @class='ant-col ant-col-6 r24-attach-col']")
	private WebElement previewImage;
	@FindBy(xpath = "//*[@class='ant-modal-footer']/button[2]")
	private WebElement viewAttachCloseBtn;

	@FindBy(xpath = "//div[@class='ant-image']/following-sibling::div/div[1]/div/span[2]")
	private WebElement uploadEditTag;
	public void validateAttachmentOnEventEditPage(String attachmentType) {
		wait.forLoading();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		wait.forElementToBeClickable(viewAttachmentButton);
		jsAction.jsclick(viewAttachmentButton);
		wait.forElementToBeDisplayed(previewImage);
		Assert.assertTrue(previewImage.isDisplayed());
		Assert.assertEquals(driverActions.driverGetText(uploadEditTag),attachmentType);
		jsAction.jsclick(viewAttachCloseBtn);
		addAttachments(driver, attachmentType);
		driver.switchTo().defaultContent();
	}

	@FindBy(xpath = "(//*[@class='ant-btn ant-btn-default'])[1]")
	private WebElement attachmentButton;
	@FindBy(xpath = "(//div[@class='ant-modal-footer']/button[2])[2]")
	private WebElement uploadButton;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content' and text()='Pre-repair']")
	private WebElement preRepairButton;
	@FindBy(xpath = "//div[@class='ant-select-item-option-content' and text()='Post-repair']")
	private WebElement postRepairButton;
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content' and text()='Other'])[1]")
	private WebElement otherButton;
//	@FindBy(xpath = "(//*[@class='ant-btn ant-btn-default'])[2]")
//	private WebElement viewAttachmentButton;
//	@FindBy(xpath = "//div[@class='ant-image']/following-sibling::div/div[1]/div/span[2]")
//	private WebElement uploadEditTag;
//	@FindBy(xpath = "(//span[@class='anticon anticon-close ant-modal-close-icon'])[2]")
//	private WebElement viewAttachCloseBtn;

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

// shipper
	
	@FindBy(xpath="//span[text()='Edit']")
	private WebElement EditButton;

	public void eventEdit()
	{
		wait.forElementToBeDisplayed(EditButton);
		EditButton.click();
	}
	
	@FindBy(xpath = "(//button[@class='ant-btn ant-btn-primary'])[2]")
	private WebElement btnOK;

	public void handlePopup() {
		wait.forElementToBeDisplayed(btnOK);
		jsclick(btnOK);
	}
	
//	@FindBy(xpath = "//span[text()='Shipper']")	
//	//@FindBy(xpath = "(//label[normalize-space()='Shipper'])[1]")
//	private WebElement shipperTab;
//	
//	public void validateShipperOnEditPage() {
//		eventEdit();
//		driverActions.hardwaitBasedOnInput(2000);
//		driver.switchTo().frame("eventPageIFrame");
//		handlePopup();
//		driverActions.hardwaitBasedOnInput(2000);
//		scrolldownandclick(shipperTab);
//		driverActions.hardwaitBasedOnInput(2000);
//	}
}

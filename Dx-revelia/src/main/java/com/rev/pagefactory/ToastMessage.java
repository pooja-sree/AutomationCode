package com.rev.pagefactory;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ToastMessage {

    public ToastMessage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    WebDriver driver;

    @FindBy(xpath = "//section/ol/li/div[2]/div")
    public WebElement toastmessage;
    @FindBy(xpath = "(//p[text()='This field is required'])")
    public WebElement emailValidationmessage;
    @FindBy(xpath = "(//p[text()='This field is required'])[1]")
    public WebElement PwdValidationmessage;

    public void CheckToastMessage(String expectedValue,String message) {
        Assert.assertEquals(toastmessage.getText(),expectedValue,message);
    }
    public void EmailValidationMessage(String expectedValue,String message) {
        Assert.assertEquals(emailValidationmessage.getText(), expectedValue, message);
    }
    public void PasswordValidationMessage(String message, String expectedValue) {
        Assert.assertEquals(PwdValidationmessage.getText(), expectedValue, message);
    }
    public void CheckURL(String ExpectedLink, String text){
       String msg = driver.getCurrentUrl();
        Assert.assertEquals(ExpectedLink,msg,text);
    }
}

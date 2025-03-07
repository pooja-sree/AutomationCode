package org.Reach.iOS.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.Reach.iOS.Utils.AlertHandler;
import org.Reach.iOS.Utils.Validation;
import org.Reach.iOS.Utils.WaitFunctions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Login_Elements extends AlertHandler{

    AppiumDriver driver;
    IOSDriver iosDriver;
  public WaitFunctions waitfn ;




    public Login_Elements(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        waitfn = new WaitFunctions(driver);
    }




    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"start_button\"])[2]")
    public WebElement StartButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"reach_email\"]")
    public WebElement ReachEmail;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"login_button\"]")
    public WebElement LoginButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"reach_password\"]")
    public WebElement ReachPassword;

    @iOSXCUITFindBy(accessibility = "\uE672")
    public WebElement SettingsIcon;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uE65A\"])[2]")
    public WebElement Logout;

   @iOSXCUITFindBy(xpath =  "(//XCUIElementTypeOther[@name=\"Are you sure to logout? Yes No\"])[1]")
           public WebElement LogoutPopup;

   @iOSXCUITFindBy(accessibility = "Yes")
   public WebElement Yes;

   @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SC-ADMIN\"]")
   public WebElement AdminUser;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SC-TECHNICIAN\"]")
    public WebElement TechnicianUser;


    public void StartButton(String email,String password) {

        try{
            if(StartButton.isDisplayed()){
        StartButton.click();
            }}
        catch(NoSuchElementException e){
            LoginApp(email,password);
        }
    }


    public void LoginApp(String email, String password){
        waitfn.Clear(ReachEmail);
        waitfn.sendKeys(ReachEmail, email +Keys.RETURN);
        waitfn.Clear(ReachPassword);
        waitfn.sendKeys(ReachPassword, password +Keys.RETURN);

    }

    public void Logout(){
        waitfn.clickElement(SettingsIcon);
        waitfn.clickElement(Logout);
        waitfn.Visibility(LogoutPopup);
        Yes.click();
        System.out.println("User Had Logged Out");
    }

}

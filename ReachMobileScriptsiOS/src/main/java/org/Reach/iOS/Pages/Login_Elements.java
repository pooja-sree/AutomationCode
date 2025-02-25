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
    WaitFunctions waitfn ;
    Validation validation ;


public Login_Elements(){
    
}
    public Login_Elements(AppiumDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Appium Driver is null!");
        }
        else {
            System.out.println("Driver found");
        }
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

        this.waitfn = new WaitFunctions(driver);
        this.validation = new Validation(driver);
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

   @iOSXCUITFindBy(className = "XCUIElementTypeStaticText")
   public WebElement User;


    public void StartButton() {


        try {
            System.out.println("e"+driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            StartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//XCUIElementTypeOther[@name='start_button'])[2]")));

            if (StartButton != null && StartButton.isDisplayed()) {
                System.out.println("✅ Found Start Button");
                StartButton.click();
            } else {
                System.out.println("❌ Start Button is not visible.");
            }
        } catch (TimeoutException e) {
            System.out.println("❌ Start Button Not Found: TimeoutException");
        } catch (Exception e) {
            System.out.println("❌ Unexpected Exception: " + e.getMessage());
        }
    }


    public void LoginApp(String email, String password){
        ReachEmail.sendKeys(email+ Keys.RETURN);
//       waitfn.Visibility(ReachPassword);
        ReachPassword.sendKeys(password+Keys.RETURN);
        validation.User("SC-ADMIN","Admin is logged in");

    }

    public void Logout(){
//        waitfn.Visibility(SettingsIcon);
//        waitfn.clickElement(SettingsIcon);
//        waitfn.Visibility(Logout);
//        waitfn.clickElement(Logout);
//        waitfn.Visibility(LogoutPopup);
        Yes.click();
    }

}

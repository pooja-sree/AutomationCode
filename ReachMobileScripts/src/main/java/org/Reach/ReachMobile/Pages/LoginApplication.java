package org.Reach.ReachMobile.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class LoginApplication {

    protected AppiumDriver driver;
private WebDriverWait Wait;

    public LoginApplication(AppiumDriver driver){
        if (driver == null) {
            throw new IllegalStateException("🚨 Driver is null! Ensure driver is properly initialized before using LoginApplication.");
        }
        this.driver = driver;
        System.out.println("✅ LoginApplication received driver: " + driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this);
        this.Wait = new WebDriverWait(driver,Duration.ofSeconds(60000));
        System.out.println("✅ LoginApplication initialized with driver: " + driver);
    }


    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    @iOSXCUITFindBy()


    public WebElement NotificationAllow;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.android.permissioncontroller:id/permission_icon']//following::android.widget.LinearLayout/android.widget.Button[2]")
    public WebElement NotificationDontAllow;

    @AndroidFindBy(id = "start_button")
    public WebElement GetStarted;

    @AndroidFindBy(id = "reach_email")
    public WebElement Email;

    @AndroidFindBy(id="login_button")
    public WebElement NextButton;

    @AndroidFindBy(id = "reach_password")
    public WebElement Password;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView//following::android.widget.TextView[1]")
    public WebElement Username;

    @AndroidFindBy(accessibility = "\uE672")
    public WebElement Settingicon;

    @AndroidFindBy(accessibility = "\uE65A")
            public WebElement iconsettings;


    @AndroidFindBy(accessibility = "Yes")
    public WebElement yesbutton;

    @AndroidFindBy(accessibility = "No")
    public WebElement Nobutton;


}











package com.rev.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {

    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(name = "usernameOrNumber")
    public WebElement email;
    @FindBy(name = "password")
    public WebElement emailpwd;
    @FindBy(xpath = "//input[@name='password']//following::button[1]")
    public WebElement loginButton;
    @FindBy(xpath = "//section/ol/li/div[2]/div")
    public WebElement toastmessage;
    @FindBy(xpath = "(//p[text()='This field is required'])")
    public WebElement emailValidationmessage;
    @FindBy(xpath = "(//p[text()='This field is required'])[1]")
    public WebElement PwdValidationmessage;
    @FindBy(linkText = "Forgot Password?")
    public WebElement ForgotPassword;
    @FindBy(name = "email")
    public WebElement resetpwdemail;
    @FindBy(xpath = "//button[text()='Continue']")
    public WebElement cont;

    @FindBy(xpath = "//span[@class='w-full inline-block text-left text-xs text-neutral-500']")
    public WebElement user;

    @FindBy(xpath = "//div/h1[text()='Upcoming Visit']")
    public WebElement Patient_Dashboard;


    public String Dashboard_url = "https://app-dev.reveliadx.com/user/dashboard";
    public String Login_url = "https://app-dev.reveliadx.com/";

    public void Email(String username) {email.sendKeys(username);}

    public void Password(String password) {
        emailpwd.sendKeys(password);
    }

    public void LoginButton() {
        loginButton.click();
    }

    public void Forgotpwd() {
        ForgotPassword.click();
    }

    public void Resetpwd(String username) {
        resetpwdemail.sendKeys(username);
    }

    public void Continuebtn() {
        cont.click();
    }


}



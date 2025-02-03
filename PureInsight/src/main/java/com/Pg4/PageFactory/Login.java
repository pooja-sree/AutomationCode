package com.Pg4.PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    WebDriver driver;
    Waitfunctions Waitf;




    public Login(WebDriver driver) {

        this.driver =driver;
        PageFactory.initElements(driver,this);
        Waitf = new Waitfunctions(driver);

    }

     public String Signin_url ="https://pg3.lmapps.io/users/login";

    @FindBy(xpath = "//button//span[text()='For Healthcare Provider']")
    WebElement Practitioner_Dashboard;

    @FindBy(xpath = "//button/span[text()='For Patient']")
    WebElement Patient_Dashboard;

    @FindBy(id="sign-in-btn__loginpage")
    WebElement signin;
    public void SigninButton(){
        signin.click();
    }

    @FindBy(className="email-input")
    WebElement Patient_email;

    @FindBy(xpath = "//div[@class='text-danger text-center']/b")
    WebElement Invalidusererrormessage;

    @FindBy(xpath = "(//div[@class='text-danger mx-2 my-1 transition-all'])[1]")
    WebElement EmailToast;

    @FindBy(xpath = "(//div[@class='text-danger mx-2 my-1 transition-all'])[2]")
    WebElement PasswordToast;

    @FindBy(id = "fp-btn__loginpage")
    WebElement ResetPassword;

    @FindBy(id="email-input__forgotpassword")
    WebElement Email_for_Resetting;

    @FindBy(id = "submit-btn__forgotpassword")
    WebElement Submit_button_for_resetting;

    @FindBy(xpath = "//div[@class='go1415219401']")
    WebElement Forgot_Password_toast;


    public void Email(String Email){
        Patient_email.sendKeys(Email);

    }

    @FindBy(id="password-input__loginpage")
    WebElement Patient_Password;
    public void Password(String Password){
        Patient_Password.sendKeys(Password);
    }

    public void ResetPwd(){
        ResetPassword.click();
        Email_for_Resetting.sendKeys("poojasree.k+test@spritle.com");
        Submit_button_for_resetting.click();


    }




}

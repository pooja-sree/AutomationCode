package com.Pg4.Pg.Pages;

import com.Pg4.Pg.Util.BasePage;
import com.Pg4.Pg.Util.PropsReader;
import com.Pg4.Pg.Util.Validation;
import com.Pg4.Pg.Util.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

WebDriver driver;
PropsReader props = new PropsReader();
Wait wait;
Validation Check;

public Login(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new Wait(driver);
    Check = new Validation();
}

 public String Patient_url = "https://mypractice.pg3.lmapps.io/patient/dashboard??lng=en";

public String Practitioner_url = "https://mypractice.pg3.lmapps.io/practice/dashboard?lng=en";
    @FindBy(id="sign-in-btn__loginpage")
    WebElement signin;
    public void SigninButton(){
        signin.click();
    }

    @FindBy(id="email-input__loginpage")
    //@FindBy(xpath = "//input[@id='email-input__loginpage']")
    WebElement Email;
    public void Patient_Email(){
        wait.Visibility(Email);

        Email.sendKeys(PropsReader.Patient_Email);
    }

    @FindBy(id="password-input__loginpage")
    WebElement Password;
    public void Patient_Password(){
        wait.Visibility(Password);
        Password.sendKeys(PropsReader.Patient_Password);
    }


    public void Practitioner_Email(){
        wait.Visibility(Email);
        Email.clear();
        Email.sendKeys(PropsReader.Practitioner_Email);
    }

    @FindBy(id="password-input__loginpage")
    WebElement Practitioner_Password;
    public void Practitioner_Password(){
        wait.Visibility(Password);
        Password.sendKeys(PropsReader.Practitioner_Password);
    }
}

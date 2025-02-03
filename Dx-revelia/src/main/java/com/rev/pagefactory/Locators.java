package com.rev.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Locators {
    WebDriver driver;

    public Locators(WebDriver driver) {
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





    String Dashboard_url = "http://54.236.2.11:5173/user/dashboard";
    String Login_url = "http://54.236.2.11:5173/";
    String Patient_Dashboard_url = "http://54.236.2.11:5173/Revpractice/patient/dashboard";


//    public void Email(String username) {
//        email.sendKeys(username);
//    }
//
//    public void Password(String password) {
//        emailpwd.sendKeys(password);
//    }
//
//    public void LoginButton() {
//        loginButton.click();
//    }
//
//    public void Forgotpwd() { ForgotPassword.click();}
//    public void Continuebtn() { cont.click(); }
//    public void Resetpwd(String username) { resetpwdemail.sendKeys(username); }
//
//    public void AddNewPatientButton(){ Add_new_patient.click();}
//
//    public void PatientDetails(String Firstname, String Lastname, String DOB, String Patientemail, String PatientMob){
//        First_name.sendKeys(Firstname);
//        Last_name.sendKeys(Lastname);
//        Date_of_birth.sendKeys(DOB);
//        Gender();
//        Patient_Email.sendKeys(Patientemail);
//        Patient_Mob_number.sendKeys(PatientMob);
//        PrimaryPractitioner();
//    }
//    public void Gender(){
//        if(!Male.isSelected()) {
//            Male.click();
//        }
//    }
//    public void PrimaryPractitioner(){
//        Select Practitioner = new Select(Primary_Practitioner);
//        Practitioner.selectByVisibleText("Dr. Revpract one");
//    }
//
//    public void Add(){
//        Add_Button.click();
//    }
//    public void Cancel(){
//        Cancel_Button.click();
//    }
//    public void Pop_Cancel(){
//        popup_cancel.click();
//    }
//    public void Pop_Continue(){
//        popup_continue.click();
//    }

}


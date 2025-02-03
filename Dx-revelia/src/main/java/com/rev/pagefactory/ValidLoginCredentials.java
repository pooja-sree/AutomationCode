package com.rev.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ValidLoginCredentials extends Login {
    WebDriver driver;
    Waiting Waitfn;
    ToastMessage Toastmsg;

    public ValidLoginCredentials(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Waitfn = new Waiting(driver);
        Toastmsg = new ToastMessage(driver);

    }

    public void Validlogincredentials(String username, String password) {
        email.sendKeys(username);
        emailpwd.sendKeys(password);
        loginButton.click();
    }

    public void Login_validation() {
        Waitfn.Visibility(user);
        String role = user.getText();
        if (role.contains("Practice admin") || role.contains("Practitioner")) {
            System.out.println("Login Successful");
        }
        else if(!user.isDisplayed()){
            System.out.println("Patient Login");
        }

    }

    public void LoginValidation() {
        Waitfn.URL(Dashboard_url);
        Toastmsg.CheckURL(Dashboard_url, "Login Successful");

    }

    public void PatientDasboardValidation() {
        Waitfn.Visibility(Patient_Dashboard);
       if(Patient_Dashboard.isDisplayed()){
           System.out.println("Patient has logged in successfully");
       }


    }
}





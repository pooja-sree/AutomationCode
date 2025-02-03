package com.rev.pagefactory;


import java.util.List;

import io.cucumber.java.bs.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class AddNewPatient {
    WebDriver driver;
    Waiting waitfn;
    ToastMessage toast;

    Patient_Dashboard dashboard;

    public AddNewPatient(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitfn = new Waiting(driver);
        toast = new ToastMessage(driver);
        dashboard = new Patient_Dashboard(driver);
    }


    public String Add_New_Patient_url = "https://app-dev.reveliadx.com/user/new_patient";
    public String Dashboard_url = "https://app-dev.reveliadx.com/user/dashboard";
    public String Login_url = "https://app-dev.reveliadx.com";

    @FindBy(xpath = "//button[text()='Continue']")
    public WebElement cont;


    @FindBy(xpath = "//a[text()='Add New Patient']")
    public WebElement Add_new_patient;

    @FindBy(name = "first_name")
    public WebElement First_name;


    @FindBy(name = "last_name")
    public WebElement Last_name;


    @FindBy(xpath = "(//div[contains(@class, 'react-date-picker')])[1]")
    public WebElement Date_of_birth;

    @FindBy(name = "month")
    public WebElement Date_of_birth_Month;

    @FindBy(name = "day")
    public WebElement Date_of_birth_Day;

    @FindBy(name = "year")
    public WebElement Date_of_birth_Year;

    @FindBy(name = "email")
    public WebElement Patient_Email;

    @FindBy(name = "phone_number")
    public WebElement Patient_Mob_number;

    //@FindBy(xpath = "//button[text()='Cancel']//following::button")
    @FindBy(xpath = "//button[text()='Add']")
    public WebElement Add_Button;

    @FindBy(id = "new_patient_cancel_button")
    public WebElement Cancel_Button;

    @FindBy(id = "radix-:r9l:")
    public WebElement pop_up;

    @FindBy(xpath = "//p[text()='Click \"Continue\" to proceed.']//following::button[1]")
    public WebElement popup_cancel;

    @FindBy(xpath = "//p[text()='Click \"Continue\" to proceed.']//following::button[2]")
    public WebElement popup_continue;

    @FindBy(xpath = "//button[@value='male']")
    public WebElement Male;

    @FindBy(xpath = "//button[@value='female']")
    public WebElement Female;

    @FindBy(xpath = "//button[@value='others']")
    public WebElement other;

    @FindBy(xpath = "//label[text()='Primary Practitioner']//following::button[1]")
    public WebElement Primary_Practitioner;

    @FindBy(xpath = "//div[contains(@class,'relative flex cursor-default select-none items-center rounded-sm px-2 py-1.5 text-sm')]")
    public WebElement Practitioner;

    @FindBy(xpath = "//table[@class='caption-bottom text-sm rounded overflow-hidden w-full']")
    public WebElement Table;

    @FindBy(xpath = "//th[text()='Last name']//following::td[1]")
    public WebElement Lastname_Table;
    @FindBy(xpath = "//th[text()='First name']//following::td[2]")
    public WebElement Firstname_Table;
    @FindBy(xpath = "//section/ol/li/div[2]/div")
    public WebElement toastmessage;

    @FindBy(xpath = "(//td[@class='p-4 align-middle [&:has([role=checkbox])]:pr-0 font-medium'])[5]")
    public WebElement Forms_count;

    @FindBy(xpath = "(//td[@class='p-4 align-middle [&:has([role=checkbox])]:pr-0 font-medium'])[6]")
    public WebElement Form_Status;

    String first_name; String last_name;

    public void Continuebtn() {
        cont.click();
    }

    public void AddNewPatientButton() {
        Actions act = new Actions(driver);
        act.moveToElement(Add_new_patient).perform();
        Add_new_patient.click();
    }

    public void PracticeEmail() {
        Patient_Email.sendKeys("poojasree.k+revpraemail@spritle.com");

    }
    public void PractitionerEmail() {
        Patient_Email.sendKeys("poojasree.k+revpractemail@spritle.com");

    }

    public void PracticeAdminPatientDetails() {
        First_name.sendKeys("table");
        Last_name.sendKeys("sree");
        DOB();
        Gender();
        Patient_Email.sendKeys("poojasree.k+revpat3@spritle.com");
        Patient_Mob_number.sendKeys("+910000000000");

    }

    public void PractitionerPatientDetails() {
        First_name.sendKeys("table");
        Last_name.sendKeys("sree");
        DOB();
        Gender();
        Patient_Email.sendKeys("poojasree.k+revpat4@spritle.com");
        Patient_Mob_number.sendKeys("+910000000000");

    }

    public void Gender() {
        if (!Male.isSelected() && !Female.isSelected() && !other.isSelected()) {
            Male.click();
        }
    }

    public void PrimaryPractitioner() {
        Primary_Practitioner.click();
        Practitioner.click();
    }

    public void DOB() {
        Date_of_birth.click();
        Date_of_birth_Month.sendKeys("02");
        Date_of_birth_Day.sendKeys("15");
        Date_of_birth_Year.sendKeys("1998");
    }

    public void Add() {
        Actions actions = new Actions(driver);
        actions.moveToElement(Add_Button).perform();
        Add_Button.click();
    }

    public void Cancel_continue() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        waitfn.Visibility(Cancel_Button);
        actions.moveToElement(Cancel_Button);
        Cancel_Button.click();
        waitfn.Visibility(popup_continue);
        popup_continue.click();
        Dashoard_Validation();

    }

    public void Cancel() {
        Actions actions = new Actions(driver);
        actions.moveToElement(Cancel_Button).perform();
        waitfn.Visibility(Cancel_Button);
        Cancel_Button.click();
        actions.moveToElement(popup_cancel).perform();
        waitfn.Visibility(popup_cancel);
        popup_cancel.click();
    }

    public void Patient_Table_Validation() {
        List<WebElement> rows = Table.findElements(By.tagName("tr"));
        for(int i = 0; i<1;i++){
            WebElement row = rows.get(i);

        List<WebElement> cells = row.findElements(By.tagName("td"));


       if(cells.size() >=2){
            String Firstname_in_Table = cells.get(1).getText();
            String Lastname_in_Table = cells.get(0).getText();

            if(Firstname_in_Table.equals(first_name) && Lastname_in_Table.equals(last_name)){
                System.out.println(Firstname_in_Table);
                System.out.println(Lastname_in_Table);
            }
        }

        // Forms Validation
            dashboard.Practice_Status_Check();
        }
    }


    public void Dashoard_Validation() {
        waitfn.URL(Dashboard_url);
        toast.CheckURL(Dashboard_url, "Dashboard");
    }


    public void Validationforaddpatient(){
        waitfn.Visibility(toastmessage);
        toast.CheckToastMessage("Patient added successfully","Patient added");
        Dashoard_Validation();
    }
    public void Validationforemail(){
        waitfn.Visibility(toastmessage);
        toast.CheckToastMessage("Email already in use","Registered Email");
    }
    public void Validationforreqfield(){
        toast.EmailValidationMessage("This field is required","Required field");

    }



}

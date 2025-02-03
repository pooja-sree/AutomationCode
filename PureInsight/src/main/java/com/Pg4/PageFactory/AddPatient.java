package com.Pg4.PageFactory;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

public class AddPatient {

    WebDriver driver;
    Waitfunctions waitfn;

    Random random;
    Faker faker;

    public AddPatient(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
        waitfn = new Waitfunctions(driver);
        random = new Random();
        faker = new Faker();

    }

    public String Practitioner_url = "https://mypractice.pg3.lmapps.io/practice/dashboard?lng=en";
    public String AddPat_url ="https://mypractice.pg3.lmapps.io/practice/patient/add";

    public String PatientUrl = "https://mypractice.pg3.lmapps.io/practice/patients";

    @FindBy(id = "add-patient-btn__dashboard")
    public WebElement Add_Patient_button;

    @FindBy(id="add-patient-btn__patientlist")
    public WebElement AddPatient;

    @FindBy(id ="f-name__addpatient")
    WebElement Patient_Firstname;

    @FindBy(id="l-name__addpatient")
    WebElement Patient_Lastname;

    @FindBy(id="email-input__addpatient")
    WebElement Patient_Email;

    @FindBy(id = "dob__addpatient")
    WebElement Patient_DOB;

    @FindBy(id="gender")
    WebElement Gender;

    @FindBy(id = "select-option__Male")
    WebElement Male;

    @FindBy(id ="select-option__Female")
    WebElement Female;

    @FindBy(id = "select-option__Intersex")
    WebElement Others;


    @FindBy(id = "skincolor__addpatient")
    WebElement SkinColor;

    @FindBy(id = "select-option__Dark")
    WebElement Dark;
    @FindBy(id = "select-option__Medium")
    WebElement Medium;
    @FindBy(id = "select-option__Light")
    WebElement Light;

    @FindBy(id = "cancel-btn__addpatient")
    public WebElement Cancel_btn;

    @FindBy(id = "done-btn__addpatient")
    public WebElement Done_btn;

    @FindBy(xpath = "//span[@class='mr-5 mx-2']")
    WebElement AddPatientToast;

    @FindBy(id="radio__myself__cb")
    public WebElement Myself;

    @FindBy(id="radio__testpatient__cb")
    public WebElement TestPatient;

    @FindBy(xpath = "(//div[@class='text-danger mx-2 my-1 transition-all']/div)[1]")
    public WebElement FirstNameValidation;
    @FindBy(xpath = "(//div[@class='text-danger mx-2 my-1 transition-all']/div)[2]")
    public WebElement LastNameValidation;
    @FindBy(xpath = "(//div[@class='text-danger mx-2 my-1 transition-all']/div)[3]")
    public WebElement EmailValidation;
    @FindBy(xpath = "(//div[@class='text-danger mx-2 my-1 transition-all']/div)[4]")
    WebElement AgeValidation;

    @FindBy(xpath = "(//div[@class='text-danger mx-2 my-1 transition-all '])[1]")
    WebElement GenderValidation;

    @FindBy(xpath = "(//div[@class='text-danger mx-2 my-1 transition-all '])[2]")
    WebElement SkinColorValidation;





    public void Enter_Patient_Details(){
        waitfn.URL(Practitioner_url);
        waitfn.scrollToElement(driver,Add_Patient_button);
        waitfn.Visibility(Add_Patient_button);
        Add_Patient_button.click();
        waitfn.URL(AddPat_url);

        String Firstname = faker.name().firstName();
        String Lastname = faker.name().lastName();
        String Email = "Poojasree.k+" +Firstname.toLowerCase()+ Lastname.toLowerCase() + random.nextInt(1000)+"@spritle.com";

        Patient_Firstname.sendKeys(Firstname);
        Patient_Lastname.sendKeys(Lastname);
        Patient_Email.sendKeys(Email);
        DOB();
        SelectGender();
        SelectColor();



        waitfn.scrollToElement(driver,Done_btn);
        Done_btn.click();
        waitfn.URL(PatientUrl);}





    public void SelectGender() {
        waitfn.scrollToElement(driver,Gender);
        Gender.click();
        if (!Female.isSelected() && !Others.isSelected()) {
            Male.click();
        } else if (!Male.isSelected() && !Others.isSelected()) {
            Female.click();
        } else {
            Others.click();
        }
    }

    public void SelectColor(){
        waitfn.scrollToElement(driver,SkinColor);
        SkinColor.click();
        if(!Medium.isSelected()&&!Light.isSelected()){
            Dark.click();
        } else if (!Light.isSelected()&&!Dark.isSelected()) {
            Medium.click();
        }
        else {
            Light.click();
        }
    }

    public void DOB(){

        String DOB = "02/15/1998";


        Patient_DOB.sendKeys(DOB);
    }


    public void NewPatientToast(String message,String expectedValue){
        Assert.assertEquals(AddPatientToast.getText(),expectedValue,message);
    }
}




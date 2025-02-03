package com.Pg4.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Validation extends Login {

    WebDriver driver;
    Waitfunctions waitfn;

    Questionnaire quepf;

    AddPatient AddPatient;

    public Validation(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
        waitfn=new Waitfunctions(driver);
        quepf = new Questionnaire(driver);
        AddPatient = new AddPatient(driver);
    }

    public void Login_Validation_Practitioner(){
        waitfn.Visibility(Practitioner_Dashboard);
        String role1 = Practitioner_Dashboard.getText();
        System.out.println(role1);

        if(role1.contains("FOR HEALTHCARE PROVIDER")){

            System.out.println("Practitioner Login successful");
        }
    }

    public void Login_Validation_Patient(){
        waitfn.Visibility(Patient_Dashboard);
        String role2 = Patient_Dashboard.getText();
        if (role2.contains("Patient")) {

            System.out.println("Patient Login successful");

        }
    }

    public void InvalidUser_Validation(String expectedValue,String message){

            Assert.assertEquals(Invalidusererrormessage.getText(),expectedValue,message);
        }




        public void EmailValidationMessage(String expectedValue,String message) {
            Assert.assertEquals(EmailToast.getText(), expectedValue, message);
        }
        public void PasswordValidationMessage(String message, String expectedValue) {
            Assert.assertEquals(PasswordToast.getText(), expectedValue, message);
        }

        public void ForgotPasswordToastValidation(String message, String expectedValue){

        Assert.assertEquals(Forgot_Password_toast.getText(),expectedValue,message);
        }



        public void questionnaireValidation(String ExpectedValue, String message){
        Assert.assertEquals(quepf.Que_Validation.getText(),ExpectedValue,message);
        }

        public void MultiSymptom_Questionnaire_HeaderValidation(){

        waitfn.scrollToElement(driver,quepf.Section);

        waitfn.Visibility(quepf.Section);

        String Progresstxt = quepf.Section.getText();




        int progresspercent = Integer.parseInt(Progresstxt.replace("% complete", "").trim());

            switch(progresspercent) {
                case 11:
                    System.out.println("Sleep section is completed");
                    break;
                case 22:
                    System.out.println("Mental Health and mood section is completed");
                    break;
                case 33:
                    System.out.println("Digestive Health section is completed");
                    break;
                case 44:
                    System.out.println("Energy & Fatigue section is completed");
                    break;
                case 56:
                    System.out.println("Metabolic Health section is completed");
                    break;
                case 67:
                    System.out.println("Immune Health section is completed");
                    break;
                case 78:
                    System.out.println("Cognitive section is completed");
                    break;
                case 100:
                    System.out.println("Musculoskeletal & General section is completed");
                    break;
                case 0:
                    System.out.println("Questionnaire is yet to be answered");
                    break;
                default:
                    System.out.println("Progress percentage is: " + Progresstxt);
            }


        }
    public void Generalized_Anxiety_Disorder_Questionnaire_HeaderValidation(){
        String Sectiontxt = quepf.Anxiety_Disorder_Section.getText();
        waitfn.scrollToElement(driver,quepf.Section);
        Assert.assertEquals(Sectiontxt,"Anxiety","Anxiety Section is being answered");
    }

    public void QuestionnaireCompletion(){
        waitfn.HardWaitBasedOnInput(1000);
        waitfn.Visibility(quepf.Questionnaire_Complete_toast);
        Assert.assertEquals(quepf.Questionnaire_Complete_toast.getText(),"REPORT","Questionnaire is Completed");

    }


public void Questions(String Question,String Expected){

        Assert.assertEquals(quepf.Question.getText(),Expected,Question);

}

public void FirstNameValidation(String Expected, String Message){

        Assert.assertEquals(AddPatient.FirstNameValidation.getText(),Expected,Message);

}
    public void LastNameValidation(String Expected, String Message){

        Assert.assertEquals(AddPatient.LastNameValidation.getText(),Expected,Message);

    }

    public void EmailValidation(String Expected, String Message){

        Assert.assertEquals(AddPatient.EmailValidation.getText(),Expected,Message);

    }

    public void AgeValidation(String Expected, String Message){

        Assert.assertEquals(AddPatient.AgeValidation.getText(),Expected,Message);

    }

    public void GenderValidation(String Expected, String Message){

        Assert.assertEquals(AddPatient.GenderValidation.getText(),Expected,Message);

    }

    public void SkinColorValidation(String Expected, String Message){

        Assert.assertEquals(AddPatient.SkinColorValidation.getText(),Expected,Message);

    }






}






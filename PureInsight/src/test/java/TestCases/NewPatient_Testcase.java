package TestCases;

import com.Pg4.PageFactory.AddPatient;
import com.Pg4.PageFactory.Validation;
import com.Pg4.PageFactory.Waitfunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewPatient_Testcase extends AddPatient {

    WebDriver driver;
    Waitfunctions waitfn;
    Validation validate;

    public NewPatient_Testcase(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
        waitfn = new Waitfunctions(driver);
        validate = new Validation(driver);

    }


    public void Add_Patient_with_Blank_Fields(){
        waitfn.Visibility(AddPatient);
        waitfn.scrollToElement(driver,AddPatient);
        AddPatient.click();
        waitfn.URL(AddPat_url);
        waitfn.scrollToElement(driver,Done_btn);
        Done_btn.click();
        validate.FirstNameValidation("First Name is required","Fill in the First name");
        validate.LastNameValidation("Last Name is required","Fill in the Last name");
        validate.EmailValidation("Enter valid Email","Fill in the Email");
        validate.AgeValidation("Enter valid age", "Fill in the age");
        validate.GenderValidation("Gender is required", "Select the Gender");
        validate.SkinColorValidation("Skin Color is required", "Select Skin color");
        Cancel_btn.click();



    }
    public void Add_Patient(){
        Enter_Patient_Details();
        NewPatientToast("Patient Added Successfully","You’ve added a new patient. They’ll receive an email invitation to register.");
        System.out.println("Patient Added Successfully");
    }

    public void PractitionerAsAPatient(){
        waitfn.Visibility(AddPatient);
        waitfn.scrollToElement(driver,AddPatient);
        AddPatient.click();
        waitfn.URL(AddPat_url);
        try {
            if(Myself.isDisplayed()){
                System.out.println("Myself is displayed");
                AddMyselfAsAPatient();
            }
            else{
                System.out.println("tail");
                CancelAddingPatient();
            }

            }catch (Exception e){
            System.out.println("Fail" + e.getMessage());
        }
    }


    public void AddMyselfAsAPatient(){
                waitfn.Visibility(Myself);
                Myself.click();
                DOB();
                SelectGender();
                SelectColor();
                waitfn.scrollToElement(driver,Done_btn);
                Done_btn.click();
                waitfn.URL(PatientUrl);
                NewPatientToast("Patient Added Successfully", "You’ve added a new patient.");
                System.out.println("Practitioner has been added as a Patient Successfully");

    }
    public void CancelAddingPatient(){
        waitfn.scrollToElement(driver,Cancel_btn);
        Cancel_btn.click();
    }

    public void TestPatient(){
//        AddPatient.click();
        TestPatient.click();
        SelectColor();
        waitfn.scrollToElement(driver,Done_btn);
        Done_btn.click();
        waitfn.URL(PatientUrl);
        NewPatientToast("Patient Added Successfully","You’ve added a new patient.");
        System.out.println("Test Patient Added Successfully");
    }
}

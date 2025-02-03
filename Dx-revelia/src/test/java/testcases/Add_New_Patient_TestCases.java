package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.rev.pagefactory.AddNewPatient;
import com.rev.pagefactory.Locators;
import com.rev.pagefactory.ToastMessage;
import com.rev.pagefactory.ValidLoginCredentials;
import com.rev.pagefactory.Waiting;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Add_New_Patient_TestCases extends AddNewPatient{
	    WebDriver driver;
	    Locators Locate;
	    ToastMessage toast;
	    Waiting waitfn;
	    
	    public Add_New_Patient_TestCases(WebDriver driver) {
	    	super(driver);
			waitfn = new Waiting(driver);
			toast = new ToastMessage(driver);
			Locate = new Locators(driver);

	    }


	    public void Add_Patient_Details_For_PracticeAdmin(){
	        Patient_Dashboard();
			PracticeAdminPatientDetails();
			PrimaryPractitioner();
	    }
		public void Add_Patient_Details_For_Practitioner(){
			Patient_Dashboard();
			PractitionerPatientDetails();
		}
	    public void Patient_Dashboard() {
	        waitfn.Visibility(Add_new_patient);
	        AddNewPatientButton();

	    }
}

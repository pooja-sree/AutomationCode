package testcases;

import com.rev.pagefactory.Patient_Dashboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Patient_Dashboard_TestCases extends Patient_Dashboard {
WebDriver driver;
    public Patient_Dashboard_TestCases(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);

    }

    public void Patient_Profile_update(){
        Patient_Profile();
    }
}

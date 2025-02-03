package testcases;

import com.rev.pagefactory.Plans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Patient_Plan_Testcases extends Plans {
WebDriver driver;
    public Patient_Plan_Testcases(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public void Patient_Plans(){
        Plan();

    }
}



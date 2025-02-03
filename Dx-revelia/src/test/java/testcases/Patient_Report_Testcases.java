package testcases;

import com.rev.pagefactory.Reports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class Patient_Report_Testcases extends Reports {
WebDriver driver;
    public Patient_Report_Testcases(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public void Patient_Report() throws AWTException {
        Report();
    }
}

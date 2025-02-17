package Testcase;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.eo.Se;
import org.Reach.ReachMobile.Pages.EventCreate;
import org.Reach.ReachMobile.utils.Wait;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.List;

public class CreateEvent extends EventCreate {

    public Wait waitmethod;
    String Address= "San Francisco";
    String TD = "Pooja Truck Dispatch [TEST]";

    private String EquipmentNo;
    public CreateEvent(AppiumDriver driver){
        super(driver);
        if (driver == null) {
            throw new IllegalStateException("🚨 Driver is NULL in LoginCase! Ensure it's initialized before calling.");
        }
       this. waitmethod = new Wait(driver);

    }

    public void EventCreation(){
        waitmethod.waitAndClick(createEventButton);
        waitmethod.waitAndClick(chassis);
        waitmethod.waitAndClick(DeviceLocationAccess);
        waitmethod.waitAndClick(EventLocation);
        waitmethod.waitAndClick(EventLocation2);
        EventLocation2.sendKeys("San Francisco, CA, USA");
        waitmethod.Visibility(EventAddress);
        waitmethod.tapActions(EventAddress);
        waitmethod.Visibility(ConfirmLocation);
        waitmethod.waitAndClick(ConfirmLocation);
        EquipmentNumber();
        waitmethod.waitAndClick(SelectTD);
        waitmethod.waitAndClick(Search);
        waitmethod.Visibility(Search);
        Search.sendKeys(TD);
        waitmethod.Visibility(TruckDispatch);
        waitmethod.tapActions(TruckDispatch);
        waitmethod.Scroll();
        waitmethod.Scroll();
        waitmethod.Scroll();
        waitmethod.waitAndClick(AddFleetProfile);
        waitmethod.Scroll();
        waitmethod.waitAndSendKeys(PONumber,"90");
        waitmethod.waitAndClick(NextButton);
        waitmethod.waitAndClick(AddServiceLine);
        waitmethod.Visibility(SystemSl);
        waitmethod.waitAndClick(SystemSl);
        waitmethod.waitAndClick(Search);
        waitmethod.waitAndSendKeys(Search,"Electrical");
        waitmethod.tapActions(ElectricalSystem);
        waitmethod.Visibility(SubsystemSl);
        waitmethod.waitAndClick(SubsystemSl);
        waitmethod.waitAndClick(Search);
        waitmethod.waitAndSendKeys(Search,"7-way");
        waitmethod.tapActions(Sevenwaysubsystem);
        waitmethod.Visibility(ServiceSl);
        waitmethod.waitAndClick(ServiceSl);
        waitmethod.waitAndClick(Search);
        waitmethod.waitAndSendKeys(Search,"7-WayReceptacleBase - ReplaceW/New");
        waitmethod.tapActions(Serviceitem);
        waitmethod.Visibility(DefectSl);
        waitmethod.waitAndClick(DefectSl);
        waitmethod.waitAndClick(Search);
        waitmethod.waitAndSendKeys(Search,"Associated With Repairs");
        waitmethod.tapActions(Defectitem);
        waitmethod.Visibility(LocationSL);
        waitmethod.waitAndClick(LocationSL);
        waitmethod.waitAndClick(Search);
        waitmethod.waitAndSendKeys(Search,"Front");
        waitmethod.tapActions(LocationItem);
        waitmethod.Visibility(SlComments);
        waitmethod.waitAndClick(SlComments);
        waitmethod.waitAndSendKeys(SlComments,"Mobile event through automation");
        waitmethod.waitAndClick(NextButton);
        waitmethod.waitAndClick(Done);

    }

    public void serviceEventList(){
        waitmethod.Visibility(ServiceEventListButton);
        waitmethod.waitAndClick(ServiceEventListButton);
        waitmethod.Visibility(serviceEventSearch);
        waitmethod.waitAndClick(serviceEventSearch);
        waitmethod.waitAndSendKeys(serviceEventSearch1,EquipmentNo);
        waitmethod.Visibility(serviceEvent);
        waitmethod.waitAndClick(serviceEvent);
        System.out.println("The event ID is:"+eventID.getText());


    }


    public void EquipmentNumber(){
        waitmethod.Visibility(EquipmentNumber);
        EquipmentNo = randomAlphaNumericName(4,6);
        EquipmentNumber.sendKeys(EquipmentNo);
    }

    private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC = "0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String randomAlphaNumericName(int alphaCount, int numCount) {
        StringBuilder eqno = new StringBuilder();
        for (int i = 0; i < alphaCount; i++) {
            eqno.append(ALPHA.charAt(RANDOM.nextInt(ALPHA.length())));
        }
        for (int i = 0; i < numCount; i++) {
            eqno.append(NUMERIC.charAt(RANDOM.nextInt(NUMERIC.length())));
        }
        return eqno.toString();
    }
}

package Testcase;

import io.appium.java_client.AppiumDriver;
import org.Reach.ReachMobile.Pages.EventCreate;
import org.Reach.ReachMobile.Pages.Validation;
import org.Reach.ReachMobile.utils.Wait;
import org.openqa.selenium.*;
import java.security.SecureRandom;


public class CreateEvent extends EventCreate {

    public Wait waitmethod;
    public Validation valid;
    String Address= "San Francisco";
    String TD = "Pooja Truck Dispatch [TEST]";


    private String EquipmentNo;
    public CreateEvent(AppiumDriver driver){
        super(driver);
        if (driver == null) {
            throw new IllegalStateException("🚨 Driver is NULL in LoginCase! Ensure it's initialized before calling.");
        }
       this. waitmethod = new Wait(driver);
        this.valid = new Validation(driver);


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
        waitmethod.Visibility(MapMarker);
        if(MapMarker.isDisplayed()){
            valid.Location("San Francisco, CA, USA","Event Address");
            waitmethod.Visibility(ConfirmLocation);
            waitmethod.waitAndClick(ConfirmLocation);
        }
        EquipmentNumber();

        waitmethod.waitAndClick(SelectTD);
        waitmethod.waitAndClick(SearchTD);
        waitmethod.Visibility(SearchTD);
        SearchTD.sendKeys(TD);
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
        addServiceLineChassis();
        waitmethod.waitAndClick(NextButton);
        waitmethod.waitAndClick(Done);

        serviceEventList();

    }

    public void addServiceLineChassis(){
        waitmethod.Visibility(SystemSl);
        waitmethod.waitAndClick(SystemSl);
        waitmethod.waitAndClick(searchSystem);
        waitmethod.waitAndSendKeys(searchSystem,"Electrical");
        waitmethod.Visibility(ElectricalSystem);
        waitmethod.tapActions(ElectricalSystem);
        waitmethod.Visibility(SubsystemSl);
        waitmethod.waitAndClick(SubsystemSl);
        waitmethod.waitAndClick(searchSubSystem);
        waitmethod.waitAndSendKeys(searchSubSystem,"7-Way");
        waitmethod.tapActions(Sevenwaysubsystem);
        waitmethod.Visibility(ServiceSl);
        waitmethod.waitAndClick(ServiceSl);
        waitmethod.waitAndClick(Searchservice);
        waitmethod.waitAndSendKeys(Searchservice,"7-WayReceptacleBase - ReplaceW/New");
        waitmethod.tapActions(Serviceitem);
        waitmethod.Visibility(DefectSl);
        waitmethod.waitAndClick(DefectSl);
        waitmethod.waitAndClick(searchDefect);
        waitmethod.waitAndSendKeys(searchDefect,"Associated With Repairs");
        waitmethod.tapActions(Defectitem);
        waitmethod.Visibility(LocationSL);
        waitmethod.waitAndClick(LocationSL);
        waitmethod.waitAndClick(searchLocation);
        waitmethod.waitAndSendKeys(searchLocation,"Front");
        waitmethod.tapActions(LocationItem);
        waitmethod.Visibility(SlComments);
        waitmethod.waitAndClick(SlComments);
        waitmethod.waitAndSendKeys(SlComments,"Mobile event through automation");
    }

    public void serviceEventList(){


        waitmethod.tapActions(Eventandinspections);

        waitmethod.Visibility(eventSearchIcon);
        waitmethod.waitAndClick(eventSearchIcon);


//        waitmethod.LongPress(serviceEventSearch);
//        waitmethod.tapActions(serviceEventSearch);
//
//        serviceEventSearch.clear();

        waitmethod.tapActions(serviceEventSearch);
        serviceEventSearch.sendKeys(EquipmentNo + Keys.RETURN);

        waitmethod.waitAndClick(serviceEvent);
        System.out.println("The event ID is:"+eventID.getText());

    }


    public void EquipmentNumber(){
        waitmethod.Visibility(EquipmentNumber);
        EquipmentNo = randomAlphaNumericName(4,6);
        EquipmentNumber.sendKeys(EquipmentNo + Keys.RETURN);
//        waitmethod.Visibility(EquipmentProviderIsUnknown);

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

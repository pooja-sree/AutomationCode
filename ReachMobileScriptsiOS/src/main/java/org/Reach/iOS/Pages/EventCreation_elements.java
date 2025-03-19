package org.Reach.iOS.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.Reach.iOS.Utils.Validation;
import org.Reach.iOS.Utils.WaitFunctions;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.security.SecureRandom;
import java.time.Duration;

public class EventCreation_elements {

    AppiumDriver driver;
    WaitFunctions waitFunctions;
    Validation validation;


    public EventCreation_elements(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        waitFunctions = new WaitFunctions(driver);
        validation = new Validation(driver);

    }

    public static String  Equipmentno;

    public static  String eventID;



    String Address = "San Francisco";

    @iOSXCUITFindBy(accessibility = "Create Service Request")
    public WebElement CreateServiceRequest;

    @iOSXCUITFindBy(accessibility = "Service events and inspections")
    public WebElement ServiceEvents;

    @iOSXCUITFindBy(accessibility = "Chassis")
    public WebElement Chassis;

    @iOSXCUITFindBy(accessibility = "Trailer")
    public WebElement Trailer;

    @iOSXCUITFindBy(accessibility = "Power Unit")
    public WebElement PowerUnit;

    @iOSXCUITFindBy(accessibility = "Container")
    public WebElement Container;

    @iOSXCUITFindBy(accessibility = "Allow Once")
    public WebElement AllowOnce;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Type to search a location\"])[2]")
    public WebElement TypeToSearch;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Type to search a location\"]")
    public WebElement TypeToSearchInput;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"San Francisco, CA, USA\"])[4]")
    public WebElement SanFrancisco;

    @iOSXCUITFindBy(accessibility = "Confirm this address")
    public WebElement ConfirmThisAddress;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Enter the number\"]")
    public WebElement EquipmentNumber;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uEB1E Equipment Provider is Unknown Equipment Provider\"])[2]\n")
    public WebElement EquipmentProviderIsUnknown;

    @iOSXCUITFindBy(accessibility = "Please select")
    public WebElement SelectTruckDispatch;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Search Truck dispatch\"])[1]")
    public WebElement SearchTruckDispatch;

    String TruckDispatch = "Pooja Truck Dispatch [TES" ;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Pooja Truck Dispatch [TEST]\"])[3]")
    public WebElement PoojaTruckDispatch;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"LOADED\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    public WebElement Loaded;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"NOT LOADED\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    public WebElement Unloaded;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"IN\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    public WebElement DriverIn;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"OUT\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    public WebElement DriverOut;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Add fleet profile\"])[1]")
    public WebElement AddFleetProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"PO #\"]")
    public WebElement PONumber;

    @iOSXCUITFindBy(accessibility = "Next")
    public WebElement Next;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"+ Add\"])")
    public WebElement Add1;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"+ Add\"])[2]")
    public WebElement Add2;

    @iOSXCUITFindBy(accessibility = "System * Please Select")
    public WebElement SelectSystem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search System\"]")
    public WebElement SearchSystem;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"050 - Accessories Group\"])[2]")
    public WebElement AccessoriesGroup;

    @iOSXCUITFindBy(accessibility = "Assembly * Please Select")
    public WebElement Assembly;

    @iOSXCUITFindBy(accessibility = "Component Please Select")
    public WebElement Component;

    @iOSXCUITFindBy(accessibility = "Position Please Select")
    public WebElement Position;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"00 - Not Applicable\"])[2]")
    public WebElement NotApplicable;

    @iOSXCUITFindBy(accessibility = "Work Accomplished Please Select")
    public WebElement WorkAccomplished;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search Work Accomplished\"]")
    public WebElement SearchWorkAccomplished;

    @iOSXCUITFindBy(accessibility = "Reason for Repair Please Select")
    public WebElement ReasonForRepair;

    @iOSXCUITFindBy(accessibility = "Service Please Select")
    public WebElement Service;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"Enter your comment here\"]")
    public WebElement Comments;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search Assembly\"]")
    public WebElement SearchAssembly;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"000 - Accessories Group\"])[3]")
    public WebElement accessoriesGroup;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search Component\"]")
    public WebElement SearchComponent;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search Position\"]")
    public WebElement SearchPosition;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"017 - Add\"])[2]")
    public WebElement PowerunitWorkaccomplished;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search Reason for Repair\"]")
    public WebElement SearchReasonForRepair;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"062 - Abandonment\"])[2]")
    public WebElement Abandonment;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search Service\"]")
    public WebElement SearchService;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"ABSECUCable - ReplaceW/New\"])[2]")
    public WebElement ReplaceW;

    @iOSXCUITFindBy(accessibility = "Defect Please select")
    public WebElement Defect;

    @iOSXCUITFindBy(accessibility = "Location Please select")
    public WebElement LocationSli;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Search Defect\"])[1]")
    public WebElement SearchDefect;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Associated With Repairs\"])[2]")
    public WebElement AssociatedWithRepairs;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Search Location\"])[1]")
    public WebElement SearchLocation;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Under\"])[3]")
    public WebElement Under;

    @iOSXCUITFindBy(accessibility = "Done")
    public WebElement Done;

    @iOSXCUITFindBy(accessibility = "\uEE60")
    public WebElement searchIcon;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"  Service Events\"]")
    public WebElement typeEP;

    @iOSXCUITFindBy(accessibility = "Accept")
    public WebElement acceptButton;

    @iOSXCUITFindBy(accessibility = "Event Details")
    public WebElement eventDetailsButton;

    @iOSXCUITFindBy(accessibility = "60 min")
    public WebElement sixtyMinutesETA;

    @iOSXCUITFindBy(accessibility = "(//XCUIElementTypeOther[@name=\"Confirm\"])[1]")
    public WebElement confirm;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Confirm\"])[2]")
    public WebElement ETAEtCConfirm;

    @iOSXCUITFindBy(accessibility = "Departed")
    public WebElement departedButton;

    @iOSXCUITFindBy(accessibility = "Mark as Repaired")
    public WebElement markAsRepairedButton;

    @iOSXCUITFindBy(accessibility = "Mark as repaired")
    public WebElement markAsrepairedButton;

    @iOSXCUITFindBy(accessibility = "Decline job ")
    public WebElement declineJobButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Yes, change the status \"])[2]")
    public WebElement departedStatusYes;

    @iOSXCUITFindBy(accessibility = "Mark as Arrived")
    public WebElement markAsArrived;

    @iOSXCUITFindBy(accessibility = "I'm not currently driving")
    public WebElement notDriving;

    @iOSXCUITFindBy(accessibility = "30 min")
    public WebElement thirtyMinutesETC;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Proceed without ETC\"])[2]")
    public WebElement proceedWithoutETC;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"No, I'm not on the way \"])[2]")
    public WebElement departedStatusNO;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[11]")
    public WebElement statusCheckInEventPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Accept Event Details\"]/XCUIElementTypeOther[2]")
    public WebElement acceptEventDetails;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Assign Tech\"])[1]")
    public WebElement assignTechnician;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Search User\"])[1]")
    public WebElement searchTechnician;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search User\"]")
    public WebElement technicianInput;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"AutoTechnician T\"])[3]")
    public WebElement autoTechnician;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[20]")
    public WebElement backButton1;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[18]")
    public WebElement backButton2;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[72]")
    public WebElement selectEvent;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[1]")
    public WebElement EventID;

    public void EventId(){

        eventID =EventID.getText();
        System.out.println("Event ID is :" + eventID);

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





    public void chassisEquipment()
    {
        waitFunctions.clickElement(Chassis);
    }

    public void containerEquipment(){
        waitFunctions.clickElement(Container);
    }

    public void powerUnitEquipment(){
        waitFunctions.clickElement(PowerUnit);
    }

    public void trailerEquipment(){
        waitFunctions.clickElement(Trailer);
    }

    public void location(){
        waitFunctions.clickElement(TypeToSearch);
        waitFunctions.Clear(TypeToSearchInput);
        waitFunctions.sendKeys(TypeToSearchInput,Address);
        waitFunctions.clickElement(SanFrancisco);
        waitFunctions.clickElement(ConfirmThisAddress);
    }

    public void equipmentNumber() throws InterruptedException {
        Equipmentno =  randomAlphaNumericName(4,6);
        String EQnumber = Equipmentno.replaceAll("[^\\x00-\\x7F]", ""); // Removes non-ASCII characters


        System.out.println("Equipment number is: " + EQnumber);
        waitFunctions.Clear(EquipmentNumber);
        Thread.sleep(1000);
        waitFunctions.Clear(EquipmentNumber);
        Thread.sleep(1000);
        waitFunctions.EqnosendKeys(EquipmentNumber,EQnumber);
        Thread.sleep(500);


        Thread.sleep(2500);
//        waitFunctions.Visibility(EquipmentProviderIsUnknown);
//        validation.Equipmentnumber("Equipment Provider is Unknown Equipment Provider","Equipment Provider Validation");

    }

    public void truckDispatch(){
        waitFunctions.clickElement(SelectTruckDispatch);
        waitFunctions.sendKeys(SearchTruckDispatch,TruckDispatch+Keys.RETURN);
        waitFunctions.clickElement(PoojaTruckDispatch);
        System.out.println("Selected Truck Dispatch is: " + PoojaTruckDispatch);
    }

    public void loaded(){
        if(Loaded.isSelected())
            waitFunctions.clickElement(Unloaded);
        else {
            waitFunctions.clickElement(Loaded);
        }
    }

    public void Driver(){
        if (DriverIn.isSelected())
            waitFunctions.clickElement(DriverOut);
        else {
            waitFunctions.clickElement(DriverIn);
        }
    }

    public void addFleetProfile(){


        waitFunctions.clickElement(AddFleetProfile);
        waitFunctions.scrollUp(driver);
        waitFunctions.sendKeys(PONumber,"90");
    }

    public void Next(){
        waitFunctions.Visibility(Next);
        waitFunctions.clickElement(Next);
    }

    public void Done(){
        waitFunctions.clickElement(Done);
    }

    public void Add(){
        waitFunctions.clickElement(Add1);
    }

    public void PowerunitServiceEvent(){
        waitFunctions.clickElement(CreateServiceRequest);
        powerUnitEquipment();
//       waitFunctions.clickElement(AllowOnce);
        location();
        try {
            equipmentNumber();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        truckDispatch();
        waitFunctions.scrollUp(driver);
        loaded();
        Driver();
        waitFunctions.scrollUp(driver);
        addFleetProfile();
        Next();
        Add();
        powerunitService();
        Next();
        Done();
    }

    public void assignTechnician(){
        waitFunctions.clickElement(acceptEventDetails);
        waitFunctions.clickElement(assignTechnician);
        waitFunctions.clickElement(searchTechnician);
        waitFunctions.sendKeys(technicianInput,"Auto" + Keys.RETURN);
        waitFunctions.clickElement(autoTechnician);
        EventId();
        String backButton = "(//XCUIElementTypeOther[@name=\""+eventID+" Service Event Void \uDB80\uDF66\"])[1]/XCUIElementTypeOther[2]";
        WebElement backButton1 = driver.findElement(By.xpath(backButton));
        waitFunctions.clickElement(backButton1);
        waitFunctions.clickElement(backButton2);


    }

    public void powerunitService(){
        waitFunctions.clickElement(SelectSystem);
        waitFunctions.sendKeys(SearchSystem,"050"+Keys.RETURN);
        waitFunctions.clickElement(AccessoriesGroup);
        waitFunctions.clickElement(Assembly);
        waitFunctions.sendKeys(SearchAssembly,"000"+Keys.RETURN);
        waitFunctions.clickElement(accessoriesGroup);
        waitFunctions.clickElement(Component);
        waitFunctions.sendKeys(SearchComponent,"000"+Keys.RETURN);
        waitFunctions.clickElement(accessoriesGroup);
        waitFunctions.clickElement(Position);
        waitFunctions.sendKeys(SearchPosition,"00"+Keys.RETURN);
        waitFunctions.clickElement(NotApplicable);
        waitFunctions.clickElement(WorkAccomplished);
        waitFunctions.sendKeys(SearchWorkAccomplished,"017"+Keys.RETURN);
        waitFunctions.clickElement(PowerunitWorkaccomplished);
        waitFunctions.clickElement(ReasonForRepair);
        waitFunctions.sendKeys(SearchReasonForRepair,"062"+Keys.RETURN);
        waitFunctions.clickElement(Abandonment);
        waitFunctions.sendKeys(Comments,"Powerunit event through automation");
    }

    public void searchEventAndInspection(){

        waitFunctions.clickElement(ServiceEvents);
        waitFunctions.clickElement(searchIcon);
//        String TrimmedEquipmentno = Equipmentno.substring(0,Equipmentno.length()-1);
//
//        waitFunctions.sendKeys(typeEP,TrimmedEquipmentno+Keys.RETURN);
        waitFunctions.sendKeys(typeEP,"KGFX60669"+ Keys.RETURN);

        waitFunctions.clickElement(selectEvent);
    }

    public void EventWithETAandETC(){
        waitFunctions.Visibility(statusCheckInEventPage);
        validation.EventStatus(statusCheckInEventPage,"Tech Assigned","Event has been assigned to a Technician");
        waitFunctions.clickElement(acceptButton);
        waitFunctions.clickElement(sixtyMinutesETA);
        waitFunctions.clickElement(ETAEtCConfirm);
        validation.EventStatus(statusCheckInEventPage,"Tech Accepted","Event is Accepted by Technician");
        waitFunctions.scrollUp(driver);
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(departedButton);
        waitFunctions.clickElement(departedStatusYes);
        waitFunctions.clickElement(markAsArrived);
        waitFunctions.clickElement(thirtyMinutesETC);
        waitFunctions.clickElement(ETAEtCConfirm);
        validation.EventStatus(statusCheckInEventPage,"Tech Arrived","Technician has arrived to event location");
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(markAsRepairedButton);
        waitFunctions.clickElement(markAsrepairedButton);
        validation.EventStatus(statusCheckInEventPage,"Tech Repaired","Event has been Repaired");

    }



}

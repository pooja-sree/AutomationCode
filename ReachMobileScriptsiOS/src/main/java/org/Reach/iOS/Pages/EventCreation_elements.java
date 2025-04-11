package org.Reach.iOS.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
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
import java.util.List;

public class EventCreation_elements {

    public AppiumDriver driver;
   public WaitFunctions waitFunctions;
    Validation validation;
    IOSDriver iosDriver;


    public EventCreation_elements(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        waitFunctions = new WaitFunctions(driver);
        validation = new Validation(driver);


    }

    public static String  Equipmentno;

    public static  String eventID;



    static String Address = "San Francisco";

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

    @iOSXCUITFindBy(accessibility = "Equipment #  * Enter the number")
    public WebElement EQ1;
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
    public WebElement SelectAssembly;

    @iOSXCUITFindBy(accessibility = "Component Please Select")
    public WebElement SelectComponent;

    @iOSXCUITFindBy(accessibility = "Position Please Select")
    public WebElement SelectPosition;

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
    public WebElement powerunitWorkAccomplished;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search Reason for Repair\"]")
    public WebElement SearchReasonForRepair;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"062 - Abandonment\"])[2]")
    public WebElement Abandonment;


    @iOSXCUITFindBy(accessibility = "Service Please Select")
    public WebElement SelectService;
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

    @iOSXCUITFindBy(accessibility = "Reject")
    public WebElement rejectButton;

    @iOSXCUITFindBy(accessibility = "Event Details")
    public WebElement eventDetailsButton;

    @iOSXCUITFindBy(accessibility = "Forwarded to Another Location")
    public WebElement RejectReason;
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

    @iOSXCUITFindBy(accessibility = "Arrived")
    public WebElement Arrived;

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

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Complete \"])[2]")
    public WebElement EventComplete;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[10]")
    public WebElement assignedStatusCheckInEventPage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[11]")
    public WebElement eventStatus;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Accept Event Details\"]/XCUIElementTypeOther[2]")
    public WebElement acceptEventDetails;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Reject Event Details\"]/XCUIElementTypeOther[2]")
    public WebElement rejectEventDetails;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Assign Tech\"])[1]")
    public WebElement assignTechnician;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Search User\"])[1]")
    public WebElement searchTechnician;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search User\"]")
    public WebElement technicianInput;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"AutoTechnician T\"])[3]")
    public WebElement autoTechnician;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"tech3 test\"])[2]")
    public WebElement Technician2;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[20]")

    public WebElement backButton1;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[18]")
    public WebElement backButton2;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)[72]")
    public WebElement selectEvent;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[1]")
    public WebElement EventID;

    @iOSXCUITFindBy(accessibility = "Tech Accept")
    public WebElement TechAccept;

    @iOSXCUITFindBy(accessibility = "Decline job ")
    public WebElement DeclineJob;

    @iOSXCUITFindBy(accessibility = "Complete")
    public WebElement Complete;

    @iOSXCUITFindBy(accessibility = "Submit")
    public WebElement Submit;

    @iOSXCUITFindBy(accessibility = "Busy with other events")
    public WebElement DeclineReason;

    @iOSXCUITFindBy(accessibility = "Pre-repair")
    public WebElement preRepair;

    @iOSXCUITFindBy(accessibility = "Post-repair")
    public WebElement postRepair;

    @iOSXCUITFindBy(accessibility = "Other")
    public WebElement otherAttachment;

    @iOSXCUITFindBy(accessibility = "Photo or Video from gallery")
    public WebElement ImageFromGallery;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,\"PXGGridLayout-Info\")]")
    public WebElement Images;

    @iOSXCUITFindBy(accessibility = "Add")
    public WebElement AddImage;

    @iOSXCUITFindBy(accessibility = "Cancel")
    public WebElement CancelImage;

    @iOSXCUITFindBy(accessibility = "Uncategorized")
    public WebElement Uncategorized;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Brakes\"])[2]")
    public WebElement Brakes;

    @iOSXCUITFindBy(accessibility = "SubSystem Please Select")
    public WebElement SelectSubsystem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search SubSystem\"]")
    public  WebElement SearchSubSystem;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"ABS\"])[3]")
    public WebElement ABS;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"ABSECUCable - ReplaceW/New\"])[2]")
    public WebElement ABSECUCable;

    @iOSXCUITFindBy(accessibility = "Location Please select")
    public WebElement Location;






//    public static String dxpath= "((//XCUIElementTypeOther[contains(@name,'"+eventID+" Service Event')])[1]//XCUIElementTypeOther[2])[3]";



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
        Thread.sleep(1000);
        waitFunctions.EqnosendKeys(EquipmentNumber,EQnumber);
        Thread.sleep(2000);
        Thread.sleep(500);


        Thread.sleep(2500);
//        waitFunctions.Visibility(EquipmentProviderIsUnknown);
//        validation.Equipmentnumber("Equipment Provider is Unknown Equipment Provider","Equipment Provider Validation");

    }
    public void chassisEquipmentNumber(){
        Equipmentno =  randomAlphaNumericName(4,6);
        waitFunctions.tapActions(EQ1);
        waitFunctions.EqnosendKeys(EQ1,Equipmentno+Keys.RETURN);
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



    public void AcceptEventDetails(){
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(acceptEventDetails);
    }

    public void RejectEventDetails(){
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(rejectEventDetails);
    }

    public void assignTechnician1() {
        waitFunctions.clickElement(assignTechnician);
        waitFunctions.clickElement(searchTechnician);
        waitFunctions.sendKeys(technicianInput, "Aut" + Keys.RETURN);
        waitFunctions.clickElement(autoTechnician);
//        try{
//            validation.EventStatus(assignedStatusCheckInEventPage,"  Tech Assigned","Event has been assigned to a Technician");
//        } catch (Exception e) {
//            validation.EventStatus(eventStatus,"  Tech Assigned","Event has been assigned to a Technician");
//
//        }

    }
    public void assignTechnician2() {
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(assignTechnician);
        waitFunctions.clickElement(searchTechnician);
        waitFunctions.sendKeys(technicianInput, "tech3" + Keys.RETURN);
        waitFunctions.clickElement(Technician2);
//        validation.EventStatus(eventStatus,"  Tech Assigned","Event has been assigned to a Technician");

    }
    public void BackScreen1(){
//        String dxpath= "((//XCUIElementTypeOther[contains(@name,'AA194822 Service Event')])[1]//XCUIElementTypeOther[2])[3]";

        String dxpath= "((//XCUIElementTypeOther[contains(@name,'"+eventID+" Service Event')])[1]//XCUIElementTypeOther[2])[3]";
        WebElement bb1 = driver.findElement(By.xpath(dxpath));
        waitFunctions.clickElement(bb1);
        waitFunctions.clickElement(backButton2);
    }

    public void BackScreen2(){
        waitFunctions.clickElement(backButton2);
    }


    public void System(String System){
        waitFunctions.clickElement(SelectSystem);
        waitFunctions.sendKeys(SearchSystem,System+Keys.RETURN);
        waitFunctions.clickElement(AccessoriesGroup);
    }

    public void chassisSystem(String chassisSystem){
        waitFunctions.clickElement(SelectSystem);
        waitFunctions.sendKeys(SearchSystem,chassisSystem+Keys.RETURN);
        waitFunctions.clickElement(Brakes);
    }

    public void subSystem(String Subsystem){
        waitFunctions.clickElement(SelectSubsystem);
        waitFunctions.sendKeys(SearchSubSystem,Subsystem+Keys.RETURN);
        waitFunctions.clickElement(ABS);
    }

    public void Service(String Service){
        waitFunctions.clickElement(SelectService);
        waitFunctions.sendKeys(SearchService,Service+Keys.RETURN);
        waitFunctions.clickElement(ABSECUCable);
    }

    public void Defect(String defect){
        waitFunctions.clickElement(Defect);
        waitFunctions.sendKeys(SearchDefect,defect+Keys.RETURN);
        waitFunctions.clickElement(AssociatedWithRepairs);
    }

    public void Location(String location){
        waitFunctions.clickElement(Location);
        waitFunctions.sendKeys(SearchLocation,location+Keys.RETURN);
        waitFunctions.clickElement(Under);
    }


    public void Assembly(String assembly){
        waitFunctions.clickElement(SelectAssembly);
        waitFunctions.sendKeys(SearchAssembly,assembly+Keys.RETURN);
        waitFunctions.clickElement(accessoriesGroup);
    }

    public void Component(String component){
        waitFunctions.clickElement(SelectComponent);
        waitFunctions.sendKeys(SearchComponent,component+Keys.RETURN);
        waitFunctions.clickElement(accessoriesGroup);
    }

    public void Position(String position){
        waitFunctions.clickElement(SelectPosition);
        waitFunctions.sendKeys(SearchPosition,position+Keys.RETURN);
        waitFunctions.clickElement(NotApplicable);
    }

    public void WorkAccomplished(String Accomplished){
        waitFunctions.clickElement(WorkAccomplished);
        waitFunctions.sendKeys(SearchWorkAccomplished,Accomplished+Keys.RETURN);
        waitFunctions.clickElement(powerunitWorkAccomplished);
    }

    public void reasonForRepair(String reasonForRepair){
        waitFunctions.clickElement(ReasonForRepair);
        waitFunctions.sendKeys(SearchReasonForRepair,reasonForRepair+Keys.RETURN);
        waitFunctions.clickElement(Abandonment);
    }

    public void Comments(String comment){

        waitFunctions.sendKeys(Comments,comment);
    }

    public void searchEventAndInspection(){

        waitFunctions.clickElement(ServiceEvents);
        waitFunctions.clickElement(searchIcon);
        System.out.println(Equipmentno);
        String TrimmedEquipmentno = Equipmentno.substring(0,Equipmentno.length()-1);
        waitFunctions.sendKeys(typeEP,TrimmedEquipmentno+Keys.RETURN);
//        waitFunctions.sendKeys(typeEP,"EDGQ77033    "+ Keys.RETURN);


        waitFunctions.clickElement(selectEvent);
    }

    public void ETA(){
        waitFunctions.clickElement(sixtyMinutesETA);
        waitFunctions.clickElement(ETAEtCConfirm);
    }
    public void ETC(){
        waitFunctions.clickElement(sixtyMinutesETA);
        waitFunctions.clickElement(ETAEtCConfirm);
    }
    public void noETC(){
        waitFunctions.clickElement(proceedWithoutETC);
    }


    public void Accept(){
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(acceptButton);
    }

    public void Reject(){
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(rejectButton);
        waitFunctions.clickElement(RejectReason);
        waitFunctions.clickElement(Submit);
        waitFunctions.clickElement(backButton2);

    }

    public void Repaired(){
        waitFunctions.scrollUp(driver);
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(markAsRepairedButton);
    }

    public void Complete(){
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(EventComplete);
        waitFunctions.clickElement(Complete);
        validation.EventStatus(assignedStatusCheckInEventPage,"Completed","Event has been completed");
    }

    public void TechnicianAccept(){
        waitFunctions.scrollUp(driver);
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(TechAccept);
        waitFunctions.Visibility(eventStatus);
        validation.EventStatus(eventStatus,"  Tech Accepted","Event is Accepted by Technician");

    }
    public void TechnicianDepartedYes(){
        waitFunctions.scrollUp(driver);
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(departedButton);
        waitFunctions.clickElement(departedStatusYes);
    }

    public void TechnicianDepartedNo(){
        waitFunctions.scrollUp(driver);
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(departedButton);
        waitFunctions.clickElement(departedStatusNO);
    }

    public void TechnicianRepaired(){
        waitFunctions.scrollUp(driver);
        waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(markAsRepairedButton);
        waitFunctions.clickElement(markAsrepairedButton);
        validation.EventStatus(eventStatus,"  Tech Repaired","Event has been Repaired");

    }

    public void TechnicianArrived(){
        waitFunctions.scrollUp(driver);waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(markAsArrived);
//        validation.EventStatus(eventStatus,"  Tech Arrived","Technician has arrived to event location");

    }

    public void TechnicianArrival(){
        waitFunctions.scrollUp(driver);waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(Arrived);
//        validation.EventStatus(eventStatus,"  Tech Arrived","Technician has arrived to event location");
    }

    public void TechnicianNotDriving(){
        waitFunctions.scrollUp(driver);waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(notDriving);
    }

    public void TechnicianDeclined(){
        waitFunctions.scrollUp(driver);waitFunctions.scrollUp(driver);
        waitFunctions.clickElement(DeclineJob);
        waitFunctions.clickElement(DeclineReason);
        waitFunctions.clickElement(Submit);
        validation.EventStatus(eventStatus,"  Tech Declined","Technician has declined the event");

    }

    public void Attachments(){
        waitFunctions.clickElement(ImageFromGallery);
        waitFunctions.clickElement(Images);
        waitFunctions.clickElement(AddImage);

    }

    public void MultipleAttachments(){
        waitFunctions.clickElement(ImageFromGallery);
        List<WebElement> Image = driver.findElements(By.xpath("//XCUIElementTypeImage[contains(@name,\"PXGGridLayout-Info\")]"));
        waitFunctions.Visibility(Images);
        System.out.println(Image.size());
        for (WebElement clickImage : Image){
            System.out.println("👉 Trying to click an image: " + clickImage);
            waitFunctions.clickElement(clickImage);
        }
        waitFunctions.clickElement(AddImage);
        waitFunctions.Visibility(Next);

    }

    public void preAttachments(){
        waitFunctions.Visibility(Uncategorized);
        waitFunctions.clickElement(Uncategorized);
        waitFunctions.clickElement(preRepair);
    }

    public void postAttachments(){
        waitFunctions.Visibility(Uncategorized);
        waitFunctions.clickElement(Uncategorized);
        waitFunctions.clickElement(postRepair);
    }

    public void otherAttachments(){
        waitFunctions.Visibility(Uncategorized);
        waitFunctions.clickElement(Uncategorized);
        waitFunctions.clickElement(otherAttachment);
    }
}

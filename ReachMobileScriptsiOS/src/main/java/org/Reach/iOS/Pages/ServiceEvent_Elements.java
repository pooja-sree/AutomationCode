package org.Reach.iOS.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.Reach.iOS.Utils.Validation;
import org.Reach.iOS.Utils.WaitFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.security.SecureRandom;
import java.time.Duration;

public class ServiceEvent_Elements {
    AppiumDriver driver;
    WaitFunctions waitfn;
    Validation validation;

    public ServiceEvent_Elements(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        waitfn = new WaitFunctions(driver);
        validation = new Validation(driver);
    }

    String Address = "San Francisco, CA, USA";

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

    @iOSXCUITFindBy(accessibility = "//XCUIElementTypeTextField[@value=\"Enter the number\"]")
    public WebElement EquipmentNumber;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uEB1E Equipment Provider is Unknown Equipment Provider\"])[2]\n")
    public WebElement EquipmentProviderIsUnknown;

    @iOSXCUITFindBy(accessibility = "Please select")
    public WebElement SelectTruckDispatch;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Search Truck dispatch\"])[1]")
    public WebElement SearchTruckDispatch;

    String TruckDispatch = "Pooja Truck Dispatch [TEST]" ;

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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PO #\"]")
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

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Brakes\"])[2]")
    public WebElement Brakes;

    @iOSXCUITFindBy(accessibility = "SubSystem Please Select")
    public WebElement SubSystem;

    @iOSXCUITFindBy(accessibility = "Service Please Select")
    public WebElement Service;

    @iOSXCUITFindBy(accessibility = "Comments")
    public WebElement Comments;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Search SubSystem\"]")
    public WebElement SearchSubSystem;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"ABS\"])[3]")
    public WebElement ABS;

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
        waitfn.clickElement(Chassis);
    }

    public void containerEquipment(){
        waitfn.clickElement(Container);
    }

    public void powerUnitEquipment(){
        waitfn.clickElement(PowerUnit);
    }

    public void trailerEquipment(){
        waitfn.clickElement(Trailer);
    }

    public void location(){
        waitfn.clickElement(TypeToSearch);
        waitfn.sendKeys(TypeToSearchInput,Address);
        waitfn.clickElement(SanFrancisco);
        waitfn.clickElement(ConfirmThisAddress);
    }

    public void equipmentNumber(){
       String Equipmentno =  randomAlphaNumericName(4,6);
       waitfn.sendKeys(EquipmentNumber,Equipmentno);
       System.out.println("Equipment number is: " + Equipmentno);
       waitfn.Visibility(EquipmentProviderIsUnknown);
       validation.Equipmentnumber("Equipment Provider is Unknown Equipment Provider","Equipment Provider Validation");

    }

    public void truckDispatch(){
        waitfn.clickElement(SelectTruckDispatch);
        waitfn.sendKeys(SearchTruckDispatch,TruckDispatch);
        waitfn.clickElement(PoojaTruckDispatch);
        System.out.println("Selected Truck Dispatch is: " + PoojaTruckDispatch);
    }

    public void loaded(){
        if(Loaded.isSelected())
            waitfn.clickElement(Unloaded);
        else {
            waitfn.clickElement(Loaded);
        }
    }

    public void Driver(){
        if (DriverIn.isSelected())
            waitfn.clickElement(DriverOut);
        else {
            waitfn.clickElement(DriverIn);
        }
    }

    public void addFleetProfile(){

        waitfn.scrollUp(driver);
        waitfn.clickElement(AddFleetProfile);
        waitfn.sendKeys(PONumber,"90");
    }

    public void Next(){
        waitfn.clickElement(Next);
    }

    public void Done(){
        waitfn.clickElement(Done);
    }

    public void Add(){
        waitfn.clickElement(Add1);
    }

    public void chassisServiceEvent(){
        waitfn.clickElement(CreateServiceRequest);
        chassisEquipment();
        waitfn.clickElement(AllowOnce);
        location();
        equipmentNumber();
        truckDispatch();
        loaded();
        Driver();
        addFleetProfile();
        Next();
        chassisService();
        Next();
        Done();
    }

    public void chassisService(){
       waitfn.clickElement(SelectSystem);
       waitfn.sendKeys(SearchSystem,"Brakes");
       waitfn.clickElement(Brakes);
       waitfn.clickElement(SubSystem);
       waitfn.sendKeys(SearchSubSystem,"ABS");
       waitfn.clickElement(ABS);
       waitfn.clickElement(Service);
       waitfn.sendKeys(SearchService,"ABSECUCable - ReplaceW/New");
       waitfn.clickElement(ReplaceW);
       waitfn.clickElement(Defect);
       waitfn.sendKeys(SearchDefect,"Associated With Repairs");
       waitfn.clickElement(AssociatedWithRepairs);
       waitfn.clickElement(LocationSli);
       waitfn.sendKeys(SearchLocation,"Under");
       waitfn.clickElement(Under);
       waitfn.sendKeys(Comments,"Chassis event through automation");
    }





}


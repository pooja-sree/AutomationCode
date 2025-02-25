package org.Reach.ReachMobile.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class EventCreate {
    protected AppiumDriver driver;

    public EventCreate(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(accessibility = "Create Service Request")
    public WebElement createEventButton;

    @AndroidFindBy(accessibility = "Chassis")
    public WebElement chassis;

    @AndroidFindBy(accessibility = "Trailer")
    public WebElement trailer;
    @AndroidFindBy(accessibility = "Power Unit")
    public WebElement powerUnit;

    @AndroidFindBy(accessibility = "Container")
    public WebElement container;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement DeviceLocationAccess;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Type to search a location']")
    public WebElement EventLocation;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Type to search a location']")
    public WebElement EventLocation2;

    @AndroidFindBy(accessibility = "San Francisco, CA, USA")
    public WebElement EventAddress;

    @AndroidFindBy(accessibility = "Map Marker")
    public WebElement MapMarker;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    public WebElement selectedEventLocation;
    @AndroidFindBy(accessibility = "Confirm this address")
    public WebElement ConfirmLocation;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter the number']")
    public WebElement EquipmentNumber;

    @AndroidFindBy(accessibility = "Please select")
    public WebElement SelectTD;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search Truck dispatch\"]")
    public WebElement SearchTD;

    @AndroidFindBy(accessibility = "Pooja Truck Dispatch [TEST]")
    public WebElement TruckDispatch;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Equipment Provider is Unknown Equipment Provider\")]")
    public WebElement EquipmentProviderIsUnknown;

    @AndroidFindBy(accessibility = "Next")
    public WebElement NextButton;

    @AndroidFindBy(accessibility = "Add fleet profile")
    public WebElement AddFleetProfile;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"PO #\"]")
    public WebElement PONumber;

    @AndroidFindBy(accessibility = "+ Add")
    public WebElement AddServiceLine;

    @AndroidFindBy(accessibility = "System, *, Please Select")
    public WebElement SystemSl;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search System\"]")
    public WebElement searchSystem;

    @AndroidFindBy(accessibility = "Electrical")
    public WebElement ElectricalSystem;


    @AndroidFindBy(accessibility = "SubSystem, Please Select")
    public WebElement SubsystemSl;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search SubSystem\"]")
    public WebElement searchSubSystem;

    @AndroidFindBy(accessibility = "7-Way")
    public WebElement Sevenwaysubsystem;


    @AndroidFindBy(accessibility = "Service, Please Select")
    public WebElement ServiceSl;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search Service\"]")
    public WebElement Searchservice;

    @AndroidFindBy(accessibility = "7-WayReceptacleBase - ReplaceW/New")
    public WebElement Serviceitem;
    @AndroidFindBy(accessibility = "Defect, Please select")
    public WebElement DefectSl;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search Defect\"]")
    public WebElement searchDefect;

    @AndroidFindBy(accessibility = "Associated With Repairs")
    public WebElement Defectitem;

    @AndroidFindBy(accessibility = "Location, Please select")
    public WebElement LocationSL;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search Location\"]")
    public WebElement searchLocation;

    @AndroidFindBy(accessibility = "Front")
    public WebElement LocationItem;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Enter your comment here\"]")
    public WebElement SlComments;

    @AndroidFindBy(accessibility = "Photo or Video from gallery")
    public WebElement ImageFromGallery;

    @AndroidFindBy(accessibility = "Open Camera")
    public WebElement OpenCamera;

    @AndroidFindBy(accessibility = "Done")
    public WebElement Done;




    //@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Service events')]")
    @AndroidFindBy(accessibility = "Service events and inspections")
    public WebElement Eventandinspections;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]")
    public WebElement serviceEvent;

    @AndroidFindBy(accessibility = "\uEE60")
    public WebElement eventSearchIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Service Events')]")
//    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")

//    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"  Services and Inspections\"]")
    public WebElement serviceEventSearch;


    @AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
    public WebElement eventID;

    @AndroidFindBy(accessibility = "Accept")
    public WebElement eventAccept;
    @AndroidFindBy(accessibility = "Reject")
    public WebElement eventReject;
    @AndroidFindBy(accessibility = "Assign Tech")
    public WebElement assignTechnician;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search User']")
    public WebElement searchUser;

    @AndroidFindBy(accessibility = "AutoTechnician T")
    public WebElement Technician;

}

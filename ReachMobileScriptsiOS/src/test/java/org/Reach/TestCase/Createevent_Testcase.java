package org.Reach.TestCase;

import io.appium.java_client.AppiumDriver;
import org.Reach.iOS.Pages.EventCreation_elements;

public class Createevent_Testcase extends EventCreation_elements {

    public Createevent_Testcase(AppiumDriver driver) {
        super(driver);


    }


    public void powerunitEventCreation() {

        PowerunitServiceEvent();
    }

    public void searchEventID(){
        EventId();
    }
    public void searchEvent(){
        searchEventAndInspection();
    }



    public void assignEvent(){
        assignTechnician();
    }

    public void eventFlowWithETAAndETC(){
        EventWithETAandETC();
    }

}

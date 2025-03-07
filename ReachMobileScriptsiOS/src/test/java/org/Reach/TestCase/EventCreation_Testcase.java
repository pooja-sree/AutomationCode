package org.Reach.TestCase;

import io.appium.java_client.AppiumDriver;
import org.Reach.iOS.Pages.ServiceEvent_Elements;

public class EventCreation_Testcase extends ServiceEvent_Elements {



    public EventCreation_Testcase(AppiumDriver driver) {

        super(driver);
    }

    public void EventCreation() {
        clickCreateServiceRequest();
    }
}

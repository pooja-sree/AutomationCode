package org.Reach.TestCase;

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.eo.Se;
import org.Reach.iOS.Pages.EventCreation_elements;

import java.util.List;
import java.util.Map;

public class Createevent_Testcase extends EventCreation_elements {


    public Createevent_Testcase(AppiumDriver driver) {
        super(driver);

    }




    public void EventCreation(String Featurename, DataTable EventData) throws InterruptedException {

        List<Map<String,String>> list = EventData.asMaps(String.class,String.class);
        String EquipmentType = list.getFirst().get("EquipmentType");
        System.out.println("Started creating event");
        if(Featurename.equals("EventCreation")){
            waitFunctions.clickElement(CreateServiceRequest);
            System.out.println("Starting to select Equipment");
            switch (EquipmentType) {
                case "PowerUnit":
                    powerUnitEquipment();
                    break;

                case "Chassis":
                    chassisEquipment();
                    break;

                case "Container":
                    containerEquipment();
                    break;
                case "Trailer":
                    trailerEquipment();
                    break;

                default:
                    System.out.println("Invalid Equipment Type");
            }
            location();
            if(EquipmentType.equals("PowerUnit")||EquipmentType.equals("Trailer")){
                equipmentNumber();
            } else if (EquipmentType.equals("Chassis")||EquipmentType.equals("Container")) {
                chassisEquipmentNumber();

            }
            truckDispatch();
            waitFunctions.scrollUp(driver);
            loaded();
            Driver();
            waitFunctions.scrollUp(driver);
            addFleetProfile();
            Next();
        }

    }

    public void serviceEventDetails(String FeatureName, DataTable EventData){
        List<Map<String,String>> list = EventData.asMaps(String.class, String.class);
        String EquipmentType = list.getFirst().get("EquipmentType");
        String Category = list.getFirst().get("Category");
        Add();

        if(EquipmentType.equals("PowerUnit")||EquipmentType.equals("Trailer")){
            String ServiceSystem =list.getFirst().get("System");
            String ServiceAssembly =list.getFirst().get("Assembly");
            String ServiceComponent =list.getFirst().get("Component");
            String ServicePosition =list.getFirst().get("Position");
            String ServiceWorkAccomplished =list.getFirst().get("WorkAccomplished");
            String ServiceReasonForRepair =list.getFirst().get("ReasonForRepair");
            String ServiceComment =list.getFirst().get("Comments");
            System(ServiceSystem);
            Assembly(ServiceAssembly);
            Component(ServiceComponent);
            Position(ServicePosition);
            WorkAccomplished(ServiceWorkAccomplished);
            reasonForRepair(ServiceReasonForRepair);
            Comments(ServiceComment);
        } else if (EquipmentType.equals("Chassis")||EquipmentType.equals("Container")) {
            String System = list.getFirst().get("ChassisSystem");
            String ServiceSubSystem = list.getFirst().get("SubSystem");
            String ServiceService = list.getFirst().get("Service");
            String ServiceDefect = list.getFirst().get("Defect");
            String ServiceLocation = list.getFirst().get("Location");
            String ServiceComment = list.getFirst().get("Comments");
            chassisSystem(System);
            subSystem(ServiceSubSystem);
            Service(ServiceService);
            Defect(ServiceDefect);
            Location(ServiceLocation);
            Comments(ServiceComment);
        }
        if(FeatureName.equals("Attachments")){
            switch (Category){
                case "Only Attachments" -> Attachments();
                case "Multiple Attachments" -> MultipleAttachments();
                case "Pre" -> {
                    Attachments();
                    preAttachments();
                }
                case "Others" -> {
                    Attachments();
                    otherAttachments();
                }
                case "Post" -> {
                    Attachments();
                    postAttachments();
                }
                default -> System.out.println("Invalid Category");
            }
        }

        Next();
        Done();
    }

    public void AssignTech(String Technician){

        if(Technician.equals("Technician1")) {
            assignTechnician1();
        }
        else {
            assignTechnician2();
        }


    }
    public void searchEventID(){

        EventId();


    }

    public void AddAttachments(String category){
        switch (category){
            case "Pre" -> {
                Attachments();
                preAttachments();
            }
            case "Others" -> {
                Attachments();
                otherAttachments();
            }
            case "Post" -> {
                Attachments();
                postAttachments();
            }
            default -> System.out.println("Invalid Category");
        }

    }
    public void searchEvent(){
        searchEventAndInspection();
    }

    public void EventAction(String Action,String user){

        if(user.equals("SC-Admin")){
            switch (Action) {

                case "Accept" -> {
                    Accept();ETA();
                }
                case "Reject" -> {
                    Reject();
                }
                case "Mark as Repaired" -> Repaired();
                case "Complete" -> Complete();
                default -> System.out.println("Invalid Event Action");
            }

        } else if (user.equals("SC-Technician")) {
            switch (Action){

                case "Tech Accept with ETA" -> {

                    Accept();ETA();
                }
                case "Tech Accept" -> TechnicianAccept();
                case "Tech Decline" -> TechnicianDeclined();
                case "Tech Arrive with ETC" -> {
                    TechnicianArrived();
                    ETC();
                }
                case "Tech Arrive without ETC" -> {

                    TechnicianArrived();
                    noETC();
                }
                case "Tech Arrived" -> {
                    TechnicianArrival();
                    noETC();
                }
                case "Tech Not Driving" ->  TechnicianNotDriving();


                case "Tech Departed"-> TechnicianDepartedYes();
                case "Tech Not Departed" -> TechnicianDepartedNo();
                case "Tech Repaired" -> TechnicianRepaired();
                default -> System.out.println("Invalid Technician Action");
            }

        }

    }

    public void EventDetails(String Action){
        System.out.println("Select Event Details Action");
        switch (Action){
            case "Accept" ->
                AcceptEventDetails();
            case "Reject" -> RejectEventDetails();
            default -> System.out.println("Invalid Event Details Action");

        }
    }


    public void GoBack1(){
        BackScreen1();
    }

    public void GoBack2(){
        BackScreen2();
    }




}

package org.reach24.Reach24NEP.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.reach24.Reach24NEP.dtos.EventDetailsDTO;
import org.reach24.Reach24NEP.dtos.Services;
import org.reach24.Reach24NEP.pages.DashboardPage;
import org.reach24.Reach24NEP.pages.EventInfoPage;
import org.reach24.Reach24NEP.util.BasePage;
import org.reach24.Reach24NEP.util.PropsReader;

public class EventDtoHelper extends BasePage {
	EventDetailsDTO eventDtoForInfoPage = new EventDetailsDTO();
	EventDetailsDTO eventDtoForDashboardPage = new EventDetailsDTO();
	EventInfoPage eventInfoPage = new EventInfoPage(driver);
//	DVIR_DashboardPage dvirDashBoardPage = new DVIR_DashboardPage(driver);
	String eventLink;

	List<Services> servicesList = new ArrayList<Services>();
	Services services = new Services();
	DashboardPage dashboardPage = new DashboardPage(driver);

	public EventDetailsDTO setEventdataFromEventInfoPage(int servicesCount,boolean regularEvent) throws IOException {
		
		if(regularEvent) {
			System.out.println(driver.getCurrentUrl());
		 eventDtoForInfoPage.setEventId(driver.getCurrentUrl().split("incidents/")[1]);
		}
		wait.forLoading();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eventDtoForInfoPage.setAlphaNumEventID(eventInfoPage.getAlphaNumEventId());
//		eventDtoForInfoPage.setEventLogStatus(eventInfoPage.getStatus("eventLog"));
//		eventDtoForInfoPage.setDispatchLogStatus(eventInfoPage.getStatus("dispatchLog"));
//		eventDtoForInfoPage.setTechnicianLogStatus(eventInfoPage.getStatus("technicianLog"));
//		eventDtoForInfoPage.setTechnicianLogStatus(eventInfoPage.getStatus("technicianName"));
//		eventDtoForInfoPage.setTechnicianLogStatus(eventInfoPage.getStatus("technicianStatus"));
		if (eventInfoPage.getEquipementType("Chassis") != null) {
			eventDtoForInfoPage.setChassisNumber(eventInfoPage.getEquipmentNumber());
			eventDtoForInfoPage.setEquipmentType("Chassis");
//			eventDtoForInfoPage.setAssociatedTractorNumber(eventInfoPage.getEventInfo("Associated Power Unit # :"));
//			eventDtoForInfoPage.setAssociatedContainerNumber(eventInfoPage.getEventInfo("Associated Container # :"));

		} else if (eventInfoPage.getEquipementType("Container") != null) {
			eventDtoForInfoPage.setContainerNumber(eventInfoPage.getEquipmentNumber());
			eventDtoForInfoPage.setEquipmentType("Container");
//			eventDtoForInfoPage.setAssociatedTractorNumber(eventInfoPage.getEventInfo("Associated Power Unit # :"));
//			eventDtoForInfoPage.setAssociatedChassisNumber(eventInfoPage.getEventInfo("Associated Chassis # :"));
		}

		else if (eventInfoPage.getEquipementType("Power Unit") != null) {
			eventDtoForInfoPage.setTractorNumber(eventInfoPage.getEquipmentNumber());
			eventDtoForInfoPage.setEquipmentType("Power Unit");
//			eventDtoForInfoPage.setAssociatedTrailerNumber(eventInfoPage.getEventInfo("Associated Trailer # :"));
//			eventDtoForInfoPage.setAssociatedChassisNumber(eventInfoPage.getEventInfo("Associated Chassis # :"));
//			eventDtoForInfoPage.setAssociatedContainerNumber(eventInfoPage.getEventInfo("Associated Container # :"));
		} else if (eventInfoPage.getEquipementType("Trailer") != null) {
			eventDtoForInfoPage.setTrailerNumber(eventInfoPage.getEquipmentNumber());
			eventDtoForInfoPage.setEquipmentType("Trailer");
//			eventDtoForInfoPage.setAssociatedTractorNumber(eventInfoPage.getEventInfo("Associated Power Unit # :"));
		}
//		eventDtoForInfoPage.setServiceCenter(eventInfoPage.getEventInfo("Service Center :"));
		eventDtoForInfoPage.setEquipmentProvider(eventInfoPage.getEquipmentProvider());

		if (eventInfoPage.getDriverWithUnit().equalsIgnoreCase("yes")) {
			eventDtoForInfoPage.setDriverWithUnit(true);
		} else if (eventInfoPage.getDriverWithUnit().equalsIgnoreCase("no")) {
			eventDtoForInfoPage.setDriverWithUnit(false);
		}

		if (eventInfoPage.getLoaded().equalsIgnoreCase("yes")) {
			eventDtoForInfoPage.setLoaded(true);
		} else if (eventInfoPage.getLoaded().equalsIgnoreCase("no")) {
			eventDtoForInfoPage.setLoaded(false);
		}

		// Services

		for (int count = servicesCount - 1; count >= 0; count--) {
			services.setSystem(eventInfoPage.getServicesInfo("System", count));
			if (eventInfoPage.getEquipementType("Chassis") != null
					|| eventInfoPage.getEquipementType("Container") != null) {
				services.setSystem(eventInfoPage.getServicesInfo("System", count));
				services.setSubSystem(eventInfoPage.getServicesInfo("Subsystem", count));
				services.setService(eventInfoPage.getServicesInfo("Service", count));
				services.setJob(eventInfoPage.getServicesInfo("Job", count));
				services.setDefect(eventInfoPage.getServicesInfo("Defect", count));
				services.setLocation(eventInfoPage.getServicesInfo("Location", count));
			} else if (eventInfoPage.getEquipementType("Power Unit") != null
					|| eventInfoPage.getEquipementType("Trailer") != null) {
				services.setAssembly(eventInfoPage.getServicesInfo("Assembly", count));
				services.setComponent(eventInfoPage.getServicesInfo("Component", count));
				services.setPosition(eventInfoPage.getServicesInfo("Position", count));
				services.setWorkAccomplished(eventInfoPage.getServicesInfo("Work Accomplished", count));
				services.setReasonforRepair(eventInfoPage.getServicesInfo("Reason for Repair", count));
			}
			servicesList.add(services);
		}

		eventDtoForInfoPage.setServices(servicesList);
		return eventDtoForInfoPage;

	}

	public EventDetailsDTO setEventdataFromDashboardPage(String tabname) {
		
		HashMap<String, String> dashboardMap = new HashMap<String, String>();
		String eventId = null;
		eventId = eventDtoForInfoPage.getAlphaNumEventID();
		System.out.println(eventId);
		dashboardPage.switchTabTo(tabname);
		if(tabname.equalsIgnoreCase("All")) {
		dashboardPage.searchEvent(eventId);
		}else {
			dashboardPage.searchotherEvent(eventId);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dashboardMap = dashboardPage.getInfoFromDashboardPage(tabname);
		System.out.println(dashboardMap);
		eventDtoForDashboardPage.setEventId(dashboardMap.get("Event#"));
		eventDtoForDashboardPage.setStatus(dashboardMap.get("Status"));
		eventDtoForDashboardPage.setTechstatus(dashboardMap.get("Technician Status"));
		eventDtoForDashboardPage.setEquipmentType(dashboardMap.get("Equipment Type"));
		eventDtoForDashboardPage.setEquipmentNumber(dashboardMap.get("Equipment#"));
		eventDtoForDashboardPage.setAssociatedContainerNumber(dashboardMap.get("Asso. Container#"));
//		System.out.println(dashboardMap.get("Asso. Container#"));
		eventDtoForDashboardPage.setEquipmentProvider(dashboardMap.get("EP"));
//		System.out.println(dashboardMap.get("Asso. Power Unit#"));
		eventDtoForDashboardPage.setAssociatedTractorNumber(dashboardMap.get("Asso. Power Unit#"));
		eventDtoForDashboardPage.setAssociatedChassisNumber(dashboardMap.get("Asso. Chassis#"));
		eventDtoForDashboardPage.setAssociatedTrailerNumber(dashboardMap.get("Asso. Trailer#"));
//		System.out.println(dashboardMap.get("Asso. Trailer#"));
		eventDtoForDashboardPage.setReferenceNumber(dashboardMap.get("Reference#"));
		System.out.println(" Event Info Verified");
		return eventDtoForDashboardPage;

	}
	
   
}

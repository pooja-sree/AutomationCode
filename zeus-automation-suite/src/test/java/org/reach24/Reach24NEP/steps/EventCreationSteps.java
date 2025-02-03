package org.reach24.Reach24NEP.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.util.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.reach24.Reach24NEP.actions.DriverActions;
import org.reach24.Reach24NEP.actions.JsActions;
import org.reach24.Reach24NEP.dtos.CommonVariables;
import org.reach24.Reach24NEP.dtos.EventDetailsDTO;
import org.reach24.Reach24NEP.dtos.Services;
import org.reach24.Reach24NEP.helper.EventDtoHelper;
import org.reach24.Reach24NEP.pages.*;
import org.reach24.Reach24NEP.util.*;
import io.cucumber.datatable.DataTable;

public class EventCreationSteps extends BasePage {
	static EventDetailsDTO eventInfoFromCreation = new EventDetailsDTO();
	static EventDetailsDTO eventInfoFromTenant = new EventDetailsDTO();
	static EventDetailsDTO eventInfoFromDashboard = new EventDetailsDTO();
	static BeforeAndAfterScenarios beforeScenarios = new BeforeAndAfterScenarios();
	EventDtoHelper eventHelper = new EventDtoHelper();
	EventCreationPage eventCreationPage = new EventCreationPage(driver);
	EventServicesPage eventServicePage = new EventServicesPage(driver);
	EventInfoPage eventInfoPage = new EventInfoPage(driver);
	EventEditPage eventEditPage = new EventEditPage(driver);
	TenantLogoutPage tenantLogoutPage = new TenantLogoutPage(driver);
	TenantLoginPage tenantLoginPage = new TenantLoginPage(driver);
	Inandoutstream inandoutstream = new Inandoutstream();
	DashboardPage dashboardPage = new DashboardPage(driver);
	Services services = new Services();
	DriverActions driverActions = new DriverActions(driver);
	JsActions jsActions = new JsActions(driver);

	static int serviesCount;
	static String eventId;
	String last5Numbers;
	static String Drafteventid;
	String duplicatechassisNumber;
	String duplicatetractorNumber;

	public void createEvent(String eventType, String tenantType, String featureName, DataTable eventData) throws IOException, AWTException {
		List<Map<String, String>> list = eventData.asMaps(String.class, String.class);
		String equipmentType = list.get(0).get("EquipmentType");
		String customerName = list.get(0).get("CustomerName");
		String equipmentProvider = list.get(0).get("EquipmentProvider");
		String crosswalk = list.get(0).get("Crosswalk");

		tenantType = tenantType.toUpperCase();
		try {
			switch (tenantType) {

			case "TD":
				driver.get(PropsReader.tdeventCreatePage);
				break;

			case "TD1":
				driver.get(PropsReader.td1eventCreatePage);
				break;

			case "TD2":
				driver.get(PropsReader.td2eventCreatePage);
				break;

			case "SP":
				driver.get(PropsReader.speventCreatePage);
				break;

			case "SP1":
				driver.get(PropsReader.sp1eventCreatePage);
				break;

			case "SP2":
				driver.get(PropsReader.sp2eventCreatePage);
				break;

			case "SP3":
				driver.get(PropsReader.sp3eventCreatePage);
				break;

			case "SP4":
				driver.get(PropsReader.sp4eventCreatePage);
				break;

			case "FLEET":
				driver.get(PropsReader.fleeteventCreatePage);
				break;

			case "SPHQ":
				driver.get(PropsReader.sphqeventCreatePage);
				break;

			case "SCCROSSWALK":
				driver.get(PropsReader.SCcrosswalkeventCreatePage);
				break;

			case "CC":
				driver.get(PropsReader.ccEventCreatePage);
				break;

			case "CC1":
				driver.get(PropsReader.cc1eventCreatePage);
				break;

			case "CCHQ":
				driver.get(PropsReader.cchqeventCreatePage);
				break;

			case "AUTOFORWARD":
				driver.get(PropsReader.autoForwardCreatePage);
				break;

			case "BRIDGESTONE":
			    driver.get(PropsReader.bridgeStoneCallCenterCreatePage);
			    break;

			default:
				throw new Reach24NEPCustomException("Invalid Tenant selected");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}
		driverActions.hardwaitBasedOnInput(3000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		driverActions.hardwaitBasedOnInput(3000);
		System.out.println("Create Event Started.");
		if (featureName.equalsIgnoreCase("Walkin")) {
			eventCreationPage.addWalkinDetails(crosswalk);
		}
		eventCreationPage.selectEpuipmentAndDriver(featureName, customerName, equipmentType, crosswalk);
		eventInfoFromCreation.setEquipmentType(equipmentType);
		if ((featureName.contains("DepartedTerminal"))) {
			eventCreationPage.selectSPAuthorityy();
			eventCreationPage.selectDifferentEP();
			eventCreationPage.selectDepartedTerminall();
			eventCreationPage.selectdriver();
			if ((!featureName.contains("AncillaryLocation"))) {
				eventCreationPage.selectEventAndLocation(CommonVariables.address, CommonVariables.caller);
				eventInfoFromCreation.setAddress(CommonVariables.address);
			}
			return;
		}
		if (eventType.contains("Draft")) {
			eventCreationPage.selectEquipmentNumber(eventType);
			eventCreationPage.selectEventAndLocation(CommonVariables.address, CommonVariables.caller);
			eventInfoFromCreation.setAddress(CommonVariables.address);
			eventCreationPage.clickSaveDraftButton();
			driver.switchTo().defaultContent();
			driverActions.hardwaitBasedOnInput(3000);
			dashboardPage.searchEquipmentNumber();
			last5Numbers = inandoutstream.loadScheduleEventID();
			System.out.println("Event is :" + last5Numbers);
			return;
		}
		if (featureName.contains("Duplicate") || (featureName.contains("EPselectionfromFleet"))) {
			if (equipmentType.equalsIgnoreCase("Chassis")) {
				eventCreationPage.selectDuplicateEventNumber(Inandoutstream.loadchassisnumber(duplicatechassisNumber));
			}
			if (equipmentType.equalsIgnoreCase("Trailer")) {
				eventCreationPage.selectDuplicateEventNumber(Inandoutstream.loadchassisnumber(duplicatechassisNumber));
			}
			if (equipmentType.equalsIgnoreCase("Container")) {
				eventCreationPage.selectDuplicateEventNumber(Inandoutstream.loadchassisnumber(duplicatechassisNumber));
			}
			if (equipmentType.equalsIgnoreCase("Power Unit")) {
				eventCreationPage.selectDuplicateEventNumber(Inandoutstream.loadtractornumber(duplicatetractorNumber));
			}
			if (featureName.contains("Duplicate")) {
				eventCreationPage.clickIgnoreCont();
			}
		} else {
			if (featureName.equalsIgnoreCase("FSCSPAuthority") || featureName.equalsIgnoreCase("FSCEPApproved")) {
				eventCreationPage.selectSPAuthority();
				eventCreationPage.selectDifferentEP();
				eventCreationPage.selectEP(equipmentProvider);
//				eventCreationPage.clickIgnoreCont();
				eventCreationPage.selectDepartedTerminal();
				if (featureName.equalsIgnoreCase("FSCSPAuthority")) {
					eventCreationPage.selectdriver();
				}
				if (featureName.equalsIgnoreCase("FSCEPApproved")) {
					eventCreationPage.selectdriver1();
				}
			} else {
				eventCreationPage.selectEquipmentNumber(featureName);
			}
		}

		if ((featureName.contains("ShipperFunction"))) {
			eventCreationPage.selectShipperTenant();
			driverActions.hardwaitBasedOnInput(2000);
		}

		if (featureName.equalsIgnoreCase("EPselectionfromFleet")) {
			if (tenantType.equalsIgnoreCase("TD") || tenantType.equalsIgnoreCase("Fleet")) {
				//eventCreationPage.selectDifferentEP();
				if (equipmentProvider.equalsIgnoreCase("AutoTruck TD") && customerName.equalsIgnoreCase("Fleet")) {
					eventCreationPage.clickIgnoreCont();
					eventCreationPage.selectDifferentEP();
					eventCreationPage.selectEP(equipmentProvider);

				}
				if (equipmentProvider.equalsIgnoreCase("AutoTruck Fleet")) {
					eventCreationPage.clickIgnoreCont();
					eventCreationPage.selectDifferentEP();
					eventCreationPage.selectEP(equipmentProvider);
				}
				if (equipmentProvider.equalsIgnoreCase("AutoTruck") && customerName.equalsIgnoreCase("AutoTruck TD")) {
					eventCreationPage.clickIgnoreCont();
					eventCreationPage.selectDifferentEP();
					eventCreationPage.selectEP(customerName);


				}
				if (customerName.equalsIgnoreCase("AutoTruck Fleet")) {
					eventCreationPage.clickIgnoreCont();
					eventCreationPage.selectDifferentEP();
					eventCreationPage.selectEP(equipmentProvider);
//					eventCreationPage.clickIgnoreCont();
				}
			}
		}
		eventInfoFromCreation.setCustomerName(customerName);

		if (featureName.contains("AncillaryLocation")) {
			eventCreationPage.selectDropLocationCheckBox();
			eventCreationPage.selectAncillaryLocation();
		}
		if ((!featureName.contains("AncillaryLocation"))) {
			eventCreationPage.selectEventAndLocation(CommonVariables.address, CommonVariables.caller);
			eventInfoFromCreation.setAddress(CommonVariables.address);
		}
		if (featureName.contains("AssignReportingLocation")) {
			eventCreationPage.assignReportingLocation();
			eventCreationPage.validateARL();
		}
		if (featureName.contains("EventForward")) {
			eventCreationPage.selectEventForwardedFrom();
		}
		if(featureName.contains("BridgestoneShipTo")){
			eventCreationPage.selectBridgestoneResponsiblePayer(customerName);
		}
	}

	public void enterServiceDetailsEdit(DataTable serviceLineData) {
		List<Map<String, String>> list1 = serviceLineData.asMaps(String.class, String.class);
		String equipmentType = list1.get(0).get("EquipmentType");
		serviesCount = list1.size();

		for (int count = 0; count <= list1.size() - 1; count++) {

			eventCreationPage.addServiceBtn();

			if (equipmentType.equalsIgnoreCase("chassis") || equipmentType.equalsIgnoreCase("container")) {
				eventServicePage.selectSystemEdit(list1.get(count).get("System"), count);
				services.setSystemEdit(list1.get(count).get("System"));

				eventServicePage.selectSubSystemEdit(list1.get(count).get("SubSystem"), count);
				services.setSubSystemEdit(list1.get(count).get("SubSystem"));

				eventServicePage.selectServiceEdit(list1.get(count).get("Service"), count);
				services.setServiceEdit(list1.get(count).get("Service"));

				eventServicePage.selectDefectEdit(list1.get(count).get("Defect"), count);
				services.setDefectEdit(list1.get(count).get("Defect"));

				eventServicePage.selectLocationEdit(list1.get(count).get("Location"), count);
				services.setLocationEdit(list1.get(count).get("Location"));

			} else if (equipmentType.equalsIgnoreCase("power unit") || equipmentType.equalsIgnoreCase("trailer")) {

				eventServicePage.selectTractorSystemEdit(list1.get(count).get("System1"), count);
				services.setSystemEdit(list1.get(count).get("System1"));

				eventServicePage.selectAssemblyEdit(list1.get(count).get("Assembly1"), count);
				services.setAssemblyEdit(list1.get(count).get("Assembly1"));

				eventServicePage.selectComponentEdit(list1.get(count).get("Component1"), count);
				services.setComponentEdit(list1.get(count).get("Component1"));

				eventServicePage.selectPositionEdit(list1.get(count).get("Position1"), count);
				services.setPositionEdit(list1.get(count).get("Position1"));

				eventServicePage.selectWorkAccomplishedEdit(list1.get(count).get("WorkAccomplished1"), count);
				services.setWorkAccomplishedEdit(list1.get(count).get("WorkAccomplished1"));

				eventServicePage.selectReasonforRepairEdit(list1.get(count).get("Reason1"), count);
				services.setReasonforRepairEdit(list1.get(count).get("Reason1"));

			}
		}
		eventServicePage.clickSaveEditBtn();
		driver.switchTo().defaultContent();
		wait.forLoading();
	}

	public void enterServiceDetails(String featureName, DataTable serviceLineData) throws IOException {
		List<Map<String, String>> list = serviceLineData.asMaps(String.class, String.class);
		String equipmentType = list.get(0).get("EquipmentType");
		List<Services> servicesList = new ArrayList<Services>();
		serviesCount = list.size();
		for (int count = 0; count <= list.size() - 1; count++) {
			eventCreationPage.addServiceBtn();
			if (featureName.equalsIgnoreCase("SecondServiceLine")) {
				eventServicePage.selectTractorSystem2(list.get(count).get("System"), count);
				eventServicePage.selectAssembly2(list.get(count).get("Assembly"), count);
				eventServicePage.selectComponent2(list.get(count).get("Component"), count);
				eventServicePage.selectPosition2(list.get(count).get("Position"), count);
				eventServicePage.selectWorkAccomplished2(list.get(count).get("WorkAccomplished"), count);
				eventServicePage.selectReasonforRepair2(list.get(count).get("Reason"), count);
				if (list.get(count).get("ValidateSecondServiceLine") != null) {
					int size = driver.findElements(By.xpath("//input[contains(@id,'towing_destination_address')]"))
							.size();
					boolean status = size == 1;
					Assert.assertTrue(status);
				}
				return;
			}
			if (equipmentType.equalsIgnoreCase("chassis") || equipmentType.equalsIgnoreCase("container")) {
				eventServicePage.selectSystem(list.get(count).get("System"), count);
				services.setSystem(list.get(count).get("System"));

				eventServicePage.selectSubSystem(list.get(count).get("SubSystem"), count);
				services.setSubSystem(list.get(count).get("SubSystem"));

				eventServicePage.selectService(list.get(count).get("Service"), count);
				services.setService(list.get(count).get("Service"));

				eventServicePage.selectDefect(list.get(count).get("Defect"), count);
				services.setDefect(list.get(count).get("Defect"));

				eventServicePage.selectLocation(list.get(count).get("Location"), count);
				services.setLocation(list.get(count).get("Location"));

				if (list.get(count).get("TowingDestination") != null) {
					eventServicePage.selectTowingDestination(list.get(count).get("TowingDestination"),
							list.get(count).get("Mileage"));
				}

				if (list.get(count).get("Size1") != null) {
					eventServicePage.selectSize1(list.get(count).get("Size1"), count);
					services.setSize1(list.get(count).get("Size1"));
				}

				if (list.get(count).get("Size2") != null) {
					eventServicePage.selectSize2(list.get(count).get("Size2"), count);
					services.setSize2(list.get(count).get("Size2"));
				}
				if (list.get(count).get("CreateTemplate") != null) {
					saveTemplate();
					return;
				}

			} else if (equipmentType.equalsIgnoreCase("power unit") || equipmentType.equalsIgnoreCase("trailer")) {

				eventServicePage.selectTractorSystem(list.get(count).get("System"), count);
				services.setSystem(list.get(count).get("System"));

				eventServicePage.selectAssembly(list.get(count).get("Assembly"), count);
				services.setAssembly(list.get(count).get("Assembly"));

				if (list.get(count).get("Component") != null) {
					eventServicePage.selectComponent(list.get(count).get("Component"), count);
					services.setComponent(list.get(count).get("Component"));
				}

				if (list.get(count).get("Position") != null) {
					eventServicePage.selectPosition(list.get(count).get("Position"), count);
					services.setPosition(list.get(count).get("Position"));
				}

				if (list.get(count).get("WorkAccomplished") != null) {
					eventServicePage.selectWorkAccomplished(list.get(count).get("WorkAccomplished"), count);
					services.setWorkAccomplished(list.get(count).get("WorkAccomplished"));
				}

				if (list.get(count).get("TowingDestination") != null) {
					eventServicePage.selectReasonforRepair(list.get(count).get("Reason"), count);
					services.setReasonforRepair(list.get(count).get("Reason"));
				}

				if (list.get(count).get("TowingDestination") != null) {
					eventServicePage.selectTowingDestination(list.get(count).get("TowingDestination"),
							list.get(count).get("Mileage"));
				}
				if (list.get(count).get("CreateTemplate") != null) {
					saveTemplate();
					return;
				}
			}
		}
		servicesList.add(services);
		driverActions.hardwaitBasedOnInput(8000);
		if (featureName.equalsIgnoreCase("with Attachments")) {
			eventServicePage.addAttachments(driver, "Others");
			driverActions.hardwaitBasedOnInput(3000);
		}
		if (featureName.equalsIgnoreCase("with Pre Attachments")) {
			eventServicePage.addAttachments(driver, "Pre");
			driverActions.hardwaitBasedOnInput(3000);
		}
		if (featureName.equalsIgnoreCase("with Post Attachments")) {
			eventServicePage.addAttachments(driver, "Post");
			driverActions.hardwaitBasedOnInput(3000);
		}
		System.out.println("Feature is : " + featureName);
		eventServicePage.clickSaveBtn(featureName);
		driver.switchTo().defaultContent();
		for (int i = 0; i < 50; i++) {
			if (driver.getCurrentUrl().contains("next/new")) {
				driverActions.hardwaitBasedOnInput(2000);
			} else {
				break;
			}
		}
		assertFalse(driver.getCurrentUrl().contains("next/new"));
		assertFalse(driver.getCurrentUrl().contains("/event/incidents/next/new"));
		System.out.println("Asserted the create event url : " + driver.getCurrentUrl());
		eventId = driver.getCurrentUrl().split("incidents/")[1];
		System.out.println(eventId);
		inandoutstream.saveEventID(eventId);
	}

	public void getEventInfo(String tenantType) throws IOException {
		tenantType = tenantType.toUpperCase();
		try {
			switch (tenantType) {

			case "TD":
				driver.get(PropsReader.tdEventInfoPage + eventId);
				System.out.println(PropsReader.tdEventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.tdURL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.tdEventInfoPage + eventId);
				break;

			case "TD1":
				driver.get(PropsReader.td1EventInfoPage + eventId);
				System.out.println(PropsReader.td1EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.td1URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				break;

			case "TD2":
				driver.get(PropsReader.td2EventInfoPage + eventId);
				System.out.println(PropsReader.td2EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.td2URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				break;

			case "SP":
				driver.get(PropsReader.spEventInfoPage + eventId);
				System.out.println(PropsReader.spEventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.spURL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.spEventInfoPage + eventId);
				break;

			case "SP1":
				driver.get(PropsReader.sp1EventInfoPage + eventId);
				System.out.println(PropsReader.sp1EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.sp1URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.sp1EventInfoPage + eventId);
				break;

			case "SP2":
				driver.get(PropsReader.sp2EventInfoPage + eventId);
				System.out.println(PropsReader.sp2EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.sp2URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.sp2EventInfoPage + eventId);
				break;

			case "SPHQ":
				driver.get(PropsReader.sphqEventInfoPage + eventId);
				System.out.println(PropsReader.sphqEventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.sphqURL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.sphqEventInfoPage + eventId);
				break;

			case "SP3":
				driver.get(PropsReader.sp3EventInfoPage + eventId);
				System.out.println(PropsReader.sp3EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.sp3URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.sp3EventInfoPage + eventId);
				break;

			case "SP4":
				driver.get(PropsReader.sp4EventInfoPage + eventId);
				System.out.println(PropsReader.sp4EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.sp4URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.sp4EventInfoPage + eventId);
				break;

			case "SP6":
				driver.get(PropsReader.sp6EventInfoPage + eventId);
				System.out.println(PropsReader.sp6EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.sp6URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.sp6EventInfoPage + eventId);
				break;

			case "SP7":
				driver.get(PropsReader.sp7EventInfoPage + eventId);
				System.out.println(PropsReader.sp7EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.sp7URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.sp7EventInfoPage + eventId);
				break;

			case "TECHSP":
				driver.get(PropsReader.sctechEventInfoPage + eventId);
				System.out.println(PropsReader.sctechEventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.sctechURL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.sctechEventInfoPage + eventId);
				break;

			case "TECHSP2":
				driver.get(PropsReader.sctech2EventInfoPage + eventId);
				System.out.println(PropsReader.sctech2EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.sctech2URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.sctech2EventInfoPage + eventId);
				break;

			case "FLEET":
				driver.get(PropsReader.fleetEventInfoPage + eventId);
				System.out.println(PropsReader.fleetEventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.fleetURL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.fleetEventInfoPage + eventId);
				break;

			case "CC":
				driver.get(PropsReader.ccEventInfoPage + eventId);
				System.out.println(PropsReader.ccEventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.ccURL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.ccEventInfoPage + eventId);
				break;

			case "CCHQ":
				driver.get(PropsReader.cchqEventInfoPage + eventId);
				System.out.println(PropsReader.cchqEventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.cchqURL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.cchqEventInfoPage + eventId);
				break;

			case "CC1":
				driver.get(PropsReader.cc1EventInfoPage + eventId);
				System.out.println(PropsReader.cc1EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.cc1URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.cc1EventInfoPage + eventId);
				break;

			case "CC2":
				driver.get(PropsReader.cc2EventInfoPage + eventId);
				System.out.println(PropsReader.cc2EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.cc2URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.cc2EventInfoPage + eventId);
				break;

			case "AUTOFORWARD":
				driver.get(PropsReader.autoForwardEventInfoPage + eventId);
				System.out.println(PropsReader.autoForwardEventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.autoForwardUrl);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.autoForwardEventInfoPage + eventId);
				break;

			case "BRIDGESTONE":
				driver.get(PropsReader.bridgeStoneCallCenterEventInfoPage + eventId);
				System.out.println(PropsReader.bridgeStoneCallCenterEventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.bridgeStoneCallCenterUrl);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				driver.get(PropsReader.bridgeStoneCallCenterEventInfoPage + eventId);
				break;

			default:
				throw new Reach24NEPCustomException("Invalid Tenant selected");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}

	}

	public void saveTemplate() {

		eventServicePage.clickSaveTemplate();
		driver.switchTo().defaultContent();
		wait.forLoading();
		for (int i = 0; i < 50; i++) {
			if (driver.getCurrentUrl().contains("next/new")) {
				driverActions.hardwaitBasedOnInput(3000);
			} else {
				break;
			}
		}
	}

	public void validateEventFields(EventDetailsDTO eventInfoFromCreation, EventDetailsDTO eventInfoTenant) {

		assertEquals("Verify Equipment Type", eventInfoFromCreation.getEquipmentType().toLowerCase(),
				eventInfoFromCreation.getEquipmentType().toLowerCase());
		try {
			switch (eventInfoFromCreation.getEquipmentType().toLowerCase()) {
			case "chassis":
				assertEquals("Verify Chassis Number", eventInfoTenant.getChassisNumber(),
						eventInfoTenant.getChassisNumber());
				break;
			case "container":
				assertEquals("Verify Container Number", eventInfoFromCreation.getContainerNumber(),
						eventInfoTenant.getContainerNumber());
				break;
			case "power unit":
				assertEquals("Verify Tractor Number", eventInfoFromCreation.getTractorNumber(),
						eventInfoTenant.getTractorNumber());
				break;
			case "trailer":
				assertEquals("Verify Trailer Number", eventInfoFromCreation.getTrailerNumber(),
						eventInfoTenant.getTrailerNumber());
				break;
			default:
				throw new Reach24NEPCustomException("Invalid Equipement Type");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}
	}

	public void dashBoardValidation(EventDetailsDTO eventInfoFromCreation, EventDetailsDTO eventInfoFromDashboard) {
		try {
			wait.forLoading();
			driverActions.hardwaitBasedOnInput(3000);
			switch (eventInfoFromCreation.getEquipmentType().toLowerCase()) {
			case "chassis":
				assertEquals("Verify Chassis Number", eventInfoFromDashboard.getEquipmentNumber(),
						eventInfoFromDashboard.getEquipmentNumber());
				assertEquals("Verify associated Tractor Number", eventInfoFromDashboard.getAssociatedTractorNumber(),
						eventInfoFromDashboard.getAssociatedTractorNumber());
				assertEquals("Verify associated Container Number",
						eventInfoFromDashboard.getAssociatedContainerNumber(),
						eventInfoFromDashboard.getAssociatedContainerNumber());
				break;
			case "container":
				assertEquals("Verify Container Number", eventInfoFromDashboard.getEquipmentNumber(),
						eventInfoFromDashboard.getEquipmentNumber());
				break;

			case "power unit":
				assertEquals("Verify Tractor Number", eventInfoFromDashboard.getEquipmentNumber(),
						eventInfoFromDashboard.getEquipmentNumber());
				break;

			case "trailer":
				assertEquals("Verify Trailer Number", eventInfoFromDashboard.getEquipmentNumber(),
						eventInfoFromDashboard.getEquipmentNumber());
				break;
			default:
				throw new Reach24NEPCustomException("Options not selected");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}
	}

	public void verifyStatus(DataTable verificationData) throws IOException {
		List<Map<String, String>> list = verificationData.asMaps(String.class, String.class);
		for (int count = 0; count <= list.size() - 1; count++) {
			String tenantType = list.get(count).get("TenandType");
			String childTenant = "";
			if (tenantType.contains(">")) {
				for (int i = 0; i < tenantType.length(); i++) {
					if (tenantType.charAt(i) == '>') {
						childTenant = tenantType.substring(i + 1);
						System.out.println("Child Tenant: "+childTenant);
						tenantType = tenantType.substring(0, i);
						System.out.println("Parent Tenant: "+tenantType);
						break;
					}
				}
			}
			String status = list.get(count).get("Status");
			String page = list.get(count).get("Page");
			String statusType = list.get(count).get("StatusType");
			String last5Number = inandoutstream.loadScheduleEventID();
			try {
				wait.forLoading();
				switch (tenantType.toUpperCase()) {
				case "TD":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.tdURL);
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.tdEventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						if (status.equalsIgnoreCase("Rejected")) {
							return;
						}
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "TD1":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.td1URL);
						if (statusType.equals("Org")) {
							verifyOrgEvent(childTenant);
						}
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.td1EventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						if (statusType.equals("Org")) {
							verifyOrgEventInfo(childTenant);
						}
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "TD2":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.td2URL);
						if (statusType.equals("Org")) {
							verifyOrgEvent(childTenant);
						}
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.td2EventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						if (statusType.equals("Org")) {
							verifyOrgEventInfo(childTenant);
						}
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "SP":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.spURL);
						if (statusType.equals("Org")) {
							verifyOrgEvent(childTenant);
						}
						dashboardPage.searchEvent(last5Number);
						removeReportingTenants();
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.spEventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equals("Org")) {
							verifyOrgEventInfo(childTenant);
						}
						if (list.get(count).get("NoInvoice") != null) {
							eventInfoPage.validateNoInvoice();
						}
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "SP1":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.sp1URL);
						if (statusType.equals("Org")) {
							verifyOrgEvent(childTenant);
						}
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.sp1EventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equals("Org")) {
							verifyOrgEventInfo(childTenant);
						}
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "SP2":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.sp2URL);
						if (statusType.equals("Org")) {
							verifyOrgEvent(childTenant);
						}
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.sp2EventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equals("Org")) {
							verifyOrgEventInfo(childTenant);
						}
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "SP3":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.sp3URL);
						if (statusType.equals("Org")) {
							verifyOrgEvent(childTenant);
						}
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.sp3EventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equals("Org")) {
							verifyOrgEventInfo(childTenant);
						}
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "SP4":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.sp4URL);
						if (statusType.equals("Org")) {
							verifyOrgEvent(childTenant);
						}
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.sp4EventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equals("Org")) {
							verifyOrgEventInfo(childTenant);
							break;
						}
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "SPHQ":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.sphqURL);
						if (statusType.equals("Org")) {
							verifyOrgEvent(childTenant);
						}
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.sphqEventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equals("Org")) {
							verifyOrgEventInfo(childTenant);
							break;
						}
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "TECHSP":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.sctechURL);
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.sctechEventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equalsIgnoreCase("technStatus-remainingServiceLineItems")) {
							String statusTypeString="";
							String statusString="";
							String serviceLineItems="";
							for(int i=0;i<statusType.length();i++) {
								if(statusType.charAt(i)=='-'){
									System.out.println(statusTypeString);
									break;
								}
								statusTypeString=statusTypeString+statusType.charAt(i);
							}
							for(int j=0;j<status.length();j++){
								if(status.charAt(j)=='-'){
									System.out.println(statusString);
									serviceLineItems=status.substring(j+1);
									incompleteServiceLines(serviceLineItems);
									break;
								}
								statusString=statusString+status.charAt(j);
							}
							status=statusString;
							statusType=statusTypeString;
						}

						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "TECH2SP":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.sctech2URL);
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.sctech2EventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "FLEET":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.fleetURL);
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.fleetEventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "CC":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.ccURL);
						if (statusType.equals("Org")) {
							verifyOrgEvent(childTenant);
						}
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.ccEventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equals("Org")) {
							verifyOrgEventInfo(childTenant);
						}
						driverActions.hardwaitBasedOnInput(2000);
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						if (status.equalsIgnoreCase("Rejected")) {
							return;
						}
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "AUTOTRUCK SP8":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.sp8URL);
						if (statusType.equals("Org")) {
							verifyOrgEvent(childTenant);
						}
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.sp8EventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equals("Org")) {
							verifyOrgEventInfo(childTenant);
						}
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "CCHQ":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.cchqURL);
						if (statusType.equals("Org")) {
							verifyOrgEvent(childTenant);
						}
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.cchqEventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equals("Org")) {
							verifyOrgEventInfo(childTenant);
							break;
						}
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "CC1":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.cc1URL);
						if (statusType.equals("Org")) {
							verifyOrgEvent(childTenant);
						}
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.cc1EventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equals("Org")) {
							verifyOrgEventInfo(childTenant);
						}
						if (list.get(count).get("ValidateResendInvoice") != null) {
							eventInfoPage.validateResendInvoice(list.get(count).get("ValidateResendInvoice"));
						}
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "AUTOFORWARD":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.autoForwardUrl);
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.autoForwardEventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				case "BRIDGESTONE":
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.bridgeStoneCallCenterUrl);
						dashboardPage.searchEvent(last5Number);
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertDashboardStatus(status, statusType);
					} else if (page.equalsIgnoreCase("EventInfo")) {
						driver.get(PropsReader.bridgeStoneCallCenterEventInfoPage + eventId);
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertTrue(verifyEventInfoBannerStatus(status, statusType));
						assertEquals(status, eventInfoPage.getStatus(statusType));
					}
					break;

				default:
					throw new Reach24NEPCustomException("Invalid Tenant selected");

				}
			} catch (Reach24NEPCustomException e) {
				e.printStackTrace();
			}
		}
	}

	public void incompleteServiceLines(String serviceLineItems){
		System.out.println(serviceLineItems);
		StringBuilder serviceLineString= new StringBuilder();
		ArrayList<String> serviceLine = new ArrayList<String>();
		for(int i=0;i<serviceLineItems.length();i++){
			if(serviceLineItems.charAt(i)=='-'){
				serviceLine.add(serviceLineString.toString());
				serviceLineString = new StringBuilder();
				continue;
			}
			serviceLineString.append(serviceLineItems.charAt(i));
		}
		serviceLine.add(serviceLineString.toString());
		String component=serviceLine.get(0);
		System.out.println(component);
		String position=serviceLine.get(1);
		System.out.println(position);
		String workAccomplished=serviceLine.get(2);
		System.out.println(workAccomplished);
		String reason=serviceLine.get(3);
		System.out.println(reason);
		eventInfoPage.clickEdit();
		driver.switchTo().defaultContent();
		driverActions.hardwaitBasedOnInput(4000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		eventServicePage.selectComponent(component,1);
		eventServicePage.selectPosition(position,1);
		eventServicePage.selectWorkAccomplished(workAccomplished,1);
		eventServicePage.selectReasonforRepair(reason,1);
		eventServicePage.clickSaveEditBtn();
		driver.switchTo().defaultContent();
	}

	public boolean verifyEventInfoBannerStatus(String status, String statusType) {
		boolean bannerStatus = false;
		driverActions.hardwaitBasedOnInput(3000);
		if (statusType.equalsIgnoreCase("eventLog") || statusType.equalsIgnoreCase("Single")
				|| statusType.equalsIgnoreCase("Org") || statusType.equalsIgnoreCase("eventLog-2")) {
			if (status.equalsIgnoreCase("Estimated")) {
				bannerStatus = true;
				return bannerStatus;
			}
			assertEquals(status.toUpperCase(), eventInfoPage.getBannerStatus(status).toUpperCase());
			bannerStatus = true;

		} else if (statusType.equalsIgnoreCase("dispatchLog") || statusType.equalsIgnoreCase("technLog")
				|| statusType.equalsIgnoreCase("technStatus")) {
			bannerStatus = true;
		}
		return bannerStatus;
	}

	public void verifyOrgEvent(String childTenant) {
		System.out.println("Verify Org Events Dashboard : ");
		System.out.println("Child Tenant: "+ childTenant);
		dashboardPage.enableShowOrgEvents();
		dashboardPage.enterReportingTenants(childTenant);
		String displayedReportingTenant = driverActions
				.driverGetText(driver.findElement(By.xpath("//div[@id='reporting_tenants_toolbar']/span")));
		Assert.assertEquals("Validating Reporting Tenant : ", childTenant, displayedReportingTenant);
	}

	public void removeReportingTenants() {
		String ReportingTenantClass = driver
				.findElement(By.xpath("//a[contains(@class,'dt-button reporting_tenants_filter_btn')]"))
				.getAttribute("class");
		if (ReportingTenantClass.contains("reporting-tenants-filter-highlight")) {
			WebElement reportingTenantBtn = driver
					.findElement(By.xpath("//a[contains(@class,'dt-button reporting_tenants_filter_btn')]"));
			jsActions.jsclick(reportingTenantBtn);
			driverActions.hardwaitBasedOnInput(2000);
			int selectedOrgTenantsSize = driver
					.findElements(By.xpath(
							"//div[@aria-labelledby='reporting-tenants-filter-modal']/div/div/div/div/div/ul/li"))
					.size();
			for (int i = 1; i < selectedOrgTenantsSize; i++) {
				WebElement ithSelectOrgTenant = driver.findElement(
						By.xpath("//div[@aria-labelledby='reporting-tenants-filter-modal']/div/div/div/div/div/ul/li["
								+ i + "]/a"));
				jsActions.jsclick(ithSelectOrgTenant);
				driverActions.hardwaitBasedOnInput(2000);
			}
			WebElement closeBtn = driver
					.findElement(By.xpath("//div[@id='reporting-tenants-filter-modal']/div/div/div[3]/button"));
			jsActions.jsclick(closeBtn);
			driverActions.hardwaitBasedOnInput(3000);
		}
	}

	public void verifyOrgEventInfo(String childTenant) {
		driverActions.hardwaitBasedOnInput(7000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		System.out.println("Verify Org Events Info : ");
		System.out.println(childTenant);
		String OrgBanner = driverActions.driverGetText(driver.findElement(By
				.xpath("//div[contains(@class,'ant-alert ant-alert-info ant-alert-no-icon notify-report-tenant')]/div/div[1]")));
		Assert.assertEquals("Validating the Parent Tenant Banner :",
				"Viewing Reporting Tenant Event: "+childTenant, OrgBanner);
		driver.switchTo().defaultContent();
	}

	public void verifyNEPBanner(String pageType, String action) {
		if (action.equals("Create")) {
			driver.switchTo().defaultContent();
			eventCreationPage.verifyNewEventPageBackBanner();
			System.out.println("Create Event -- NEP Banner -- Verified");
			driver.switchTo().frame("eventPageIFrame");
		}
		if (action.equals("Show")) {
			eventCreationPage.verifyNewEventPageBackBanner();
			System.out.println("Show Event -- NEP Banner -- Verified");
		}
		if (action.equals("Edit")) {
			eventInfoPage.clickEdit();
			eventCreationPage.verifyNewEventPageBackBanner();
			System.out.println("Edit Event -- NEP Banner -- Verified");
		}
		if (action.equals("Clone")) {
			eventCreationPage.clickBackButton();
			eventInfoPage.clickClone();
			eventCreationPage.verifyNewEventPageBackBanner();
			System.out.println("Clone Event -- NEP Banner -- Verified");
		}

	}

	public void validateAncillaryLocation() {
		eventEditPage.validateAncillaryLocation();
	}

	public void validateAttachmentInfo(String attachmentType) {
		driverActions.hardwaitBasedOnInput(2000);
		eventInfoPage.validateAttachmentsOnEventInfoPage(attachmentType);
//		driver.navigate().refresh();
//		driverActions.hardwaitBasedOnInput(8000);
//		driver.switchTo().parentFrame();
//		driver.switchTo().frame("eventPageIFrame");
		eventInfoPage.clickEditEvent();
		driver.switchTo().defaultContent();
		eventEditPage.validateAttachmentOnEventEditPage(attachmentType);
	}

	public void cloneEvent(String action, String tenantType, String featureName, DataTable eventData)
			throws IOException {
		if (action.equalsIgnoreCase("clone")) {
			eventInfoPage.clickClone();
			List<Map<String, String>> list = eventData.asMaps(String.class, String.class);
			String equipmentType = list.get(0).get("EquipmentType");
			String customerName = list.get(0).get("CustomerName");
			String crosswalk = list.get(0).get("Crosswalk");
			String parent = driver.getWindowHandle();
			Set<String> s = driver.getWindowHandles();
			for (String child_window : s) {
				if (!parent.equals(child_window)) {
					driver.switchTo().window(child_window);
				}
			}
			driver.switchTo().parentFrame();
			driver.switchTo().frame("eventPageIFrame");
			eventCreationPage.selectEpuipmentAndDriver(customerName, featureName, equipmentType, crosswalk);
			eventInfoFromCreation.setEquipmentType(equipmentType);
			eventCreationPage.selectEquipmentNumber(featureName);
			eventInfoFromCreation.setCustomerName(customerName);
		}
		if (action.equalsIgnoreCase("void")) {
			List<Map<String, String>> list1 = eventData.asMaps(String.class, String.class);
			String voidReason = list1.get(0).get("VoidReason");
			String voidStatus = list1.get(0).get("VoidStatus");
			eventInfoPage.voidEvent(voidReason, voidStatus);
			eventInfoFromCreation.setVoidStatus(voidStatus);
			driver.switchTo().defaultContent();
		}
		if (action.equalsIgnoreCase("edit")) {
			eventInfoPage.clickEdit();
			driverActions.hardwaitBasedOnInput(5000);
			driver.switchTo().frame("eventPageIFrame");
			List<Map<String, String>> list = eventData.asMaps(String.class, String.class);
			String equipmentType = list.get(0).get("EquipmentType");
			String customerName = list.get(0).get("CustomerName");
			String truckDispatch = list.get(0).get("TruckDispatch");
			String equipmentProvider = list.get(0).get("EquipmentProvider");
			String equipmentProviderType = list.get(0).get("EquipmentProviderType");
			String crosswalk = list.get(0).get("Crosswalk");
			eventCreationPage.selectEpuipmentAndDriver(featureName, customerName, equipmentType, crosswalk);
			if (equipmentType.equalsIgnoreCase("Chassis") || equipmentType.equalsIgnoreCase("Container")) {
				eventCreationPage.selectEditEventNumber(Inandoutstream.loadchassisnumber(duplicatechassisNumber));
			}
			if (equipmentType.equalsIgnoreCase("Power Unit")) {
				eventCreationPage.selectEditEventNumber(Inandoutstream.loadtractornumber(duplicatetractorNumber));
			}
			eventInfoFromCreation.setCustomerName(customerName);
			driver.switchTo().defaultContent();
		}
		if (action.equalsIgnoreCase("PLT")) {
			eventInfoPage.clickEdit();
			driverActions.hardwaitBasedOnInput(5000);
			driver.switchTo().parentFrame();
			driver.switchTo().frame("eventPageIFrame");
			List<Map<String, String>> list = eventData.asMaps(String.class, String.class);
			String groupCode = list.get(0).get("GroupCode");
			String groupDesc = list.get(0).get("GroupDescription");
			String laborCode = list.get(0).get("LaborCode");
			if (featureName.equalsIgnoreCase("AddLabor")) {
				eventInfoPage.addLabor(laborCode);
			} else {
				eventInfoPage.addPLT(groupCode, groupDesc);
			}
			driver.switchTo().defaultContent();
		}
	}

	public void addCustomFields(String tenant) {
		eventInfoPage.clickEdit();
		eventCreationPage.add_CustomFields();
	}

	public void assertDashboardStatus(String status, String statusType) throws IOException {
		String eventNumber=inandoutstream.loadScheduleEventID();
		switch (statusType) {
			case "eventStatus":
				assertEquals(status, dashboardPage.getValueOnDashboardTable("Status"));
				break;
			case "Org":
				if (status.equalsIgnoreCase("draft")) {
					dashboardPage.switchTabTo("draft");
				}
				assertEquals(status, dashboardPage.getValueOnDashboardTable("Status"));
				break;
			case "techStatus":
				dashboardPage.showHideColumn("Technician Status", "Show");
				assertEquals(status, dashboardPage.getValueOnDashboardTable("Technician Status"));
				break;
			case "ReassignedValidation": {
				driver.findElement(By.xpath("//*[@id='incidents-tab']//a[contains(@href,'#reassigned')]")).click();
				driverActions.hardwaitBasedOnInput(2000);
				WebElement searchBox = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
				wait.forElementToBeDisplayed(searchBox);
				driverActions.hardwaitBasedOnInput(2000);
				searchBox.clear();
				driverActions.driverSendKeys(searchBox, last5Numbers);
				driverActions.hardwaitBasedOnInput(2000);
				String tableDashStatus = "";
				List<WebElement> thList = driver
						.findElements(By.xpath("//*[@id='incidents-datatable_wrapper']//table[@role='grid']/thead/tr/th"));
				for (int i = 1; i < thList.size() - 1; i++) {
					String headerSearch = "(//div[@class='dataTables_scrollHeadInner']/table/thead/tr/th[" + i + "])[2]";
					System.out.println(driverActions.driverGetText(driver.findElement(By.xpath(headerSearch))));
					if (driverActions.driverGetText(driver.findElement(By.xpath(headerSearch)))
							.equalsIgnoreCase("Status")) {
						String valueSearch = "(//div[@class='dataTables_scrollBody']//tr[@class='odd' and @role='row']/td["
								+ i + "])";
						tableDashStatus = driverActions.driverGetText(driver.findElement(By.xpath(valueSearch)));
						break;
					}
				}
				assertEquals(status, tableDashStatus);
				WebElement event = driver.findElement(By.xpath("//table[@id='event-snapshot-datatable']/tbody/tr/td[1]/a"));
				jsActions.jsclick(event);
				driverActions.hardwaitBasedOnInput(2000);
				driver.switchTo().parentFrame();
				driver.switchTo().frame("eventPageIFrame");
				WebElement reassignedStatus = driver
						.findElement(By.xpath("//div[@class='status-void status-reassigned']/span"));
				assertEquals(status.toLowerCase(), driverActions.driverGetText(reassignedStatus).toLowerCase());
				driver.switchTo().defaultContent();
				break;
			}
			case "RejectedValidation": {
				driver.findElement(By.xpath("//*[@id='incidents-tab']//a[contains(@href,'#rejected')]")).click();
				driverActions.hardwaitBasedOnInput(2000);
				WebElement searchBox = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
				wait.forElementToBeDisplayed(searchBox);
				driverActions.hardwaitBasedOnInput(2000);
				searchBox.clear();
				driverActions.driverSendKeys(searchBox, eventNumber);
				driverActions.hardwaitBasedOnInput(2000);
				String tableDashStatus = "";
				List<WebElement> thList = driver
						.findElements(By.xpath("//*[@id='incidents-datatable_wrapper']//table[@role='grid']/thead/tr/th"));
				for (int i = 1; i < thList.size() - 1; i++) {
					String headerSearch = "(//div[@class='dataTables_scrollHeadInner'])[2]/table/thead/tr/th[" + i + "]";
					driverActions.hardwaitBasedOnInput(3000);
					System.out.println(driverActions.driverGetText(driver.findElement(By.xpath(headerSearch))));
					if (driverActions.driverGetText(driver.findElement(By.xpath(headerSearch)))
							.equalsIgnoreCase("Status")) {
						String valueSearch = "(//div[@class='dataTables_scrollBody']//tr[@class='odd' and @role='row']/td["
								+ i + "])[2]";
						tableDashStatus = driverActions.driverGetText(driver.findElement(By.xpath(valueSearch)));
						break;
					}
				}
				assertEquals(status, tableDashStatus);
				WebElement event = driver.findElement(By.xpath("//table[@id='event-snapshot-datatable']/tbody/tr/td[1]/a"));
				jsActions.jsclick(event);
				driverActions.hardwaitBasedOnInput(2000);
				driver.switchTo().parentFrame();
				driver.switchTo().frame("eventPageIFrame");
				WebElement rejectedStatus = driver
						.findElement(By.xpath("//div[@class='status-void status-reassigned']/span"));
				assertEquals(status.toLowerCase(), driverActions.driverGetText(rejectedStatus).toLowerCase());
				break;
			}
			default:
				assertEquals(status, eventInfoFromDashboard.getStatus());
				break;
		}
	}

	public void selectPaymentMethod(String action, DataTable dataTable) {
		if (action.equalsIgnoreCase("Select")) {
			eventCreationPage.clickPaymentMethod();
			List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
			String paymentMethod = list.get(0).get("PaymentMethod");
			if (paymentMethod.equalsIgnoreCase("Default")) {
				eventCreationPage.selectDefaultPaymentMethod();
			}
			if (paymentMethod.equalsIgnoreCase("Cash")) {
				eventCreationPage.selectCashPaymentMethod();
			}
			if (paymentMethod.equalsIgnoreCase("Check")) {
				eventCreationPage.selectCheckPaymentMethod();
			}
		}
		if (action.equalsIgnoreCase("DeSelect")) {
			eventCreationPage.clickPaymentMethod();
			List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
			String paymentMethod = list.get(0).get("PaymentMethod");
			if (paymentMethod.equalsIgnoreCase("Default")) {
				eventCreationPage.deselectDefaultPaymentMethod();
			}
			if (paymentMethod.equalsIgnoreCase("Cash")) {
				eventCreationPage.selectCashPaymentMethod();
			}
		}

	}

	public void deletedraftevent(String action) throws InterruptedException, IOException {

		dashboardPage.switchTabTo("draft");
		driverActions.hardwaitBasedOnInput(4000);
		String eventID = inandoutstream.loadScheduleEventID();
		dashboardPage.searchDraftEvent(eventID);
		driverActions.hardwaitBasedOnInput(4000);
		eventCreationPage.action();
		driverActions.hardwaitBasedOnInput(4000);
		if (action.equalsIgnoreCase("Delete")) {
			eventCreationPage.deleteevent();
		} else {
			eventCreationPage.createDraftevent();
			wait.forLoading();
			driver.get(PropsReader.tdURL);
		}
		driverActions.hardwaitBasedOnInput(3000);
		driver.navigate().refresh();
		driverActions.hardwaitBasedOnInput(5000);
		String emptyTrMessage = driverActions
				.driverGetText(driver.findElement(By.xpath("//div[@class='dataTables_scrollBody']/table/tbody/tr/td")));
		System.out.println(emptyTrMessage);
		Assert.assertEquals("Empty TableRow message validated:", "No matching records found", emptyTrMessage);
		if ((Drafteventid == null)) {
			System.out.println("Draft Event successfully deleted");
		}
	}

	public void createEventUsingTemplate(String tenant, DataTable eventData) throws IOException {
		List<Map<String, String>> list = eventData.asMaps(String.class, String.class);
		String equipmentType = list.get(0).get("EquipmentType");
		driver.get(PropsReader.fleetURL);

		driverActions.hardwaitBasedOnInput(2000);
		eventCreationPage.eventTemplate(equipmentType);
		driverActions.hardwaitBasedOnInput(5000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		eventInfoFromCreation.setEquipmentType(equipmentType);
		eventInfoFromCreation.setAssociatedTractorNumber("BABA102030");
		driverActions.hardwaitBasedOnInput(3000);
		eventServicePage.clickSaveBtn("create");
		wait.forLoading();
		driver.switchTo().defaultContent();
		for (int i = 0; i < 50; i++) {
			if (driver.getCurrentUrl().contains("next/new")) {
				driverActions.hardwaitBasedOnInput(3000);
			} else {
				break;
			}
		}
		assertFalse(driver.getCurrentUrl().contains("next/new"));
		assertFalse(driver.getCurrentUrl().contains("/event/incidents/next/new"));
		System.out.println("Asserted the create event url : " + driver.getCurrentUrl());
		eventId = driver.getCurrentUrl().split("incidents/")[1];
		System.out.println(eventId);
	}

	public void createValidateAgentAssignmentTask(String action, String user, String tenant) throws IOException {
		tenantLogoutPage.sclogout();
		loginUsers(user);
		if (action.equalsIgnoreCase("Create")) {
			eventInfoPage.createAgentAssignmntTaskonEventInfoPage(user);
		}
		if (action.equalsIgnoreCase("Validate")) {
			if (user.contains("Observer") || user.contains("Accountant")) {
				eventInfoPage.validateNoAgentAssignment(user);
			} else if (user.contains("Admin") || user.equalsIgnoreCase("Supervisor") || user.equalsIgnoreCase("User")) {
				eventInfoPage.validateAgentAssignment(user);
			}
		}
		if (action.equalsIgnoreCase("Claim")) {
			eventInfoPage.claimAgentAssignmntTaskonEventInfoPage(user);
		}
		beforeScenarios.loginTenant(tenant);
	}

	public void createEventsBatchUpload(String tenant, String fileName){
		try {
			switch (tenant.toUpperCase()) {

				case "TD2":
					driver.get(PropsReader.td2URL);
					break;

				case "SP2":
					driver.get(PropsReader.sp2URL);
					break;

				case "CC1":
					driver.get(PropsReader.cc1URL);
					break;

				case "FLEET":
					driver.get(PropsReader.fleetURL);
					break;

				default:
					throw new Reach24NEPCustomException("Invalid Tenant selected");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}
		dashboardPage.selectBatchUpload();
		eventServicePage.uploadBatchUploadAttachments(driver,fileName);
	}

	public void loginUsers(String user) {
		if (user.equalsIgnoreCase("AutoTruck TD1 Accountant")) {
			tenantLoginPage.enterUserName(PropsReader.td1AccountantUserName);
			tenantLoginPage.enterPassword(PropsReader.td1Password);
			tenantLoginPage.clickLoginButton();
			return;
		}
		if (user.equalsIgnoreCase("AutoTruck CC1 Observer")) {
			driver.get(PropsReader.cc1URL);
			tenantLoginPage.enterUserName(PropsReader.cc1ObserverUserName);
			tenantLoginPage.enterPassword(PropsReader.cc1Password);
			tenantLoginPage.clickLoginButton();
			return;
		}
		if (user.equalsIgnoreCase("AutoTruck SP3 Supervisor")) {
			driver.get(PropsReader.sp3URL);
			tenantLoginPage.enterUserName(PropsReader.sp3SupervisorUserName);
			tenantLoginPage.enterPassword(PropsReader.sp3Password);
			tenantLoginPage.clickLoginButton();
			return;
		}
		if (user.equalsIgnoreCase("AutoTruck TD1 Admin1")) {
			tenantLoginPage.enterUserName(PropsReader.td1Admin1UserName);
			tenantLoginPage.enterPassword(PropsReader.td1Password);
			tenantLoginPage.clickLoginButton();
			return;
		}
		if (user.equalsIgnoreCase("AutoTruck TD1 User")) {
			tenantLoginPage.enterUserName(PropsReader.td1ObserverUserName);
			tenantLoginPage.enterPassword(PropsReader.td1Password);
			tenantLoginPage.clickLoginButton();
			return;
		}

	}

	public void viewCreateAgentAssignment(String action, String agent, String tenant) {
		tenantLogoutPage.sclogout();
		loginUsers(agent);
		if (action.equalsIgnoreCase("Create")) {
			dashboardPage.createAgentAssignmentOnEventDashboardPage(agent);
		} else if (action.equalsIgnoreCase("View")) {
			dashboardPage.viewAgentAssignmentOnEventDashboardPage(agent);
		}
		eventInfoPage.logOutUser(agent);
		beforeScenarios.loginTenant(tenant);
	}

	public void deleteTheUser(String agent) {
		dashboardPage.deleteUser(agent);
	}

	public void verifyActiveInactiveStatus(String user) {
		dashboardPage.verifyActiveInactiveStatusOnDashboardPage(user);
	}

	public void waitForApproval() {
		try {
			Thread.sleep(75000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void loginastenant(String tenant) {
		try {
			switch (tenant.toUpperCase()) {

			case "TD":
				driver.get(PropsReader.tdEventInfoPage);
				break;

			case "SP5":
				driver.get(PropsReader.sp5EventInfoPage);
				break;

			case "SP":
				driver.get(PropsReader.spEventInfoPage);
				break;

			case "CC":
				driver.get(PropsReader.ccEventInfoPage);
				break;

			default:
				throw new Reach24NEPCustomException("Invalid Tenant selected");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}

	}

	public void validateTerminal(String tenantType) {

		if (tenantType.equalsIgnoreCase("TD")) {
			eventCreationPage.validateTerminalOnEventShowPage();
		} else {
			eventCreationPage.validateTerminalOnEventShowPage1();
		}
	}

	public void createEventTemplate(String eventType, String tenantType, String featureName, DataTable eventData,
			boolean advanceSearch) throws InterruptedException, IOException, AWTException {
		List<Map<String, String>> list = eventData.asMaps(String.class, String.class);
		String equipmentType = list.get(0).get("EquipmentType");
		String Driver = list.get(0).get("Driver");
		String address = list.get(0).get("Reported Location");
		String Caller = list.get(0).get("Reported by user");
		String crosswalk = list.get(0).get("Crosswalk");
		String customerName = list.get(0).get("CustomerName");
		String type = list.get(0).get("EquipmentProvider");
		String chassNumber = list.get(0).get("EquipmentNumber");
		String tempname = list.get(0).get("TemplateName");

		tenantType = tenantType.toUpperCase();
		try {
			switch (tenantType) {

			case "TD":
				driver.get(PropsReader.tdURL);
				break;
			case "SP":
				driver.get(PropsReader.spURL);
				break;
			case "CC":
				driver.get(PropsReader.ccURL);
				break;

			default:
				throw new Reach24NEPCustomException("Invalid Tenant selected");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}
		driverActions.hardwaitBasedOnInput(5000);
		eventCreationPage.clickEventTempDropdown();
		int size = driver.findElements(By.xpath("//li[@class='li-template-title']")).size();
		System.out.println(size);
		for (int i = 1; i <= size; i++) {
			driver.navigate().refresh();
			driverActions.hardwaitBasedOnInput(5000);
			eventCreationPage.clickEventTempDropdown();
			driverActions.hardwaitBasedOnInput(2000);
			WebElement templateName = driver.findElement(By.xpath("(//li[@class='li-template-title'])[1]/a"));
			String name = driverActions.driverGetText(templateName);
			System.out.println(name);
			if (name.equalsIgnoreCase(tempname)) {
				driverActions.hardwaitBasedOnInput(1000);
				WebElement deleteIcon = driver.findElement(By.xpath("(//li[@class='li-template-title'])[1]/span/a[2]"));
				Actions actions = new Actions(driver);
				actions.moveToElement(deleteIcon).click().build().perform();
				driverActions.hardwaitBasedOnInput(2000);
				driver.findElement(By.xpath("//div[@class='sa-confirm-button-container']")).click();

			}
		}
		driver.navigate().refresh();
		driverActions.hardwaitBasedOnInput(5000);
		eventCreationPage.clickEventTempDropdown();
		eventCreationPage.newTemplate();
		driverActions.hardwaitBasedOnInput(4000);
		driver.switchTo().frame("eventPageIFrame");
		if (equipmentType.equalsIgnoreCase("Chassis") || (equipmentType.equalsIgnoreCase("Container"))) {
			eventCreationPage.selectEquipmentType(equipmentType);
			eventCreationPage.selectEquipmentNumber(type);
			eventCreationPage.reportedLocation(address);
		}
		if (equipmentType.equalsIgnoreCase("Power Unit") || (equipmentType.equalsIgnoreCase("Trailer"))) {
			eventCreationPage.addWalkinDetails(crosswalk);
			eventCreationPage.selectEquipmentType(equipmentType);
			eventCreationPage.selectDropLocationCheckBox();
		}
		if (equipmentType.equalsIgnoreCase("Snow Scraper")) {
			eventCreationPage.selectEquipmentType(equipmentType);
			eventCreationPage.selectCrossWalk(crosswalk);
			eventCreationPage.selectShipperTenant();

		}
		eventCreationPage.testTemplate(tempname);
		if (tenantType.equalsIgnoreCase("SP") || (tenantType.equalsIgnoreCase("CC"))) {
			eventServicePage.clickSaveTemplate();
			driver.switchTo().defaultContent();

		}
	}

	public void verifyEventTemplate(DataTable dataTable, String tenantType) throws IOException {
		List<Map<String, String>> tableData = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : tableData) {
			String equipmentType = row.get("EquipmentType");
			String type = row.get("EquipmentProvider");
			String driver = row.get("Driver");
			String address = row.get("ReportedLocation");
			String priority = row.get("Priority");
			String caller = row.get("Reported by user");
			String walkin = row.get("Walkin");
			String crosswalk = row.get("Crosswalk");
			String shipper = row.get("Shipper");
			eventCreationPage.clickEventTempDropdown();
			eventCreationPage.viewTemplate();
			driverActions.hardwaitBasedOnInput(4000);
			if (tenantType.equalsIgnoreCase("TD")) {
				eventCreationPage.validateTemplatefields1(equipmentType, priority, address, walkin);
			}
			if (tenantType.equalsIgnoreCase("SP")) {
				eventCreationPage.validateTemplatefields2(equipmentType, crosswalk);
			}
			if (tenantType.equalsIgnoreCase("CC")) {
				eventInfoPage.crossWalkTemplateValidation(crosswalk);
				eventCreationPage.validateShipperTemplate(shipper);
			}
		}
	}

	public void updateEventTemplate(DataTable eventData, String tenantType) throws IOException {
		List<Map<String, String>> list = eventData.asMaps(String.class, String.class);
		for (Map<String, String> row : list) {
			String equipmentType = list.get(0).get("EquipmentType");
			wait.forLoading();
			if (tenantType.equalsIgnoreCase("TD")) {
				driver.get(PropsReader.tdURL);
			}
			if (tenantType.equalsIgnoreCase("SP")) {
				driver.get(PropsReader.spURL);

			}
			if (tenantType.equalsIgnoreCase("CC")) {
				driver.get(PropsReader.ccURL);
			}

			eventCreationPage.clickEventTempDropdown();
			eventCreationPage.editTemplate();
			driverActions.hardwaitBasedOnInput(4000);
			driver.switchTo().frame("eventPageIFrame");
			eventCreationPage.selectEquipmentType(equipmentType);
			driverActions.hardwaitBasedOnInput(2000);
			if (list.get(0).get("Customfields") != null) {
				eventCreationPage.templateCustomFields();
			}
			if (list.get(0).get("BreakdownLocation") != null) {
				eventCreationPage.templateBreakDownNotes();
			}
			eventCreationPage.clickUpdateTemplate();
			driver.switchTo().defaultContent();
			eventCreationPage.clickDeleteTemplate();
		}
	}

	public void validateTowingServices(String type, String towingDestination, String mileage) {
		eventServicePage.validateTowingServices(type, towingDestination, mileage);
	}

	public void reEvaluateTowingServices(String towingDestination, String mileage) {
		eventServicePage.reEvaluateTowingServices(towingDestination, mileage);
	}

	public void validateShipper() {
		eventInfoPage.validateShipperOnInfoPage();
	}

	public void closeOpenDoor(String action, String tenant) {
		eventInfoPage.clickDoorCloseOpen(action, tenant);
	}

}
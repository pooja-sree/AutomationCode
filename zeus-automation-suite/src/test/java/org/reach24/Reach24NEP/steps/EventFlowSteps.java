package org.reach24.Reach24NEP.steps;

import java.io.IOException;
import java.sql.DriverAction;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.reach24.Reach24NEP.actions.DriverActions;
import org.reach24.Reach24NEP.actions.JsActions;
import org.reach24.Reach24NEP.dtos.EventDetailsDTO;
import org.reach24.Reach24NEP.pages.*;
import org.reach24.Reach24NEP.util.*;

import io.cucumber.datatable.DataTable;

public class EventFlowSteps extends BasePage {
	EventInfoPage eventInfoPage = new EventInfoPage(driver);
	EventCreationPage eventCreationPage = new EventCreationPage(driver);
	EventServicesPage eventServicePage = new EventServicesPage(driver);
	SuperAdminLoginPage superAdminLoginPage = new SuperAdminLoginPage(driver);
	TenantInfoPage tenantInfoPage = new TenantInfoPage(driver);
	DashboardPage dashboardPage = new DashboardPage(driver);
	Inandoutstream inandoutstream = new Inandoutstream();
	BeforeAndAfterScenarios beforeScenarios = new BeforeAndAfterScenarios();
	ReusableMethods reuse = new ReusableMethods();
	JsActions jsaction = new JsActions(driver);
	static EventDetailsDTO eventInfoFromTenant = new EventDetailsDTO();

	public void assignEventToTenant(String action, String eventTenantType, String tenent, String payment)
			throws Exception, Exception {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().parentFrame();
		driver.switchTo().frame("eventPageIFrame");
		if(payment.equalsIgnoreCase("BridgeStoneOEM")){
			eventInfoPage.verifyBridgestoneBillToDetails();
		}
		if (action.equalsIgnoreCase("UnderRadius1")) {
			eventInfoPage.clickFSCInRadiusBtn("in 75 mile radius");
			eventInfoPage.clickUnderRadiusTab();
			eventInfoPage.searchSP2(tenent);
			String emptyClass = driver.findElement(By.xpath("(//tbody[@class='ant-table-tbody']/tr[2])[2]/td[1]/div"))
					.getAttribute("class");
			Assert.assertTrue(emptyClass.equalsIgnoreCase("ant-empty ant-empty-normal"));
			WebElement closeFSC = driver
					.findElement(By.xpath("(//span[@class='anticon anticon-close ant-modal-close-icon'])[2]"));
			closeFSC.click();
			driver.switchTo().defaultContent();
			return;
		}
		if (action.equalsIgnoreCase("UnderRadius2")) {
			eventInfoPage.clickFSCInRadiusBtn("in 100 mile radius");
			eventInfoPage.clickUnderRadiusTab();
			driver.findElement(By
					.xpath("(//div[@class='ant-tabs-content-holder'])[2]/div/div[5]/div[1]/div/span/span/span/button"))
					.click();
			eventInfoPage.assignSP2(tenent);
			eventInfoPage.paymentMethod(action, payment);
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("AssignMap")) {
			eventInfoPage.assignSPMap(tenent);
			if (payment.equalsIgnoreCase("cash")) {
				eventInfoPage.paymentMethod(action, payment);
			}
			if (payment.equalsIgnoreCase("check")) {
				eventInfoPage.paymentMethodCheck(action, payment);
			}
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		eventInfoPage.clickFSC();

		if (action.equalsIgnoreCase("AssignAll")) {
			eventInfoPage.clickAllTab();
			eventInfoPage.searchSP2(tenent);
			eventInfoPage.assignSPtenant2(tenent);
			eventInfoPage.paymentMethod(action, payment);
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("AssignAllcc")) {
			eventInfoPage.clickAllTab();
			eventInfoPage.searchSP2(tenent);
			eventInfoPage.assignSP3(tenent);
			eventInfoPage.paymentMethod(action, payment);
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("SPAuthority")) {
			eventInfoPage.clickSPAuthorityTab();
			eventInfoPage.searchSP2(tenent);
			eventInfoPage.assignSP2(tenent);
			eventCreationPage.clickIgnoreCont();
			eventInfoPage.paymentMethod(action, payment);
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("FSCEPApproved")) {
			eventInfoPage.clickEPApprovedTab();
			eventInfoPage.assignSP2(tenent);
			eventCreationPage.clickIgnoreCont();
			eventInfoPage.paymentMethod(action, payment);
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("Override")) {
			eventInfoPage.clickOverrideSearch(tenent);
			eventInfoPage.assignAnyway();
			eventInfoPage.paymentMethod(action, payment);
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("OverrideNPSP")) {
			eventInfoPage.clickOverrideSearch(tenent);
			eventInfoPage.assignAnywayNPSP();
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("AssignDefault")) {
			eventInfoPage.clickDefaultTab(tenent);
			if (payment.equalsIgnoreCase("cash")) {
				eventInfoPage.paymentMethod(action, payment);
			}
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("AssignRSP")) {
			eventInfoPage.clickReportingSPTab(tenent);
			if (payment.equalsIgnoreCase("cash")) {
				eventInfoPage.paymentMethod(action, payment);
			}
			if (payment.equalsIgnoreCase("check")) {
				eventInfoPage.paymentMethodCheck(action, payment);
			}
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("AssignOEM")) {
			eventInfoPage.clickOEMSPTab(tenent);
			if (payment.equalsIgnoreCase("cash")) {
				eventInfoPage.paymentMethod(action, payment);
			}
			if (payment.equalsIgnoreCase("check")) {
				eventInfoPage.paymentMethodCheck(action, payment);
			}
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("Assigncc")) {
			if (eventTenantType.equalsIgnoreCase("CC")) {
				eventInfoPage.assignSP12(tenent);
			} else {
				eventInfoPage.assignSP1(tenent);
			}

			if (payment.equalsIgnoreCase("cash")) {
				eventInfoPage.paymentMethod(action, payment);
			}
			if (payment.equalsIgnoreCase("check")) {
				eventInfoPage.paymentMethodCheck(action, payment);
			}
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("AssignRPSP")) {
			eventInfoPage.assignSPRPSP(tenent);
			eventInfoPage.assignAnyway();
			if (payment.equalsIgnoreCase("cash")) {
				eventInfoPage.paymentMethod(action, payment);
			}
			if (payment.equalsIgnoreCase("check")) {
				eventInfoPage.paymentMethodCheck(action, payment);
			}
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}
		eventInfoPage.searchSP(tenent);

		if (action.equalsIgnoreCase("AssignPLT")) {
			eventInfoPage.assignSPtenant1(tenent);
			if (payment.equalsIgnoreCase("cash")) {
				eventInfoPage.paymentMethod(action, payment);
			}
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}
		if (action.equalsIgnoreCase("AssignNonWorkingHours")) {
			eventInfoPage.assignSPtenant1(tenent);
			eventInfoPage.ValidateFscPopUpNonWorkingHours();
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("Available-afterHours")) {
			eventInfoPage.assignSPtenant1(tenent);
			eventInfoPage.ValidateFscPopUpAfterHours();
			driver.switchTo().defaultContent();
			return;
		}
		if (action.equalsIgnoreCase("AssignDoorClosed")) {
			eventInfoPage.assignSPtenant1(tenent);
			eventInfoPage.ValidateFscPopUpDoorClosed();
			driver.switchTo().defaultContent();
			return;
		}
		if (action.equalsIgnoreCase("Available")) {
			eventInfoPage.assignSPtenant1(tenent);
			eventInfoPage.ValidateFscPopUpAvaiable();
			driver.switchTo().defaultContent();
			return;
		}

		if (action.equalsIgnoreCase("Reassign")) {
			eventInfoPage.assignSPAnyway(eventTenantType);
			if (payment.equalsIgnoreCase("cash")) {
				eventInfoPage.paymentMethod(action, payment);
			}
			if (payment.equalsIgnoreCase("check")) {
				eventInfoPage.paymentMethodCheck(action, payment);
			}
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (eventTenantType.equalsIgnoreCase("SPHQ-Org")) {
			eventInfoPage.assignSP(tenent);
			eventInfoPage.assignAnyway();
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (tenent.equalsIgnoreCase("Auto RPO NPSP")) {
			eventInfoPage.verifyRPONPSPLogo();
			eventInfoPage.assignTenant(tenent);
			eventCreationPage.handleAssignAnyway();
			if (payment.equalsIgnoreCase("cash")) {
				eventInfoPage.paymentMethod(action, payment);
			}
			if (payment.equalsIgnoreCase("check")) {
				eventInfoPage.paymentMethodCheck(action, payment);
			}
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}

		if (tenent.equalsIgnoreCase("AutoTruck SP") || tenent.equalsIgnoreCase("AutoTruck SP5")) {
			if (action.equalsIgnoreCase("AssignSecondTime")) {
				eventInfoPage.assignSPtenant1(tenent);
				eventInfoPage.paymentMethod(action, payment);
				eventInfoPage.eventAssignValidation(tenent);
				driver.switchTo().defaultContent();
				return;
			}
			eventInfoPage.assignSPtenant1(tenent);
			if (eventTenantType.equalsIgnoreCase("TD-Schedule")) {
				eventInfoPage.scheduleEventAssignSP();
			}
			if (eventTenantType.equalsIgnoreCase("TD-Schedule(2)")) {
				eventInfoPage.validateTimeSlot();
				driver.switchTo().defaultContent();
				return;
			}
			if (eventTenantType.equalsIgnoreCase("TD-Schedule-Wo-TimeSlot")) {
				inandoutstream.saveScheduledTimeSlot(" ");
				eventInfoPage.clickContinue();
			}
			if (action.equalsIgnoreCase("AssignDuplicate")) {
				eventCreationPage.clickIgnoreCont();
			}
			if (payment.equalsIgnoreCase("cash")) {
				eventInfoPage.paymentMethod(action, payment);
			}
			eventInfoPage.eventAssignValidation(tenent);
			driver.switchTo().defaultContent();
			return;
		}
		eventInfoPage.assignSP(tenent);
		if (tenent.equalsIgnoreCase("TestCallForward")) {
			eventCreationPage.handleAssignAnyway();
		}
		if (tenent.equalsIgnoreCase("TestCallForwardCC")) {
			eventCreationPage.handleAssignAnyway();
		}
		if (action.equalsIgnoreCase("AssignDuplicate")) {
			eventCreationPage.clickIgnoreCont();
		}
		if (payment.equalsIgnoreCase("yes")) {
			eventInfoPage.paymentMethod(action, payment);
		}
		if (payment.equalsIgnoreCase("cash")) {
			eventInfoPage.paymentMethod(action, payment);
		}
		if (payment.equalsIgnoreCase("continental")) {
			eventInfoPage.paymentMethodContinental(action, payment);
		}
		if (payment.equalsIgnoreCase("check")) {
			eventInfoPage.paymentMethodCheck(action, payment);
		}
		if (payment.equalsIgnoreCase("OEM")) {
			eventInfoPage.paymentMethodOEM(action, payment);
		}
		if (payment.equalsIgnoreCase("Reach")) {
			eventInfoPage.paymentMethodReach(action, payment);
		}
		if (payment.equalsIgnoreCase("Tire Warranty")) {
			eventInfoPage.paymentMethodTireWarranty(action, payment);
		}
		eventInfoPage.eventAssignValidation(tenent);
		driver.switchTo().defaultContent();
	}

	public void eventActionBy(String Action, String Tenant) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (Action.equalsIgnoreCase("Accept")) {
			eventInfoPage.acceptwithETA();
		} else if (Action.equalsIgnoreCase("Reject")) {
			eventInfoPage.clickReject();
		} else if (Action.equalsIgnoreCase("Reject2")) {
			eventInfoPage.clickReject2();
		} else if (Action.equalsIgnoreCase("Repair")) {
			eventInfoPage.clickRepaired();
		} else if (Action.equalsIgnoreCase("Complete")) {
			eventInfoPage.clickComplete();
		} else if (Action.equalsIgnoreCase("Complete2")) {
			eventInfoPage.clickComplete2();
		} else if (Action.equalsIgnoreCase("Approve")) {
			eventInfoPage.clickApprove();
		} else if (Action.equalsIgnoreCase("Reprocess")) {
			eventInfoPage.clickReprocess();
		} else if (Action.equalsIgnoreCase("TechAccept")) {
			eventInfoPage.clickTechAccept();
		} else if (Action.equalsIgnoreCase("TechReject")) {
			eventInfoPage.clickTechReject();
		} else if (Action.equalsIgnoreCase("TechEnroute")) {
			eventInfoPage.clickTechEnroute();
		} else if (Action.equalsIgnoreCase("TechArrive")) {
			eventInfoPage.clickTechArrive();
		} else if (Action.equalsIgnoreCase("TechRepair")) {
			eventInfoPage.clickTechRepair();
		} else if (Action.equalsIgnoreCase("Estimate")) {
			eventInfoPage.clickEstimate();
		} else if (Action.equalsIgnoreCase("TechAccept2")) {
			eventInfoPage.techAccept2();
		}else if (Action.equalsIgnoreCase("AcceptWithdraw")) {
		eventInfoPage.acceptWithdraw();
	}
	}

	public void AlertsMethodsConversationTab(String action, String tenanttype, String assignedTenant) {
		try {
			switch (action.toUpperCase()) {

			case "RAISE":
				eventInfoPage.HandleconversationstabRaiseRFA(assignedTenant);
				break;

			case "RESOLVE":
				eventInfoPage.HandleconversationstabResolveRFA();
				break;

			// case "ACKNOWLEDGE":
			// eventInfoPage.HandleconversationstabAckRFA();
			// break;
			//
			// case "CANCEL":
			// eventInfoPage.HandleconversationstabCancelRFA();
			// break;

			default:
				throw new Reach24NEPCustomException("Invalid Action");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}
	}

	public void resolve_RFAinHotTab(String tenantType) {
		eventInfoPage.resolveRFAinHotTab();

	}

	public void assignTech(String tenantType, String technician) {
		try {
			switch (tenantType.toUpperCase()) {

			case "TD":
				driver.get(PropsReader.tdEventInfoPage + EventCreationSteps.eventInfoFromTenant.getEventId());
				break;

			case "SP":
				driver.get(PropsReader.spEventInfoPage + EventCreationSteps.eventInfoFromTenant.getEventId());
				break;

			default:
				throw new Reach24NEPCustomException("Invalid Tenant");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}

		eventInfoPage.assignTechnician(technician);
	}

	public void rFA_Action(String action, String tab, DataTable table) {
		eventInfoPage.rFA_Action(action, tab, table);
	}

	public void validateCrosswalk(String tenant, DataTable crosswalkData) {
		List<Map<String, String>> list = crosswalkData.asMaps(String.class, String.class);
		String crosswalk = list.get(0).get("Crosswalk");
		if(tenant.equalsIgnoreCase("Bridgestone")){
			driver.switchTo().parentFrame();
			driver.switchTo().frame("eventPageIFrame");
			eventInfoPage.verifyBridgestoneBillToDetails();
			driver.switchTo().defaultContent();
			return;
		}
		eventInfoPage.crossWalkValidation(crosswalk);
	}

	public void ValidateWatchListEvent() {
		eventInfoPage.validateWatchedEvents();
	}

	public void enableDisableFeature(String tenantName, String featureName, String enableDisable) {
		beforeScenarios.loginSuperAdmin(driver);
		superAdminLoginPage.searchTenantBox(tenantName);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		superAdminLoginPage.clickLinkTenant(tenantName);
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

			}
		}
		Assert.assertEquals("Verify Tenant Name", tenantName, tenantInfoPage.getTenantName());

		tenantInfoPage.selectInfoEdit();
		System.out.println("Entering Information on Edit Tenant Info Page");
		if (enableDisable.equals("Enable")) {
			tenantInfoPage.enableFeature(featureName);
		} else if (enableDisable.equals("Disable")) {
			tenantInfoPage.disableFeature(featureName);
		}

		tenantInfoPage.clickBtnUpdate();
		driver.close();
		driver.switchTo().window(parent);
	}

	public void dashboardActionScheduledAction(String tenant, DataTable validations) throws IOException {
		tenant = tenant.toUpperCase();
		try {
			switch (tenant) {

			case "TD":
				driver.get(PropsReader.tdURL);
				break;

			case "SP5":
				driver.get(PropsReader.sp5URL);
				break;

			default:
				throw new Reach24NEPCustomException("Invalid Tenant selected");
			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}

		List<Map<String, String>> list = validations.asMaps(String.class, String.class);
		for (int i = 0; i < list.size(); i++) {
			String dropdown = list.get(i).get("Dropdown");
			String validate = list.get(i).get("Validate");
			driver.navigate().refresh();
			dashboardPage.selectDashboardTableDropdown(dropdown);
			// dashboardPage.validateDashboardTableRow(validate);
		}

	}

	public void scheduleEventAction(String tenant, String action) throws IOException {
		eventInfoPage.performScheduleEventAction(tenant, action);

	}

	public void validateCallforward(String forwardTo, String forwardFrom) {
		eventInfoPage.callForwardValidation(forwardTo, forwardFrom);
	}

	public void validateEPfromFleet(String tenantName) {
		eventInfoPage.validateEquipmentProvider(tenantName);
	}

	public void validationATDstatus(String status1, String status2, String status3, String status4) {
		eventInfoPage.validateAtdStatus(status1, status2, status3, status4);
	}

	public void techScheduler(String action, String techName, String tenantType) {
		try {
			switch (action.toUpperCase()) {
			case "ADD":
				eventCreationPage.techSchedularTab();
				eventCreationPage.addTechinTS(techName);
				break;

			case "EDIT":
				eventCreationPage.editTechinTS();
				break;

			case "DELETE":
				eventCreationPage.deleteTechinTS();
				break;

			default:
				throw new Reach24NEPCustomException("Invalid Tenant selected");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}
	}

	public void addShiftinTechSchedular(String action, String techName, String tenantType) {

		try {
			switch (action.toUpperCase()) {
			case "ADD":
				eventCreationPage.addShiftTS(techName);
				break;

			case "EDIT AND VERIFY":
				eventCreationPage.editAndVerifyShiftTS(techName);
				break;

			case "DELETE":
				eventCreationPage.deleteShiftTS();
				break;

			case "UPLOAD":
				eventCreationPage.uploadShift();
				break;

			default:
				throw new Reach24NEPCustomException("Invalid Tenant selected");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}
	}

	public void addAndVerifyNotesDay() {
		eventCreationPage.addGeneralNotes();
		// eventCreationPage.deleteTechnicianNotes();
	}

	public void copyShiftInTS() {
		eventCreationPage.copyPreviousWeekShiftInTS();
	}

	public void validateTechLog() {
		eventCreationPage.activityLog();
	}

	public void logTechArrival(String tenantName) {

		eventInfoPage.logTechArrival(tenantName);
	}

	public void prepareEstimate(DataTable estimates) {
		eventInfoPage.clickPrepareEstimateButton();
		List<Map<String, String>> list = estimates.asMaps(String.class, String.class);
		String estimateType;
		String amount;
		int totalGrossAmount = 0;
		int totalNetAmount = 0;
		int estimatedTotalAmount = 0;

		for (int i = 0; i <= list.size() - 1; i++) {
			estimateType = list.get(i).get("Estimate");
			amount = list.get(i).get("Amount");

			try {
				System.out.println(estimateType.toLowerCase());
				System.out.println(amount);
				switch (estimateType.toLowerCase()) {

				case "discount":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalNetAmount = totalNetAmount - Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount - Integer.parseInt(amount);
					break;

				case "taxable":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					break;

				case "nontaxable":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					break;

				case "tax":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount) + Integer.parseInt(amount);
					break;

				case "parts":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "labor":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "oil":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "newtires":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "usedtires":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "tradein":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalNetAmount = totalNetAmount - Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount - Integer.parseInt(amount);
					break;

				case "sublet":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "roadcall":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				case "envwastetax":
					eventInfoPage.enterValueForEstimates(estimateType, amount);
					totalGrossAmount = totalGrossAmount + Integer.parseInt(amount);
					totalNetAmount = totalNetAmount + Integer.parseInt(amount);
					estimatedTotalAmount = estimatedTotalAmount + Integer.parseInt(amount);
					break;

				default:
					throw new Reach24NEPCustomException("Invalid Action");

				}
			} catch (Reach24NEPCustomException e) {
				e.printStackTrace();
			}
		}
		eventInfoPage.clickSubmitEstimatesButton();
	}

	public void validatePreApprovalEstimation(String tenantName) {
		eventInfoPage.validateEstimationPreApproval(tenantName);
	}

	public void approveEstimateFleet(String action, String tenantName) {
		if (action.equalsIgnoreCase("Approve")) {
			eventInfoPage.estimateApproval(tenantName);
		}
		if (action.equalsIgnoreCase("Reject")) {
			eventInfoPage.rejectApproval(tenantName);
		}

	}

	public void acceptEventWiChecklist(String action, String tenant, DataTable checklistData) {
		eventInfoPage.chechkistActions(action, checklistData);
	}

	public void verifyChecklistFields(DataTable checklist) {
		eventInfoPage.validateChecklistInTanent(checklist);
	}

	public void validateEq360(String page, DataTable equipmentDetails) throws Exception {
		
		List<Map<String, String>> list = equipmentDetails.asMaps(String.class, String.class);
		String equipmentType = list.get(0).get("EquipmentType");
		String equipmentNumber = list.get(0).get("EquipmentNumber");
		String sourceTruck = list.get(0).get("SourceTruck");
		String equipmentProvider = list.get(0).get("EquipmentProvider");
		String make = list.get(0).get("Make");
		String model = list.get(0).get("Model");
		String year = list.get(0).get("Year");
		String vin = list.get(0).get("Vin");
		String liscence = list.get(0).get("Liscence");
		
		if (page.equalsIgnoreCase("Dashboard")) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.get(PropsReader.fleetURL);
			eventInfoPage.equipment360ActivityValidation();
			eventInfoPage.validateEquipmentDetails(equipmentType, equipmentNumber, sourceTruck, equipmentProvider, make,
					model, year, vin, liscence);
			eventInfoPage.validateEq360Dashboard();
			eventInfoPage.validateEquipmentDetails(equipmentType, equipmentNumber, sourceTruck, equipmentProvider, make,
					model, year, vin, liscence);

		}
		
		if (page.equalsIgnoreCase("Editpage")) {
			eventInfoPage.validateEq360Editpage();
			eventInfoPage.validateEquipmentDetailsEditPage(equipmentType, equipmentNumber, sourceTruck, equipmentProvider, make,
					model, year, vin, liscence);
		}
	}

	public void validateARL(DataTable serviceCenter) {
		
		List<Map<String, String>> list = serviceCenter.asMaps(String.class, String.class);
		String createdby = list.get(0).get("CreatedBy");
		String servicecenter = list.get(0).get("ServiceCenter");
        eventInfoPage.validateAssignReportingLocation(createdby , servicecenter);
		
	}
	
	public void invoiceAction(String action , DataTable invoiceActionDetails) throws IOException {
		List<Map<String, String>> list = invoiceActionDetails.asMaps(String.class, String.class);
		String invoiceNumber = list.get(0).get("InvoiceNumber");
		String amount = list.get(0).get("Amount");
		String status = list.get(0).get("Status");
		String payer = list.get(0).get("Payer");
		String payee = list.get(0).get("Payee");

		if((list.get(0).get("ViewInvoice1"))!=null){
			eventInfoPage.clickViewInvoice(list.get(0).get("ViewInvoice1"));
			String tenant1=(list.get(0).get("ViewInvoice1")).toLowerCase();
			String tenant=eventInfoPage.removeSpace(tenant1);
			String parent = driver.getWindowHandle();
			Set<String> s = driver.getWindowHandles();
			Iterator<String> I1 = s.iterator();
			while (I1.hasNext()) {
				String child_window = I1.next();
				if (!parent.equals(child_window)) {
					driver.switchTo().window(child_window);
				}
			}
			eventInfoPage.invoiceDetails(invoiceNumber,amount,status,action,tenant);
			driver.close();
			driver.switchTo().window(parent);
//		if((list.get(0).get("Payer"))!=null){
//			eventInfoPage.validatePayee(list.get(0).get("Payer"));
//		}
//		if((list.get(0).get("Payee"))!=null){
//			eventInfoPage.validatePayer(list.get(0).get("Payee"));
//		}
		}

		if((list.get(0).get("EPInvoice"))!=null){
			eventInfoPage.clickViewInvoice(list.get(0).get("EPInvoice"));
		}
		if((list.get(0).get("ViewInvoice2"))!=null){
			eventInfoPage.viewInvoice(list.get(0).get("ViewInvoice2"));
			String tenant=(list.get(0).get("ViewInvoice2")).toLowerCase();
			String parent2 = driver.getWindowHandle();
			Set<String> s2 = driver.getWindowHandles();
			Iterator<String> I2 = s2.iterator();
			while (I2.hasNext()) {
				String child_window2 = I2.next();
				if (!parent2.equals(child_window2)) {
					driver.switchTo().window(child_window2);
				}
			}
			eventInfoPage.invoiceDetails(invoiceNumber,amount,status,action,tenant);
			driver.close();
			driver.switchTo().window(parent2);
		}
	}

	public void invoiceDashBoardValidation(String tenant, String status, String payer, String payee) throws IOException {
		try {
			wait.forLoading();
			switch (tenant.toUpperCase()) {
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

		eventInfoPage.filterInvoice(status, payer, payee);
	}

	public void verifyStream(String tenantType) {
		eventInfoPage.verifyPaymentStream(tenantType);		
	}

	public void verifySubContact(String tofrom,String tenant) {
		eventInfoPage.verifySubContact(tofrom, tenant);
	}


}

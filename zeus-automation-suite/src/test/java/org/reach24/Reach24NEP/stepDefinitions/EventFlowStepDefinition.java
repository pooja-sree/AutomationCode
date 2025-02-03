package org.reach24.Reach24NEP.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.reach24.Reach24NEP.steps.EventCreationSteps;
import org.reach24.Reach24NEP.steps.EventFlowSteps;
import org.reach24.Reach24NEP.util.BasePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.awt.*;
import java.io.IOException;

public class EventFlowStepDefinition extends BasePage {

	EventFlowSteps eventFlow = new EventFlowSteps();
	EventCreationSteps eventCreationStep = new EventCreationSteps();

	@And("^(.*) (.*) event to -- (.*) -- Payment Method - (.*)$")
	public void assignEvent(String action, String eventTenantType, String tenantType, String payment) throws Exception {
		eventFlow.assignEventToTenant(action, eventTenantType, tenantType, payment);
	}

	@And("^(.*) RFA from conversation Tab -- (.*) -- (.*)$")
	public void RaiseRFAFromConversationsTab(String action, String tenanttype, String assignedTenant) {
		eventFlow.AlertsMethodsConversationTab(action, tenanttype, assignedTenant);
	}

	@And("Resolve RFA in Dashboard -- (.*)$")
	public void resolve_RFA_in_Dashboard_Fleet(String tenantType) {
		eventFlow.resolve_RFAinHotTab(tenantType);
	}

	@When("^(.*) -- RFA -- (.*)$")
	public void rFA_Action(String action, String tab, DataTable table) {
		eventFlow.rFA_Action(action, tab, table);
	}

	@When("Assign Tech -- (.*) -- (.*)$")
	public void assign_Tech(String tenantType, String technician) {
		eventFlow.assignTech(tenantType, technician);
	}

	@And("^EventAction -- (.*) -- by -- (.*)$")
	public void eventAction_by(String action, String tenant) {
		eventFlow.eventActionBy(action, tenant);
	}

	@When("Validate Crosswalk -- (.*)$")
	public void validate_crosswalk_nep(String tenant, DataTable crosswalkData) {
		eventFlow.validateCrosswalk(tenant, crosswalkData);
	}

	@When("Validate WatchList")
	public void validate_watch_list() {
		eventFlow.ValidateWatchListEvent();
	}

	@And("^Dashboard actions for scheduled events -- (.*)$")
	public void dashboard_actions_for_scheduled_events(String tenant, DataTable validations) throws IOException {
		eventFlow.dashboardActionScheduledAction(tenant, validations);
	}

	@And("^ScheduleEventAction -- (.*) -- (.*)$")
	public void scheduleEventAction(String tenant, String action) throws IOException {
		eventFlow.scheduleEventAction(tenant, action);
	}

	@Given("^(.*) -- Enable/Disable feature -- (.*)--(.*)$")
	public void enableDisableFeature(String tenantName, String featureName, String enableDisable)
			throws InterruptedException, IOException, AWTException {
		eventFlow.enableDisableFeature(tenantName, featureName, enableDisable);
	}

	@After("@ScheduleEvent")
	public void afterScheduleEventScenario() {
		eventFlow.enableDisableFeature("AutoTruck SP5", "Enable Event Schedule", "Disable");
	}

	@After("@AutoTechDispatch")
	public void afterAutoTechDispatchScenario() {
		eventFlow.enableDisableFeature("AutoTruck SP6", "Enable Auto Tech Dispatch", "Disable");
		eventFlow.enableDisableFeature("AutoTruck SP7", "Enable Auto Tech Dispatch", "Disable");
	}

	 @After("@FleetTechChecklist")
	 public void afterFleetTechChecklistScenario(){
	 eventFlow.enableDisableFeature("AutoTruck SP", "Enable Workflow Checklist","Disable");
	 eventFlow.enableDisableFeature("AutoTruck Fleet", "Enable Workflow Checklist", "Disable");
	 }

	@When("^Validate ATDlog -- (.*) -- (.*) -- (.*) -- (.*)$")
	public void validate_atdlog(String status1, String status2, String status3, String status4) {
		eventFlow.validationATDstatus(status1, status2, status3, status4);
	}

	@When("Validate CallForward -- (.*) -- (.*)$")
	public void validate_call_forward(String forwardTo, String forwardFrom) {
		eventFlow.validateCallforward(forwardTo, forwardFrom);
	}

	@When("Validate EquipmentProvider -- (.*)$")
	public void validate_equipment_provider_fleet(String tenantName) {
		eventFlow.validateEPfromFleet(tenantName);
	}

	@And("(.*) Tech -- (.*) -- in TS -- (.*)$")
	public void addTechinTS(String action, String techName, String tenantType) {
		eventFlow.techScheduler(action, techName, tenantType);
	}

	@And("(.*) Shift -- (.*) -- in TS -- (.*)$")
	public void addShiftinTS(String action, String techName, String tenantType) {
		eventFlow.addShiftinTechSchedular(action, techName, tenantType);
	}

	@And("Add Notes and Verify Notes")
	public void add_Notes_And_Verify_Notes() {
		eventFlow.addAndVerifyNotesDay();
	}

	@And("Copy Shift in TS")
	public void copy_Shift_In_TS() {
		eventFlow.copyShiftInTS();
	}

	@And("Validate Technician Log")
	public void validate_Technician_Log() {
		eventFlow.validateTechLog();
	}

	@And("LogTechArrival -- In (.*)$")
	public void logTechArrival(String tenantName) {
		eventFlow.logTechArrival(tenantName);
	}

	@Then("^Prepare estimate$")
	public void prepareEstimate(DataTable estimates) {
		eventFlow.prepareEstimate(estimates);
	}

	@When("^Validate Estimate PreApproval -- (.*)$")
	public void validate_estimate_pre_approval(String tenantName) {
		eventFlow.validatePreApprovalEstimation(tenantName);
	}

	@When("^(.*) Estimation -- (.*)$")
	public void approve_estimate(String action, String tenantName) {
		eventFlow.approveEstimateFleet(action, tenantName);

	}

	@Then("^(.*) Event with Checklist -- In (.*)$")
	public void acceptEventWithChecklist(String action, String tenantType, DataTable checklistData) {
		eventFlow.acceptEventWiChecklist(action, tenantType, checklistData);
	}

	@Then("Validate Checklist Fields")
	public void validate_Checklist_Fields_in_Additional_details_tab(DataTable checklist) {
		eventFlow.verifyChecklistFields(checklist);
	}

	@When("^Validate Equipment360 activity -- (.*)$")
	public void validate_equipment360_activity(String page, DataTable equipmentDetails) throws Exception {
		eventFlow.validateEq360(page, equipmentDetails);
	}

	@When("^Validate AssignReportingLocation")
	public void validate_assign_reporting_location(DataTable serviceCenter) {
		eventFlow.validateARL(serviceCenter);
	}

	@And("^(.*) -- Invoice$")
	public void invoiceAction(String action, DataTable invoiceActionDetails) throws Exception {
		eventFlow.invoiceAction(action, invoiceActionDetails);
	}

	@And("^(.*) Invoice Dashboard Validation -- (.*) - (.*) - (.*)$")
	public void invoiceDashBoardValidation(String tenant, String action, String payer, String payee) throws Exception {
		eventFlow.invoiceDashBoardValidation(tenant, action, payer, payee);
	}

	@Then("Verify Payment Stream --(.*)$")
	public void verify_Payment_Stream(String tenantType) {
		eventFlow.verifyStream(tenantType);
	}

	@Given("^SubContact -- (.*) -- (.*)$")
	public void subContact(String tofrom, String tenant) {
		eventFlow.verifySubContact(tofrom, tenant);
	}
	
	@When("^(.*) -- (.*)-- Door$")
	public void close_Open_door(String action,String tenant) {
		eventCreationStep.closeOpenDoor(action,tenant);
	}

}


package org.reach24.Reach24NEP.stepDefinitions;

import java.awt.AWTException;
import java.io.IOException;

import org.reach24.Reach24NEP.steps.EventCreationSteps;
import org.reach24.Reach24NEP.util.BasePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EventCreationStepDefinition extends BasePage {

	EventCreationSteps eventCreationStep = new EventCreationSteps();

	@Given("Create a (.*)Event-- (.*) -- Feature - (.*)$")
	public void create_a_Event(String eventType, String tenantType, String featureName, DataTable eventData) throws InterruptedException, IOException, AWTException {
		eventCreationStep.createEvent(eventType, tenantType, featureName, eventData);

	}

	@When("(.*) Event -- (.*) -- (.*)$")
	public void clone_event(String action ,String tenantType ,String featureName, DataTable eventData) throws IOException {
		eventCreationStep.cloneEvent(action , tenantType ,featureName, eventData);
	}

	@When("^Enter Service details -- (.*)$")
	public void enter_Service_details(String featureName,DataTable dataTable) throws IOException {
		eventCreationStep.enterServiceDetails(featureName,dataTable);
	}

	@When("Enter Service details Edit")
	public void enter_Service_details_edit(DataTable dataTable) {
		eventCreationStep.enterServiceDetailsEdit(dataTable);
	}

	@When("Get Event information from -- (.*)$")
	public void get_Event_information(String tenantType) throws IOException {
		eventCreationStep.getEventInfo(tenantType);
	}

	@When("Verify (.*)Event Status")
	public void verify_Event_Status(DataTable verificationData) throws IOException {
		eventCreationStep.verifyStatus(verificationData);
	}

	@Then("Validate Ancillary Location Info -- (.*)$")     
	public void validate_Ancillary_Location_Info(String tenantType)	{
		eventCreationStep.validateAncillaryLocation();
	}

	@Then("Validate (.*)Attachment Info -- (.*)$")
	public void validate_Attachment_Info(String attachmentType,String tenantType) throws InterruptedException {
		eventCreationStep.validateAttachmentInfo(attachmentType);
	}

	@When("Add Custom Fields -- (.*)$")
	public void add_custom_fields_nep_accessibility_sp(String tenant) {
		eventCreationStep.addCustomFields(tenant);
	}

	@Given("(.*) Payment Method$")
	public void select_payment_method_td(String action, DataTable dataTable) {
		eventCreationStep.selectPaymentMethod(action, dataTable);
	}

	@Then("^(.*) the DraftEvent$")
	public void delete_the_draftEvent(String action) throws InterruptedException, IOException {
		eventCreationStep.deletedraftevent(action);
	}

	@Then("^(.*) Agent Assignmnt Task Info Login As -- (.*) -- (.*)$")
	public void createValidate_agent_assignmnt_task_info(String action, String user,String tenant) throws IOException {
		eventCreationStep.createValidateAgentAssignmentTask(action, user, tenant);
	}

	@Then("^(.*) The Agent Assignment On Dashboard Page -- (.*) -- (.*)$")
	public void viewCreate_the_agent_assignment_on_dashboard_page(String action, String agent, String tenant) {
		eventCreationStep.viewCreateAgentAssignment(action, agent, tenant);
	}

	@Then("^Delete The Assigned User -- (.*)$")
	public void delete_the_assigned_user(String agent) {
		eventCreationStep.deleteTheUser(agent);
	}

	@Then("^Verify Active or Inactive status of Deleted User -- (.*)$")
	public void verify_active_or_inactive_status_of_deleted_user(String user) {
		eventCreationStep.verifyActiveInactiveStatus(user);
	}

	@Then("Wait for Auto Approval")
	public void autoApproval() {
		eventCreationStep.waitForApproval();
	}

	@Given("Verify that We Can Delete that created Template")
	public void verify_that_we_can_delete_that_created_template() {
	}

	@Then("Validate Demo Terminal on Event Show Page -- (.*)$")
	public void validate_demo_terminal_on_event_show_page(String tenantType) {
		eventCreationStep.validateTerminal(tenantType);
	}

	// Shipper Fun
	@Then("Validate Shipper Function")
	public void validate_shipper_function() {
		eventCreationStep.validateShipper();
	}

	@Then("^Validate Towing Services Details- (.*) - (.*) - (.*)$")
	public void Validate_Towing_Services_Details(String type, String towingDestination, String mileage) {
		eventCreationStep.validateTowingServices(type,towingDestination,mileage);
	}

	@Then("^Re-Evaluate Towing Service - (.*) - (.*)$")
	public void Re_Evaluate_Towing_Service(String towingDestination, String mileage) {
		eventCreationStep.reEvaluateTowingServices(towingDestination,mileage);
	}
	@Given("Create an (.*)Template-- (.*) -- EventTemplates - (.*)$")
	public void create_an_Template(String eventType, String tenantType, String featureName, DataTable eventData) throws InterruptedException, IOException, AWTException {
		eventCreationStep.createEventTemplate(eventType, tenantType, featureName, eventData , false);
	}

	@Then("^Verify Event Template-- (.*)$")
    public void verify_Template(String tenantType, DataTable dataTable) throws IOException {
		eventCreationStep.verifyEventTemplate(dataTable, tenantType);
	}
	@Given("^Update an Template using EventTemplates-- (.*)$")
	public void update_an_Template_EventTemplate(String tenantType, DataTable eventData) throws IOException {
		eventCreationStep.updateEventTemplate(eventData, tenantType);
	}

	@Given("^Create an Event using EventTemplates-- (.*)$")
	public void create_an_Template_EventTemplate(String tenant, DataTable dataTable) throws IOException {
		eventCreationStep.createEventUsingTemplate(tenant,dataTable);
	}

	@Given("^Create Events Batch Upload - (.*) - (.*)$")
	public void create_EventsBatchUpload(String tenant, String fileName) {
		eventCreationStep.createEventsBatchUpload(tenant,fileName);
	}
	
}

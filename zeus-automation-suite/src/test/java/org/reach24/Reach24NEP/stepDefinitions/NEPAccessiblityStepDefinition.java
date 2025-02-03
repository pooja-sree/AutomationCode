package org.reach24.Reach24NEP.stepDefinitions;

import io.cucumber.java.en.Then;
import org.reach24.Reach24NEP.steps.EventCreationSteps;
import org.reach24.Reach24NEP.steps.NEPAccessiblitySteps;
import org.reach24.Reach24NEP.util.BasePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class NEPAccessiblityStepDefinition extends BasePage {
	
	NEPAccessiblitySteps nEPAccessiblitySteps= new NEPAccessiblitySteps();
	EventCreationSteps eventCreationStep = new EventCreationSteps();
	
	@Given("^Configure NEP access$")
	public void configure_NEP_access(DataTable eventData) {
		System.out.println("Executing configure_NEP_access");
		nEPAccessiblitySteps.enterTenantInfo(eventData);
	}
	
	@And("^Verify NEP Banner -- (.*) -- (.*)$")
	public void configure_NEP_banner_new_page(String pageType, String action) {
		System.out.println("Executing configure_NEP_banner_new_page");
		eventCreationStep.verifyNEPBanner(pageType, action);
	}
	
	@Given("^Disable NEP access$")
	public void disable_NEP_access(DataTable eventData) {
		System.out.println("Executing disable_NEP_access");
		nEPAccessiblitySteps.disableNEPAccess(eventData);
	}


	@Then("Validate dashboard")
	public void validate_dashboard() {
		nEPAccessiblitySteps.validateDashboard();
	}

	@Then("^Validate Event Sorting -- (.*)$")
	public void validate_event_sorting(String tabName) {
		nEPAccessiblitySteps.eventSorting(tabName);
	}


}

package org.reach24.Reach24NEP.stepDefinitions;

import org.reach24.Reach24NEP.steps.EventCreationSteps;
import org.reach24.Reach24NEP.util.BasePage;
import org.reach24.Reach24NEP.util.BeforeAndAfterScenarios;

import io.cucumber.java.en.Given;

public class TenantLoginAndLogoutStepDefinition extends BasePage {

	BeforeAndAfterScenarios beforescenario = new BeforeAndAfterScenarios();
	EventCreationSteps eventCreationStep = new EventCreationSteps();

	@Given("^Logout as -- (.*)$")
	public void logoutTenant(String tenantType) {
		beforescenario.logoutTenant(tenantType);

	}

	@Given("^Login as -- (.*)$")
	public void loginTenant(String tenantType) {
		beforescenario.loginTenant(tenantType);
	}

	@Given("^Open (.*) dashboard$")
	public void Open_dashboard(String tenant) {
		eventCreationStep.loginastenant(tenant);
	}


}

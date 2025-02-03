package org.reach24.Reach24NEP.steps;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.reach24.Reach24NEP.pages.*;
import org.reach24.Reach24NEP.util.BasePage;
import org.reach24.Reach24NEP.util.PropsReader;
import org.reach24.Reach24NEP.util.ReusableMethods;
import io.cucumber.datatable.DataTable;

public class NEPAccessiblitySteps extends BasePage {

	TenantLoginPage tenantLoginPage = new TenantLoginPage(driver);
	TenantInfoPage tenantInfoPage = new TenantInfoPage(driver);
	TenantInfoEditPage tenantInfoEditPage = new TenantInfoEditPage(driver);
	SuperAdminPage superAdminPage = new SuperAdminPage(driver);
	ReusableMethods reusableMethods = new ReusableMethods();
	PropsReader propsReader = new PropsReader();
	DashboardPage dashboardPage = new DashboardPage(driver);

	@SuppressWarnings("deprecation")
	public void enterTenantInfo(DataTable eventData) {
		List<Map<String, String>> list = eventData.asMaps(String.class, String.class);
		String tenantname = list.get(0).get("TenantName");
		String nEPAccessibility = list.get(0).get("NEPAccessibility");
		String marknewpageasdefault = list.get(0).get("MarkNewPageAsDefault");
		String switchbacktooldeventpage = list.get(0).get("SwitchBackToOldEventPage");
		String create = list.get(0).get("Create");
		String edit = list.get(0).get("Edit");
		String show = list.get(0).get("Show");
		String clone = list.get(0).get("Clone");

		driver.get(PropsReader.adminUrl);

//		tenantLoginPage.enterAdminUserName(PropsReader.superAdminUserName);
//		tenantLoginPage.enterAdminPassword(PropsReader.superAdminPassword);
//		tenantLoginPage.checkAdminRememberMe();
//		tenantLoginPage.clickAdminLoginButton();

		superAdminPage.searchTenantBox(tenantname);
		superAdminPage.clickLinkTenant(tenantname);

		// reusableMethods.switchNextBrowserTab(driver);
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		for (String child_window : s) {
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

			}
		}

		Assert.assertTrue(tenantInfoPage.verifyTenantName(tenantname));

		tenantInfoPage.selectInfoEdit();

		System.out.println("Entering Information on Edit Tenant Info Page");

		if (nEPAccessibility.equalsIgnoreCase("Yes")) {
			tenantInfoEditPage.enableDisableNEPAccessibility("enable");
		}
		
		if (marknewpageasdefault.equalsIgnoreCase("Yes")) {
			tenantInfoEditPage.enableDisableMarkNewPageDefault("enable");
		}
		
		if (switchbacktooldeventpage.equalsIgnoreCase("Yes")) {
			tenantInfoEditPage.enableDisableSwitchBackToOldEventPage("enable");
		}
		
		if (create.equalsIgnoreCase("Yes")) {
			tenantInfoEditPage.enableDisableCreateEvent("enable");
		}
		
		if (edit.equalsIgnoreCase("Yes")) {
			tenantInfoEditPage.enableDisableEditEvent("enable");
		}
		
		if (show.equalsIgnoreCase("Yes")) {
			tenantInfoEditPage.enableDisableShowEvent("enable");
		}
		
		if (clone.equalsIgnoreCase("Yes")) {
			tenantInfoEditPage.enableDisableCloneEvent("enable");
		}

		tenantInfoEditPage.clickBtnUpdate();

		driver.close();

		driver.switchTo().window(parent);
	}

	@SuppressWarnings("deprecation")
	public void disableNEPAccess(DataTable eventData) {
		List<Map<String, String>> list = eventData.asMaps(String.class, String.class);
		String tenantname = list.get(0).get("TenantName");
		driver.get(PropsReader.adminUrl);

		superAdminPage.searchTenantBox(tenantname);
		superAdminPage.clickLinkTenant(tenantname);

		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		for (String child_window : s) {
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

			}
		}

		Assert.assertTrue(tenantInfoPage.verifyTenantName(tenantname));

		tenantInfoPage.selectInfoEdit();

		System.out.println("Disabling NEP Access on Edit Tenant Info Page");

		tenantInfoEditPage.enableDisableCreateEvent("disable");
		tenantInfoEditPage.enableDisableShowEvent("disable");
		tenantInfoEditPage.enableDisableEditEvent("disable");
		tenantInfoEditPage.enableDisableCloneEvent("disable");
		tenantInfoEditPage.enableDisableSwitchBackToOldEventPage("disable");
		tenantInfoEditPage.enableDisableMarkNewPageDefault("disable");
		tenantInfoEditPage.enableDisableNEPAccessibility("disable");

		System.out.println("NEP Access Disabled");

		tenantInfoEditPage.clickBtnUpdate();

		driver.close();

		driver.switchTo().window(parent);

	}

	public void validateDashboard() {
		dashboardPage.validateDashboard();
	}

	public void eventSorting(String tabName) {
		dashboardPage.eventSorting(tabName);
	}

}

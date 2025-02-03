package org.reach24.Reach24NEP.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.reach24.Reach24NEP.pages.SuperAdminLoginPage;
import org.reach24.Reach24NEP.pages.TenantLoginPage;
import org.reach24.Reach24NEP.pages.TenantLogoutPage;

public class BeforeAndAfterScenarios extends BasePage {

	PropsReader propsReader = new PropsReader();
	TenantLoginPage tenantLoginPage = new TenantLoginPage(driver);
	TenantLogoutPage tenantLogoutPage = new TenantLogoutPage(driver);

	public void loginTenant(String tenantType) {

		try {
			switch (tenantType.toUpperCase()) {

			case "TD":
				driver.get(PropsReader.tdURL);
				tenantLoginPage.enterUserName(PropsReader.tdUserName);
				tenantLoginPage.enterPassword(PropsReader.tdPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "TD1":
				driver.get(PropsReader.td1URL);
				tenantLoginPage.enterUserName(PropsReader.td1UserName);
				tenantLoginPage.enterPassword(PropsReader.td1Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "TD2":
				driver.get(PropsReader.td2URL);
				tenantLoginPage.enterUserName(PropsReader.td2UserName);
				tenantLoginPage.enterPassword(PropsReader.td2Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "FLEET":
				driver.get(PropsReader.fleetURL);
				tenantLoginPage.enterUserName(PropsReader.fleetUserName);
				tenantLoginPage.enterPassword(PropsReader.fleetPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "SP":
				driver.get(PropsReader.spURL);
				tenantLoginPage.enterUserName(PropsReader.spUserName);
				tenantLoginPage.enterPassword(PropsReader.spPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "SP1":
				driver.get(PropsReader.sp1URL);
				tenantLoginPage.enterUserName(PropsReader.sp1UserName);
				tenantLoginPage.enterPassword(PropsReader.sp1Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
	
			case "SP2":
				driver.get(PropsReader.sp2URL);
				tenantLoginPage.enterUserName(PropsReader.sp2UserName);
				tenantLoginPage.enterPassword(PropsReader.sp2Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "SP3":
				driver.get(PropsReader.sp3URL);
				tenantLoginPage.enterUserName(PropsReader.sp3UserName);
				tenantLoginPage.enterPassword(PropsReader.sp3Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "SP4":
				driver.get(PropsReader.sp4URL);
				tenantLoginPage.enterUserName(PropsReader.sp4UserName);
				tenantLoginPage.enterPassword(PropsReader.sp4Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "SP5":
				driver.get(PropsReader.sp5URL);
				tenantLoginPage.enterUserName(PropsReader.sp5UserName);
				tenantLoginPage.enterPassword(PropsReader.sp5Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "SP6":
				driver.get(PropsReader.sp6URL);
				tenantLoginPage.enterUserName(PropsReader.sp6UserName);
				tenantLoginPage.enterPassword(PropsReader.sp6Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "SP7":
				driver.get(PropsReader.sp7URL);
				tenantLoginPage.enterUserName(PropsReader.sp7UserName);
				tenantLoginPage.enterPassword(PropsReader.sp7Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "CC":
				driver.get(PropsReader.ccURL);
				tenantLoginPage.enterUserName(PropsReader.ccUserName);
				tenantLoginPage.enterPassword(PropsReader.ccPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "CC1":
				driver.get(PropsReader.cc1URL);
				tenantLoginPage.enterUserName(PropsReader.cc1UserName);
				tenantLoginPage.enterPassword(PropsReader.cc1Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "CC2":
				driver.get(PropsReader.cc2URL);
				tenantLoginPage.enterUserName(PropsReader.cc2UserName);
				tenantLoginPage.enterPassword(PropsReader.cc2Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "CCHQ":
				driver.get(PropsReader.cchqURL);
				tenantLoginPage.enterUserName(PropsReader.cchqUserName);
				tenantLoginPage.enterPassword(PropsReader.cchqPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "TECHSP":
				driver.get(PropsReader.sctechURL);
				tenantLoginPage.enterUserName(PropsReader.sctechUserName);
				tenantLoginPage.enterPassword(PropsReader.sctechPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "TECH2SP":
				driver.get(PropsReader.sctechURL);
				tenantLoginPage.enterUserName(PropsReader.sctech2UserName);
				tenantLoginPage.enterPassword(PropsReader.sctech2Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "SPHQ":
				driver.get(PropsReader.sphqURL);
				tenantLoginPage.enterUserName(PropsReader.sphqUserName);
				tenantLoginPage.enterPassword(PropsReader.sphqPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "SCAUTOCROSSWALK":
				driver.get(PropsReader.SCcrosswalkUrl);
				tenantLoginPage.enterUserName(PropsReader.SCcrosswalkUsername);
				tenantLoginPage.enterPassword(PropsReader.SCcrosswalkpassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "ADMIN":
				driver.get(PropsReader.adminUrl);
				tenantLoginPage.enterAdminUserName(PropsReader.superAdminUserName);
				tenantLoginPage.enterAdminPassword(PropsReader.superAdminPassword);
				tenantLoginPage.checkAdminRememberMe();
				tenantLoginPage.clickAdminLoginButton();
				break;

			case "AUTOFORWARD":
				driver.get(PropsReader.autoForwardUrl);
				tenantLoginPage.enterUserName(PropsReader.autoForwardUserName);
				tenantLoginPage.enterPassword(PropsReader.autoForwardPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "BRIDGESTONE":
				driver.get(PropsReader.bridgeStoneCallCenterUrl);
				tenantLoginPage.enterUserName(PropsReader.bridgestoneCallCenterUserName);
				tenantLoginPage.enterPassword(PropsReader.bridgestoneCallCenterPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
								
			default:
				throw new Reach24NEPCustomException("Invalid tenant login");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}
	}

	public void logoutTenant(String tenantType) {

		try {
			switch (tenantType.toUpperCase()) {

			case "SP":
				driver.get(PropsReader.spURL);
				tenantLogoutPage.sclogout();
				break;
				
			case "TECHSP":
				driver.get(PropsReader.sctechURL);
				tenantLogoutPage.sclogout();
				break;

			case "TECH2SP":
				driver.get(PropsReader.sctech2URL);
				tenantLogoutPage.sclogout();
				break;
				
			case "ADMIN":
				driver.get(PropsReader.adminUrl);
				tenantLogoutPage.sclogout();
				break;
				
			default:
				throw new Reach24NEPCustomException("Invalid tenant logout");
			}

		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}

	}

	public void loginSuperAdmin(WebDriver driver) {

		SuperAdminLoginPage superAdminloginPage = new SuperAdminLoginPage(driver);

		driver.get(PropsReader.adminUrl);

		int size=driver.findElements(By.xpath("//div[@class='custom-panel margin activemenu']")).size();
		if(size==0)
		{
			superAdminloginPage.enterUserName();
			superAdminloginPage.enterPassword();
			superAdminloginPage.clickRememberMeCheckBox();
			superAdminloginPage.clickLoginButton();
		}

	}

}

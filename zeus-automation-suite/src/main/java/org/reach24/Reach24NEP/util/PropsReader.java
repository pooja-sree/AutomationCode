package org.reach24.Reach24NEP.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropsReader {
	public static String filePath;
	public static String configFilesPath = "./src/test/resources/config/";
	public static int timeoutInSeconds;
	public static int timeoutLessInSeconds;

	// URLs
	public static String adminUrl;
	public static String tdURL;
	public static String td1URL;
	public static String td2URL;
	public static String ccURL;
	public static String cc1URL;
	public static String cc2URL;
	public static String cchqURL;
	public static String spURL;
	public static String sp1URL;
	public static String sp2URL;
	public static String sp3URL;
	public static String sp4URL;
	public static String sp5URL;
	public static String sp6URL;
	public static String sp7URL;
	public static String sp8URL;
	public static String sphqURL;
	public static String sctechURL;
	public static String sctech2URL;
	public static String SCcrosswalkUrl;
	public static String fleetURL;
	public static String autoForwardUrl;
	public static String bridgeStoneCallCenterUrl;
	public static String tenantCreatePage;
	public static String tdeventCreatePage;
	public static String td1eventCreatePage;
	public static String td2eventCreatePage;
	public static String ccEventCreatePage;
	public static String cc1eventCreatePage;
	public static String cchqeventCreatePage;
	public static String speventCreatePage;
	public static String sp1eventCreatePage;
	public static String sp2eventCreatePage;
	public static String sp3eventCreatePage;
	public static String sp4eventCreatePage;
	public static String sp5eventCreatePage;
	public static String sp8eventCreatePage;
	public static String sphqeventCreatePage;
	public static String SCcrosswalkeventCreatePage;
	public static String fleeteventCreatePage;
	public static String autoForwardCreatePage;
	public static String bridgeStoneCallCenterCreatePage;
	public static String tdEventInfoPage;
	public static String td1EventInfoPage;
	public static String td2EventInfoPage;
	public static String ccEventInfoPage;
	public static String cc1EventInfoPage;
	public static String cc2EventInfoPage;
	public static String cchqEventInfoPage;
	public static String spEventInfoPage;
	public static String sp1EventInfoPage;
	public static String sp2EventInfoPage;
	public static String sp3EventInfoPage;
	public static String sp4EventInfoPage;
	public static String sp5EventInfoPage;
	public static String sp6EventInfoPage;
	public static String sp7EventInfoPage;
	public static String sp8EventInfoPage;
	public static String sphqEventInfoPage;
	public static String SCcrosswalkEventInfoPage;
	public static String sctechEventInfoPage;
	public static String sctech2EventInfoPage;
	public static String fleetEventInfoPage;
	public static String autoForwardEventInfoPage;
	public static String bridgeStoneCallCenterEventInfoPage;

	// Driver
	public static String driver;

	// Super Admin Credentials
	public static String superAdminUserName;
	public static String superAdminPassword;

	// TD Admin
	public static String tdUserName;
	public static String tdPassword;

	// TD1 Admin
	public static String td1UserName;
	public static String td1Admin1UserName;
	public static String td1SupervisorUserName;
	public static String td1AccountantUserName;
	public static String td1ObserverUserName;
	public static String td1Password;

	// TD2 Admin
	public static String td2UserName;
	public static String td2Password;

	// CC Admin
	public static String ccUserName;
	public static String ccPassword;

	// CC1 Admin
	public static String cc1UserName;
	public static String cc1ObserverUserName;
	public static String cc1Password;

	// CC2 Admin
	public static String cc2UserName;
	public static String cc2Password;

	// CCHQ Admin
	public static String cchqUserName;
	public static String cchqPassword;

	// SPHQ Admin
	public static String sphqUserName;
	public static String sphqPassword;

	// SP Admin
	public static String spUserName;
	public static String spPassword;

	// SP1 Admin
	public static String sp1UserName;
	public static String sp1Password;

	// SP2 Admin
	public static String sp2UserName;
	public static String sp2Password;

	// SP3 Admin
	public static String sp3UserName;
	public static String sp3SupervisorUserName;
	public static String sp3Password;

	// SP4 Admin
	public static String sp4UserName;
	public static String sp4Password;

	// SP5 Admin
	public static String sp5UserName;
	public static String sp5Password;

	// SP6 Admin
	public static String sp6UserName;
	public static String sp6Password;

	// SP7 Admin
	public static String sp7UserName;
	public static String sp7Password;

	// SP8 Admin
	public static String sp8UserName;
	public static String sp8Password;

	// SC crosswalk
	public static String SCcrosswalkUsername;
	public static String SCcrosswalkpassword;

	// SC Tech
	public static String sctechUserName;
	public static String sctechPassword;

	// SC Tech2
	public static String sctech2UserName;
	public static String sctech2Password;

	// Fleet Admin

	public static String fleetUserName;
	public static String fleetPassword;

	// AutoForward Admin

	public static String autoForwardUserName;
	public static String autoForwardPassword;

	public static String bridgestoneCallCenterUserName;
	public static String bridgestoneCallCenterPassword;

	// Agent Assignment cred
	public static String tdAdmin1UserName;
	public static String tdAdmin1Password;

	public static String tdSupervisorUserName;
	public static String tdSupervisorPassword;

	public static String tdUser_UserName;
	public static String tdUser_Password;

	public static String tdObserver_UserName;
	public static String tdObserver_Password;

	public static String tdAccountant_UserName;
	public static String tdAccountant_Password;

	public PropsReader() {

		// Driver
		PropsReader.driver = readPropertiesFile(configFilesPath + "baseConfig.properties").getProperty("Driver");

		PropsReader.adminUrl = readPropertiesFile(getBaseConfig()).getProperty("AdminPage");
		PropsReader.tdURL = readPropertiesFile(getBaseConfig()).getProperty("TDUrl");
		PropsReader.td1URL = readPropertiesFile(getBaseConfig()).getProperty("TD1Url");
		PropsReader.td2URL = readPropertiesFile(getBaseConfig()).getProperty("TD2Url");
		PropsReader.ccURL = readPropertiesFile(getBaseConfig()).getProperty("CCUrl");
		PropsReader.cc1URL = readPropertiesFile(getBaseConfig()).getProperty("CC1Url");
		PropsReader.cc2URL = readPropertiesFile(getBaseConfig()).getProperty("CC2Url");
		PropsReader.cchqURL = readPropertiesFile(getBaseConfig()).getProperty("CCHQUrl");
		PropsReader.spURL = readPropertiesFile(getBaseConfig()).getProperty("SPUrl");
		PropsReader.sp1URL = readPropertiesFile(getBaseConfig()).getProperty("SP1Url");
		PropsReader.sp2URL = readPropertiesFile(getBaseConfig()).getProperty("SP2Url");
		PropsReader.sp3URL = readPropertiesFile(getBaseConfig()).getProperty("SP3Url");
		PropsReader.sp4URL = readPropertiesFile(getBaseConfig()).getProperty("SP4Url");
		PropsReader.sp5URL = readPropertiesFile(getBaseConfig()).getProperty("SP5Url");
		PropsReader.sp6URL = readPropertiesFile(getBaseConfig()).getProperty("SP6Url");
		PropsReader.sp7URL = readPropertiesFile(getBaseConfig()).getProperty("SP7Url");
		PropsReader.sp8URL = readPropertiesFile(getBaseConfig()).getProperty("SP8Url");
		PropsReader.sphqURL = readPropertiesFile(getBaseConfig()).getProperty("SPHQUrl");
		PropsReader.sctechURL = readPropertiesFile(getBaseConfig()).getProperty("SCTechUrl");
		PropsReader.sctech2URL = readPropertiesFile(getBaseConfig()).getProperty("SCTech2Url");
		PropsReader.SCcrosswalkUrl = readPropertiesFile(getBaseConfig()).getProperty("SCcrosswalkUrl");
		PropsReader.fleetURL = readPropertiesFile(getBaseConfig()).getProperty("FleetUrl");
		PropsReader.autoForwardUrl = readPropertiesFile(getBaseConfig()).getProperty("AutoForwardUrl");
		PropsReader.bridgeStoneCallCenterUrl = readPropertiesFile(getBaseConfig()).getProperty("BridgestoneUrl");

		// Pages
		PropsReader.tenantCreatePage = adminUrl.concat("/administration/tenants/new");
		PropsReader.tdeventCreatePage = tdURL.concat("/event/incidents/new");
		PropsReader.td1eventCreatePage = td1URL.concat("/event/incidents/new");
		PropsReader.td2eventCreatePage = td2URL.concat("/event/incidents/new");
		PropsReader.ccEventCreatePage = ccURL.concat("/event/incidents/new");
		PropsReader.cc1eventCreatePage = cc1URL.concat("/event/incidents/new");
		PropsReader.cchqeventCreatePage = cchqURL.concat("/event/incidents/new");
		PropsReader.speventCreatePage = spURL.concat("/event/incidents/new");
		PropsReader.sp1eventCreatePage = sp1URL.concat("/event/incidents/new");
		PropsReader.sp2eventCreatePage = sp2URL.concat("/event/incidents/new");
		PropsReader.sp3eventCreatePage = sp3URL.concat("/event/incidents/new");
		PropsReader.sp4eventCreatePage = sp4URL.concat("/event/incidents/new");
		PropsReader.sp5eventCreatePage = sp5URL.concat("/event/incidents/new");
		PropsReader.sp8eventCreatePage = sp8URL.concat("/event/incidents/new");
		PropsReader.sphqeventCreatePage = sphqURL.concat("/event/incidents/new");
		PropsReader.SCcrosswalkeventCreatePage = SCcrosswalkUrl.concat("/event/incidents/new");
		PropsReader.fleeteventCreatePage = fleetURL.concat("/event/incidents/new");
		PropsReader.autoForwardCreatePage = autoForwardUrl.concat("/event/incidents/new");
		PropsReader.bridgeStoneCallCenterCreatePage =bridgeStoneCallCenterUrl.concat("/event/incidents/new");

		PropsReader.tdEventInfoPage = tdURL.concat("/event/incidents/");
		PropsReader.td1EventInfoPage = td1URL.concat("/event/incidents/");
		PropsReader.td2EventInfoPage = td2URL.concat("/event/incidents/");
		PropsReader.ccEventInfoPage = ccURL.concat("/event/incidents/");
		PropsReader.cc1EventInfoPage = cc1URL.concat("/event/incidents/");
		PropsReader.cchqEventInfoPage = cchqURL.concat("/event/incidents/");
		PropsReader.spEventInfoPage = spURL.concat("/event/incidents/");
		PropsReader.sphqEventInfoPage = sphqURL.concat("/event/incidents/");
		PropsReader.sp1EventInfoPage = sp1URL.concat("/event/incidents/");
		PropsReader.sp2EventInfoPage = sp2URL.concat("/event/incidents/");
		PropsReader.sp3EventInfoPage = sp3URL.concat("/event/incidents/");
		PropsReader.sp4EventInfoPage = sp4URL.concat("/event/incidents/");
		PropsReader.sp5EventInfoPage = sp5URL.concat("/event/incidents/");
		PropsReader.sp6EventInfoPage = sp6URL.concat("/event/incidents/");
		PropsReader.sp7EventInfoPage = sp7URL.concat("/event/incidents/");
		PropsReader.sp8EventInfoPage = sp8URL.concat("/event/incidents/");
		PropsReader.sctechEventInfoPage = sctechURL.concat("/event/incidents/");
		PropsReader.sctech2EventInfoPage = sctechURL.concat("/event/incidents/");
		PropsReader.SCcrosswalkEventInfoPage = SCcrosswalkUrl.concat("/event/incidents/");
		PropsReader.fleetEventInfoPage = fleetURL.concat("/event/incidents/");
		PropsReader.autoForwardEventInfoPage = autoForwardUrl.concat("/event/incidents/");
		PropsReader.bridgeStoneCallCenterEventInfoPage = bridgeStoneCallCenterUrl.concat("/event/incidents/");

		PropsReader.superAdminUserName = readPropertiesFile(getBaseConfig()).getProperty("SuperAdminUserName");
		PropsReader.superAdminPassword = readPropertiesFile(getBaseConfig()).getProperty("SuperAdminPassword");

		PropsReader.timeoutInSeconds = Integer
				.parseInt(readPropertiesFile(getBaseConfig()).getProperty("TimeoutinSeconds"));
		PropsReader.timeoutLessInSeconds = Integer
				.parseInt(readPropertiesFile(getBaseConfig()).getProperty("TimeoutLessinSeconds"));

		// TD creds
		PropsReader.tdUserName = readPropertiesFile(getBaseConfig()).getProperty("TDUserName");
		PropsReader.tdPassword = readPropertiesFile(getBaseConfig()).getProperty("TDPassword");

		// TD1 creds
		PropsReader.td1UserName = readPropertiesFile(getBaseConfig()).getProperty("TD1UserName");
		PropsReader.td1Admin1UserName = readPropertiesFile(getBaseConfig()).getProperty("TD1Admin1UserName");
		PropsReader.td1SupervisorUserName = readPropertiesFile(getBaseConfig()).getProperty("TD1SupervisorUserName");
		PropsReader.td1AccountantUserName = readPropertiesFile(getBaseConfig()).getProperty("TD1AccountantUserName");
		PropsReader.td1ObserverUserName = readPropertiesFile(getBaseConfig()).getProperty("TD1ObserverUserName");
		PropsReader.td1Password = readPropertiesFile(getBaseConfig()).getProperty("TD1Password");

		// TD2 creds
		PropsReader.td2UserName = readPropertiesFile(getBaseConfig()).getProperty("TD2UserName");
		PropsReader.td2Password = readPropertiesFile(getBaseConfig()).getProperty("TD2Password");

		// SP creds
		PropsReader.spUserName = readPropertiesFile(getBaseConfig()).getProperty("SPUserName");
		PropsReader.spPassword = readPropertiesFile(getBaseConfig()).getProperty("SPPassword");

		// SPHQ creds
		PropsReader.sphqUserName = readPropertiesFile(getBaseConfig()).getProperty("SPHQUserName");
		PropsReader.sphqPassword = readPropertiesFile(getBaseConfig()).getProperty("SPHQPassword");

		// SP1 creds
		PropsReader.sp1UserName = readPropertiesFile(getBaseConfig()).getProperty("SP1UserName");
		PropsReader.sp1Password = readPropertiesFile(getBaseConfig()).getProperty("SP1Password");

		// SP2 creds
		PropsReader.sp2UserName = readPropertiesFile(getBaseConfig()).getProperty("SP2UserName");
		PropsReader.sp2Password = readPropertiesFile(getBaseConfig()).getProperty("SP2Password");

		// SP3 creds
		PropsReader.sp3UserName = readPropertiesFile(getBaseConfig()).getProperty("SP3UserName");
		PropsReader.sp3SupervisorUserName = readPropertiesFile(getBaseConfig()).getProperty("SP3SupervisorUserName");
		PropsReader.sp3Password = readPropertiesFile(getBaseConfig()).getProperty("SP3Password");

		// SP4 creds
		PropsReader.sp4UserName = readPropertiesFile(getBaseConfig()).getProperty("SP4UserName");
		PropsReader.sp4Password = readPropertiesFile(getBaseConfig()).getProperty("SP4Password");

		// SP5 creds
		PropsReader.sp5UserName = readPropertiesFile(getBaseConfig()).getProperty("SP5UserName");
		PropsReader.sp5Password = readPropertiesFile(getBaseConfig()).getProperty("SP5Password");

		// SP6 creds
		PropsReader.sp6UserName = readPropertiesFile(getBaseConfig()).getProperty("SP6UserName");
		PropsReader.sp6Password = readPropertiesFile(getBaseConfig()).getProperty("SP6Password");

		// SP7 creds
		PropsReader.sp7UserName = readPropertiesFile(getBaseConfig()).getProperty("SP7UserName");
		PropsReader.sp7Password = readPropertiesFile(getBaseConfig()).getProperty("SP7Password");

		// SP8 creds
		PropsReader.sp8UserName = readPropertiesFile(getBaseConfig()).getProperty("SP8UserName");
		PropsReader.sp8Password = readPropertiesFile(getBaseConfig()).getProperty("SP8Password");

		// SCcrosswalk creds
		PropsReader.SCcrosswalkUsername = readPropertiesFile(getBaseConfig()).getProperty("SCcrosswalkUsername");
		PropsReader.SCcrosswalkpassword = readPropertiesFile(getBaseConfig()).getProperty("SCcrosswalkpassword");

		// TECHSP creds
		PropsReader.sctechUserName = readPropertiesFile(getBaseConfig()).getProperty("SCTechUserName");
		PropsReader.sctechPassword = readPropertiesFile(getBaseConfig()).getProperty("SCTechPassword");

		// TECH2SP creds
		PropsReader.sctech2UserName = readPropertiesFile(getBaseConfig()).getProperty("SCTech2UserName");
		PropsReader.sctech2Password = readPropertiesFile(getBaseConfig()).getProperty("SCTech2Password");

		// Fleet Creds
		PropsReader.fleetUserName = readPropertiesFile(getBaseConfig()).getProperty("FleetUsername");
		PropsReader.fleetPassword = readPropertiesFile(getBaseConfig()).getProperty("FleetPassword");

		// CC creds
		PropsReader.ccUserName = readPropertiesFile(getBaseConfig()).getProperty("CCUserName");
		PropsReader.ccPassword = readPropertiesFile(getBaseConfig()).getProperty("CCPassword");

		// CC1NEP creds
		PropsReader.cc1UserName = readPropertiesFile(getBaseConfig()).getProperty("CC1UserName");
		PropsReader.cc1ObserverUserName = readPropertiesFile(getBaseConfig()).getProperty("CC1ObserverUserName");
		PropsReader.cc1Password = readPropertiesFile(getBaseConfig()).getProperty("CC1Password");

		// CC2NEP creds
		PropsReader.cc2UserName = readPropertiesFile(getBaseConfig()).getProperty("CC2UserName");
		PropsReader.cc2Password = readPropertiesFile(getBaseConfig()).getProperty("CC2Password");

		// CCHQ creds
		PropsReader.cchqUserName = readPropertiesFile(getBaseConfig()).getProperty("CCHQUserName");
		PropsReader.cchqPassword = readPropertiesFile(getBaseConfig()).getProperty("CCHQPassword");

		// AutoForward creds
		PropsReader.autoForwardUserName = readPropertiesFile(getBaseConfig()).getProperty("AutoForwardUsername");
		PropsReader.autoForwardPassword = readPropertiesFile(getBaseConfig()).getProperty("AutoForwardPassword");

		// BridgeStone creds
		PropsReader.bridgestoneCallCenterUserName = readPropertiesFile(getBaseConfig()).getProperty("BridgestoneUsername");
		PropsReader.bridgestoneCallCenterPassword = readPropertiesFile(getBaseConfig()).getProperty("BridgestonePassword");

		// Agent Assignment cred
		PropsReader.tdAdmin1UserName = readPropertiesFile(getBaseConfig()).getProperty("TDAdmin1UserName");
		PropsReader.tdAdmin1Password = readPropertiesFile(getBaseConfig()).getProperty("TDAdmin1Password");

		PropsReader.tdSupervisorUserName = readPropertiesFile(getBaseConfig()).getProperty("TDSupervisorUserName");
		PropsReader.tdSupervisorPassword = readPropertiesFile(getBaseConfig()).getProperty("TDSupervisorPassword");

		PropsReader.tdUser_UserName = readPropertiesFile(getBaseConfig()).getProperty("TDUser_UserName");
		PropsReader.tdUser_Password = readPropertiesFile(getBaseConfig()).getProperty("TDUser_Password");

		PropsReader.tdObserver_UserName = readPropertiesFile(getBaseConfig()).getProperty("TDObserver_UserName");
		PropsReader.tdObserver_Password = readPropertiesFile(getBaseConfig()).getProperty("TDObserver_Password");

		PropsReader.tdAccountant_UserName = readPropertiesFile(getBaseConfig()).getProperty("TDAccountant_UserName");
		PropsReader.tdAccountant_Password = readPropertiesFile(getBaseConfig()).getProperty("TDAccountant_Password");

	}

	public static Properties readPropertiesFile(String fileName) {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (IOException fnfe) {
			fnfe.printStackTrace();
		} finally {
			try {
				assert fis != null;
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

	public String getBaseConfig() {
		String environment = readPropertiesFile(configFilesPath + "baseConfig.properties").getProperty("Environment");
		Properties props = new Properties();

		try {
			props.load(PropsReader.class.getClassLoader().getResourceAsStream("project.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String mvnEnvironment = props.getProperty("Environment");
		if (environment.equals("${Environment}")) {
			environment = mvnEnvironment;
		}
		try {
			switch (environment.toLowerCase()) {

			case "stage":
				filePath = configFilesPath + "stage/stage.properties";
				break;
			case "testing":
				filePath = configFilesPath + "Testing/testing.properties";
				break;
			case "demo":
				filePath = configFilesPath + "ProdDemo/demo.properties";
				break;
			case "prod":
				filePath = configFilesPath + "Prod/prod.properties";
				break;
			case "int":
				filePath = configFilesPath + "integration/int.properties";
				break;
			default:
				throw new Reach24NEPCustomException("Invalid Environment Selected");

			}
		} catch (Reach24NEPCustomException e) {
			e.printStackTrace();
		}
		return filePath;
	}

}

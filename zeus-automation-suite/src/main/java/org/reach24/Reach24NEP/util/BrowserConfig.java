package org.reach24.Reach24NEP.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserConfig {

	static WebDriver driver;
	PropsReader propsReader = new PropsReader();

	// Lambda creds
	public String username = "nb.satheeshkumar";
	public String accesskey = "KwE3kHv49TCoBdKqrzJvgPBPTI0rK3S6ThMi0VqyULMdp4yP8Z";
	public String gridURL = "@hub.lambdatest.com/wd/hub";

	// Selenium Grid config
	String huburl = "http://r24sgrid:autor24grid678@automation.reach24.io:4444/wd/hub";

	public BrowserConfig() {
		BrowserConfig.driver = getDriver();
	}

	public WebDriver getDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (PropsReader.driver.equals("Local")) {

			// ?System.setProperty("webdriver.chrome.driver",
			// "C:/Users/Spritle/git/Reach24AdminAutomation/src/test/resources/config/lib/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver-win64/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			/*
			 * } else if (PropsReader.driver.equals("Lambda")) {
			 * capabilities.setCapability("build", "your build name");
			 * capabilities.setCapability("name", "your test name");
			 * capabilities.setCapability("platform", "Windows 10");
			 * capabilities.setCapability("browserName", "Chrome");
			 * capabilities.setCapability("version","90.0"); try { driver = new
			 * RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL),
			 * capabilities); } catch (MalformedURLException e) {
			 * System.out.println("Invalid grid URL"); } catch (Exception e) {
			 * System.out.println(e.getMessage()); }
			 */
		}
		if (PropsReader.driver.equals("LocalFF")) {

			System.setProperty("webdriver.gecko.driver", "./src/test/resources/config/lib/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			
		} 
		if (PropsReader.driver.equals("LocalIE")) {

			System.setProperty("webdriver.edge.driver", "./src/test/resources/config/lib/msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			
		}else if (PropsReader.driver.equals("Grid")) {
			capabilities.setCapability("browserName", "chrome");
			capabilities.setCapability("platform", "LINUX");
			capabilities.setCapability("platformName", "LINUX");
			capabilities.acceptInsecureCerts();
			capabilities.setCapability("pageLoadStrategy", "eager");
			try {
				System.out.println("Inside Browser config - Launching browser");
				driver = new RemoteWebDriver(new URL(huburl), capabilities);
				System.out.println("Inside Browser config - Browser Launched");
				driver.manage().window().maximize();
			} catch (MalformedURLException e) {
				System.out.println("Invalid grid URL");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return driver;
	}

	public void closeDriver() {
		driver.quit();
	}
}

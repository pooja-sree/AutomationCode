package stepDefinition;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.github.javafaker.Faker;
import com.puregenomics.at.dataprovider.ConfigFileReader;
import com.puregenomics.at.testcases.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Hooks extends BaseClass {
	private Logger log = Logger.getLogger(Hooks.class);
	
	@Before
	public void openBrowser() throws Exception {
		log.info("**********************Scenario Execution**********************");
		ConfigFileReader configFileReader= new ConfigFileReader();
		log.info("Launch the browser");
		System.out.println("Opening ChromeBrowser");
		WebDriverManager.chromedriver().setup();
	    //ChromeOptions options = new ChromeOptions();
	    //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");
	    //driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		log.info("Delete all cookies");
		driver.manage().window().maximize();
		log.info("Maximize the browser");
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("unchecked")
	@Before
	public void testdata() {
		Locale locale = new Locale("en-US");
		Faker faker = new Faker(locale);
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		int number = faker.number().numberBetween(0,999);
		String email = "gopinath+" + lastname+ number + "@livingmatrix.com";
		int age = faker.number().numberBetween(20, 99);
		
		JSONObject json = new JSONObject();
		json.put("firstname", firstname);
		json.put("lastname", lastname);
		json.put("email", email);
		json.put("age", age);
		
		try {
			 ConfigFileReader config= new ConfigFileReader();
	         FileWriter file = new FileWriter(config.getJSON());
	         file.write(json.toJSONString());
	         file.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      System.out.println("JSON file created: "+json);
	}

	@After
	public void closeBrowser() throws Exception {
		driver.close();
		log.info("Close the browser");
	    log.info("**********************Scenario Completed**********************");
	}
}

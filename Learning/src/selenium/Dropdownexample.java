package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdownexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		// For Dropown Select is an in built class in selenium 
		WebElement dropd = driver.findElement(By.xpath("//*[@id=\'j_idt87\']/div/div[1]/div[1]/div/div/select"));
		//To access the dropdown the webelement will be captured and passed in selction obj declaration
		Select dd = new Select(dropd);
		//Select by index, visibletext and value is used as methods
		dd.selectByVisibleText("Selenium");
		
		WebElement dropdd = driver.findElement(By.name("j_idt87:country_input"));
		Select dd1 = new Select(dropdd);
		dd1.selectByValue("Germany");
	
		
		
				List<WebElement> listofoption = dd1.getOptions();
				int size = listofoption.size();
				System.out.println(size);
			
		
		}

	}



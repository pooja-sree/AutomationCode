package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Autocompleteex {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		
		WebElement ty = driver.findElement(By.id("j_idt87:auto-complete_input"));
		 ty.click();
		 ty.sendKeys("s");
		 Thread.sleep(1000);
		 //Autocomplate is an element like dropdown which has search feature to identify dropdown values
		 List<WebElement> list = driver.findElements(By.xpath("//*[@id=\'j_idt87:auto-complete_panel\']/ul/li"));
		 
		 for (WebElement option : list) {
			if(option.getText().equals("Playwright")) {
				option.click();
				break;
			}
			}
		}
		 
		

	}



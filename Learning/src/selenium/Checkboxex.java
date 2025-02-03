package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		
		
		WebElement enb = driver.findElement(By.id("j_idt87:j_idt102_input"));
		//is enabled is a method to check if buttons are checked
		boolean en = enb.isEnabled();
		if(en == true) {
			System.out.println("enabled");
			
		}
		else
		{
			System.out.println("disabled");
		}

		WebElement tog = driver.findElement(By.className("ui-toggleswitch-slider"));
		tog.click();
		WebElement ch =driver.findElement(By.className("ui-growl-title"));
		String che = ch.getText();
		System.out.println(che);
	}

}

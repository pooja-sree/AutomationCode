package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioBEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		
		WebElement Rr = driver.findElement(By.id("j_idt87:console2"));
		List<WebElement> Rb = Rr.findElements(By.tagName("input"));
		
		for(WebElement radio : Rb) {
			//Is selected is a method used for radio button any one of the values should be selected( female or male)
			if(radio.isSelected()) {
				System.out.println(radio.getAttribute("value"));
			}
		
		}
	}

}

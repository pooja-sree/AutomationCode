package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectablesex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/list.xhtml");
		
		//Selectables are use for DRAG AND DROP elements
		
		List<WebElement> List = driver.findElements(By.xpath("//*[@id=\"pickList\"]/div[2]/ul/li"));
		
		int size = List.size();
		System.out.println(size);
		
		Actions act = new Actions(driver);
		//keyboard
		//by using actions class object we are click control key and selecting the first value in list by using .get(0) this method retrieve the value using index value
		//to select multiple values click should be written as such, build and perform will initialize the actions to be done
		act.keyDown(Keys.CONTROL).click(List.get(0)).click(List.get(1)).build().perform();
		
		//mouse
//		act.clickAndHold(List.get(0));
//		act.clickAndHold(List.get(1));
//		act.build().perform();

	}

}

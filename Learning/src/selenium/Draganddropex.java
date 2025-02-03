package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draganddropex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");

        //Actions calss is used for interacting with mouse elements
		WebElement dra =driver.findElement(By.id("form:drag_content"));

		WebElement dro = driver .findElement(By.id("form:drop"));

		Actions act = new Actions(driver);
		
		//Clickand hold() and dragand dropby() are some method for mouse interaction

		act.clickAndHold(dra).moveToElement(dro).release(dro).build().perform();

		WebElement drag = driver.findElement(By.id("form:conpnl"));


		act.dragAndDropBy(drag, 200, 200).build().perform();

	}

}

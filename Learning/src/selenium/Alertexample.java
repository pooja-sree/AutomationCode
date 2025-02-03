package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		
		WebElement simplealert = driver.findElement(By.id("j_idt88:j_idt91"));
		simplealert.click();
		//TO work with alerts there is a class called alert in selenium
		//Switchto() method switch the control to alert box 
		//Accept and dismiss methods are used to click ok and cancel buttons is alert box
		Alert sa = driver.switchTo().alert();
		sa.accept();
		
		WebElement confirmalert = driver.findElement(By.id("j_idt88:j_idt106"));
		confirmalert.click();
		driver.findElement(By.id("j_idt88:j_idt109")).click();
		
		
		WebElement promdia = driver.findElement(By.id("j_idt88:j_idt104"));
		promdia.click();
		
		Alert pa = driver.switchTo().alert();
		pa.sendKeys("Pooja");
		pa.dismiss();
		
		
		

	}

}

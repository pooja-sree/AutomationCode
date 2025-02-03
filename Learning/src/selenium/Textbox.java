package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Textbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml");
		//Textbox
		
			WebElement name =	driver.findElement(By.id("j_idt88:name"));
			name.sendKeys("Testleaf");
			
		    WebElement Append = driver.findElement(By.id("j_idt88:j_idt91"));
		    Append.sendKeys("city");
		    
		    WebElement enable = driver.findElement(By.id("j_idt88:j_idt97"));
		    String enb = enable.getAttribute("value");
		    System.out.println(enb);
		    
		    WebElement error = driver.findElement(By.id("j_idt106:thisform:age"));
		    error.sendKeys(Keys.ENTER);
		   WebElement error1 =  driver.findElement(By.id("javax.faces.error.xhtml"));
		   String message = error1.getText();
            System.out.println(message);		  

	}

}

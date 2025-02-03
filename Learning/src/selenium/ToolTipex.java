package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTipex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml");
		
		driver.findElement(By.id("j_idt106:thisform:age")).sendKeys(Keys.ENTER);
		WebElement tooltip =driver .findElement(By.id("j_idt106:thisform:j_idt110_error-detail"));
		String tt = tooltip.getText();
		System.out.println(tt);

	}

}

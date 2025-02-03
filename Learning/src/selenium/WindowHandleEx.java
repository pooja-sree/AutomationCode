package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		
		//to get access of one window we use window handle

		String ow = driver.getWindowHandle();

		WebElement open = driver.findElement(By.id("j_idt88:new"));
		open.click();

		Thread.sleep(4000);
		// to access multiple window tabs we use windowhandles
		Set<String> win = driver.getWindowHandles();
		for (String nw : win) {

			driver.switchTo().window(nw); // this is used to switch the control to other windows, without switching we cant interact with new window

		}

		driver.close();

		driver.switchTo().window(ow);


		WebElement close = driver.findElement(By.id("j_idt88:j_idt93"));
		close.click();

		Set<String> cw = driver.getWindowHandles();
		for (String aw : cw) {

			if(!aw.equals(ow)) {
				driver.switchTo().window(aw);
				driver.close();
			}

		}
		driver.switchTo().window(ow);

		WebElement openmultiple = driver.findElement(By.id("j_idt88:j_idt91"));
		openmultiple.click();

		int si = driver.getWindowHandles().size();
		System.out.println(si);
	}



}

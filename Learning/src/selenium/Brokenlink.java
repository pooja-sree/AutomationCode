package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlink {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/broken");
		WebElement broken = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div[2]/div[2]/div[2]/img[2]"));
		
		//If NaturalWidth of the image is "0" it is said to be broken
		String img = broken.getAttribute("naturalWidth");
		
		if(img.equals("0")) {
			System.out.println("broken");
		}
	
		WebElement brolink = driver.findElement(By.linkText("Click Here for Broken Link"));
		Thread.sleep(2000);
		brolink.click();
		String link = driver.getTitle();
		if(link.contains("500")) {
			System.out.println("broken");
		}
		
	}

}

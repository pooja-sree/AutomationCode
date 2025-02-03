package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Framesex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		//dividing webpage into multiple section html inside html
		//To access frame we use switchto().frame(); either by index or frame name
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		String text = driver.findElement(By.id("Click")).getText();
		System.out.println(text);
		//To switch back to original state, without switching back to default frame selenium cannot interact
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click")).click();
		String tex = driver.findElement(By.id("Click")).getText();
		System.out.println(tex);
		driver.switchTo().defaultContent();
		
		List<WebElement> noofframe =driver.findElements(By.tagName("iframe"));
		int frame =noofframe.size();
		System.out.println(frame);
		
		
		


	}

}

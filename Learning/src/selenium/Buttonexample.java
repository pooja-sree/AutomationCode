package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buttonexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		
		//Location of button
		WebElement Button = driver.findElement(By.id("j_idt88:j_idt94"));
		//Point is a class in selenium to get the location and coordinates of the button
		
		Point loc =	Button.getLocation();
		int x =loc.getX();
		int y=loc.getY();
		System.out.println("X:"+x + "Y:"+y);

		//Color of the button

		WebElement Colour = driver.findElement(By.id("j_idt88:j_idt96"));
		String bk = Colour.getCssValue("color");
		System.out.println(bk);

		//size of the button
		WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
		int height=  size.getSize().getHeight();
		int width = size.getSize().getWidth();
		System.out.println("height:"+height + "width:"+width);

	}

}

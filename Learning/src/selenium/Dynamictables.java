package selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamictables {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/grid.xhtml");

		//th is for column , tr is row nad td is data in rows
		List<WebElement> column = driver.findElements(By.tagName("th"));	
		int colsize =column.size();
		System.out.println(colsize);

		List<WebElement> row = driver.findElements(By.tagName("tr"));	
		int rowsize =row.size();
		System.out.println(rowsize);


		WebElement txt = driver.findElement(By.xpath("//td[text()='Blue Band']//following::td[2]"));
		String price =	txt.getText();
		System.out.println(price);
		
		List<WebElement> cost = driver.findElements(By.xpath("//td[5]"));
		
		
		
		List<Double> price1 = new ArrayList<Double>();
		
		for (WebElement pricelist : cost) {
			String IV = pricelist.getText().replace("$"," ");
			 price1.add(Double.parseDouble(IV));	
			
		}
		System.out.println(price1);
		
		Double smallvalue = Collections.min(price1);
		String SV = Double.toString(smallvalue);
		
		String fXpath = "//span[text()="+"\""+"$"+ SV +"0"+ "\""+"]"+"//following::td[1]";
		
		WebElement tex = driver.findElement(By.xpath(fXpath));
		String value = tex.getText();
		System.out.println(value);
				
				//span[text()='$29.00']//following::td[1]
	

	}}

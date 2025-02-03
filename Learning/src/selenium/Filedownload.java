package selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Filedownload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/upload-download");
		// File Download
		WebElement download= driver.findElement(By.id("downloadButton"));
		download.click();
		
	    //Storing the file location in a variable where FILE is a class in selenium which is to access files
		File loc = new File("C:\\Users\\pooja\\Downloads");
		File[] file =loc.listFiles();// File list will be collected in File array
		for (File file2 : file) {
			
			if(file2.getName().equals("sampleFile.jpeg")) {
				
			System.out.println("filepresent");
			break;
		}
		

	}		
		
	}
}



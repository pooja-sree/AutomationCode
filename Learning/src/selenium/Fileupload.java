package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fileupload {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		

		System.setProperty("Webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/file.xhtml");
		
		//To click on upload button
		WebElement upload = driver.findElement(By.id("j_idt88:j_idt89"));
		upload.click();
		
		//To access window tool to upload file
		//store file location in a string
		String File = "C:\\Users\\pooja\\Downloads\\1.docx";
		
		//String selection is used for identifying transfer location.
		StringSelection transfer = new StringSelection(File);
		
		//Toolkit is a class where the data is stored temporarily.when we cut or copy the values are stored in a temp storage called clipboard.
		//to access it from toolkit, deftoolkit is used to fetch clipboard, setcontent is to pass the file location from stringselection.
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(transfer, null);
		
		//To interact with Window Elements We use Robot class
		//here we are pasting the file location in filename textbox and clicking enter
		Robot rob = new Robot();
		//Here it uses the virtual keyboard 
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		

	}

}

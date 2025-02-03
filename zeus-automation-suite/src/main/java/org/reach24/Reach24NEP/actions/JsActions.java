package org.reach24.Reach24NEP.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.reach24.Reach24NEP.util.Wait;

public class JsActions {

	Wait wait;
	WebDriver driver;
	 
    public JsActions(WebDriver driver) {
        this.driver = driver;
    }

	public void highlightElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", ele);
		js.executeScript("window.scrollBy(0,100)", "");
		js.executeScript("arguments[0].setAttribute('style', 'border:3px solid green; background:LightCoral')", ele);
	}

	public void scrollIntoView(WebElement elementLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elementLocator);
	}

	public void jsclick(WebElement elementLocator) {
		boolean flag=false;
		try {
				highlightElement(elementLocator);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", elementLocator);
				flag=true;
		}catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				System.out.println(elementLocator +" - jsClicked");	
			}else {
				System.out.println(elementLocator +" - jsClicked not clicked");
			}
		}
	}

	public void scrolldownandJsClick(WebElement elementLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elementLocator);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
		js.executeScript("arguments[0].click();", elementLocator);
	}

	public void jsInput(WebElement elementLocator, String input) {
		highlightElement(elementLocator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + input + "';", elementLocator);
	}
	
	public void robotPressEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
}

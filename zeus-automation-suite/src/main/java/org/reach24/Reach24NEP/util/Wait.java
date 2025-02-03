package org.reach24.Reach24NEP.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	 private WebDriver driver;
	 
	    public Wait(WebDriver driver) {
	        this.driver = driver;
	    }
	    PropsReader propsReader  = new PropsReader();
	 	int timeout = PropsReader.timeoutInSeconds;
	int timeoutLess = PropsReader.timeoutLessInSeconds;
	    @SuppressWarnings("unchecked")
		private void waitUntilCondition(@SuppressWarnings("rawtypes") ExpectedCondition condition, String timeoutMessage, int timeout) {
	        WebDriverWait wait = new WebDriverWait(driver, timeout);
	        wait.withMessage(timeoutMessage);
	        wait.until(condition);
	    }

	    public void forLoading(){
	        ExpectedCondition<Object> condition = ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
	        String timeoutMessage = "Page didn't load after " + Integer.toString(timeout) + " seconds.";
	        waitUntilCondition(condition, timeoutMessage, timeout);
	    }

	    public void forElementToBeDisplayed(WebElement webElement){
	        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
	        String timeoutMessage = webElement + " wasn't displayed after " + Integer.toString(timeout) + " seconds.";
	        waitUntilCondition(condition, timeoutMessage, timeout);
	    }
	public void forElementToBeDisplayedLess(WebElement webElement){
		ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
		String timeoutMessage = webElement + " wasn't displayed after " + Integer.toString(timeoutLess) + " seconds.";
		waitUntilCondition(condition, timeoutMessage, timeout);
	}

	    public void forPresenceOfElements(By elementLocator){
	        ExpectedCondition<List<WebElement>> condition = ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator);
	        String timeoutMessage = elementLocator + " elements were not displayed after " + Integer.toString(timeout) + " seconds.";
	        waitUntilCondition(condition, timeoutMessage, timeout);
	    }
	    
	    public void forElementToBeClickable(WebElement webElement){
	        ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(webElement);
	        String timeoutMessage = webElement + " wasn't displayed after " + Integer.toString(timeout) + " seconds.";
	        waitUntilCondition(condition, timeoutMessage, timeout);
	    }

}

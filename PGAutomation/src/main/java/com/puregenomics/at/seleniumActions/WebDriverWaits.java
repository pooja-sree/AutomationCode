package com.puregenomics.at.seleniumActions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebDriverWaits {
	static final Logger logger = Logger.getLogger(WebDriverWaits.class);

	/* To wait till a particular time interval
	@Parameters : Browser and Time Interval in seconds */
	public static void implicitlyWaitFor(WebDriver driver, int seconds)
	{
		logger.info("--------	implicitlyWaitFor wrapper method inside MyWait class is invoked successfully	--------");
		try
		{		
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);	
			logger.info("--------	implicitlyWaitFor wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO IMPLICITLY WAIT FOR SPECIFIED TIME INTERVAL : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO IMPLICITLY WAIT FOR SPECIFIED TIME INTERVAL");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO IMPLICITLY WAIT FOR SPECIFIED TIME INTERVAL : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO IMPLICITLY WAIT FOR SPECIFIED TIME INTERVAL");			
		}
	}
	
	/* To wait till a particular WebPage loads
	@Parameters : Browser and Time Interval in seconds */
	public static void tillPageLoads(WebDriver driver, int seconds)
	{
		logger.info("--------	tillPageLoads wrapper method inside MyWait class is invoked successfully	--------");
		try
		{			
			driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
			logger.info("--------	tillPageLoads wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT TILL SPCIFIED WEBPAGE LOADS : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT TILL SPCIFIED WEBPAGE LOADS");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT TILL SPCIFIED WEBPAGE LOADS : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO WAIT TILL SPCIFIED WEBPAGE LOADS");			
		}
	}
	
	/* To wait till an alert window is visible
	@Parameters : Browser and Time Interval in seconds */
	public static void untilAlerIsPresent(WebDriver driver, int secs)
	{
		logger.info("--------	untilAlerIsPresent wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;		
		try
		{		
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.alertIsPresent());
			logger.info("--------	untilAlerIsPresent wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL AN ALERT WINDOW IS PRESENT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL AN ALERT WINDOW IS PRESENT");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL AN ALERT WINDOW IS PRESENT : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO WAIT UNTIL AN ALERT WINDOW IS PRESENT");			
		}
	}
	
	/* To wait till a WebElement is visible
	@Parameters : Browser, WebElement and Time Interval in seconds */
	public static void untilElementIsVisible(WebDriver driver, WebElement element, int secs)
	{
		logger.info("--------	untilElementIsVisible wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{			
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("--------	untilElementIsVisible wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(NoSuchElementException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF THE SPECIFIED WEB ELEMENT");			
		}
		catch(StaleElementReferenceException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("StaleElementReferenceException : WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF THE SPECIFIED WEB ELEMENT");			
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF THE SPECIFIED WEB ELEMENT");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF THE SPECIFIED WEB ELEMENT");			
		}
	}
	
	/* To wait till a set of WebElements are visible
	@Parameters : Browser, WebElement list and Time Interval in seconds */
	public static void waitUntilVisibilityOfAllElements(WebDriver driver, List<WebElement> elements, int secs)
	{
		logger.info("--------	waitUntilVisibilityOfAllElements wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			logger.info("--------	waitUntilVisibilityOfAllElements wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(NoSuchElementException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF ALL THE SPECIFIED WEB ELEMENTS : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF ALL THE SPECIFIED WEB ELEMENTS");			
		}
		catch(StaleElementReferenceException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF ALL THE SPECIFIED WEB ELEMENTS : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF ALL THE SPECIFIED WEB ELEMENTS");			
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF ALL THE SPECIFIED WEB ELEMENTS : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF ALL THE SPECIFIED WEB ELEMENTS");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF ALL THE SPECIFIED WEB ELEMENTS : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO WAIT UNTIL THE VISIBILITY OF ALL THE SPECIFIED WEB ELEMENTS");		
		}
	}
	
	/* To wait till a WebElement is clickable
	@Parameters : Browser, WebElement and Time Interval in seconds */
	public static void untilElementIsClickable(WebDriver driver, WebElement element, int secs)
	{
		logger.info("--------	untilElementIsClickable wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;		
		try
		{			
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.elementToBeClickable(element));	
			logger.info("--------	untilElementIsClickable wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(NoSuchElementException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS CLICKABLE : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS CLICKABLE");			
		}
		catch(StaleElementReferenceException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS CLICKABLE : "+error.getMessage());
			Assert.fail("StaleElementReferenceException : WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS CLICKABLE");			
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS CLICKABLE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS CLICKABLE");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS CLICKABLE : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS CLICKABLE");			
		}
	}
	
	/* To wait till a WebElement is selected
	@Parameters : Browser, WebElement and Time Interval in seconds */
	public static void untilElementIsSelected(WebDriver driver, WebElement element, int secs)
	{
		logger.info("--------	untilElementIsSelected wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;		
		try
		{		
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.elementToBeSelected(element));
			logger.info("--------	untilElementIsSelected wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(NoSuchElementException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS SELECTABLE : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS SELECTABLE");			
		}
		catch(StaleElementReferenceException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS SELECTABLE : "+error.getMessage());
			Assert.fail("StaleElementReferenceException : WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS SELECTABLE");			
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS SELECTABLE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS SELECTABLE");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS SELECTABLE : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO WAIT UNTIL THE SPECIFIED WEB ELEMENT IS SELECTABLE");			
		}
	}
	
	public static void waitUntilTitleIs(WebDriver driver, int secs, String title)
	{
		logger.info("--------	waitUntilTitleIs wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.titleIs(title));
			logger.info("--------	waitUntilTitleIs wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE PAGE TITLE MATCHES SPECIFIED TITLE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL THE PAGE TITLE MATCHES SPECIFIED TITLE");
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE PAGE TITLE MATCHES SPECIFIED TITLE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL THE PAGE TITLE MATCHES SPECIFIED TITLE");			
		}
	}
	
	/* To wait till the Page Title contains a particular text
	@Parameters : Browser, Text and Time Interval in seconds */
	public static void untilPageTitleContains(WebDriver driver, String text, int secs)
	{
		logger.info("--------	untilPageTitleContains wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;		
		try
		{			
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.titleContains(text));
			logger.info("--------	untilPageTitleContains wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE PAGE TITLE CONTAINS SPECIFIED TEXT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL THE PAGE TITLE CONTAINS SPECIFIED TEXT");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE PAGE TITLE CONTAINS SPECIFIED TEXT : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO WAIT UNTIL THE PAGE TITLE CONTAINS SPECIFIED TEXT");			
		}
	}
	
	/* To wait till the expected Page URL
	@Parameters : Browser, URL and Time Interval in seconds */
	public static void waitUntilUrlToBe(WebDriver driver, String url, int secs)
	{
		logger.info("--------	waitUntilUrlToBe wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.urlToBe(url));
			logger.info("--------	waitUntilUrlToBe wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED PAGE URL : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED PAGE URL");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED PAGE URL : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED PAGE URL");			
		}
	}
	
	/* To wait till the Page URL matches given regular expression
	@Parameters : Browser, URL and Time Interval in seconds */
	public static void waitUntilUrlMatches(WebDriver driver, String regexp, int secs)
	{
		logger.info("--------	waitUntilUrlMatches wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.urlMatches(regexp));
			logger.info("--------	waitUntilUrlMatches wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE PAGE URL MATCHES SPECIFIED TEXT: "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL THE PAGE URL MATCHES SPECIFIED TEXT");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE PAGE URL MATCHES SPECIFIED TEXT: "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL THE PAGE URL MATCHES SPECIFIED TEXT");			
		}
	}
	
	/* To wait till the Page URL contains specified text
	@Parameters : Browser, text and Time Interval in seconds */
	public static void waitUntilUrlContains(WebDriver driver, String fraction, int secs)
	{
		logger.info("--------	waitUntilUrlContains wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.urlContains(fraction));
			logger.info("--------	waitUntilUrlContains wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE PAGE URL CONTAINS SPECIFIED TEXT: "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL THE PAGE URL CONTAINS SPECIFIED TEXT");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL THE PAGE URL CONTAINS SPECIFIED TEXT: "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL THE PAGE URL CONTAINS SPECIFIED TEXT");			
		}
	}

	/* To wait till a particular text is present in the WebElement
	@Parameters : Browser, WebElement, Text and Time Interval in seconds */
	public static void untilTextPresentInElement(WebDriver driver, WebElement element, String text, int secs)
	{
		logger.info("--------	untilTextPresentInElement wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;		
		try
		{			
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));		
			logger.info("--------	untilTextPresentInElement wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(NoSuchElementException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SOME TEXT IS PRESENT ON THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO WAIT UNTIL SOME TEXT IS PRESENT ON THE SPECIFIED WEB ELEMENT");			
		}
		catch(StaleElementReferenceException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SOME TEXT IS PRESENT ON THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("StaleElementReferenceException : WHILE TRYING TO WAIT UNTIL SOME TEXT IS PRESENT ON THE SPECIFIED WEB ELEMENT");			
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SOME TEXT IS PRESENT ON THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SOME TEXT IS PRESENT ON THE SPECIFIED WEB ELEMENT");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SOME TEXT IS PRESENT ON THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO WAIT UNTIL SOME TEXT IS PRESENT ON THE SPECIFIED WEB ELEMENT");			
		}
	}
	
	/* To wait till a particular frame appears and switch to it
	@Parameters : Browser, Text and Time Interval in seconds */
	public static void waitUntilFrameAndSwitchToIt(WebDriver driver, By locator, int secs)
	{
		logger.info("--------	waitUntilFrameAndSwitchToIt wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
			logger.info("--------	waitUntilFrameAndSwitchToIt wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT");			
		}
	}
	
	/* To wait till a particular frame appears and switch to it
	@Parameters : Browser, frame index and Time Interval in seconds */
	public static void waitUntilFrameAndSwitchToIt(WebDriver driver, int frameIndex, int secs)
	{
		logger.info("--------	waitUntilFrameAndSwitchToIt wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
			logger.info("--------	waitUntilFrameAndSwitchToIt wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT");			
		}
	}
	
	/* To wait till a particular frame appears and switch to it
	@Parameters : Browser, frame locator and Time Interval in seconds */
	public static void waitUntilFrameAndSwitchToIt(WebDriver driver, String frameLocator, int secs)
	{
		logger.info("--------	waitUntilFrameAndSwitchToIt wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
			logger.info("--------	waitUntilFrameAndSwitchToIt wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT");			
		}
	}
	
	/* To wait till a particular frame appears and switch to it
	@Parameters : Browser, WebElement and Time Interval in seconds */
	public static void waitUntilFrameAndSwitchToIt(WebDriver driver, WebElement element, int secs)
	{
		logger.info("--------	waitUntilFrameAndSwitchToIt wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
			logger.info("--------	waitUntilFrameAndSwitchToIt wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(NoSuchElementException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT");			
		}
		catch(StaleElementReferenceException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT");			
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED FRAME APPEARS AND SWITCH TO IT");			
		}
	}
	
	/* To wait till a particular web element appears
	@Parameters : Browser, element locator and Time Interval in seconds */
	public static void waitUntilPresenceOfElement(WebDriver driver, WebElement element, int secs)
	{
		logger.info("--------	waitUntilPresenceOfElement wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
			logger.info("--------	waitUntilPresenceOfElement wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED WEB ELEMENT APPEARS : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED WEB ELEMENT APPEARS");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED WEB ELEMENT APPEARS : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED WEB ELEMENT APPEARS");			
		}
	}
	
	/* To wait till a particular set of web elements appear
	@Parameters : Browser, elements locator and Time Interval in seconds */
	public static void waitUntilPresenceOfElements(WebDriver driver, By locator, int secs)
	{
		logger.info("--------	waitUntilPresenceOfElements wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			logger.info("--------	waitUntilPresenceOfElements wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED WEB ELEMENTS APPEAR : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED WEB ELEMENTS APPEAR");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL SPECIFIED WEB ELEMENTS APPEAR : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL SPECIFIED WEB ELEMENTS APPEAR");			
		}
	}
	
	/* To wait till staleness of a particular web element
	@Parameters : Browser, web element and Time Interval in seconds */
	public static void waitUntilStalenessOfElement(WebDriver driver, WebElement element, int secs)
	{
		logger.info("--------	waitUntilStalenessOfElement wrapper method inside MyWait class is invoked successfully	--------");
		WebDriverWait wait;
		try
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
			wait.until(ExpectedConditions.stalenessOf(element));
			logger.info("--------	waitUntilStalenessOfElement wrapper method inside MyWait class is executed successfully	--------");
		}
		catch(NoSuchElementException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL STALENESS OF THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL STALENESS OF THE SPECIFIED WEB ELEMENT");			
		}
		catch(StaleElementReferenceException error)
		{			
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL STALENESS OF THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL STALENESS OF THE SPECIFIED WEB ELEMENT");			
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL STALENESS OF THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL STALENESS OF THE SPECIFIED WEB ELEMENT");	
		}
		catch(Exception error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT UNTIL STALENESS OF THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO WAIT UNTIL STALENESS OF THE SPECIFIED WEB ELEMENT");			
		}
	}


}

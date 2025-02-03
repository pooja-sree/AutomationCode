package com.puregenomics.at.seleniumActions;

import java.util.List;
import java.util.NoSuchElementException;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.log4j.Logger;
public class JavaScriptActions {
static final Logger logger = Logger.getLogger(String.valueOf(JavaScriptActions.class));

	
	/* To click on the specified web element
	@Parameter : Browser and Web element */
	public static void Click(WebDriver driver, WebElement element) throws StaleElementReferenceException, Exception {
		logger.info("--------	Click wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		try
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
			logger.info("--------	Click wrapper method inside MyJScriptAction class is executed successfully	--------");
		}
		catch(NoSuchElementException | WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT");			
		}
	}
	
	/* To click on the specified web element
	@Parameter : Browser and Web element locator */
	public static void Click(WebDriver driver, String idValue)
	{
		logger.info("--------	Click wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		try
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("document.getElementById('"+idValue+"').click()");
			logger.info("--------	Click wrapper method inside MyJScriptAction class is executed successfully	--------");
		} catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT");
		}
	}
	
	/* To type the specified text
	@Parameter : Browser, Web element locator and Text */
	public static void TypeText(WebDriver driver, String idValue, String text) throws Exception {
		logger.info("--------	TypeText wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		try
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("document.getElementById('"+idValue+"').value='"+text+"'");
			logger.info("--------	TypeText wrapper method inside MyJScriptAction class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO TYPE THE SPECIFIED TEXT : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO TYPE THE SPECIFIED TEXT");	
		}
	}
	
	/* To find a particular web element using its ID locator
	@Parameter : Browser, Web element locator and Text */
	public static WebElement FindElementByID(WebDriver driver, String idValue, String text) throws Exception {
		logger.info("--------	FindElementByID wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		WebElement element = null;
		try
		{
			js = (JavascriptExecutor)driver;
			element = (WebElement) js.executeScript("return document.getElementById('"+idValue+"');");
			logger.info("--------	FindElementByID wrapper method inside MyJScriptAction class is executed successfully	--------");
			return element;
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO FIND A PARTICUALR WEB ELEMENT USING IT'S ID LOCATOR : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO FIND A PARTICUALR WEB ELEMENT USING IT'S ID LOCATOR");	
		}
		return element;
	}
	
	/* To refresh the active browser session
	@Parameter : Browser */
	public static void RefreshPage(WebDriver driver) throws Exception {
		//logger.info("--------	RefreshPage wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		try
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("history.go(0)");
			logger.info("--------	RefreshPage wrapper method inside MyJScriptAction class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO REFRESH THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO REFRESH THE ACTIVE BROWSER SESSION");	
		}
	}
	
	/* To the page text of the active browser session
	@Parameter : Browser */
	public static String GetPageText(WebDriver driver) throws Exception {
		logger.info("--------	GetPageText wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		String pageText="";
		try
		{
			js = (JavascriptExecutor)driver;
			pageText =  js.executeScript("return document.documentElement.innerText;").toString();
			logger.info("--------	GetPageText wrapper method inside MyJScriptAction class is executed successfully	--------");
			return pageText;	
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO GET THE PAGE TEXT OF THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO GET THE PAGE TEXT OF THE ACTIVE BROWSER SESSION");	
		}
		return pageText;
	}
	
	/* To get the Page Title from the active browser session
	@Parameter : Browser */
	public static String GetPageTitle(WebDriver driver)
	{
		logger.info("--------	GetPageTitle wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		String pageTitle="";
		try
		{
			js = (JavascriptExecutor)driver;
			pageTitle =  js.executeScript("return document.title;").toString();
			logger.info("--------	GetPageTitle wrapper method inside MyJScriptAction class is executed successfully	--------");
			return pageTitle;	
		} catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE PAGE TITLE OF THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO GET THE PAGE TITLE OF THE ACTIVE BROWSER SESSION");
		}
		return pageTitle;
	}
	
	/* To get the Page URL from the active browser session
	@Parameter : Browser */
	public static String GetPageURL(WebDriver driver)
	{
		logger.info("--------	GetPageURL wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		String pageURL="";
		try
		{
			js = (JavascriptExecutor)driver;
			pageURL =  js.executeScript("return document.URL;").toString();
			logger.info("--------	GetPageURL wrapper method inside MyJScriptAction class is executed successfully	--------");
			return pageURL;	
		} catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE PAGE URL OF THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO GET THE PAGE URL OF THE ACTIVE BROWSER SESSION");
		}
		return pageURL;
	}
	
	/* To scroll the page to specified coordinates
	@Parameter : Browser and coordinates */
	public static void ScrollPage(WebDriver driver, int pixel)
	{
		logger.info("--------	ScrollPage wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		try
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,"+pixel+")");
			logger.info("--------	ScrollPage wrapper method inside MyJScriptAction class is executed successfully	--------");
		} catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO SCROLL THE WEB PAGE TO SPECIFIED PIXEL : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO SCROLL THE WEB PAGE TO SPECIFIED PIXEL");
		}
	}
	
	/* To scroll the page to specified web element
	@Parameter : Browser and web element */
	public static void ScrollPage(WebDriver driver, WebElement element) throws StaleElementReferenceException, WebDriverException, Exception {
		logger.info("--------	ScrollPage wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		try
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",element);
			logger.info("--------	ScrollPage wrapper method inside MyJScriptAction class is executed successfully	--------");
		}
		catch(NoSuchElementException error)
		{			
			logger.error("ERROR WHILE TRYING TO SCROLL THE WEB PAGE TO SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO SCROLL THE WEB PAGE TO SPECIFIED WEB ELEMENT");				
		}
	}
	
	/* To scroll the page to specified web element with point
	@Parameter : Browser and web element */
	
	public static void ScrollPageWithPoint(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js;
		Point hoverItem = element.getLocation();
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0," + (hoverItem.getX()) + ");");
	  
	}

	/* To scroll the page to specified web element Horizontally
	@Parameter : Browser and web element */
	
	public static void ScrollPageHorizontally(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js;
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(100)");
	  
	}
	
	/* To scroll to the bottom of the web page
	@Parameter : Browser */
	public static void PageDown(WebDriver driver) throws Exception {
		logger.info("--------	PageDown wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		try
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			logger.info("--------	PageDown wrapper method inside MyJScriptAction class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO SCROLL TO THE BOTTOM OF THE WEB PAGE : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO SCROLL TO THE BOTTOM OF THE WEB PAGE");	
		}
	}
	
	/* To mouse over and click on the sub menu
	@Parameter : Browser, class name and index */
	public static void MouseOverAndClickSubMenu(WebDriver driver, String className, int i) throws Exception {
		logger.info("--------	MouseOverAndClickSubMenu wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		try
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("$('ul."+className+" li["+i+"]').hover()");
			logger.info("--------	MouseOverAndClickSubMenu wrapper method inside MyJScriptAction class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO MOUSE OVER AND CLICK ON A SUB MENU : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO MOUSE OVER AND CLICK ON A SUB MENU");	
		}
	}
	
	/* To navigate to specified URL
	@Parameter : Browser and URL */
	public static void NavigateTo(WebDriver driver, String url) throws Exception {
		logger.info("--------	NavigateTo wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		try
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("window.location = '"+url+"'");
			logger.info("--------	NavigateTo wrapper method inside MyJScriptAction class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO NAVIGATE TO THE SPECIFIED URL : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO NAVIGATE TO THE SPECIFIED URL");	
		}
	}
	
	/* To navigate to specified URL in a new tab
	@Parameter : Browser and URL */
	public static void NavigateToInNewTab(WebDriver driver, String url) throws Exception {
		logger.info("--------	NavigateToInNewTab wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		try
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("window.open = '"+url+"'");
			logger.info("--------	NavigateToInNewTab wrapper method inside MyJScriptAction class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO NAVIGATE TO THE SPECIFIED URL INSIDE NEW TAB : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO NAVIGATE TO THE SPECIFIED URL INSIDE NEW TAB");	
		}
	}
	
	/* To highlight the specified web element
	@Parameter : Browser, web element and color */
	public static void Hightlight(WebDriver driver, WebElement element, String colour) throws Exception {
		logger.info("--------	Hightlight wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		try
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].style.border='3px dotted "+colour+"'", element);
			logger.info("--------	Hightlight wrapper method inside MyJScriptAction class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO HIGHLIGHT THE SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO HIGHLIGHT THE SPECIFIED WEB ELEMENT");	
		}
	}
	
	/* To highlight the specified web elements
	@Parameter : Browser, web elements locator, locator value and color */
	public static void Hightlight(WebDriver driver, String locator, String locatorValue, String colour) throws Exception {
		logger.info("--------	Hightlight wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		try
		{
			js = (JavascriptExecutor)driver;
			js.executeScript("document.getElementsBy"+locator+"('"+locatorValue+"')[0].style.border='3px dotted "+colour+"'");
			logger.info("--------	Hightlight wrapper method inside MyJScriptAction class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO HIGHLIGHT THE SPECIFIED WEB ELEMENTS : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO HIGHLIGHT THE SPECIFIED WEB ELEMENTS");	
		}
	}
	
	/* To wait till a web page loads
	@Parameter : Browser, and time interval */
	public static void WaitTillPageLoads(WebDriver driver, long milisecs) throws Exception {
		logger.info("--------	WaitTillPageLoads wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		//String loadingState = "";
		try
		{
			js = (JavascriptExecutor)driver;
			String loadingState = (String) js.executeScript("return document.readyState.toString()");

			while(loadingState!="complete")
				Thread.sleep(milisecs);
			logger.info("--------	WaitTillPageLoads wrapper method inside MyJScriptAction class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO WAIT TILL A WEB PAGE LOADS : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO WAIT TILL A WEB PAGE LOADS");	
		}
	}
	
	/* To find web element by name locator
	@Parameter : Browser, and name locator value */
	public static WebElement FindElementByName(WebDriver driver, String nameValue) throws Exception {
		logger.info("--------	FindElementByName wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		WebElement element = null;
		try
		{
			js = (JavascriptExecutor)driver;
			element = (WebElement) js.executeScript("return document.getElementsByName('"+nameValue+"')[0];");
			logger.info("--------	FindElementByName wrapper method inside MyJScriptAction class is executed successfully	--------");
			return element;
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO FIND A WEB ELEMENT USING NAME LOCATOR : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO FIND A WEB ELEMENT USING NAME LOCATOR");	
		}
		return element;
	}
	
	/* To find web element by class name locator
	@Parameter : Browser, and class name locator value */
	public static WebElement FindElementByClassName(WebDriver driver, String classnameValue) throws Exception {
		logger.info("--------	FindElementByClassName wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		WebElement element = null;
		try
		{
			js = (JavascriptExecutor)driver;
			element = (WebElement) js.executeScript("return document.getElementsByClassName('"+classnameValue+"')[0];");
			logger.info("--------	FindElementByClassName wrapper method inside MyJScriptAction class is executed successfully	--------");
			return element;
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO FIND A WEB ELEMENT USING CLASS NAME LOCATOR : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO FIND A WEB ELEMENT USING CLASS NAME LOCATOR");	
		}
		return element;
	}
	
	/* To find web element by tag name locator
	@Parameter : Browser, and tag name locator value */
	public static WebElement FindElementByTagName(WebDriver driver, String tagValue) throws Exception {
		logger.info("--------	FindElementByTagName wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		WebElement element = null;
		try
		{
			js = (JavascriptExecutor)driver;
			element = (WebElement) js.executeScript("return document.getElementsByTagName('"+tagValue+"')[0];");
			logger.info("--------	FindElementByTagName wrapper method inside MyJScriptAction class is executed successfully	--------");
			return element;
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO FIND A WEB ELEMENT USING TAG NAME LOCATOR : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO FIND A WEB ELEMENT USING TAG NAME LOCATOR");	
		}
		return element;
	}
	
	/* To find web elements by name locator
	@Parameter : Browser, and name locator value */
	@SuppressWarnings("unchecked")
	public static List<WebElement> FindElementsByName(WebDriver driver, String tagValue) throws Exception {
		logger.info("--------	FindElementsByName wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		List<WebElement> elements = null;
		try
		{
			js = (JavascriptExecutor)driver;
			elements = (List<WebElement>) js.executeScript("return document.getElementsByName('"+tagValue+"');");
			logger.info("--------	FindElementsByName wrapper method inside MyJScriptAction class is executed successfully	--------");
			return elements;
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO FIND A WEB ELEMENTS USING NAME LOCATOR : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO FIND A WEB ELEMENTS USING NAME LOCATOR");	
		}
		return elements;
	}
	
	/* To find web elements by class name locator
	@Parameter : Browser, and class name locator value */
	@SuppressWarnings("unchecked")
	public static List<WebElement> FindElementsByClassName(WebDriver driver, String tagValue) throws Exception {
		logger.info("--------	FindElementsByClassName wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		List<WebElement> elements = null;
		try
		{
			js = (JavascriptExecutor)driver;
			elements = (List<WebElement>) js.executeScript("return document.getElementsByClassName('"+tagValue+"');");
			logger.info("--------	FindElementsByClassName wrapper method inside MyJScriptAction class is executed successfully	--------");
			return elements;
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO FIND A WEB ELEMENTS USING CLASS NAME LOCATOR : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO FIND A WEB ELEMENTS USING CLASS NAME LOCATOR");	
		}
		return elements;
	}
	
	/* To find web elements by tag name locator
	@Parameter : Browser, and tag name locator value */
	@SuppressWarnings("unchecked")
	public static List<WebElement> FindElementsByTagName(WebDriver driver, String tagValue) throws Exception {
		logger.info("--------	FindElementsByTagName wrapper method inside MyJScriptAction class is invoked successfully	--------");
		JavascriptExecutor js;
		List<WebElement> elements = null;
		try
		{
			js = (JavascriptExecutor)driver;
			elements = (List<WebElement>) js.executeScript("return document.getElementsByTagName('"+tagValue+"');");
			logger.info("--------	FindElementsByTagName wrapper method inside MyJScriptAction class is executed successfully	--------");
			return elements;
		}
		catch(WebDriverException error)
		{		
			logger.error("ERROR WHILE TRYING TO FIND A WEB ELEMENTS USING TAG NAME LOCATOR : "+error.getMessage());
			Assert.fail("NoSuchElementException : WHILE TRYING TO FIND A WEB ELEMENTS USING TAG NAME LOCATOR");	
		}
		return elements;
	}
}

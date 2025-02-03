package com.puregenomics.at.seleniumActions;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebdriverMethods {
	
	static final Logger logger = Logger.getLogger(WebdriverMethods.class);

	/* To close only the active browser session
	@Parameter : Browser */
	public static void close(WebDriver driver)
	{
		logger.info("--------	close wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.close();
			logger.info("--------	close wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO CLOSE THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO CLOSE THE ACTIVE BROWSER SESSION");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO CLOSE THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO CLOSE THE ACTIVE BROWSER SESSION");
		}
	}
	
	/* To close all browser sessions
	@Parameter : Browser */
	public static void closeAll(WebDriver driver)
	{
		logger.info("--------	closeAll wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.quit();
			logger.info("--------	closeAll wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO CLOSE ALL THE BROWSER SESSIONS : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO CLOSE ALL THE BROWSER SESSIONS");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO CLOSE ALL THE BROWSER SESSIONS : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO CLOSE ALL THE BROWSER SESSIONS");
		}	
	}
	
	/* To get the Page Title
	@Parameter : Browser */
	public static String getPageTitle(WebDriver driver)
	{
		logger.info("--------	getPageTitle wrapper method inside MyWebDriver class is invoked successfully	--------");
		String pageTitle = "";
		pageTitle = driver.getTitle();
		return pageTitle;	

		/*try
		{
			pageTitle = driver.getTitle();
			logger.info("--------	getPageTitle wrapper method inside MyWebDriver class is executed successfully	--------");
			return pageTitle;	
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE PAGE TITLE FROM THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO GET THE PAGE TITLE FROM THE ACTIVE BROWSER SESSION");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE PAGE TITLE FROM THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO GET THE PAGE TITLE FROM THE ACTIVE BROWSER SESSION");
		}
		return pageTitle;*/
	}
	
	/* To maximize the browser session
	@Parameter : Browser */
	public static void maximize(WebDriver driver)
	{
		logger.info("--------	maximize wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.manage().window().maximize();
			logger.info("--------	maximize wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO MAXIMIZE THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO MAXIMIZE THE ACTIVE BROWSER SESSION");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO MAXIMIZE THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO MAXIMIZE THE ACTIVE BROWSER SESSION");
		}
	}
	
	/* To convert the browser session into Full screen mode
	@Parameter : Browser */
	public static void fullscreenMode(WebDriver driver)
	{
		logger.info("--------	fullscreenMode wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.manage().window().fullscreen();	
			logger.info("--------	fullscreenMode wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE ACTIVE BROWSER SESSION INTO FULL SCREEN MODE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO GET THE ACTIVE BROWSER SESSION INTO FULL SCREEN MODE");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE ACTIVE BROWSER SESSION INTO FULL SCREEN MODE : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO GET THE ACTIVE BROWSER SESSION INTO FULL SCREEN MODE");
		}
	}
	
	/* To get the URL from the active browser session
	@Parameter : Browser */
	public static String getCurrentUrl(WebDriver driver)
	{
		logger.info("--------	getCurrentUrl wrapper method inside MyWebDriver class is invoked successfully	--------");
		String currentUrl="";
		try
		{
			currentUrl = driver.getCurrentUrl();
			logger.info("--------	getCurrentUrl wrapper method inside MyWebDriver class is executed successfully	--------");
			return currentUrl;	
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE URL FROM ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO GET THE URL FROM ACTIVE BROWSER SESSION");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE URL FROM ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO GET THE URL FROM ACTIVE BROWSER SESSION");
		}
		return currentUrl;
	}
	
	/* To get the Page source from the active browser session
	@Parameter : Browser */
	public static String getPageSource(WebDriver driver)
	{
		logger.info("--------	getPageSource wrapper method inside MyWebDriver class is invoked successfully	--------");
		String pageSource="";
		try
		{
			pageSource = driver.getPageSource();
			logger.info("--------	getPageSource wrapper method inside MyWebDriver class is executed successfully	--------");
			return pageSource;
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE PAGE SOURCE FROM ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO GET THE PAGE SOURCE FROM ACTIVE BROWSER SESSION");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE PAGE SOURCE FROM ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO GET THE PAGE SOURCE FROM ACTIVE BROWSER SESSION");
		}
		return pageSource;
	}
	
	/* To navigate forward on the browser page
	@Parameter : Browser */
	public static void navigateForward(WebDriver driver)
	{
		logger.info("--------	navigateForward wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.navigate().forward();
			logger.info("--------	navigateForward wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO NAVIGATE FORWARD ON THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO NAVIGATE FORWARD ON THE ACTIVE BROWSER SESSION");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO NAVIGATE FORWARD ON THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO NAVIGATE FORWARD ON THE ACTIVE BROWSER SESSION");
		}
	}
	
	/* To navigate backward on the browser page
	@Parameter : Browser */
	public static void navigateBackward(WebDriver driver)
	{
		logger.info("--------	navigateback wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.navigate().back();
			logger.info("--------	navigateback wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO NAVIGATE BACKWARD ON THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO NAVIGATE BACKWARD ON THE ACTIVE BROWSER SESSION");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO NAVIGATE BACKWARD ON THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO NAVIGATE BACKWARD ON THE ACTIVE BROWSER SESSION");
		}
	}
	
	/* To refresh the browser page
	@Parameter : Browser */
	public static void pageRefresh(WebDriver driver)
	{
		logger.info("--------	pageRefresh wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.navigate().refresh();
			logger.info("--------	pageRefresh wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO DO A PAGE REFRESH ON THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO DO A PAGE REFRESH ON THE ACTIVE BROWSER SESSION");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO DO A PAGE REFRESH ON THE ACTIVE BROWSER SESSION : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO DO A PAGE REFRESH ON THE ACTIVE BROWSER SESSION");
		}
	}
	
	/* To navigate to the required web URL
	@Parameters : Browser and web URL */
	public static void navigateTo(WebDriver driver, String url)
	{
		logger.info("--------	navigateTo wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.navigate().to(url);
			logger.info("--------	navigateTo wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO NAVIGATE TO THE SPEFICIED WEBSITE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO NAVIGATE TO THE SPEFICIED WEBSITE");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO NAVIGATE TO THE SPEFICIED WEBSITE : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO NAVIGATE TO THE SPEFICIED WEBSITE");
		}
	}
	
	/* Get to the required web URL
	@Parameters : Browser and web URL */
	public static void getTo(WebDriver driver, String url)
	{
		logger.info("--------	getMeTo wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.get(url);	
			logger.info("--------	getMeTo wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO GET TO THE SPECIFIED WEBSITE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO GET TO THE SPECIFIED WEBSITE");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO GET TO THE SPECIFIED WEBSITE : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO GET TO THE SPECIFIED WEBSITE");
		}
	}
	
	/* To locate any WebElement
	@Parameters : Browser and locator */
	public static WebElement locateElement(WebDriver driver, By locator)
	{
		logger.info("--------	locateElement wrapper method inside MyWebDriver class is invoked successfully	--------");
		WebElement element = null;		
		try
		{
			element = driver.findElement(locator);
			logger.info("--------	locateElement wrapper method inside MyWebDriver class is executed successfully	--------");
			return element;				
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO LOCATE A SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO LOCATE A SPECIFIED WEB ELEMENT");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO LOCATE A SPECIFIED WEB ELEMENT : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO LOCATE A SPECIFIED WEB ELEMENT");
		}
		return element;		
	}
	
	/* To locate multiple WebElements
	@Parameters : Browser and locator */
	public static List <WebElement> locateElements(WebDriver driver, By locator)
	{
		logger.info("--------	locateElements wrapper method inside MyWebDriver class is invoked successfully	--------");
		List <WebElement> elements = null;
		try
		{
			elements = driver.findElements(locator);
			logger.info("--------	locateElements wrapper method inside MyWebDriver class is executed successfully	--------");
			return elements;				
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO LOCATE MULTIPLE WEB ELEMENTS : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO LOCATE MULTIPLE WEB ELEMENTS");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO LOCATE MULTIPLE WEB ELEMENTS : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO LOCATE MULTIPLE WEB ELEMENTS");
		}
		return elements;		
	}
	
	/* To switch back to the parent window
	@Parameters : Browser */
	public static void switchToParentWindow(WebDriver driver)
	{
		logger.info("--------	switchToParentWindow wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.switchTo().defaultContent();
			logger.info("--------	switchToParentWindow wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH TO PARENT WINDOW : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO SWITCH TO PARENT WINDOW");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH TO PARENT WINDOW : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO SWITCH TO PARENT WINDOW");
		}
	}
	
	/* To switch to a frame using frame index
	@Parameters : Browser and frame index */
	public static void switchToFrame(WebDriver driver, int frameIndex)
	{
		logger.info("--------	switchToFrame wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.switchTo().frame(frameIndex);
			logger.info("--------	switchToFrame wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH A PARTICULAR FRAME USING FRAME INDEX : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO SWITCH A PARTICULAR FRAME USING FRAME INDEX");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH A PARTICULAR FRAME USING FRAME INDEX : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO SWITCH A PARTICULAR FRAME USING FRAME INDEX");
		}
	}
	
	/* To switch to a frame using frame locator
	@Parameters : Browser and frame locator */
	public static void switchToFrame(WebDriver driver, String locatorValue)
	{
		logger.info("--------	switchToFrame wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.switchTo().frame(locatorValue);
			logger.info("--------	switchToFrame wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH A PARTICULAR FRAME USING FRAME LOCATOR : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO SWITCH A PARTICULAR FRAME USING FRAME LOCATOR");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH A PARTICULAR FRAME USING FRAME LOCATOR : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO SWITCH A PARTICULAR FRAME USING FRAME LOCATOR");
		}
	}
	
	/* To switch to a frame using web element
	@Parameters : Browser and web element */
	public static void switchToFrame(WebDriver driver, WebElement element)
	{
		logger.info("--------	switchToFrame wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.switchTo().frame(element);
			logger.info("--------	switchToFrame wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH A PARTICULAR FRAME USING WEB ELEMENT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO SWITCH A PARTICULAR FRAME USING WEB ELEMENT");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH A PARTICULAR FRAME USING WEB ELEMENT : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO SWITCH A PARTICULAR FRAME USING WEB ELEMENT");
		}
	}
	
	/* To switch to parent frame
	@Parameters : Browser */
	public static void switchToParentFrame(WebDriver driver)
	{
		logger.info("--------	switchToParentFrame wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.switchTo().parentFrame();
			logger.info("--------	switchToParentFrame wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH TO PARENT FRAME : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO SWITCH TO PARENT FRAME");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH TO PARENT FRAME : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO SWITCH TO PARENT FRAME");
		}
	}
	
	/* To add a particular cookie
	@Parameters : Browser and Cookie */
	public static void addCookie(WebDriver driver, Cookie cookie)
	{
		logger.info("--------	addCookie wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.manage().addCookie(cookie);
			logger.info("--------	addCookie wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO ADD A PARTICULAR COOOKIE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO ADD A PARTICULAR COOOKIE");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO ADD A PARTICULAR COOOKIE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO ADD A PARTICULAR COOOKIE");
		}
	}
	
	/* To delete a particular cookie
	@Parameters : Browser and Cookie */
	public static void deleteCookie(WebDriver driver, Cookie cookie)
	{
		logger.info("--------	deleteCookie wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.manage().deleteCookie(cookie);
			logger.info("--------	deleteCookie wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO DELETE A PARTICULAR COOOKIE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO DELETE A PARTICULAR COOOKIE");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO DELETE A PARTICULAR COOOKIE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO DELETE A PARTICULAR COOOKIE");
		}
	}
	
	/* To delete all browser cookies
	@Parameters : Browser and web URL */
	public static void deleteAllCookies(WebDriver driver)
	{
		logger.info("--------	deleteAllCookies wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			driver.manage().deleteAllCookies();
			logger.info("--------	deleteAllCookies wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO DELETE ALL COOOKIES : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO DELETE ALL COOOKIES");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO DELETE ALL COOOKIES : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO DELETE ALL COOOKIES");
		}
	}
	
	/* To get window handle
	@Parameter : Browser */
	public static String getWindowHandle(WebDriver driver)
	{
		logger.info("--------	getWindowHandle wrapper method inside MyWebDriver class is invoked successfully	--------");
		String handle = "";
		try
		{
			handle = driver.getWindowHandle();
			logger.info("--------	getWindowHandle wrapper method inside MyWebDriver class is executed successfully	--------");
			return handle;
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE WINDOW HANDLE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO GET THE WINDOW HANDLE");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE WINDOW HANDLE : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO GET THE WINDOW HANDLE");
		}
		return handle;
	}
	
	/* To get window handles
	@Parameter : Browser */
	public static Set<String> getWindowHandles(WebDriver driver)
	{
		logger.info("--------	getWindowHandles wrapper method inside MyWebDriver class is invoked successfully	--------");
		Set<String> handles = null;
		try
		{
			handles = driver.getWindowHandles();
			logger.info("--------	getWindowHandles wrapper method inside MyWebDriver class is executed successfully	--------");
			return handles;
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE WINDOW HANDLES : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO GET THE WINDOW HANDLES");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO GET THE WINDOW HANDLES : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO GET THE WINDOW HANDLES");
		}
		return handles;
	}
	
	/* To switch to a window using window name
	@Parameter : Browser and window name */
	public static void switchToWindow(WebDriver driver, String windowName)
	{
		logger.info("--------	switchToWindow wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{
			boolean result = driver.getWindowHandle().equalsIgnoreCase(windowName);
			if(result==true)
			{
				driver.switchTo().window(windowName);
				logger.info("--------	switchToWindow wrapper method inside MyWebDriver class is executed successfully	--------");
			}
		}
		catch(WebDriverException error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH TO A WINDOW USING WINDOW NAME : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO SWITCH TO A WINDOW USING WINDOW NAME");
		}
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH TO A WINDOW USING WINDOW NAME : "+error.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO SWITCH TO A WINDOW USING WINDOW NAME");
		}
	}
	
	/* To check whether alert window is present
	@Parameter : Browser */
	public static boolean alertPresentOrNot(WebDriver driver)
	{
		logger.info("--------	alertPresentOrNot wrapper method inside MyWebDriver class is invoked successfully	--------");
		try
		{			
			driver.switchTo().alert(); 
			logger.info("--------	alertPresentOrNot wrapper method inside MyWebDriver class is executed successfully	--------");
		    return true;			
	    }
		catch (NoAlertPresentException error)
		{ 	    	
	    	logger.error("ERROR WHILE TRYING TO CHECK WHETHER AN ALERT WINDOW IS PRESENT OR NOT : "+error.getMessage());
	    	Assert.fail("NoAlertPresentException : WHILE TRYING TO CHECK WHETHER AN ALERT WINDOW IS PRESENT OR NOT");	    	
	    }
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO CHECK WHETHER AN ALERT WINDOW IS PRESENT OR NOT : "+error.getMessage());
			Assert.fail("Exception : WHILE TRYING TO CHECK WHETHER AN ALERT WINDOW IS PRESENT OR NOT");
		}
		return false;		
	} 
	
	/* To switch to an alert window
	@Parameter : Browser */
	public static Alert switchToAlert(WebDriver driver)
	{
		logger.info("--------	switchToAlert wrapper method inside MyWebDriver class is invoked successfully	--------");
		Alert alert = null;
		try
		{
			alert = driver.switchTo().alert();
			logger.info("--------	switchToAlert wrapper method inside MyWebDriver class is executed successfully	--------");
			return alert;
		}
		catch (NoAlertPresentException error)
		{ 	    	
	    	logger.error("ERROR WHILE TRYING TO SWITCH TO AN ALERT WINDOW : "+error.getMessage());
	    	Assert.fail("NoAlertPresentException : WHILE TRYING TO SWITCH TO AN ALERT WINDOW");	    	
	    }
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO SWITCH TO AN ALERT WINDOW : "+error.getMessage());
	    	Assert.fail("NoAlertPresentException : WHILE TRYING TO SWITCH TO AN ALERT WINDOW");
		}
		return alert;
	}
	
	/* To accept an alert window
	@Parameter : Browser */
	public static void acceptAlert(WebDriver driver)
	{
		logger.info("--------	acceptAlert wrapper method inside MyWebDriver class is invoked successfully	--------");
		Alert alert;
		try
		{
			alert = switchToAlert(driver);
			alert.accept();
			logger.info("--------	acceptAlert wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch (NoAlertPresentException error)
		{ 	    	
	    	logger.error("ERROR WHILE TRYING TO ACCEPT AN ALERT WINDOW : "+error.getMessage());
	    	Assert.fail("NoAlertPresentException : WHILE TRYING TO ACCEPT AN ALERT WINDOW");	    	
	    }
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO ACCEPT AN ALERT WINDOW : "+error.getMessage());
	    	Assert.fail("NoAlertPresentException : WHILE TRYING TO ACCEPT AN ALERT WINDOW");
		}	
	}
	
	/* To dismiss an alert window
	@Parameter : Browser */
	public static void dismissAlert(WebDriver driver)
	{
		logger.info("--------	dismissAlert wrapper method inside MyWebDriver class is invoked successfully	--------");
		Alert alert;
		try
		{
			alert = switchToAlert(driver);
			alert.dismiss();
			logger.info("--------	dismissAlert wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch (NoAlertPresentException error)
		{ 	    	
	    	logger.error("ERROR WHILE TRYING TO DISMISS AN ALERT WINDOW : "+error.getMessage());
	    	Assert.fail("NoAlertPresentException : WHILE TRYING TO DISMISS AN ALERT WINDOW");	    	
	    }
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO DISMISS AN ALERT WINDOW : "+error.getMessage());
	    	Assert.fail("NoAlertPresentException : WHILE TRYING TO DISMISS AN ALERT WINDOW");
		}	
	}
	
	/* To get text from an alert window
	@Parameter : Browser */
	public static String getTextFromAlert(WebDriver driver)
	{
		logger.info("--------	getTextFromAlert wrapper method inside MyWebDriver class is invoked successfully	--------");
		Alert alert;
		String text="";
		try
		{
			alert = switchToAlert(driver);
			text = alert.getText();
			logger.info("--------	getTextFromAlert wrapper method inside MyWebDriver class is executed successfully	--------");
			return text;
		}
		catch (NoAlertPresentException error)
		{ 	    	
	    	logger.error("ERROR WHILE TRYING TO GET TEXT FROM AN ALERT WINDOW : "+error.getMessage());
	    	Assert.fail("NoAlertPresentException : WHILE TRYING TO GET TEXT FROM AN ALERT WINDOW");	    	
	    }
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO GET TEXT FROM AN ALERT WINDOW : "+error.getMessage());
	    	Assert.fail("NoAlertPresentException : WHILE TRYING TO GET TEXT FROM AN ALERT WINDOW");
		}	
		return text;
	}
	
	/* To type a text inside an alert window
	@Parameter : Browser and Text to type */
	public static void typeTextInAlert(WebDriver driver, String text)
	{
		logger.info("--------	typeTextInAlert wrapper method inside MyWebDriver class is invoked successfully	--------");
		Alert alert;
		try
		{
			alert = switchToAlert(driver);
			alert.sendKeys(text);
			logger.info("--------	typeTextInAlert wrapper method inside MyWebDriver class is executed successfully	--------");
		}
		catch (NoAlertPresentException error)
		{ 	    	
	    	logger.error("ERROR WHILE TRYING TO TYPE A PARTICULAR TEXT INSIDE AN ALERT WINDOW : "+error.getMessage());
	    	Assert.fail("NoAlertPresentException : WHILE TRYING TO TYPE A PARTICULAR TEXT INSIDE AN ALERT WINDOW");	    	
	    }
		catch(Exception error)
		{
			logger.error("ERROR WHILE TRYING TO TYPE A PARTICULAR TEXT INSIDE AN ALERT WINDOW : "+error.getMessage());
	    	Assert.fail("NoAlertPresentException : WHILE TRYING TO TYPE A PARTICULAR TEXT INSIDE AN ALERT WINDOW");	
		}
	}


}

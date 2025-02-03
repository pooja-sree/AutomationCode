package org.reach24.Reach24NEP.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.reach24.Reach24NEP.util.Wait;

public class DriverActions {
	
	Wait wait;
	JsActions jsActions;
	WebDriver driver;
	String checkedClass;
	
    public DriverActions(WebDriver driver) {
        this.driver = driver;
        jsActions=new JsActions(driver);
    }

	public void hardwaitBasedOnInput(int timeOuts) {
		try {
			Thread.sleep(timeOuts);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	public void driverClick(WebElement elementLocator) {
		boolean flag=false;
		try {
			flag=findElement(elementLocator);
			wait.forElementToBeClickable(elementLocator);
			elementLocator.click();
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}finally {
			if(flag) {
				System.out.println(elementLocator +" - Clicked");
			}else {
				System.out.println(elementLocator +" - Not Clicked");
			}
		}
	}
	
	public void driverSendKeys( WebElement elementLocator,String text) {
		boolean flag=false;
		try {
			flag=findElement(elementLocator);
			elementLocator.clear();
			elementLocator.sendKeys(text);
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}finally {
			if(flag) {
				System.out.println(text+" Entered On "+elementLocator);
			}else {
				System.out.println(text+" Not Entered On "+elementLocator);
			}
		}
	}
	
	public String driverGetText( WebElement elementLocator) {
		boolean flag=false;
		String textDisplayedOnUI = null;
		try {
			flag=findElement(elementLocator);
			textDisplayedOnUI=elementLocator.getText();
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}finally {
			if(flag) {
				System.out.println("Text caught ----> "+textDisplayedOnUI);
				return textDisplayedOnUI;
			}
		}
		return "Text Not Displayed";
	}
	
	public boolean findElement(WebElement elementLocator) {
		boolean flag=false;
		try {
			if(elementLocator.isDisplayed()) {
				jsActions.highlightElement(elementLocator);
				flag=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				System.out.println(elementLocator +" - Found");	
			}else {
				System.out.println(elementLocator +" - Not Found");
			}
		}
		return flag;
	}

	public boolean isChecked(WebElement element){
		boolean flag=false;
		if(element.getAttribute("class").contains("checked")){
				flag=true;
				System.out.println("Checkbox is checked");
		}else {
			flag=false;
			System.out.println("Checkbox is un-checked");
		}
		return flag;
	}

	public boolean isChecked2(String xpath) {
		boolean flag=false;
		checkedClass=driver.findElement(By.xpath(xpath)).getAttribute("class");
		if(checkedClass.contains("checked")) {
			flag=true;
			System.out.println("Checkbox is Checked");
		}else {
			System.out.println("Checkbox is Unchecked");
		}
		return flag;
	}

	public void enableDisableNEP(String enableDisable, WebElement eleDiv, WebElement eleINS){
		if(enableDisable.equalsIgnoreCase("enable")){
			if(isChecked(eleDiv)){
				System.out.println("Checkbox not clicked");
				return;
			} else{
				jsActions.jsclick(eleINS);
				System.out.println("Checkbox clicked");
			}
		} else if (enableDisable.equalsIgnoreCase("disable")) {
			if(isChecked(eleDiv)){
				System.out.println("Checkbox clicked");
				jsActions.jsclick(eleINS);
			} else{
				System.out.println("Checkbox not clicked");
				return;
			}
		}
	}
	public boolean isActive(WebElement element){
		boolean flag=false;
		if(element.getAttribute("class").contains("active")){
			flag=true;
			System.out.println("ShowHideBox is Active");
		}else {
			flag=false;
			System.out.println("ShowHideBox is Inactive");
		}
		return flag;
	}
}

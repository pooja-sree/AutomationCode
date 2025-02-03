package org.reach24.Reach24NEP.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	protected WebDriver driver;
	protected Wait wait;
	
	public BasePage() {
		PageFactory.initElements(driver, this);
		this.driver = BrowserConfig.driver;
		this.wait = new Wait(this.driver);
	}
}

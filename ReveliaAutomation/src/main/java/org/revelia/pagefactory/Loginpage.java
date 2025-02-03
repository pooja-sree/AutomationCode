package org.revelia.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage {
	public WebDriver driver;

    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
     
    @FindBy(name = "usernameOrNumber")
    public WebElement input_username;
    
    @FindBy(name = "password")
    public WebElement input_password;
    
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div/form/button")
    public WebElement button_login;
    
    @FindBy(xpath="//*[@id=\"root\"]/div/div/div[2]/div/div/div/main/div/p")
    public WebElement welcome_name;
    
    @FindBy(xpath="//*[@id=\"radix-:r6:\"]/p/span[2]")
    public WebElement user_roles;
    
   
}

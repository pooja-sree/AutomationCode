package com.revilia.pagefactory;





import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class Loginpage {
	public static  WebDriver driver;
	 WebDriverWait wait;
	
    
	public Loginpage(WebDriver driver) {
		Loginpage.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofMillis(3000));

		}
	
	
	@FindBy(name = "usernameOrNumber")
	public static WebElement Emailid;

	@FindBy(name = "password")
	public static WebElement emailpwd;

	@FindBy(xpath = "//input[@name='password']//following::button[1]")
	public static WebElement loginButton;

	@FindBy(xpath = "//input[@name='password']//following::div[1]")
	public static WebElement Visibilityicon;

	@FindBy(xpath = "//section/ol/li/div[2]/div")
	public static WebElement toastmessage;

	@FindBy(xpath = "(//p[text()='This field is required'])[1]")
	public WebElement emailValidationmessage;

	@FindBy(xpath = "(//p[text()='This field is required'])[2]")
	public WebElement PwdValidationmessage;

	@FindBy(linkText = "Forgot Password?")
	public WebElement ForgotPassword;

	@FindBy(name = "email")
	public WebElement resetpwdemail;

	@FindBy(xpath ="//button[text()='Continue']")
	public WebElement cont;




	public void Validlogincredentials(String username, String password) throws InterruptedException {
		
		
			wait.until(ExpectedConditions.urlToBe("http://54.236.2.11:5173/"));
			
			wait.until(ExpectedConditions.visibilityOf(Emailid));
			Emailid.sendKeys(username);
			emailpwd.sendKeys(password);
			loginButton.click();
	
		
		
		
		

	}

	public void isLoginSuccessful() throws InterruptedException {
		wait.until(ExpectedConditions.urlToBe("http://54.236.2.11:5173/test_clinic2/patient/dashboard"));
		
		String msg = driver.getCurrentUrl();
		Assert.assertEquals(msg, "http://54.236.2.11:5173/test_clinic2/patient/dashboard", "Login Successful");


	}

	public  void InValidlogincredentials(String username, String password)  {
		wait.until(ExpectedConditions.urlToBe("http://54.236.2.11:5173/"));
		Emailid.sendKeys(username);
		emailpwd.sendKeys(password);
		loginButton.click();
		wait.until(ExpectedConditions.visibilityOf(toastmessage));

	}

	public void Loginunsuccessful()  {
		
		Assert.assertEquals(toastmessage.getText(),"Invalid Login or password." ,"Login Unsuccessful");
	}

	public  void Loginwithoutcredentials(String username, String password)  {
		wait.until(ExpectedConditions.urlToBe("http://54.236.2.11:5173/"));

		Emailid.sendKeys("");
		emailpwd.sendKeys("");
		loginButton.click();
	}

	public  void Validationmessage() {
	
		Assert.assertEquals(emailValidationmessage.getText(),"This field is required");
		Assert.assertEquals(PwdValidationmessage.getText(),"This field is required");

	}

	public void Forgot_Password()  {
		wait.until(ExpectedConditions.urlToBe("http://54.236.2.11:5173/"));
		//wait.until(ExpectedConditions.elementToBeClickable(icon)).click();
		ForgotPassword.click();
		resetpwdemail.sendKeys("poojasree.k+o@spritle.com");
		cont.click();
		wait.until(ExpectedConditions.visibilityOf(toastmessage));

	}

	public void Reset_Password() {
	
		Assert.assertEquals(toastmessage.getText(),"Forget password link shared to your email ID" ,"Link sent");

	}
	
	
	
	

	public void Visibility() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(emailpwd.getAttribute("type"), "password", "Password is Invisible");
		Visibilityicon.click();
		Assert.assertEquals(emailpwd.getAttribute("type"), "text", "Password is visible");
		Thread.sleep(2000);
}
}
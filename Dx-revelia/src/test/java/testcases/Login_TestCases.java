package testcases;

import org.openqa.selenium.WebDriver;
import com.rev.pagefactory.Login;
import com.rev.pagefactory.ToastMessage;
import com.rev.pagefactory.ValidLoginCredentials;
import com.rev.pagefactory.Waiting;
import org.openqa.selenium.support.PageFactory;

public class Login_TestCases extends Login{
	WebDriver driver;
    ValidLoginCredentials Cred;
    ToastMessage toast;
    Waiting waitfn;
    
    public Login_TestCases(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Cred = new ValidLoginCredentials(driver);
        waitfn = new Waiting(driver);
        toast = new ToastMessage(driver);
    }
    
    public void Validcredentials( String username,String password) {

        Cred.Validlogincredentials(username, password);
        Cred.Login_validation();


    }
    public void PatientLogin(String username, String password) {
         Cred.Validlogincredentials(username,password);
         Cred.PatientDasboardValidation();
    }

    public void Invalidlogincredentials(String username, String password)  {
        waitfn.URL(Login_url);
        Cred.Validlogincredentials(username,password);
        waitfn.Visibility(toastmessage);
        toast.CheckToastMessage("Invalid credentials","Login failed");

    }
    public void Nonexistent(String username,String password) {
        waitfn.URL(Login_url);
        Cred.Validlogincredentials(username,password);
        waitfn.Visibility(toastmessage);
        toast.CheckToastMessage("Account doesnot exists! Please Register to log in","Nonexistent");}


    public  void Loginwithoutcredentials(String username, String password)  {
        waitfn.URL(Login_url);
        Cred.Validlogincredentials(username,password);
        waitfn.Visibility(emailValidationmessage);
        toast.EmailValidationMessage("This field is required","Required Field");
        waitfn.Visibility(PwdValidationmessage);
        toast.PasswordValidationMessage("Required Field","This field is required");

    }

    public void ForgotPassword(String usermame)  {
        waitfn.URL(Login_url);
        waitfn.Visibility(ForgotPassword);
        Forgotpwd();
        waitfn.Visibility(resetpwdemail);
        Resetpwd(usermame);
        waitfn.Visibility(cont);
        Continuebtn();
        waitfn.Visibility(toastmessage);
        toast.CheckToastMessage("Forget password link shared to your email ID","Link sent");
    }
}

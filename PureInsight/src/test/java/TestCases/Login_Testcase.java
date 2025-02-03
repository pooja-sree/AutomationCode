package TestCases;

import com.Pg4.PageFactory.Login;
import com.Pg4.PageFactory.Validation;
import com.Pg4.PageFactory.Waitfunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Login_Testcase extends Login {

    WebDriver driver;
    Login signin;
    Validation Validate;
    Waitfunctions waitfn;

    public Login_Testcase(WebDriver driver){
        super(driver);

        this.driver = driver;
        PageFactory.initElements(driver,this);
        signin = new Login(driver);
        Validate = new Validation(driver);
        waitfn = new Waitfunctions(driver);

    }

    public void Login(String username, String Password){
        waitfn.URL(Signin_url);
        signin.Email(username);
        signin.Password(Password);
        signin.SigninButton();

    }

    public void InvalidLogin(String username,String password){
        Login(username,password);
        Validate.InvalidUser_Validation("Invalid username or password. Forgot Your Password? Reset Password","Login Failed");
    }

    public void EmptyData(String username, String password){
        Login(username,password);
        Validate.EmailValidationMessage("Enter Valid Email","Please Enter your Email");
        Validate.PasswordValidationMessage("Enter Valid Password", "Please enter your Password");

    }

    public void ForgotPassword(String username, String password){
        Login(username,password);
        ResetPwd();
        Validate.ForgotPasswordToastValidation("Reset Link Sent","You will receive an email with instructions to reset your password.");

    }
}

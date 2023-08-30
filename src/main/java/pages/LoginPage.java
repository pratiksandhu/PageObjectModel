package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;

import base.BaseClass;

public class LoginPage extends BaseClass {
	
	HomePage hp=new HomePage();;
	
    // page factory (object Repository)
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//div[text()='Login']")
	WebElement SignIn;
	@FindBy(linkText="Forgot your password?")
	WebElement forgotPassword;
    
 public LoginPage() {
	 PageFactory.initElements(driver, this);
 }
	//public void initiateElements() {
		//PageFactory.initElements(driver, this);
//	}

	/*public void openLoginPage() {
		hp.initiateElements();
		hp.loginPage();
	}*/
	
	public AfterSignInPage LogIn(String us,  String pass) {
	email.sendKeys(us);
	password.sendKeys(pass);
	SignIn.click();
	return new AfterSignInPage();
	}

    public ForgotPasswordPage forgotPassword() {
    	forgotPassword.click();
    	return new ForgotPasswordPage();
    }
	
		
}

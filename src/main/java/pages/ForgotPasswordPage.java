package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class ForgotPasswordPage extends BaseClass {
	LoginPage lp=new LoginPage();
	
 @FindBy(id="email")
 WebElement email;
 @FindBy(xpath="//button[@type='submit']")
 WebElement forgotPassword;
 
 public ForgotPasswordPage() {
	 PageFactory.initElements(driver, this);
 }
 
 /*public void openForgotPasswordPage() {
      lp.openLoginPage();
      lp.initiateElements();
      lp.forgotPassword();
	 
 }
 */
 public void forgotPassword() {
	 email.sendKeys(p.getProperty("username"));
	 forgotPassword.click();
 }

}

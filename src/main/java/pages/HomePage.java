package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;



public class HomePage extends BaseClass {
	
 @FindBy(linkText="SIGN UuP")
 @CacheLookup
 WebElement signUp;
 @FindBy(linkText="CRM")
 WebElement crm;
 @FindBy(xpath="(//a[@href='insurance.html'])[1]") 
 WebElement insurance;
 @FindBy(linkText="Sign Up")
 WebElement logIn;
 
 public HomePage() {
	 PageFactory.initElements(driver, this);
 }
 
 //public void initiateElements() {
//	/ PageFactory.initElements(driver, this);
// }
 public void signUpPage() {
	 signUp.click();  
 }
 public void crmInsurancepage() {
	Actions a= new Actions(driver);
	a.moveToElement(crm).build().perform();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(insurance));
	insurance.click();
 }
 public LoginPage loginPage() {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].click();", logIn);

	// logIn.click();
	 return new LoginPage();
 }
}

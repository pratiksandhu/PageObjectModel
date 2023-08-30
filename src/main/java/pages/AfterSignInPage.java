package pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.BaseClass;

public class AfterSignInPage extends BaseClass {
	 
 @FindBy(xpath="//span[@class='user-display']")
 WebElement displayUser;
 @FindBy(xpath="//span[text()='Contacts']")
 WebElement contacts;
 @FindBy(xpath="//span[text()='Deals']")
 WebElement deals;
 @FindBy(xpath="//a[@href='/contacts']//following-sibling::button")
 WebElement contact;
 

 
 public AfterSignInPage() {
	 PageFactory.initElements(driver, this);
 }
 
 public boolean displayUser() {
	 return displayUser.isDisplayed();
	
 }
 public ContactsPage contacts() throws InterruptedException {
	 contacts.click();
	 Thread.sleep(5000);
	 return new ContactsPage();
 }
 public DealsPage deals() {
	 deals.click();
     return new DealsPage();
 }
 public void addContact() {
	 contact.click();
	 
	 
 }
}


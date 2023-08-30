package pages;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.BaseClass;

public class ContactsPage extends BaseClass {
	
	@FindBy(xpath="//div[@id='dashboard-toolbar']/div/span")
	WebElement contacts;
	@FindBy(name="first_name")
	@CacheLookup
	WebElement firstName;
	@FindBy(name="last_name")
	WebElement lastName;
	@FindBy(name="category")
	WebElement category;
	@FindBy(xpath="//button[text()='Save']")
	WebElement btn;

	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyContactsPage() {
		return contacts.isDisplayed();
	}
	
	public void selectContact(String name) throws InterruptedException {
		WebElement search=driver.findElement(By.xpath("//input[@type='text']"));
		search.click();
		search.sendKeys("sandhu");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td/div")).click();	
	}
	
	public void createNewContact(String fName,String lName,String categoryName) {
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		category.click();
		WebElement c=driver.findElement(By.xpath("//span[text()='"+categoryName+"']"));
		c.click();
		btn.click();
		
	}
}


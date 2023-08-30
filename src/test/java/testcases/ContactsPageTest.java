package testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AfterSignInPage;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.Util;

public class ContactsPageTest extends BaseClass{
 
	HomePage homePage;
	LoginPage loginPage;
	AfterSignInPage afterSignInPage;
	ContactsPage contactsPage;
	Util util=new Util();
	
@BeforeMethod
public void beforeMethod() throws InterruptedException, IOException {
	readFile();
	initialization();
	homePage=new HomePage();
	loginPage=homePage.loginPage();
	afterSignInPage=loginPage.LogIn(p.getProperty("username"), p.getProperty("password"));
	contactsPage=afterSignInPage.contacts();
	
}
@AfterMethod
public void afterMethod() {
	closeBrowser();
}	
	
//@Test(priority=1)
public void verifyContactsPage() {
	Assert.assertTrue(contactsPage.verifyContactsPage());
	
}
//@Test(priority=2)
public void selectSingleContact() throws InterruptedException {
	contactsPage.selectContact("pratik sandhu");
}
@DataProvider
public Object[][] getTestData() throws InvalidFormatException, IOException {
	 Object[][] data= util.getData("Sheet1");
	return data;
}
@Test(priority=3, dataProvider="getTestData")
public void addNewContact(String fN,String lN,String comp) throws InterruptedException {
	afterSignInPage.addContact();
	Thread.sleep(3000);
	driver.navigate().refresh();
	contactsPage.createNewContact(fN,lN,comp);
}
}


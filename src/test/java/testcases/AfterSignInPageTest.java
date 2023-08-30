package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.AfterSignInPage;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AfterSignInPageTest extends BaseClass{
	HomePage homePage;
	LoginPage loginPage;
	AfterSignInPage afterSignInPage;
 
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  readFile();
	  initialization();
	  homePage=new HomePage();
	  loginPage=homePage.loginPage();
	  afterSignInPage=loginPage.LogIn(p.getProperty("username"), p.getProperty("password"));
  }

  @AfterMethod
  public void afterMethod() {
  closeBrowser();
  }

  //@Test(priority=1)
  public void verifyDisplayUser() {
	  afterSignInPage.displayUser();
	  Assert.assertTrue(true);	  }
  
  @Test(priority=2)
  public void contacts() throws InterruptedException {
	  afterSignInPage.contacts();
  }
 
  //@Test(priority=3)
  public void deals() {
	  afterSignInPage.deals();  
	
  }
}

  
  


package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class LoginPageTest extends BaseClass {
	HomePage homePage;
	LoginPage loginPage;

  @BeforeMethod
  public void beforeMethod() throws IOException {
	  readFile();
	  initialization();
	  //lp.openLoginPage();
	  //lp.initiateElements();
	  homePage=new HomePage();
	  loginPage=homePage.loginPage();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  closeBrowser();
  }
  
 @Test(priority=1)
  public void signIn() {
	  loginPage.LogIn(p.getProperty("username"),p.getProperty("password"));
  }
  
  @Test(priority=2,enabled=false)
  public void forgotPassword() {
	  loginPage.forgotPassword();
  }
}

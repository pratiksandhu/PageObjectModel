package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class ForgotPasswordPageTest extends BaseClass{
	HomePage homePage;
	LoginPage loginPage;
	ForgotPasswordPage forgotPasswordPage;
 
  @BeforeMethod
  public void beforeMethod() throws IOException {
	 readFile();
	 initialization();
	 //fp.openForgotPasswordPage();
	 //fp.initiateElements();
	 homePage=new HomePage();
	 loginPage=homePage.loginPage();
	 forgotPasswordPage=loginPage.forgotPassword();
 }

  @AfterMethod
  public void afterMethod() {
	  closeBrowser();
  }

  @Test(priority=1)
  public void resetPassword() {
	  forgotPasswordPage.forgotPassword();
  }
}

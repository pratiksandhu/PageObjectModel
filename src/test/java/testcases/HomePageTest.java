package testcases;

import org.testng.annotations.Test;
import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


import java.io.IOException;



public class HomePageTest extends BaseClass{
    LoginPage loginPage;
	HomePage homePage;
	

  @BeforeMethod
  public void beforeMethod() throws IOException  {
	  readFile();
	  initialization();
	  //hp.initiateElements();
	  homePage=new HomePage();
	  }
  
  @AfterMethod
  public void afterMethod() {
	closeBrowser();
	}
  
  @Test (priority=1)
  public void signUpPage() {
	  homePage.signUpPage();
  }
  
  @Test(priority=2,enabled=true)
  public void openCRMInsurance() {
	  homePage.crmInsurancepage();
  }
  
  @Test(priority=3,enabled=true)
  public void openLoginPage() {
	loginPage = homePage.loginPage();
	  
  }

}

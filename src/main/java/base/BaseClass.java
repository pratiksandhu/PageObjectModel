package base;

import java.io.FileInputStream;


import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utilities.Util;
import utilities.WebEventListener;

public class BaseClass {
	public static  WebDriver driver; 
	public static Properties p;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//read properties file
	public void readFile() throws IOException{
		FileInputStream file= new FileInputStream("/Users/pratiksandhu/eclipse-workspace/POMByNaveen/src/main/java/data/config.properties");
		p= new Properties();
		p.load(file);
		}
	
	
    public   void initialization() {
    	String browser=p.getProperty("browser");
    	if(browser.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "/Users/pratiksandhu/Documents/QA/drivers/geckodriver");
		driver= new FirefoxDriver();
    	}
    	e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PageLoadOutTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.ImplicitWait, TimeUnit.SECONDS);
		driver.get(p.getProperty("url"));
		
		

    }
    	
	 public void closeBrowser(){
		 driver.quit(); 
	} 
}

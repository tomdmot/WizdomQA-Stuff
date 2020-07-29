package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private WebDriver driver = null;
	
	public WebDriver getDriver (String browser) {
		
	    switch(browser.toLowerCase()) {
	    case "firefox": 
	    	System.setProperty("webdriver.gecko.driver", TestConfig.getProperty("firefoxDriverLocation").split("\"")[1]);
		    this.driver = new FirefoxDriver();
		    break;
	    case "chrome":
	    	System.setProperty("webdriver.chrome.driver", TestConfig.getProperty("chromeDriverLocation"));
		    this.driver = new ChromeDriver();
		    break;
	    default:
	    	System.out.println("Invalid driver");
	    }
	    driver.manage().timeouts().implicitlyWait(Long.valueOf(TestConfig.getProperty("implicitWait")), TimeUnit.SECONDS);
	    driver.manage().deleteAllCookies();
		return this.driver;
		
	}
	
//	public void splitProps() {
//		String s = TestConfig.getProperty("firefoxDriverLocation").split("'")[0];
//		s.split(rege)
//	}
	
	public void quitDriver () {
	    if(this.driver != null) {
	    	this.driver.quit();
	    }
	}
	
	
}

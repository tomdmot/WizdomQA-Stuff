package tests;


import java.io.File;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import core.DriverFactory;
import core.ITestData;
import core.JsonDataProvider;
import core.TestConfig;

public class BaseTest {
	
	private WebDriver driver = null;
	private DriverFactory factory = null;
	private ITestData data = null;
	
	@Parameters({"env"})
	@BeforeSuite(groups="regression")
	public void loadConfig(String env) throws Exception{
		String s2 = env;
		TestConfig.loadProps(env);
	}
	
	public String getData(String name) throws IOException {
		File file = new File("src/test/resources/testdata/");
		
		String dataSource = TestConfig.getProperty("dataSource");
		String env = TestConfig.getProperty("env");

		try {
		    if(dataSource.equalsIgnoreCase("json")) {
		    	this.data = new JsonDataProvider(file.getAbsolutePath() + "/data." + env + ".json");
		    }
		
		} catch (Exception e) {
			
		}
		
		String testdata =data.getCounty(name);
		return testdata;
	}
	
	@Parameters({"browser"})
	@BeforeClass(groups="regression")
	public void setupDriver(String browser) {
		factory = new DriverFactory();
		driver = factory.getDriver(browser);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@AfterClass(groups="regression")
	public void teardown() {
		factory.quitDriver();
	}

}

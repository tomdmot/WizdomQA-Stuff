package tests;


import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import core.DriverFactory;
import core.TestConfig;
import pages.ExpediaHome;
import pages.SearchPage;
import tests.BaseTest;

public class ExpediaTest extends BaseTest {
	
	
	@Test(groups="regression")	
	public void Test1() throws Exception {
		String s = getData("Tom");
		System.out.println(s);
	}
	
    

}

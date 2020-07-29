package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DriverFactory;

public class BasePage {

	protected WebDriver driver =null;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitUntilElementVisible(WebElement element, WebDriver driver) {
		new WebDriverWait(driver,60)
		.until(ExpectedConditions.visibilityOf(element));
	}
	
	public Select returnSelectDropDown(WebElement element) {
		Select select = new Select(element);
		return select;
	}
	
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void enterText(WebElement element, Keys text) {
		element.sendKeys(text);
	}
	
	 public boolean checkElementIsDisplayed(WebElement element) {
     	try {
     	if(element.isDisplayed()) {
     		return true;
     	} 
     	}catch(Exception e) {
     		
     	}
     	return false;
     }
	}

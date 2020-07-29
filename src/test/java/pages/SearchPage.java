package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage{
		
		@FindBy(xpath=".//select[@id='sortDropdown']")
		private WebElement selectDropDown;
		
		@FindBy(xpath=".//span[contains(text(),'Select your departure to')]")
	    private WebElement departureTitle;
		
		WebDriver driver = null;
		
		
		public SearchPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
		}
		
		public boolean verifySearchPageIsDisplayed() {
			return checkElementIsDisplayed(departureTitle);
		}
        
        public boolean selectFlights() {
        	waitUntilElementVisible(selectDropDown,driver);
        	
        	Select flightsOptions = returnSelectDropDown(selectDropDown);
        	
        	List <WebElement> selectElements = flightsOptions.getOptions();
        	
        	for(WebElement i : selectElements) {
        		clickOnElement(i);
        		if(!checkSelectBoxElement(i)) {
        			return false;
        		}
        	}
        	return true;
        }
        
        public boolean checkSelectBoxElement(WebElement e) {
        	if(!checkElementIsDisplayed(e)) {
        		return false;
        	}
        	return true;
        }

	}

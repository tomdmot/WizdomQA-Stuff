package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpediaHome extends BasePage {
	
	@FindBy(xpath=".//span[text()='One way']")
	private WebElement flightTab;
	
	@FindBy(xpath=".//button[@id='tab-flight-tab-hp']")
	private WebElement flightsLink;
	
	@FindBy(xpath=".//input[@id='flight-origin-hp-flight']")
	private WebElement locationOriginInput;
	
	@FindBy(xpath=".//input[@id='flight-destination-hp-flight']")
	private WebElement locationDestinationInput;
	
	@FindBy(xpath = ".//input[@id='flight-departing-hp-flight']")
	private WebElement departingDate;
	
	@FindBy(xpath = ".//input[@id='flight-returning-hp-flight']")
	private WebElement returningDate;
	
	@FindBy(xpath = ".//div[@class='datepicker-cal-month']//caption")
	private WebElement curMonthPicker;
	
//	@FindBy(xpath = ".//div[@class='datepicker-cal-month']//caption[contains(text(),'Sep')]/..//button[@data-day='8']")
//	private WebElement dateSelector;
	
	@FindBy(xpath = ".//button[contains(@class,'next')]")
	private WebElement dateNavigator;
	
	@FindBy(xpath = ".//span[text()='Search']/..")
	private WebElement searchButton;

	
	WebDriver driver = null;	
	
	public ExpediaHome(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public boolean launchExpediaUrl(String url) {
		driver.get(url);
		clickOnElement(flightsLink);
		return checkElementIsDisplayed(flightTab);
	}
	
	public void launchExpedia(String url) {
		driver.get(url);
	}
	
	public void searchForOriginLocation() {
		enterText(locationOriginInput,"Dublin");
		enterText(locationOriginInput,Keys.ENTER);
	}
	
	public void searchForDestinationLocation() {
		enterText(locationDestinationInput,"London");
		enterText(locationDestinationInput,Keys.ENTER);
	}
	
	public void searchForDepartDate() {
	   clickOnElement(departingDate);
	   getDate("11", "Sep");
	}
	
	public void searchForReturnDate() {
	   clickOnElement(returningDate);
	   getDate("12", "Oct");
	}
	
	public void searchForFlights () {
	    clickOnElement(flightsLink);
		searchForOriginLocation();
		searchForDestinationLocation();
		searchForDepartDate();
		searchForReturnDate();
		
		clickOnElement(searchButton);
	}
	
	public void quitDriver() {
		driver.quit();
	}
	
	public void getDate(String day, String month) {
		 while(!curMonthPicker.getText().contains(month)) {
			 dateNavigator.click();
		 }
		 curMonthPicker.findElement(By.xpath("//caption[contains(text(),'"+month+"')]/..//button[@data-day='"+day+"']")).click();
		 
	}

}

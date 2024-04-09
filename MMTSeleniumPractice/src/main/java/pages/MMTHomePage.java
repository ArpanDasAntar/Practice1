package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMTHomePage {
	private WebDriver driver;
	
	//PageElements
	private By advCloseBtn = By.xpath("//a[@class='close']");
	private By iframeX= By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']");
	private By flightSearchOptions= By.xpath("//span[text()='Flights' and @class='headerIconTextAlignment chNavText darkGreyText']");
	private By roundTripRadioButton=By.xpath("//li[contains(text(),'Round Trip')]");
	private By fromCity=By.id("fromCity");
	private By fromCitySearch=By.xpath("//input[@placeholder='From']");
	//private By fromCityOptions=By.xpath("//ul[@class='react-autosuggest__suggestions-list']");
	private By fromCityOptions=By.xpath("//li[@class='react-autosuggest__suggestion']/div/div/p[1]");

	//    private By fromCityOptions = By.xpath("//div[@class='calc60']");
	private By deptDate=By.xpath("//div[@class=\"DayPicker-Day\"]");
	//private By retDate=By.xpath("(//div[@class=\"DayPicker-Body\"])[1]//div[@class='dateInnerCell']/p");
	
	private By toCity=By.id("toCity");
	private By toCitySearch=By.xpath("//input[@placeholder='To']");
	private By toCityOptions=By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-3\"]/div/div[1]/p[1]");
	private By searchButton=By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']");
	
	
	public MMTHomePage(WebDriver driver) {
		this.driver =driver;
	}
	
	
	//PageActions
	public void checkMMTLogo() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='Make My Trip']"));
		//driver.findElement(By.xpath("//ion-icon[@name='close']"));
	}
	
	public void closeAdvert() {
		driver.switchTo().frame(driver.findElement(iframeX));
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10) );
		WebElement closeAdvert=wait.until(ExpectedConditions.visibilityOfElementLocated(advCloseBtn));
		closeAdvert.click();
		driver.switchTo().parentFrame();
	}
	
	public void selectFlightPath() throws InterruptedException {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(flightSearchOptions)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(roundTripRadioButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromCity)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(fromCityOptions));

		WebElement fromCityInput = driver.findElement(fromCitySearch);
        fromCityInput.sendKeys("Kol");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromCityOptions));

        Thread.sleep(10000);
		List<WebElement> lst=driver.findElements(fromCityOptions);
		for(WebElement wb:lst) {
            String suggestionText = wb.getText();
            System.out.println(suggestionText);

			if (wb.getText().equalsIgnoreCase("Koln/Bonn")) {
				wb.click();
				System.out.println("Clicked");
				break;
			}
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(toCity)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(toCityOptions));

		WebElement toCityInput = driver.findElement(toCitySearch);
		toCityInput.sendKeys("sil");
		Thread.sleep(10000);
        List<WebElement> lst2=driver.findElements(toCityOptions);
		for(WebElement wb1:lst2) {
            String suggestionText = wb1.getText();
            System.out.println(suggestionText);

			if (wb1.getText().equalsIgnoreCase("Silchar Airport")) {
				System.out.println(wb1.getText());
				wb1.click();
				System.out.println("Clicked");
				break;
			}
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(deptDate));
		List<WebElement> datelist=driver.findElements(deptDate);
		for(WebElement dates:datelist) {
            String suggestionText = dates.getText();
            System.out.println(suggestionText);

			if (dates.getText().equalsIgnoreCase("5")) {
				System.out.println(dates.getText());
				dates.click();
				System.out.println("Clicked");
				break;
			}
		}
		List<WebElement> datelist2=driver.findElements(deptDate);
		for(WebElement dates:datelist2) {
            String suggestionText = dates.getText();
            System.out.println(suggestionText);

			if (dates.getText().equalsIgnoreCase("10")) {
				System.out.println(dates.getText());
				dates.click();
				System.out.println("Clicked");
				break;
			}
		}
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
		
		
        
        
//		Select sl=new Select(driver.findElement(fromCityOptions));
//		sl.selectByVisibleText("Cologne, Germany");
	}

}

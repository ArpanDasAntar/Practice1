package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CricInfoPage {
	private WebDriver driver;
	
	//PageElements
	private By homeButton=By.xpath("//a[@class='navbar-brand']");
	private By teamsbutton = By.xpath("//a[text()='Teams']");
	private By iframeX= By.xpath("//iframe[@id='google_ads_iframe_21783347309/espn.cricinfo.com/teams/ind/index_0']");
	private By teamNameIndia=By.xpath("//span[text()='India']");
	private By teamNameNZ=By.xpath("//span[text()='New Zealand']");
	private By advtCloseBtn=By.xpath("//a[@class='sprite close']");
	private By playersTab=By.xpath("//span[text()='Players']");
	private By firstPlayer=By.xpath("(//div[@class='ds-flex ds-flex-col']/div/a/span)[1]");
	private By notNownoti=By.xpath("//button[text()='Not Now']");
	public CricInfoPage(WebDriver driver) {
		this.driver =driver;
	}
	//Actions action = new Actions(driver);

	
	//PageActions
	public void goToHomePage() {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10) );
		WebElement HomeButton=wait.until(ExpectedConditions.visibilityOfElementLocated(homeButton));
		HomeButton.click();
	}
	public void hoverOnTeams() throws InterruptedException {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(teamsbutton));
		WebElement teamsMenu=driver.findElement(teamsbutton);
		new Actions(driver).moveToElement(teamsMenu).build().perform();
	}
	public void openIndianTeamlist() {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(teamsbutton));
		WebElement indiaOption=driver.findElement(teamNameIndia);
		indiaOption.click();
	}
	public void openNZTeamlist() {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(teamsbutton));
		WebElement nzOption=driver.findElement(teamNameNZ);
		nzOption.click();
	}
	public void closenoti() {
		try {
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10) );
			wait.until(ExpectedConditions.visibilityOfElementLocated(notNownoti)).click();
            System.out.println("Closed Notification");
        } catch (NoSuchElementException e) {
            System.out.println("no notification present");
        }
		
	}
	public void closeAdvert() {
		driver.switchTo().frame(driver.findElement(iframeX));
		//WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10) );
		//WebElement closeAdvert=wait.until(ExpectedConditions.visibilityOfElementLocated(advtCloseBtn));
		WebElement closeAdvert=driver.findElement(advtCloseBtn);
		closeAdvert.click();
		driver.switchTo().parentFrame();
		
//		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10) );
//		
//		try {
//			driver.switchTo().frame(driver.findElement(iframeX));
//			WebElement closeAdvert=wait.until(ExpectedConditions.visibilityOfElementLocated(advtCloseBtn));
//			closeAdvert.click();
//            System.out.println("Closed Advert popUp");
//            driver.switchTo().parentFrame();
//        } catch (NoSuchElementException e) {
//            System.out.println("Advert popUp not found or already closed");
//        }
		
		
	}
	public void goToPlayrsTab() throws InterruptedException {
		Thread.sleep(11000);
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(teamsbutton));
		WebElement playersoption=driver.findElement(playersTab);
		playersoption.click();
	}
	public String getFirstPlayerName() {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10) );
		WebElement player=wait.until(ExpectedConditions.visibilityOfElementLocated(firstPlayer));
		String playerName=player.getText();
		return playerName;
	}

}

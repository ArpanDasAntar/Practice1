package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import factory.DriverFactory;
import pages.CricInfoPage;
import pages.MMTHomePage;

public class BaseTest {
	public DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public MMTHomePage hp;
	public CricInfoPage cp;
	 
	
	@BeforeTest
	public void setUp() {
		
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		hp = new MMTHomePage(driver);
		cp = new CricInfoPage(driver);
		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
		
	}

}

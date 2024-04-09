package factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(Properties prop){
		String browser = prop.getProperty("browser").trim();
		System.out.println("browser name is:" + browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("please pass the right browser..." + browser);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url").trim());
		
		return driver;
		
	}
	
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}

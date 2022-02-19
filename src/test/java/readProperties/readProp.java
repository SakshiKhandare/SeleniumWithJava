package readProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class readProp {
public static WebDriver driver;
	
	public static void main(String[] args) throws IOException  {

		// read data from properties class
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Office Work Code\\GitCode\\Selenium\\"
				+ "SeleniumTestcases\\src\\test\\resources\\config.properties");
		prop.load(ip);
		
		String browser = prop.getProperty("browser");
		if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(prop.getProperty("uname"));
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(prop.getProperty("pass"));
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		driver.close();
		
		
	}
}

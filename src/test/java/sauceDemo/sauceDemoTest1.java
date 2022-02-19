package sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class sauceDemoTest1 {

	public static String browser = "edge";
	public static WebDriver driver;

	public static void main(String[] args) { 

		if (browser.equals("firefox")) { 
			WebDriverManager.firefoxdriver().setup() ; 
			driver = new FirefoxDriver();
		}
	else if(browser.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	else if(browser.equals("edge")){ 
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		driver.close();
	
}
}

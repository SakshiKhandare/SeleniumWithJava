package generateLogs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

//What is log? : capturing info/activities at the time of program execution. 
	// types of logs:
		//1. info
		//2. warn
		//3. debug
		//4. fatal
		
	//how to generate the logs? : use Apache log4j API (log4j jar)
	//How it works? : it reads log 4j configuration from log4j.properties file
	//where to create: create inside resources folder

public class logUsinglog4j {

	public static WebDriver driver;
	Logger log = Logger.getLogger(logUsinglog4j.class);
	
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		log.info("****************************** Starting test cases execution  *****************************************");
		log.info("launching chrome broswer");
		
		SoftAssert softassert = new SoftAssert();
		String expTitle ="Electronics, Cars, Fashion, Collectibles & More | eBay";
		String expText = "Search";
				
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		String actTitle = driver.getTitle();
		String actText = driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).getAttribute("value");
		//Assert.assertEquals(actTitle, expTitle);
		softassert.assertEquals(actTitle, expTitle,"Title verification failed");
		softassert.assertEquals(actText, expText);
		softassert.assertAll();
		
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
		
		driver.close();
	}
	
}

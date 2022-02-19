package downloadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class downloadZipFirefox {

public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		
		//creating browser profile
		// https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
		
		FirefoxProfile profile = new FirefoxProfile();
		
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip"); //set MIME type
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		
		FirefoxDriver driver = new FirefoxDriver(option);
		
		driver.get("http://testingmasters.com/student-corner/downloads/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Download")).click();
		
		Thread.sleep(5000);
		
		driver.close();
		
}
}

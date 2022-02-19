package screenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class captureScreenshot {

	//https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html
		// Search Takes Screenshot
		// https://commons.apache.org/proper/commons-io/
	public static void main(String[] args) throws InterruptedException, IOException {
			
			Date currentDate = new Date();
			String ssFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
			
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.ebay.com/");
			driver.manage().window().maximize();
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(".//screenshot/"+ssFileName+".png"));
			Thread.sleep(2000);
			driver.close();
	}
}

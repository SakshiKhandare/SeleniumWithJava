package javascriptExecutor;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class jsExecutor {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.twoplugs.com/");
		
		// Flashing an elememt
		WebElement joinBtn = driver.findElement(By.xpath("/html/body/div[1]/header/div/ul/li[2]/a"));
		javaScriptUtil.flash(joinBtn, driver);;
		
		// Drawing border around element
		WebElement borderBtn = driver.findElement(By.xpath("/html/body/div[1]/header/div/ul/li[2]/a"));
		javaScriptUtil.drawBorder(borderBtn, driver);
		
		// Screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File trg =  new File("D://Office Work Code/Selenium/twoplugs.png");
		FileUtils.copyFile(src,trg);
		
		// Title
		System.out.println(javaScriptUtil.getTitleByJS(driver));
		
		// Scrolling till we find some element
		WebElement scroll = driver.findElement(By.xpath("/html/body/div[1]/section[6]/div/div[2]/a/span"));
		javaScriptUtil.scrollIntoView(scroll, driver);
		
		// Scroll till end
		javaScriptUtil.scrollPageDown(driver); 
		
		// Clicking an element
		WebElement loginBtn = driver.findElement(By.xpath("/html/body/div[1]/header/div/ul/li[1]/a"));
		javaScriptUtil.clickElement(loginBtn, driver);
		
		// Refresh
		javaScriptUtil.refreshBrowser(driver);
		
		// generate alert
		javaScriptUtil.generateAlert("You clicked Login Btn", driver);
		
		driver.close();
}
}

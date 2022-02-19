package keyboardEvents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

//https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html
	// All classes -> Keys
public class keyboardEvents {

public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://extendsclass.com/text-compare.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement sourceArea = driver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[5]/pre/span"));
		WebElement targetArea = driver.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[3]/pre"));
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.keyDown(sourceArea, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		Thread.sleep(2000);
		action.keyDown(targetArea, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
		
}
}

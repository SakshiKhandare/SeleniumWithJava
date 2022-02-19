package dropDown;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class makeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/label/span")).click();
		WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
		from.sendKeys("Mumbai");
		Thread.sleep(2000);
		from.sendKeys(Keys.ARROW_DOWN);	
		Thread.sleep(2000);
		from.sendKeys(Keys.ENTER);	
		Thread.sleep(2000);
		driver.close();
		
	}
}

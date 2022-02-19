package frames;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class prompt {

public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("/html/body/button")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("sakshi");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText());
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		driver.close();
		
	}
}

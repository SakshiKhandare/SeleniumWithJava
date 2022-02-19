package dynamicGoogleSearch;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class dynamicGoogleSearch {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("testing");
		
		List<WebElement> list = driver.findElements(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]//li/descendant::div[@class='wM6W7d']"));
		System.out.println(list.size());
		//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]
		
		//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[2]/div[2]/ul[1]
	}	
}

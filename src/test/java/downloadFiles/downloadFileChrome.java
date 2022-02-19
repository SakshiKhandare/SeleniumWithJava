 package downloadFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class downloadFileChrome {

public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("textbox")).sendKeys("testing");
		driver.findElement(By.xpath("//*[@id='createTxt']")).click();
		driver.findElement(By.xpath("//*[@id=\'link-to-download\']")).click();
		
		driver.close();
		
}
}

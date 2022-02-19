package multipleWindows;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

// https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.TargetLocator.html#window(java.lang.String)
// https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html#getWindowHandle()

public class handlingWindows {

public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/?ir=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div[1]/div/a")).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		
		Iterator<String> iterator = windows.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();
		
		driver.switchTo().window(childwindow);
		driver.findElement(By.name("UserFirstName")).sendKeys("sakshi");
		driver.findElement(By.name("UserLastName")).sendKeys("khandare");
		driver.switchTo().window(parentwindow);
		driver.close();
		
	}
}


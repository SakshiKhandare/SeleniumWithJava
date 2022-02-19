package dropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//handle dropdown with select tag
//documentation - https://www.selenium.dev/selenium/docs/api/java/overview-summary.html
// https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ISelect.html

public class sugarCRM {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ddown = driver.findElement(By.name("employees_c"));
		Select select = new Select(ddown);
		
		WebElement firstOption = select.getFirstSelectedOption();
		System.out.println(firstOption.getText());
				
		select.selectByValue("level1");
		Thread.sleep(2000);
		select.selectByVisibleText("51 - 100 employees");
		Thread.sleep(2000);
		select.selectByIndex(4);
		Thread.sleep(2000);
		driver.close();
		
	}
}

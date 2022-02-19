package authenticationPopup;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class popup {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Suppose we are reading data from external files
		String password = "admin";
		String username = "admin";

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.get("https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}

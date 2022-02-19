package encodeDecode;

import java.time.Duration;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginWithEncryption {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("test@mail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(decodePass("ZGVtbzEyMw=="));
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
		driver.close();
	}
	
	static String decodePass(String pass) {
		byte[] decodePass  =Base64.decodeBase64(pass);
		return new String(decodePass);
	}
}

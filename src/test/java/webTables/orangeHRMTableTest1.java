package webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class orangeHRMTableTest1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();	
		driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']")).click();
		driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']")).click();
		
		int r = driver.findElements(By.xpath("//tbody/tr")).size();
		System.out.println(r);
		
		// to check how many rows have last column as "Enabled"
		int count = 0;
		for(int i=2;i<=r;i++) {
				String status = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[5]")).getText();
				if(status.equals("Enabled")) {
					count= count+1;
				}	}
		System.out.println(count);
		
		driver.close();
	}	
}

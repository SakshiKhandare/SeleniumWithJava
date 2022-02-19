package webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class orangeHRMTableTest2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();	
		driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
		
		int r = driver.findElements(By.xpath("//tbody/tr")).size();
		System.out.println(r);
		
		for(int i=1;i<=r;i++) {
			String id = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]")).getText();
			String firstname = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[3]")).getText();
			String lastname = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]")).getText();
			System.out.println(id + "   " + firstname + "   " + lastname);
				}
		driver.close();
	}	
}

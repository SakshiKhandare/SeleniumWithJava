package webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class localHtmlTable {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Asus/Desktop/Work/Selenium/table.html");
		
		int r = driver.findElements(By.xpath("html/body/table/tbody/tr")).size();
		System.out.println(r);
		
		int c = driver.findElements(By.xpath("html/body/table/tbody/tr/th")).size();
		System.out.println(c);
		

		for(int i=2;i<=r;i++) {
			for(int j=1;j<=c;j++) {
				System.out.print(driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td["+j+"]")).getText()+" ");
			}
			System.out.println();
		}
		
	}	
}

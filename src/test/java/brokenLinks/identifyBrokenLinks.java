package brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;

import io.github.bonigarcia.wdm.WebDriverManager;

public class identifyBrokenLinks {

public static void main(String[] args) throws FindFailed, IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.guru99.com/test/newtours/");
		
		// captures links from webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));
			
		// number of links
		System.out.println(links.size());
		
		for(int i=0;i<links.size();i++) {
			
			// by using href attribute we can get URL of required link
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			
			URL link = new URL(url);
			
			// create a connection using url object 'link'
			HttpURLConnection httpConn = (HttpURLConnection)link.openConnection();
			
			//establish connection
			httpConn.connect();
			
			// if resCode is >400 then link is broken
			int resCode = httpConn.getResponseCode();
			
			if(resCode >= 400) {
				System.out.println(url + "-" + " is broken link");
			}
			else {
				System.out.println(url + "-" + " is valid link");
			}
		}
		
		driver.close();
}
}

package aShotAPI;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
public class captureImg {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement logoImgElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/img[1]"));
		Screenshot logoImgSS = new AShot().takeScreenshot(driver,logoImgElement);
		ImageIO.write(logoImgSS.getImage(), "png",new File("D://Office Work Code/Selenium/Ashot/OrganeHRMLogo.png"));
		
		File f = new File("D://Office Work Code/Selenium/Ashot/OrganeHRMLogo.png");
		if (f.exists())
			System.out.println("Img file captured");
		else
			System.out.println("Img file doesn't exists");
		
		driver.close();
		
	}
}

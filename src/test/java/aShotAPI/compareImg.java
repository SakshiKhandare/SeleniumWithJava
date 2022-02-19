package aShotAPI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class compareImg {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		BufferedImage expectedImg = ImageIO.read(new File("D://Office Work Code/Selenium/Ashot/OrganeHRMLogo.png"));
		
		WebElement logoImgElement = driver.findElement(By.xpath("//*[@id=\'divLogo\']/img"));
		Screenshot logoImgSS = new AShot().takeScreenshot(driver,logoImgElement);
		BufferedImage acualImg =logoImgSS.getImage();
		
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(expectedImg, acualImg);
		
		if (diff.hasDiff()==true)
			System.out.println("Img are not same");
		else
			System.out.println("Img are same");
		
		driver.close();
		
	}
	
}

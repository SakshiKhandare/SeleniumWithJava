package apachePDFBoxAPI;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

// website
// https://www.betterteam.com/downloads/employee-information-form-download-20170810.pdf
// https://www.axmag.com/download/UserGuide.pdf

public class pdfReader {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// read url from site
		driver.get("https://www.betterteam.com/downloads/employee-information-form-download-20170810.pdf");

		// read url from local machine
		// driver.get("file:///C:/Users/Asus/Downloads/Manual-Testing-Faqs.pdf");

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		URL url = new URL(currentUrl);
		InputStream is = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(is);
		PDDocument document = null;

		document = PDDocument.load(fileParse);
		String pdfContent = new PDFTextStripper().getText(document);
		System.out.println(pdfContent);

		driver.close();

	}
}

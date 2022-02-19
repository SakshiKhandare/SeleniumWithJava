package javascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javaScriptUtil {

	public static void flash(WebElement element,WebDriver driver) {
		String bgcolor = element.getCssValue("backgroundColor");
		
		for(int i=0;i<20;i++) {
			changeColor("#0000FF",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor ='"+color+"'", element);
		try {
			Thread.sleep(20);
		}
		catch(InterruptedException e) {
			
		}}
	
	public static void drawBorder(WebElement element,WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
		
	}
	
	public static void clickElement(WebElement element,WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static void generateAlert(String msg,WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + msg + "')");
		
	}
	
	public static void refreshBrowser(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
		
	}
	
	public static void scrollIntoView(WebElement element,WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
}

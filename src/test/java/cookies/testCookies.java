package cookies;

import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testCookies {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		// captures all cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies);
		System.out.println("size of cookies----" + cookies.size());

		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + "   " + cookie.getValue() + "   " + cookie.getExpiry());
		}

		System.out.println(driver.manage().getCookieNamed("session-id-time"));

		// add new cookie to browser
		Cookie cobj = new Cookie("mycookie", "1234567");
		driver.manage().addCookie(cobj);
		cookies = driver.manage().getCookies();
		System.out.println("size of cookies----" + cookies.size());
		
		// delete specific cookie
		driver.manage().deleteCookie(cobj);
		cookies = driver.manage().getCookies();
		System.out.println("size of cookies----" + cookies.size());
		
		// delete all cookies
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("size of cookies----" + cookies.size());
		
		driver.close();
	}
}

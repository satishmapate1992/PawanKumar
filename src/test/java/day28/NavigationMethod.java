package day28;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethod {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		// driver.get("https://demo.nopcommerce.com/"); // accept parameter in string format
		// driver.navigate().to("https://demo.nopcommerce.com/");
		@SuppressWarnings("deprecation")
		URL myurl = new URL("https://demo.nopcommerce.com/");
		driver.navigate().to(myurl);   // accept parameter in string as well as url object format
		Thread.sleep(2000);
		driver.navigate().to("http://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		
		
		
	}

}

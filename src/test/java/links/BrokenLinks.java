package links;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {

		
		// broken links which does't have any resource in server.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	//	driver.get("http://www.DeadLinkCity.com");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		
		List<WebElement> links = driver.findElements(By.tagName("a"));  // capture all links from web page
		System.out.println("Total links- " + links.size());
		int brokenlink = 0;

		for (WebElement link : links) {
			String url = link.getAttribute("href");

			if (url == null || url.isEmpty()) {
				System.out.println("URL is empty or null");
				continue;
			}
			
			// it url in server
			try {

				@SuppressWarnings("deprecation")
				URL urlLink = new URL(url);  // convert string to URL format
				HttpURLConnection conn = (HttpURLConnection) urlLink.openConnection(); // open connection to server
				conn.connect();  // connect to server and sent request to server
				int responseCode = conn.getResponseCode();
				if (responseCode > 400) {
					System.out.println("Broken link: " + url + " | Status: " + responseCode);
					brokenlink++;
				} else {
					System.out.println("Valid link: " + url + " | Status: " + responseCode);
				}

			} catch (Exception e) {
				System.out.println("Error checking link: " + url + " | Message: " + e.getMessage());
			}

		}
		System.out.println("Total broken links are- " + brokenlink);
		driver.quit();
	}

}

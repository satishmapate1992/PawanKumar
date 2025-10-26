package handleWindowsDifferentWays;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Method3 {

	// Switch to a window by title

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

		System.out.println("Parent window title- " + driver.getTitle());

		String desiredTitle = "Human Resources Management Software | HRMS | OrangeHRM";
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equals(desiredTitle)) {
				break;
			}
		}

		driver.quit();
	}

}

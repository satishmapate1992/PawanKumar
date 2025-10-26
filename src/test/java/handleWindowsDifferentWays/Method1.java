package handleWindowsDifferentWays;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Method1 {

	// 1. Switch to the next available window

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

		System.out.println("Parent window title- " + driver.getTitle());

		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();

		for (String handle : allHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}

		System.out.println("Child window title- " + driver.getTitle());

		driver.quit();
	}

}

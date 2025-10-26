package handleWindowsDifferentWays;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Method4 {

	// Switch to a window by index

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

		System.out.println("Parent window title- " + driver.getTitle());

		Set<String> winID = driver.getWindowHandles();

		ArrayList<String> winlst = new ArrayList<String>(winID);

		driver.switchTo().window(winlst.get(1));

		System.out.println("Child window title- " + driver.getTitle());

		driver.quit();

	}

}

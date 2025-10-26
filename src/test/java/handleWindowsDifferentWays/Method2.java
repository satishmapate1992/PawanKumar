package handleWindowsDifferentWays;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Method2 {

	// Switch using an iterator

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

		System.out.println("Parent window title- " + driver.getTitle());

		Iterator<String> windowIterator = driver.getWindowHandles().iterator();
		String parentWindow = windowIterator.next();
		String childWindow = windowIterator.next();

		driver.switchTo().window(childWindow);
		System.out.println("Child window title- " + driver.getTitle());

		driver.switchTo().window(parentWindow);
		System.out.println("Parent window title- " + driver.getTitle());

		driver.quit();

	}

}

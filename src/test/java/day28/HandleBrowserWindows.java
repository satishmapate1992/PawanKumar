package day28;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("http://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set<String> windowIDs = driver.getWindowHandles();
		ArrayList<String> listOfID= new ArrayList<>(windowIDs);
		String parentID= listOfID.get(0);
		String ChildID= listOfID.get(1);
		System.out.println(driver.getTitle());
		
		
		// switch to child window
		
		driver.switchTo().window(ChildID);
		// driver.findElement(By.xpath("//a[@class='nav-link-hed'][normalize-space()='Pricing']")).click();
	
		System.out.println(driver.getTitle());
		
		// switch to parent window.
		
		driver.switchTo().window(parentID);
		
	}

}

package browserMethodsAndNavigationMethods;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsNavigation {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/"); 
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		 List<WebElement> serachItemas = driver.findElements(By.xpath("//*[contains(@id,'wikipedia-search-results')]/div/a"));
		 System.out.println("Search iteams count: "+serachItemas.size());
		 for(WebElement item:serachItemas) {
			 item.click();
		 }
		 
		 Set<String> windIDs = driver.getWindowHandles();
		 for(String ID:windIDs) {
			 String title=driver.switchTo().window(ID).getTitle();
			 System.out.println(title);
			 if(title.equals("Selenium dioxide - Wikipedia")) {
				 driver.close();
			 }
			 
		 }
	}

}

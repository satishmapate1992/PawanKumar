package handleDropDown;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropDown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		
		// login steps
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		// clicking on PIM
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		
		// click on dropdown
		driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/following-sibling::div//*[contains(@class,'select-text--arrow')]")).click();
		
		
		// select one element
		// driver.findElement(By.xpath("//*[text()='Account Assistant']")).click();
		
		// fetch all elements from drop down
		List<WebElement> drpDpwnValues=driver.findElements(By.xpath("//*[@role='option']//span"));
		
		int totalElements= drpDpwnValues.size();
		
		System.out.println("Total elements: "+totalElements);
		
		for(WebElement value:drpDpwnValues) {
			System.out.println(value.getText());
		}
		
		
		
		
		
	}
}

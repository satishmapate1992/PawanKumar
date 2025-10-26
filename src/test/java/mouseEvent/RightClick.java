package mouseEvent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightClickMe = driver.findElement(By.xpath("//span[normalize-space()='right click me']"));

		Actions act = new Actions(driver);
		act.contextClick(rightClickMe).perform();
		
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();		
				
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		System.out.println("print");
		
		

	}

}

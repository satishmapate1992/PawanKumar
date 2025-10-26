package keyboardEvent;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		Actions act = new Actions(driver);
		
		WebElement register=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		act.moveToElement(register).perform();
		
		act.keyDown(Keys.CONTROL).click(register).keyUp(Keys.CONTROL).perform();
		
		Set<String> windID = driver.getWindowHandles();
		
		List<String> lstID= new ArrayList<String>(windID);
		
		
		driver.switchTo().window(lstID.get(1));
		
		driver.findElement(By.id("small-searchterms")).sendKeys("iphone");
		
		driver.switchTo().window(lstID.get(0));
		
		driver.findElement(By.id("small-searchterms")).sendKeys("samsung");
		
		

	}

}

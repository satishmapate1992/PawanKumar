package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		Wait<WebDriver> wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		WebElement SearchStore = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#small-searchterms")));
		SearchStore.sendKeys("iphone");	

	}	
}

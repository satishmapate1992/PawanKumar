package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class FluentWait {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		Wait<WebDriver> wait =
		        new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(2))
		            .pollingEvery(Duration.ofMillis(300))
		            .ignoring(ElementNotInteractableException.class);

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		@SuppressWarnings("unchecked")
		WebElement element = (WebElement) wait.until(
			    ExpectedConditions.elementToBeClickable(By.cssSelector("input#small-searchterms"))
			);
		element.sendKeys("iphone");
	}

}

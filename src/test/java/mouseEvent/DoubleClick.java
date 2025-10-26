package mouseEvent;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");

		driver.switchTo().frame("iframeResult");

		// input[@id='field1']
		// input[@id='field2']
		// button[normalize-space()='Copy Text']

		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement copyText = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

		field1.clear();
		field1.sendKeys("Welcome");

		Actions act = new Actions(driver);

		act.doubleClick(copyText).perform();

		String field2Text = field2.getAttribute("value");

		if (field2Text.equals("Welcome")) {
			System.out.println("Text copied");
		} else {
			System.out.println("Text not copied");
		}

	}

}

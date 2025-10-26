package keyboardEvent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardAction {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://text-compare.com/");
		Actions act = new Actions(driver);

		driver.findElement(By.id("inputText1")).sendKeys("Welcome to India");
		WebElement textBox2 = driver.findElement(By.id("inputText2"));

		// ctrl+A - select text

		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

		// ctrl+C- copy text

		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

		// tab

		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

		// ctrl+V - paste text to another text box

		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

	}

}

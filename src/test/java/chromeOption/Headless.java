package chromeOption;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;

public class Headless {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://text-compare.com/");
		Actions act = new Actions(driver);

		driver.findElement(By.id("inputText1")).sendKeys("Welcome to India");
		WebElement textBox2 = driver.findElement(By.id("inputText2"));
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		System.out.println("test case passed");

	}

}

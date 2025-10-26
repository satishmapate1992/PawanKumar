package shadowDOM_SVG;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
//		driver.get("https://books-pwakit.appspot.com/");

//		 SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
//		shadow.findElement(By.cssSelector("#input")).sendKeys("Welcome");

		driver.get("https://dev.automationtesting.in/shadow-dom");
		SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(2000);
		SearchContext shadow1 = shadow.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(2000);
		String geTxt = shadow1.findElement(By.cssSelector("#nested-shadow-element")).getText();
		System.out.println(geTxt);
		driver.quit();

	}

}

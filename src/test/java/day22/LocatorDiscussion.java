package day22;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDiscussion {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		WebElement searchBox=driver.findElement(By.name("search"));
		searchBox.sendKeys("TShirt");
	}

}

package javaScriptExecutorDemo;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecuteScript {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement name=driver.findElement(By.id("name"));
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		// passing text to textbox- alternate of sendkeys method
		js.executeScript("arguments[0].value='India';", name);
		
		WebElement maleRadioBtn= driver.findElement(By.id("male"));
		
		// alternate for click
		js.executeScript("arguments[0].click();", maleRadioBtn);
		
		
		
		
		
		
		
		

	}

}

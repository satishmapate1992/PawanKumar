package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_Selector {

	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// tag id
		
		// driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("iphone");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("iphone");
		
		// tag classname
		// driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("iphone");
		// driver.findElement(By.cssSelector(".search-box-text")).sendKeys("iphone");
		
		
		// tag attribute  tag[attribute=value]
		
		//	driver.findElement(By.cssSelector("input[input[placeholder=\"Search store\"]]")).sendKeys("iphone");
		//	driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("iphone");
		//	driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("iphone");
		
		
		// tag class attribute	tag.class[attribute=value]
			
		//	driver.findElement(By.cssSelector("input.search-box-text[placeholder=\"Search store\"]")).sendKeys("iphone");
		// driver.findElement(By.cssSelector("input.search-box-text[placeholder='Search store']")).sendKeys("iphone");
			driver.findElement(By.cssSelector(".search-box-text[placeholder='Search store']")).sendKeys("iphone");
		
		
	}

}

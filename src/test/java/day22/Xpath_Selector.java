package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Selector {

	public static void main(String[] args) {
	
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// xpath with single attribute
		
		// driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("iphone"); 
		// driver.findElement(By.xpath("//*[@id='small-searchterms']")).sendKeys("iphone");
	
		// xpath with multiple attribute
		
			//driver.findElement(By.xpath("//input[@id='small-searchterms'][@name='q']")).sendKeys("iphone");
		
		
		// xpath with 'and' 'or' operator
		
		
		//	driver.findElement(By.xpath("//*[@id='small-searchterms' and @name='q']")).sendKeys("iphone");
		// driver.findElement(By.xpath("//*[@id='small-searchterms' or @name='q']")).sendKeys("iphone");
		
		// xpath with inner text- text()
			//driver.findElement(By.xpath("//*[text()='Computers ']")).click();
	/*	boolean isDesplay=driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).isDisplayed();
		System.out.println(isDesplay);
	*/	
	
/*		boolean isDesplay=driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).isDisplayed();
		System.out.println(isDesplay);
	*/
		
	/*	String value=driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).getText();
		System.out.println(value);
	
		*/
		
		// xpath with contains
		
		
		//	driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys("andriod");
		
		// xpath with starts-with
		
			// driver.findElement(By.xpath("//input[starts-with(@placeholder,'Search')]")).sendKeys("andriod");
			
			
		// chained xpath
			
		driver.findElement(By.xpath("// div[contains(@class,'search-box')]/form/input")).sendKeys("andriod");
			
		
		
	}

}

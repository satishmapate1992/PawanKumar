package javaScriptExecutorDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
			
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		//1- scroll down page by pixel number
/*		
		js.executeScript("window.scrollBy(0,3000);");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//2- Scroll till webelement
		
		WebElement cuba=driver.findElement(By.xpath("//td[normalize-space()='Cuba']"));
		
		js.executeScript("arguments[0].scrollIntoView();", cuba);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//3- scroll till end of page
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(2000);
		// scroll at initial stage
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight);");
		System.out.println(js.executeScript("return window.pageYOffset;"));
	*/	

	}

}

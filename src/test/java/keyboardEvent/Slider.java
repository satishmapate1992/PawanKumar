package keyboardEvent;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		Actions act= new Actions(driver);
		
		// handle min slider
		
		WebElement minSlider=driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));		
		System.out.println("min Location: "+minSlider.getLocation());  // (59, 250)		
		act.dragAndDropBy(minSlider, 200, 257).perform();		
		System.out.println("Location: "+minSlider.getLocation());  // (258, 250)
		
		// handle max slider
		
		WebElement maxSlider=driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
		System.out.println("max Location: "+maxSlider.getLocation()); // (545, 250)
		act.dragAndDropBy(maxSlider, -100, 197).perform();		
		System.out.println("Location: "+maxSlider.getLocation()); // (443, 250)
		
		
		
		
		
		
	//	driver.quit();
		
		
		
		
		
		
		
	}

}

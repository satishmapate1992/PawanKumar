package checkBoxHandling;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBox {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/"); 
	/*	
		String day="monday";		
		
		// select checkbox
		
		WebElement chkBox=driver.findElement(By.xpath("//input[@id='"+day+"']"));
		
		if(!chkBox.isSelected()) {
			chkBox.click();
		}
		
	*/	// select multiple checkboxes
		
	//	List<WebElement> chkBoxs=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
	/*	for(int i=0; i<chkBoxs.size();i++) {			
			if(!chkBoxs.get(i).isSelected()) {
				chkBoxs.get(i).click();
			}
		}
	*/
	/*	
		for(WebElement chBox:chkBoxs) {
			if(!chBox.isSelected()) {
				chBox.click();
			}
		}
	*/	
		// select alternate checkboxes
		
	/*	for(int i=1; i<chkBoxs.size();i=i+2) {			
			if(!chkBoxs.get(i).isSelected()) {
				chkBoxs.get(i).click();
			}
		}
	*/
		
		// select checkbox using switch case
		
		String day="Thursday";
		switch(day) 
		{
		
		case "Monday": driver.findElement(By.xpath("//input[@id='monday']")).click();
						break;
		case "Tuesday": driver.findElement(By.xpath("//input[@id='tuesday']")).click();
						break;
		case "Wednesday": driver.findElement(By.xpath("//input[@id='wednesday']")).click();
						break;
		case "Thursday": driver.findElement(By.xpath("//input[@id='thursday']")).click();
						break;
		case "Friday": driver.findElement(By.xpath("//input[@id='friday']")).click();
						break;
		case "Saturday": driver.findElement(By.xpath("//input[@id='saturday']")).click();
						break;
		case "Sunday": driver.findElement(By.xpath("//input[@id='sunday']")).click();
						break;
		default: System.out.println("invalid week day");
		
		
		}
		
	}

}

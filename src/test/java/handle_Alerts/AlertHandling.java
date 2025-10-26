package handle_Alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		// Normal alert with OK button
		/*
		  driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click(); String
		  alertText = driver.switchTo().alert().getText();
		  driver.switchTo().alert().accept(); 
		  System.out.println(alertText);
		  
		 */
		// confirmation alert OK and Cancel button

		/*
		  driver.findElement(By.
		  xpath("//button[normalize-space()='Click for JS Confirm']")).click(); 
		  String alertText = driver.switchTo().alert().getText();
		  driver.switchTo().alert().dismiss(); System.out.println(alertText); 
		  String result= driver.findElement(By.xpath("//p[@id='result']")).getText();
		  System.out.println(result);
		  
		 */

		// prompt alert- Input box

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Alert myalert = driver.switchTo().alert();
		String alertText = myalert.getText();
		System.out.println(alertText);
		myalert.sendKeys("Welcome");
		myalert.accept();
		String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(result);

	}
}

package handle_Frame;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_Frame {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");

		// Frame1
		WebElement iframe1 = driver.findElement(By.xpath("//frame[contains(@src,'frame_1.html')]"));
		driver.switchTo().frame(iframe1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");
		
		driver.switchTo().defaultContent();
		
		// Frame2
		
		WebElement iframe2 = driver.findElement(By.xpath("//frame[contains(@src,'frame_2.html')]"));
		driver.switchTo().frame(iframe2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("to selenium");
		
		driver.switchTo().defaultContent();
		
		// Frame3
		
		WebElement iframe3 = driver.findElement(By.xpath("//frame[contains(@src,'frame_3.html')]"));
		driver.switchTo().frame(iframe3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Frame");
		
		// inner frame / nested frame
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='i6']//div[@class='AB7Lab Id5V1']")).click();
		
		

	}

}

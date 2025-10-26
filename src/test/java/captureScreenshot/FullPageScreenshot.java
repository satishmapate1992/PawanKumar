package captureScreenshot;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullPageScreenshot {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");

		// 1. capture full page screenshot
/*
		TakesScreenshot pics = (TakesScreenshot) driver;
		File source = pics.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir") + "\\Screenshot\\fullpage.png");
		FileUtils.copyFile(source, targetFile);
*/		
		
		//2 capture specific section of page
		
		WebElement fetureProducts= driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File source =fetureProducts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir") + "\\Screenshot\\fetureProduct.png");
		FileUtils.copyFile(source, targetFile);
		
		driver.quit();

	}

}

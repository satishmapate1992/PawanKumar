package javaScriptExecutorDemo;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/upload");
		File uploadFile = new File("C:\\Users\\System Plus\\Downloads\\Upload doc.txt");

		WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
		fileInput.sendKeys(uploadFile.getAbsolutePath());
		driver.findElement(By.id("file-submit")).click();

		WebElement fileName = driver.findElement(By.id("uploaded-files"));
		Assert.assertEquals("Upload doc.txt", fileName.getText());

		driver.quit();

	}

}

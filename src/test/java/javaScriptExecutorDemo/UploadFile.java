package javaScriptExecutorDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();

		// upload single file
/*		
		driver.findElement(By.id("filesToUpload")).sendKeys("C:\\Users\\System Plus\\Downloads\\file1.txt");
		String uploadedFile = driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText();

		if (uploadedFile.equals("file1.txt")) {
			System.out.println("file upload successfully");
		} else {
			System.out.println("file upload fail");
		}
*/
		
		// upload multiple file
		
		String file1="C:\\Users\\System Plus\\Downloads\\file1.txt";
		String file2="C:\\Users\\System Plus\\Downloads\\file2.txt";
		
		driver.findElement(By.id("filesToUpload")).sendKeys(file1+"\n"+file2);
		String uploadedFile = driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText();
		String uploadedFile2 = driver.findElement(By.xpath("//ul[@id='fileList']/li[2]")).getText();
		
		if(uploadedFile.equals("file1.txt") && uploadedFile2.equals("file2.txt")) {
			System.out.println("file match successfully");			
		}else {
			System.out.println("file missmatch");
		}
		
		
		
		
	}

}

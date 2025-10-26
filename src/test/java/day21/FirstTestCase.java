package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) {
		
		// ChromeDriver driver= new ChromeDriver();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.youtube.com/@TV9MarathiLive");
		String actualTitile=driver.getTitle();
		
		if(actualTitile.equalsIgnoreCase("TV9 Marathi - YouTub")) 
		{
			System.out.println("Test case pass");
		}else {
			System.out.println("Test case fail");
		}
		driver.close();
		
	}

}

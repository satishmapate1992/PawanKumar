package tableHandling;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		int total_Rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		int total_Column = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]/th")).size();
/*
		// print table

		System.out.println("BookName" + "\t" + "Author" + "\t" + "Subject" + "\t" + "Price");
		for (int r = 2; r <= total_Rows; r++) {
			for (int c = 1; c <= total_Column; c++) {
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[" + c + "]"))
						.getText();
				System.out.print(value + "\t");
			}
			System.out.println();
		}

		// print Bookname by author

		for (int r = 2; r <= total_Rows; r++) {
			List<WebElement> Authers = driver.findElements(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[2]"));

			for (WebElement author : Authers) {
				if (author.getText().equalsIgnoreCase("mukesh")) {
					String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[1]"))
							.getText();
					System.out.println(bookName);
				}
			}

		}

		// total price

		int sum = 0;

		for (int r = 2; r <= total_Rows; r++) {

			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[4]")).getText();

			sum = sum + Integer.parseInt(price);

		}
		System.out.println("total price of book: " + sum);

		// find lowest price of book

		for (int r = 2; r <= total_Rows; r++) {

			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[4]")).getText();

			sum = sum + Integer.parseInt(price);

		}
		
*/		
		
		// print book name of lowest price
		
		int[] str= new int[total_Rows-1];
	
		int i=0;
		for (int r = 2; r <= total_Rows; r++) {
			
				String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[4]"))
						.getText();
				str[i]=Integer.parseInt(price);
				i++;
		}
		
		Arrays.sort(str);
		
	//	String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//td[text()='"+str[1]+"']//preceding-sibling::td[3]")).getText();
	//	System.out.println(bookName);
		
		List<WebElement> headers = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]/th"));
		int columnIndex = -1;

		for (int j = 0; j < headers.size(); j++) {
		    if (headers.get(j).getText().equalsIgnoreCase("BookName")) {
		        columnIndex = j + 1; // XPath is 1-based
		        break;
		    }
		}

		System.out.println("BookName column is at index: " + columnIndex);
		
		String bookName1=driver.findElement(By.xpath(
				"//table[@name='BookTable']//td[text()='"+str[1]+"']//parent::tr/preceding-sibling::tr//th[text()='BookName']//following::td["+columnIndex+"]"))
				.getText();
		System.out.println(bookName1);
		
		
		driver.quit();

	}

}

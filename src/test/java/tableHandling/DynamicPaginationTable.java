package tableHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable 
{

	public static void main(String[] args)
	{

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Pagination Web Table']"));
		js.executeScript("arguments[0].scrollIntoView();", element);

		int totalRows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
		List<WebElement> pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li/a"));
		int totalColumn = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();

		for (WebElement currentPageCount : pageCount) 
		{
			int j = Integer.parseInt(currentPageCount.getText());
			{
				for (int r = 1; r <= totalRows; r++) {
					for (int c = 1; c <= totalColumn - 1; c++)
					{
						if (j > 1) 
						{
							currentPageCount.click();
						}
						String rowData = driver
								.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + r + "]/td[" + c + "]"))
								.getText();
						System.out.print(rowData + "\t");
					}
					System.out.println();

				}

			}
		}

		driver.quit();

	}

}

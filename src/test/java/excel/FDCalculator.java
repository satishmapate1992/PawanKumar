package excel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FDCalculator {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		driver.findElement(By.xpath("//*[@id=\"wzrk-cancel\"]")).click();  // clicked on popup

		String filePath = System.getProperty("user.dir") + "\\Test Data\\" + "Simple Interest.xlsx";

		int totalRows = ExcelUtils.getRowCount(filePath, "Sheet1");

		for (int i = 1; i <= totalRows; i++) 
		{

			driver.findElement(By.xpath("//input[@id='principal']"))
					.sendKeys(ExcelUtils.getCellData(filePath, "Sheet1", i, 0));
			driver.findElement(By.xpath("//input[@id='interest']"))
					.sendKeys(ExcelUtils.getCellData(filePath, "Sheet1", i, 1));
			driver.findElement(By.xpath("//input[@id='tenure']"))
					.sendKeys(ExcelUtils.getCellData(filePath, "Sheet1", i, 2));

			Select sel = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			sel.selectByVisibleText(ExcelUtils.getCellData(filePath, "Sheet1", i, 3));

			Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			sel2.selectByVisibleText(ExcelUtils.getCellData(filePath, "Sheet1", i, 4));
			driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[1]/img")).click();  // click on calculate

			String actualInterst = driver.findElement(By.xpath("//*[@id='resp_matval']//strong")).getText();
			String expecetdInterst = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);

			System.out.println("UI value- " + actualInterst);
			System.out.println("Excel value- " + expecetdInterst);

			if (Double.parseDouble(actualInterst) == Double.parseDouble(expecetdInterst)) 
			{
				System.out.println("Test case pass");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Pass");
				ExcelUtils.setGreenColor(filePath, "Sheet1", i, 7);
			} 
			else
			{
				System.out.println("Test case Fail");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Fail");
				ExcelUtils.setRedColor(filePath, "Sheet1", i, 7);
			}

			driver.findElement(By.xpath("//img[@class='PL5']")).click();  // click on clear
			Thread.sleep(3000);
		}

		driver.quit();

	}

}

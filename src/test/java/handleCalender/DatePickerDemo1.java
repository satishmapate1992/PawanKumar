package handleCalender;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {

	static void selectDate(WebDriver driver, String date) {

		List<WebElement> dates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

		for (WebElement dt : dates) {

			if (dt.getText().equals(date)) {
				dt.click();
			}

		}

	}

	static Month convertMonth(String month) {

		HashMap<String, Month> monthMap = new HashMap<String, Month>();

		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);

		Month vmonth = monthMap.get(month);

		if (vmonth == null) {
			System.out.println("Invalid month");
		}

		return vmonth;

	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");

		// switch to frame

		driver.switchTo().frame(0);

		// method1- using sendkeys

		// driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("08/29/2025");

		// method2- date picker

		String date = "29";
		String expectedMonth = "July";
		String expectedYear = "2026";

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		while (true) {

			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			WebElement next = driver.findElement(By.xpath("//span[contains(@class,'ui-icon-circle-triangle-e')]"));
			WebElement prev = driver.findElement(By.xpath("//span[contains(@class,'ui-icon-circle-triangle-w')]"));

			if (currentYear.equals(expectedYear)) {
				Month cmonth = convertMonth(currentMonth);
				Month emonth = convertMonth(expectedMonth);
				int result = emonth.compareTo(cmonth);
				if (result == 0) {
					selectDate(driver, date);
					break;
				} else if (result > 0) {
					next.click();
				} else {
					prev.click();
				}
			} else if (Integer.parseInt(expectedYear) > Integer.parseInt(currentYear)) {
				next.click();
			} else {
				prev.click();
			}

		}
		driver.quit();

	}

}

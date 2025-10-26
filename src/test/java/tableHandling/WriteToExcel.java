package tableHandling;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteToExcel {
    public static void main(String[] args) throws IOException {
        
    	WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Pagination Web Table']"));
        js.executeScript("arguments[0].scrollIntoView();", element);

        List<WebElement> pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li/a"));
      
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Product Table");
        int excelRow = 1;

        for (WebElement currentPageCount : pageCount) {
            currentPageCount.click();
            	try 
            	{ 
            		Thread.sleep(1000); 
            	} catch (InterruptedException e) 
            	{
            		
            	}

            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
            for (WebElement rowElement : rows) {
                Row row = sheet.createRow(excelRow++);
                List<WebElement> cols = rowElement.findElements(By.tagName("td"));
                for (int c = 0; c < cols.size(); c++) {
                    row.createCell(c).setCellValue(cols.get(c).getText());
                }
            }
        }

        try (FileOutputStream fos = new FileOutputStream("PaginationData.xlsx")) {
            workbook.write(fos);
            workbook.close();
            System.out.println("📂 Excel file created successfully.");
        }

        driver.quit();

    }
}





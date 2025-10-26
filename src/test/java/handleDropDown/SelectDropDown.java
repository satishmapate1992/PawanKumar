package handleDropDown;

import java.lang.classfile.ClassFile.Option;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement selDropDown= driver.findElement(By.xpath("//select[@id='country']"));
		
		Select sel=new Select(selDropDown);
		//sel.selectByVisibleText("Japan");
		//sel.selectByValue("brazil");
		//sel.selectByIndex(5);
		sel.selectByContainsVisibleText("Ind");
		
		List<WebElement> option = sel.getOptions();
		int size= option.size();
		System.out.println("Total options: "+size);
		
		for( WebElement element:option) {
			System.out.println(element.getText());
		}
	
	
	}

}

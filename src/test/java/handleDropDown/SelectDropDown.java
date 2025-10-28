package handleDropDown;

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
		// Select the first option that contains the given substring ("Ind")
		String substringToMatch = "Ind";
		boolean selected = false;
		List<WebElement> options = sel.getOptions();
		for (WebElement opt : options) {
			String txt = opt.getText();
			if (txt != null && txt.contains(substringToMatch)) {
				sel.selectByVisibleText(txt);
				selected = true;
				break;
			}
		}
		if (!selected) {
			System.out.println("No option contains: " + substringToMatch);
		}
		
		List<WebElement> option = sel.getOptions();
		int size= option.size();
		System.out.println("Total options: "+size);
		
		for( WebElement element:option) {
			System.out.println(element.getText());
		}
	
	
	}

}
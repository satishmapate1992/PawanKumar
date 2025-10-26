package testNG;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParallelTesting {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void setup(String br, String url) {	
		
		switch(br.toLowerCase()) {
		
			case "chrome" : driver= new ChromeDriver();  break;
			case "firefox": driver= new FirefoxDriver(); break;
			case "edge"   : driver= new EdgeDriver();    break;
			default : System.out.println("Invalid driver"); return;
		}		
		driver.get(url);	
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	
	public void testLogo() {
		Wait<WebDriver> wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logo=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='company-branding']")));
		Assert.assertEquals(logo.isDisplayed(), true);		
		
	}
	
	@Test(priority=2)
	public void testURL() {		
		String expecetd="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String actualURL= driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expecetd);		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

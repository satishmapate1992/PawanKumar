package listener_ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

// @Listeners(listener_ExtentReport.Listen_me.class)
public class TestClass {

WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void setup(ITestContext context, String br, String url) {    
	    	
		switch(br.toLowerCase()) {
		
			case "chrome" : driver= new ChromeDriver();  break;
			case "firefox": driver= new FirefoxDriver(); break;
			case "edge"   : driver= new EdgeDriver();    break;
			default : System.out.println("Invalid driver"); return;
		}        		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);    
		driver.manage().window().maximize();
		
		// expose the driver to TestNG context so listeners (like ExtentReportManager) can retrieve it
		context.setAttribute("driver", driver);
		
	
	}
	
	@Test(priority=1)
	
	public void testLogo() throws Exception {
	//	Wait<WebDriver> wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	//	WebElement logo=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='company-branding']")));
		WebElement logo= driver.findElement(By.xpath("//img[@alt='geeksforgeeks']"));		
		Assert.assertEquals(logo.isDisplayed(), true);		
		
	}
	
	@Test(priority=2)
	public void testURL() {		
		String expecetd="https://www.geeksforgeeks.org/software-testing/automation-testing-software-";
		String actualURL= driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expecetd);		
	}
	
	@Test(priority=3, dependsOnMethods = {"testURL"})
	public void testSkip() {		
		String expecetd="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String actualURL= driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expecetd);		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
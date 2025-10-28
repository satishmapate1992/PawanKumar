package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {

	private WebDriver driver;
	private LoginPage loginPage;
	private final String loginUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(loginUrl);
		loginPage = new LoginPage(driver);
	}

	@Test(description = "Verify demo credentials box is visible on the login page")
	public void demoCredentialsVisibleTest() {
		Assert.assertTrue(loginPage.isDemoCredentialsVisible(), "Demo credentials should be visible on the login page");
	}

	@Test(description = "Perform a valid login using demo credentials and verify navigation to dashboard")
	public void validLoginTest() {
		// Use demo credentials from the page: Admin / admin123
		loginPage.login("Admin", "admin123");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait for URL to change to dashboard (site uses /dashboard or similar)
		boolean urlChanged = wait.until(ExpectedConditions.urlContains("/dashboard"));
		Assert.assertTrue(urlChanged, "Expected URL to contain '/dashboard' after successful login");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

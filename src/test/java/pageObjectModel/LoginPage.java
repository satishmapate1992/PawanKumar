package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for the OrangeHRM Login page (based on provided HTML). Provides
 * helpers to interact with username, password and login actions.
 */
public class LoginPage {

	private WebDriver driver;

	// @FindBy(name = "username")
	@FindBy(how = How.NAME, using = "username")
	private WebElement usernameInput;

	@FindBy(name = "password")
	private WebElement passwordInput;

	@FindBy(css = "button[type='submit']")
	private WebElement loginButton;

	@FindBy(css = ".orangehrm-login-logo-mobile img")
	private WebElement logoImage;

	@FindBy(css = ".orangehrm-demo-credentials")
	private WebElement demoCredentialsBox;

	@FindBy(css = ".orangehrm-login-forgot .orangehrm-login-forgot-header")
	private WebElement forgotPasswordHeader;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Setters / actions
	public void setUsername(String username) {
		usernameInput.clear();
		usernameInput.sendKeys(username);
	}

	public void setPassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		clickLogin();
	}

	// Helpers / getters
	public boolean isLoginButtonDisplayed() {
		return loginButton.isDisplayed();
	}

	public boolean isLoginButtonEnabled() {
		return loginButton.isEnabled();
	}

	public String getLoginButtonText() {
		try {
			return loginButton.getText().trim();
		} catch (Exception e) {
			return null;
		}
	}

	public boolean isDemoCredentialsVisible() {
		try {
			return demoCredentialsBox.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getDemoCredentialsText() {
		try {
			return demoCredentialsBox.getText().trim();
		} catch (Exception e) {
			return null;
		}
	}

	public boolean isLogoVisible() {
		try {
			return logoImage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getForgotPasswordHeaderText() {
		try {
			return forgotPasswordHeader.getText().trim();
		} catch (Exception e) {
			return null;
		}
	}

}

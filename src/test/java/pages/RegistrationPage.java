package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Page Object for the Register form shown in the provided HTML.
 * Provides helpers to interact with the registration form fields and actions.
 */
public class RegistrationPage {

    private WebDriver driver;

    // Inputs
    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(id = "userMobile")
    private WebElement phoneInput;

    @FindBy(css = "select[formcontrolname='occupation']")
    private WebElement occupationSelect;

    @FindBy(xpath = "//input[@type='radio' and @value='Male']")
    private WebElement maleRadio;

    @FindBy(xpath = "//input[@type='radio' and @value='Female']")
    private WebElement femaleRadio;

    @FindBy(id = "userPassword")
    private WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(css = "input[formcontrolname='required']")
    private WebElement termsCheckbox;

    @FindBy(id = "login")
    private WebElement registerButton;

    @FindBy(css = "p.login-wrapper-footer-text a")
    private WebElement loginHereLink;

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Setters / actions
    public void setFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void setEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void selectOccupationByVisibleText(String visibleText) {
        Select sel = new Select(occupationSelect);
        sel.selectByVisibleText(visibleText);
    }

    public void selectOccupationByValue(String value) {
        Select sel = new Select(occupationSelect);
        sel.selectByValue(value);
    }

    public String getSelectedOccupation() {
        Select sel = new Select(occupationSelect);
        return sel.getFirstSelectedOption().getText();
    }

    public void selectGender(String gender) {
        if (gender == null) return;
        if (gender.equalsIgnoreCase("male")) {
            if (!maleRadio.isSelected()) {
                maleRadio.click();
            }
        } else if (gender.equalsIgnoreCase("female")) {
            if (!femaleRadio.isSelected()) {
                femaleRadio.click();
            }
        }
    }

    public void setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(password);
    }

    public void setTermsChecked(boolean checked) {
        if (termsCheckbox.isSelected() != checked) {
            termsCheckbox.click();
        }
    }

    public void clickRegister() {
        registerButton.click();
    }

    public boolean isRegisterButtonDisplayed() {
        return registerButton.isDisplayed();
    }

    public boolean isRegisterButtonEnabled() {
        return registerButton.isEnabled();
    }

    public String getRegisterButtonText() {
        return registerButton.getAttribute("value");
    }

    public void clickLoginHere() {
        loginHereLink.click();
    }

    // Helper: convenience flow to fill and submit the form
    public void registerFull(String firstName, String lastName, String email, String phone,
                             String occupationVisibleText, String gender, String password, boolean acceptTerms) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        if (occupationVisibleText != null) selectOccupationByVisibleText(occupationVisibleText);
        selectGender(gender);
        setPassword(password);
        setConfirmPassword(password);
        setTermsChecked(acceptTerms);
        clickRegister();
    }

}

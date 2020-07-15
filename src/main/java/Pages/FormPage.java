package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FormPage {
    WebDriver driver;
    By fullName = By.id("formNameInput");
    By emailField = By.id("formEmailInput");
    By experienceField = By.cssSelector("input[type=number]");
    By description = By.id("formAboutYouTextArea");
    By termsCheckbox = By.id("formTermsAndConditionsCheckbox");
    By termsLink = By.className("Pointer");
    By termsPopup = By.className("modal-title");
    By roleDropdown = By.id("formRoleSelect");
    By submitBtn = By.id("formSubmitButton");
    By clearBtn = By.id("formClearButton");
    By logo = By.cssSelector("a#companyLogo>img");

    By nameError = By.cssSelector("input[id=formNameInput]~span[class=help-block]");
    By emailError = By.cssSelector("input[id=formEmailInput]~span[class=help-block]");
    By experienceError = By.cssSelector("input[type=number]~span[class=help-block]");
    By roleError = By.cssSelector("select[id=formRoleSelect]~span[class=help-block]");
    By termsError = By.cssSelector("a.Pointer+.form-group>.help-block");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getTermsPopup() {
        return termsPopup;
    }

    public void setName(String setName) {
        driver.findElement(fullName).sendKeys(setName);
    }

    public void setEmail(String setEmail) {
        driver.findElement(emailField).sendKeys(setEmail);
    }

    public void setExperienceField(String setExperience) {
        driver.findElement(experienceField).sendKeys(setExperience);
    }

    public void setRole(int setRole) {
        Select role = new Select(driver.findElement(roleDropdown));
        role.selectByIndex(setRole);
    }

    public void setDescription(String setDescription) {
        driver.findElement(description).sendKeys(setDescription);
    }

    public void clickOnTermsCheckbox() {
        driver.findElement(termsCheckbox).click();
    }

    public boolean getTermsCheckboxValue() {
        return driver.findElement(termsCheckbox).isSelected();
    }

    public void openTerms() {
        driver.findElement(termsLink).click();
    }

    public boolean isDisplayedTermsPopup() {
        return driver.findElement(termsPopup).isDisplayed();
    }

    public void clickSubmit() {
        driver.findElement(submitBtn).click();
    }

    public void clickClear() {
        driver.findElement(clearBtn).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public String getNameErrorText() {
        return driver.findElement(nameError).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(emailError).getText();
    }

    public String getExperienceErrorText() {
        return driver.findElement(experienceError).getText();
    }

    public String getRoleErrorText() {
        return driver.findElement(roleError).getText();
    }

    public String getTermsErrorText() {
        return driver.findElement(termsError).getText();
    }

    public String getNameValue() {
        return driver.findElement(fullName).getAttribute("value");
    }

    public String getEmailValue() {
        return driver.findElement(emailField).getAttribute("value");
    }

    public String getExperienceValue() {
        return driver.findElement(experienceField).getAttribute("value");
    }

    public String getRoleValue() {
        Select role = new Select(driver.findElement(roleDropdown));
        return role.getFirstSelectedOption().getText();
    }

    public String getAboutYouValue() {
        return driver.findElement(description).getText();
    }

    public void fillForm(String years) {
        fillFormWithoutTermsCheckbox(years);
        clickOnTermsCheckbox();
    }

    public void fillFormWithoutTermsCheckbox(String years) {
        setName("Mark");
        setEmail("my@email.com");
        setExperienceField(years);
        setRole(1);
        setDescription("This is my description");
    }
}

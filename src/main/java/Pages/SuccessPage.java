package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage {
    WebDriver driver;

    By logo = By.cssSelector("a#companyLogo>img");
    By titleOfPage = By.cssSelector("h1");

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public String getTitleOfPage(){
        return driver.findElement(titleOfPage).getText();
    }
}
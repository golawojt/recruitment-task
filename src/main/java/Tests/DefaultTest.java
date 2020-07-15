package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DefaultTest {
    public static WebDriver driver = null;

    @BeforeMethod
    public void BeforeMethod() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver.get("http://qa-recruitment-form.xxx.amazonaws.com/");
    }

    @AfterMethod
    public void AfterMethod(){
        DefaultTest.driver.quit();
    }
}

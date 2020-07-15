package Tests;

import Pages.FailPage;
import Pages.FormPage;
import Pages.SuccessPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompanyLogo extends DefaultTest {
    FormPage objForm;
    SuccessPage objSuccess;
    FailPage objFail;

    @Test
    public void isLogoWorkOnFormPage() {
        objForm = new FormPage(driver);
        objForm.clickLogo();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.companylink.com/");
    }

    @Test
    public void isLogoWorkOnSuccessPage() {
        objForm = new FormPage(driver);
        objForm.fillForm("2");
        objForm.clickSubmit();
        objSuccess = new SuccessPage(driver);
        objSuccess.clickLogo();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.companylink.com/");
    }

    @Test
    public void isLogoWorkOnFailPage() {
        objForm = new FormPage(driver);
        objForm.fillForm("1");
        objForm.clickSubmit();
        objFail = new FailPage(driver);
        objFail.clickLogo();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.companylink.com/");
    }
}

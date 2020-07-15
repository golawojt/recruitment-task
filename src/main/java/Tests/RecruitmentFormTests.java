package Tests;

import Pages.FailPage;
import Pages.FormPage;
import Pages.SuccessPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitmentFormTests extends DefaultTest {
    FormPage objForm;
    SuccessPage objSuccessPage;
    FailPage objFailPage;

    @Test
    public void applyForJobSuccessful() {
        objForm = new FormPage(driver);
        objForm.fillForm("2");
        objForm.clickSubmit();
        objSuccessPage = new SuccessPage(driver);
        Assert.assertEquals(objSuccessPage.getTitleOfPage(), "Success!");
    }

    @Test
    public void applyForJobFail() {
        objForm = new FormPage(driver);
        objForm.fillForm("1");
        objForm.clickSubmit();
        objFailPage = new FailPage(driver);
        Assert.assertEquals(objFailPage.getTitleOfPage(), "Failed!");
    }

    @Test
    public void checkIfTermsAreVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        objForm = new FormPage(driver);
        objForm.openTerms();

        wait.until(ExpectedConditions.textToBe(objForm.getTermsPopup(), "Terms and Conditions"));
        Assert.assertTrue(objForm.isDisplayedTermsPopup());
    }

    @Test
    public void checkClearButton() {
        objForm = new FormPage(driver);
        objForm.fillForm("5");
        objForm.clickClear();

        Assert.assertEquals(objForm.getNameValue(), "");
        Assert.assertEquals(objForm.getEmailValue(), "");
        Assert.assertEquals(objForm.getExperienceValue(), "");
        Assert.assertEquals(objForm.getRoleValue(), "Select Role");
        Assert.assertEquals(objForm.getAboutYouValue(), "");
        Assert.assertFalse(objForm.getTermsCheckboxValue());
    }
}

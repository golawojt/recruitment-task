package Tests;

import Pages.FormPage;
import Pages.SuccessPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationFieldsTests extends DefaultTest {
    FormPage objForm;
    SuccessPage objSuccess;

    @Test
    public void validationMessageNameIsTooShort() {
        objForm = new FormPage(driver);
        objForm.setName("M");
        Assert.assertEquals(objForm.getNameErrorText(), "The name is too short");
    }

    @Test
    public void validationMessageWrongEmail() {
        objForm = new FormPage(driver);
        objForm.setEmail("M");
        Assert.assertEquals(objForm.getEmailErrorText(), "The email is incorrect");
    }

    @Test
    public void validationMessageExperienceBelowZero() {
        objForm = new FormPage(driver);
        objForm.setExperienceField("-5");
        Assert.assertEquals(objForm.getExperienceErrorText(), "Your experience looks wired!");
    }

    @Test
    public void validationMessageExperienceWithLetter() {
        objForm = new FormPage(driver);
        objForm.setExperienceField("asd");
        Assert.assertEquals(objForm.getExperienceErrorText(), "");
    }

    @Test
    public void validationMessageNameIsRequired() {
        objForm = new FormPage(driver);
        objForm.fillForm("3");
        objForm.setName(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        objForm.clickSubmit();
        Assert.assertEquals(objForm.getNameErrorText(), "The name is too short");
    }

    @Test
    public void validationMessageEmailIsRequired() {
        objForm = new FormPage(driver);
        objForm.fillForm("3");
        objForm.setEmail(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        objForm.clickSubmit();
        Assert.assertEquals(objForm.getEmailErrorText(), "The email is incorrect");
    }

    @Test
    public void validationMessageExperienceIsRequired() {
        objForm = new FormPage(driver);
        objForm.fillForm("");
        objForm.clickSubmit();
        Assert.assertEquals(objForm.getExperienceErrorText(), "Your experience looks wired!");
    }

    @Test
    public void validationMessageRoleIsRequired() {
        objForm = new FormPage(driver);
        objForm.setName("Mark");
        objForm.setEmail("my@email.com");
        objForm.setExperienceField("2");
        objForm.clickOnTermsCheckbox();
        objForm.clickSubmit();
        Assert.assertEquals(objForm.getRoleErrorText(), "Please select your future role");
    }

    @Test
    public void validationMessageCheckboxIsRequired() {
        objForm = new FormPage(driver);
        objForm.fillFormWithoutTermsCheckbox("2");
        objForm.clickSubmit();
        Assert.assertEquals(objForm.getTermsErrorText(), "Please check to proceed");
    }

    @Test
    public void validationIfAboutYouIsNotRequired() {
        objForm = new FormPage(driver);
        objForm.fillForm("2");
        objForm.setDescription(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        objForm.clickSubmit();
        objSuccess = new SuccessPage(driver);
        Assert.assertEquals(objSuccess.getTitleOfPage(), "Success!");
    }
}

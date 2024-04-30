package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.registrationTest.ErrorData;
import org.akavity.models.registrationTest.RegUserData;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.ModalWrapperSteps;
import org.akavity.steps.PopUpsSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HeaderSteps headerSteps = new HeaderSteps();
    ModalWrapperSteps modal = new ModalWrapperSteps();

    @TestData(jsonFile = "errorData", model = "ErrorData", folder = "registrationTest")
    @Test(description = "Enter incorrect data when logging into your account",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void isErrorMessageDisplayed(ErrorData error) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modal.clickRegistrationButton();
        modal.enterDataIntoModalField(error.getName(), error.getEmail());
        modal.clickSubmitButton();

        Assert.assertTrue(headerSteps.isErrorFieldDisplayed(error.getError()));
    }

    @TestData(jsonFile = "regUserData", model = "RegUserData", folder = "registrationTest")
    @Test(description = "Login to registered user account",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void registeredUserLogin(RegUserData regUser) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modal.enterDataIntoModalField(regUser.getEmailName(), regUser.getEmail());
        modal.enterDataIntoModalField(regUser.getPasName(), regUser.getPassword());
        modal.clickSubmitButton();
        headerSteps.clickAccountButton();

        String actualAccountEmail = headerSteps.extractEmailFromAccount();
        Assert.assertEquals(actualAccountEmail, regUser.getEmail());
    }
}

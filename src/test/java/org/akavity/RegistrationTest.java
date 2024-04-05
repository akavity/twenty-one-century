package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.registrationTest.ErrorData;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.PopUpsSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HeaderSteps headerSteps = new HeaderSteps();

    @TestData(jsonFile = "errorData", model = "ErrorData", folder = "registrationTest")
    @Test(description = "", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void isErrorMessageDisplayed(ErrorData error) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        headerSteps.clickRegistrationButton();
        headerSteps.enterRegistrationEmail(error.getEmail());
        headerSteps.clickRegistrationSubmitButton();
        Assert.assertTrue(headerSteps.isErrorFieldDisplayed(error.getError()));
    }
}

package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.personalTest.PersonalData;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.ModalWrapperSteps;
import org.akavity.steps.PopUpsSteps;
import org.akavity.steps.ProfileContentSteps;
import org.akavity.utils.JsonReader;
import org.akavity.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalDataTest extends BaseTest {
    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HeaderSteps headerSteps = new HeaderSteps();
    ProfileContentSteps profileContentSteps = new ProfileContentSteps();
    ModalWrapperSteps modalWrapperSteps = new ModalWrapperSteps();
    Utils utils = new Utils();

    @TestData(jsonFile = "personalData", model = "PersonalData", folder = "personalTest")
    @Test(description = "Change personal data using a fake name, random date",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void changeNameGenderBirth(PersonalData data) {
        String fakeName = utils.getFakeFullName();
        String randomBirth = utils.getRandomBirthDate();

        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modalWrapperSteps.enterDataIntoModalField(data.getTitleEmail(), data.getEmail());
        modalWrapperSteps.enterDataIntoModalField(data.getTitlePassword(), data.getPassword());
        modalWrapperSteps.clickSubmitButton();
        headerSteps.clickAccountButton();
        headerSteps.clickProfileItem(data.getItemPersonalData());
        profileContentSteps.clickEditData(data.getDataType());
        modalWrapperSteps.enterDataIntoModalField(data.getTitleName(), fakeName); // use fake name
        modalWrapperSteps.clickGenderButton(data.getGender());
        modalWrapperSteps.enterDataIntoModalField(data.getTitleBirth(), randomBirth); // use random birth
        modalWrapperSteps.clickSubmitButton();

        String actualName = profileContentSteps.extractTextFromPersonalDataField(data.getTextName());
        String actualGender = profileContentSteps.extractTextFromPersonalDataField(data.getTextGender());
        String actualBirth = profileContentSteps.extractTextFromPersonalDataField(data.getTextBirth());
        Assert.assertEquals(actualName, fakeName);
        Assert.assertEquals(actualGender, data.getTextMale());
        Assert.assertEquals(actualBirth, randomBirth);
    }
}

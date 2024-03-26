package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.personalDataTest.NameGenderBirthData;
import org.akavity.steps.*;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalDataTest extends BaseTest {
    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HeaderSteps headerSteps = new HeaderSteps();
    ProfileContentSteps profileContentSteps = new ProfileContentSteps();
    ContentWrapperSteps contentWrapperSteps = new ContentWrapperSteps();
    ModalWrapperSteps modalWrapperSteps = new ModalWrapperSteps();

    @TestData(jsonFile = "nameGenderBirthData", model = "NameGenderBirthData", folder = "personalDataTest")
    @Test(description = "Check the sorting when searching for a special equipment",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void changePersonalData(NameGenderBirthData data) {
        popUpsSteps.clickCookiesAcceptButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modalWrapperSteps.enterDataIntoModalField(data.getModalAttributName1(), data.getEmail());
        modalWrapperSteps.enterDataIntoModalField(data.getModalAttributName2(), data.getPassword());
        modalWrapperSteps.clickSubmitButton();
        headerSteps.clickAccountButton();
        headerSteps.clickProfileItem(data.getProfileItem());
        profileContentSteps.clickEditData(data.getPersonalData());
        modalWrapperSteps.enterDataIntoModalField(data.getModalAttributName3(), data.getName());
        modalWrapperSteps.clickGenderButton(data.getGender());
        modalWrapperSteps.enterDataIntoModalField(data.getModalAttributName4(), data.getBirth());
        modalWrapperSteps.clickSubmitButton();
        String actualName = profileContentSteps.extractTextFromPersonalDataField(data.getActualName());
        String actualGender = profileContentSteps.extractTextFromPersonalDataField(data.getActualGender());
        String actualBirth = profileContentSteps.extractTextFromPersonalDataField(data.getActualBirth());
        Assert.assertEquals(actualName, data.getName());
        Assert.assertEquals(actualGender, data.getExpectedGender());
        Assert.assertEquals(actualBirth, data.getBirth());
    }
}

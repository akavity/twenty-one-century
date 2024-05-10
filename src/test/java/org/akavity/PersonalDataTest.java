package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.personalTest.*;
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
    @Test(description = "Change personal data using a fake name, random birth",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void changeNameGenderBirth(PersonalData data) {
        String fakeName = utils.getFakeFullName();
        String randomBirth = utils.getRandomBirthday();

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

    @TestData(jsonFile = "addressData", model = "AddressData", folder = "personalTest")
    @Test(description = "Add an address to personal data",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void addAddress(AddressData address) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modalWrapperSteps.enterDataIntoModalField(address.getTitleEmail(), address.getEmail());
        modalWrapperSteps.enterDataIntoModalField(address.getTitlePassword(), address.getPassword());
        modalWrapperSteps.clickSubmitButton();
        headerSteps.clickAccountButton();
        headerSteps.clickProfileItem(address.getItemPersonalData());
        profileContentSteps.clickAddButton(address.getAddButtonTitle());
        modalWrapperSteps.enterStreet(address.getStreet());
        modalWrapperSteps.enterDataIntoModalField(address.getTitleEntrance(), address.getNumberOfEntrance());
        modalWrapperSteps.enterDataIntoModalField(address.getTitleFloor(), address.getNumberOfFloor());
        modalWrapperSteps.enterDataIntoModalField(address.getTitleFlat(), address.getNumberOfFlat());
        modalWrapperSteps.clickSubmitButton();

        Assert.assertTrue(profileContentSteps.isAddressDisplayed(address.getStreet()));
    }

    @TestData(jsonFile = "newAddressData", model = "NewAddressData", folder = "personalTest")
    @Test(dependsOnMethods = "addAddress", description = "Change the address in personal data",  // dependsOnMethods = "addAddress", alwaysRun = true нежесткая зависимость
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void editAddress(NewAddressData address) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modalWrapperSteps.enterDataIntoModalField(address.getTitleEmail(), address.getEmail());
        modalWrapperSteps.enterDataIntoModalField(address.getTitlePassword(), address.getPassword());
        modalWrapperSteps.clickSubmitButton();
        headerSteps.clickAccountButton();
        headerSteps.clickProfileItem(address.getItemPersonalData());
        profileContentSteps.editAddress(address.getOldStreet());
        modalWrapperSteps.enterStreet(address.getNewStreet());
        modalWrapperSteps.enterDataIntoModalField(address.getTitleEntrance(), address.getNumberOfEntrance());
        modalWrapperSteps.enterDataIntoModalField(address.getTitleFloor(), address.getNumberOfFloor());
        modalWrapperSteps.enterDataIntoModalField(address.getTitleFlat(), address.getNumberOfFlat());
        modalWrapperSteps.clickSubmitButton();

        Assert.assertTrue(profileContentSteps.isAddressDisplayed(address.getNewStreet()));
    }

    @TestData(jsonFile = "newAddressData", model = "NewAddressData", folder = "personalTest")
    @Test(dependsOnMethods = "editAddress", description = "Delete the address in personal data",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void deleteAddress(NewAddressData address) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modalWrapperSteps.enterDataIntoModalField(address.getTitleEmail(), address.getEmail());
        modalWrapperSteps.enterDataIntoModalField(address.getTitlePassword(), address.getPassword());
        modalWrapperSteps.clickSubmitButton();
        headerSteps.clickAccountButton();
        headerSteps.clickProfileItem(address.getItemPersonalData());
        profileContentSteps.deleteAddress(address.getNewStreet());
        modalWrapperSteps.clickPinkDeleteButton();

        Assert.assertFalse(profileContentSteps.isAddressDisplayed(address.getNewStreet()));
        Assert.assertFalse(profileContentSteps.isAddressDisplayed(address.getOldStreet()));
    }

    @TestData(jsonFile = "phoneNumberData", model = "PhoneNumberData", folder = "personalTest")
    @Test(description = "Add a phone number to personal data",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void addPhoneNumber(PhoneNumberData phone) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modalWrapperSteps.enterDataIntoModalField(phone.getTitleEmail(), phone.getEmail());
        modalWrapperSteps.enterDataIntoModalField(phone.getTitlePassword(), phone.getPassword());
        modalWrapperSteps.clickSubmitButton();
        headerSteps.clickAccountButton();
        headerSteps.clickProfileItem(phone.getItemPersonalData());
        profileContentSteps.clickAddButton(phone.getAddButtonTitle());
        modalWrapperSteps.enterDataIntoModalField(phone.getTitlePhone(), phone.getPhoneNumber());
        modalWrapperSteps.clickSubmitButton();

        Assert.assertTrue(profileContentSteps.isPhoneNumberDisplayed(phone.getPhoneNumberText()));
    }

    @TestData(jsonFile = "newPhoneNumberData", model = "NewPhoneNumberData", folder = "personalTest")
    @Test(dependsOnMethods = "addPhoneNumber", description = "Change the phone number in personal data",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void editPhoneNumber(NewPhoneNumberData phone) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modalWrapperSteps.enterDataIntoModalField(phone.getTitleEmail(), phone.getEmail());
        modalWrapperSteps.enterDataIntoModalField(phone.getTitlePassword(), phone.getPassword());
        modalWrapperSteps.clickSubmitButton();
        headerSteps.clickAccountButton();
        headerSteps.clickProfileItem(phone.getItemPersonalData());
        profileContentSteps.editPhoneNumber(phone.getOldPhoneNumber());
        modalWrapperSteps.enterDataIntoModalField(phone.getTitlePhone(), phone.getNewPhoneNumber());
        modalWrapperSteps.clickSubmitButton();

        Assert.assertTrue(profileContentSteps.isPhoneNumberDisplayed(phone.getNewPhoneNumber()));
    }

    @TestData(jsonFile = "newPhoneNumberData", model = "NewPhoneNumberData", folder = "personalTest")
    @Test(dependsOnMethods = "editPhoneNumber", description = "Delete the phone number in personal data",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void deletePhoneNumber(NewPhoneNumberData phone) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modalWrapperSteps.enterDataIntoModalField(phone.getTitleEmail(), phone.getEmail());
        modalWrapperSteps.enterDataIntoModalField(phone.getTitlePassword(), phone.getPassword());
        modalWrapperSteps.clickSubmitButton();
        headerSteps.clickAccountButton();
        headerSteps.clickProfileItem(phone.getItemPersonalData());
        profileContentSteps.deletePhoneNumber(phone.getNewPhoneNumber());
        modalWrapperSteps.clickPinkDeleteButton();

        Assert.assertFalse(profileContentSteps.isPhoneNumberDisplayed(phone.getNewPhoneNumber()));
    }

    @TestData(jsonFile = "requisitesData", model = "RequisitesData", folder = "personalTest")
    @Test(description = "Add requisites to personal data",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void addRequisites(RequisitesData requisites) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modalWrapperSteps.enterDataIntoModalField(requisites.getTitleEmail(), requisites.getEmail());
        modalWrapperSteps.enterDataIntoModalField(requisites.getTitlePassword(), requisites.getPassword());
        modalWrapperSteps.clickSubmitButton();
        headerSteps.clickAccountButton();
        headerSteps.clickProfileItem(requisites.getPersonalDataItem());
        profileContentSteps.clickAddButton(requisites.getAddButtonTitle());
        modalWrapperSteps.enterDataIntoModalField(requisites.getNameUnp(), requisites.getDataUnp());
        modalWrapperSteps.enterDataIntoModalField(requisites.getNameAcc(), requisites.getDataAcc());
        modalWrapperSteps.enterDataIntoModalField(requisites.getNameLegalName(), requisites.getDataLegalName());
        modalWrapperSteps.enterDataIntoModalField(requisites.getNameBank(), requisites.getDataBank());
        modalWrapperSteps.enterDataIntoModalField(requisites.getNameLegalAddress(), requisites.getDataLegalAddress());
        modalWrapperSteps.enterDataIntoModalField(requisites.getNameRcbic(), requisites.getDataRcbic());
        modalWrapperSteps.clickSubmitButton();

        Assert.assertEquals(profileContentSteps.extractTextFromRequisitesField(requisites.getTitleUnp()), requisites.getDataUnp());
        Assert.assertEquals(profileContentSteps.extractTextFromRequisitesField(requisites.getTitleAcc()), requisites.getDataAcc());
        Assert.assertEquals(profileContentSteps.extractTextFromRequisitesField(requisites.getTitleLegalName()), requisites.getDataLegalName());
        Assert.assertEquals(profileContentSteps.extractTextFromRequisitesField(requisites.getTitleBank()), requisites.getDataBank());
        Assert.assertEquals(profileContentSteps.extractTextFromRequisitesField(requisites.getTitleLegalAddress()), requisites.getDataLegalAddress());
        Assert.assertEquals(profileContentSteps.extractTextFromRequisitesField(requisites.getTitleRcbic()), requisites.getDataRcbic());
    }

    @TestData(jsonFile = "requisitesData", model = "RequisitesData", folder = "personalTest")
    @Test(dependsOnMethods = "addRequisites", description = "Change the requisites in personal data",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void editRequisites(RequisitesData requisites) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modalWrapperSteps.enterDataIntoModalField(requisites.getTitleEmail(), requisites.getEmail());
        modalWrapperSteps.enterDataIntoModalField(requisites.getTitlePassword(), requisites.getPassword());
        modalWrapperSteps.clickSubmitButton();
        headerSteps.clickAccountButton();
        headerSteps.clickProfileItem(requisites.getPersonalDataItem());
        profileContentSteps.editRequisites();
        modalWrapperSteps.enterDataIntoModalField(requisites.getNameUnp(), requisites.getDataUnpNew());
        modalWrapperSteps.enterDataIntoModalField(requisites.getNameAcc(), requisites.getDataAccNew());
        modalWrapperSteps.enterDataIntoModalField(requisites.getNameLegalName(), requisites.getDataLegalNameNew());
        modalWrapperSteps.enterDataIntoModalField(requisites.getNameBank(), requisites.getDataBankNew());
        modalWrapperSteps.enterDataIntoModalField(requisites.getNameLegalAddress(), requisites.getDataLegalAddressNew());
        modalWrapperSteps.enterDataIntoModalField(requisites.getNameRcbic(), requisites.getDataRcbicNew());
        modalWrapperSteps.clickSubmitButton();

        Assert.assertEquals(profileContentSteps.extractTextFromRequisitesField(requisites.getTitleUnp()), requisites.getDataUnpNew());
        Assert.assertEquals(profileContentSteps.extractTextFromRequisitesField(requisites.getTitleAcc()), requisites.getDataAccNew());
        Assert.assertEquals(profileContentSteps.extractTextFromRequisitesField(requisites.getTitleLegalName()), requisites.getDataLegalNameNew());
        Assert.assertEquals(profileContentSteps.extractTextFromRequisitesField(requisites.getTitleBank()), requisites.getDataBankNew());
        Assert.assertEquals(profileContentSteps.extractTextFromRequisitesField(requisites.getTitleLegalAddress()), requisites.getDataLegalAddressNew());
        Assert.assertEquals(profileContentSteps.extractTextFromRequisitesField(requisites.getTitleRcbic()), requisites.getDataRcbicNew());
    }

    @TestData(jsonFile = "requisitesData", model = "RequisitesData", folder = "personalTest")
    @Test(dependsOnMethods = "editRequisites", description = "Delete the requisites in personal data",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void deleteRequisites(RequisitesData requisites) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickAccountButton();
        headerSteps.clickLoginButton();
        modalWrapperSteps.enterDataIntoModalField(requisites.getTitleEmail(), requisites.getEmail());
        modalWrapperSteps.enterDataIntoModalField(requisites.getTitlePassword(), requisites.getPassword());
        modalWrapperSteps.clickSubmitButton();
        headerSteps.clickAccountButton();
        headerSteps.clickProfileItem(requisites.getPersonalDataItem());
        profileContentSteps.deleteRequisites();
        modalWrapperSteps.clickPinkDeleteButton();

        Assert.assertFalse(profileContentSteps.isRequisitesBockDisplayed());
    }
}

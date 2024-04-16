package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ProfileContentPage;
import org.akavity.utils.Utils;

@Log4j2
public class ProfileContentSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    ProfileContentPage profileContentPage = new ProfileContentPage();
    Utils utils = new Utils();

    @Step
    public void clickEditPersonalDataButton(String id) {
        profileContentPage.getAddButton(id).click();
    }

    @Step
    public void clickAddButton(String title) {
        log.info("Click add button");
        profileContentPage.getAddButton(title).click();
    }

    @Step
    public void clickEditAddressButton(String street) {
        log.info("Edit address button");
        SelenideElement element = profileContentPage.getEditAddressButton(street);
        element.scrollIntoView(PARAMETER);
        element.click();
    }

    @Step
    public void clickEditPhoneNumberButton(String phoneNumber) {
        log.info("Edit address button");
        SelenideElement element = profileContentPage.getEditPhoneNumberButton(phoneNumber);
        element.scrollIntoView(PARAMETER);
        element.click();
    }

    @Step
    public boolean isAddressDisplayed(String address) {
        utils.sleep();
        return profileContentPage.getAddressField(address).isDisplayed();
    }

    @Step
    public boolean isPhoneNumberDisplayed(String telephoneNumber) {
        utils.sleep();
        return profileContentPage.getPhoneNumberField(telephoneNumber).isDisplayed();
    }

    @Step
    public String extractTextFromPersonalDataField(String data) {
        utils.sleep();
        String text = profileContentPage.getPersonalDataField(data).getText();
        log.info("Personal data field contains text: " + text);
        return text;
    }

    @Step
    public void clickEditData(String id) {
        log.info("Click edit data");
        profileContentPage.getEditPersonalDataButton(id).click();
    }

    @Step
    public void deleteAddress(String address) {
        log.info("Delete address: " + address);
        profileContentPage.getDeleteAddressButton(address).click();
    }

    @Step
    public void deletePhoneNumber(String phoneNumber) {
        log.info("Delete phone number: " + phoneNumber);
        profileContentPage.getDeletePhoneNumberButton(phoneNumber).click();
    }
}

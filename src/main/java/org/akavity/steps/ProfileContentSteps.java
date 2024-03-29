package org.akavity.steps;

import io.qameta.allure.Step;
import org.akavity.pages.ProfileContentPage;
import org.akavity.utils.Utils;

public class ProfileContentSteps {
    Utils utils = new Utils();
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    ProfileContentPage profileContentPage = new ProfileContentPage();

    @Step
    public void clickEditPersonalDataButton(String id) {
        profileContentPage.getAddButton(id).click();
    }

    @Step
    public void clickAddButton(String title) {
        profileContentPage.getAddButton(title).click();
    }

    @Step
    public void clickEditAddressButton(String street) {
        profileContentPage.getAddressField(street).scrollIntoView(PARAMETER);
        profileContentPage.getEditAddressButton(street).click();
    }

    @Step
    public String extractTextFromPersonalDataField(String data) {
        utils.sleep();
        return profileContentPage.getPersonalDataField(data).getText();
    }

    @Step
    public void clickEditData(String id) {
        profileContentPage.getEditPersonalDataButton(id).click();
    }

    @Step
    public boolean isNumberDisplayed(String number) {
        return true;
    }
}

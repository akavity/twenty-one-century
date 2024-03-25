package org.akavity.steps;

import io.qameta.allure.Step;
import org.akavity.pages.ProfileContentPage;

public class ProfileContentSteps {
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
    public void clickEditData(String id) {
        profileContentPage.getEditPersonalDataButton(id).click();
    }
}

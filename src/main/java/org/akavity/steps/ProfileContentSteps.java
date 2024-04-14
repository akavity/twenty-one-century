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
        SelenideElement element = profileContentPage.getAddressField(street);
        element.scrollIntoView(PARAMETER);
        element.click();
    }

    @Step
    public String extractTextFromPersonalDataField(String data) {
        utils.sleep(1000);
        String text = profileContentPage.getPersonalDataField(data).getText();
        log.info("Personal data field contains text: " + text);
        return text;
    }

    @Step
    public void clickEditData(String id) {
        log.info("Click edit data");
        profileContentPage.getEditPersonalDataButton(id).click();
    }
}

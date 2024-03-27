package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.akavity.pages.ModalWrapperPage;
import org.openqa.selenium.Keys;

public class ModalWrapperSteps {
    ModalWrapperPage modalWrapperPage = new ModalWrapperPage();

    @Step
    public void enterDataIntoModalField(String title, String data) {
        SelenideElement element = modalWrapperPage.getModalField(title);
        element.sendKeys(Keys.CONTROL + "A");         // clear input field
        element.sendKeys(Keys.BACK_SPACE);                       //
        modalWrapperPage.getModalField(title).sendKeys(data);
    }

    @Step
    public void clickSubmitButton() {
        modalWrapperPage.getSubmitButton().click();
    }

    @Step
    public void clickGenderButton(String gender) {
        modalWrapperPage.getGenderButton(gender).click();
    }
}

package org.akavity.steps;

import io.qameta.allure.Step;
import org.akavity.pages.ModalWrapperPage;

public class ModalWrapperSteps {
    ModalWrapperPage modalWrapperPage = new ModalWrapperPage();

    @Step
    public void enterDataIntoModalField(String name, String data) {
        modalWrapperPage.getModalField(name).click();
        modalWrapperPage.getModalField(name).sendKeys(data);
    }

    @Step
    public void clickSubmitButton() {
        modalWrapperPage.getSubmitButton().click();
    }
}

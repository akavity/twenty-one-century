package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ModalWrapperPage;
import org.openqa.selenium.Keys;

@Log4j2
public class ModalWrapperSteps {
    ModalWrapperPage modalWrapperPage = new ModalWrapperPage();

    @Step
    public void enterDataIntoModalField(String title, String data) {
        log.info("Enter data into modal field: " + data);
        SelenideElement element = modalWrapperPage.getModalField(title);
        element.sendKeys(Keys.CONTROL + "A");         // clear input field
        element.sendKeys(Keys.BACK_SPACE);                       //
        modalWrapperPage.getModalField(title).sendKeys(data);
    }

    @Step
    public void clickSubmitButton() {
        log.info("Click submit button");
        modalWrapperPage.getSubmitButton().click();
    }

    @Step
    public void clickGenderButton(String gender) {
        log.info("Select gender: " + gender);
        modalWrapperPage.getGenderButton(gender).click();
    }
}

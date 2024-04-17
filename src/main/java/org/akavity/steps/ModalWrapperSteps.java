package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ModalWrapperPage;
import org.akavity.utils.Utils;
import org.openqa.selenium.Keys;

@Log4j2
public class ModalWrapperSteps {
    ModalWrapperPage modalWrapperPage = new ModalWrapperPage();
    Utils utils = new Utils();

    @Step
    public void enterDataIntoModalField(String name, String data) {  // cleanFieldAndEnterData
        log.info("Enter data into modal field: " + data);
        SelenideElement element = modalWrapperPage.getModalField(name);
        element.sendKeys(Keys.CONTROL + "A");         // clear input field
        element.sendKeys(Keys.BACK_SPACE);                       //
        modalWrapperPage.getModalField(name).sendKeys(data);
    }

    @Step
    public void enterCity(String city) {
        SelenideElement element = modalWrapperPage.getModalField("city");
        element.sendKeys(Keys.CONTROL + "A");         // clear input field
        element.sendKeys(Keys.BACK_SPACE);                       //
        element.sendKeys(city);
        element.click();
        modalWrapperPage.getListItem(city).click();
    }

    @Step
    public void enterStreet(String street) {
        SelenideElement element = modalWrapperPage.getAddressField();
        element.sendKeys(Keys.CONTROL + "A");         // clear input field
        element.sendKeys(Keys.BACK_SPACE);                       //
        element.setValue(street);
        element.click();
        utils.sleep(2000);
        element.pressEnter();
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

    @Step
    public void clickPinkDeleteButton() {
        log.info("Click the \"Delete\" button");
        modalWrapperPage.getPinkDeleteButton().click();
    }
}

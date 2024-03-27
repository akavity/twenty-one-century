package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ModalWrapperPage {
    private final SelenideElement submitButton = $(By.xpath("//div[not(contains(@class,'Subscription'))]" +
            "/button[@type='submit']"));

    /**
     * @param gender male, female
     */
    public SelenideElement getGenderButton(String gender) {
        return $(By.xpath("//input[@name='gender' and @value='" + gender + "']/parent::label"));
    }

    /**
     * @param title email, password, name, birth, oldPassword, newPassword
     */
    public SelenideElement getModalField(String title) {
        return $(By.xpath("//div[not(contains(@class,'Subscription'))]/input[@name='" + title + "']"));
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }
}

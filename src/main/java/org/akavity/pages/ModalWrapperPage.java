package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ModalWrapperPage {
    private final SelenideElement modalWindow = $(By.cssSelector("div[class*='modalWrapper']"));
    private final SelenideElement submitButton = $(By.xpath("//div[not(contains(@class,'Subscription'))]" +
            "/button[@type='submit']"));
    private final SelenideElement addressField = $(By.cssSelector("div[data-testid='address'] input[class]"));
    private final SelenideElement pinkDeleteButton = $(By.cssSelector("button[class*=pink-primary]"));

    public SelenideElement getListItem(String text) {
        return $(By.xpath("//li/div[contains(text(),'" + text + "')]"));
    }

    /**
     * @param gender male, female
     */
    public SelenideElement getGenderButton(String gender) {
        return $(By.xpath("//input[@name='gender' and @value='" + gender + "']/parent::label"));
    }

    /**
     * @param name email, password, name, birth, oldPassword, newPassword,
     *             phone
     *             city, entrance, floor, flat
     *             unp, acc, legalName, bank, legalAddress, rcbic
     */
    public SelenideElement getModalField(String name) {
        return $(By.xpath("//div[not(contains(@class,'Subscription'))]/input[@name='" + name + "']"));
    }

    public SelenideElement getModalWindow() {
        return modalWindow;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    public SelenideElement getAddressField() {
        return addressField;
    }

    public SelenideElement getPinkDeleteButton() {
        return pinkDeleteButton;
    }
}

package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ModalWrapperPage {
    private final SelenideElement modalWindow = $(By.cssSelector("div[data-testid='modal']"));
    private final SelenideElement submitButton = $(By.xpath("//button[@type='submit']/div[contains(@class,'Button')]"));
    private final SelenideElement submitEmailButton = $(By.cssSelector("div[class*='EmailLogin'] button[type='submit']"));
    private final SelenideElement submitPhoneButton = $(By.cssSelector("div[class*='PhoneLogin'] button[type='submit']"));
    private final SelenideElement addressField = $(By.cssSelector("div[data-testid='address'] input[class]"));
    private final SelenideElement pinkDeleteButton = $(By.cssSelector("button[class*=pink-primary]"));
    private final SelenideElement registrationButton = $(By.xpath("//div[contains(@class,'Email')]//button[contains(text(),'Регистрация')]"));
    private final SelenideElement forgottenPasswordButton = $(By.xpath("//button[contains(@class,'reset')]"));

    public SelenideElement getListItem(String text) {
        return $(By.xpath("//li/div[contains(text(),'" + text + "')]"));
    }

    /**
     * @param gender Мужской, Женский
     */
    public SelenideElement getGenderButton(String gender) {
        return $(By.xpath("//label[@role='presentation']//span[contains(text(),'" + gender + "')]"));
    }

    /**
     * @param name email, password, name, birth, oldPassword, newPassword,
     *             phone
     *             city, entrance, floor, flat
     *             unp, acc, legalName, bank, legalAddress, rcbic
     */
    public SelenideElement getModalField(String name) {
        if (name.equals("bank")) {
            return $(By.xpath("//div[not(contains(@class,'Subscription'))]/input[@name='bank']/..//input[@class]"));
        } else {
            return $(By.xpath("//div[@data-testid='modal']//div[not(contains(@class,'Subscription'))]/input[@name='" + name + "']"));
        }
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

    public SelenideElement getSubmitEmailButton() {
        return submitEmailButton;
    }

    public SelenideElement getSubmitPhoneButton() {
        return submitPhoneButton;
    }

    public SelenideElement getRegistrationButton() {
        return registrationButton;
    }

    public SelenideElement getForgottenPasswordButton() {
        return forgottenPasswordButton;
    }
}

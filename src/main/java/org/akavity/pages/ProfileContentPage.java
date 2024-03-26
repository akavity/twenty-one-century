package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfileContentPage {
    /**
     * @param data Имя, Пол, Год рождения, Почта
     */
    public SelenideElement getPersonalDataField(String data) {
        return $(By.xpath("//p[contains(text(),'" + data + "')]/../p[contains(@class,'data')]"));
    }

    /**
     * @param id editData, changeEmail, changePassword
     */
    public SelenideElement getEditPersonalDataButton(String id) {
        return $(By.cssSelector("div[data-testid='" + id + "']"));
    }

    /**
     * @param title Телефоны, Адреса, Юридические реквизиты
     */
    public SelenideElement getAddButton(String title) {
        return $(By.xpath("//h2[contains(text(),'" + title + "')]/ancestor::div[contains(@class,'Block_')]" +
                "//div[contains(@class,'action')]"));
    }

    public SelenideElement getEditPrimaryButton(String title) {
        return $(By.xpath("//h2[contains(text(),'" + title + "')]/ancestor::div[contains(@class,'BlockW')]" +
                "/div[contains(@class,'primary')]//div[contains(@class,'edit')]"));
    }

    public SelenideElement getAddressField(String street) {
        return $(By.xpath("//p[contains(@data-testid,'addres') and contains(text(),'" + street + "')]"));
    }

    public SelenideElement getPhoneNumberField(String phoneNumber) {
        return $(By.xpath("//div[contains(@class,'phone')]//p[contains(text(),'" + phoneNumber + "')]"));
    }

    public SelenideElement getEditPhoneNumberButton(String phoneNumber) {
        return $(By.xpath("//p[contains(text(),'" + phoneNumber + "')]" +
                "/ancestor::div[contains(@class,'phone')]//div[contains(@class,'edit')]"));
    }

    public SelenideElement getDeletePhoneNumberButton(String phoneNumber) {
        return $(By.xpath("//p[contains(text(),'" + phoneNumber + "')]" +
                "/ancestor::div[contains(@class,'phone')]//div[contains(@class,'delete')]"));
    }

    public SelenideElement getEditAddressButton(String street) {
        return $(By.xpath("//p[contains(@data-testid,'addres') and contains(text(),'" + street + "')]" +
                "/ancestor::div[contains(@class,'dataWrapper')]//div[contains(@class,'edit')]"));
    }

    public SelenideElement getDeleteAddressButton(String street) {
        return $(By.xpath("//p[contains(@data-testid,'addres') and contains(text(),'" + street + "')]" +
                "/ancestor::div[contains(@class,'dataWrapper')]//div[contains(@class,'delete')]"));
    }
}

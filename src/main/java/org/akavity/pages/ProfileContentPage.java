package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfileContentPage {
    /**
     * @param text Имя, Пол, Год рождения, Почта
     */
    public SelenideElement getPersonalDataField(String text) {
        return $(By.xpath("//p[contains(text(),'" + text + "')]/../p[contains(@class,'data')]"));
    }

    /**
     * @param type Data, Email, Password
     */
    public SelenideElement getEditPersonalDataButton(String type) {
        String id = "";
        switch (type) {
            case "Email", "Password" -> id = "change" + type;
            case "Data" -> id = "edit" + type;
        }

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

    public SelenideElement getEditAddressButton(String street) {
        return $(By.xpath("//p[contains(@data-testid,'addres') and contains(text(),'" + street + "')]" +
                "/ancestor::div[contains(@class,'dataWrapper')]//div[contains(@class,'edit')]"));
    }

    public SelenideElement getDeleteAddressButton(String street) {
        return $(By.xpath("//p[contains(@data-testid,'addres') and contains(text(),'" + street + "')]" +
                "/ancestor::div[contains(@class,'dataWrapper')]//div[contains(@class,'delete')]"));
    }

    public SelenideElement getPhoneNumberField(String phoneNumber) {
        return $(By.xpath("//div[contains(@class,'PhoneItem')]//span[contains(text(),'" + phoneNumber + "')]"));
    }

    public SelenideElement getEditPhoneNumberButton(String phoneNumber) {
        return $(By.xpath("//span[contains(text(),'" + phoneNumber + "')]" +
                "/ancestor::div[contains(@class,'PhoneItem')]//div[contains(@class,'edit')]"));
    }

    public SelenideElement getDeletePhoneNumberButton(String phoneNumber) {
        return $(By.xpath("//span[contains(text(),'" + phoneNumber + "')]" +
                "/ancestor::div[contains(@class,'PhoneItem')]//div[contains(@class,'delete')]"));
    }

    public SelenideElement getRequisitesField(String title) {
        return $(By.xpath("//h6[contains(text(),'" + title + "')]/../p"));
    }

    private final SelenideElement requisitesBlock = $(By.xpath("//div[contains(@class,'dataEntities')]"));

    private final SelenideElement editRequisitesButton = $(By.xpath("//div[contains(text(),'Реквизиты')]" +
            "/../../following-sibling::div//div[contains(@class,'edit')]"));

    private final SelenideElement deleteRequisitesButton = $(By.xpath("//div[contains(text(),'Реквизиты')]" +
            "/../../following-sibling::div//div[contains(@class,'delete')]"));

    public SelenideElement getEditRequisitesButton() {
        return editRequisitesButton;
    }

    public SelenideElement getDeleteRequisitesButton() {
        return deleteRequisitesButton;
    }

    public SelenideElement getRequisitesBlock() {
        return requisitesBlock;
    }
}

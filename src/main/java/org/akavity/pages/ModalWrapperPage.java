package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ModalWrapperPage {
    private final SelenideElement submitButton = $(By.xpath("//div[not(contains(@class,'Subscription'))]" +
            "/button[@type='submit']"));

    /**
     * @param name email, password, name, birth, oldPassword, newPassword
     */
    public SelenideElement getModalField(String name) {
        return $(By.xpath("//div[not(contains(@class,'Subscription'))]/input[@name='" + name + "']"));
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }
}

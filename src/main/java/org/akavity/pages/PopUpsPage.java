package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PopUpsPage {
    private final SelenideElement cookiesRefuseButton = $(By.cssSelector("button[class*='gray-secondary']"));

    private final SelenideElement cookiesAcceptButton = $(By.cssSelector("div[class*='Cookie'] button[class*='blue-primary']"));

    public SelenideElement getCookiesRefuseButton() {
        return cookiesRefuseButton;
    }

    public SelenideElement getCookiesAcceptButton() {
        return cookiesAcceptButton;
    }
}

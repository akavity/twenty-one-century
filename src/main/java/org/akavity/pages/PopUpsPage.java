package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PopUpsPage {
    private final SelenideElement cookiesRefuseButton = $(By.cssSelector("button[class*='gray-secondary']"));
    private final SelenideElement cookiesSecondRefuseButton = $(By.cssSelector("div[class*='Cookies'] button[class*='gray-secondary']"));
    private final SelenideElement cookiesAcceptButton = $(By.cssSelector("div[class*='Cookie'] button[class*='blue-primary']"));

    private final SelenideElement popmechanicDesktop = $(By.cssSelector("div[class*='popmechanic-main']"));
    private final SelenideElement popmechanicCloseButton = $(By.cssSelector("div[class='popmechanic-close']"));

    public SelenideElement getCookiesRefuseButton() {
        return cookiesRefuseButton;
    }

    public SelenideElement getCookiesSecondRefuseButton() {
        return cookiesSecondRefuseButton;
    }

    public SelenideElement getCookiesAcceptButton() {
        return cookiesAcceptButton;
    }

    public SelenideElement getPopmechanicDesktop() {
        return popmechanicDesktop;
    }

    public SelenideElement getPopmechanicCloseButton() {
        return popmechanicCloseButton;
    }
}

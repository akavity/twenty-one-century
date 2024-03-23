package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private final SelenideElement accountButton = $(By.cssSelector("button[class*='userToolsToggler']"));

    private final SelenideElement loginButton = $(By.cssSelector("button[data-testid='loginButton']"));

    private final SelenideElement headerCartButton = $(By.cssSelector("div[class='headerCart']"));

    public SelenideElement getPromoItem(String title) {
        return $(By.xpath("//div[contains(@class,'promo')]//a[contains(text(),'" + title + "')]"));
    }

    // UserTools

    private final SelenideElement emailField = $(By.cssSelector("input[id='login-email']"));
    private final SelenideElement passwordField = $(By.cssSelector("input[id='login-password']"));
    private final SelenideElement submitButton = $(By.cssSelector("div[data-testid='loginForm'] button[type='submit']"));
    private final SelenideElement subTitleField = $(By.cssSelector("span[class='userToolsSubtitle']"));
    private final SelenideElement logoutButton = $(By.cssSelector("a[href='/logout/'] div"));

    public SelenideElement getProfileItem(String text) {
        return $(By.xpath("//div[contains(@class,'itemText') and contains(text(), '" + text + "')]"));
    }

    public SelenideElement getAccountButton() {
        return accountButton;
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }

    public SelenideElement getHeaderCartButton() {
        return headerCartButton;
    }

    public SelenideElement getEmailField() {
        return emailField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    public SelenideElement getSubTitleField() {
        return subTitleField;
    }

    public SelenideElement getLogoutButton() {
        return logoutButton;
    }
}

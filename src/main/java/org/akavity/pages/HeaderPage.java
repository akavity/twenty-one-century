package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private final SelenideElement logoButton = $(By.cssSelector("a[class='logotypeImg']"));
    private final SelenideElement accountButton = $(By.cssSelector("button[class*='userToolsToggler']"));
    private final SelenideElement headerCartButton = $(By.cssSelector("div[class='headerCart']"));
    private final SelenideElement catalogSearchFiled = $(By.cssSelector("#catalogSearch"));

    public SelenideElement getPromoItem(String title) {
        return $(By.xpath("//div[contains(@class,'promo')]//a[contains(text(),'" + title + "')]"));
    }

    // Profile navigation
    private final SelenideElement loginButton = $(By.cssSelector("button[data-testid='loginButton']"));

    public SelenideElement getProfileItem(String text) {
        return $(By.xpath("//div[contains(@class,'itemText') and contains(text(), '" + text + "')]"));
    }

    private final SelenideElement subTitleField = $(By.cssSelector("span[class='userToolsSubtitle']"));
//    private final SelenideElement logoutButton = $(By.cssSelector("a[href='/logout/'] div")); // getProfileItem

    //    modalWrapperPage
    private final SelenideElement emailField = $(By.cssSelector("#login-email"));   // modalWrapperPage
    private final SelenideElement passwordField = $(By.cssSelector("#login-password")); // modalWrapperPage
    private final SelenideElement submitButton = $(By.cssSelector("div[data-testid='loginForm'] button[type='submit']")); // modalWrapperPage
    private final SelenideElement registrationButton = $(By.xpath("//div[contains(text(),'Регистрация')]"));
    private final SelenideElement forgottenPasswordButton = $(By.xpath("//button[contains(@class,'reset')]"));
    private final SelenideElement registrationEmailField = $(By.cssSelector("div[class*='BaseInput'] input"));
    private final SelenideElement registrationSubmitButton = $(By.xpath("//div[contains(@class,'submit')]/button"));
    public SelenideElement getErrorField(String errorText) {
        return $(By.xpath("//div[contains(@class,'ErrorMessage')]//span[contains(text(),'" + errorText + "')]"));
    }

    public SelenideElement getLogoButton() {
        return logoButton;
    }

    public SelenideElement getAccountButton() {
        return accountButton;
    }

    public SelenideElement getCatalogSearchFiled() {
        return catalogSearchFiled;
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

    public SelenideElement getRegistrationButton() {
        return registrationButton;
    }

    public SelenideElement getForgottenPasswordButton() {
        return forgottenPasswordButton;
    }

    public SelenideElement getRegistrationEmailField() {
        return registrationEmailField;
    }

    public SelenideElement getRegistrationSubmitButton() {
        return registrationSubmitButton;
    }

//    public SelenideElement getLogoutButton() {
//        return logoutButton;
//    }
}

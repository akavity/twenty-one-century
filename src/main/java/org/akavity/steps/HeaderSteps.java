package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.HeaderPage;
import org.openqa.selenium.Keys;

@Log4j2
public class HeaderSteps {
    HeaderPage headerPage = new HeaderPage();

    public void clickAccountButton() {
        headerPage.getAccountButton().click();
    }

    public void clickCatalogButton() {
        headerPage.getCatalogButton().click();
    }

    public boolean isLoginButtonDisplayed() {
        return headerPage.getLoginButton().isDisplayed();
    }

    public void clickLoginButton() {
        headerPage.getLoginButton().click();
    }

    public void clickPromoItem(String title) {
        headerPage.getPromoItem(title).click();
    }

    public void clickHeaderCart() {
        headerPage.getHeaderCartButton().click();
    }

    public void enterEmail(String email) {
        headerPage.getEmailField().click();
        headerPage.getEmailField().sendKeys(email);
    }

    public void enterPassword(String password) {
        headerPage.getPasswordField().click();
        headerPage.getPasswordField().sendKeys(password);
    }

    public void clickSubmitButton() {
        headerPage.getSubmitButton().click();
    }

    public String extractTextFromSubTitle() {
        return headerPage.getSubTitleField().getText();
    }

    public void clickProfileItem(String text) {
        headerPage.getProfileItem(text).click();
    }

    public void clickRegistrationButton() {
        headerPage.getRegistrationButton().click();
    }

    public void clickForgottenPasswordButton() {
        headerPage.getForgottenPasswordButton().click();
    }

    public boolean isErrorFieldDisplayed(String errorText) {
        log.info("Error: " + headerPage.getErrorField(errorText).getText());
        return headerPage.getErrorField(errorText).isDisplayed();
    }

    public void enterRegistrationEmail(String email) {
        headerPage.getRegistrationEmailField().click();
        headerPage.getRegistrationEmailField().sendKeys(email);
    }

    public void clingSearchField() {
        SelenideElement element = headerPage.getCatalogSearchFiled();
        element.sendKeys(Keys.CONTROL + "A");         // clear input field
        element.sendKeys(Keys.BACK_SPACE);
    }

    public void lookForProductUsingCatalogSearch(String product) {
        headerPage.getCatalogSearchFiled().sendKeys(product);
        headerPage.getCatalogSearchFiled().pressEnter();
    }

    public void clickRegistrationSubmitButton() {
        headerPage.getRegistrationSubmitButton().click();
    }
}

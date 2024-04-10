package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.HeaderPage;
import org.openqa.selenium.Keys;

@Log4j2
public class HeaderSteps {
    HeaderPage headerPage = new HeaderPage();

    public void clickAccountButton() {
        log.info("Click account button");
        headerPage.getAccountButton().click();
    }

    public void clickCatalogButton() {
        log.info("Click catalog button");
        headerPage.getCatalogButton().click();
    }

    public boolean isLoginButtonDisplayed() {
        boolean result = headerPage.getLoginButton().isDisplayed();
        log.info("Is login button displayed: " + result);
        return result;
    }

    public void clickLoginButton() {
        log.info("Click login button");
        headerPage.getLoginButton().click();
    }

    public void clickPromoItem(String title) {
        log.info("Click promo item: " + title);
        headerPage.getPromoItem(title).click();
    }

    public void clickHeaderCart() {
        log.info("Click header cart");
        headerPage.getHeaderCartButton().click();
    }

    public void enterEmail(String email) {
        log.info("Enter email: " + email);
        headerPage.getEmailField().click();
        headerPage.getEmailField().sendKeys(email);
    }

    public void enterPassword(String password) {
        log.info("Enter password: " + password);
        headerPage.getPasswordField().click();
        headerPage.getPasswordField().sendKeys(password);
    }

    public void clickSubmitButton() {
        log.info("Click submit button");
        headerPage.getSubmitButton().click();
    }

    public String extractTextFromSubTitle() {
        String text = headerPage.getSubTitleField().getText();
        log.info("Get title text: " + text);
        return text;
    }

    public void clickProfileItem(String text) {
        log.info("Click profile item");
        headerPage.getProfileItem(text).click();
    }

    public void clickRegistrationButton() {
        log.info("Click registration button");
        headerPage.getRegistrationButton().click();
    }

    public void clickForgottenPasswordButton() {
        log.info("Click forgotten password button");
        headerPage.getForgottenPasswordButton().click();
    }

    public boolean isErrorFieldDisplayed(String errorText) {
        log.info("Error: " + headerPage.getErrorField(errorText).getText());
        return headerPage.getErrorField(errorText).isDisplayed();
    }

    public void enterRegistrationEmail(String email) {
        log.info("Enter registration email: " + email);
        headerPage.getRegistrationEmailField().click();
        headerPage.getRegistrationEmailField().sendKeys(email);
    }

    public void cleanSearchField() {
        log.info("Clean the catalog search field");
        SelenideElement element = headerPage.getCatalogSearchFiled();
        element.sendKeys(Keys.CONTROL + "A");         // clear input field
        element.sendKeys(Keys.BACK_SPACE);
    }

    public void lookForProductUsingCatalogSearch(String product) {
        log.info("Look for product using catalog search");
        headerPage.getCatalogSearchFiled().sendKeys(product);
        headerPage.getCatalogSearchFiled().pressEnter();
    }

    public void clickRegistrationSubmitButton() {
        log.info("Click registration submit button");
        headerPage.getRegistrationSubmitButton().click();
    }

    public String extractEmailFromAccount() {
        String email = headerPage.getSubTitleField().getText();
        log.info("Account email: " + email);
        return email;
    }
}

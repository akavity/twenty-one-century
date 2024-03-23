package org.akavity.steps;

import org.akavity.pages.HeaderPage;

public class HeaderSteps {
    HeaderPage headerPage = new HeaderPage();

    public void clickAccountButton() {
        headerPage.getAccountButton().click();
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

    public void clickLogoutButton() {
        headerPage.getLogoutButton().click();
    }

    public void clickProfileItem(String text) {
        headerPage.getProfileItem(text).click();
    }
}

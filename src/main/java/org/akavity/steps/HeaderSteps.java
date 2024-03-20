package org.akavity.steps;

import org.akavity.pages.HeaderPage;

public class HeaderSteps {
    HeaderPage headerPage = new HeaderPage();

    public void clickAccountButton() {
        headerPage.getAccountButton().click();
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
}

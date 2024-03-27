package org.akavity.steps;

import org.akavity.pages.PopUpsPage;

public class PopUpsSteps {
    PopUpsPage popUpsPage = new PopUpsPage();

    public void clickCookiesRefuseButton() {
        popUpsPage.getCookiesRefuseButton().click();
    }

    public void clickAcceptCookiesButton() {
        popUpsPage.getCookiesAcceptButton().click();
    }
}

package org.akavity.steps;

import lombok.extern.log4j.Log4j2;
import org.akavity.pages.PopUpsPage;
import org.akavity.utils.Utils;

@Log4j2
public class PopUpsSteps {
    PopUpsPage popUpsPage = new PopUpsPage();
    Utils utils = new Utils();

    public void clickCookiesRefuseButton() {
        popUpsPage.getCookiesRefuseButton().click();
    }

    public void clickAcceptCookiesButton() {
        popUpsPage.getCookiesAcceptButton().click();
    }

    public void closePromoCode() {
        utils.sleep(2500);
        if (popUpsPage.getPopmechanicDesktop().isDisplayed()) {
            log.info("Close promotional code");
            popUpsPage.getPopmechanicCloseButton().click();
        }
    }
}

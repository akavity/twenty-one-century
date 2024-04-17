package org.akavity.steps;

import lombok.extern.log4j.Log4j2;
import org.akavity.pages.PopUpsPage;
import org.akavity.utils.Utils;

@Log4j2
public class PopUpsSteps {
    PopUpsPage popUpsPage = new PopUpsPage();
    Utils utils = new Utils();

    public void clickRefuseCookiesButton() {
        log.info("Click refuse cookies button");
        popUpsPage.getCookiesRefuseButton().click();
    }

    public void clickSecondCookiesRefuseButton() {
        log.info("Click second time refuse  cookies button ");
        popUpsPage.getCookiesSecondRefuseButton().click();
    }

    public void clickAcceptCookiesButton() {
        log.info("Click accept cookies button");
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

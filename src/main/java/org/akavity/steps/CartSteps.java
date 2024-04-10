package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.CartPage;

@Log4j2
public class CartSteps {
    CartPage cartPage = new CartPage();

    @Step
    public String extractBasketTitleItem() {
        String title = cartPage.getBasketItemTitle().getText();
        log.info("Extract text from basket title item: " + title);
        return title;
    }
}

package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement basketItemTitle = $(By.xpath("//div[contains(@class,'BasketItem_title')]/a"));

    public SelenideElement getBasketItemTitle() {
        return basketItemTitle;
    }
}

package org.akavity.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContentPage {
    private final ElementsCollection popularItem = $$(By.cssSelector("section[class*='PopularsContainer'] div[class*='ListItem']"));
    private final ElementsCollection specialOfferItem = $$(By.cssSelector("div[aria-hidden='false'] div[class*='CardContainer']"));
    private final ElementsCollection favoritesButton= $$(By.cssSelector("button[data-testid='card-favorites']"));

    public SelenideElement getBannersItem(String text) {
        return $(By.xpath("//span[contains(@class,'Banners_title') and contains(text(),'" + text + "')]/../.."));
    }

    public SelenideElement getChipHomeButton(String text) {
        return $(By.xpath("//span[contains(@class,'chip') and contains(text(),'" + text + "')]"));
    }

    public ElementsCollection getPopularItem() {
        return popularItem;
    }

    public ElementsCollection getSpecialOfferItem() {
        return specialOfferItem;
    }
}

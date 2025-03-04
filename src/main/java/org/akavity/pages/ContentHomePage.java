package org.akavity.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContentHomePage {
    private final ElementsCollection popularItems = $$(By.cssSelector("section[class*='PopularsContainer'] div[class*='ListItem']"));
    private final ElementsCollection specialOfferItems = $$(By.cssSelector("div[aria-hidden='false'] div[class*='CardContainer']"));
    private final ElementsCollection favoritesButtons = $$(By.cssSelector("button[data-testid='card-favorites']"));
    private final ElementsCollection popularPrice = $$(By.xpath("//header[contains(@class,'PopularsList')]/" +
            "following-sibling::div//span[contains(@data-testid,'card-current-price')]"));

    public SelenideElement getBannersItem(String text) {
        return $(By.xpath("//span[contains(@class,'Banners_title') and contains(text(),'" + text + "')]/../.."));
    }

    public SelenideElement getSpecialOfferButton(String text) {
        return $(By.xpath("//div[contains(@class,'SpecialOffersList')]//span[contains(@class,'Chip') and contains(text(),'" + text + "')]"));
    }

    public ElementsCollection getDiscountTypeItem(String disType) {
        return $$(By.xpath("//div[@aria-hidden='false']//div[contains(@class,'CardContainer')]" +
                "//span[contains(@class,'CardDiscount') and contains(text(),'" + disType + "')] | " +
                "//div[@aria-hidden='false']//div[contains(@class,'CardContainer')]" +
                "//div[contains(@class,'CardDiscountType') and contains(text(),'" + disType + "')]"));
    }

    public SelenideElement getPopularButton(String text) {
        return $(By.xpath("//header[contains(@class,'PopularsList')]//span[contains(@class,'Chip') and contains(text(),'" + text + "')]"));
    }

    public ElementsCollection getPopularItems() {
        return popularItems;
    }

    public ElementsCollection getSpecialOfferItems() {
        return specialOfferItems;
    }

    public ElementsCollection getFavoritesButtons() {
        return favoritesButtons;
    }

    public ElementsCollection getPopularPrice() {
        return popularPrice;
    }
}

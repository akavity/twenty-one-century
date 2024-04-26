package org.akavity.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContentHomePage {
    private final ElementsCollection popularItems = $$(By.cssSelector("section[class*='PopularsContainer'] div[class*='ListItem']"));
    private final ElementsCollection specialOfferItems = $$(By.cssSelector("div[aria-hidden='false'] div[class*='CardContainer']"));
    private final ElementsCollection favoritesButtons= $$(By.cssSelector("button[data-testid='card-favorites']"));

    public SelenideElement getBannersItem(String text) {
        return $(By.xpath("//span[contains(@class,'Banners_title') and contains(text(),'" + text + "')]/../.."));
    }

    public SelenideElement getSpecialOfferButton(String text) {
        return $(By.xpath("//div[contains(@class,'SpecialOffersList')]" +
                "//span[contains(@class,'label') and contains(text(),'" + text + "')]"));
    }
   public SelenideElement getPopularButton(String text) {
        return $(By.xpath("//header[contains(@class,'PopularsList')]" +
                "//span[contains(@class,'label') and contains(text(),'" + text + "')]"));
   }

    public ElementsCollection getPopularItems() {
        return popularItems;
    }
}

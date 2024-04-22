package org.akavity.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContentWrapperPage {
    private final SelenideElement titleField = $(By.cssSelector("h1[class*='title']"));
    private final ElementsCollection foundProducts = $$(By.xpath("//div[contains(@class,'style_product')]"));
    private final ElementsCollection searchDescriptionFields = $$(By.xpath("//span[@class='result__name']"));
    private final ElementsCollection catalogDescriptionField = $$(By.cssSelector("a[data-testid='card-info-a']"));
    private final ElementsCollection priceFields = $$(By.xpath("//p[contains(@class,'currentPrice')]"));
    private final ElementsCollection pinkButtons = $$(By.xpath("//button[@data-ga_action='add_to_cart']"));

    public SelenideElement getTitleField() {
        return titleField;
    }

    public ElementsCollection getFoundProducts() {
        return foundProducts;
    }

    public ElementsCollection getSearchDescriptionFields() {
        return searchDescriptionFields;
    }

    public ElementsCollection getPinkButtons() {
        return pinkButtons;
    }

    public ElementsCollection getPriceFields() {
        return priceFields;
    }

    public ElementsCollection getCatalogDescriptionField() {
        return catalogDescriptionField;
    }
}

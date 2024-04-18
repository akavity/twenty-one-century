package org.akavity.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContentPage {
    public SelenideElement getBannersItem(String text) {
        return $(By.xpath("//span[contains(@class,'Banners_title') and contains(text(),'" + text + "')]/../.."));
    }

    public SelenideElement getChipHomeButton(String text) {
        return $(By.xpath("//span[contains(@class,'chip') and contains(text(),'" + text + "')]"));
    }

    public ElementsCollection getSpecialOfferItem() {
        return $$(By.xpath("//div[@aria-hidden='false']//div[contains(@class,'CardContainer')]"));
    }
}

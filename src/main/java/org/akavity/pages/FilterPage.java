package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FilterPage {
    private final SelenideElement minPriceField = $(By.xpath("//input[@id='minPrice']"));
    private final SelenideElement maxPriceField = $(By.xpath("//input[@id='maxPrice']"));
    private final SelenideElement allFiltersButton = $(By.xpath("//div[contains(text(),'Все фильтры')]"));
    private final SelenideElement applyFiltersButton = $(By.cssSelector("button[data-testid*='apply']"));

    public SelenideElement getCheckbox(String title, String text) {
        return $(By.xpath("//div[contains(@class,'ListingFilters') and contains(text(),'" + title + "')]" +
                "/..//span[contains(text(),'" + text + "')]"));
    }

    public SelenideElement getShowAllButton(String title) {
        return $(By.xpath("//div[contains(@class,'ListingFilters') and contains(text(),'" + title + "')]" +
                "/..//div[contains(text(),'все')]"));
    }

    public SelenideElement getMinPriceField() {
        return minPriceField;
    }

    public SelenideElement getMaxPriceField() {
        return maxPriceField;
    }

    public SelenideElement getAllFiltersButton() {
        return allFiltersButton;
    }

    public SelenideElement getApplyFiltersButton() {
        return applyFiltersButton;
    }
}

package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {

    private final SelenideElement categoryTitleField = $(By.cssSelector("div[class*='categoryTitle']"));

    public SelenideElement getChapterItem(String title) {
        return $(By.xpath("//div[contains(@class,'leftContainer')]//span[contains(text(),'" + title + "')]"));
    }

    public SelenideElement getSectionItem(String name) {
        return $(By.xpath(" //div[contains(@class,'rightContainer')]" +
                "//a[contains(@class,'categoryButton')]/span[contains(text(),'" + name + "')]"));
    }

    public SelenideElement getSubsectionItem(String name) {
        return $(By.xpath("//div[contains(@class,'rightContainer')]" +
                "//a[contains(@class,'itemContainer')]/span[contains(text(),'" + name + "')]"));
    }

    public SelenideElement getShowAllButton(String categoryName) {
        return $(By.xpath("//a[contains(@class,'categoryButton')]" +
                "/span[contains(text(),'" + categoryName + "')]/../../button"));
    }

    public SelenideElement getBrandButton(String brand) {
        return $(By.xpath("//a[contains(@class,'randCrisps') and contains(text(),'" + brand + "')]"));
    }

    public SelenideElement getCategoryTitleField() {
        return categoryTitleField;
    }
}

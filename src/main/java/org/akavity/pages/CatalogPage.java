package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {

    private final SelenideElement categoryTitleField = $(By.cssSelector("div[class*='categoryTitle']"));

    public SelenideElement getChapterItem(String title) {
        return $(By.xpath("//div[contains(@class,'leftContainer')]//span[contains(text(),'" + title + "')]"));
    }

    public SelenideElement getCategoryItem(String name) {
        return $(By.xpath("//div[contains(@class,'rightContainer')]" +
                "//span[contains(@class,'categoryName') and contains(text(),'" + name + "')]"));
    }

    public SelenideElement getBrandButton(String brand) {
        return $(By.xpath("//a[contains(@class,'randCrisps') and contains(text(),'" + brand + "')]"));
    }

    public SelenideElement getCategoryTitleField() {
        return categoryTitleField;
    }
}

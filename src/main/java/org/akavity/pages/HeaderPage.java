package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private final SelenideElement logoButton = $(By.cssSelector("a[class='logotypeImg']"));
    private final SelenideElement catalogButton = $(By.cssSelector("button[class*='catalogButton']"));
    private final SelenideElement accountButton = $(By.xpath("//span[@class='userToolsText']"));
    private final SelenideElement headerCartButton = $(By.cssSelector("div[class='headerCart']"));
    private final SelenideElement catalogSearchFiled = $(By.cssSelector("#catalogSearch"));
    private final SelenideElement lupeButton = $(By.cssSelector("button[class*='Search_s']"));
    private final SelenideElement searchResultTitle = $(By.xpath("//h1[contains(text(),'Результаты поиска')]"));

    public SelenideElement getPromoItem(String title) {
        return $(By.xpath("//div[contains(@class,'promo')]//a[contains(text(),'" + title + "')]"));
    }

    // Profile navigation
    private final SelenideElement loginButton = $(By.cssSelector("button[data-testid='loginButton']"));
    private final SelenideElement subTitleField = $(By.cssSelector("span[class='userToolsSubtitle']"));

    public SelenideElement getProfileItem(String text) {
        return $(By.xpath("//div[contains(@class,'itemText') and contains(text(), '" + text + "')]"));
    }

    public SelenideElement getErrorField(String errorText) {
        return $(By.xpath("//div[contains(@class,'ErrorMessage')]//span[contains(text(),'" + errorText + "')]"));
    }

    public SelenideElement getLogoButton() {
        return logoButton;
    }

    public SelenideElement getAccountButton() {
        return accountButton;
    }

    public SelenideElement getCatalogSearchFiled() {
        return catalogSearchFiled;
    }

    public SelenideElement getLupeButton() {
        return lupeButton;
    }

    public SelenideElement getSearchResultTitle() {
        return searchResultTitle;
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }

    public SelenideElement getHeaderCartButton() {
        return headerCartButton;
    }

    public SelenideElement getSubTitleField() {
        return subTitleField;
    }

    public SelenideElement getCatalogButton() {
        return catalogButton;
    }
}

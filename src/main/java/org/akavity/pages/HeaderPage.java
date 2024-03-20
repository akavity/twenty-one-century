package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private final SelenideElement accountButton = $(By.cssSelector("button[class*='userToolsToggler']"));

    private final SelenideElement loginButton = $(By.cssSelector("button[data-testid='loginButton']"));

    private final SelenideElement headerCartButton = $(By.cssSelector("div[class='headerCart']"));

    public SelenideElement getPromoItem(String title) {
        return $(By.xpath("//div[contains(@class,'promo')]//li[contains(text(),'" + title + "')]"));
    }

    public SelenideElement getAccountButton() {
        return accountButton;
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }

    public SelenideElement getHeaderCartButton() {
        return headerCartButton;
    }
}

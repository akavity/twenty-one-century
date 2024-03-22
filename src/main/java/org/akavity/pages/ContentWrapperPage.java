package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ContentWrapperPage {
    private final SelenideElement titleField = $(By.cssSelector("h1[class*='title']"));

    public SelenideElement getTitleField() {
        return titleField;
    }
}

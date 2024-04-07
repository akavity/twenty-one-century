package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.CatalogPage;

@Log4j2
public class CatalogSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    CatalogPage catalogPage = new CatalogPage();

    @Step
    public String extractTextFromTitle() {
        String text = catalogPage.getCategoryTitleField().getText();
        log.info("Title contains text: " + text);
        return text;
    }

    @Step
    public void clickChapterItem(String title) {   // Left Container
        log.info("Click left container item: " + title);
        catalogPage.getChapterItem(title).click();
    }

    @Step
    public void clickCategoryItem(String title) {  // Right Container
        log.info("Click right container item: " + title);
        catalogPage.getCategoryItem(title).click();
    }

    @Step
    public void clickBrandButton(String brand) {
        log.info("Click " + brand + " button");
        catalogPage.getBrandButton(brand).click();
    }

    @Step
    public void clickShowAllButton(String categoryName) {
        log.info("Click show all button in category: " + categoryName);
        catalogPage.getShowAllButton(categoryName).scrollIntoView(PARAMETER);
        catalogPage.getShowAllButton(categoryName).click();
    }

    @Step
    public void hoverTheMouseOverChapterItem(String title) {
        log.info("Move the cursor over chapter item: " + title);
        SelenideElement chapterItem = catalogPage.getChapterItem(title);
        chapterItem.scrollIntoView(PARAMETER);
        chapterItem.hover();                                                 // mouse hover
    }
}

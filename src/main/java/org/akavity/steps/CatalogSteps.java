package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.CatalogPage;

@Log4j2
public class CatalogSteps {
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
}

package org.akavity.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ContentWrapperPage;
import org.akavity.utils.Utils;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ContentWrapperSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    ContentWrapperPage contentWrapperPage = new ContentWrapperPage();
    Utils utils = new Utils();

    @Step
    public String extractTextFromLogoOrTitle() {
        SelenideElement title = contentWrapperPage.getTitleField();
        String text;
        if (title.isDisplayed()) {
            text = title.getText();
            log.info("Title is displayed: " + text);
        } else {
            text = contentWrapperPage.getBrandLogo().getText();
            log.info("BrandLogo is displayed: " + text);
        }
        return text;
    }

    @Step
    public boolean doCatalogDescriptionsContainText(String text) {
        ElementsCollection collection = contentWrapperPage.getCatalogDescriptionField();
        List<String> names = new ArrayList<>(collection.texts());
        log.info("Description collection size: " + collection.size());
        return utils.doesListContainText(names, text);
    }

    @Step
    public boolean doSearchDescriptionsContainText(String text, int numberOfElements) {
        ElementsCollection collection = contentWrapperPage.getSearchDescriptionFields();
        List<String> names = new ArrayList<>(collection.first(numberOfElements).texts());
        log.info("Description collection size: " + collection.size());
        return utils.doesListContainText(names, text);
    }

    @Step
    public void clickRandomPinkButton(int elements) {
        log.info("Click random pink button");
        utils.sleep(2000);
        ElementsCollection collection = contentWrapperPage.getPinkButtons().first(elements);
        SelenideElement randomElement = collection.get(utils.rnd(0, collection.size() - 1));
        randomElement.scrollIntoView(PARAMETER);
        randomElement.click();
    }

    @Step
    public boolean areProductPricesWithinLimit(String min, String max) {
        log.info("Check product prices \n min price: " + min + "\n max price: " + max);
        ElementsCollection collection = contentWrapperPage.getPriceFields();
        return utils.arePricesWithinLimit(collection, Integer.parseInt(min), Integer.parseInt(max));
    }

    @Step
    public boolean areProductPricesHigherThanPrice(int price, int elements) {
        utils.sleep(1500);
        log.info("Check that the price of products is higher than a specific price");
        ElementsCollection collection = contentWrapperPage.getPriceFields().first(elements);
        return utils.arePricesHigherThanPrice(collection, price);
    }

    @Step
    public boolean areProductPricesLowerThanPrice(int price, int elements) {
        utils.sleep(1500);
        log.info("Check that the price of products is higher than a specific price");
        ElementsCollection collection = contentWrapperPage.getPriceFields().first(elements);
        return utils.arePricesLowerThanPrice(collection, price);
    }
}

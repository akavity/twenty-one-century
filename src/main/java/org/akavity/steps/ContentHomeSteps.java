package org.akavity.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ContentHomePage;
import org.akavity.utils.Utils;

@Log4j2
public class ContentHomeSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    ContentHomePage contentPage = new ContentHomePage();
    Utils utils = new Utils();

    @Step
    public void clickBannerItem(String text) {
        log.info("Click the banner item: " + text);
        contentPage.getBannersItem(text).scrollIntoView(PARAMETER);
        contentPage.getBannersItem(text).click();
    }

    @Step
    public void clickSpecialOfferButton(String text) {
        log.info("Click the special offer button: " + text);
        contentPage.getSpecialOfferButton(text).scrollIntoView(PARAMETER);
        contentPage.getSpecialOfferButton(text).click();
        utils.sleep();
    }

    @Step
    public void clickPopularButton(String text) {
        log.info("CLick the popular button: " + text);
        contentPage.getPopularButton(text).scrollIntoView(PARAMETER);
        contentPage.getPopularButton(text).click();
    }

    @Step
    public boolean areDiscountsDisplayed(String disType) {
        ElementsCollection collection = contentPage.getDiscountTypeItem(disType);
        return collection.asDynamicIterable().stream().allMatch(SelenideElement::isDisplayed);
    }

    @Step
    public boolean checkPriceOfPopularProducts(String text, int elements) {
        boolean result = false;
        ElementsCollection prices = contentPage.getPopularPrice().first(elements);
        switch (text) {
            case "до 100" -> result = utils.arePricesLowerThanPrice(prices, 100, elements);
            case "от 400" -> result = utils.arPricesHigherThanPrice(prices, 400, elements);
            case "200 – 400" -> result = utils.arePricesWithinLimit(prices, 200, 400, elements);
            default -> log.info("Entered an incorrect text");
        }
        return result;
    }
}

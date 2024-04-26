package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ContentHomePage;

@Log4j2
public class ContentHomeSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    ContentHomePage contentPage = new ContentHomePage();

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
    }

    @Step
    public void clickPopularButton(String text) {
        log.info("CLick the popular button: " + text);
        contentPage.getPopularButton(text).scrollIntoView(PARAMETER);
        contentPage.getPopularButton(text).click();
    }
}

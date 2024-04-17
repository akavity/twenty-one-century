package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.FilterPage;

@Log4j2
public class FilterSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    FilterPage filterPage = new FilterPage();

    @Step
    public void enterPrice(String min, String max) {
        log.info("Enter min price: " + min + "\n Enter max price: " + max);
        SelenideElement minPrice = filterPage.getMinPriceField();
        minPrice.scrollIntoView(PARAMETER);
        minPrice.sendKeys(min);
        filterPage.getMaxPriceField().sendKeys(max);
    }

    @Step
    public void selectCheckbox(String title, String text) {
        log.info("In section: " + title + " select element " + text);
        SelenideElement element = filterPage.getCheckbox(title, text);
        element.scrollIntoView(PARAMETER);
        element.click();
    }

    @Step
    public void clickShowAllButton(String title) {
        log.info("In section: " + title + " click button show all");
        SelenideElement element = filterPage.getShowAllButton(title);
        element.scrollIntoView(PARAMETER);
        element.click();
    }

    @Step
    public void clickAllFilers() {
        log.info("Click button all filters");
        SelenideElement element = filterPage.getAllFiltersButton();
        element.scrollIntoView(PARAMETER);
        element.click();
    }

    @Step
    public void applyFiltersButton() {
        log.info("Apply filters");
        SelenideElement element = filterPage.getApplyFiltersButton();
        element.scrollIntoView(PARAMETER);
        element.click();
    }
}

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
    public String getTitle() {
        String title = contentWrapperPage.getTitleField().getText();
        log.info("Title: " + title);
        return title;
    }

    @Step
    public boolean doDescriptionsContainText(String text, int numberOfElements) {
        ElementsCollection collection = contentWrapperPage.getDescriptionFields();
        log.info("Description collection size: " + collection.size());
        boolean result = true;
        if (collection.isEmpty()) {
            log.info("Collection is empty");
            result = false;
        } else {
            List<String> names = new ArrayList<>(collection.first(numberOfElements).texts());
            for (String name : names) {
                log.info("Array names contains name: " + name);
                if (!name.contains(text)) {
                    log.info("/// Object name dose not contain text: " + text);
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Step
    public boolean doDescriptionsContainText(String text) {
        ElementsCollection collection = contentWrapperPage.getDescriptionFiltersField();
        log.info("Description collection size: " + collection.size());
        boolean result = true;
        if (collection.isEmpty()) {
            log.info("Description collection is empty");
            result = false;
        } else {
            List<String> names = new ArrayList<>(collection.texts());
            for (String name : names) {
                log.info("Description collection contains : " + name);
                if (!name.contains(text)) {
                    log.info("/// Object name dose not contain text: " + text);
                    log.info("Description: " + name);
                    result = false;
                    break;
                }
            }
        }
        return result;
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
        boolean result = true;
        if (collection.isEmpty()) {
            log.info("Collection is empty");
            result = false;
        } else {
            for (SelenideElement el : collection) {
                String text = el.getText();
                double price = utils.extractDoubleFromText(text, "\\d+[,]\\d{2}");
                log.info("Product price: " + price);
                if (price > Double.parseDouble(max) && price < Double.parseDouble(min)) {
                    log.info("The product price isn't in the limit");
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}

package org.akavity.steps;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ContentWrapperPage;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ContentWrapperSteps {
    ContentWrapperPage contentWrapperPage = new ContentWrapperPage();

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
}

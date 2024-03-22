package org.akavity.steps;

import io.qameta.allure.Step;
import org.akavity.pages.ContentWrapperPage;

public class ContentWrapperSteps {
    ContentWrapperPage contentWrapperPage = new ContentWrapperPage();

    @Step
    public String getTitle() {
        return contentWrapperPage.getTitleField().getText();
    }
}

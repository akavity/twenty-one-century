package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.HeaderPage;
import org.akavity.pages.ModalWrapperPage;
import org.akavity.utils.Utils;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;

@Log4j2
public class HeaderSteps {
    HeaderPage headerPage = new HeaderPage();
    ModalWrapperPage modalWrapperPage = new ModalWrapperPage();
    Utils utils = new Utils();

    public void clickAccountButton() {
        log.info("Click account button");
        modalWrapperPage.getModalWindow().shouldNotBe(visible, Duration.ofSeconds(10));
        SelenideElement element = headerPage.getAccountButton();
        executeJavaScript("arguments[0].click();", element);
    }

    public void clickCatalogButton() {
        log.info("Click catalog button");
        headerPage.getCatalogButton().click();
    }

    public boolean isLoginButtonDisplayed() {
        boolean result = headerPage.getLoginButton().isDisplayed();
        log.info("Is login button displayed: " + result);
        return result;
    }

    public void clickLoginButton() {
        log.info("Click login button");
        headerPage.getLoginButton().click();
    }

    public void clickPromoItem(String title) {
        log.info("Click promo item: " + title);
        headerPage.getPromoItem(title).click();
    }

    public void clickHeaderCart() {
        log.info("Click header cart");
        headerPage.getHeaderCartButton().scrollTo();
        headerPage.getHeaderCartButton().click();
    }

    public String extractTextFromSubTitle() {
        String text = headerPage.getSubTitleField().getText();
        log.info("Get title text: " + text);
        return text;
    }

    public void clickProfileItem(String text) {
        log.info("Click profile item");
        headerPage.getProfileItem(text).click();
    }

    public boolean isErrorFieldDisplayed(String errorText) {
        log.info("Error: " + headerPage.getErrorField(errorText).getText());
        return headerPage.getErrorField(errorText).isDisplayed();
    }

    public void cleanSearchField() {
        log.info("Clean the catalog search field");
        SelenideElement element = headerPage.getCatalogSearchFiled();
        element.sendKeys(Keys.CONTROL + "A");         // clear input field
        element.sendKeys(Keys.BACK_SPACE);
    }

    public void lookForProductUsingCatalogSearch(String product) {
        log.info("Look for product using catalog search");
        headerPage.getCatalogSearchFiled().sendKeys(product);
        headerPage.getCatalogSearchFiled().pressEnter();
    }

    public String extractEmailFromAccount() {
        utils.sleep();
        String email = headerPage.getSubTitleField().getText();
        log.info("Account email: " + email);
        return email;
    }
}

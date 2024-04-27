package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.catalogTest.*;
import org.akavity.steps.*;
import org.akavity.utils.JsonReader;
import org.akavity.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends BaseOldTest {
    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HeaderSteps headerSteps = new HeaderSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    ContentHomeSteps contentSteps = new ContentHomeSteps();
    ContentWrapperSteps contentWrapperSteps = new ContentWrapperSteps();
    Utils utils = new Utils();

    @TestData(jsonFile = "hiddenItemData", model = "HiddenItemData", folder = "catalogTest")
    @Test(description = "Select hidden an element in the catalog",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectHiddenCategoryItem(HiddenItemData hiddenItem) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickCatalogButton();
        catalogSteps.hoverTheMouseOverChapterItem(hiddenItem.getChapterItem());
        catalogSteps.clickShowAllButton(hiddenItem.getAllButton());
        catalogSteps.clickSubsectionItem(hiddenItem.getCategoryItem());

        String actualTitle = contentWrapperSteps.extractTextFromLogoOrTitle();
        String expectedTitle = hiddenItem.getExpectedTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @TestData(jsonFile = "catalogData", model = "CatalogData", folder = "catalogTest")
    @Test(description = "Move around the catalog",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void moveAroundTheCatalog(CatalogData catalog) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickCatalogButton();
        catalogSteps.hoverTheMouseOverChapterItem(catalog.getChapterItem());
        catalogSteps.clickSubsectionItem(catalog.getCategoryItem());

        String actualTitle = contentWrapperSteps.extractTextFromLogoOrTitle();
        String expectedTitle = catalog.getExpectedTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @TestData(jsonFile = "brandData", model = "BrandData", folder = "catalogTest")
    @Test(description = "Select brand in the catalog",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectBrand(BrandData brand) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickCatalogButton();
        catalogSteps.hoverTheMouseOverChapterItem(brand.getChapterItem());
        catalogSteps.clickBrandButton(brand.getBrand());

        String actualTitle = contentWrapperSteps.extractTextFromLogoOrTitle();
        String expectedTitle = brand.getExpectedTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @TestData(jsonFile = "brandItemData", model = "BrandItemData", folder = "catalogTest")
    @Test(description = "Click on the banner in banner box",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void clickBannerItem(BrandItemData brand) {
        popUpsSteps.clickRefuseCookiesButton();
        popUpsSteps.clickSecondCookiesRefuseButton();
        contentSteps.clickBannerItem(brand.getBrand());

        Assert.assertTrue(contentWrapperSteps.extractTextFromLogoOrTitle().contains(brand.getBrand()));
    }

    @TestData(jsonFile = "specialOfferData", model = "SpecialOfferData", folder = "catalogTest")
    @Test(description = "Check that the discounts are shown on the products",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void clickSpecialOfferItem(SpecialOfferData offer) {
        popUpsSteps.clickRefuseCookiesButton();
        popUpsSteps.clickSecondCookiesRefuseButton();
        contentSteps.clickSpecialOfferButton(offer.getOfferType());

        Assert.assertTrue(contentSteps.areDiscountsDisplayed(offer.getDiscountType()));
    }
}

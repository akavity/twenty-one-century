package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.catalogTest.*;
import org.akavity.steps.*;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends OldBaseTest {
    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HeaderSteps headerSteps = new HeaderSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    ContentHomeSteps contentSteps = new ContentHomeSteps();
    ContentWrapperSteps contentWrapperSteps = new ContentWrapperSteps();

    @TestData(jsonFile = "hiddenItemData", model = "HiddenItemData", folder = "catalogTest")
    @Test(description = "Select a hidden element in the catalog",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectHiddenCategoryItem(HiddenItemData hiddenItem) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickCatalogButton();
        catalogSteps.hoverTheMouseOverChapterItem(hiddenItem.getChapterItem());
        catalogSteps.clickShowAllButton(hiddenItem.getAllButton());
        catalogSteps.clickSubsectionItem(hiddenItem.getCategoryItem());

        String actualTitle = contentWrapperSteps.extractTextFromTitle();
        String expectedTitle = hiddenItem.getExpectedTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @TestData(jsonFile = "catalogData", model = "CatalogData", folder = "catalogTest")
    @Test(description = "Navigate through the catalog",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void navigateThroughCatalog(CatalogData catalog) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickCatalogButton();
        catalogSteps.hoverTheMouseOverChapterItem(catalog.getChapterItem());
        catalogSteps.clickSubsectionItem(catalog.getCategoryItem());

        String actualTitle = contentWrapperSteps.extractTextFromTitle();
        String expectedTitle = catalog.getExpectedTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @TestData(jsonFile = "brandData", model = "BrandData", folder = "catalogTest")
    @Test(description = "Select a brand in the catalog",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectBrand(BrandData brand) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickCatalogButton();
        catalogSteps.hoverTheMouseOverChapterItem(brand.getChapterItem());
        catalogSteps.clickBrandButton(brand.getBrand());

        String actualTitle = contentWrapperSteps.extractTextFromTitle();
        String expectedTitle = brand.getExpectedTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @TestData(jsonFile = "brandItemData", model = "BrandItemData", folder = "catalogTest")
    @Test(description = "Select a banner in the banner box",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void clickBannerItem(BrandItemData brand) {
        popUpsSteps.clickAcceptCookiesButton();
        contentSteps.clickBannerItem(brand.getBrand());

        Assert.assertTrue(contentWrapperSteps.extractTextFromTitle().contains(brand.getBrand().toLowerCase()));
    }

    @TestData(jsonFile = "popProductsData", model = "PopProductsData", folder = "catalogTest")
    @Test(description = "Sort popular products by price",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void sortPopularProductsByPrice(PopProductsData products) {
        popUpsSteps.clickAcceptCookiesButton();
        contentSteps.clickPopularButton(products.getButtonText());

        Assert.assertTrue(contentSteps.checkPriceOfPopularProducts(products.getButtonText(), products.getElements()));
    }
}

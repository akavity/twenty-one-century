package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.catalogTest.BrandData;
import org.akavity.models.catalogTest.CatalogData;
import org.akavity.models.catalogTest.HiddenItemData;
import org.akavity.steps.CatalogSteps;
import org.akavity.steps.ContentWrapperSteps;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.PopUpsSteps;
import org.akavity.utils.JsonReader;
import org.akavity.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTest {
    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HeaderSteps headerSteps = new HeaderSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
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
        catalogSteps.clickCategoryItem(hiddenItem.getCategoryItem());

        String actualTitle = contentWrapperSteps.getTitle();
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
        catalogSteps.clickCategoryItem(catalog.getCategoryItem());

        String actualTitle = contentWrapperSteps.getTitle();
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

        String actualTitle = contentWrapperSteps.getTitle();
        String expectedTitle = brand.getExpectedTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}

package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.shoppingTest.CatalogData;
import org.akavity.models.shoppingTest.SearchData;
import org.akavity.steps.ContentWrapperSteps;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.PopUpsSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ShoppingTest extends BaseTest {
    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HeaderSteps headerSteps = new HeaderSteps();
    ContentWrapperSteps contentWrapperSteps = new ContentWrapperSteps();

    @TestData(jsonFile = "catalogData", model = "CatalogData", folder = "shoppingTest")
    @Test(description = "",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void moveAroundTheCatalog(CatalogData catalog) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.clickPromoItem(catalog.getPromoItem());

        Assert.assertEquals(contentWrapperSteps.getTitle(), catalog.getTitle());
    }

    @TestData(jsonFile = "searchData", model = "SearchData", folder = "shoppingTest")
    @Test(description = "",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void findProductUsingTheSearch(SearchData searchData) {
        popUpsSteps.clickAcceptCookiesButton();
        headerSteps.cleanSearchField();
        headerSteps.lookForProductUsingCatalogSearch(searchData.getProductName());
        popUpsSteps.closePromoCode();

        boolean result = contentWrapperSteps
                .doDescriptionsContainText(searchData.getProductName(), searchData.getNumberOfProducts());
        Assert.assertTrue(result);
    }
}

package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.shoppingTest.CatalogData;
import org.akavity.models.shoppingTest.PhoneData;
import org.akavity.models.shoppingTest.SearchCartData;
import org.akavity.models.shoppingTest.SearchData;
import org.akavity.steps.*;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {
    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HeaderSteps headerSteps = new HeaderSteps();
    ContentWrapperSteps contentWrapperSteps = new ContentWrapperSteps();
    CartSteps cartSteps = new CartSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    FilterSteps filterSteps = new FilterSteps();

    @TestData(jsonFile = "catalogData", model = "CatalogData", folder = "shoppingTest")
    @Test(description = "Headers Navigation",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void moveAroundTheHeader(CatalogData catalog) {
        popUpsSteps.clickRefuseCookiesButton();
        popUpsSteps.clickSecondCookiesRefuseButton();
        headerSteps.clickPromoItem(catalog.getPromoItem());

        Assert.assertEquals(contentWrapperSteps.getTitle(), catalog.getTitle());
    }

    @TestData(jsonFile = "searchData", model = "SearchData", folder = "shoppingTest")
    @Test(description = "Find a product using search",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void findProductUsingTheSearch(SearchData searchData) {
        popUpsSteps.clickRefuseCookiesButton();
        popUpsSteps.clickSecondCookiesRefuseButton();
        headerSteps.lookForProductUsingCatalogSearch(searchData.getProductName());
        popUpsSteps.closePromoCode();

        boolean result = contentWrapperSteps.doSearchDescriptionsContainText(searchData.getProductName(), searchData.getNumberOfProducts());
        Assert.assertTrue(result);
    }

    @TestData(jsonFile = "searchCartData", model = "SearchCartData", folder = "shoppingTest")
    @Test(description = "Find the product using the search and add it to the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void findProductUsingSearchAndAddToCart(SearchCartData search) {
        popUpsSteps.clickRefuseCookiesButton();
        popUpsSteps.clickSecondCookiesRefuseButton();
        headerSteps.lookForProductUsingCatalogSearch(search.getProduct());
        contentWrapperSteps.clickRandomPinkButton(search.getNumberOfElements());
        headerSteps.clickHeaderCart();

        Assert.assertTrue(cartSteps.extractBasketTitleItem().contains(search.getCartProduct()));
    }

    @TestData(jsonFile = "phoneData", model = "PhoneData", folder = "shoppingTest")
    @Test(description = "Make sure that product prices are within the specified limit",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectPhone(PhoneData phone) {
        popUpsSteps.clickRefuseCookiesButton();
        popUpsSteps.clickSecondCookiesRefuseButton();
        headerSteps.clickCatalogButton();
        catalogSteps.hoverTheMouseOverChapterItem(phone.getChapterItem());
        catalogSteps.clickSubsectionItem(phone.getSubsectionItem());
        filterSteps.enterPrice(phone.getMinPrice(), phone.getMaxPrice());
        filterSteps.selectCheckbox(phone.getTitleManufacturer(), phone.getManufacturer());
        filterSteps.selectCheckbox(phone.getTitleInternalMemory(), phone.getInternalMemory());
        filterSteps.applyFiltersButton();

        Assert.assertTrue(contentWrapperSteps.areProductPricesWithinLimit(phone.getMinPrice(), phone.getMaxPrice()));
        Assert.assertTrue(contentWrapperSteps.doCatalogDescriptionsContainText(phone.getManufacturer()));
        Assert.assertTrue(contentWrapperSteps.doCatalogDescriptionsContainText(phone.getInternalMemory()));
    }
}

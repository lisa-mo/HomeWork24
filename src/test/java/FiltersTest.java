//  Write 2 tests (add usage of all 8 types of selectors):
//2) Verification of 3 filters (manufacturer, price, your own choice)
//        1. Navigate to https://rozetka.com.ua/
//        2. Search by "samsung"
//        3. Click "Мобильные телефоны" in the product filters panel
//        4. Add to filters "Apple" and "Honor"
//        5. Verify all filtered products are products made by Samsung, Apple or Honor
//
//        1. Navigate to https://rozetka.com.ua/
//        2. Search by "samsung"
//        3. Click "Мобильные телефоны" in the product filters panel
//        4. Add to price filter: 5000<price<15000
//        5. Verify all filtered products are products with price from range
//
//        1. Navigate to https://rozetka.com.ua/
//        2. Search by "samsung"
//        3. Click "Мобильные телефоны" in the product filters panel
//        4. Add filter value (your choice)
//        5. Verify all filtered products are products according to filter

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import filtersPages.FiltersPage;
import filtersPages.SamsungSearchPage;
import filtersPages.SamsungSearchResultPage;

public class FiltersTest extends BaseTest {
    String url = "https://rozetka.com.ua/";
    String searchText = "samsung";
    String samsung = "Samsung";
    String apple = "Apple";
    String huawei = "Huawei";
    int minValue = 5000;
    int maxValue = 15000;
    String ram16 = "16/";

    FiltersPage filtersPage;

    @BeforeMethod
    public void navigateToUrl() {
//  1. Navigate to https://rozetka.com.ua/
        driver.get(url);
//  2. Search by "samsung"
        SamsungSearchPage samsungSearchPage = new SamsungSearchPage(driver);
        samsungSearchPage.doTheSearch(searchText);
        waitForPageLoad();

//  3. Click "Мобильные телефоны" in the product filters panel
        SamsungSearchResultPage samsungSearchResultPage = new SamsungSearchResultPage(driver);
        samsungSearchResultPage.showMoreProdToWait();
        samsungSearchResultPage.waitForMobilesLink();
        samsungSearchResultPage.pressMobilesLink();
        waitForPageLoad();

        filtersPage = new FiltersPage(driver);
    }

    @Test
    public void filterBrandTest() throws Exception {
//        4. Add to filters "Apple" and "Honor"
        filtersPage.pressAppleCheckbox();
        waitForPageLoad();
        filtersPage.pressHonorCheckbox();
        waitForPageLoad();
//        5. Verify all filtered products are products made by Samsung, Apple or Honor
        filtersPage.checkTitlesForBrands(samsung, apple, huawei);
    }

    @Test
    public void filterPriceTest() throws Exception {
        filtersPage.waitForMinInput();
        filtersPage.clearMinInput();
        filtersPage.waitForMaxInput();
        filtersPage.waitForSubmitButton();
        filtersPage.fillInMinInput(minValue);
        filtersPage.clearMaxInput();
        filtersPage.fillInMaxInput(maxValue);
        filtersPage.pressSubmitButton();

        waitForPageLoad();
//        5. Verify all filtered products are products with price from range
        filtersPage.checkMobilePrices(minValue, maxValue);
    }

    @Test
    public void filterMemoryTest() throws Exception {
//        4. Add filter value (your choice)
        scrollToElement(filtersPage.findRam16Checkbox());
        filtersPage.pressRam16Checkbox();
        waitForPageLoad();
//        5. Verify all filtered products are products according to filter
        filtersPage.checkRam16InTitles(ram16);
    }
}

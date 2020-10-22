package Factory;//  Write 2 tests (add usage of all 8 types of selectors):

//  1) Verification of comparison of 2 monitors
//  1. Navigate to https://rozetka.com.ua/
//  2. Hover "Ноутбуки и компьютеры", click "Мониторы", wait for page to load
//  3. Find first monitor with price less then 3000UAH, click on image of this monitor, wait for page to load
//  4. Add monitor to comparison. Verify icon (1) appears in header close to comparison image (scales). Remember price, name
//  5. Click back button in browser
//  6. Find first monitor which price is less then first monitor. Click on image of found monitor. Wait for page to load
//  7. Add second monitor to comparison. Verify icon (2) appears in header close to comparison image (scales). Remember price, name
//  8. Click on comparison image in header. Click on "Мониторы (2)". Wait for page to load
//  9. Verify that in comparison you have just 2 monitors
//  10. Verify that names are correct (equal to names which you stored in step4 and step7)
//  11. Verify that prices are correct (equal to prices which you stored in step4 and step7)

import monitorsCompareFactory.ComparingMonitorsFactoryPage;
import monitorsCompareFactory.FirstMonitorFactoryPage;
import monitorsCompareFactory.HoverToMonitorsFactoryPage;
import monitorsCompareFactory.MonitorsFactoryPage;
import monitorsComparePages.ComparingMonitorsPage;
import monitorsComparePages.FirstMonitorPage;
import monitorsComparePages.HoverToMonitorsPage;
import monitorsComparePages.MonitorsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MonitorComparisonFactoryTest extends BaseFactoryTest {
    String url = "https://rozetka.com.ua/";
    String firstAmount = "3000";

    @BeforeMethod
    public void navigateToUrl() {
//  1. Navigate to https://rozetka.com.ua/
        driver.get(url);
    }

    @Test
    public void compareTest() throws Exception {
//  2. Hover "Ноутбуки и компьютеры", click "Мониторы", wait for page to load
        driver.manage().window().maximize();
        HoverToMonitorsFactoryPage hoverToMonitorsPage = new HoverToMonitorsFactoryPage(driver);
        hoverToMonitorsPage.hoverlaptopPcLink();
        hoverToMonitorsPage.waitForMonitorsLink();
        hoverToMonitorsPage.waitForMonitorsLinkClickable();
        hoverToMonitorsPage.pressMonitorsLink();
        waitForPageLoad();

//  3. Find first monitor with price less then 3000UAH, click on image of this monitor, wait for page to load
        MonitorsFactoryPage monitorsPage = new MonitorsFactoryPage(driver);
        scrollToElement(monitorsPage.scrollToMin);
        monitorsPage.compareMonitorPrices(firstAmount);
        waitForPageLoad();
//        Assert.assertTrue(elementIsNotPresent("//span [@class='header-actions__button-counter']"));

//  4. Add monitor to comparison. Verify icon (1) appears in header close to comparison image (scales). Remember price, name
        FirstMonitorFactoryPage firstMonitorPage = new FirstMonitorFactoryPage(driver);
        firstMonitorPage.tabForWait();
        scrollToElement(firstMonitorPage.waitTab);
        firstMonitorPage.pressCompareButton();
        firstMonitorPage.waitForCompareCounter();
//        assertTrue(isElementPresent(firstMonitorPage.compareCounter));

        firstMonitorPage.waitForNumberOfCompare();
        assertEquals(firstMonitorPage.checkNumberOfCompare(), "1");

        String firstPriceToCompare = firstMonitorPage.getFirstMonitorPrice();
        String firstTitleToCompare = firstMonitorPage.getFirstMonitorTitle();

        System.out.println(firstMonitorPage.getFirstMonitorPrice());
        System.out.println(firstMonitorPage.getFirstMonitorTitle());

//  5. Click back button in browser
        driver.navigate().back();
        waitForPageLoad();

//  6. Find first monitor which price is less then first monitor. Click on image of found monitor. Wait for page to load
        monitorsPage.compareMonitorPrices(firstPriceToCompare);
        waitForPageLoad();

//  7. Add second monitor to comparison. Verify icon (2) appears in header close to comparison image (scales). Remember price, name

        firstMonitorPage.pressMainCompareButton();
        waitForPageLoad();
        firstMonitorPage.waitForScales();
//        sleep(1000);
        scrollToElement(firstMonitorPage.prodCodeWait);
        assertEquals(firstMonitorPage.secondIconCompare(), "2");

        String secondPriceToCompare = firstMonitorPage.getFirstMonitorPrice();
        String secondTitleToCompare = firstMonitorPage.getFirstMonitorTitle();

        System.out.println(secondPriceToCompare);
        System.out.println(secondTitleToCompare);

//  8. Click on comparison image in header. Click on "Мониторы (2)". Wait for page to load
        firstMonitorPage.hoverAllAboutProdToWait();
        sleep(1000);
        firstMonitorPage.waitForCompareIcon();
        firstMonitorPage.pressToCompare();

        firstMonitorPage.waitForCompareLink();
        firstMonitorPage.pressCompareLink();

        waitForPageLoad();

//  9. Verify that in comparison you have just 2 monitors
        ComparingMonitorsFactoryPage comparingMonitorsPage = new ComparingMonitorsFactoryPage(driver);
        comparingMonitorsPage.pressSearchToWait();

        assertEquals(2, comparingMonitorsPage.checkAmountToCompare());

//  10. Verify that names are correct (equal to names which you stored in step4 and step7)
        assertEquals(comparingMonitorsPage.comparingTitles.get(0).getText(), firstTitleToCompare);
        assertEquals(comparingMonitorsPage.comparingTitles.get(1).getText(), secondTitleToCompare);

        System.out.println(comparingMonitorsPage.comparingTitles.get(0).getText() + " " + firstTitleToCompare);
        System.out.println(comparingMonitorsPage.comparingTitles.get(1).getText() + " " + secondTitleToCompare);

//  11. Verify that prices are correct (equal to prices which you stored in step4 and step7)
        assertEquals(comparingMonitorsPage.getFirstPriceToCompareStr(), firstPriceToCompare);
        assertEquals(comparingMonitorsPage.getSecondPriceToCompareStr(), secondPriceToCompare);
        System.out.println(comparingMonitorsPage.getFirstPriceToCompareStr() + " " + firstPriceToCompare);
        System.out.println(comparingMonitorsPage.getSecondPriceToCompareStr() + " " + secondPriceToCompare);
    }
}
package filtersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class FiltersPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public FiltersPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
    }

    private By appleCheckbox = By.cssSelector("label[for=Apple]");
    private By honorCheckbox = By.cssSelector("label[for=Huawei]");
    private By prodTitlesBrands = By.cssSelector("span.goods-tile__title");
    private By minInput = By.cssSelector("input[formcontrolname=min]");
    private By maxInput = By.cssSelector("input[formcontrolname=max]");
    private By submitButton = By.cssSelector("button[type=submit]");
    private By mobListPrices = By.cssSelector("span.goods-tile__price-value");
    private By ram16Checkbox = By.cssSelector("label[for=\"16 ГБ\"]");
    private By ram16List = By.cssSelector("span.goods-tile__title");

    public void pressAppleCheckbox() {
        webDriver.findElement(appleCheckbox).click();
    }

    public void pressHonorCheckbox() {
        webDriver.findElement(honorCheckbox).click();
    }

    private List<WebElement> getTitlesForBrands() {
        return webDriver.findElements(prodTitlesBrands);
    }

    public void checkTitlesForBrands(String samsung, String apple, String huawei) throws Exception {
        List<WebElement> searchResultsBrands = getTitlesForBrands();
        for (WebElement searchResult : searchResultsBrands) {
            if (!searchResult.getText().contains(samsung)) {
                if (!searchResult.getText().contains(apple)) {
                    if (!searchResult.getText().contains(huawei)) {
                        throw new Exception("There are no" + samsung + ", " + apple + ", " + huawei + " brands in the names of items.");
                    }
                }
            }
        }
    }

    public void waitForMinInput() {
        wait.until(presenceOfElementLocated(minInput));
    }

    public void waitForMaxInput() {
        wait.until(presenceOfElementLocated(maxInput));
    }

    public void waitForSubmitButton() {
        wait.until(presenceOfElementLocated(submitButton));
    }

    public void clearMinInput() {
        webDriver.findElement(minInput).clear();
      }

    public void clearMaxInput() {
        webDriver.findElement(maxInput).clear();
    }

    public void fillInMinInput(int minValue) {
        webDriver.findElement(minInput).sendKeys(String.valueOf(minValue) + Keys.ENTER);
    }

    public void fillInMaxInput(int maxValue) {
        webDriver.findElement(maxInput).sendKeys(String.valueOf(maxValue) + Keys.ENTER);
    }

    public void pressSubmitButton() {
        webDriver.findElement(submitButton).click();
    }

    public List<WebElement> getListOfPrices() {
        return webDriver.findElements(mobListPrices);
    }

    public void checkMobilePrices(int minValue, int maxValue) throws Exception {
        List<WebElement> prices = getListOfPrices();
        for (int prodCount = 0; prodCount < prices.size(); prodCount++) {
            String strPrice = prices.get(prodCount).getText().replaceAll("[^\\d.]", "");
            int intPrice = Integer.parseInt(strPrice);
            if (intPrice < minValue || intPrice > maxValue) {
                throw new Exception("Wrong price value.");
            }
        }
    }

    public WebElement findRam16Checkbox() {
        WebElement checkboxGB = webDriver.findElement(ram16Checkbox);
        return checkboxGB;
    }

    public void pressRam16Checkbox() {
        webDriver.findElement(ram16Checkbox).click();
    }

    private List<WebElement> getRam16List() {
        return webDriver.findElements(ram16List);
    }

    public void checkRam16InTitles(String ram16) throws Exception {
        List<WebElement> searchResultsRam = getRam16List();
        for (WebElement searchResult : searchResultsRam) {
            if (!searchResult.getText().contains(ram16)) {
                throw new Exception("RAM size filter error.");
            }
        }
    }
}
package filtersFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class FiltersFactoryPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public FiltersFactoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "label[for=Apple]")
    private WebElement appleCheckbox;
    @FindBy(css = "label[for=Huawei]")
    private WebElement honorCheckbox;
    @FindBy(css = "span.goods-tile__title")
    private List<WebElement> prodTitlesBrands;
    @FindBy(css = "input[formcontrolname=min]")
    private WebElement minInput;
    @FindBy(css = "input[formcontrolname=max]")
    private WebElement maxInput;
    @FindBy(css = "button[type=submit]")
    private WebElement submitButton;
    @FindBy(css = "span.goods-tile__price-value")
    private List<WebElement> mobListPrices;
    @FindBy(css = "label[for=\"16 ГБ\"]")
    public WebElement ram16Checkbox;
    @FindBy(css = "span.goods-tile__title")
    private List<WebElement> ram16List;

    public void pressAppleCheckbox() {
        appleCheckbox.click();
    }

    public void pressHonorCheckbox() {
        honorCheckbox.click();
    }

    public void checkTitlesForBrands(String samsung, String apple, String huawei) throws Exception {
        List<WebElement> searchResultsBrands = prodTitlesBrands;
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
        wait.until(visibilityOf(minInput));
    }

    public void waitForMaxInput() {
        wait.until(visibilityOf(maxInput));
    }

    public void waitForSubmitButton() {
        wait.until(visibilityOf(submitButton));
    }

    public void clearMinInput() {
        minInput.clear();
    }

    public void clearMaxInput() {
        maxInput.clear();
    }

    public void fillInMinInput(int minValue) {
        minInput.sendKeys(String.valueOf(minValue) + Keys.ENTER);
    }

    public void fillInMaxInput(int maxValue) {
        maxInput.sendKeys(String.valueOf(maxValue) + Keys.ENTER);
    }

    public void pressSubmitButton() {
        submitButton.click();
    }

    public void checkMobilePrices(int minValue, int maxValue) throws Exception {
        List<WebElement> prices = mobListPrices;
        for (int prodCount = 0; prodCount < prices.size(); prodCount++) {
            String strPrice = prices.get(prodCount).getText().replaceAll("[^\\d.]", "");
            int intPrice = Integer.parseInt(strPrice);
            if (intPrice < minValue || intPrice > maxValue) {
                throw new Exception("Wrong price value.");
            }
        }
    }

    public void pressRam16Checkbox() {
        ram16Checkbox.click();
    }


    public void checkRam16InTitles(String ram16) throws Exception {
        List<WebElement> searchResultsRam = ram16List;
        for (WebElement searchResult : searchResultsRam) {
            if (!searchResult.getText().contains(ram16)) {
                throw new Exception("RAM size filter error.");
            }
        }
    }
}
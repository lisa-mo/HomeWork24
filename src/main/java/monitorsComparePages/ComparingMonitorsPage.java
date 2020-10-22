package monitorsComparePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ComparingMonitorsPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public ComparingMonitorsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);

    }

    private By searchWait = By.name("search");
    private By prodAmountCompare = By.cssSelector("a.product__heading");
    private By comparingTitles = By.cssSelector("a.product__heading");
    private By fOldPrice = By.xpath("//ul[@class = 'products-grid']//li[1]//*[@class = 'product__prices']/div/div");
    private By sOldPrice = By.xpath("//ul[@class = 'products-grid']//li[2]//*[@class = 'product__prices']/div/div");
    private By fAllPrices = By.xpath("//ul[@class = 'products-grid']//li[1]//*[@class = 'product__prices']/div");
    private By sAllPrices = By.xpath("//ul[@class = 'products-grid']//li[2]//*[@class = 'product__prices']/div");

    public void pressSearchToWait() {
        webDriver.findElement(searchWait).click();
    }

    public int checkAmountToCompare() {
        return webDriver.findElements(prodAmountCompare).size();
    }

    public List<WebElement> getNamesToCompareList() {
        return webDriver.findElements(comparingTitles);
    }

    private String getFirstOldPrice() {
        return webDriver.findElement(fOldPrice).getText().replaceAll("\\s+", "");
    }

    private String getSecondOldPrice() {
        return webDriver.findElement(sOldPrice).getText().replaceAll("\\s+", "");
    }

    private String getFirstAllPrice() {
        return webDriver.findElement(fAllPrices).getText().replaceAll("\\s+", "");
    }

    private String getSecondAllPrice() {
        return webDriver.findElement(sAllPrices).getText().replaceAll("\\s+", "");
    }

    public String getFirstPriceToCompareStr() {
        return getFirstAllPrice().replace(getFirstOldPrice(), "").replaceAll("[^0-9]", "");
    }

    public String getSecondPriceToCompareStr() {
        return getSecondAllPrice().replace(getSecondOldPrice(), "").replaceAll("[^0-9]", "");
    }

}

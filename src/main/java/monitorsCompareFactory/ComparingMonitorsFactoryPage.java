package monitorsCompareFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ComparingMonitorsFactoryPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public ComparingMonitorsFactoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(name = "search")
    private WebElement searchWait;
    @FindBy(css = "a.product__heading")
    private List<WebElement> prodAmountCompare;
    @FindBy(css = "a.product__heading")
    public List<WebElement> comparingTitles;
    @FindBy(xpath = "//ul[@class = 'products-grid']//li[1]//*[@class = 'product__prices']/div/div")
    private WebElement fOldPrice;
    @FindBy(xpath = "//ul[@class = 'products-grid']//li[2]//*[@class = 'product__prices']/div/div")
    private WebElement sOldPrice;
    @FindBy(xpath = "//ul[@class = 'products-grid']//li[1]//*[@class = 'product__prices']/div")
    private WebElement fAllPrices;
    @FindBy(xpath = "//ul[@class = 'products-grid']//li[2]//*[@class = 'product__prices']/div")
    private WebElement sAllPrices;

    public void pressSearchToWait() {
        searchWait.click();
    }

    public int checkAmountToCompare() {
        return prodAmountCompare.size();
    }

    private String getFirstOldPrice() {
        return fOldPrice.getText().replaceAll("\\s+", "");
    }

    private String getSecondOldPrice() {
        return sOldPrice.getText().replaceAll("\\s+", "");
    }

    private String getFirstAllPrice() {
        return fAllPrices.getText().replaceAll("\\s+", "");
    }

    private String getSecondAllPrice() {
        return sAllPrices.getText().replaceAll("\\s+", "");
    }

    public String getFirstPriceToCompareStr() {
        return getFirstAllPrice().replace(getFirstOldPrice(), "").replaceAll("[^0-9]", "");
    }

    public String getSecondPriceToCompareStr() {
        return getSecondAllPrice().replace(getSecondOldPrice(), "").replaceAll("[^0-9]", "");
    }

}

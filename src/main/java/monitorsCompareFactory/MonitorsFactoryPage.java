package monitorsCompareFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MonitorsFactoryPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public MonitorsFactoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "input[formcontrolname=min]")
    public WebElement scrollToMin;
    @FindBy(css = "span.goods-tile__price-value")
    private List<WebElement> pricesList;
    @FindBy(xpath = "//span[@class = 'goods-tile__title']")
    private List<WebElement> prodList;

    public void compareMonitorPrices(String priceToCompare) throws Exception {
        List<WebElement> pricesListTemo = pricesList;
        for (int counter = 0; counter <= pricesList.size(); counter++) {
            String price = pricesList.get(counter).getText().replaceAll("[^\\d.]", "");
            if (counter == pricesList.size()) {
                throw new Exception("There is no monitor with the corresponding price.");
            }
            if (Integer.parseInt(price) < Integer.parseInt(priceToCompare)) {
                List<WebElement> prodListByPrices = prodList;
                prodListByPrices.get(counter).click();
                break;
            }
        }
    }
}




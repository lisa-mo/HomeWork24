package monitorsComparePages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MonitorsPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public MonitorsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
    }

    private By scrollToMin = By.cssSelector("input[formcontrolname=min]");
    private By pricesList = By.cssSelector("span.goods-tile__price-value");
    private By prodList = By.xpath("//span[@class = 'goods-tile__title']");

    public WebElement scrollToMinForWait() {
        return webDriver.findElement(scrollToMin);
    }

    private List<WebElement> getListOfMonitorPrices() {
        return webDriver.findElements(pricesList);
    }

    private List<WebElement> getFirstProdList() {
        return webDriver.findElements(prodList);
    }

    public void compareMonitorPrices(String priceToCompare) throws Exception {
        List<WebElement> pricesList = getListOfMonitorPrices();
        for (int counter = 0; counter <= pricesList.size(); counter++) {
            String price = pricesList.get(counter).getText().replaceAll("[^\\d.]", "");
            if (counter == pricesList.size()) {
                throw new Exception("There is no monitor with the corresponding price.");
            }
            if (Integer.parseInt(price) < Integer.parseInt(priceToCompare)) {
                List<WebElement> prodListByPrices = getFirstProdList();
                prodListByPrices.get(counter).click();
                break;
            }
        }
    }
}



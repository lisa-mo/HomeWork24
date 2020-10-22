package filtersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SamsungSearchResultPage {

    WebDriver webDriver;
    WebDriverWait wait;

    public SamsungSearchResultPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
    }

    private By showMoreProd = By.cssSelector("span.show-more__text");
    private By mobilesLink = By.cssSelector("a[href$='mobile-phones/c80003/producer=samsung/']");

    public void showMoreProdToWait() {
        wait.until(presenceOfElementLocated(showMoreProd));
    }

    public void waitForMobilesLink() {
        wait.until(presenceOfElementLocated(mobilesLink));
    }

    public void pressMobilesLink() {
        webDriver.findElement(mobilesLink).click();
    }
}

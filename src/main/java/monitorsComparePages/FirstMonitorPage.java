package monitorsComparePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class FirstMonitorPage {
    WebDriver webDriver;
    WebDriverWait wait;
    Actions action;

    public FirstMonitorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        this.action = new Actions(webDriver);

    }

    private By waitTab = By.cssSelector("a.tabs__link");
    private By compareButton = By.className("compare-button");
    public By compareCounter = By.xpath("//li[3]//*[@class='header-actions__button-counter']");
    private By numberOfCompareCounter = By.xpath("//span[@class='header-actions__button-counter']");
    private By firstMonitorPrice = By.cssSelector("p.product-prices__big.product-prices__big_color_red");
    private By firstMonitorTitle = By.cssSelector("h1.product__title");
    private By prodCodeWait = By.xpath("//span[@class='product__code-accent']");
    private By mainCompareButton = By.cssSelector("button.compare-button");
    private By scalesWait = By.xpath("//li[3]//*[@class='header-actions__button-counter']");
    private By seconIconNumber = By.xpath("//span[@class='header-actions__button-counter']");
    private By allAboutProduct = By.partialLinkText("се про товар");
    private By compareIcon = By.id("icon-header-compare");
    private By actCompareButton = By.className("header-actions__button-icon");
    private By compareLink = By.cssSelector("a.comparison-modal__link");

    public void tabForWait() {
        wait.until(presenceOfElementLocated(waitTab));
    }

    public WebElement scrollToTabForWait() {
        WebElement scrollTabWait = webDriver.findElement(waitTab);
        return scrollTabWait;
    }

    public void pressCompareButton() {
        webDriver.findElement(compareButton).click();
    }

    public void waitForCompareCounter() {
        wait.until(presenceOfElementLocated(compareCounter));
    }

    public void waitForNumberOfCompare() {
        wait.until(presenceOfElementLocated(numberOfCompareCounter));
    }

    public String checkNumberOfCompare() {
        return webDriver.findElement(numberOfCompareCounter).getText();
    }

    public String getFirstMonitorPrice() {
        return webDriver.findElement(firstMonitorPrice).getText().replaceAll("[^\\d.]", "");
    }

    public String getFirstMonitorTitle() {
        return webDriver.findElement(firstMonitorTitle).getText();
    }

    public WebElement scrollToProdCodeForWait() {
        return webDriver.findElement(prodCodeWait);
    }

    public void pressMainCompareButton() {
        webDriver.findElement(mainCompareButton).click();
    }

    public void waitForScales() {
        wait.until(presenceOfElementLocated(scalesWait));
    }

    public String secondIconCompare() {
        return webDriver.findElement(seconIconNumber).getText();
    }

    private WebElement getAllAboutProdToWait() {
        return webDriver.findElement(allAboutProduct);
    }

    public void hoverAllAboutProdToWait() {
        action.moveToElement(getAllAboutProdToWait()).build().perform();
    }

    public void waitForCompareIcon() {
        wait.until(presenceOfElementLocated(compareIcon));
    }

    public void pressToCompare() {
        webDriver.findElement(actCompareButton).click();
    }

    public void waitForCompareLink() {
        wait.until(ExpectedConditions.elementToBeClickable(compareLink));
    }

    public void pressCompareLink() {
        webDriver.findElement(compareLink).click();
    }

}


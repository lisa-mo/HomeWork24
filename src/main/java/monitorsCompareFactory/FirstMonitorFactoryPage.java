package monitorsCompareFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class FirstMonitorFactoryPage {
    WebDriver webDriver;
    WebDriverWait wait;
    Actions action;

    public FirstMonitorFactoryPage(WebDriver webDriver) {


        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        this.action = new Actions(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "a.tabs__link")
    public WebElement waitTab;
    @FindBy(className = "compare-button")
    private WebElement compareButton;
    @FindBy(xpath = "//li[3]//*[@class='header-actions__button-counter']")
    public WebElement compareCounter;
    @FindBy(xpath = "//span[@class='header-actions__button-counter']")
    private WebElement numberOfCompareCounter;
    @FindBy(css = "p.product-prices__big.product-prices__big_color_red")
    private WebElement firstMonitorPrice;
    @FindBy(css = "h1.product__title")
    private WebElement firstMonitorTitle;
    @FindBy(xpath = "//span[@class='product__code-accent']")
    public WebElement prodCodeWait;
    @FindBy(css = "button.compare-button")
    private WebElement mainCompareButton;
    @FindBy(xpath = "//li[3]//*[@class='header-actions__button-counter']")
    private WebElement scalesWait;
    @FindBy(xpath = "//span[@class='header-actions__button-counter']")
    private WebElement seconIconNumber;
    @FindBy(partialLinkText = "се про товар")
    private WebElement allAboutProduct;
    @FindBy(css = "i.header-actions__button-icon")
    private WebElement compareIcon;
    @FindBy(className = "header-actions__button-icon")
    private WebElement actCompareButton;
    @FindBy(css = "a.comparison-modal__link")
    private WebElement compareLink;

    public void tabForWait() {
        wait.until(visibilityOf(waitTab));
    }

    public void pressCompareButton() {
        compareButton.click();
    }

    public void waitForCompareCounter() {
        wait.until(visibilityOf(compareCounter));
    }

    public void waitForNumberOfCompare() {
        wait.until(visibilityOf(numberOfCompareCounter));
    }

    public String checkNumberOfCompare() {
        return numberOfCompareCounter.getText();
    }

    public String getFirstMonitorPrice() {
        return firstMonitorPrice.getText().replaceAll("[^\\d.]", "");
    }

    public String getFirstMonitorTitle() {
        return firstMonitorTitle.getText();
    }

    public void pressMainCompareButton() {
        mainCompareButton.click();
    }

    public void waitForScales() {
        wait.until(visibilityOf(scalesWait));
    }

    public String secondIconCompare() {
        return seconIconNumber.getText();
    }

    public void hoverAllAboutProdToWait() {
        action.moveToElement(allAboutProduct).build().perform();
    }

    public void waitForCompareIcon() {
        wait.until(visibilityOf(compareIcon));
    }

    public void pressToCompare() {
        actCompareButton.click();
    }

    public void waitForCompareLink() {
        wait.until(ExpectedConditions.elementToBeClickable(compareLink));
    }

    public void pressCompareLink() {
        compareLink.click();
    }

}

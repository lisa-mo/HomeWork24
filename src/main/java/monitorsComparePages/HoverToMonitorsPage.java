package monitorsComparePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HoverToMonitorsPage {
    WebDriver webDriver;
    WebDriverWait wait;
    Actions action;

    public HoverToMonitorsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        this.action = new Actions(webDriver);
    }

    private By laptopPcLink = By.cssSelector("a[class='menu-categories__link'][href$='computers-notebooks/c80253/']");
    private By monitorsLink = By.cssSelector("a[class='menu__link'][href$='monitors/c80089/']");

    private WebElement getlaptopPcLink() {
        WebElement tolaptopPcLink = webDriver.findElement(laptopPcLink);
        return tolaptopPcLink;
    }

    public void hoverlaptopPcLink() {
        action.moveToElement(getlaptopPcLink()).build().perform();
    }

    public void waitForMonitorsLink() {
        wait.until(presenceOfElementLocated(monitorsLink));
    }

    public void waitForMonitorsLinkClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(monitorsLink));
    }

    public void pressMonitorsLink() {
        webDriver.findElement(monitorsLink).click();
    }
}

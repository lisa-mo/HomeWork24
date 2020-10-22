package monitorsCompareFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HoverToMonitorsFactoryPage {
    WebDriver webDriver;
    WebDriverWait wait;
    Actions action;

    public HoverToMonitorsFactoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        this.action = new Actions(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "a[class='menu-categories__link'][href$='computers-notebooks/c80253/']")
    private WebElement laptopPcLink;
    @FindBy(css = "a[class='menu__link'][href$='monitors/c80089/']")
    private WebElement monitorsLink;

    public void hoverlaptopPcLink() {
        action.moveToElement(laptopPcLink).build().perform();
    }

    public void waitForMonitorsLink() {
        wait.until(visibilityOf(monitorsLink));
    }

    public void waitForMonitorsLinkClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(monitorsLink));
    }

    public void pressMonitorsLink() {
        monitorsLink.click();
    }
}

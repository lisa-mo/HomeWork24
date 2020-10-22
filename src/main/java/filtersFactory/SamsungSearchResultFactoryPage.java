package filtersFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SamsungSearchResultFactoryPage {

    WebDriver webDriver;
    WebDriverWait wait;

    public SamsungSearchResultFactoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "span.show-more__text")
    private WebElement showMoreProd;
    @FindBy(css = "a[href$='mobile-phones/c80003/producer=samsung/']")
    private WebElement mobilesLink;

    public void showMoreProdToWait() {
        wait.until(visibilityOf(showMoreProd));
    }

    public void waitForMobilesLink() {
        wait.until(visibilityOf(mobilesLink));
    }

    public void pressMobilesLink() {
        mobilesLink.click();
    }
}

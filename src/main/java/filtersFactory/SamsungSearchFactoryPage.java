package filtersFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamsungSearchFactoryPage {
    WebDriver webDriver;


    public SamsungSearchFactoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(name = "search")
    private WebElement searchInput;

    public void doTheSearch(String searchText) {
        searchInput.sendKeys(searchText + Keys.ENTER);
    }
}

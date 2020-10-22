package filtersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SamsungSearchPage {
    WebDriver webDriver;


    public SamsungSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By searchInput = By.name("search");

    public void doTheSearch(String searchText) {
        webDriver.findElement(searchInput).sendKeys(searchText + Keys.ENTER);
    }
}

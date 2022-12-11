package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> searchResults = this.driver.findElements(By.xpath("//div[@class='goods-tile__inner']"));

    public boolean checkSearchResults() {
        return searchResults.isEmpty();
    }
}

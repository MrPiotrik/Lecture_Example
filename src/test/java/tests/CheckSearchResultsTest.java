package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class CheckSearchResultsTest extends BaseTest {
    @Test
    public void CheckSearchResultsTest() {
        Assert.assertFalse(new HomePage(this.driver).enterInSearchField().clickOnSearchButton().checkSearchResults());
    }
}

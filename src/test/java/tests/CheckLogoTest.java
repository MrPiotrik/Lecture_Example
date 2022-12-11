package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class CheckLogoTest extends BaseTest {
    @Test
    public void CheckLogoTest() {
        Assert.assertTrue(new HomePage(this.driver).hasLogo());
    }
}

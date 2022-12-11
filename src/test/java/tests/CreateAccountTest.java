package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class CreateAccountTest extends BaseTest {
    private static final String MESSAGE = "Для реєстрації введіть код підтвердження із SMS або Viber, надісланого на номер";

    @Test
    public void createAccountTest() {
        String actualMassage = new HomePage(driver)
                .clickOnLoginButton()
                .clickOnSignUpButton()
                .writeYourFirstName()
                .writeYourLastName()
                .writeYourTelephoneNumber()
                .writeYourEmail()
                .createYourPassword()
                .getActualMassage();
        Assert.assertTrue(actualMassage.contains(MESSAGE));
    }
}

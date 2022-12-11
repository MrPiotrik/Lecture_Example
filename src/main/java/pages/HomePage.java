package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.StringUtils;

public class HomePage extends BasePage {
    private static final String USER_NAME = "Петро";
    private static final String USER_SURNAME = "Щеснюк";
    private static final String USER_TELEPHONE_NUMBER = "661234590";
    private static final int LENGTH_OF_EMAIL = 8;
    private static final String USER_EMAIL = StringUtils.generateRandomEmail(LENGTH_OF_EMAIL);
    private static final String USER_PASSWORD = "123456789A";
    private static final String textVisible = "Для реєстрації введіть код підтвердження із SMS або Viber, надісланого на номер";

    private static final String TEXT_SEARCH = "Ноутбук";
    private static final String SEARCH_RESULTS_URL = "https://rozetka.com.ua/ua/notebooks/c80004/#search_text=%D0%BD%D0%BE%D1%83%D1%82%D0%B1%D1%83%D0%BA";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//rz-user/button[@class='header__button ng-star-inserted']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(), 'Зареєструватися')]")
    private WebElement signUpButton;

    @FindBy(xpath = "//input[@id='registerUserName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='registerUserSurname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='registerUserPhone']")
    private WebElement telephoneNumber;

    @FindBy(xpath = "//input[@id='registerUserEmail']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='registerUserPassword']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='modal__content']")
    private WebElement logInPopUp;

    @FindBy(xpath = "//h2[contains(text(),'Для реєстрації введіть код підтвердження із SMS або Viber, надісланого на номер')]")
    private WebElement actualText;
    @FindBy(xpath = "//img[@alt='Rozetka Logo']")
    private WebElement logo;
    @FindBy(xpath = "//input[@placeholder='Я шукаю...']")
    private WebElement searchField;
    @FindBy(xpath = "//button[contains(text(),'Знайти')]")
    private WebElement searchButton;

    public HomePage clickOnLoginButton() {
        waitForElementToAppear(loginButton);
        loginButton.click();
        return this;
    }

    public HomePage clickOnSignUpButton() {
        waitForElementToAppear(signUpButton);
        signUpButton.click();
        return this;
    }

    public HomePage writeYourFirstName() {
        waitForElementToAppear(firstNameField);
        firstNameField.sendKeys(USER_NAME);
        return this;
    }

    public HomePage writeYourLastName() {
        waitForElementToAppear(lastNameField);
        lastNameField.sendKeys(USER_SURNAME);
        return this;
    }

    public HomePage writeYourTelephoneNumber() {
        waitForElementToAppear(telephoneNumber);
        telephoneNumber.sendKeys(USER_TELEPHONE_NUMBER);
        return this;
    }

    public HomePage writeYourEmail() {
        waitForElementToAppear(emailField);
        emailField.sendKeys(USER_EMAIL);
        return this;
    }

    public HomePage createYourPassword() {
        passwordField.sendKeys(USER_PASSWORD);
        implicitWait();
        submitButton.click();
        implicitWait();
        return this;
    }

    public String getActualMassage() {
        waitForElementToAppear(logInPopUp);
        implicitWait();
        waitForTextVisibility(actualText, textVisible);
        return actualText.getText();
    }

    public boolean hasLogo() {
        return logo.isDisplayed();
    }

    public HomePage enterInSearchField() {
        searchField.sendKeys(TEXT_SEARCH);
        return this;
    }

    public SearchResultsPage clickOnSearchButton() {
        searchButton.click();
        //driver.navigate().to(SEARCH_RESULTS_URL);
        implicitWait();
        return new SearchResultsPage(driver);
    }
}
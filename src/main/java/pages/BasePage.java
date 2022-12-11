package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final int TIME = 10;
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME));
        PageFactory.initElements(driver,this);
    }

    protected void waitForTextVisibility(WebElement element, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
    protected void waitToURLToBe(String URL){
        wait.until(ExpectedConditions.urlToBe(URL));
    }
    protected void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME));
    }
}
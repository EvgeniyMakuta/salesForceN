package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT_LOCATOR = By.id("username");
    private static final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private static final By LOGIN_BTN_LOCATOR = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage openPage() {
        driver.get(LOGIN_URL);
        return this;
    }

    @Override
    public LoginPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BTN_LOCATOR));
        } catch (TimeoutException e) {
            fail("Login Page is not loaded. locator: " + LOGIN_BTN_LOCATOR + " is not found");
        }
        return this;
    }

    public HomePage login(String username, String password) {
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(username);
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        driver.findElement(LOGIN_BTN_LOCATOR).click();
        return new HomePage(driver);
    }
}

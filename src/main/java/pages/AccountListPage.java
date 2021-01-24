package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class AccountListPage extends BasePage {

    public static final By NEW_BTN_LOCATOR = By.cssSelector("[title=New]");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountListPage openPage() {
        driver.get(BASE_URL + ACCOUNT_ENDPOINT);
        return this;
    }

    @Override
    public AccountListPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BTN_LOCATOR));
        } catch (TimeoutException e) {
            fail("AccountList Page is not loaded. locator: " + NEW_BTN_LOCATOR + " is not found");
        }
        return this;
    }

    public NewAccountModal clickNewBtn() {
        driver.findElement(NEW_BTN_LOCATOR).click();
        return new NewAccountModal(driver);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class AccountDetailsPage extends BasePage {
    public static final By DETAILS_TAB = By.xpath("//*[@title='Details']");
    public static final By IS_TAB_OPENED_LOCATOR = By.xpath("//*[contains(text(), 'Industry')]");
    String accountDetails = "//*[contains(text(), '%s')]/ancestor::div[contains(@class, 'slds-form-element')]//slot[@slot='outputField']";

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountDetailsPage openPage() {
        return this;
    }

    @Override
    public AccountDetailsPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_TAB));
        } catch (TimeoutException e) {
            fail("AccountList Page is not loaded. locator: " + DETAILS_TAB + " is not found");
        }
        return this;
    }

    public AccountDetailsPage waitForTabOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(IS_TAB_OPENED_LOCATOR));
        return this;
    }

    public AccountDetailsPage openDetailsTab() {
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    public String getAccountDetails(String text) {
        return driver.findElement(By.xpath(String.format(accountDetails, text))).getText();
    }
}

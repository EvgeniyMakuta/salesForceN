package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class AccountDetailsPage extends BasePage {
    private static final By DETAILS_TAB_XPATH = By.xpath("//*[@title='Details']");
    private static final By OPENED_TAB_XPATH = By.xpath("//*[contains(text(), 'Industry')]");
    private static final String ACCOUNT_DETAILS_XPATH = "//*[contains(text(), '%s')]/ancestor::div[contains(@class, 'slds-form-element')]//slot[@slot='outputField']";

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
            wait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_TAB_XPATH));
        } catch (TimeoutException e) {
            fail("AccountList Page is not loaded. locator: " + DETAILS_TAB_XPATH + " is not found");
        }
        return this;
    }

    public AccountDetailsPage waitForTabOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OPENED_TAB_XPATH));
        return this;
    }

    public AccountDetailsPage openDetailsTab() {
        driver.findElement(DETAILS_TAB_XPATH).click();
        return this;
    }

    public String getAccountDetails(String text) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_DETAILS_XPATH, text))).getText();
    }
}

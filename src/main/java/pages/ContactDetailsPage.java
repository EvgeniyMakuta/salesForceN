package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class ContactDetailsPage extends BasePage {
    public static final By IS_TAB_OPENED_LOCATOR = By.xpath("//*[contains(text(), 'Department')]");
    public static final By DETAILS_TAB = By.xpath("//*[@title='Details']");
    String contactDetails = "//*[contains(text(), '%s')]/ancestor::div[contains(@class, 'slds-form-element')]//slot[@slot='outputField']";

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactDetailsPage openPage() {
        return this;
    }

    @Override
    public ContactDetailsPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(IS_TAB_OPENED_LOCATOR));
        } catch (TimeoutException e) {
            fail("AccountList Page is not loaded. locator: " + IS_TAB_OPENED_LOCATOR + " is not found");
        }
        return this;
    }

    public ContactDetailsPage waitForTabOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(IS_TAB_OPENED_LOCATOR));
        return this;
    }

    public ContactDetailsPage openDetailsTab() {
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    public String getAccountDetails(String text) {
        return driver.findElement(By.xpath(String.format(contactDetails, text))).getText();
    }
}

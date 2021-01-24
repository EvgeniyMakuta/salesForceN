package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class ContactsListPage extends BasePage {
    public static final By NEW_BTN_LOCATOR = By.cssSelector("[title=New]");

    public ContactsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactsListPage openPage() {
        driver.get(BASE_URL + CONTACT_ENDPOINT);
        return this;
    }

    @Override
    public ContactsListPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BTN_LOCATOR));
        } catch (TimeoutException e) {
            fail("ContactsList Page is not loaded. locator: " + NEW_BTN_LOCATOR + " is not found");
        }
        return this;
    }

    public NewContactModal clickNew() {
        driver.findElement(NEW_BTN_LOCATOR).click();
        return new NewContactModal(driver);
    }
}

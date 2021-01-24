package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import objects.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class NewAccountModal extends BasePage {
    public static final By SAVE_BTN_LOCATOR = By.cssSelector("[title=Save]");
    public static final By CANCEL_BUTTON_LOCATOR = By.cssSelector("[title=Cancel]");
    public static final By SAVE_NEW_BUTTON_LOCATOR = By.cssSelector("[title='Save & New']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewAccountModal openPage() {
        driver.get(BASE_URL + ACCOUNT_MODAL_ENDPOINT);
        return this;
    }

    @Override
    public NewAccountModal waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BTN_LOCATOR));
        } catch (TimeoutException e) {
            fail("AccountModal Page is not loaded. locator: " + SAVE_BTN_LOCATOR + " is not found");
        }
        return this;
    }

    public AccountDetailsPage create(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Website").write(account.getWebsite());
        new DropDown(driver, "Type").select(account.getType());
        new TextArea(driver, "Description").write(account.getDescription());
        new Input(driver, "Phone").write(account.getPhone());
        new DropDown(driver, "Industry").select(account.getIndustry());
        new Input(driver, "Employees").write(String.valueOf(account.getEmployees()));
        clickSaveBtn();
        return new AccountDetailsPage(driver);
    }

    public AccountDetailsPage clickSaveBtn() {
        driver.findElement(SAVE_BTN_LOCATOR).click();
        return new AccountDetailsPage(driver);
    }
}

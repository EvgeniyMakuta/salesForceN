package pages;

import elements.DropDown;
import elements.Input;
import elements.InputWithSearch;
import objects.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class NewContactModal extends BasePage {
    private static final By SAVE_BTN_CSS = By.cssSelector("[title=Save]");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewContactModal openPage() {
        driver.get(BASE_URL + CONTACT_MODAL_ENDPOINT);
        return this;
    }

    @Override
    public NewContactModal waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BTN_CSS));
        } catch (TimeoutException e) {
            fail("AccountModal Page is not loaded. locator: " + SAVE_BTN_CSS + " is not found");
        }
        return this;
    }

    public ContactDetailsPage clickSave() {
        driver.findElement(SAVE_BTN_CSS).click();
        return new ContactDetailsPage(driver);
    }

    public ContactDetailsPage create(Contact contact) {
        new DropDown(driver, "Salutation").select(contact.getSalutation());
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Middle Name").write(contact.getMiddleName());
        new Input(driver, "Last Name").write(contact.getLastName());
        new Input(driver, "Suffix").write(contact.getSuffix());
        new InputWithSearch(driver, "Account Name").inputAndSearch(contact.getAccountName());
        new Input(driver, "Title").write(contact.getTitle());
        new Input(driver, "Email").write(contact.getEmail());
        new Input(driver, "Phone").write(contact.getPhone());
        new Input(driver, "Mobile").write(contact.getMobile());
        new Input(driver, "Fax").write(contact.getFax());
        new Input(driver, "Department").write(contact.getDepartment());
        clickSave();
        return new ContactDetailsPage(driver);
    }
}

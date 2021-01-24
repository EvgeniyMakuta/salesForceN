package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class HomePage extends BasePage {
    public static final By REFRESH_BTN_LOCATOR = By.cssSelector("[title='Refresh Chart']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage() {
        driver.get(BASE_URL + HOME_ENDPOINT);
        return this;
    }

    @Override
    public HomePage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(REFRESH_BTN_LOCATOR));
        } catch (TimeoutException e) {
            fail("Home page is not loaded. Locator " + REFRESH_BTN_LOCATOR + " is not found");
        }
        return this;
    }

    public boolean isPageOpened() {
        return driver.findElement(REFRESH_BTN_LOCATOR).isDisplayed();
    }
}

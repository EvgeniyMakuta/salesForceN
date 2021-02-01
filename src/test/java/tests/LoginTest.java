package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static pages.HomePage.REFRESH_BTN_LOCATOR;

public class LoginTest extends BaseTest {

    @Test(description = "Input valid credentials to Login")
    public void LoginShouldBeSuccessful() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForPageOpened();
        assertTrue(homePage.isPageOpened(), "Home Page is not open. Locator: " + REFRESH_BTN_LOCATOR + " is not found");
    }
}

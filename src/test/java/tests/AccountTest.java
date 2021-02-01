package tests;

import objects.ActualAccount;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AccountTest extends BaseTest {
    ActualAccount actualAccount;

    @Test
    public void createAccount() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForPageOpened();
        accountListPage.openPage()
                .waitForPageOpened()
                .clickNewBtn()
                .waitForPageOpened()
                .create(account)
                .waitForPageOpened()
                .openDetailsTab()
                .waitForTabOpened();
        String accountNameActual = accountDetailsPage.getAccountDetails("Account Name");
        String typeActual = accountDetailsPage.getAccountDetails("Type");
        String descriptionActual = accountDetailsPage.getAccountDetails("Description");
        String employeesActualStr = accountDetailsPage.getAccountDetails("Employees");
        Integer employeesActual = Integer.parseInt(employeesActualStr);
        String industryActual = accountDetailsPage.getAccountDetails("Industry");
        String phoneActual = accountDetailsPage.getAccountDetails("Phone");
        String websiteActual = accountDetailsPage.getAccountDetails("Website");
        assertEquals(accountNameActual, account.getAccountName(), account.getAccountName() + " should be displayed");
        assertEquals(typeActual, account.getType(), account.getType() + " should be displayed");
        assertEquals(employeesActual, account.getEmployees(), account.getEmployees() + " should be displayed");
        assertEquals(descriptionActual, account.getDescription(), account.getDescription() + " should be displayed");
        assertEquals(industryActual, account.getIndustry(), account.getIndustry() + " should be displayed");
        assertEquals(phoneActual, PHONE_DATA_FORMAT, PHONE_DATA_FORMAT + " should be displayed");
        assertEquals(websiteActual, WEBSITE_DATA, WEBSITE_DATA + " should be displayed");
    }
}

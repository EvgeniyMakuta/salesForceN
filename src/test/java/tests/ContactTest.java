package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactTest extends BaseTest {

    @Test
    public void createContact() {
        loginPage.openPage()
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .waitForPageOpened();
        contactsListPage.openPage()
                .waitForPageOpened()
                .clickNewButton()
                .waitForPageOpened()
                .create(contact)
                .waitForPageOpened()
                .openDetailsTab()
                .waitForTabOpened();
        String nameActual = contactDetailsPage.getAccountDetails("Name");
        String titleActual = contactDetailsPage.getAccountDetails("Title");
        String emailActual = contactDetailsPage.getAccountDetails("Email");
        String phoneActual = contactDetailsPage.getAccountDetails("Phone");
        String mobileActual = contactDetailsPage.getAccountDetails("Mobile");
        String departmentActual = contactDetailsPage.getAccountDetails("Department");
        String faxActual = contactDetailsPage.getAccountDetails("Fax");
        String nameExpected = contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getMiddleName() + " " + contact.getLastName() + " " + contact.getSuffix();
        assertEquals(nameActual, nameExpected, nameExpected + " should be displayed");
        assertEquals(titleActual, contact.getTitle(), contact.getTitle() + " should be displayed");
        assertEquals(emailActual, contact.getEmail(), contact.getEmail() + " should be displayed");
        assertEquals(phoneActual, PHONE_DATA_FORMAT, PHONE_DATA_FORMAT + " should be displayed");
        assertEquals(mobileActual, MOBILE_DATA_FORMAT, MOBILE_DATA_FORMAT + " should be displayed");
        assertEquals(departmentActual, contact.getDepartment(), contact.getDepartment() + " should be displayed");
        assertEquals(faxActual, contact.getFax(), contact.getFax() + " should be displayed");
    }
}

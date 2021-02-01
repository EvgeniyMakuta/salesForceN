package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.Account;
import objects.Contact;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import test_data.TestConstants;

import java.util.concurrent.TimeUnit;

public class BaseTest implements TestConstants {
    WebDriver driver;
    ChromeOptions options;
    LoginPage loginPage;
    HomePage homePage;
    AccountDetailsPage accountDetailsPage;
    AccountListPage accountListPage;
    NewAccountModal newAccountModal;
    ContactDetailsPage contactDetailsPage;
    ContactsListPage contactsListPage;
    NewContactModal newContactModal;
    Account account;
    Contact contact;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountListPage = new AccountListPage(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
        contactsListPage = new ContactsListPage(driver);
        newAccountModal = new NewAccountModal(driver);
        newContactModal = new NewContactModal(driver);
        account = new Account.Builder()
                .setAccountName(ACCOUNT_NAME_DATA)
                .setWebsite(WEBSITE_DATA)
                .setType(TYPE_DATA)
                .setDescription(DESCRIPTION_DATA)
                .setPhone(PHONE_DATA)
                .setEmployees(EMPLOYEES_DATA)
                .setIndustry(INDUSTRY_DATA)
                .build();
        contact = new Contact.Builder()
                .setSalutation(SALUTATION_DATA)
                .setFirstName(FIRST_NAME_DATA)
                .setLastName(LAST_NAME_DATA)
                .setMiddleName(MIDDLE_NAME_DATA)
                .setSuffix(SUFFIX_DATA)
                .setAccountName(ACCOUNT_NAME_DATA)
                .setDepartment(DEPARTMENT_DATA)
                .setEmail(EMAIL_DATA)
                .setFax(FAX_DATA)
                .setMobile(MOBILE_DATA)
                .setPhone(PHONE_DATA)
                .setTitle(TITLE_DATA)
                .build();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

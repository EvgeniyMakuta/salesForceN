package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputWithSearch extends BaseElement {
   private static final String INPUT_AND_SEARCH_XPATH = "//*[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInput')]//input";
    private static final String OPTION_INPUT_AND_SEARCH_XPATH = "//*[@role='option']/descendant::div[@title='%s']";
    private static final String SEARCH_XPATH = "//*[contains(text(), '%s')]/ancestor::div[contains(@class, 'slds-form-element__control')]//button";
    private static final String SEARCH_ADDRESS_INPUT_XPATH = "//*[contains(text(), '%s)]/ancestor::div[contains(@class, 'modal-container')]//input";
    private static final String OPTION_SEARCH_ADDRESS_XPATH = "//*[@class='option']";

    public InputWithSearch(WebDriver driver, String label) {
        super(driver, label);
    }

    public InputWithSearch inputAndSearch(String option) {
        writeActionMsg(label);
        waitForElementVisible(INPUT_AND_SEARCH_XPATH, label);
        getSearchInput(INPUT_AND_SEARCH_XPATH, label).sendKeys(option);
        waitForElementVisible(OPTION_INPUT_AND_SEARCH_XPATH, option);
        getSearchInput(OPTION_INPUT_AND_SEARCH_XPATH, option).click();
        return this;
    }

    public InputWithSearch search(String option) {
        writeActionMsg(label);
        getSearchInput(SEARCH_XPATH, label).click();
        waitForElementVisible(SEARCH_ADDRESS_INPUT_XPATH, label);
        getSearchInput(SEARCH_ADDRESS_INPUT_XPATH, label).sendKeys(option);
        waitForElementVisible(OPTION_SEARCH_ADDRESS_XPATH, label);
        driver.findElements(By.xpath(OPTION_SEARCH_ADDRESS_XPATH)).get(0).click();
        return this;
    }

    public WebElement getSearchInput(String locator, String inputWithSearchName) {
        return driver.findElement(By.xpath(String.format(locator, inputWithSearchName)));
    }
}

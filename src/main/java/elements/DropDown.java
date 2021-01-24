package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown extends BaseElement {
    String dropDownLocator = "//*[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInputSelect')]//a";
    String optionLocator = "//*[@class='select-options']/descendant::a[contains(text(),'%s')]";

    public DropDown(WebDriver driver, String label) {
        super(driver, label);
    }

    public DropDown select(String option) {
        writeActionMsg(option);
        driver.findElement(By.xpath(String.format(dropDownLocator, label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
        return this;
    }
}

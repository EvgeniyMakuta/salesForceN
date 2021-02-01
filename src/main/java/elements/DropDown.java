package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown extends BaseElement {
   private static final String DROP_DOWN_XPATH = "//*[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInputSelect')]//a";
   private static final String OPTION_XPATH = "//*[@class='select-options']/descendant::a[contains(text(),'%s')]";

    public DropDown(WebDriver driver, String label) {
        super(driver, label);
    }

    public DropDown select(String option) {
        writeActionMsg(option);
        driver.findElement(By.xpath(String.format(DROP_DOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(OPTION_XPATH, option))).click();
        return this;
    }
}

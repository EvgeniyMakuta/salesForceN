package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input extends BaseElement {
   private static final String INPUT_XPATH = "//*[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInput')]//input";

    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public Input write(String text) {
        writeActionMsg(text);
        driver.findElement(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(text);
        return this;
    }
}

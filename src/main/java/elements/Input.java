package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input extends BaseElement {
    String inputLocator = "//*[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInput')]//input";

    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public Input write(String text) {
        writeActionMsg(text);
        driver.findElement(By.xpath(String.format(inputLocator, label))).sendKeys(text);
        return this;
    }
}

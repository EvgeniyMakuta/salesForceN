package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea extends BaseElement {
    String textAreaLocator = "//*[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInput')]//textarea";

    public TextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public TextArea write(String text) {
        writeActionMsg(text);
        driver.findElement(By.xpath(String.format(textAreaLocator, label))).sendKeys(text);
        return this;
    }
}

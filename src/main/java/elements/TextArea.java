package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea extends BaseElement {
   private static final String TEXT_AREA_XPATH = "//*[contains(text(),'%s')]/ancestor::div[contains(@class, 'uiInput')]//textarea";

    public TextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public TextArea write(String text) {
        writeActionMsg(text);
        driver.findElement(By.xpath(String.format(TEXT_AREA_XPATH, label))).sendKeys(text);
        return this;
    }
}

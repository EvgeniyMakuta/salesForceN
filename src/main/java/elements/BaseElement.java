package elements;

import base.Waiter;
import org.openqa.selenium.WebDriver;

public class BaseElement extends Waiter {
    public String label;
    WebDriver driver;

    public BaseElement(WebDriver driver, String label) {
        super(driver);
        this.driver = driver;
        this.label = label;
    }

    public BaseElement writeActionMsg(String text) {
        System.out.println(String.format("Writing text: '%s' with label: '%s' ", text, label));
        return this;
    }
}

package base;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Waiter {
    WebDriver driver;
    WebDriverWait wait;

    public Waiter(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public void sleep(int number) {
        try {
            Thread.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waiter(String locator, String label) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(locator, label))));
        } catch (TimeoutException e) {
            Assert.fail(label + " is not visible/opened");
        }
    }

    public void waiter(By by, int time, String errorMessage) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            Assert.fail(errorMessage);
        }
    }
}

package pages;

import org.openqa.selenium.*;
import org.junit.Assert;

public class ConfirmationPage {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyConfirmation() {
        String message = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals("THANK YOU FOR YOUR ORDER", message);
    }
}

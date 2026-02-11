package pages;

import org.openqa.selenium.*;
import org.junit.Assert;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyItem(String item) {
        Assert.assertTrue(driver.getPageSource().contains(item));
    }

    public void checkout() {
        driver.findElement(By.id("checkout")).click();
    }
}

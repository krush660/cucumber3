package pages;

import org.openqa.selenium.*;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct(String productName) {
        driver.findElement(By.xpath("//div[text()='"+productName+"']/ancestor::div[@class='inventory_item']//button")).click();
    }

    public void clickCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}

package stepdefinition;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.*;
import utils.ConfigReader;

public class PurchaseSteps {

    WebDriver driver = Hooks.driver;

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ConfirmationPage confirmationPage;

    @Given("the user navigates to the SauceDemo login page")
    public void navigate_to_login_page() {

        driver = Hooks.driver;
        loginPage = new LoginPage(driver);
    }

    @When("the user logs in with valid credentials")
    public void login_with_valid_credentials() {

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));
    }

    @And("the user adds {string} and {string} to the cart")
    public void add_products(String product1, String product2) {

        productsPage = new ProductsPage(driver);
        productsPage.addProduct(product1);
        productsPage.addProduct(product2);
        productsPage.clickCart();
    }

    @And("the user verifies the items in the cart")
    public void verify_cart_items() {

        cartPage = new CartPage(driver);
        cartPage.verifyItem("Sauce Labs Backpack");
        cartPage.verifyItem("Sauce Labs Bolt T-Shirt");
    }

    @And("the user proceeds to checkout")
    public void proceed_checkout() {

        cartPage.checkout();
    }

    @And("the user enters checkout details {string} {string} {string}")
    public void enter_checkout_details(String fname, String lname, String zip) {

        checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterDetails(fname, lname, zip);
    }

    @And("the user completes the purchase")
    public void complete_purchase() {

        checkoutPage.finish();
    }

    @Then("the user should see the order confirmation message")
    public void verify_confirmation() {

        confirmationPage = new ConfirmationPage(driver);
        confirmationPage.verifyConfirmation();
    }
}

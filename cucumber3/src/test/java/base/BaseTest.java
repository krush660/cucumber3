package base;

import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    public void setup() {
        driver = DriverFactory.initDriver(ConfigReader.getProperty("browser"));
        driver.get(ConfigReader.getProperty("url"));
    }

    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

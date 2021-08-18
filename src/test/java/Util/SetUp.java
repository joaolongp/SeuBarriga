package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {

    private WebDriver driver;

    private static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    private void setupTest() {
        driver = new ChromeDriver();
    }

    public WebDriver getWebDriver(){
        setupClass();
        setupTest();
        return driver;
    }
}

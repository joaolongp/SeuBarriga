package Test;

import Util.SetUp;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected final static WebDriver driver = new SetUp().getWebDriver();

    @BeforeClass
    public static void startUp() {
        driver.get("https://seubarriga.wcaquino.me/");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

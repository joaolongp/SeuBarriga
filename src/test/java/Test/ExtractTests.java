package Test;

import PageObjects.Extract;
import PageObjects.Home;
import PageObjects.Login;
import Pages.LoginPage;
import Util.SetUp;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ExtractTests {

    private static WebDriver driver = new SetUp().getWebDriver();
    private Extract screen = new Extract(driver);

    @BeforeClass
    public static void startUp(){
        driver.get("https://seubarriga.wcaquino.me/");
        new LoginPage(driver).signIn("test@mail.com", "test");
        new Home(driver).monthlyReview();
    }

    @Test
    public void validateExtratoTest(){
        screen.setMonth("07");
        screen.setYear("2020");
        screen.searchButton();
        Assert.assertEquals("test",screen.getItemByIndex(0,0).getText());
        Assert.assertEquals("01/07/2020",screen.getItemByIndex(0,1).getText());
        Assert.assertEquals("Parci",screen.getItemByIndex(0,2).getText());
        Assert.assertEquals("200.00",screen.getItemByIndex(0,3).getText());
        Assert.assertEquals("Pago",screen.getItemByIndex(0,4).getText());
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

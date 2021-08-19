package UnitTests;

import PageObjects.ExtratoScreen;
import PageObjects.HomeScreen;
import PageObjects.LoginScreen;
import Util.SetUp;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ExtratoScreenTests {

    private static WebDriver driver = new SetUp().getWebDriver();
    private ExtratoScreen screen = new ExtratoScreen(driver);

    @BeforeClass
    public static void startUp(){
        driver.get("https://seubarriga.wcaquino.me/");
        new LoginScreen(driver).Do();
        new HomeScreen(driver).resumoMensal();
    }

    @Test
    public void validateExtratoTest(){
        screen.setMes("07");
        screen.setAno("2020");
        screen.buscarButton();
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

package Test.AccountScreens;

import PageObjects.AccountScreens.EditAccountScreen;
import PageObjects.HomeScreen;
import PageObjects.AccountScreens.ListAccountScreen;
import PageObjects.LoginScreen;
import Util.SetUp;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountScreenTest {

    private static WebDriver driver = new SetUp().getWebDriver();
    private EditAccountScreen screen = new EditAccountScreen(driver);

    @BeforeClass
    public static void startUp(){
        driver.get("https://seubarriga.wcaquino.me/");
        new LoginScreen(driver).Do();
        new HomeScreen(driver).listAccounts();
    }

    @Test
    public void editAccountTest(){
        new ListAccountScreen(driver).editAccount(0);
        screen.setName("Neymar");
        screen.saveButton();
        Assert.assertEquals("Conta alterada com sucesso!", driver.findElement(By.cssSelector("body > div.alert.alert-success")).getText());
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

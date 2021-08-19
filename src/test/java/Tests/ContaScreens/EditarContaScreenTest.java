package Tests.ContaScreens;

import PageObjects.ContaScreens.EditarContaScreen;
import PageObjects.HomeScreen;
import PageObjects.ContaScreens.ListaContaScreen;
import PageObjects.LoginScreen;
import Util.SetUp;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditarContaScreenTest {

    private static WebDriver driver = new SetUp().getWebDriver();
    private EditarContaScreen screen = new EditarContaScreen(driver);

    @BeforeClass
    public static void startUp(){
        driver.get("https://seubarriga.wcaquino.me/");
        new LoginScreen(driver).Do();
        new HomeScreen(driver).listaContas();
    }

    @Test
    public void editarContaTest(){
        new ListaContaScreen(driver).editarConta(0);
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

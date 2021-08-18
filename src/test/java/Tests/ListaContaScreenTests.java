package Tests;

import PageObjects.HomeScreen;

import PageObjects.ListaContaScreen;
import PageObjects.LoginScreen;
import Util.SetUp;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class ListaContaScreenTests {

    private static WebDriver driver = new SetUp().getWebDriver();
    private ListaContaScreen screen = new ListaContaScreen(driver);

    @BeforeClass
    public static void startUp(){
        driver.get("https://seubarriga.wcaquino.me/");
        new LoginScreen(driver).Do();
        new HomeScreen(driver).listaContas();
    }

    @Test
    public void listaNomesTest(){
        List<WebElement> nomes = screen.getContas();
        List<String> nomesString = new ArrayList<>();
        for (WebElement nome : nomes) {
            nomesString.add(nome.getText());
        }
        Assert.assertThat(nomesString, containsInAnyOrder("Menino Ney", "Parci"));
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

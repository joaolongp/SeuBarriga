package Tests.ContaScreens;

import PageObjects.HomeScreen;

import PageObjects.ContaScreens.ListaContaScreen;
import PageObjects.LoginScreen;
import Util.SetUp;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void excluirContaTest(){
        screen.excluirConta(0);
        Assert.assertEquals("Conta removida com sucesso!", driver.findElement(By.cssSelector("body > div.alert.alert-success")));
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

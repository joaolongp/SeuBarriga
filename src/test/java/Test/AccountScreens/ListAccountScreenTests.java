package Test.AccountScreens;

import PageObjects.HomeScreen;

import PageObjects.AccountScreens.ListAccountScreen;
import PageObjects.LoginScreen;
import Util.SetUp;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;

public class ListAccountScreenTests {

    private static WebDriver driver = new SetUp().getWebDriver();
    private ListAccountScreen screen = new ListAccountScreen(driver);

    @BeforeClass
    public static void startUp(){
        driver.get("https://seubarriga.wcaquino.me/");
        new LoginScreen(driver).Do();
        new HomeScreen(driver).listAccounts();
    }

    @Test
    public void listNamesTest(){
        List<WebElement> names = screen.getAccounts();
        List<String> namesString = new ArrayList<>();
        for (WebElement nome : names) {
            namesString.add(nome.getText());
        }
        Assert.assertThat(namesString, containsInAnyOrder("Menino Ney", "Parci"));
    }

    @Test
    public void removeAccountTest(){
        screen.removeAccount(0);
        Assert.assertEquals("Conta removida com sucesso!", driver.findElement(By.cssSelector("body > div.alert.alert-success")));
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

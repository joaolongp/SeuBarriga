package Test;

import PageObjects.HomeScreen;
import PageObjects.LoginScreen;
import PageObjects.MovimentationScreen;
import Util.SetUp;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovimentationScreenTests {

    private static WebDriver driver = new SetUp().getWebDriver();
    private MovimentationScreen screen = new MovimentationScreen(driver);

    @BeforeClass
    public static void startUp(){
        driver.get("https://seubarriga.wcaquino.me/");
        new LoginScreen(driver).Do();
        new HomeScreen(driver).createMovimentation();
    }

    @Test
    public void noInfoSaveTest(){
        screen.saveButton();
        for (String message : screen.errorMessagesList()) {
            Assert.assertTrue(screen.mandatoryFields.containsValue(message));
        }
    }

    @Test
    public void invalidValorTest(){
        screen.setDateTransaction("01/07/2020");
        screen.setDatePayment("01/07/2020");
        screen.setDesc("test");
        screen.setInterested("test");
        screen.setValor("abc");
        screen.setType("REC");
        screen.setAccount(0);
        screen.setSituation("status_pago");
        screen.saveButton();

        Assert.assertTrue(screen.errorMessagesList().contains(screen.mandatoryFields.get("caracterValor")));
    }

    @Test
    public void movimentacaoValidaTest(){
        screen.setDateTransaction("01/07/2020");
        screen.setDatePayment("01/07/2020");
        screen.setDesc("test");
        screen.setInterested("test");
        screen.setValor("200");
        screen.setType("REC");
        screen.setAccount(0);
        screen.setSituation("status_pago");
        screen.saveButton();

        Assert.assertEquals("Movimentação adicionada com sucesso!", driver.findElement(By.cssSelector(".alert.alert-success")).getText());
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

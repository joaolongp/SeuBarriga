package Test.UnitTest;

import PageObjects.HomeScreen;
import PageObjects.LoginScreen;
import PageObjects.MovimentacaoScreen;
import Util.SetUp;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovimentacaoScreenTests {

    private static WebDriver driver = new SetUp().getWebDriver();
    private MovimentacaoScreen screen = new MovimentacaoScreen(driver);

    @BeforeClass
    public static void startUp(){
        driver.get("https://seubarriga.wcaquino.me/");
        new LoginScreen(driver).Do();
        new HomeScreen(driver).criarMovimentacao();
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
        screen.setDataTransacao("01/07/2020");
        screen.setDataPgto("01/07/2020");
        screen.setDescricao("test");
        screen.setInteressado("test");
        screen.setValor("abc");
        screen.setTipo("REC");
        screen.setConta(0);
        screen.setSituacao("status_pago");
        screen.saveButton();

        Assert.assertTrue(screen.errorMessagesList().contains(screen.mandatoryFields.get("caracterValor")));
    }

    @Test
    public void movimentacaoValidaTest(){
        screen.setDataTransacao("01/07/2020");
        screen.setDataPgto("01/07/2020");
        screen.setDescricao("test");
        screen.setInteressado("test");
        screen.setValor("200");
        screen.setTipo("REC");
        screen.setConta(0);
        screen.setSituacao("status_pago");
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

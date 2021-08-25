package Test;

import Data.MovementMandatoryFields;
import PageObjects.Home;
import PageObjects.Login;
import PageObjects.Movement;
import Pages.AccountPages.AddAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MovementPage;
import Util.SetUp;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovementTests extends BaseTests{

    private MovementPage page = new MovementPage(driver);
    private MovementMandatoryFields data = new MovementMandatoryFields();

    @Before
    public void set(){
        new LoginPage(driver).signIn("test@mail.com", "test");
        new HomePage(driver).openAddAccount();
        new AddAccountPage(driver).setNameAndSave("Adriano");
        new HomePage(driver).openCreateMovement();
    }

    @Test
    public void noInfoSaveTest(){
        page.saveButton();
        for (String message : page.getErrorMessagesList()) {
            Assert.assertTrue(data.mandatoryFields.containsValue(message));
        }
    }

//    @Test
//    public void invalidValorTest(){
//        screen.setDateTransaction("01/07/2020");
//        screen.setDatePayment("01/07/2020");
//        screen.setDesc("test");
//        screen.setInterested("test");
//        screen.setValor("abc");
//        screen.setType("REC");
//        screen.setAccount(0);
//        screen.setSituation("status_pago");
//        screen.saveButton();
//
//        Assert.assertTrue(screen.errorMessagesList().contains(screen.mandatoryFields.get("caracterValor")));
//    }
//
//    @Test
//    public void movimentacaoValidaTest(){
//        screen.setDateTransaction("01/07/2020");
//        screen.setDatePayment("01/07/2020");
//        screen.setDesc("test");
//        screen.setInterested("test");
//        screen.setValor("200");
//        screen.setType("REC");
//        screen.setAccount(0);
//        screen.setSituation("status_pago");
//        screen.saveButton();
//
//        Assert.assertEquals("Movimentação adicionada com sucesso!", driver.findElement(By.cssSelector(".alert.alert-success")).getText());
//    }
}

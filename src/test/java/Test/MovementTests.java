package Test;

import Data.MovementMandatoryFields;
import Pages.AccountPages.AddAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MovementPage;
import org.junit.*;

public class MovementTests extends BaseTests{

    private MovementPage page = new MovementPage(driver);
    private MovementMandatoryFields data = new MovementMandatoryFields();
    private String accountName;

    @Before
    public void set(){
        new LoginPage(driver).signIn("test@mail.com", "test");
        new HomePage(driver).openAddAccount();
        accountName = "Neymar";
        new AddAccountPage(driver).setNameAndSave(accountName);
        new HomePage(driver).openCreateMovement();
    }

    @Test
    public void noInfoSaveTest(){
        page.saveButton();
        for (String message : page.getErrorMessagesList()) {
            Assert.assertTrue(data.mandatoryFields.containsValue(message));
        }
    }

    @Test
    public void invalidValorTest(){
        page.setDateTransaction("01/07/2020");
        page.setDatePayment("01/07/2020");
        page.setDescription("descriçao para a movimentação");
        page.setInterested("Seu Barriga");
        page.setValor("abc");
        page.setType("REC");
        page.setAccount(accountName);
        page.setSituation("status_pago");
        page.saveButton();

        Assert.assertTrue(page.getErrorMessagesList().contains(data.mandatoryFields.get("caracterValor")));
    }

    @Test
    public void noValorTest(){
        page.setDateTransaction("01/07/2020");
        page.setDatePayment("01/07/2020");
        page.setDescription("descriçao para a movimentação");
        page.setInterested("Seu Barriga");
        page.setValor("");
        page.setType("REC");
        page.setAccount(accountName);
        page.setSituation("status_pago");
        page.saveButton();

        Assert.assertTrue(page.getErrorMessagesList().contains(data.mandatoryFields.get("valor")));
    }

    @Test
    public void noTransactionDateTest(){
        page.setDateTransaction("");
        page.setDatePayment("01/07/2020");
        page.setDescription("descriçao para a movimentação");
        page.setInterested("Seu Barriga");
        page.setValor("200");
        page.setType("REC");
        page.setAccount(accountName);
        page.setSituation("status_pago");
        page.saveButton();

        Assert.assertTrue(page.getErrorMessagesList().contains(data.mandatoryFields.get("dataMovimento")));
    }

    @Test
    public void noPaymentDateTest(){
        page.setDateTransaction("01/07/2020");
        page.setDatePayment("");
        page.setDescription("descriçao para a movimentação");
        page.setInterested("Seu Barriga");
        page.setValor("200");
        page.setType("REC");
        page.setAccount(accountName);
        page.setSituation("status_pago");
        page.saveButton();

        Assert.assertTrue(page.getErrorMessagesList().contains(data.mandatoryFields.get("dataPgto")));
    }

    @Test
    public void noDescriptionTest(){
        page.setDateTransaction("01/07/2020");
        page.setDatePayment("01/07/2020");
        page.setDescription("");
        page.setInterested("Seu Barriga");
        page.setValor("200");
        page.setType("REC");
        page.setAccount(accountName);
        page.setSituation("status_pago");
        page.saveButton();

        Assert.assertTrue(page.getErrorMessagesList().contains(data.mandatoryFields.get("descricao")));
    }

    @Test
    public void noInterestedTest(){
        page.setDateTransaction("01/07/2020");
        page.setDatePayment("01/07/2020");
        page.setDescription("descriçao para a movimentação");
        page.setInterested("");
        page.setValor("200");
        page.setType("REC");
        page.setAccount(accountName);
        page.setSituation("status_pago");
        page.saveButton();

        Assert.assertTrue(page.getErrorMessagesList().contains(data.mandatoryFields.get("interessado")));
    }

    @Test
    public void validMovementTest(){
        page.setDateTransaction("01/07/2020");
        page.setDatePayment("01/07/2020");
        page.setDescription("descriçao para a movimentação");
        page.setInterested("Seu Barriga");
        page.setValor("200");
        page.setType("REC");
        page.setAccount(accountName);
        page.setSituation("status_pago");
        page.saveButton();

        Assert.assertEquals("Movimentação adicionada com sucesso!", page.getSuccessMessage());
    }
}

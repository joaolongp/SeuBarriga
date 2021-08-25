package Test;

import Data.TransactionMandatoryFields;
import Pages.AccountPages.AddAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TransactionPage;
import Util.LoginUtil;
import org.junit.*;

public class TransactionTests extends BaseTests{

    private TransactionPage page = new TransactionPage(driver);
    private TransactionMandatoryFields data = new TransactionMandatoryFields();
    private String accountName;

    @Before
    public void set(){
        new LoginUtil(driver);
        new HomePage(driver).openAddAccount();
        accountName = "Neymar";
        new AddAccountPage(driver).setNameAndSave(accountName);
        new HomePage(driver).openCreateTransaction();
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
    public void validTransactionTest(){
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

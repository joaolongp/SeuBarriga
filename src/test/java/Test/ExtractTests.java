package Test;

import Pages.AccountPages.AddAccountPage;
import Pages.ExtractPage;
import Pages.HomePage;
import Pages.TransactionPage;
import Util.LoginUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExtractTests extends BaseTests{

    private ExtractPage page = new ExtractPage(driver);
    private String accountName;


    @Before
    public void set(){
        new LoginUtil(driver);
        new HomePage(driver).openAddAccount();
        accountName = "Geromel";
        new AddAccountPage(driver).setNameAndSave(accountName);
        new HomePage(driver).openCreateTransaction();
        createTransaction(new TransactionPage(driver));
        new HomePage(driver).openMonthlyReview();
    }

    private void createTransaction(TransactionPage TransactionPage){
        TransactionPage.setDateTransaction("01/07/2020");
        TransactionPage.setDatePayment("");
        TransactionPage.setDescription("descriçao para a movimentação");
        TransactionPage.setInterested("Seu Barriga");
        TransactionPage.setValor("200");
        TransactionPage.setType("REC");
        TransactionPage.setAccount(accountName);
        TransactionPage.setSituation("status_pago");
        TransactionPage.saveButton();
    }

    @Test
    public void validateExtratoTest(){
        page.setMonth("07");
        page.setYear("2020");
        page.searchButton();
        Assert.assertEquals("Neymar", page.getDataRow(0, 2));
    }
}

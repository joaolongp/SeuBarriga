package Test;

import Pages.AccountPages.AddAccountPage;
import Pages.ExtractPage;
import Pages.HomePage;
import Pages.MovementPage;
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
        new HomePage(driver).openCreateMovement();
        createMovement(new MovementPage(driver));
        new HomePage(driver).openMonthlyReview();
    }

    private void createMovement(MovementPage movementPage){
        movementPage.setDateTransaction("01/07/2020");
        movementPage.setDatePayment("");
        movementPage.setDescription("descriçao para a movimentação");
        movementPage.setInterested("Seu Barriga");
        movementPage.setValor("200");
        movementPage.setType("REC");
        movementPage.setAccount(accountName);
        movementPage.setSituation("status_pago");
        movementPage.saveButton();
    }

    @Test
    public void validateExtratoTest(){
        page.setMonth("07");
        page.setYear("2020");
        page.searchButton();
        Assert.assertEquals("Neymar", page.getDataRow(0, 2));
    }
}

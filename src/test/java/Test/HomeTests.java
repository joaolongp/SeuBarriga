package Test;

import Pages.HomePage;
import Util.LoginUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HomeTests extends BaseTests{

    private HomePage page = new HomePage(driver);

    @Before
    public void set(){
        new LoginUtil(driver);
    }

    @Test
    public void validateAddAccountTitle(){
        page.openAddAccount();
        Assert.assertEquals("Seu Barriga - Adicionar Conta", page.title());
    }

    @Test
    public void validateListAccount(){
        page.openListAccounts();
        Assert.assertEquals("Seu Barriga - Contas", page.title());
    }

    @Test
    public void validateCreateTransaction(){
        page.openCreateTransaction();
        Assert.assertEquals("Seu Barriga - Movimentações", page.title());
    }

    @Test
    public void validateMonthlyReview(){
        page.openMonthlyReview();
        Assert.assertEquals("Seu Barriga - Extrato", page.title());
    }
}

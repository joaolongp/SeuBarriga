package Test.AccountTests;

import Pages.AccountPages.AddAccountPage;
import Pages.AccountPages.ListAccountPage;
import Pages.HomePage;
import Util.LoginUtil;
import Test.BaseTests;
import org.junit.*;

public class ListAccountTests extends BaseTests {

    private ListAccountPage page = new ListAccountPage(driver);
    private AddAccountPage addAccountPage = new AddAccountPage(driver);

    @Before
    public void set(){
        new LoginUtil(driver);
        new HomePage(driver).openAddAccount();
        addAccountPage.setNameAndSave("Ibra");
        new HomePage(driver).openListAccounts();
    }

    @Test
    public void removeAccountTest(){
        page.removeAccount(page.getNumberOfAccounts());
        Assert.assertEquals("Conta removida com sucesso!", page.getSuccessMsg());
    }

    @Test
    public void openEditAccountTest(){
        page.editAccount(page.getNumberOfAccounts());
        Assert.assertEquals("Seu Barriga - Adicionar Conta", page.title());
    }

    @Test
    public void editAccountTest(){
        page.editAccount(page.getNumberOfAccounts());
        addAccountPage.setNameAndSave("Geromel");
        Assert.assertEquals("Conta alterada com sucesso!", page.getSuccessMsg());
    }

    @Test
    public void listNamesTest(){
        Assert.assertTrue(page.getAccountNames().contains("Ibra"));
    }
}

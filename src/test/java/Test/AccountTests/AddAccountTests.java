package Test.AccountTests;

import Pages.AccountPages.AddAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Test.BaseTests;
import org.junit.*;

public class AddAccountTests extends BaseTests {

    private AddAccountPage page = new AddAccountPage(driver);

    @Before
    public void set(){
        new LoginPage(driver).signIn("test@mail.com", "test");
        new HomePage(driver).openAddAccount();
    }

    @Test
    public void addAccountWithoutNameTest(){
        page.setNameAndSave("");
        Assert.assertEquals("Informe o nome da conta", page.getErrorMsg());
    }

    @Test
    public void addAccountAlreadyExistsTest(){
        page.setNameAndSave("Neymar");
        driver.navigate().back();
        page.setNameAndSave("Neymar");
        Assert.assertEquals("Já existe uma conta com esse nome!", page.getErrorMsg());
    }

    @Test
    public void addAccountTest(){
        page.setNameAndSave("Messi");
        Assert.assertEquals("Conta adicionada com sucesso!", page.getSuccessMsg());
    }
}

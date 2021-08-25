package Test;

import Pages.LoginPage;
import org.junit.*;

public class LoginTests extends BaseTests{

    private LoginPage loginPage = new LoginPage(driver);

    @BeforeClass
    public static void startUp(){
        driver.get("https://seubarriga.wcaquino.me/");
    }

    @Test
    public void successfullLoginTest(){
        loginPage.signIn("test@mail.com", "test");
        Assert.assertEquals("Seu Barriga - Home", loginPage.title());
    }

    @Test
    public void failedLoginTest(){
        loginPage.signIn("fail@fail", "fail");
        Assert.assertEquals("Problemas com o login do usuário", loginPage.getErrorMsg());
    }
}

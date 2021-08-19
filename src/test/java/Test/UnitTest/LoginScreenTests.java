package Test.UnitTest;

import PageObjects.LoginScreen;
import Util.SetUp;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreenTests {

    private static WebDriver driver = new SetUp().getWebDriver();
    private LoginScreen login = new LoginScreen(driver);

    @BeforeClass
    public static void startUp(){
        driver.get("https://seubarriga.wcaquino.me/");
    }

    @Test
    public void successfullLoginTest(){
        login.Do();
        Assert.assertEquals("Seu Barriga - Home", driver.getTitle());
    }

    @Test
    public void failedLoginTest(){
        login.Do("fail@fail", "fail");
        Assert.assertEquals("Problemas com o login do usuário", driver.findElement(By.cssSelector("body > div.alert.alert-danger")).getText());
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

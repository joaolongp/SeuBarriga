package Test.AccountScreens;

import PageObjects.AccountScreens.AddAccountScreen;
import PageObjects.HomeScreen;
import PageObjects.LoginScreen;
import Util.SetUp;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAccountScreenTests {

    private static WebDriver driver = new SetUp().getWebDriver();
    private AddAccountScreen screen = new AddAccountScreen(driver);

    @BeforeClass
    public static void startUp(){
        driver.get("https://seubarriga.wcaquino.me/");
        new LoginScreen(driver).Do();
        new HomeScreen(driver).addAccount();
    }

    @Test
    public void noNameTest(){
        screen.saveButton();
        Assert.assertEquals("Informe o nome da conta",driver.findElement(By.className("alert-danger")).getText());
    }

    @Test
    public void duplicateNameClickSaveTest(){
        screen.setName("Parci");
        screen.saveButton();
        driver.navigate().back();
        screen.saveButton();
        Assert.assertEquals("Já existe uma conta com esse nome!", driver.findElement(By.cssSelector("body > div.alert.alert-danger")).getText());
    }

    @Test
    public void setNameClickSaveTest(){
        screen.setName("Menino Ney");
        screen.saveButton();
        Assert.assertEquals("Conta adicionada com sucesso!", driver.findElement(By.cssSelector("body > div.alert.alert-success")).getText());
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

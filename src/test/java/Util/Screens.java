package Util;

import PageObjects.*;
import PageObjects.AccountScreens.AddAccountScreen;
import PageObjects.AccountScreens.EditAccountScreen;
import PageObjects.AccountScreens.ListAccountScreen;
import org.openqa.selenium.WebDriver;

public class Screens extends BaseScreen {

    public LoginScreen loginScreen;
    public HomeScreen homeScreen;
    public MovimentationScreen movimentacaoScreen;
    public ExtractScreen extratoScreen;
    public AddAccountScreen addContaScreen;
    public EditAccountScreen editAccountScreen;
    public ListAccountScreen listaContaScreen;

    public Screens(WebDriver driver){
        super(driver);
        loginScreen = new LoginScreen(driver);
        homeScreen = new HomeScreen(driver);
        movimentacaoScreen = new MovimentationScreen(driver);
        extratoScreen = new ExtractScreen(driver);
        addContaScreen = new AddAccountScreen(driver);
        editAccountScreen = new EditAccountScreen(driver);
        listaContaScreen = new ListAccountScreen(driver);
    }

    public void backtoHome(){
        driver.get("https://seubarriga.wcaquino.me/");
    }
}

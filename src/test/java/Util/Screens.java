package Util;

import PageObjects.*;
import PageObjects.ContaScreens.AddContaScreen;
import PageObjects.ContaScreens.EditarContaScreen;
import PageObjects.ContaScreens.ListaContaScreen;
import org.openqa.selenium.WebDriver;

public class Screens extends BaseScreen {

    public LoginScreen loginScreen;
    public HomeScreen homeScreen;
    public MovimentacaoScreen movimentacaoScreen;
    public ExtratoScreen extratoScreen;
    public AddContaScreen addContaScreen;
    public EditarContaScreen editarContaScreen;
    public ListaContaScreen listaContaScreen;

    public Screens(WebDriver driver){
        super(driver);
        loginScreen = new LoginScreen(driver);
        homeScreen = new HomeScreen(driver);
        movimentacaoScreen = new MovimentacaoScreen(driver);
        extratoScreen = new ExtratoScreen(driver);
        addContaScreen = new AddContaScreen(driver);
        editarContaScreen = new EditarContaScreen(driver);
        listaContaScreen = new ListaContaScreen(driver);
    }

    public void backtoHome(){
        driver.get("https://seubarriga.wcaquino.me/");
    }
}

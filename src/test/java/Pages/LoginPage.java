package Pages;

import PageObjects.Login;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Login {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void email(String email){
        email().sendKeys(email);
    }

    public void password(String password){
        password().sendKeys(password);
    }

    public void loginButton(){
        button().click();
    }

    public String getErrorMsg(){
        return errorAlert().getText();
    }

    public void signIn(String email, String password){
        email(email);
        password(password);
        loginButton();
    }
}

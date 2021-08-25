package Util;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginUtil {
    public LoginUtil(WebDriver driver){
        new LoginPage(driver).signIn("test@mail.com", "test");
    }
}

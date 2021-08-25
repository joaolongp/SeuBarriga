package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends Base {

    public Login(WebDriver driver){
        super(driver);
    }

    public WebElement email(){
        return driver.findElement(By.id("email"));
    }

    public WebElement password(){
        return driver.findElement(By.id("senha"));
    }

    public WebElement button(){
        return driver.findElement(By.className("btn-primary"));
    }

    public WebElement errorAlert(){
        return driver.findElement(By.className("alert-danger"));
    }
}

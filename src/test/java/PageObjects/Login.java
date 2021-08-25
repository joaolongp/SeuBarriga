package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends Base {

    public Login(WebDriver driver){
        super(driver);
    }

    protected WebElement email(){
        return driver.findElement(By.id("email"));
    }

    protected WebElement password(){
        return driver.findElement(By.id("senha"));
    }

    protected WebElement button(){
        return driver.findElement(By.className("btn-primary"));
    }

    protected WebElement errorAlert(){
        return driver.findElement(By.className("alert-danger"));
    }
}

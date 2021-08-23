package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen extends BaseScreen{

    public LoginScreen(WebDriver driver){
        super(driver);
    }

    public void Do(String email, String password){
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("senha")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();
    }
    public void Do(){
        driver.findElement(By.id("email")).sendKeys("test@mail.com");
        driver.findElement(By.id("senha")).sendKeys("test");
        driver.findElement(By.tagName("button")).click();
    }
}

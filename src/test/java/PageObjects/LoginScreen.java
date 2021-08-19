package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen {

    private WebDriver driver;

    public LoginScreen(WebDriver driver){
        this.driver = driver;
    }

    public void Do(String email, String senha){
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("senha")).sendKeys(senha);
        driver.findElement(By.tagName("button")).click();
    }
    public void Do(){
        driver.findElement(By.id("email")).sendKeys("test@mail.com");
        driver.findElement(By.id("senha")).sendKeys("test");
        driver.findElement(By.tagName("button")).click();
    }
}

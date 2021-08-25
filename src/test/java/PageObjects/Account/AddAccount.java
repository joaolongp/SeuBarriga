package PageObjects.Account;

import PageObjects.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddAccount extends Base {

    public AddAccount(WebDriver driver){
        super(driver);
    }

    protected WebElement saveButton() {
        return driver.findElement(By.className("btn-primary"));
    }

    protected WebElement nameField(){
        return driver.findElement(By.id("nome"));
    }

    protected WebElement errorAlert(){
        return driver.findElement(By.className("alert-danger"));
    }

    protected WebElement successAlert(){
        return driver.findElement(By.className("alert-success"));
    }
}
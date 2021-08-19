package PageObjects.ContaScreens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddContaScreen {

    private WebDriver driver;

    public AddContaScreen(WebDriver driver){
        this.driver = driver;
    }

    public void saveButton(){
        driver.findElement(By.tagName("button")).click();
    }

    public void setName(String name){
        driver.findElement(By.id("nome")).sendKeys(name);
    }
}
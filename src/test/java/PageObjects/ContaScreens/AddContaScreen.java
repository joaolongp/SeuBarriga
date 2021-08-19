package PageObjects.ContaScreens;

import PageObjects.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddContaScreen extends BaseScreen {

    public AddContaScreen(WebDriver driver){
        super(driver);
    }

    public void saveButton(){
        driver.findElement(By.tagName("button")).click();
    }

    public void setName(String name){
        driver.findElement(By.id("nome")).sendKeys(name);
    }
}
package PageObjects.AccountScreens;

import PageObjects.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAccountScreen extends BaseScreen {

    public AddAccountScreen(WebDriver driver){
        super(driver);
    }

    public void saveButton(){
        driver.findElement(By.tagName("button")).click();
    }

    public void setName(String name){
        driver.findElement(By.id("nome")).sendKeys(name);
    }
}
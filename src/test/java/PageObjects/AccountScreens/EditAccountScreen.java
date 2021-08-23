package PageObjects.AccountScreens;

import PageObjects.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountScreen extends BaseScreen {

    public EditAccountScreen(WebDriver driver){
        super(driver);
    }

    public void setName(String name){
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys(name);
    }

    public void saveButton(){
        driver.findElement(By.className("btn-primary")).click();
    }
}

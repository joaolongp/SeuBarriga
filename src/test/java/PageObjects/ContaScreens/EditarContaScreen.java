package PageObjects.ContaScreens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditarContaScreen {

    private WebDriver driver;

    public EditarContaScreen(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String name){
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys(name);
    }

    public void saveButton(){
        driver.findElement(By.className("btn-group")).click();
    }
}

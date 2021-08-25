package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home extends Base {

    public Home(WebDriver driver){
        super(driver);
    }

    protected WebElement dropDown(){
        return driver.findElement(By.className("dropdown"));
    }

    public WebElement addAccount(){
        return driver.findElement(By.linkText("Adicionar"));
    }

    public WebElement listAccount(){
        return driver.findElement(By.linkText("Listar"));
    }

    public WebElement createMovement(){
        return driver.findElement(By.linkText("Criar Movimentação"));
    }

    public WebElement monthlyReview(){
        return driver.findElement(By.linkText("Resumo Mensal"));
    }
}

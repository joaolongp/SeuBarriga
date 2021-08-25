package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home extends Base {

    public Home(WebDriver driver){
        super(driver);
    }

    protected WebElement dropDown(){
        return driver.findElement(By.className("dropdown"));
    }

    protected WebElement addAccount(){
        return driver.findElement(By.linkText("Adicionar"));
    }

    protected WebElement listAccount(){
        return driver.findElement(By.linkText("Listar"));
    }

    protected WebElement createMovement(){
        return driver.findElement(By.linkText("Criar Movimentação"));
    }

    protected WebElement monthlyReview(){
        return driver.findElement(By.linkText("Resumo Mensal"));
    }
}

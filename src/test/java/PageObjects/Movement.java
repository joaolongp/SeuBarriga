package PageObjects;

import Data.MovementMandatoryFields;
import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Movement extends Base {

    public Movement(WebDriver driver){
        super(driver);
    }

    protected WebElement save(){
        return driver.findElement(By.className("btn-group"));
    }

    protected List<WebElement> errorAlertList(){
        return driver.findElement(By.className("alert-danger")).findElements(By.tagName("li"));
    }

    protected WebElement errorAlertByIndex(int index){
        return errorAlertList().get(index);
    }

    protected WebElement dateTransaction(){
        return driver.findElement(By.id("data_transacao"));
    }

    protected WebElement DatePayment(){
        return driver.findElement(By.id("data_pagamento"));
    }

    protected WebElement description(){
        return driver.findElement(By.id("descricao"));
    }

    protected WebElement interested(){
        return driver.findElement(By.id("interessado"));
    }

    protected WebElement valor(){
        return driver.findElement(By.id("valor"));
    }

    protected Select typesDropDown(){
        return new Select(driver.findElement(By.id("tipo")));
    }

    protected Select account(int index){
        return new Select(driver.findElement(By.id("conta")));
    }

    protected void situation(String id){
        driver.findElement(By.id(id)).click();
    }
}

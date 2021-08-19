package PageObjects;

import Data.MovimentacaoMandatoryFields;
import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovimentacaoScreen {

    private WebDriver driver;
    public Map<String, String> mandatoryFields = new MovimentacaoMandatoryFields().getMandatoryFields();

    public MovimentacaoScreen(WebDriver driver){
        this.driver = driver;
    }

    public void saveButton(){
        driver.findElement(By.className("btn-group")).click();
    }

    private List<WebElement> getErrorMessages(){
        return driver.findElement(By.cssSelector(".alert.alert-danger")).findElements(By.tagName("li"));
    }

    public List<String> errorMessagesList(){
        List<String> messagesList = new ArrayList<>();
        for (WebElement element : getErrorMessages()) {
            messagesList.add(element.getText());
        }
        return messagesList;
    }

    public void setDataTransacao(String data){
        driver.findElement(By.id("data_transacao")).sendKeys(data);
    }

    public void setDataPgto(String data){
        driver.findElement(By.id("data_pagamento")).sendKeys(data);
    }

    public void setDescricao(String descricao){
        driver.findElement(By.id("descricao")).sendKeys(descricao);
    }

    public void setInteressado(String interessado){
        driver.findElement(By.id("interessado")).sendKeys(interessado);
    }

    public void setValor(String valor){
        driver.findElement(By.id("valor")).sendKeys(valor);
    }

    @Description("REC or DESP")
    public void setTipo(String value){
        Select dropDown = new Select(driver.findElement(By.id("tipo")));
        dropDown.selectByValue(value);
    }

    public void setConta(int index){
        Select dropDown = new Select(driver.findElement(By.id("conta")));
        dropDown.selectByIndex(index);
    }

    @Description("status_pago or status_pendente")
    public void setSituacao(String id){
        driver.findElement(By.id(id)).click();
    }
}

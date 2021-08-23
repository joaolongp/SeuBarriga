package PageObjects;

import Data.MovimentationMandatoryFields;
import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovimentationScreen extends BaseScreen{

    public Map<String, String> mandatoryFields = new MovimentationMandatoryFields().getMandatoryFields();

    public MovimentationScreen(WebDriver driver){
        super(driver);
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

    public void setDateTransaction(String date){
        driver.findElement(By.id("data_transacao")).clear();
        driver.findElement(By.id("data_transacao")).sendKeys(date);
    }

    public void setDatePayment(String date){
        driver.findElement(By.id("data_pagamento")).clear();
        driver.findElement(By.id("data_pagamento")).sendKeys(date);
    }

    public void setDesc(String desc){
        driver.findElement(By.id("descricao")).clear();
        driver.findElement(By.id("descricao")).sendKeys(desc);
    }

    public void setInterested(String interested){
        driver.findElement(By.id("interessado")).clear();
        driver.findElement(By.id("interessado")).sendKeys(interested);
    }

    public void setValor(String valor){
        driver.findElement(By.id("valor")).clear();
        driver.findElement(By.id("valor")).sendKeys(valor);
    }

    @Description("REC or DESP")
    public void setType(String value){
        Select dropDown = new Select(driver.findElement(By.id("tipo")));
        dropDown.selectByValue(value);
    }

    public void setAccount(int index){
        Select dropDown = new Select(driver.findElement(By.id("conta")));
        dropDown.selectByIndex(index);
    }

    @Description("status_pago or status_pendente")
    public void setSituation(String id){
        driver.findElement(By.id(id)).click();
    }
}

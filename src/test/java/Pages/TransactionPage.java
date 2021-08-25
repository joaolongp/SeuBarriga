package Pages;

import PageObjects.Transaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TransactionPage extends Transaction {

    public TransactionPage(WebDriver driver) {
        super(driver);
    }

    public void saveButton(){
        save().click();
    }

    public String getSuccessMessage(){
        return successAlert().getText();
    }

    public List<String> getErrorMessagesList(){
        List<String> alertList = new ArrayList<>();
        for (WebElement element:
             errorAlertList()) {
            alertList.add(element.getText());
        }
        return alertList;
    }

    public void setType(String value){
        typesDropDown().selectByValue(value);
    }

    public void setDateTransaction(String date){
        dateTransaction().sendKeys(date);
    }

    public void setDatePayment(String date){
        datePayment().sendKeys(date);
    }

    public void setDescription(String description){
        description().sendKeys(description);
    }

    public void setInterested(String interested){
        interested().sendKeys(interested);
    }

    public void setValor(String valor){
        valor().sendKeys(valor);
    }

    public void setAccount(String account){
        account().selectByVisibleText(account);
    }

    public void setSituation(String id){
        situation(id);
    }
}

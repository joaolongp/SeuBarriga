package Pages;

import PageObjects.Extract;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class ExtractPage extends Extract {

    public ExtractPage(WebDriver driver) {
        super(driver);
    }

    public void setMonth(String value){
        month().selectByValue(value);
    }

    public void setYear(String value){
        year().selectByValue(value);
    }

    public void searchButton(){
        button().click();
    }

    public String getDataRow(int index, int row){
        return dataFromTransaction(index,row).getText();
    }

    public Map<Integer, WebElement>getData(int index){
        return TransactionByIndex(index);
    }

//    public List<String> dataFromTransactionByIndex(int index){
//        int row = 0;
//        for (WebElement element:
//             getTransactionByIndex(index)) {
//
//        }
//    }
//
//    public Map<Integer, WebElement> getTransactionByIndex(int index){
//        return rows().get(index);
//    }
}

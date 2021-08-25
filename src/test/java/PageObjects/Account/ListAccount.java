package PageObjects.Account;

import PageObjects.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListAccount extends Base {

    public ListAccount(WebDriver driver){
        super(driver);
    }

    protected List<WebElement> accounts(){
        return driver.findElement(By.id("tabelaContas")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
    }

    protected WebElement accountByIndex(int index){
        return accounts().get(index);
    }

    protected WebElement removeButton(int index){
        return accountByIndex(index).findElement(By.className("glyphicon-remove-circle"));
    }

    protected WebElement editButton(int index){
        return accountByIndex(index).findElement(By.className("glyphicon-edit"));
    }

    protected WebElement successAlert(){
        return driver.findElement(By.className("alert-success"));
    }


}
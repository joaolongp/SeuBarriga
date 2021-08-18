package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListaContaScreen {

    private WebDriver driver;
    private List<WebElement> contas;

    public ListaContaScreen(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getContas(){
        contas=driver.findElement(By.id("tabelaContas")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        return contas;
    }

}
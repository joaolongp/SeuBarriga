package PageObjects.ContaScreens;

import PageObjects.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListaContaScreen extends BaseScreen {

    private List<WebElement> contas;

    public ListaContaScreen(WebDriver driver){
        super(driver);
    }

    public List<WebElement> getContas(){
        return contas = driver.findElement(By.id("tabelaContas")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
    }

    public List<String> getNames(){
        List<String> list = new ArrayList<>();
        for (WebElement element:
             getContas()) {
            list.add(element.getText());
        }
        return list;
    }

    private void clickExcluir(WebElement conta){
        conta.findElements(By.tagName("td")).get(1).findElements(By.tagName("a")).get(1).click();
    }

    private void clickEditar(WebElement conta){
        conta.findElements(By.tagName("td")).get(1).findElements(By.tagName("a")).get(0).click();
    }

    public void excluirConta(int index){
        clickExcluir(getContas().get(index));
    }

    public void editarConta(int index){
        clickEditar(getContas().get(index));
    }
}
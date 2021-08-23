package PageObjects.AccountScreens;

import PageObjects.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListAccountScreen extends BaseScreen {

    private List<WebElement> contas;

    public ListAccountScreen(WebDriver driver){
        super(driver);
    }

    public List<WebElement> getAccounts(){
        return contas = driver.findElement(By.id("tabelaContas")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
    }

    public List<String> getNames(){
        List<String> list = new ArrayList<>();
        for (WebElement element:
             getAccounts()) {
            list.add(element.getText());
        }
        return list;
    }

    private void clickExcludeButton(WebElement conta){
        conta.findElements(By.tagName("td")).get(1).findElements(By.tagName("a")).get(1).click();
    }

    private void clickEditButton(WebElement conta){
        conta.findElements(By.tagName("td")).get(1).findElements(By.tagName("a")).get(0).click();
    }

    public void removeAccount(int index){
        clickExcludeButton(getAccounts().get(index));
    }

    public void editAccount(int index){
        clickEditButton(getAccounts().get(index));
    }
}
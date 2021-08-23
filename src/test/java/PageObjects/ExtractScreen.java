package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtractScreen extends BaseScreen{

    private Map<Integer, List<WebElement>> dados = new HashMap();

    public ExtractScreen(WebDriver driver) {
        super(driver);
    }

    public void setMonth(String mes) {
        Select dropDown = new Select(driver.findElement(By.id("mes")));
        dropDown.selectByValue(mes);
    }

    public void setYear(String ano) {
        Select dropDown = new Select(driver.findElement(By.id("ano")));
        dropDown.selectByValue(ano);
    }

    public void searchButton() {
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
    }

    public Map<Integer, List<WebElement>> getData() {
        int index = 0;
        for (WebElement element : driver.findElements(By.cssSelector("#tabelaExtrato > tbody > tr"))) {
            dados.put(index++ , element.findElements(By.tagName("td")));
        }
        return dados;
    }

    public List<WebElement> getItens(int index){
        return getData().get(index);
    }

    public WebElement getItemByIndex(int dado, int index){
        return getItens(dado).get(index);
    }
}
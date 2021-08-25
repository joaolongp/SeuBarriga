package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Extract extends Base {

    private Map<Integer, List<WebElement>> dados = new HashMap();

    public Extract(WebDriver driver) {
        super(driver);
    }

    protected Select month() {
        return new Select(driver.findElement(By.id("mes")));
    }

    protected Select year() {
        return new Select(driver.findElement(By.id("ano")));
    }

    protected WebElement button() {
        return driver.findElement(By.className("btn-primary"));
    }

    protected Map<Integer, WebElement> movementByIndex(int index){
        return movementList().get(index);
    }

    protected WebElement dataFromMovement(int index, int row){
        return movementByIndex(index).get(row);
    }

    protected List<Map<Integer, WebElement>> movementList(){
        List<Map<Integer, WebElement>> list = new ArrayList<>();
        for (WebElement element:
             driver.findElement(By.id("tabelaExtrato")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"))) {
            list.add(movementToMap(element));
        }
        return list;
    }

    private Map<Integer, WebElement> movementToMap(WebElement movement){
        Map<Integer, WebElement> map = new HashMap<>();
        int id = 0;
        for (WebElement element:
             movement.findElements(By.tagName("td"))) {
            map.put(id++, element);
        }
        return map;
    }

//    public Map<Integer, List<WebElement>> getData() {
//        int index = 0;
//        for (WebElement element : driver.findElements(By.cssSelector("#tabelaExtrato > tbody > tr"))) {
//            dados.put(index++ , element.findElements(By.tagName("td")));
//        }
//        return dados;
//    }
//
//    public List<WebElement> getItens(int index){
//        return getData().get(index);
//    }
//
//    public WebElement getItemByIndex(int dado, int index){
//        return getItens(dado).get(index);
//    }
}
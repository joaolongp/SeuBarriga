package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeScreen {

    private WebDriver driver;
    private List<WebElement> contasDropDown;

    public HomeScreen(WebDriver driver){
        this.driver = driver;
    }

    private void openDropDown(){
        driver.findElement(By.className("dropdown")).click();
        contasDropDown= driver.findElement(By.className("dropdown-menu")).findElements(By.tagName("li"));
    }

    public void addConta(){
        openDropDown();
        contasDropDown.get(0).click();
    }

    public void listaContas(){
        openDropDown();
        contasDropDown.get(1).click();
    }

    public void criarMovimentacao(){
        driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(3) > a")).click();
    }

    public void resumoMensal(){
        driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(4) > a")).click();
    }
}

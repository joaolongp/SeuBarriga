package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeScreen extends BaseScreen{

    private List<WebElement> contasDropDown;

    public HomeScreen(WebDriver driver){
        super(driver);
    }

    private void openDropDown(){
        driver.findElement(By.className("dropdown")).click();
        contasDropDown= driver.findElement(By.className("dropdown-menu")).findElements(By.tagName("li"));
    }

    public void addAccount(){
        openDropDown();
        contasDropDown.get(0).click();
    }

    public void listAccounts(){
        openDropDown();
        contasDropDown.get(1).click();
    }

    public void createMovimentation(){
        driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(3) > a")).click();
    }

    public void monthlyReview(){
        driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(4) > a")).click();
    }
}

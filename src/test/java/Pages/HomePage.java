package Pages;

import PageObjects.Home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Home {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openDropDown(){
        dropDown().click();
    }

    public void openAddAccount(){
        openDropDown();
        addAccount().click();
    }

    public void openListAccounts(){
        openDropDown();
        listAccount().click();
    }

    public void openCreateMovement(){
        createMovement().click();
    }

    public void openMonthlyReview(){
        monthlyReview().click();
    }
}

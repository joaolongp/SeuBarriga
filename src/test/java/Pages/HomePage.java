package Pages;

import PageObjects.Home;
import org.openqa.selenium.WebDriver;

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

    public void openCreateTransaction(){
        createTransaction().click();
    }

    public void openMonthlyReview(){
        monthlyReview().click();
    }
}

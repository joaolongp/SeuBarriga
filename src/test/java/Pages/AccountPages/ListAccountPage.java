package Pages.AccountPages;

import PageObjects.Account.ListAccount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListAccountPage extends ListAccount {

    public ListAccountPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfAccounts(){
        return accounts().size()-1;
    }

    public void removeAccount(int index){
        removeButton(index).click();
    }

    public void editAccount(int index){
        editButton(index).click();
    }

    public List<String> getAccountNames(){
        List<String> listAccountNames = new ArrayList<>();
        for (WebElement account:
             accounts()) {
            listAccountNames.add(account.getText());
        }
        return listAccountNames;
    }

    public String getSuccessMsg(){
        return successAlert().getText();
    }
}

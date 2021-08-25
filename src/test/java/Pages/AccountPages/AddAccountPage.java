package Pages.AccountPages;

import PageObjects.Account.AddAccount;
import org.openqa.selenium.WebDriver;

public class AddAccountPage extends AddAccount {

    public AddAccountPage(WebDriver driver) {
        super(driver);
    }

    private void save() {
        saveButton().click();
    }

    private void name(String name){
        nameField().clear();
        nameField().sendKeys(name);
    }

    public void setNameAndSave(String name){
        this.name(name);
        save();
    }

    public String getErrorMsg(){
        return errorAlert().getText();
    }

    public String getSuccessMsg(){
        return successAlert().getText();
    }
}

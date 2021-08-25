package Pages;

import PageObjects.Movement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MovementPage extends Movement {

    public MovementPage(WebDriver driver) {
        super(driver);
    }

    public void saveButton(){
        save().click();
    }

    public List<String> getErrorMessagesList(){
        List<String> alertList = new ArrayList<>();
        for (WebElement element:
             errorAlertList()) {
            alertList.add(element.getText());
        }
        return alertList;
    }

    public String getErrorMessageByIndex(int index){
        return getErrorMessagesList().get(index);
    }
}

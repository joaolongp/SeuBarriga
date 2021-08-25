package PageObjects;

import org.openqa.selenium.WebDriver;

public class Base {

    protected final WebDriver driver;

    protected Base(WebDriver driver) {
        this.driver = driver;
    }

    public String title(){
        return driver.getTitle();
    }
}
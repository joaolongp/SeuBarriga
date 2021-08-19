package PageObjects;

import org.openqa.selenium.WebDriver;

public abstract class BaseScreen {

    protected final WebDriver driver;

    protected BaseScreen(WebDriver driver) {
        this.driver = driver;
    }
}
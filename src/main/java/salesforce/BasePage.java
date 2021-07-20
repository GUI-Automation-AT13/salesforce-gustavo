package salesforce;

import core.selenium.WebElementAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebElementAction webElementAction;
    public BasePage(final WebDriver driver) {
        this.driver = driver;
        webElementAction = new WebElementAction(driver);
        PageFactory.initElements(driver, this);
        waitForPageLoaded();
    }

    protected abstract void waitForPageLoaded();
}


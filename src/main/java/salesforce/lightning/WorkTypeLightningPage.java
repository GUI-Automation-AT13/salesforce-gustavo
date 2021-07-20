package salesforce.lightning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.BasePage;

public class WorkTypeLightningPage extends BasePage {
    @FindBy(xpath = "//a[@class='forceActionLink'][@role='button']")
    protected WebElement newBtn;

    public WorkTypeLightningPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForElementVisibility(newBtn);
    }

    /**
     * Changes the page to create work type.
     *
     * @return workTypeForm initialize.
     */
    public WorkTypeForm clickNewButton() {
        newBtn.click();
        return new WorkTypeForm(driver);
    }
}
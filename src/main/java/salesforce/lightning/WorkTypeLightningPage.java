package salesforce.lightning;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.BasePage;

public class WorkTypeLightningPage extends BasePage {
    @FindBy(xpath = "//a[@class='forceActionLink'][@role='button']")
    protected WebElement newBtn;

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
        webElementAction.clickElement(newBtn);
        return new WorkTypeForm();
    }
}
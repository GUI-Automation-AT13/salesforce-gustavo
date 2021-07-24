package salesforce.classic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.BasePage;

public class WorkTypeForm extends BasePage {
    @FindBy(id = "Name")
    protected WebElement nameTxtBox;

    @FindBy(id = "EstimatedDuration")
    protected WebElement estimatedDurationTxtBox;

    @FindBy(name = "save")
    protected WebElement saveBtn;

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForElementVisibility(nameTxtBox);
    }

    /**
     * Sets the name of work type.
     *
     * @param workTypeName is name work type
     */
    public void setNameTxtBox(final String workTypeName) {
        webElementAction.setInputField(nameTxtBox, workTypeName);
    }

    /**
     * Sets the estimated duration of work type.
     *
     * @param estimatedDuration is time estimate duration of work type
     */
    public void setEstimatedDurationTxtBox(final String estimatedDuration) {
        webElementAction.setInputField(estimatedDurationTxtBox, estimatedDuration);
    }

    /**
     * Actions to click save button.
     *
     * @return WorkTypeInfo which is to pass other page.
     */
    public WorkTypeInfo clickSaveButton() {
        saveBtn.click();
        return new WorkTypeInfo();
    }
}

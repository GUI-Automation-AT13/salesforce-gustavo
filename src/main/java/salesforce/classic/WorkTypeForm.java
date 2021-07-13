package salesforce.classic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.BasePage;

public class WorkTypeForm extends BasePage {
    @FindBy(id = "Name")
    protected WebElement nameTxtBox;

    @FindBy(id = "EstimatedDuration")
    protected WebElement estimatedDurationTxtBox;

    @FindBy(name = "save")
    protected WebElement saveBtn;

    public WorkTypeForm(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameTxtBox));
    }

    public void setNameTxtBox(final String workTypeName) {
        nameTxtBox.sendKeys(workTypeName);
    }

    public void setEstimatedDurationTxtBox(final String estimatedDuration) {
        estimatedDurationTxtBox.sendKeys(estimatedDuration);
    }

    public WorkTypeInfo clickSaveButton() {
        saveBtn.click();
        return new WorkTypeInfo(driver);
    }
}

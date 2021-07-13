package salesforce.classic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.BasePage;

public class WorkTypeInfo extends BasePage {
    @FindBy(id = "Name_ilecell")
    protected WebElement nameWorkTypeTxt;

    public WorkTypeInfo(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameWorkTypeTxt));
    }

    public String getNameOfWorkType() {
        return nameWorkTypeTxt.getText();
    }
}

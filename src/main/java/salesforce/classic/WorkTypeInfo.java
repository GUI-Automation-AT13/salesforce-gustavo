package salesforce.classic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.BasePage;

public class WorkTypeInfo extends BasePage {
    @FindBy(id = "Name_ilecell")
    protected WebElement nameWorkTypeTxt;

    public WorkTypeInfo(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForElementVisibility(nameWorkTypeTxt);
    }

    /**
     * Gets the name of work type.
     *
     * @return name of worktype.
     */
    public String getNameOfWorkType() {
        return webElementAction.getText(nameWorkTypeTxt);
    }
}

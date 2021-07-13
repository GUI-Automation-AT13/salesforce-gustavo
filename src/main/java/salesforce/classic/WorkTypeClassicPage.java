package salesforce.classic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.BasePage;


public class WorkTypeClassicPage extends BasePage {
    @FindBy(name = "new")
    protected WebElement newBtn;

    @FindBy(css = "#tryLexDialogX")
    protected WebElement closeAnnouncement;

    public WorkTypeClassicPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {
        System.out.println("Entrooo");
        wait.until(ExpectedConditions.visibilityOf(newBtn));
    }

    public void closeAnnouncement() {
        closeAnnouncement.click();
    }

    public WorkTypeForm clickNewButton() {
        newBtn.click();
        return new WorkTypeForm(driver);
    }
}

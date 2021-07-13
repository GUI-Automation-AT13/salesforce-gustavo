package salesforce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.classic.WorkTypeClassicPage;
import salesforce.lightning.WorkTypeLightningPage;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement userNameTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
    }

    public void setUserName(final String userName) {
        userNameTxtBox.sendKeys(userName);
    }

    public void setPassword(final String password) {
        passwordTxtBox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    public WorkTypeClassicPage goToClassic() {
        driver.get(Urls.WORK_TYPE_CLASSIC.getValue());
        return new WorkTypeClassicPage(driver);
    }

    public WorkTypeLightningPage goToLightning() {
        driver.get(Urls.WORK_TYPE_LIGHTNING.getValue());
        return new WorkTypeLightningPage(driver);
    }
}

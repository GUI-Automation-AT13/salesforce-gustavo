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

    /**
     * Sets user name to login salesforce.
     *
     * @param userName name of user
     */
    public void setUserName(final String userName) {
        userNameTxtBox.sendKeys(userName);
    }

    /**
     * Sets user password to login salesforce.
     *
     * @param password password of user
     */
    public void setPassword(final String password) {
        passwordTxtBox.sendKeys(password);
    }

    /**
     * Click button login.
     */
    public void clickLoginButton() {
        loginBtn.click();
    }

    /**
     * Goes to classic salesforce.
     *
     * @return workTypeClassicPage is work type page in classic
     */
    public WorkTypeClassicPage goToClassic() {
        driver.get(Urls.WORK_TYPE_CLASSIC.getValue());
        return new WorkTypeClassicPage(driver);
    }

    /**
     * Goes to lightning salesforce.
     *
     * @return workTypeLightningPage is work type page in lightning
     */
    public WorkTypeLightningPage goToLightning() {
        driver.get(Urls.WORK_TYPE_LIGHTNING.getValue());
        return new WorkTypeLightningPage(driver);
    }
}

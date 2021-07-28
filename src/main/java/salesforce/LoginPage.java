package salesforce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.classic.WorkTypeClassicPage;
import salesforce.lightning.WorkTypeLightningPage;
import salesforce.utilities.Urls;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement userNameTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForElementVisibility(loginBtn);
    }

    /**
     * Sets user name to login salesforce.
     *
     * @param userName name of user
     */
    public void setUserName(final String userName) {
        System.out.println(userName);
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
        return new WorkTypeClassicPage();
    }

    /**
     * Goes to lightning salesforce.
     *
     * @return workTypeLightningPage is work type page in lightning
     */
    public WorkTypeLightningPage goToLightning() {
        driver.get(Urls.WORK_TYPE_LIGHTNING.getValue());
        return new WorkTypeLightningPage();
    }
}

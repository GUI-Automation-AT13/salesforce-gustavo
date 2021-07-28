package salesforce.hooks;

import core.selenium.WebDriverManager;
import salesforce.PageTransporter;
import salesforce.utilities.Urls;
import salesforce.utilities.UserDate;

public class LoginPage {
    private WebDriverManager webDriverManager;
    protected salesforce.LoginPage loginPage;
    protected PageTransporter pageTransporter = new PageTransporter();

    protected void setUp() {
        webDriverManager = WebDriverManager.getInstance();
        webDriverManager.maximizeScreen();
    }

    public void loginSalesforce() {
        setUp();
        pageTransporter.goToUrl(Urls.PATH_LOGIN.getValue());
        loginPage = new salesforce.LoginPage();
        loginPage.setUserName(UserDate.USERNAME.getValue());
        loginPage.setPassword(UserDate.PASSWORD.getValue());
        loginPage.clickLoginButton();
    }
}

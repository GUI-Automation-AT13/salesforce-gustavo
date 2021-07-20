package base;

import core.selenium.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import salesforce.LoginPage;
import salesforce.PageTransporter;
import salesforce.utilities.Urls;
import salesforce.utilities.UserDate;

public class BaseTest {
    private WebDriverManager webDriverManager;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        webDriverManager = WebDriverManager.getInstance();
        webDriverManager.maximizeScreen();
    }

    @BeforeClass(dependsOnMethods = "setUp")
    public void loginSalesforce() {
        PageTransporter.goToUrl(Urls.PATH_LOGIN.getValue());
        loginPage = new LoginPage(webDriverManager.getDriver());
        loginPage.setUserName(UserDate.USERNAME.getValue());
        loginPage.setPassword(UserDate.PASSWORD.getValue());
        loginPage.clickLoginButton();
    }

    @AfterClass
    public void tearDown() {
        webDriverManager.quitDriver();
    }
}

package base;

import gui.Interact;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import salesforce.LoginPage;
import salesforce.Urls;
import salesforce.UserDate;

public class BaseTest {
    private Interact interact = new Interact();
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        interact.maximizeScreen();
    }

    @BeforeClass(dependsOnMethods = "setUp")
    public void loginSalesforce() {
        interact.setUrl(Urls.PATH_LOGIN.getValue());
        loginPage = new LoginPage(interact.getDriver());
        loginPage.setUserName(UserDate.USERNAME.getValue());
        loginPage.setPassword(UserDate.PASSWORD.getValue());
        loginPage.clickLoginButton();
    }

    @AfterClass
    public void tearDown() {
        interact.quitDriver();
    }
}

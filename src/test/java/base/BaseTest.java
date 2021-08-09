package base;

import api.*;
import core.selenium.WebDriverManager;
import core.utilities.GetEnv;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import salesforce.LoginPage;
import salesforce.PageTransporter;
import salesforce.entities.Token;
import salesforce.utilities.Urls;
import salesforce.utilities.UserDate;
import salesforce.api.Header;

public class BaseTest {
    private WebDriverManager webDriverManager;
    protected LoginPage loginPage;
    protected String tokenUser;
    protected String nameOwner;
    protected PageTransporter pageTransporter;
    protected final String TYPE_USER = "admin";

    @BeforeClass
    public void setUp() {
        webDriverManager = WebDriverManager.getInstance();
        webDriverManager.maximizeScreen();
        pageTransporter = new PageTransporter();
        GetEnv.getInstance().setEnvVariable(TYPE_USER);
    }

    @BeforeClass(dependsOnMethods = "setUp")
    public void loginSalesforce() {
        pageTransporter.goToUrl(Urls.PATH_LOGIN.getValue());
        loginPage = new LoginPage();
        loginPage.setUserName(UserDate.USERNAME.getValue());
        loginPage.setPassword(UserDate.PASSWORD.getValue());
        loginPage.clickLoginButton();
    }

    @BeforeClass(dependsOnMethods = "setUp")
    public void generateToken() {
        ApiRequest apiRequest = new ApiRequestBuilder()
                .params(UserDate.USERNAME.getKey(), UserDate.USERNAME.getValue())
                .params(UserDate.PASSWORD.getKey(), UserDate.PASSWORD.getValue())
                .params(UserDate.CLIENT_ID.getKey(), UserDate.CLIENT_ID.getValue())
                .params(UserDate.CLIENT_SECRET.getKey(), UserDate.CLIENT_SECRET.getValue())
                .params(UserDate.GRANT_TYPE.getKey(), UserDate.GRANT_TYPE.getValue())
                .headers(Header.ACCEPT.getValue(), Header.APPLICATION_JSON.getValue())
                .headers(Header.CONTENT_TYPE.getValue(), Header.X_WWW_FORM_URLENCODED.getValue())
                .baseUri(Urls.TOKEN.getValue())
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.executeParam(apiRequest);
        tokenUser = apiResponse.getBody(Token.class).getAccessToken();
    }

    @BeforeClass(dependsOnMethods = "generateToken")
    public void getDateUser() {
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(Urls.USER_INFO.getValue())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .method(ApiMethod.GET).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        nameOwner = apiResponse.getResponse().jsonPath().getString("name");
    }

    @AfterClass
    public void tearDown() {
        webDriverManager.quitDriver();
    }
}

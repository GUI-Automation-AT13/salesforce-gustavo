package salesforce.hooks;

import api.*;
import core.selenium.WebDriverManager;
import core.utilities.GetEnv;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.Test;
import salesforce.LoginPage;
import salesforce.PageTransporter;
import salesforce.api.Header;
import salesforce.entities.Token;
import salesforce.utilities.Urls;
import salesforce.utilities.UserDate;
import utilities.ObjectInformation;

public class WorkTypeHooks {
    private WebDriverManager webDriverManager;
    protected salesforce.LoginPage loginPage;
    protected String tokenUser;
    protected String nameOwner;
    protected PageTransporter pageTransporter;
    protected final String TYPE_USER = "admin";
    protected ObjectInformation objectInformation;

    public WorkTypeHooks(ObjectInformation objectInformation) {
        this.objectInformation = objectInformation;
    }

    @Before(value = "@CreateWorkType", order = 1)
    public void setUp() {
        webDriverManager = WebDriverManager.getInstance();
        webDriverManager.maximizeScreen();
        pageTransporter = new PageTransporter();
        GetEnv.getInstance().setEnvVariable(TYPE_USER);
    }

    @Before(value = "@CreateWorkType", order = 2)
    public void loginSalesforce() {
        pageTransporter.goToUrl(Urls.PATH_LOGIN.getValue());
        loginPage = new LoginPage();
        loginPage.setUserName(UserDate.USERNAME.getValue());
        loginPage.setPassword(UserDate.PASSWORD.getValue());
        loginPage.clickLoginButton();
    }

    @Before(value = "@CreateWorkType", order = 2)
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

    @Before(value = "@CreateWorkType", order = 3)
    public void getDateUser() {
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(Urls.USER_INFO.getValue())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .method(ApiMethod.GET).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        objectInformation.setNameOwner(apiResponse.getResponse().jsonPath().getString("name"));
    }

    @After(value = "@CreateWorkType")
    public void tearDown() {
        webDriverManager.quitDriver();
    }
}

package salesforce.hooks;

import api.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.selenium.WebDriverManager;
import core.utilities.GetEnv;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import salesforce.PageTransporter;
import salesforce.api.Header;
import salesforce.entities.Token;
import salesforce.entities.operatinghours.OperatingHours;
import salesforce.entities.operatinghours.OperatingHoursCreated;
import salesforce.utilities.Urls;
import salesforce.utilities.UserDate;
import salesforce.utilities.ObjectInformation;

public class WorkTypeHooks {
    private Logger log = Logger.getLogger(getClass());
    private WebDriverManager webDriverManager;
    private String tokenUser;
    private PageTransporter pageTransporter;
    private ObjectInformation objectInformation = new ObjectInformation();
    private final String USER_TYPE = "admin";
    private String idOperatingHours;

    public WorkTypeHooks(ObjectInformation objectInformation) {
        log.info("WorkTypeHooks constructor");
        this.objectInformation = objectInformation;
    }

    @Before(value = "@CreateWorkType", order = 1)
    public void setUp() {
        log.info("Set browser and initialize webDriverManager");
        webDriverManager = WebDriverManager.getInstance();
        webDriverManager.maximizeScreen();
        pageTransporter = new PageTransporter();
        GetEnv.getInstance().setEnvVariable(USER_TYPE);
    }

    @Before(value = "@CreateWorkType", order = 2)
    public void generateToken() {
        log.info("Generate Token");
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
        log.info("Get Date user");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(Urls.USER_INFO.getValue())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .method(ApiMethod.GET).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        objectInformation.setNameOwner(apiResponse.getResponse().jsonPath().getString("name"));
    }

    @Before(value = "@CreateWorkType", order = 3)
    public void createOperatingHours() throws JsonProcessingException {
        log.info("Create OperatingHours");
        OperatingHours operatingHours = new OperatingHours();
        operatingHours.setName("OperatingHours-test news");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(Urls.OPERATING_HOURS.getValue())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .body(new ObjectMapper().writeValueAsString(operatingHours))
                .method(ApiMethod.POST).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        idOperatingHours = apiResponse.getBody(OperatingHoursCreated.class).getId();
    }

    @After(value = "@CreateWorkType", order = 2)
    public void deleteOperatingHours() {
        log.info("Delete OperatingHours");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(Urls.OPERATING_HOURS.getValue() + idOperatingHours)
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@CreateWorkType", order = 2)
    public void cleanRepository() {
        log.info("Delete WorkType");
        ApiRequest apiRequest = new ApiRequestBuilder()
                .baseUri(Urls.WORK_TYPE.getValue() + objectInformation.getId())
                .headers(Header.AUTHORIZATION.getValue(), Header.BEARER.getValue() + tokenUser)
                .method(ApiMethod.DELETE).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
    }

    @After(value = "@CreateWorkType", order = 1)
    public void tearDown() {
        log.info("Close Driver");
        webDriverManager.quitDriver();
    }
}

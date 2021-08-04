package salesforce.steps;

import core.utilities.GetEnv;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import salesforce.LoginPage;
import salesforce.lightning.WorkTypeForm;
import salesforce.lightning.WorkTypeInfo;
import salesforce.lightning.WorkTypeLightningPage;
import salesforce.utilities.Urls;
import salesforce.utilities.UserDate;
import utilities.CalendarManager;
import org.testng.asserts.SoftAssert;
import utilities.ObjectInformation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static salesforce.PageTransporter.goToUrl;
import static utilities.IdPage.getIdWorKType;

public class CreateWorkTypeSteps {
    private Logger log = Logger.getLogger(getClass());
    private CalendarManager calendarManager = new CalendarManager();
    private WorkTypeInfo workTypeInfo;
    private SoftAssert softAssert = new SoftAssert();
    private ObjectInformation objectInformation;
    private Map<String, String> tableFeature;
    private WorkTypeLightningPage workTypeLightningPage;
    private WorkTypeForm workTypeForm;

    public CreateWorkTypeSteps(ObjectInformation objectInformation) {
        log.info("CreateWorkTypeSteps constructor");
        this.objectInformation = objectInformation;
    }

    @Given("^I login to Salesforce site as an (.*) user$")
    public void iLoginToSalesforceSiteAsAnAdminUser(final String userType) {
        log.info("Sign in to Salesforce");
        GetEnv.getInstance().setEnvVariable(userType);
        goToUrl(Urls.PATH_LOGIN.getValue());
        LoginPage loginPage = new LoginPage();
        loginPage.setUserName(UserDate.USERNAME.getValue());
        loginPage.setPassword(UserDate.PASSWORD.getValue());
        loginPage.clickLoginButton();
    }

    @When("^I create a new workType (?:.*)$")
    public void iCreateANewWorkTypeOnlyWithRequiredAllFields(final Map<String, String> table) {
        log.info("Create a workType");
        tableFeature = table;
        workTypeLightningPage = new WorkTypeLightningPage();
        workTypeForm = workTypeLightningPage.clickNewButton();
        workTypeForm.fillUpField(table);
        workTypeInfo = workTypeForm.clickSaveButton();
        objectInformation.setId(getIdWorKType(workTypeInfo.getCurrentUrl()));
    }

    @Then("^I verify WorkType created with (?:.*)$")
    public void iVerifyWorkTypeCreatedWithAllFields() {
        log.info("Assert of fields");
        List<String> valuesField = workTypeInfo.getValueField(tableFeature);
        assertEquals(valuesField, new ArrayList<>(tableFeature.values()));
    }


    @And("I matches date and creator's name")
    public void iMatchesRequirementAllFields() {
        log.info("Assert of date and creator's name");
        assertEquals(workTypeInfo.getCreatedByTxt(), calendarManager.generateDateActual("M/d/yyyy, h:mm a"));
        assertEquals(workTypeInfo.getNameCreatorTxt(), objectInformation.getNameOwner());
    }
}

package salesforce.steps;

import core.utilities.GetEnv;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import salesforce.entities.worktype.WorkType;
import salesforce.hooks.CreateWorkType;
import salesforce.hooks.LoginPage;
import salesforce.lightning.WorkTypeInfo;
import utilities.CalendarManager;
import org.testng.asserts.SoftAssert;
import utilities.ObjectInformation;

import static salesforce.utilities.Converter.converterIntToString;


public class CreateWorkTypeTests {
    protected LoginPage loginPage = new LoginPage();
    protected WorkType workType;
    protected CreateWorkType createWorkType = new CreateWorkType();
    private WorkTypeInfo workTypeInfo;
    private CalendarManager calendarManager = new CalendarManager();
    private SoftAssert softAssert = new SoftAssert();
    protected ObjectInformation objectInformation;

    public CreateWorkTypeTests(ObjectInformation objectInformation) {
        this.objectInformation = objectInformation;
    }

    @Given("^I login to Salesforce site as an (.*) user$")
    public void iLoginToSalesforceSiteAsAnAdminUser(final String userType) {
        GetEnv.getInstance().setEnvVariable(userType);
        loginPage.loginSalesforce();
    }

    @When("^I create a new workType (?:.*)$")
    public void iCreateANewWorkTypeOnlyWithRequiredAllFields2(final DataTable dataTable) {
        workType = createWorkType.setWorkType(dataTable);
        workTypeInfo = createWorkType.createWorkTypeForUI(workType);
    }

    @Then("^I verify WorkType created with requirement fields$")
    public void iVerifyWorkTypeCreatedWithAllFields() {
        softAssert.assertEquals(workTypeInfo.getNameOfWorkType(), workType.getName());
        softAssert.assertEquals(workTypeInfo.getTxtField("Estimated Duration"), converterIntToString(workType.getEstimatedDuration()));
    }


    @And("I matches requirement all fields")
    public void iMatchesRequirementAllFields() {
        softAssert.assertEquals(workTypeInfo.getDescription(), workType.getDescription());
        softAssert.assertEquals(workTypeInfo.getTxtField("Block Time Before Appointment"), converterIntToString(workType.getBlockTimeBeforeAppointment()));
        softAssert.assertEquals(workTypeInfo.getTxtField("Block Time After Appointment"), converterIntToString(workType.getBlockTimeAfterAppointment()));
        softAssert.assertEquals(workTypeInfo.getTxtField("Timeframe Start"), converterIntToString(workType.getTimeframeStart()));
        softAssert.assertEquals(workTypeInfo.getTxtField("Timeframe End"),  converterIntToString(workType.getTimeframeEnd()));
        softAssert.assertEquals(workTypeInfo.getCreatedByTxt(), calendarManager.generateDateActual("d/M/yyyy H:m"));
        softAssert.assertEquals(workTypeInfo.getNameCreatorTxt(), objectInformation.getNameOwner());
    }
}

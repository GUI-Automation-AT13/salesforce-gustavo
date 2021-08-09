package salesforce.steps;

import io.cucumber.java.en.When;
import salesforce.PageTransporter;

public class NavigationSteps {
    protected PageTransporter pageTransporter = new PageTransporter();

    @When("I navigate to {string} page in mode {string}")
    public void iNavigateToWorkTypePage(final String page, final String modeSalesforce) {
        pageTransporter.navigateToPage(page, modeSalesforce);
    }
}

package salesforce;

import core.selenium.WebDriverManager;
import salesforce.classic.WorkTypeClassicPage;

public final class PageTransporter {

    private PageTransporter() {
    }

    /**
     * Goes to the given Url.
     *
     * @param url - site's Url
     */
    public static void goToUrl(final String url) {
        WebDriverManager.getInstance().getDriver().navigate().to(url);
    }

    /**
     * Sets WorkTypeClassicPage object with instance interact.
     *
     * @return WorkTypeClassicPage object
     */
    public static WorkTypeClassicPage navigateToWorkTypeClassicPage() {
        goToUrl(Urls.WORK_TYPE_CLASSIC.getValue());
        return new WorkTypeClassicPage(WebDriverManager.getInstance().getDriver());
    }
}

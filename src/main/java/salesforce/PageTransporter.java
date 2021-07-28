package salesforce;

import core.selenium.WebDriverManager;
import salesforce.classic.WorkTypeClassicPage;
import salesforce.utilities.Urls;

import static salesforce.utilities.Converter.converterStringToEnum;

public class PageTransporter<T> {

    /**
     * Goes to the given Url.
     *
     * @param url - site's Url
     */
    public void goToUrl(final String url) {
        WebDriverManager.getInstance().navigateToUrl(url);
    }

    /**
     * Sets WorkTypeClassicPage object with instance interact.
     *
     * @return WorkTypeClassicPage object
     */
    public WorkTypeClassicPage navigateToWorkTypeClassicPage() {
        goToUrl(Urls.WORK_TYPE_CLASSIC.getValue());
        return new WorkTypeClassicPage();
    }

    /**
     * Navigates by url.
     *
     * @param namePage is string with name page
     * @param mode is classic or Lightning to salesforce
     */
    public void navigateToPage(final String namePage, final String mode) {
        goToUrl(converterStringToEnum(namePage, mode).getValue());
    }
}

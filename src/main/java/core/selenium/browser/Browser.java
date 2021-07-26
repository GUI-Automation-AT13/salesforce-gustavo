package core.selenium.browser;

import org.openqa.selenium.WebDriver;

public final class Browser {

    /**
     * Sets Browser type.
     *
     * @param browser which we are tested
     * @return type of browser
     */
    public WebDriver setBrowser(final String browser) {
        if ("FIREFOX".equals(browser)) {
            return FireFox.selectBrowser();
        }
        return Chrome.selectBrowser();
    }
}

package gui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GuiSetting {

    /**
     * Sets Browser type.
     *
     * @param browser which we are tested
     * @return type of browser
     */
    public WebDriver setBrowser(final String browser) {
        if (browser == "CHROME") {
            return selectBrowserChrome();
        }
        if (browser == "FIREFOX") {
            return selectBrowserFirefox();
        }
        return selectBrowserChrome();
    }

    /**
     * Sets up browser to Chrome.
     *
     * @return ChromeDriver in driver
     */
    private RemoteWebDriver selectBrowserChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    /**
     * Sets up browser to Firefox.
     *
     * @return FirefoxDriver in driver
     */
    private RemoteWebDriver selectBrowserFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}

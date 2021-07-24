package core.selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FireFox {

    /**
     * Sets up browser to Firefox.
     *
     * @return FirefoxDriver in driver
     */
    public static RemoteWebDriver selectBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}

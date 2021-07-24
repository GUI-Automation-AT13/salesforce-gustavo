package core.selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Chrome {

    /**
     * Sets up browser to Chrome.
     *
     * @return ChromeDriver in driver
     */
    public static RemoteWebDriver selectBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}

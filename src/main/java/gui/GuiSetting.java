package gui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Browser;

public class GuiSetting {

    /**
     * Sets Browser type.
     *
     * @param browser which we are tested
     * @return type of browser
     */
    public WebDriver setBrowser(final Browser browser) {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}

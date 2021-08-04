package core.selenium;

import core.selenium.browser.Browser;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import salesforce.utilities.SetUp;

public final class WebDriverManager {
    private static WebDriver driver;
    private static Browser browser = new Browser();
    private static WebDriverManager instance = null;

    private WebDriverManager() {
    }

    /**
     * Constructor of Interact.
     * Gets Interact as Singleton.
     *
     * @return a instance
     */
    public static WebDriverManager getInstance() {
        if (instance == null) {
            instance = new WebDriverManager();
            driver = browser.setBrowser(SetUp.BROWSER.getValue());
        }
        return instance;
    }

    /**
     * Gets driver to use for other class.
     *
     * @return driver with type WebDriver.
     */
    public WebDriver getDriver() {
        return this.driver;
    }

    /**
     * Sets size of windows.
     *
     * @param width  of windows.
     * @param height of windows.
     */
    public void windowsSize(final int width, final int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    /**
     * Sets size of windows is equals to screen.
     */
    public void maximizeScreen() {
        driver.manage().window().maximize();
    }

    /**
     * Sets the url to test begin.
     *
     * @param url
     */
    public void setUrl(final String url) {
        driver.get(url);
    }

    /**
     * Quits this driver, closing every associated window.
     */
    public void quitDriver() {
        driver.quit();
    }

    /**
     * Closes associated window.
     */
    public void closeWindow() {
        driver.close();
    }

    /**
     * Navigates by url.
     *
     * @param url is url of page
     */
    public void navigateToUrl(final String url) {
        driver.navigate().to(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

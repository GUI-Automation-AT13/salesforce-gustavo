package gui;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import salesforce.SetUp;

public class Interact {
    private WebDriver driver;
    private GuiSetting guiSetting = new GuiSetting();

    public Interact() {
        driver = guiSetting.setBrowser(SetUp.BROWSER.getValue());
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
     * @param width of windows.
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
     * closes associated window.
     */
    public void closeWindow() {
        driver.close();
    }
}

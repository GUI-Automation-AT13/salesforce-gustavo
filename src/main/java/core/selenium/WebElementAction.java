package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.utilities.SetUp;

public class WebElementAction {
    private WebDriverWait wait;
    private int timeOutInSeconds = Integer.parseInt(SetUp.WAIT_TYPE.getValue());

    public WebElementAction(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void waitForElementVisibility(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Sets a value in a webElemnt.
     *
     * @param webElement type WebElement object
     * @param text       is string with value to set
     */
    public void setInputField(final WebElement webElement, final String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Clicks a webElement.
     *
     * @param webElement type WebElement object.
     */
    public void clickElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    /**
     * Gets test of webElement.
     *
     * @param webElement type WebElement object.
     * @return a text in webElement
     */
    public String getText(final WebElement webElement) {
        return webElement.getText();
    }
}

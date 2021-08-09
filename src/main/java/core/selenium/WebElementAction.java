package core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import salesforce.utilities.SetUp;

public class WebElementAction {
    private WebDriverWait wait;
    private int timeOutInSeconds = Integer.parseInt(SetUp.WAIT_TYPE.getValue());

    public WebElementAction(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    /**
     * Waits for element visibility.
     *
     * @param webElement is element to wait
     */
    public void waitForElementVisibility(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Sets a value in a webElement.
     *
     * @param webElement type WebElement object
     * @param text       is string with value to set
     */
    public void setInputField(final WebElement webElement, final String text) {
        waitForElementVisibility(webElement);
        webElement.sendKeys(text);
    }

    /**
     * Sets a value in a webElement.
     *
     * @param selector type selector object
     * @param text     is string with value to set
     */
    public void setInputField(final By selector, final String text) {
        WebDriverManager.getInstance().getDriver().findElement(selector).sendKeys(text);
    }

    /**
     * Clicks a webElement.
     *
     * @param webElement type WebElement object.
     */
    public void clickElement(final WebElement webElement) {
        webElement.click();
    }

    /**
     * Gets test of webElement.
     *
     * @param webElement type WebElement object.
     * @return a text in webElement
     */
    public String getText(final WebElement webElement) {
        waitForElementVisibility(webElement);
        return webElement.getText();
    }

    /**
     * Gets the text of a web element.
     *
     * @param field web element to get text.
     */
    public void clickByXpath(final String field) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(field)));
        WebDriverManager.getInstance().getDriver().findElement(By.xpath(field)).click();
    }

    /**
     * Gets the text of a web element.
     *
     * @param field web element to get text.
     * @return web element's text
     */
    public String getTextOfElementByField(final String field) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(field)));
        return  WebDriverManager.getInstance().getDriver().findElement(By.xpath(field)).getText();
    }

    /**
     * Selects a comboBox by webElement.
     *
     * @param webElement type WebElement object.
     */
    public void selectByAction(final WebElement webElement) {
        Actions builder = new Actions(WebDriverManager.getInstance().getDriver());
        Action action = builder.click(webElement).build();
        action.perform();
    }

    /**
     * Gets current url.
     *
     * @return a String with current url.
     */
    public String getCurrentUrl() {
        return WebDriverManager.getInstance().getDriver().getCurrentUrl();
    }
}

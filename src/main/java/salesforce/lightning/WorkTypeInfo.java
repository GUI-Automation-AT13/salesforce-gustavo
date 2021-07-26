package salesforce.lightning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.BasePage;

public class WorkTypeInfo extends BasePage {
    @FindBy(xpath = "//*[@class='uiOutputText']")
    protected WebElement nameWorkTypeTxt;

    @FindBy(xpath = "//*[@class='uiOutputTextArea']")
    protected WebElement descriptionTxt;

    @FindBy(xpath = "//*[contains(text(),'Created By')]/../..//*[@class='uiOutputDateTime forceOutputModStampWithPreview']")
    protected WebElement dateCreateByTxt;

    @FindBy(xpath = "//span[contains(text(),'Created By')]/../..//a[@rel='noreferrer']")
    protected WebElement nameCreatorTxt;

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForElementVisibility(nameWorkTypeTxt);
    }

    /**
     * Gets the name of work type.
     *
     * @return name of worktype.
     */
    public String getNameOfWorkType() {
        return nameWorkTypeTxt.getText();
    }

    public String getDescription() {
        return descriptionTxt.getText();
    }

    /**
     * Sets value and select in txt of Estimated Duration, Block Time Before Appointment, Block Time After Appointment.
     * Timeframe Start and Timeframe End.
     *
     * @param nameTxtBox is name of textBox
     * @return value of nameTxtBox
     */
    public String getTxtField(final String nameTxtBox) {
        String xpath = String.format("//*[contains(text(),'%s')]/../..//*[@class='uiOutputNumber']", nameTxtBox);
        return webElementAction.getText(driver.findElement(By.xpath(xpath)));
    }

    /**
     * Gets a date when workType is created.
     *
     * @return a String to date
     */
    public String getCreatedByTxt() {
        return webElementAction.getText(dateCreateByTxt);
    }

    /**
     * Gets a creator's name of workType.
     *
     * @return a String to date
     */
    public String getNameCreatorTxt() {
        return webElementAction.getText(nameCreatorTxt);
    }

}

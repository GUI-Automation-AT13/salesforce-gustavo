package salesforce.lightning;

import core.utilities.supplier.StringSupplier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.BasePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * Gets the description of work type.
     *
     * @return description of work type
     */
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
     * Sets value and select in txt of Duration Type, Block Time Before Unit, Block Time After Unit,
     * Time Frame Start Unit and Time Frame End Unit.
     *
     * @param nameTxtBox is name of textBox
     * @return value of nameTxtBox
     */
    public String getUnitsOfTxtField(final String nameTxtBox) {
        String xpath = "//span[contains(text(),'%s')]/../..//span[@class='test-id__field-value "
                + "slds-form-element__static slds-grow ']";
        return webElementAction.getText(driver.findElement(By.xpath(String.format(xpath, nameTxtBox))));
    }

    /**
     * Gets values of Operating Hours txt box.
     *
     * @return value of TxtBox
     */
    public String getOperatingHoursTxtBox() {
        return webElementAction.getText(driver.findElement(
                By.xpath("//*[contains(text(),'Operating Hours')]/../..//a[@target='_blank'][@href]")));
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

    /**
     * Gets current url of page.
     *
     * @return a String with url current
     */
    public String getCurrentUrl() {
        return webElementAction.getCurrentUrl();
    }

    /**
     * Gets information of workType created.
     *
     * @param table is values to get of txtBoxs
     * @return a List with values of txtBoxs
     */
    public List<String> getValueField(final Map<String, String> table) {
        List<String> result = new ArrayList<>();
        HashMap<String, StringSupplier> actionsWorkTypeMap = getTxtFields();
        table.keySet().forEach(key -> result.add(actionsWorkTypeMap.get(key).getAsString()));
        return result;
    }

    /**
     * Gets text fields of workType.
     *
     * @return a map with methods of CreatedWorkType
     */
    private HashMap<String, StringSupplier> getTxtFields() {
        HashMap<String, StringSupplier> mapValues = new HashMap<>();
        mapValues.put("Work Type Name", this::getNameOfWorkType);
        mapValues.put("Description", this::getDescription);
        mapValues.put("Operating Hours", this::getOperatingHoursTxtBox);
        mapValues.put("Estimated Duration", () -> getTxtField("Estimated Duration"));
        mapValues.put("Block Time Before Appointment", () -> getTxtField("Block Time Before Appointment"));
        mapValues.put("Block Time After Appointment", () -> getTxtField("Block Time After Appointment"));
        mapValues.put("Timeframe Start", () -> getTxtField("Timeframe Start"));
        mapValues.put("Timeframe End", () -> getTxtField("Timeframe End"));
        mapValues.put("Duration Type", () -> getUnitsOfTxtField("Duration Type"));
        mapValues.put("Block Time Before Unit", () -> getUnitsOfTxtField("Block Time Before Unit"));
        mapValues.put("Block Time After Unit", () -> getUnitsOfTxtField("Block Time After Unit"));
        mapValues.put("Time Frame Start Unit", () -> getUnitsOfTxtField("Time Frame Start Unit"));
        mapValues.put("Time Frame End Unit", () -> getUnitsOfTxtField("Time Frame End Unit"));
        return mapValues;
    }
}

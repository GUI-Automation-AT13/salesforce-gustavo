package salesforce.lightning;

import core.utilities.supplier.VoidSupplier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.BasePage;

import java.util.HashMap;
import java.util.Map;

public class WorkTypeForm extends BasePage {

    @FindBy(css = ".select[aria-required='true']")
    protected WebElement estimatedDurationComboBox;

    @FindBy(xpath = "//button[@data-aura-class='uiButton forceActionButton'][3]")
    protected WebElement saveBtn;

    @FindBy(css = ".textarea")
    protected WebElement descriptionTxtBox;

    @FindBy(className = "primaryLabel slds-truncate slds-lookup__result-text")
    protected WebElement d;

    private String selectFieldTxtBox = "//*[contains(text(),'%s')]/../..//*[@type='text']";
    private String valueEstimatedDurationComboBox = "//a[normalize-space()='%s']";
    private String xpathComboBoxSomeFields = "//*[contains(text(),'%s')]/../..//a[@class='select']";
    private String xpathValueComboBoxSomeFields = "//div[@aria-labelledby][@id][%d]//*[contains(text(),'%s')]";
    private int countComboBox = 0;

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForElementVisibility(estimatedDurationComboBox);
    }

    public void clickOperatingHours(final String operatingHours) {
        webElementAction.clickByXpath(String.format(selectFieldTxtBox, "Operating Hours"));
        String operatingHoursSelected =
                "//*[contains(text(),'%s')]/../..//*[@class='primaryLabel slds-truncate slds-lookup__result-text']";
        webElementAction.clickByXpath(String.format(operatingHoursSelected, operatingHours));
    }

    /**
     * Sets on text of descriptions field of workType.
     *
     * @param fieldValue is value to set on textBox
     */
    public void setDescription(final String fieldValue) {
        webElementAction.setInputField(descriptionTxtBox, fieldValue);
    }

    /**
     * Sets on text of field Estimated Duration, Block Time Before Appointment, Block Time After Appointment, Timeframe
     * Start  of workType and Timeframe End.
     *
     * @param fieldName  name of textBox
     * @param fieldValue is value to set on textBox
     */
    public void setInputField(final String fieldName, final String fieldValue) {
        if (fieldValue == null) {
            return;
        }
        webElementAction.setInputField(By.xpath(String.format(selectFieldTxtBox, fieldName)), fieldValue);
    }

    /**
     * Sets value and select estimated duration comboBox.
     *
     * @param selectValue is value in comboBox
     */
    public void setEstimatedDurationComboBox(final String selectValue) {
        webElementAction.selectByAction(estimatedDurationComboBox);
        webElementAction.clickByXpath(String.format(valueEstimatedDurationComboBox, selectValue));
        countComboBox++;
    }

    /**
     * Sets value and select estimated duration comboBox.
     *
     * @param selectValue is value in comboBox
     */
    public void setDurationTypeComboBox(final String selectValue) {
        webElementAction.selectByAction(estimatedDurationComboBox);
        webElementAction.clickElement(driver.findElement(
                By.xpath(String.format(valueEstimatedDurationComboBox, selectValue))));
        countComboBox++;
    }

    /**
     * Sets value and select in comboBox.
     *
     * @param nameComboBox is name of comboBox
     * @param selectValue  is a value in comboBox
     */
    public void setComboBoxField(final String nameComboBox, final String selectValue) {
        webElementAction.selectByAction(driver.findElement(By.xpath(String.format(xpathComboBoxSomeFields, nameComboBox))));
        countComboBox++;
        webElementAction.clickByXpath(String.format(xpathValueComboBoxSomeFields, countComboBox, selectValue));
    }

    /**
     * Actions to click save button.
     *
     * @return WorkTypeInfo which is to pass other page.
     */
    public WorkTypeInfo clickSaveButton() {
        webElementAction.clickElement(saveBtn);
        return new WorkTypeInfo();
    }

    /**
     * Fills up form to create a workType.
     *
     * @param table is values to fill up txtBoxs
     */
    public void fillUpField(final Map<String, String> table) {
        HashMap<String, VoidSupplier> actionsWorkTypeMap = mapActionsWorkType(table);
        table.keySet().forEach(key -> actionsWorkTypeMap.get(key).run());
    }

    /**
     * Saves actions in New work type page in map.
     *
     * @param workTypeMap is map
     * @return a map with action of fields
     */
    private HashMap<String, VoidSupplier> mapActionsWorkType(final Map<String, String> workTypeMap) {
        HashMap<String, VoidSupplier> mapActions = new HashMap<>();
        mapActions.put("Work Type Name", () -> setInputField("Work Type Name", workTypeMap.get("Work Type Name")));
        mapActions.put("Description", () -> setDescription(workTypeMap.get("Description")));
        mapActions.put("Operating Hours", () -> clickOperatingHours(workTypeMap.get("Operating Hours"))); //****
        mapActions.put("Estimated Duration", () -> setInputField("Estimated Duration",
                workTypeMap.get("Estimated Duration")));
        mapActions.put("Duration Type", () -> setDurationTypeComboBox(workTypeMap.get("Duration Type")));
        mapActions.put("Block Time Before Appointment", () -> setInputField("Block Time Before Appointment",
                workTypeMap.get("Block Time Before Appointment")));
        mapActions.put("Block Time Before Unit", () -> setComboBoxField("Block Time Before Unit",
                workTypeMap.get("Block Time Before Unit")));
        mapActions.put("Block Time After Appointment", () -> setInputField("Block Time After Appointment",
                workTypeMap.get("Block Time After Appointment")));
        mapActions.put("Block Time After Unit", () -> setComboBoxField("Block Time After Unit",
                workTypeMap.get("Block Time After Unit")));
        mapActions.put("Timeframe Start", () -> setInputField("Timeframe Start",
                workTypeMap.get("Timeframe Start")));
        mapActions.put("Time Frame Start Unit", () -> setComboBoxField("Time Frame Start Unit",
                workTypeMap.get("Time Frame Start Unit")));
        mapActions.put("Timeframe End", () -> setInputField("Timeframe End", workTypeMap.get("Timeframe End")));
        mapActions.put("Time Frame End Unit", () -> setComboBoxField("Time Frame End Unit",
                workTypeMap.get("Time Frame End Unit")));
        return mapActions;
    }


}

package salesforce.lightning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.BasePage;

public class WorkTypeForm extends BasePage {

    @FindBy(css = ".select[aria-required='true']")
    protected WebElement estimatedDurationComboBox;

    @FindBy(xpath = "//button[@data-aura-class='uiButton forceActionButton'][3]")
    protected WebElement saveBtn;
    private String xpathComboBox;
    private static int countComboBox = 0;

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForElementVisibility(estimatedDurationComboBox);
    }

    /**
     * Sets on text of all field of workType.
     *
     * @param fieldName name of textBox
     * @param fieldValue is value to set on textBox
     */
    public void setInputField(final String fieldName, final String fieldValue) {
        if ("Description".equals(fieldName)) {
            webElementAction.setInputField(driver.findElement(By.cssSelector(".textarea")), fieldValue);
        } else {
            String xpath = String.format("//*[contains(text(),'%s')]/../..//*[@type='text']", fieldName);
            webElementAction.setInputField(driver.findElement(By.xpath(xpath)), fieldValue);
        }
    }

    /**
     * Sets value and select estimated duration comboBox.
     *
     * @param selectValue is value in comboBox
     */
    public void setEstimatedDurationComboBox(final String selectValue) {
        webElementAction.selectComboBox(estimatedDurationComboBox, driver);
        String xpathValue = String.format("//a[normalize-space()='%s']", selectValue);
        webElementAction.clickElement(driver.findElement(By.xpath(xpathValue)));
    }

    /**
     * Sets value and select in comboBox.
     *
     * @param nameComboBox is name of comboBox
     * @param selectValue is a value in comboBox
     */
    public void setComboBoxField(final String nameComboBox, final String selectValue) {
        countComboBox++;
        xpathComboBox = String.format("//*[contains(text(),'%s')]/../..//a[@class='select']", nameComboBox);
        webElementAction.selectComboBox(driver.findElement(By.xpath(xpathComboBox)), driver);
        String xpathValue = String.format("(//a[normalize-space()='%s'])[%d]", selectValue, countComboBox);
        webElementAction.clickElement(driver.findElement(By.xpath(xpathValue)));
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
}

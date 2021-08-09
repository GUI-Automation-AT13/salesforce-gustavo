package salesforce.lightning;

import core.utilities.strategy.FeaturesPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.BasePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkTypePage extends BasePage implements FeaturesPage {
    @FindBy(xpath = "//a[@class='forceActionLink'][@role='button']")
    protected WebElement newBtn;
    protected String xpathTable = "//a[text()='%s']/../../..//*[contains(.,'%s')][@role='gridcell']";
    protected String fieldWithUniqueName = "Work Type Name";

    @Override
    protected void waitForPageLoaded() {
        webElementAction.waitForElementVisibility(newBtn);
    }

    /**
     * Changes the page to create work type.
     *
     * @return workTypeForm initialize.
     */
    public WorkTypeForm clickNewButton() {
        webElementAction.clickElement(newBtn);
        return new WorkTypeForm();
    }

    /**
     * Gets value of cell in table according the name of column header (Estimated Duration and Duration Type)
     * and the unique Work Type Name.
     *
     * @param fieldUniqueName is field in arrow with is unique
     * @param nameOfColumnHeader a name of column header on table
     * @return a value of one element of table
     */
    public String getValueInTable(final String fieldUniqueName, final String nameOfColumnHeader) {
        return webElementAction.getTextOfElementByField(String.format(xpathTable, fieldUniqueName, nameOfColumnHeader));
    }

    @Override
    public List<String> getValueTables(final Map<String, String> table) {
        return getValues(new ArrayList<String>(table.keySet()), table.get(fieldWithUniqueName));
    }

    /**
     * Gets values of table according the work type name, this field is unique
     * only select field of table.
     *
     * @param valuesToGet is values to get
     * @param unitName    is value of work type name
     * @return a values of tables
     */
    public List<String> getValues(final List<String> valuesToGet, final String unitName) {
        Map<String, String> mapNew = new HashMap<>();
        mapNew.put(fieldWithUniqueName, unitName);
        valuesToGet.stream()
                .filter(v -> !v.equals(fieldWithUniqueName))
                .forEach(key -> mapNew.put(key, getValueInTable(unitName, key)));
        return new ArrayList<String>(mapNew.values());
    }
}
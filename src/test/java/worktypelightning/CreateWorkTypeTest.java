package worktypelightning;

import base.BaseTest;
import core.utilities.RandomCustom;
import org.testng.annotations.Test;
import salesforce.lightning.WorkTypePage;
import salesforce.lightning.WorkTypeForm;
import salesforce.lightning.WorkTypeCreated;
import core.utilities.date.CalendarManager;
import static org.testng.Assert.assertEquals;

public class CreateWorkTypeTest extends BaseTest {

    @Test
    public void createWorkTypeLightningSalesforce() {
        CalendarManager calendarManager = new CalendarManager();
        String workTypeName = "WorkType-Lightning " + RandomCustom.random();
        pageTransporter.navigateToPage("work Type", "Lightning");
        WorkTypePage workType = new WorkTypePage();
        WorkTypeForm workTypeForm = workType.clickNewButton();
        workTypeForm.setInputField("Work Type Name", workTypeName);
        workTypeForm.setInputField("Description", "Descriptions-test-22");
        workTypeForm.setInputField("Estimated Duration", "68");
        workTypeForm.setEstimatedDurationComboBox("Minutes");
        workTypeForm.setInputField("Block Time Before Appointment", "52");
        workTypeForm.setComboBoxField("Block Time Before Unit", "Minute(s)");
        workTypeForm.setInputField("Block Time After Appointment", "5");
        workTypeForm.setComboBoxField("Block Time After Unit", "Minute(s)");
        workTypeForm.setInputField("Timeframe Start", "4");
        workTypeForm.setComboBoxField("Time Frame Start Unit", "Day(s)");
        workTypeForm.setInputField("Timeframe End", "5");
        workTypeForm.setComboBoxField("Time Frame End Unit", "Day(s)");
        WorkTypeCreated workTypeInfo = workTypeForm.clickSaveButton();
        assertEquals(workTypeInfo.getNameOfWorkType(), workTypeName);
        assertEquals(workTypeInfo.getDescription(), "Descriptions-test-22");
        assertEquals(workTypeInfo.getTxtField("Estimated Duration"), "68,00");
        assertEquals(workTypeInfo.getTxtField("Block Time Before Appointment"), "52");
        assertEquals(workTypeInfo.getTxtField("Block Time After Appointment"), "5");
        assertEquals(workTypeInfo.getTxtField("Timeframe Start"), "4");
        assertEquals(workTypeInfo.getTxtField("Timeframe End"), "5");
        assertEquals(workTypeInfo.getCreatedByTxt(), calendarManager.generateDateActual("d/M/yyyy H:m"));
        assertEquals(workTypeInfo.getNameCreatorTxt(), nameOwner);
    }
}

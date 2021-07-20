package worktypelightning;

import base.BaseTest;
import salesforce.PageTransporter;
import salesforce.lightning.WorkTypeLightningPage;
import salesforce.lightning.WorkTypeForm;
import salesforce.lightning.WorkTypeInfo;
import static org.testng.Assert.assertEquals;

public class CreateWorkTypeTest extends BaseTest {

    //@Test
    public void createWorkTypeLightningSalesforce() {

        WorkTypeLightningPage workType = PageTransporter.navigateToWorkTypeLightningPage();
        WorkTypeForm workTypeForm = workType.clickNewButton();
        workTypeForm.setInputField("Work Type Name", "WorkType-created-Lightning-test");
        workTypeForm.setInputField("Description", "Descriptions-test-22");
        workTypeForm.setInputField("Estimated Duration", "68");
        workTypeForm.setEstimatedDurationComboBox("Minutes");
        workTypeForm.setInputField("Block Time Before Appointment", "52");
        workTypeForm.setComboBoxField("Block Time Before Unit", "Minute(s)");
        workTypeForm.setInputField("Block Time After Appointment", "5");
        workTypeForm.setComboBoxField("Block Time After Unit", "Hour(s)");
        workTypeForm.setInputField("Timeframe Start", "4");
        workTypeForm.setComboBoxField("Time Frame Start Unit", "Day(s)");
        workTypeForm.setInputField("Timeframe End", "5");
        WorkTypeInfo workTypeInfo = workTypeForm.clickSaveButton();
        assertEquals(workTypeInfo.getNameOfWorkType(), "WorkType-created-Lightning-test");
        assertEquals(workTypeInfo.getDescription(), "Descriptions-test-22");
        assertEquals(workTypeInfo.getTxtField("Estimated Duration"), "68,00");
        assertEquals(workTypeInfo.getTxtField("Block Time Before Appointment"), "52");
        assertEquals(workTypeInfo.getTxtField("Block Time After Appointment"), "5");
        assertEquals(workTypeInfo.getTxtField("Timeframe Start"), "4");
        assertEquals(workTypeInfo.getTxtField("Timeframe End"), "5");
    }


}

package worktypeclassic;

import base.BaseTest;
import org.testng.annotations.Test;
import salesforce.classic.WorkTypeClassicPage;
import salesforce.classic.WorkTypeForm;
import salesforce.classic.WorkTypeInfo;
import static org.testng.Assert.assertEquals;

public class CreateWorkTypeTest extends BaseTest {

    public void createWorkTypeToClassicSalesforce() {
        WorkTypeClassicPage workType = loginPage.goToClassic();
        workType.closeAnnouncement();
        WorkTypeForm workTypeForm = workType.clickNewButton();
        workTypeForm.setNameTxtBox("WorkType-created-Classic");
        workTypeForm.setEstimatedDurationTxtBox("45");
        WorkTypeInfo workTypeInfo = workTypeForm.clickSaveButton();
        assertEquals("WorkType-created-Classic",workTypeInfo.getNameOfWorkType());
    }
}

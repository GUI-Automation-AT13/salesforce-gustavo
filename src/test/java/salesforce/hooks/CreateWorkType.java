package salesforce.hooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.utilities.RandomCustom;
import io.cucumber.datatable.DataTable;
import salesforce.PageTransporter;
import salesforce.entities.worktype.WorkType;
import salesforce.lightning.WorkTypeForm;
import salesforce.lightning.WorkTypeInfo;
import salesforce.lightning.WorkTypeLightningPage;
import utilities.CalendarManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateWorkType {
    private PageTransporter pageTransporter = new PageTransporter();
    private CalendarManager calendarManager = new CalendarManager();

    public WorkType setWorkType(DataTable dataTable) {
        List<WorkType> workTypesList = new ArrayList<WorkType>();
        List<Map<String, String>> mapList = dataTable.transpose().asMaps();
        for (Map<String, String> map : mapList) {
            workTypesList.add(new ObjectMapper().convertValue(map, WorkType.class));
        }
        return workTypesList.get(0);
    }

    public WorkTypeInfo createWorkTypeForUI(WorkType workType) {
        System.out.println(workType.toString());
        String workTypeName = "WorkType-Lightning " + RandomCustom.random();
        pageTransporter.navigateToPage("work Type", "Lightning");
        WorkTypeLightningPage workTypePage = new WorkTypeLightningPage();
        WorkTypeForm workTypeForm = workTypePage.clickNewButton();
        workTypeForm.setInputField("Work Type Name", workType.getName());
        workTypeForm.setInputField("Estimated Duration", String.valueOf(workType.getEstimatedDuration()));
        workTypeForm.setInputField("Description", workType.getDescription());
        workTypeForm.setInputField("Block Time Before Appointment", String.valueOf(workType.getBlockTimeBeforeAppointment()));
        workTypeForm.setInputField("Block Time After Appointment", String.valueOf(workType.getBlockTimeAfterAppointment()));
        workTypeForm.setInputField("Timeframe Start", String.valueOf(workType.getTimeframeStart()));
        workTypeForm.setComboBoxField("Time Frame Start Unit", "Day(s)");
        workTypeForm.setInputField("Timeframe End", String.valueOf(workType.getTimeframeEnd()));
        return workTypeForm.clickSaveButton();
    }
}

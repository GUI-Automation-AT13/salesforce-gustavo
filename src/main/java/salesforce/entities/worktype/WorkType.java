package salesforce.entities.worktype;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkType {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String timeFrameStartUnit;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String lastModifiedDate;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String description;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String blockTimeBeforeUnit;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String lastReferencedDate;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double estimatedDuration;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String ownerId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String createdById;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private double durationInMinutes;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int timeframeEnd;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Object operatingHoursId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int blockTimeBeforeAppointment;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Object defaultAppointmentType;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String durationType;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean isDeleted;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String lastViewedDate;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String systemModstamp;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String createdDate;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Attributes attributes;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int timeframeStart;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String blockTimeAfterUnit;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String lastModifiedById;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int blockTimeAfterAppointment;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String timeFrameEndUnit;

    public void setTimeFrameStartUnit(final String timeFrameStartUnit) {
        this.timeFrameStartUnit = timeFrameStartUnit;
    }

    public String getTimeFrameStartUnit() {
        return timeFrameStartUnit;
    }

    public void setLastModifiedDate(final String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    @JsonProperty("Description")
    public void setDescription(final String description) {
        this.description = description;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    public void setBlockTimeBeforeUnit(final String blockTimeBeforeUnit) {
        this.blockTimeBeforeUnit = blockTimeBeforeUnit;
    }

    public String getBlockTimeBeforeUnit() {
        return blockTimeBeforeUnit;
    }

    public void setLastReferencedDate(final String lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public String getLastReferencedDate() {
        return lastReferencedDate;
    }

    @JsonProperty("Name")
    public void setName(final String name) {
        this.name = name;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Estimated Duration")
    public void setEstimatedDuration(final double estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    @JsonProperty("Estimated Duration")
    public double getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setOwnerId(final String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setCreatedById(final String createdById) {
        this.createdById = createdById;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setDurationInMinutes(final double durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getDurationInMinutes() {
        return durationInMinutes;
    }

    @JsonProperty("Timeframe End")
    public void setTimeframeEnd(final int timeframeEnd) {
        this.timeframeEnd = timeframeEnd;
    }

    @JsonProperty("Timeframe End")
    public int getTimeframeEnd() {
        return timeframeEnd;
    }

    public void setOperatingHoursId(final Object operatingHoursId) {
        this.operatingHoursId = operatingHoursId;
    }

    public Object getOperatingHoursId() {
        return operatingHoursId;
    }

    @JsonProperty("Block Time Before Appointment")
    public void setBlockTimeBeforeAppointment(final int blockTimeBeforeAppointment) {
        this.blockTimeBeforeAppointment = blockTimeBeforeAppointment;
    }

    @JsonProperty("Block Time Before Appointment")
    public int getBlockTimeBeforeAppointment() {
        return blockTimeBeforeAppointment;
    }

    public void setDefaultAppointmentType(final Object defaultAppointmentType) {
        this.defaultAppointmentType = defaultAppointmentType;
    }

    public Object getDefaultAppointmentType() {
        return defaultAppointmentType;
    }

    public void setDurationType(final String durationType) {
        this.durationType = durationType;
    }

    public String getDurationType() {
        return durationType;
    }

    public void setIsDeleted(final boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setLastViewedDate(final String lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public String getLastViewedDate() {
        return lastViewedDate;
    }

    public void setSystemModstamp(final String systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public String getSystemModstamp() {
        return systemModstamp;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setAttributes(final Attributes attributes) {
        this.attributes = attributes;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    @JsonProperty("Timeframe Start")
    public void setTimeframeStart(final int timeframeStart) {
        this.timeframeStart = timeframeStart;
    }

    @JsonProperty("Timeframe Start")
    public int getTimeframeStart() {
        return timeframeStart;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setBlockTimeAfterUnit(final String blockTimeAfterUnit) {
        this.blockTimeAfterUnit = blockTimeAfterUnit;
    }

    public String getBlockTimeAfterUnit() {
        return blockTimeAfterUnit;
    }

    public void setLastModifiedById(final String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    @JsonProperty("Block Time After Appointment")
    public void setBlockTimeAfterAppointment(final int blockTimeAfterAppointment) {
        this.blockTimeAfterAppointment = blockTimeAfterAppointment;
    }

    @JsonProperty("Block Time After Appointment")
    public int getBlockTimeAfterAppointment() {
        return blockTimeAfterAppointment;
    }

    public void setTimeFrameEndUnit(final String timeFrameEndUnit) {
        this.timeFrameEndUnit = timeFrameEndUnit;
    }

    public String getTimeFrameEndUnit() {
        return timeFrameEndUnit;
    }
}

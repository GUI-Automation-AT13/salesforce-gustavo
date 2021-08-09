package salesforce.entities.operatinghours;

import com.fasterxml.jackson.annotation.JsonInclude;

public class OperatingHours {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastModifiedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastViewedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastReferencedDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String systemModstamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String timeZone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdById;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Attributes attributes;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastModifiedById;

    public void setLastModifiedDate(final String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setDescription(final Object description) {
        this.description = description;
    }

    public Object getDescription() {
        return description;
    }

    public void setLastViewedDate(final String lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public String getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastReferencedDate(final String lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public String getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSystemModstamp(final String systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public String getSystemModstamp() {
        return systemModstamp;
    }

    public void setTimeZone(final String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setCreatedById(final String createdById) {
        this.createdById = createdById;
    }

    public String getCreatedById() {
        return createdById;
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

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setLastModifiedById(final String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }
}

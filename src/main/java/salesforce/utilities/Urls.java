package salesforce.utilities;

public enum Urls {
    PATH_LOGIN("https://login.salesforce.com/"),
    WORK_TYPE_LIGHTNING(UserDate.URL_PERSONAL.getValue()
            + "/lightning/o/WorkType/list?filterName=00B5e00000CELgSEAX"),
    WORK_TYPE_PAGE_LIGHTNING(UserDate.URL_PERSONAL.getValue()
            + "lightning/o/WorkType/list?filterName=Recent"),
    WORK_TYPE_CLASSIC(UserDate.URL_PERSONAL.getValue() + "08q/o"),
    TOKEN("https://login.salesforce.com/services/oauth2/token"),
    USER_INFO(UserDate.URL_PERSONAL.getValue() + "services/oauth2/userinfo"),
    WORK_TYPE(UserDate.URL_PERSONAL.getValue() + "services/data/v52.0/sobjects/WorkType/"),
    OPERATING_HOURS(UserDate.URL_PERSONAL.getValue() + "services/data/v52.0/sobjects/OperatingHours");


    private String value;

    Urls(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}

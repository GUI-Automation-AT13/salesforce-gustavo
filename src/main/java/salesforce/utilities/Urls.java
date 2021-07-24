package salesforce.utilities;

public enum Urls {
    PATH_LOGIN("https://login.salesforce.com/"),
    WORK_TYPE_LIGHTNING(UserDate.URL_PERSONAL.getValue()
            + "/lightning/o/WorkType/list?filterName=00B5e00000CELgSEAX"),
    WORK_TYPE_CLASSIC(UserDate.URL_PERSONAL.getValue() + "08q/o");


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

package salesforce.api;

public enum Header {
    SOBJECTS("sobjects"),
    AUTHORIZATION("Authorization"),
    BEARER("Bearer "),
    ACCEPT("Accept"),
    APPLICATION_JSON("application/json"),
    CONTENT_TYPE("Content-Type"),
    X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded");

    private String value;

    Header(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}

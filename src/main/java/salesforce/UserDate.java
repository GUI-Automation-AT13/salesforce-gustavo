package salesforce;

import static utilities.GetEnv.envVariable;

public enum UserDate {
    USERNAME(envVariable().get("USERNAME_VALUE")),
    PASSWORD(envVariable().get("PASSWORD_VALUE")),
    URL_PERSONAL(envVariable().get("URL_PERSONAL"));

    private String value;

    UserDate(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}

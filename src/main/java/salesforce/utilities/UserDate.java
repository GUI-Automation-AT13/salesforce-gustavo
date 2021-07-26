package salesforce.utilities;

import static core.utilities.GetEnv.envVariable;

public enum UserDate {
    USERNAME(envVariable().get("USERNAME_VALUE"), "username"),
    PASSWORD(envVariable().get("PASSWORD_VALUE"), "password"),
    GRANT_TYPE("password", "grant_type"),
    CLIENT_ID(envVariable().get("CLIENT_ID_VALUE"), "client_id"),
    CLIENT_SECRET(envVariable().get("CLIENT_SECRET_VALUE"), "client_secret"),
    URL_PERSONAL(envVariable().get("URL_PERSONAL"), "");

    private String value;
    private String key;

    UserDate(final String value, final String key) {
        this.value = value;
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }
}

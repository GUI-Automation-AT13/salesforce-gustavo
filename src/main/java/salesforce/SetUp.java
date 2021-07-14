package salesforce;

import static utilities.GetEnv.envVariable;

public enum SetUp {
    WAIT_TYPE(envVariable().get("WAIT_TYPE")),
    BROWSER(envVariable().get("BROWSER"));

    private String value;

    SetUp(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}

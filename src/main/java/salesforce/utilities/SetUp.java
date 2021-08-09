package salesforce.utilities;

import core.utilities.GetEnv;

public enum SetUp {
    WAIT_TYPE(GetEnv.getInstance().setEnvVariable().get("WAIT_TYPE")),
    BROWSER(GetEnv.getInstance().setEnvVariable().get("BROWSER")),
    DATE_FORMAT(GetEnv.getInstance().setEnvVariable().get("DATE_FORMAT"));

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

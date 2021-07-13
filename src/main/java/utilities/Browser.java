package utilities;

public enum Browser {
    CHROME("CHROME");

    private String browser;

    Browser(final String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(final String browser) {
        this.browser = browser;
    }
}

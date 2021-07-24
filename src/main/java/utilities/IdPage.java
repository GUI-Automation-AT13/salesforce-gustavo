package utilities;

public final class IdPage {

    private IdPage() {
    }

    /**
     * Gets id of workType.
     *
     * @param url of workType
     * @return id fo workType
     */
    public static String getIdWorKType(final String url) {
        String[] id = url.split("/");
        return id[id.length - 2];
    }
}

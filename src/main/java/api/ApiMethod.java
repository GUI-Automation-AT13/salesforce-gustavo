package api;

public enum ApiMethod {
    GET("GET"),
    POST("POST"),
    DELETE("DELETE"),
    PUT("PUT"),
    PATCH("PATCH");

    private String name;

    ApiMethod(final String name) {
        this.name = name;
    }

    /**
     * gets the enum.'s name.
     *
     * @return the name of our enum.
     */
    public String toName() {
        return name;
    }
}

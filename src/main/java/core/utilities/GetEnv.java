package core.utilities;

import io.github.cdimascio.dotenv.Dotenv;

public final class GetEnv {
    private static GetEnv getEnv;
    private static Dotenv dotenv;
    private static Dotenv dotenvCof;

    private GetEnv() {
    }

    /**
     * Gets value of external files.
     *
     * @return object with value of external files.
     */
    public static Dotenv envVariable() {
        return dotenv;
    }

    /**
     * Set envVariable to type of user.
     *
     * @param typeUser is type user
     */
    public void setEnvVariable(final String typeUser) {
        dotenv = Dotenv.configure().filename(String.format("%s.data", typeUser))
                .ignoreIfMalformed().ignoreIfMissing().load();
    }

    /**
     * Set envVariable to salesforce.
     *
     * @return object type Dotenv
     */
    public Dotenv setEnvVariable() {
        return Dotenv.configure()
                .filename("/src/main/resources/salesforce/configuration.data")
                .ignoreIfMalformed().ignoreIfMissing().load();
    }

    /**
     * Constructor of Interact.
     * Gets Interact as Singleton.
     *
     * @return a instance
     */
    public static GetEnv getInstance() {
        if (getEnv == null) {
            getEnv = new GetEnv();
        }
        return getEnv;
    }
}

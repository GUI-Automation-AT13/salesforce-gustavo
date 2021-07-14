package core.utilities;

import io.github.cdimascio.dotenv.Dotenv;

public final class GetEnv {
    private static GetEnv getEnv = null;
    private static Dotenv dotenv = Dotenv.configure().filename(".user.data")
            .ignoreIfMalformed().ignoreIfMissing().load();

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
}

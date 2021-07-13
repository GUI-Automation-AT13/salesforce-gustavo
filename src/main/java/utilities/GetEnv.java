package utilities;

import io.github.cdimascio.dotenv.Dotenv;

public final class GetEnv {
    private static Dotenv dotenv = Dotenv.configure().filename(".user.data")
            .ignoreIfMalformed().ignoreIfMissing().load();

    private GetEnv() {
        //not called
    }

    public static Dotenv envVariable() {
        return dotenv;
    }
}

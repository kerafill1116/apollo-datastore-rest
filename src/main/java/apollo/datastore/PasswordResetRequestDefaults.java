package apollo.datastore;

public class PasswordResetRequestDefaults {

    private static long requestDuration = 1L;

    public PasswordResetRequestDefaults() { }

    public static long getRequestDuration() {
        return requestDuration;
    }

    public static void setRequestDuration(long requestDuration) {
        PasswordResetRequestDefaults.requestDuration = requestDuration;
    }
}

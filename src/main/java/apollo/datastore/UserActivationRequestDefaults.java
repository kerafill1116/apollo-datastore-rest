package apollo.datastore;

public class UserActivationRequestDefaults {

    private static long requestDuration = 1L;

    public UserActivationRequestDefaults() { }

    public static long getRequestDuration() {
        return requestDuration;
    }

    public static void setRequestDuration(long requestDuration) {
        UserActivationRequestDefaults.requestDuration = requestDuration;
    }
}

package apollo.datastore;

public class UserDefaults {

    private static long maxSessions = 1L;
    private static boolean exclusiveSession = false;
    private static long sessionTimeout = 1800L;
    private static long maxFailedAttempts = 10L;
    private static boolean useTimeSlots = false;
    private static boolean preactivated = false;
    private static boolean disabled = false;

    public UserDefaults() { }

    public static long getMaxSessions() {
        return maxSessions;
    }

    public static void setMaxSessions(long maxSessions) {
        UserDefaults.maxSessions = maxSessions;
    }

    public static boolean isExclusiveSession() {
        return exclusiveSession;
    }

    public static boolean getExclusiveSession() {
        return exclusiveSession;
    }

    public static void setExclusiveSession(boolean exclusiveSession) {
        UserDefaults.exclusiveSession = exclusiveSession;
    }

    public static long getSessionTimeout() {
        return sessionTimeout;
    }

    public static void setSessionTimeout(long sessionTimeout) {
        UserDefaults.sessionTimeout = sessionTimeout;
    }

    public static long getMaxFailedAttempts() {
        return maxFailedAttempts;
    }

    public static void setMaxFailedAttempts(long maxFailedAttempts) {
        UserDefaults.maxFailedAttempts = maxFailedAttempts;
    }

    public static boolean isUseTimeSlots() {
        return useTimeSlots;
    }

    public static boolean getUseTimeSlots() {
        return useTimeSlots;
    }

    public static void setUseTimeSlots(boolean useTimeSlots) {
        UserDefaults.useTimeSlots = useTimeSlots;
    }

    public static boolean isPreactivated() {
        return preactivated;
    }

    public static boolean getPreactivated() {
        return preactivated;
    }

    public static void setPreactivated(boolean preactivated) {
        UserDefaults.preactivated = preactivated;
    }

    public static boolean isDisabled() {
        return disabled;
    }

    public static boolean getDisabled() {
        return disabled;
    }

    public static void setDisabled(boolean disabled) {
        UserDefaults.disabled = disabled;
    }
}

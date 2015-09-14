package apollo.datastore;

public class UserDefaultsImpl implements UserDefaultsInterface {

    private static long maxSessions = 1L;
    private static boolean exclusiveSession = false;
    private static long sessionTimeout = 1800L;
    private static long maxFailedAttempts = 10L;
    private static boolean useTimeSlots = false;
    private static boolean preactivated = false;
    private static boolean disabled = false;

    public UserDefaultsImpl() { }

    public long getMaxSessions() {
        return maxSessions;
    }

    public void setMaxSessions(long maxSessions) {
        UserDefaultsImpl.maxSessions = maxSessions;
    }

    public boolean isExclusiveSession() {
        return exclusiveSession;
    }

    public boolean getExclusiveSession() {
        return exclusiveSession;
    }

    public void setExclusiveSession(boolean exclusiveSession) {
        UserDefaultsImpl.exclusiveSession = exclusiveSession;
    }

    public long getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(long sessionTimeout) {
        UserDefaultsImpl.sessionTimeout = sessionTimeout;
    }

    public long getMaxFailedAttempts() {
        return maxFailedAttempts;
    }

    public void setMaxFailedAttempts(long maxFailedAttempts) {
        UserDefaultsImpl.maxFailedAttempts = maxFailedAttempts;
    }

    public boolean isUseTimeSlots() {
        return useTimeSlots;
    }

    public boolean getUseTimeSlots() {
        return useTimeSlots;
    }

    public void setUseTimeSlots(boolean useTimeSlots) {
        UserDefaultsImpl.useTimeSlots = useTimeSlots;
    }

    public boolean isPreactivated() {
        return preactivated;
    }

    public boolean getPreactivated() {
        return preactivated;
    }

    public void setPreactivated(boolean preactivated) {
        UserDefaultsImpl.preactivated = preactivated;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        UserDefaultsImpl.disabled = disabled;
    }
}

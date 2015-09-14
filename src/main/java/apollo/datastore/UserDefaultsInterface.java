package apollo.datastore;

public interface UserDefaultsInterface {
    long getMaxSessions();
    void setMaxSessions(long maxSessions);
    boolean isExclusiveSession();
    boolean getExclusiveSession();
    void setExclusiveSession(boolean exclusiveSession);
    long getSessionTimeout();
    void setSessionTimeout(long sessionTimeout);
    long getMaxFailedAttempts();
    void setMaxFailedAttempts(long maxFailedAttempts);
    boolean isUseTimeSlots();
    boolean getUseTimeSlots();
    void setUseTimeSlots(boolean useTimeSlots);
    boolean isPreactivated();
    boolean getPreactivated();
    void setPreactivated(boolean preactivated);
    boolean isDisabled();
    boolean getDisabled();
    void setDisabled(boolean disabled);
}

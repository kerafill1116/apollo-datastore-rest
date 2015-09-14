package apollo.datastore;

public interface UserDefaultsInterface {
    public long getMaxSessions();
    public void setMaxSessions(long maxSessions);
    public boolean isExclusiveSession();
    public boolean getExclusiveSession();
    public void setExclusiveSession(boolean exclusiveSession);
    public long getSessionTimeout();
    public void setSessionTimeout(long sessionTimeout);
    public long getMaxFailedAttempts();
    public void setMaxFailedAttempts(long maxFailedAttempts);
    public boolean isUseTimeSlots();
    public boolean getUseTimeSlots();
    public void setUseTimeSlots(boolean useTimeSlots);
    public boolean isPreactivated();
    public boolean getPreactivated();
    public void setPreactivated(boolean preactivated);
    public boolean isDisabled();
    public boolean getDisabled();
    public void setDisabled(boolean disabled);
}

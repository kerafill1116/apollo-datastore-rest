package apollo.datastore;

import java.util.Date;

public class User {

    public static final MiscFunctions.HashAlgorithm PASSWORD_HASH_ALGORITHM = MiscFunctions.HashAlgorithm.SHA_256;

    private String userId;
    private String password;
    private String emailAddress;
    private boolean activated;
    private boolean disabled;
    private long maxSessions;
    private boolean exclusiveSession;
    private long sessionTimeout;
    private long failedAttempts;
    private long maxFailedAttempts;
    private boolean useTimeSlots;
    private String timeZoneId;
    private Date dateCreated;

    private User() { }

    public User(String userId, String password, String emailAddress, String timeZoneId, UserDefaultsInterface defaults) {
        this.userId = userId;
        this.password = MiscFunctions.getEncryptedHash(password, PASSWORD_HASH_ALGORITHM);
        this.emailAddress = emailAddress;
        this.activated = defaults.isPreactivated();
        this.disabled = defaults.isDisabled();
        this.maxSessions = defaults.getMaxSessions();
        this.exclusiveSession = defaults.isExclusiveSession();
        this.sessionTimeout = defaults.getSessionTimeout();
        this.failedAttempts = 0L;
        this.maxFailedAttempts = defaults.getMaxFailedAttempts();
        this.useTimeSlots = defaults.isUseTimeSlots();
        this.timeZoneId = timeZoneId;
        this.dateCreated = new Date();
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = MiscFunctions.getEncryptedHash(password, PASSWORD_HASH_ALGORITHM);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isActivated() {
        return activated;
    }

    public boolean getActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public long getMaxSessions() {
        return maxSessions;
    }

    public void setMaxSessions(long maxSessions) {
        this.maxSessions = maxSessions;
    }

    public boolean isExclusiveSession() {
        return exclusiveSession;
    }

    public boolean getExclusiveSession() {
        return exclusiveSession;
    }

    public void setExclusiveSession(boolean exclusiveSession) {
        this.exclusiveSession = exclusiveSession;
    }

    public long getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public long getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(long failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public long getMaxFailedAttempts() {
        return maxFailedAttempts;
    }

    public void setMaxFailedAttempts(long maxFailedAttempts) {
        this.maxFailedAttempts = maxFailedAttempts;
    }

    public boolean isUseTimeSlots() {
        return useTimeSlots;
    }

    public boolean getUseTimeSlots() {
        return useTimeSlots;
    }

    public void setUseTimeSlots(boolean useTimeSlots) {
        this.useTimeSlots = useTimeSlots;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}

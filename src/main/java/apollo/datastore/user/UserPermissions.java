package apollo.datastore.user;

public enum UserPermissions {

    // CHANGE_USER_ID            (1),
    CHANGE_PASSWORD           (1 << 1),
    VIEW_EMAIL_ADDRESS        (1 << 2),
    CHANGE_EMAIL_ADDRESS      (1 << 3),
    VIEW_MAX_SESSIONS         (1 << 4),
    CHANGE_MAX_SESSIONS       (1 << 5),
    VIEW_EXCLUSIVE_SESSION    (1 << 6),
    CHANGE_EXCLUSIVE_SESSION  (1 << 7),
    VIEW_SESSION_TIMEOUT      (1 << 8),
    CHANGE_SESSION_TIMEOUT    (1 << 9),
    VIEW_MAX_FAILED_ATTEMPTS  (1 << 10),
    CHANGE_MAX_FAILED_ATTEMPTS(1 << 11),
    VIEW_TIME_ZONE            (1 << 12),
    CHANGE_TIME_ZONE          (1 << 13),
    VIEW_DISABLED_STATUS      (1 << 14),
    VIEW_ACTIVATED_STATUS     (1 << 15),
    VIEW_USER_PERMISSIONS     (1 << 17),
    CHANGE_USER_PERMISSIONS   (1 << 18),
    ALL_PERMISSIONS           ((1 << 19) - 1),
    DEFAULT_PERMISSIONS       (CHANGE_PASSWORD.code +
            VIEW_EMAIL_ADDRESS.code +
            VIEW_TIME_ZONE.code +
            CHANGE_TIME_ZONE.code +
            VIEW_DISABLED_STATUS.code +
            VIEW_ACTIVATED_STATUS.code);

    private final long code;

    UserPermissions(long code) {
        this.code = code;
    }

    public long getCode() {
        return code;
    }
}

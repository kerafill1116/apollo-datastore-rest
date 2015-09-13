package apollo.datastore.user;

public enum SessionPermissions {

    VIEW_SESSIONS             (1),
    DISCONNECT_SESSIONS       (1 << 1),
    VIEW_SESSION_PERMISSIONS  (1 << 2),
    CHANGE_SESSION_PERMISSIONS(1 << 3),
    ALL_PERMISSIONS           ((1 << 4) - 1),
    DEFAULT_PERMISSIONS       (0);

    private final long code;

    SessionPermissions(long code) {
        this.code = code;
    }

    public long getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}

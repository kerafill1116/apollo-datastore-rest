package apollo.datastore.admin;

public enum SessionLogsPermissions {

    VIEW_SESSION_LOGS              (1),
    REMOVE_SESSION_LOGS            (1 << 1),
    VIEW_SESSION_LOGS_PERMISSIONS  (1 << 2),
    CHANGE_SESSION_LOGS_PERMISSIONS(1 << 3),
    ALL_PERMISSIONS                ((1 << 4) - 1),
    DEFAULT_PERMISSIONS            (0);

    private final long code;

    SessionLogsPermissions(long code) {
        this.code = code;
    }

    public long getCode() {
        return code;
    }
}

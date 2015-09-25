package apollo.datastore.utils;

public enum Error {
    NONE(0),
    REQUIRED_USER_ID(1),
    NON_EXISTENT_USER(2),
    INCORRECT_PASSWORD(3),
    MAXED_FAILED_ATTEMPTS(4),
    NOT_ACTIVATED_USER(5),
    DISABLED_USER(6);

    private final long code;

    Error(long code) {
        this.code = code;
    }

    public long getCode() {
        return code;
    }
}

package apollo.datastore.utils;

public enum Error {
    NONE(0),
    REQUIRED_USER_ID(1);

    private final long code;

    Error(long code) {
        this.code = code;
    }

    public long getCode() {
        return code;
    }
}

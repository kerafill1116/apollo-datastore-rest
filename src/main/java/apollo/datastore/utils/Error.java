package apollo.datastore.utils;

import org.omg.PortableInterceptor.NON_EXISTENT;

public enum Error {
    NONE(0),
    REQUIRED_USER_ID(1),
    NON_EXISTENT_USER(2);

    private final long code;

    Error(long code) {
        this.code = code;
    }

    public long getCode() {
        return code;
    }
}

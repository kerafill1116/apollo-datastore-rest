package apollo.datastore;

public enum CauseOfDisconnect {

    NONE(0),
    EXCLUSIVE_SESSION(1),
    TIMED_OUT_SESSION(2),
    DISCONNECTED_SESSION(3),
    INVALID_CAUSE_OF_DISCONNECT(4);

    private final long code;

    CauseOfDisconnect(long code) {
        this.code = code;
    }

    public long getCode() {
        return code;
    }
}

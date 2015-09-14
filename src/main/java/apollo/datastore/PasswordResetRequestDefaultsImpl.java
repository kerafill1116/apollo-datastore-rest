package apollo.datastore;

public class PasswordResetRequestDefaultsImpl implements PasswordRequestDefaultsInterface {

    private static long requestDuration = 1L;

    public PasswordResetRequestDefaultsImpl() { }

    public long getRequestDuration() {
        return requestDuration;
    }

    public void setRequestDuration(long requestDuration) {
        PasswordResetRequestDefaultsImpl.requestDuration = requestDuration;
    }
}

package apollo.datastore;

public class UserActivationRequestDefaultsImpl implements UserActivationRequestDefaultsInterface {

    private static long requestDuration = 1L;

    public UserActivationRequestDefaultsImpl() { }

    public long getRequestDuration() {
        return requestDuration;
    }

    public void setRequestDuration(long requestDuration) {
        UserActivationRequestDefaultsImpl.requestDuration = requestDuration;
    }
}

package apollo.datastore;

import java.util.Date;

public class PasswordResetRequest {

    public static final MiscFunctions.HashAlgorithm REQUEST_ID_HASH_ALGORITHM = MiscFunctions.HashAlgorithm.MD5;

    private String userId;
    private Date dateRequested;
    private String requestId;
    private long requestDuration;

    private PasswordResetRequest() { }

    public PasswordResetRequest(String userId, Date dateRequested, PasswordRequestDefaultsInterface defaults) {
        this.userId = userId;
        this.dateRequested = dateRequested;
        requestId = MiscFunctions.getEncryptedHash(String.valueOf(dateRequested.getTime()) + userId, REQUEST_ID_HASH_ALGORITHM);
        requestDuration = defaults.getRequestDuration();
    }

    public String getUserId() {
        return userId;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public String getRequestId() {
        return requestId;
    }

    public long getRequestDuration() {
        return requestDuration;
    }
}

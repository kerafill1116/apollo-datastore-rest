package apollo.datastore;

import java.util.Date;

public class PasswordResetRequest {

    public static final MiscFunctions.HashAlgorithm REQUEST_ID_HASH_ALGORITHM = MiscFunctions.HashAlgorithm.MD5;

    private String userId;
    private Date dateRequested;
    private String requestId;
    private long requestDuration;

    public PasswordResetRequest(String userId) {
        this.userId = userId;
        dateRequested = new Date();
        requestId = MiscFunctions.getEncryptedHash(String.valueOf(dateRequested.getTime()) + userId, REQUEST_ID_HASH_ALGORITHM);
        requestDuration = PasswordResetRequestDefaults.getRequestDuration();
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

package apollo.datastore;

import java.util.Date;

public class EmailAddressChangeRequest {

    public static final MiscFunctions.HashAlgorithm REQUEST_ID_HASH_ALGORITHM = MiscFunctions.HashAlgorithm.MD5;

    private String userId;
    private String newEmailAddress;
    private Date dateRequested;
    private String requestId;

    private EmailAddressChangeRequest() { }

    public EmailAddressChangeRequest(String userId, String newEmailAddress, Date dateRequested) {
        this.userId = userId;
        this.newEmailAddress = newEmailAddress;
        this.dateRequested = dateRequested;
        requestId = MiscFunctions.getEncryptedHash(String.valueOf(dateRequested.getTime()) + userId, REQUEST_ID_HASH_ALGORITHM);
    }

    public String getUserId() {
        return userId;
    }

    public String getNewEmailAddress() {
        return newEmailAddress;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public String getRequestId() {
        return requestId;
    }
}

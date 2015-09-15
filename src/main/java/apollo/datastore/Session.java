package apollo.datastore;

import java.util.Date;

public class Session {

    public static final MiscFunctions.HashAlgorithm SESSION_ID_HASH_ALGORITHM = MiscFunctions.HashAlgorithm.SHA_256;

    private String sessionId;
    private String userId;
    private Date dateSignedIn;
    private Date lastSessionCheck;
    private long sessionTimeout;
    private Date dateSignedOut;
    private CauseOfDisconnect causeOfDisconnect;

    private Session() { }

    public Session(User user, Date dateSignedIn) {
        this.sessionId = MiscFunctions.getEncryptedHash(String.valueOf(dateSignedIn.getTime()) + user.getUserId(), SESSION_ID_HASH_ALGORITHM);
        this.userId = user.getUserId();
        this.dateSignedIn = dateSignedIn;
        this.lastSessionCheck = dateSignedIn;
        this.sessionTimeout = user.getSessionTimeout();
        this.dateSignedOut = null;
        this.causeOfDisconnect = null;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public Date getDateSignedIn() {
        return dateSignedIn;
    }

    public Date getLastSessionCheck() {
        return lastSessionCheck;
    }

    public void setLastSessionCheck(Date lastSessionCheck) {
        this.lastSessionCheck = lastSessionCheck;
    }

    public long getSessionTimeout() {
        return sessionTimeout;
    }

    public Date getDateSignedOut() {
        return dateSignedOut;
    }

    public void setDateSignedOut(Date dateSignedOut) {
        this.dateSignedOut = dateSignedOut;
    }

    public CauseOfDisconnect getCauseOfDisconnect() {
        return causeOfDisconnect;
    }

    public void setCauseOfDisconnect(CauseOfDisconnect causeOfDisconnect) {
        this.causeOfDisconnect = causeOfDisconnect;
    }
}

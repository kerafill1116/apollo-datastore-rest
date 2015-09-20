package apollo.datastore;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.Date;

@Entity
public class SessionLog {

    @Id
    private String sessionId;
    private String userId;
    private Date dateSignedIn;
    private Date lastSessionCheck;
    private long sessionTimeout;
    private Date dateSignedOut;
    private CauseOfDisconnect causeOfDisconnect;

    private SessionLog() { }

    public SessionLog(Session session) {
        sessionId = session.getSessionId();
        userId = session.getUserId();
        dateSignedIn = session.getDateSignedIn();
        lastSessionCheck = session.getLastSessionCheck();
        sessionTimeout = session.getSessionTimeout();
        dateSignedOut = null;
        causeOfDisconnect = null;
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

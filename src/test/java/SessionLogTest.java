import static org.junit.Assert.*;

import apollo.datastore.CauseOfDisconnect;
import apollo.datastore.Session;
import apollo.datastore.SessionLog;
import apollo.datastore.User;
import apollo.datastore.UserDefaultsImpl;
import apollo.datastore.UserDefaultsInterface;

import java.util.Date;

import org.junit.*;

public class SessionLogTest {

    private Session session;

    @Before
    public void setUp() {
        String userId = "admin";
        String password = "admin";
        String emailAddress = "kerafill1116@gmail.com";
        // 32400;asia_tokyo;Asia/Tokyo
        String timeZoneId = "asia_tokyo";
        UserDefaultsInterface defaults = new UserDefaultsImpl();
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        Date dateSignedIn = new Date();
        session = new Session(user, dateSignedIn);
    }

    @Test
    public void testSession() {
        SessionLog sessionLog = new SessionLog(session);
        assertEquals(session.getSessionId(), sessionLog.getSessionId());
        assertEquals(session.getUserId(), sessionLog.getUserId());
        assertEquals(session.getDateSignedIn(), sessionLog.getDateSignedIn());
        assertEquals(session.getLastSessionCheck(), sessionLog.getLastSessionCheck());
        assertEquals(session.getSessionTimeout(), sessionLog.getSessionTimeout());
        assertEquals(null, sessionLog.getDateSignedOut());
        assertEquals(null, sessionLog.getCauseOfDisconnect());
    }

    @Test
    public void testSetDateSignedOut() {
        SessionLog sessionLog = new SessionLog(session);
        assertEquals(null, sessionLog.getDateSignedOut());
        Date newDateSignedOut = new Date();
        sessionLog.setDateSignedOut(newDateSignedOut);
        assertEquals(newDateSignedOut, sessionLog.getDateSignedOut());
    }

    @Test
    public void testSetCauseOfDisconnect() {
        SessionLog sessionLog = new SessionLog(session);
        assertEquals(null, sessionLog.getCauseOfDisconnect());
        CauseOfDisconnect newCauseOfDisconnect = CauseOfDisconnect.TIMED_OUT_SESSION;
        sessionLog.setCauseOfDisconnect(newCauseOfDisconnect);
        assertEquals(newCauseOfDisconnect, sessionLog.getCauseOfDisconnect());
    }
}

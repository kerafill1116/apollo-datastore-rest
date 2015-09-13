import static org.junit.Assert.*;

import apollo.datastore.CauseOfDisconnect;
import apollo.datastore.MiscFunctions;
import apollo.datastore.Session;
import apollo.datastore.User;

import java.util.Calendar;
import java.util.Date;

import org.junit.*;

public class SessionTest {

    private User user;

    @Before
    public void setUp() {
        String userId = "admin";
        String password = "admin";
        String emailAddress = "kerafill1116@gmail.com";
        // 32400;asia_tokyo;Asia/Tokyo
        String timeZoneId = "asia_tokyo";
        user = new User(userId, password, emailAddress, timeZoneId);
    }

    @Test
    public void testUserDate() {
        Session session = new Session(user);
        assertEquals(MiscFunctions.getEncryptedHash(String.valueOf(session.getDateSignedIn().getTime()) + user.getUserId(), Session.SESSION_ID_HASH_ALGORITHM), session.getSessionId());
        assertEquals(user.getUserId(), session.getUserId());
        assertEquals(session.getDateSignedIn(), session.getLastSessionCheck());
        assertEquals(user.getSessionTimeout(), session.getSessionTimeout());
        assertEquals(null, session.getDateSignedOut());
        assertEquals(null, session.getCauseOfDisconnect());
    }

    @Test
    public void testSetLastSessionCheck() {
        Session session = new Session(user);
        assertEquals(session.getDateSignedIn(), session.getLastSessionCheck());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date newLastSessionCheck = calendar.getTime();
        session.setLastSessionCheck(newLastSessionCheck);
        assertEquals(newLastSessionCheck, session.getLastSessionCheck());
    }

    @Test
    public void testSetDateSignedOut() {
        Session session = new Session(user);
        assertEquals(null, session.getDateSignedOut());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        Date newDateSignedOut = calendar.getTime();
        session.setDateSignedOut(newDateSignedOut);
        assertEquals(newDateSignedOut, session.getDateSignedOut());

    }

    @Test
    public void testSetCauseOfDisconnect() {
        Session session = new Session(user);
        assertEquals(null, session.getCauseOfDisconnect());
        CauseOfDisconnect newCauseOfDisconnect = CauseOfDisconnect.TIMED_OUT_SESSION;
        session.setCauseOfDisconnect(newCauseOfDisconnect);
        assertEquals(newCauseOfDisconnect, session.getCauseOfDisconnect());
    }
}

import static org.junit.Assert.*;

import apollo.datastore.UserDefaults;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDefaultsTest {

    @Test
    public void testGetMaxSessions() {
        assertEquals(1L, UserDefaults.getMaxSessions());
    }

    @Test
    public void testSetMaxSessions() {
        assertEquals(1L, UserDefaults.getMaxSessions());
        long newMaxSessions = 10L;
        UserDefaults.setMaxSessions(newMaxSessions);
        assertEquals(newMaxSessions, UserDefaults.getMaxSessions());
    }

    @Test
    public void testIsExclusiveSession() {
        assertEquals(false, UserDefaults.isExclusiveSession());
    }

    @Test
    public void testGetExclusiveSession() {
        assertEquals(false, UserDefaults.getExclusiveSession());
    }

    @Test
    public void testSetExclusiveSession() {
        assertEquals(false, UserDefaults.getExclusiveSession());
        boolean notExclusiveSession = !UserDefaults.getExclusiveSession();
        UserDefaults.setExclusiveSession(notExclusiveSession);
        assertEquals(notExclusiveSession, UserDefaults.getExclusiveSession());
    }

    @Test
    public void testGetSessionTimeout() {
        assertEquals(1800L, UserDefaults.getSessionTimeout());
    }

    @Test
    public void testSetSessionTimeout() {
        assertEquals(1800L, UserDefaults.getSessionTimeout());
        long newSessionTimeout = 3600L;
        UserDefaults.setSessionTimeout(newSessionTimeout);
        assertEquals(newSessionTimeout, UserDefaults.getSessionTimeout());
    }

    @Test
    public void testGetMaxFailedAttempts() {
        assertEquals(10L, UserDefaults.getMaxFailedAttempts());
    }

    @Test
    public void testSetMaxFailedAttempts() {
        assertEquals(10L, UserDefaults.getMaxFailedAttempts());
        long newMaxFailedAttempts = 3L;
        UserDefaults.setMaxFailedAttempts(newMaxFailedAttempts);
        assertEquals(newMaxFailedAttempts, UserDefaults.getMaxFailedAttempts());
    }

    @Test
    public void testIsUseTimeSlots() {
        assertEquals(false, UserDefaults.isUseTimeSlots());
    }

    @Test
    public void testGetUseTimeSlots() {
        assertEquals(false, UserDefaults.getUseTimeSlots());
    }

    @Test
    public void testSetUseTimeSlots() {
        assertEquals(false, UserDefaults.getUseTimeSlots());
        boolean notUseTimeSlots = !UserDefaults.getUseTimeSlots();
        UserDefaults.setUseTimeSlots(notUseTimeSlots);
        assertEquals(notUseTimeSlots, UserDefaults.getUseTimeSlots());
    }

    @Test
    public void testIsPreactivated() {
        assertEquals(false, UserDefaults.isPreactivated());
    }

    @Test
    public void testGetPreactivated() {
        assertEquals(false, UserDefaults.getPreactivated());
    }

    @Test
    public void testSetPreactivated() {
        assertEquals(false, UserDefaults.getPreactivated());
        boolean notPreactivated = !UserDefaults.getPreactivated();
        UserDefaults.setPreactivated(notPreactivated);
        assertEquals(notPreactivated, UserDefaults.getPreactivated());
    }

    @Test
    public void testIsDisabled() {
        assertEquals(false, UserDefaults.isDisabled());
    }

    @Test
    public void testGetDisabled() {
        assertEquals(false, UserDefaults.getDisabled());
    }

    @Test
    public void testSetDisabled() {
        assertEquals(false, UserDefaults.getDisabled());
        boolean notDisabled = !UserDefaults.getDisabled();
        UserDefaults.setDisabled(notDisabled);
        assertEquals(notDisabled, UserDefaults.getDisabled());
    }
}

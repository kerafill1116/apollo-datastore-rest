import static org.junit.Assert.*;

import apollo.datastore.UserDefaultsImpl;
import apollo.datastore.UserDefaultsInterface;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDefaultsImplTest {

    private UserDefaultsInterface defaults = new UserDefaultsImpl();

    @Test
    public void testGetMaxSessions() {
        assertEquals(1L, defaults.getMaxSessions());
    }

    @Test
    public void testSetMaxSessions() {
        assertEquals(1L, defaults.getMaxSessions());
        long newMaxSessions = 10L;
        defaults.setMaxSessions(newMaxSessions);
        assertEquals(newMaxSessions, defaults.getMaxSessions());
    }

    @Test
    public void testIsExclusiveSession() {
        assertEquals(false, defaults.isExclusiveSession());
    }

    @Test
    public void testGetExclusiveSession() {
        assertEquals(false, defaults.getExclusiveSession());
    }

    @Test
    public void testSetExclusiveSession() {
        assertEquals(false, defaults.getExclusiveSession());
        boolean notExclusiveSession = !defaults.getExclusiveSession();
        defaults.setExclusiveSession(notExclusiveSession);
        assertEquals(notExclusiveSession, defaults.getExclusiveSession());
    }

    @Test
    public void testGetSessionTimeout() {
        assertEquals(1800L, defaults.getSessionTimeout());
    }

    @Test
    public void testSetSessionTimeout() {
        assertEquals(1800L, defaults.getSessionTimeout());
        long newSessionTimeout = 3600L;
        defaults.setSessionTimeout(newSessionTimeout);
        assertEquals(newSessionTimeout, defaults.getSessionTimeout());
    }

    @Test
    public void testGetMaxFailedAttempts() {
        assertEquals(10L, defaults.getMaxFailedAttempts());
    }

    @Test
    public void testSetMaxFailedAttempts() {
        assertEquals(10L, defaults.getMaxFailedAttempts());
        long newMaxFailedAttempts = 3L;
        defaults.setMaxFailedAttempts(newMaxFailedAttempts);
        assertEquals(newMaxFailedAttempts, defaults.getMaxFailedAttempts());
    }

    @Test
    public void testIsUseTimeSlots() {
        assertEquals(false, defaults.isUseTimeSlots());
    }

    @Test
    public void testGetUseTimeSlots() {
        assertEquals(false, defaults.getUseTimeSlots());
    }

    @Test
    public void testSetUseTimeSlots() {
        assertEquals(false, defaults.getUseTimeSlots());
        boolean notUseTimeSlots = !defaults.getUseTimeSlots();
        defaults.setUseTimeSlots(notUseTimeSlots);
        assertEquals(notUseTimeSlots, defaults.getUseTimeSlots());
    }

    @Test
    public void testIsPreactivated() {
        assertEquals(false, defaults.isPreactivated());
    }

    @Test
    public void testGetPreactivated() {
        assertEquals(false, defaults.getPreactivated());
    }

    @Test
    public void testSetPreactivated() {
        assertEquals(false, defaults.getPreactivated());
        boolean notPreactivated = !defaults.getPreactivated();
        defaults.setPreactivated(notPreactivated);
        assertEquals(notPreactivated, defaults.getPreactivated());
    }

    @Test
    public void testIsDisabled() {
        assertEquals(false, defaults.isDisabled());
    }

    @Test
    public void testGetDisabled() {
        assertEquals(false, defaults.getDisabled());
    }

    @Test
    public void testSetDisabled() {
        assertEquals(false, defaults.getDisabled());
        boolean notDisabled = !defaults.getDisabled();
        defaults.setDisabled(notDisabled);
        assertEquals(notDisabled, defaults.getDisabled());
    }
}

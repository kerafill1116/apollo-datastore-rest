import static org.junit.Assert.*;

import apollo.datastore.MiscFunctions;
import apollo.datastore.User;
import apollo.datastore.UserDefaultsImpl;
import apollo.datastore.UserDefaultsInterface;

import org.junit.*;

public class UserTest {

    private String userId = "admin";
    private String password = "admin";
    private String emailAddress = "kerafill1116@gmail.com";
    // 32400;asia_tokyo;Asia/Tokyo
    private String timeZoneId = "asia_tokyo";
    private UserDefaultsInterface defaults = new UserDefaultsImpl();


    @Test
    public void testStringStringStringString() {
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        assertEquals(userId, user.getUserId());
        assertEquals(MiscFunctions.getEncryptedHash(password, User.PASSWORD_HASH_ALGORITHM), user.getPassword());
        assertEquals(emailAddress, user.getEmailAddress());
        assertEquals(defaults.getPreactivated(), user.getActivated());
        assertEquals(defaults.isPreactivated(), user.isActivated());
        assertEquals(user.getActivated(), user.isActivated());
        assertEquals(defaults.getDisabled(), user.getDisabled());
        assertEquals(defaults.isDisabled(), user.isDisabled());
        assertEquals(user.getDisabled(), user.isDisabled());
        assertEquals(defaults.getMaxSessions(), user.getMaxSessions());
        assertEquals(defaults.getExclusiveSession(), user.getExclusiveSession());
        assertEquals(defaults.isExclusiveSession(), user.isExclusiveSession());
        assertEquals(user.getExclusiveSession(), user.isExclusiveSession());
        assertEquals(defaults.getSessionTimeout(), user.getSessionTimeout());
        assertEquals(0L, user.getFailedAttempts());
        assertEquals(defaults.getMaxFailedAttempts(), user.getMaxFailedAttempts());
        assertEquals(defaults.getUseTimeSlots(), user.getUseTimeSlots());
        assertEquals(defaults.isUseTimeSlots(), user.isUseTimeSlots());
        assertEquals(user.getUseTimeSlots(), user.isUseTimeSlots());
        assertEquals(timeZoneId, user.getTimeZoneId());
    }

    @Test
    public void testSetPassword() {
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        assertEquals(MiscFunctions.getEncryptedHash(password, User.PASSWORD_HASH_ALGORITHM), user.getPassword());
        String newPassword = "newPassword";
        user.setPassword(newPassword);
        assertEquals(MiscFunctions.getEncryptedHash(newPassword, User.PASSWORD_HASH_ALGORITHM), user.getPassword());
    }

    @Test
    public void testSetEmailAddress() {
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        assertEquals(emailAddress, user.getEmailAddress());
        String newEmailAddress = "new@email.address";
        user.setEmailAddress(newEmailAddress);
        assertEquals(newEmailAddress, user.getEmailAddress());
    }

    @Test
    public void testSetActivated() {
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        assertEquals(defaults.getPreactivated(), user.getActivated());
        boolean notPreactivated = !defaults.getPreactivated();
        user.setActivated(notPreactivated);
        assertEquals(notPreactivated, user.getActivated());
    }

    @Test
    public void testSetDisabled() {
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        assertEquals(defaults.getDisabled(), user.getDisabled());
        boolean notDisabled = !defaults.getDisabled();
        user.setDisabled(notDisabled);
        assertEquals(notDisabled, user.getDisabled());
    }

    @Test
    public void testSetMaxSessions() {
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        assertEquals(defaults.getMaxSessions(), user.getMaxSessions());
        long newMaxSessions = 14344L;
        user.setMaxSessions(newMaxSessions);
        assertEquals(newMaxSessions, user.getMaxSessions());
    }

    @Test
    public void testSetExclusiveSession() {
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        assertEquals(defaults.getExclusiveSession(), user.getExclusiveSession());
        boolean notExclusiveSession = !defaults.getExclusiveSession();
        user.setExclusiveSession(notExclusiveSession);
        assertEquals(notExclusiveSession, user.getExclusiveSession());
    }

    @Test
    public void testSetSessionTimeout() {
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        assertEquals(defaults.getSessionTimeout(), user.getSessionTimeout());
        long newSessionTimeout = 14344L;
        user.setSessionTimeout(newSessionTimeout);
        assertEquals(newSessionTimeout, user.getSessionTimeout());
    }

    @Test
    public void testSetFailedAttempts() {
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        assertEquals(0L, user.getFailedAttempts());
        long newFailedAttempts = 14344L;
        user.setFailedAttempts(newFailedAttempts);
        assertEquals(newFailedAttempts, user.getFailedAttempts());
    }

    @Test
    public void testSetMaxFailedAttempts() {
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        assertEquals(defaults.getMaxFailedAttempts(), user.getMaxFailedAttempts());
        long newMaxFailedAttempts = 14344L;
        user.setMaxFailedAttempts(newMaxFailedAttempts);
        assertEquals(newMaxFailedAttempts, user.getMaxFailedAttempts());
    }

    @Test
    public void testSetUseTimeSlots() {
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        assertEquals(defaults.getUseTimeSlots(), user.getUseTimeSlots());
        boolean notUseTimeSlots = !defaults.getUseTimeSlots();
        user.setUseTimeSlots(notUseTimeSlots);
        assertEquals(notUseTimeSlots, user.getUseTimeSlots());
    }

    @Test
    public void testSetTimeZoneId() {
        User user = new User(userId, password, emailAddress, timeZoneId, defaults);
        assertEquals(timeZoneId, user.getTimeZoneId());
        // 28800;asia_singapore;Asia/Singapore
        String newTimeZoneId = "asia_singapore";
        user.setTimeZoneId(newTimeZoneId);
        assertEquals(newTimeZoneId, user.getTimeZoneId());
    }
}

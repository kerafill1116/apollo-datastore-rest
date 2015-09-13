import static org.junit.Assert.*;

import apollo.datastore.UserPermissions;
import apollo.datastore.user.*;

import org.junit.*;

public class UserPermissionsTest {

    private String userId = "admin";
    private long userPermissions = apollo.datastore.user.UserPermissions.ALL_PERMISSIONS.getCode();
    private long sessionPermissions = SessionPermissions.ALL_PERMISSIONS.getCode();
    private long sessionLogPermissions = SessionLogPermissions.ALL_PERMISSIONS.getCode();

    @Test
    public void testStringLongLongLong() {
        UserPermissions userPermissions = new UserPermissions(userId, this.userPermissions, sessionPermissions, sessionLogPermissions);
        assertEquals(userId, userPermissions.getUserId());
        assertEquals(this.userPermissions, userPermissions.getUserPermissions());
        assertEquals(sessionPermissions, userPermissions.getSessionPermissions());
        assertEquals(sessionLogPermissions, userPermissions.getSessionLogPermissions());
    }

    @Test
    public void testSetUserPermissions() {
        UserPermissions userPermissions = new UserPermissions(userId, 0L, 0L, 0L);
        assertEquals(0L, userPermissions.getUserPermissions());
        userPermissions.setUserPermissions(this.userPermissions);
        assertEquals(this.userPermissions, userPermissions.getUserPermissions());
    }

    @Test
    public void testSetSessionPermissions() {
        UserPermissions userPermissions = new UserPermissions(userId, 0L, 0L, 0L);
        assertEquals(0L, userPermissions.getSessionPermissions());
        userPermissions.setSessionPermissions(sessionPermissions);
        assertEquals(sessionPermissions, userPermissions.getSessionPermissions());
    }

    @Test
    public void testSetSessionLogPermissions() {
        UserPermissions userPermissions = new UserPermissions(userId, 0L, 0L, 0L);
        assertEquals(0L, userPermissions.getSessionLogPermissions());
        userPermissions.setSessionLogPermissions(sessionLogPermissions);
        assertEquals(sessionLogPermissions, userPermissions.getSessionLogPermissions());
    }
}

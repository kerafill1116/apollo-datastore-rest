import static org.junit.Assert.*;

import apollo.datastore.AdminPermissions;
import apollo.datastore.admin.*;

import org.junit.*;

public class AdminPermissionsTest {

    private String userId = "admin";
    private long usersPermissions = UsersPermissions.ALL_PERMISSIONS.getCode();
    private long sessionsPermissions = SessionsPermissions.ALL_PERMISSIONS.getCode();
    private long sessionLogsPermissions = SessionLogsPermissions.ALL_PERMISSIONS.getCode();

    @Test
    public void testStringLongLongLong() {
        AdminPermissions adminPermissions = new AdminPermissions(userId, usersPermissions, sessionsPermissions, sessionLogsPermissions);
        assertEquals(userId, adminPermissions.getUserId());
        assertEquals(usersPermissions, adminPermissions.getUsersPermissions());
        assertEquals(sessionsPermissions, adminPermissions.getSessionsPermissions());
        assertEquals(sessionLogsPermissions, adminPermissions.getSessionLogsPermissions());
    }

    @Test
    public void testSetUsersPermissions() {
        AdminPermissions adminPermissions = new AdminPermissions(userId, 0L, 0L, 0L);
        assertEquals(0L, adminPermissions.getUsersPermissions());
        adminPermissions.setUsersPermissions(usersPermissions);
        assertEquals(usersPermissions, adminPermissions.getUsersPermissions());
    }

    @Test
    public void testSetSessionsPermissions() {
        AdminPermissions adminPermissions = new AdminPermissions(userId, 0L, 0L, 0L);
        assertEquals(0L, adminPermissions.getSessionsPermissions());
        adminPermissions.setSessionsPermissions(sessionsPermissions);
        assertEquals(sessionsPermissions, adminPermissions.getSessionsPermissions());
    }

    @Test
    public void testSetSessionLogsPermissions() {
        AdminPermissions adminPermissions = new AdminPermissions(userId, 0L, 0L, 0L);
        assertEquals(0L, adminPermissions.getSessionLogsPermissions());
        adminPermissions.setSessionLogsPermissions(sessionLogsPermissions);
        assertEquals(sessionLogsPermissions, adminPermissions.getSessionLogsPermissions());
    }
}

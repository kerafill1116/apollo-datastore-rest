package apollo.datastore;

public class AdminPermissions {

    private String userId;
    private long usersPermissions;
    private long sessionsPermissions;
    private long sessionLogsPermissions;

    public AdminPermissions(String userId, long usersPermissions, long sessionsPermissions, long sessionLogsPermissions) {
        this.userId = userId;
        this.usersPermissions = usersPermissions;
        this.sessionsPermissions = sessionsPermissions;
        this.sessionLogsPermissions = sessionLogsPermissions;
    }

    public String getUserId() {
        return userId;
    }

    public long getUsersPermissions() {
        return usersPermissions;
    }

    public void setUsersPermissions(long usersPermissions) {
        this.usersPermissions = usersPermissions;
    }

    public long getSessionsPermissions() {
        return sessionsPermissions;
    }

    public void setSessionsPermissions(long sessionsPermissions) {
        this.sessionsPermissions = sessionsPermissions;
    }

    public long getSessionLogsPermissions() {
        return sessionLogsPermissions;
    }

    public void setSessionLogsPermissions(long sessionLogsPermissions) {
        this.sessionLogsPermissions = sessionLogsPermissions;
    }
}

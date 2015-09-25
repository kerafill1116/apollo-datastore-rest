package apollo.datastore;

public interface UserFactoryInterface {
    User add(String userId, String password, String emailAddress, String timeZoneId);
    User get(String userId);
    User save(User user);
    User tAddWithPermissions(String userId, String password, String emailAddress, String timeZoneId,
                             final long usersPermissions, final long sessionsPermissions, final long sessionLogsPermissions,
                             final long userPermissions, final long sessionPermissions, final long sessionLogPermissions);
    boolean tnUpdateFailedAttempts(User user);
}

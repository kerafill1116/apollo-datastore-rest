package apollo.datastore;

public interface PermissionsFactoryInterface {
    AdminPermissions addAdminPermissions(String userId, long usersPermissions, long sessionsPermissions, long sessionLogsPermissions);
    UserPermissions addUserPermissions(String userId, long userPermissions, long sessionPermissions, long sessionLogPermissions);
    AdminPermissions getAdminPermissions(String userId);
    UserPermissions getUserPermissions(String userId);
    AdminPermissions saveAdminPermissions(AdminPermissions adminPermissions);
    UserPermissions saveUserPermissions(UserPermissions userPermissions);
}

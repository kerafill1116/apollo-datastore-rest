package apollo.datastore.objectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import apollo.datastore.AdminPermissions;
import apollo.datastore.PermissionsFactoryInterface;
import apollo.datastore.UserPermissions;

import com.googlecode.objectify.Key;

public class PermissionsFactoryImpl implements PermissionsFactoryInterface {

    @Override
    public AdminPermissions addAdminPermissions(String userId, long usersPermissions, long sessionsPermissions, long sessionLogsPermissions) {
        Key<AdminPermissions> adminPermissionsKey = ofy().save().entity(new AdminPermissions(userId, usersPermissions, sessionsPermissions, sessionLogsPermissions)).now();
        return ofy().load().key(adminPermissionsKey).now();
    }

    @Override
    public UserPermissions addUserPermissions(String userId, long userPermissions, long sessionPermissions, long sessionLogPermissions) {
        Key<UserPermissions> userPermissionsKey = ofy().save().entity(new UserPermissions(userId, userPermissions, sessionPermissions, sessionLogPermissions)).now();
        return ofy().load().key(userPermissionsKey).now();
    }

    @Override
    public AdminPermissions getAdminPermissions(String userId) {
        return ofy().load().type(AdminPermissions.class).id(userId).now();
    }

    @Override
    public UserPermissions getUserPermissions(String userId) {
        return ofy().load().type(UserPermissions.class).id(userId).now();
    }

    @Override
    public AdminPermissions saveAdminPermissions(AdminPermissions adminPermissions) {
        Key<AdminPermissions> adminPermissionsKey = ofy().save().entity(adminPermissions).now();
        return ofy().load().key(adminPermissionsKey).now();
    }

    @Override
    public UserPermissions saveUserPermissions(UserPermissions userPermissions) {
        Key<UserPermissions> userPermissionsKey = ofy().save().entity(userPermissions).now();
        return ofy().load().key(userPermissionsKey).now();
    }
}

package apollo.datastore.objectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import apollo.datastore.User;
import apollo.datastore.UserDefaultsImpl;
import apollo.datastore.UserFactoryInterface;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Work;

public class UserFactoryImpl implements UserFactoryInterface {

    @Override
    public User add(String userId, String password, String emailAddress, String timeZoneId) {
        Key<User> userKey = ofy().save().entity(new User(userId, password, emailAddress, timeZoneId, new UserDefaultsImpl())).now();
        return ofy().load().key(userKey).now();
    }

    @Override
    public User get(String userId) {
        return ofy().load().type(User.class).id(userId).now();
    }

    @Override
    public User save(User user) {
        Key<User> userKey = ofy().save().entity(user).now();
        return ofy().load().key(userKey).now();
    }

    @Override
    public User tAddWithPermissions(final String userId, final String password, final String emailAddress, final String timeZoneId,
                                    final long usersPermissions, final long sessionsPermissions, final long sessionLogsPermissions,
                                    final long userPermissions, final long sessionPermissions, final long sessionLogPermissions) {
        return ofy().transact(new Work<User>() {
            public User run() {
                User user = get(userId);
                if(user == null) {
                    user = add(userId, password, emailAddress, timeZoneId);
                    PermissionsFactoryImpl permissionsFactory = new PermissionsFactoryImpl();
                    if(permissionsFactory.getAdminPermissions(userId) == null) {
                        permissionsFactory.addAdminPermissions(userId, usersPermissions, sessionsPermissions, sessionLogsPermissions);
                    }
                    if(permissionsFactory.getUserPermissions(userId) == null) {
                        permissionsFactory.addUserPermissions(userId, userPermissions, sessionPermissions, sessionLogPermissions);
                    }
                }
                return user;
            }
        });
    }
}

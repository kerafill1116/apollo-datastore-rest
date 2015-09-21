package apollo.datastore.objectify;

import apollo.datastore.AdminPermissions;
import apollo.datastore.Session;
import apollo.datastore.SessionLog;
import apollo.datastore.TimeZone;
import apollo.datastore.User;
import apollo.datastore.UserPermissions;

import com.googlecode.objectify.ObjectifyService;

import org.glassfish.jersey.server.ResourceConfig;

public class ObjectifyApplication extends ResourceConfig {

    static {
        ObjectifyService.register(TimeZone.class);
        ObjectifyService.register(User.class);
        ObjectifyService.register(AdminPermissions.class);
        ObjectifyService.register(UserPermissions.class);
        ObjectifyService.register(Session.class);
        ObjectifyService.register(SessionLog.class);
    }

    public ObjectifyApplication() { }
}

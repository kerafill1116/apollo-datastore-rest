package apollo.datastore.utils;

import apollo.datastore.AdminPermissions;
import apollo.datastore.TimeZone;
import apollo.datastore.User;
import apollo.datastore.UserPermissions;

import com.googlecode.objectify.ObjectifyService;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

@ApplicationPath("/")
public class UtilsApplication extends ResourceConfig {

    static {
        ObjectifyService.register(TimeZone.class);
        ObjectifyService.register(User.class);
        ObjectifyService.register(AdminPermissions.class);
        ObjectifyService.register(UserPermissions.class);
    }

    public UtilsApplication() {
        //  property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/classes");
        register(JspMvcFeature.class);
        register(LangRequestFilter.class);
        register(UtilsResource.class);
    }
}

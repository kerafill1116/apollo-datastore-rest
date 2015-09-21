package apollo.datastore.utils;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

// unused class, using classnames for jersey registration, keeping it for reference purposes
public class UtilsApplication extends ResourceConfig {

    public UtilsApplication() {
        // property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/classes");
        register(JspMvcFeature.class);
        register(JacksonFeature.class);
        register(LangFilter.class);
        register(UtilsResource.class);
    }
}

package apollo.datastore.utils;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

public class UtilsApplication extends ResourceConfig {

    public UtilsApplication() {
        // property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/classes");
        register(JspMvcFeature.class);
        register(JacksonFeature.class);
        register(LangFilter.class);
        register(UtilsResource.class);
        register(FormVariableExceptionMapper.class);
        register(SessionHandlingExceptionMapper.class);
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
    }
}

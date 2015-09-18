package apollo.datastore.utils;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.Map;

public class LangRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        // exclude /tasks/

        String path = containerRequestContext.getUriInfo().getPath();
        String absolutePath = containerRequestContext.getUriInfo().getAbsolutePath().getPath();

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Entity e = new Entity("path");
        e.setProperty("path", path);
        e.setProperty("absolutePath", absolutePath);
        datastore.put(e);

        if(containerRequestContext.getMethod().compareToIgnoreCase("get") == 0) {
            MultivaluedMap<String, String> queryParams = containerRequestContext.getUriInfo().getQueryParameters();
            queryParams.getFirst(apollo.datastore.utils.Cookie.LANG.getName());
        }
        Map<String, Cookie> cookies = containerRequestContext.getCookies();
    }
}

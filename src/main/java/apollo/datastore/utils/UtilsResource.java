package apollo.datastore.utils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

@Path("/utils")
public class UtilsResource {

    @GET
    @Path("sign-in")
    @Produces(MediaType.TEXT_HTML)
    public Viewable signIn() {
        return new Viewable("/WEB-INF/jsp/pub/sign-in.jsp");
    }
}

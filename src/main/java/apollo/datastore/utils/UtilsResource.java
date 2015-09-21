package apollo.datastore.utils;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;

import java.util.Map;

@Path("/utils")
public class UtilsResource {

    @GET
    @Path("sign-in")
    @Produces(MediaType.TEXT_HTML)
    public Viewable signIn() {
        return new Viewable("/WEB-INF/jsp/pub/sign-in.jsp");
    }

    @POST
    @Path("sign-in")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signIn(Map<String, String> data) {
        StringBuilder jsonData = new StringBuilder();
        for(Map.Entry<String, String> entry : data.entrySet()) {
            jsonData.append(entry.getKey() + " : " + entry.getValue() + ", ");
        }
        return Response.ok(jsonData.toString()).build();
    }
}

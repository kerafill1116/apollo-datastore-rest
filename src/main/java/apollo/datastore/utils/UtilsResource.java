package apollo.datastore.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;

@Path("/utils")
public class UtilsResource {

    @Path("init-data")
    @GET
    public Viewable initData(@Context HttpServletRequest request, @Context HttpServletResponse response)
            throws Exception {
        return new Viewable("/init-data.jsp", null);
    }

    @Path("init-data2")
    @GET
    public String initData2(@Context HttpServletRequest request, @Context HttpServletResponse response)
            throws Exception {
        return "Hello init-data2";
    }

    @Path("init-data3")
    @GET
    @Produces("text/html")
    public Response index() {
        return Response.ok(new Viewable("/init-data.jsp", null)).build();
    }
}

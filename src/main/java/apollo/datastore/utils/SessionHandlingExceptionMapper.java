package apollo.datastore.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SessionHandlingExceptionMapper implements ExceptionMapper<SessionHandlingException> {

    @Context
    HttpServletRequest httpServletRequest;

    @Override
    public Response toResponse(SessionHandlingException e) {
        String json = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(new ErrorJson(e.getError(), (String)httpServletRequest.getAttribute(RequestPropertyVariable.LANG.getName())));
        }
        catch(JsonProcessingException e1) {
            e1.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(json).build();
    }
}
